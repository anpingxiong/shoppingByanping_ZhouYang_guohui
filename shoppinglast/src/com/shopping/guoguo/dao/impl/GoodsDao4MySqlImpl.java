package com.shopping.guoguo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shopping.guoguo.dao.GoodsDao;
import com.shopping.guoguo.pojo.Goods;
import com.shopping.guoguo.pojo.Sort;
import com.shopping.util.DBUtil;


import java.sql.*;
public class GoodsDao4MySqlImpl implements GoodsDao {

	public List<Goods> getAllGoods() {
		//��ʾ���е���Ʒ
		List<Goods> goods = new ArrayList<Goods>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			
			conn = DBUtil.getConn();
			pstmt = DBUtil.getPstmt(conn, "select * from t_goods ");
			rs = DBUtil.getRs(pstmt);

			while(rs.next()){
				Goods good = new Goods();
				
				good.setGid(rs.getInt(1));
				good.setName(rs.getString(2));
				good.setMarketprice(rs.getDouble(3));
				good.setNowprice(rs.getDouble(4));
				good.setDiscount(rs.getDouble(4)/rs.getDouble(3)*10);
				good.setBargain(rs.getInt(6));
				good.setExp(rs.getString(7));
				good.setSort(new SortDao4MySqlImpl().getSortBySid(rs.getInt(8)));//ͨ��SortDao�е�getSortBySid�ķ�������һ��sid��ȥ
				good.setPdate(rs.getTimestamp(9));
				good.setGoodsnum(rs.getInt(10));
				good.setOrdernum(rs.getInt(11));
				
				goods.add(good);
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, rs);
		}
	return goods;
	}

	public Goods getGoodByGid(int gid) {
		//ͨ����Ʒ��id��ø���Ʒ��������Ϣ
		Goods good = new Goods();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
		
			conn = DBUtil.getConn();
			pstmt = DBUtil.getPstmt(conn, "select * from t_goods where gid=? ");
			pstmt.setInt(1, gid);
			pstmt.executeQuery();
			rs = DBUtil.getRs(pstmt);

			while(rs.next()){
				
				good.setGid(rs.getInt(1));
				good.setName(rs.getString(2));
				good.setMarketprice(rs.getDouble(3));
				good.setNowprice(rs.getDouble(4));
				good.setDiscount(rs.getDouble(4)/rs.getDouble(3)*10);
				good.setBargain(rs.getInt(6));
				good.setExp(rs.getString(7));
				good.setSort( new SortDao4MySqlImpl().getSortBySid(rs.getInt(8)));
				//ͨ��SortDao�е�getSortBySid�ķ�������һ��sid��ȥ
				good.setPdate(rs.getTimestamp(9));
				good.setGoodsnum(rs.getInt(10));
				good.setOrdernum(rs.getInt(11));
				
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	return good;
	}
	
public int alterGoods(Goods good){
	
	int flag = 0;
	Connection conn = null;
	PreparedStatement pstmt = null;
	try {
		conn = DBUtil.getConn();
		//注意 这里的商品数量和订购数量不用在数据库中改 
		pstmt = DBUtil.getPstmt( conn,
	    "update t_goods set name=?,marketprice=?,nowprice=?,discount=?,bargain=?,exp=?,sid=?,pdate=now() where gid=?");
		pstmt.setString(1,good.getName());
		pstmt.setDouble(2, good.getMarketprice());
		pstmt.setDouble(3, good.getNowprice());
		pstmt.setDouble(4,good.getDiscount());
		pstmt.setInt(5,good.getBargain());
		pstmt.setString(6, good.getExp());
		pstmt.setInt(7, good.getSort().getSid());//暂时 我们先不修改类型
		pstmt.setInt(8, good.getGid());
		pstmt.executeUpdate();
		flag = 1;
	
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("修改失败！");
		}finally{
			DBUtil.close(conn, pstmt, null);
		}
	return flag;
}
/*   gid                  int not null auto_increment,
   name                 varchar(20),
   marketprice          double,
   nowprice             double,
   discount             double,
   bargain              int,
   exp                  text,
   sid                  int,
   pdate                date,
   goodsnum             int,
   ordernum             int,
 *  */
public void insertGoods(Goods good) {
	//�����Ʒ
	Connection conn = null;
	PreparedStatement pstmt = null;
	try {
		
	     conn = (Connection) DBUtil.getConn();
	     pstmt = DBUtil.getPstmt(conn, "insert into t_goods values(null,?,?,?,?,?,?,?,now(),?,?)");
	     pstmt.setString(1, good.getName());
	     pstmt.setDouble(2, good.getMarketprice());
	     pstmt.setDouble(3, good.getNowprice());
	     pstmt.setDouble(4, good.getDiscount());
	     pstmt.setInt(5, good.getBargain());
	     pstmt.setString(6, good.getExp());
	     pstmt.setInt(7,good.getSort().getSid());//����Ҫͨ��sid���sort 
	     pstmt.setInt(8,good.getGoodsnum());
	     pstmt.setInt(9,good.getOrdernum());
	     pstmt.executeUpdate();
	     } catch (SQLException e) {
		e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, null);
		}
	
}

