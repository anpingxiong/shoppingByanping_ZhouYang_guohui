package com.shopping.guoguo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.guoguo.dao.SortDao;
import com.shopping.guoguo.pojo.Goods;
import com.shopping.guoguo.pojo.Sort;
import com.shopping.util.DBUtil;
 

public class SortDao4MySqlImpl implements SortDao {
//通过大类的id查出 一个大类 通过小类的id查出一个小类
	public Sort getSortBySid(int sid) {
		//ͨ��sid���������ֵ
		Sort sort = new Sort();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getPstmt(conn, "select * from t_sort where sid=?");
			pstmt.setInt(1, sid);
			pstmt.executeQuery();
			rs = DBUtil.getRs(pstmt);
			while(rs.next()){
				sort.setSid(rs.getInt(1));
				sort.setName(rs.getString(2));
				sort.setExp(rs.getString(3));
				sort.setPid(null);
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, rs);
		}
		return sort;
	}

	public int insertSort(Sort sort,int pid) {
		int  result=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getPstmt(conn, "insert into t_sort values(null,?,?,?)");
			pstmt.setString(1, sort.getName());
			pstmt.setString(2, sort.getExp());
			pstmt.setInt(3, pid);
			
			pstmt.executeUpdate();
			result=1;
		}catch(SQLException e){
			e.printStackTrace();
		 
			
		}finally{
			DBUtil.close(conn, pstmt, null);
		}
		return result;
	
	 }
	public void deleteSortBySid(int sid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getPstmt(conn, "delete from t_sort where sid=?");
			pstmt.setInt(1,sid);
			pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			DBUtil.close(conn, pstmt, null);
		}
		
	
		
	}

	public void alterSortDetail(Sort sort) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getPstmt(conn, "update t_sort set name=?,exp=? where sid=?");
			pstmt.setString(1, sort.getName());
			pstmt.setString(2, sort.getExp());
			pstmt.setInt(3, sort.getSid());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			DBUtil.close(conn, pstmt, null);
		}
	
		
	}
	/*sid                  int not null auto_increment,
   name                 varchar(20),
   exp                  text,
   pid                  int,*/

	
//这个方法可以同时查出大类相关的小类（通过大类的id查出小类）
//当pid等于0时 就是查出所有的大类 不等于0时查出所有的小类
	//这个方法是熊安平写的！！！
	public List<Sort> findSortsByPid(int pid) {
		List<Sort> sorts   =  new ArrayList<Sort>();
		String sql   ="select * from t_sort where pid =?";
		Connection conn = null;
		PreparedStatement   pstmt  =  null;
		ResultSet  rs    = null;
		conn   = DBUtil.getConn();
		
		pstmt   = DBUtil.getPstmt(conn, sql);
		 
		try {
			pstmt.setInt(1, pid);
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		rs= DBUtil.getRs(pstmt);
		try {
			while(rs.next()){
				Sort  sort  = new Sort();
				sort.setSid(rs.getInt(1));
				sort.setName(rs.getString(2));
				sort.setExp(rs.getString(3));
				sort.setPid(new SortDao4MySqlImpl().getSortBySid(rs.getInt(4)));
			   sorts.add(sort);
			}
		} catch (SQLException e) {
			 e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, rs);
		}
		
		return sorts;
	}
}
	/*sid                  int not null auto_increment,
	   name                 varchar(20),
	   exp                  text,
	   pid                  int,*/
	//这个貌似用不着
/*	public List<Sort> getAllSort() {
		List<Sort> sorts = new ArrayList<Sort>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
try{
			
			conn = DBUtil.getConn();
			pstmt = DBUtil.getPstmt(conn, "select * from t_goods ");
			rs = DBUtil.getRs(pstmt);

			while(rs.next()){
				Sort sort = new Sort();
				
				sort.setSid(rs.getInt(1));
				sort.setName(rs.getString(2));
				sort.setExp(rs.getString(3));
				sort.setPid(new SortDao4MySqlImpl().getSortBySid(rs.getInt(4)));
				
				
				sorts.add(sort);
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, rs);
		}
 		return sorts;
	}

	
	
	
}*/