public int deleteGoods(int gid) {
	//�����Ʒidɾ����Ʒ
	Connection conn = null;
	PreparedStatement pstmt = null;
	try{
		conn = DBUtil.getConn();
		pstmt = DBUtil.getPstmt(conn, "delete from t_goods where gid=?");
		pstmt.setInt(1, gid);
		pstmt.executeUpdate();
		return 1;
		
	}catch(SQLException e){
		e.printStackTrace();
		return 0;
	}finally{
		DBUtil.close(conn, pstmt, null);
	}
	
}

public Goods getGoodByName(String name) {
	Goods good = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try{
	
		conn = DBUtil.getConn();
		pstmt = DBUtil.getPstmt(conn, "select * from t_goods where name=? ");
		pstmt.setString(1, name);
		pstmt.executeQuery();
		rs = DBUtil.getRs(pstmt);

		while(rs.next()){
			good= new Goods();
			good.setGid(rs.getInt(1));
			good.setName(rs.getString(2));
			good.setMarketprice(rs.getDouble(3));
			good.setNowprice(rs.getDouble(4));
			good.setDiscount(rs.getDouble(4)/rs.getDouble(3)*10);
			good.setBargain(rs.getInt(6));
			good.setExp(rs.getString(7));
			good.setSort( new SortDao4MySqlImpl().getSortBySid(rs.getInt(8)));
		
			good.setPdate(rs.getTimestamp(9));
			good.setGoodsnum(rs.getInt(10));
			good.setOrdernum(rs.getInt(11));
			
		}
		
		
	}catch(SQLException e){
		e.printStackTrace();
	}
return good;
}

public List<Goods> getBargainGoods() {
	
	List<Goods> goods = new ArrayList<Goods>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try{
		
		conn = DBUtil.getConn();
		pstmt = DBUtil.getPstmt(conn, "select * from t_goods where bargain=1");
		
		rs = DBUtil.getRs(pstmt);

		while(rs.next()){
			Goods good = new Goods();
			
			good.setGid(rs.getInt(1));
			good.setName(rs.getString(2));
			good.setMarketprice(rs.getDouble(3));
			good.setNowprice(rs.getDouble(4));
			good.setDiscount(rs.getDouble(4)/rs.getDouble(3)*10);
			good.setBargain(rs.getInt(6));
			good.setExp(rs.getString(7));
			good.setSort( new SortDao4MySqlImpl().getSortBySid(rs.getInt(8)));//ͨ��SortDao�е�getSortBySid�ķ�������һ��sid��ȥ
			good.setPdate(rs.getTimestamp(9));
			good.setGoodsnum(rs.getInt(10));
			good.setOrdernum(rs.getInt(11));
			
			goods.add(good);}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, rs);
		}
	return goods;
}

public List<Goods> getNewGoods(){
	List<Goods> goods = new ArrayList<Goods>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try{
		
		conn = DBUtil.getConn();
		pstmt = DBUtil.getPstmt(conn, "select * from t_goods order by pdate desc limit 0,4");//显示四条信息
		rs = DBUtil.getRs(pstmt);

		while(rs.next()){
			Goods good = new Goods();
			
			good.setGid(rs.getInt(1));
			good.setName(rs.getString(2));
			good.setMarketprice(rs.getDouble(3));
			good.setNowprice(rs.getDouble(4));
			good.setDiscount(rs.getDouble(4)/rs.getDouble(3)*10);
			good.setBargain(rs.getInt(6));
			good.setExp(rs.getString(7));
			good.setSort( new SortDao4MySqlImpl().getSortBySid(rs.getInt(8)));//ͨ��SortDao�е�getSortBySid�ķ�������һ��sid��ȥ
			good.setPdate(rs.getTimestamp(9));
			good.setGoodsnum(rs.getInt(10));
			good.setOrdernum(rs.getInt(11));
			
			goods.add(good);}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, rs);
		}
	return goods;
	
}

public List<Goods> getThisPageGoods() {
	
	return null;
}
//这个方法用来更新商品的数量（根据商品的名称），传一个要增加后的商品数量和一个商品名称
public int updateGoodsnum(int goodsNum,String goodsName) {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	conn = DBUtil.getConn();
	pstmt = DBUtil.getPstmt(conn, "update t_goods set goodsnum =? where name=?");
	try {
		pstmt.setInt(1, goodsNum);
		pstmt.setString(2, goodsName);
		pstmt.executeUpdate();
		return 1;
	} catch (SQLException e) {
		e.printStackTrace();
		return 0;
		
	}finally{
		DBUtil.close(conn, pstmt, null);
	}
	
	
}

public List<Goods> getGoodsSale() {//取出商品按销量排序
	List<Goods> goods = new ArrayList<Goods>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try{
		
		conn = DBUtil.getConn();
		pstmt = DBUtil.getPstmt(conn, "select * from t_goods order by ordernum desc ");//降序
		rs = DBUtil.getRs(pstmt);

		while(rs.next()){
			Goods good = new Goods();
			
			good.setGid(rs.getInt(1));
			good.setName(rs.getString(2));
			good.setMarketprice(rs.getDouble(3));
			good.setNowprice(rs.getDouble(4));
			good.setDiscount(rs.getDouble(4)/rs.getDouble(3)*10);
			good.setBargain(rs.getInt(6));
			good.setExp(rs.getString(7));
			good.setSort( new SortDao4MySqlImpl().getSortBySid(rs.getInt(8)));//ͨ��SortDao�е�getSortBySid�ķ�������һ��sid��ȥ
			good.setPdate(rs.getTimestamp(9));
			good.setGoodsnum(rs.getInt(10));
			good.setOrdernum(rs.getInt(11));
			
			goods.add(good);}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, rs);
		}
	return goods;
}

public List<Goods> getGoodsByPage(int firstIndex, int MaxResult,int tag) {
	System.out.println(firstIndex+"==============="+MaxResult);
	List<Goods> goods = new ArrayList<Goods>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	switch(tag){
	case 0:{sql = "select * from(select * from t_goods order by gid desc) u limit ?,? ";} break;
	case 1:{sql="select * from(select * from t_goods where bargain=1 order by pdate desc) u limit ?,?";} break;//特价
	case 2:{sql="select * from(select * from t_goods where (year(now())=year(pdate)) and (month(now())=month(pdate)) and (day(now())-day(pdate))<2) u limit ?,? ";} break;//新品上架
	case 3:{sql="select * from(select * from t_goods order by goodsnum desc) u limit ?,?"; }//销售排行
	
	}
	try{
		
		conn = DBUtil.getConn();
		pstmt = DBUtil.getPstmt(conn,sql );
		pstmt.setInt(1,firstIndex);
		pstmt.setInt(2, MaxResult);
		rs = DBUtil.getRs(pstmt);

		while(rs.next()){
			Goods good = new Goods();
			
			good.setGid(rs.getInt(1));
			good.setName(rs.getString(2));
			good.setMarketprice(rs.getDouble(3));
			good.setNowprice(rs.getDouble(4));
			good.setDiscount(rs.getDouble(4)/rs.getDouble(3)*10);
			good.setBargain(rs.getInt(6));
			good.setExp(rs.getString(7));
			good.setSort(new SortDao4MySqlImpl().getSortBySid(rs.getInt(8)));//ͨ��SortDao�е�getSortBySid�ķ�������һ��sid��ȥ
			good.setPdate(rs.getTimestamp(9));
			good.setGoodsnum(rs.getInt(10));
			good.setOrdernum(rs.getInt(11));
			
			goods.add(good);
		}
		
		
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		DBUtil.close(conn, pstmt, rs);
	}
return goods;
}

public int getGoodsCountPage(int tag) {
	int c = 0;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "select count(*) from t_goods ";
	switch(tag){
	case 1:{sql="select count(*) from t_goods where bargain=1";} break;//特价
	case 2:{sql="select count(*) from t_goods where (year(now())=year(pdate)) and (month(now())=month(pdate)) and (day(now())-day(pdate))<2";} break;//新品上架
	case 3:{sql="select count(*) from t_goods"; }break;//销售排行
	
	}
	try{
		
		conn = DBUtil.getConn();
		pstmt = DBUtil.getPstmt(conn,sql );
		System.out.println(sql);
		rs = pstmt.executeQuery();
		if(rs.next()){
			c =  rs.getInt(1);
		}
}catch(SQLException e){
		e.printStackTrace();
	}finally{
		DBUtil.close(conn, pstmt, rs);
	}
	return c;
}

public void updateNumOrdered(int gid,int num,boolean tag) {
	//还要传递一个tag 当tag等于1 证明是添加订单，tag=0证明是取消订单
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = null;
	try{
		conn = DBUtil.getConn();
		sql = "update t_goods set goodsnum=?,ordernum=? where gid=?";
		pstmt = DBUtil.getPstmt(conn,sql );
		if(tag){
		pstmt.setInt(1, new GoodsDao4MySqlImpl().getGoodByGid(gid).getGoodsnum()-num);
		pstmt.setInt(2, new GoodsDao4MySqlImpl().getGoodByGid(gid).getOrdernum()+num);
		pstmt.setInt(3,gid);
		pstmt.executeUpdate();}
		else{
			pstmt.setInt(1, new GoodsDao4MySqlImpl().getGoodByGid(gid).getGoodsnum()+num);
			pstmt.setInt(2, new GoodsDao4MySqlImpl().getGoodByGid(gid).getOrdernum()-num);
			pstmt.setInt(3,gid);
			pstmt.executeUpdate();	
		}
	}catch(SQLException e){
		e.printStackTrace();
		System.out.println("已经发货了");
	}finally{
		DBUtil.close(conn, pstmt, null);
	}
	
}

public List<Goods> getGoodsByPPerentOrName(int id, String name) {
   List<Goods>  goods  = new ArrayList<Goods>() ;
	String sql  = " select   * from  t_goods where sid in (select sid   from t_sort where  pid =?) where name = ?  order by gid desc ";
	Connection conn = null;
	PreparedStatement  pstmt  = null;
	ResultSet  rs  = null;
	conn= DBUtil.getConn();
	pstmt= DBUtil.getPstmt(conn, sql);
	try {
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		rs=DBUtil.getRs(pstmt);
	    while(rs.next()){
			Goods   good  = new  Goods();
			good.setGid(rs.getInt(1));
			good.setName(rs.getString(2));
			good.setMarketprice(rs.getDouble(3));
			good.setNowprice(rs.getDouble(4));
			good.setDiscount(rs.getDouble(4)/rs.getDouble(3)*10);
			good.setBargain(rs.getInt(6));
			good.setExp(rs.getString(7));
			good.setSort(new SortDao4MySqlImpl().getSortBySid(rs.getInt(8)));//ͨ��SortDao�е�getSortBySid�ķ�������һ��sid��ȥ
			good.setPdate(rs.getTimestamp(9));
			good.setGoodsnum(rs.getInt(10));
			good.setOrdernum(rs.getInt(11));
			goods.add(good);
		}
	} catch (SQLException e) {
	 	e.printStackTrace();
	}finally{
		DBUtil.close(conn, pstmt, rs);
	}
	
	return goods;
}
}






