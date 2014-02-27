package com.shopping.anping.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.shopping.anping.dao.FavortieDao;

import com.shopping.guoguo.dao.impl.GoodsDao4MySqlImpl;
import com.shopping.guoguo.pojo.Favortie;
import com.shopping.util.DBUtil;

public class FavoriteDao4MySqlImpl implements FavortieDao {
 public List<Favortie> findFavortiesByUid(int uid) {
		List<Favortie> favorties  = new ArrayList<Favortie>();
		String sql = "select * from t_favorite where uid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		conn =(Connection) DBUtil.getConn();
		pstmt   = (PreparedStatement)DBUtil.getPstmt(conn, sql);
		try {
			pstmt.setInt(1, uid);
			rs  = DBUtil.getRs(pstmt);
			while(rs.next()){
				Favortie   favortie = new Favortie();
				favortie.setId(rs.getInt(1));
				favortie.setUser(new UserDao4MySqlImpl().findUserById(rs.getInt(2)));
				favortie.setGoods(new GoodsDao4MySqlImpl().getGoodByGid(rs.getInt(3)));
				favorties.add(favortie);
			}
		} catch (SQLException e) {
		   e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, rs);
		}
		 return favorties;
	}

	public void add(Favortie favorite) {
		  String sql  = "insert into t_favorite values(null,?,?)"; 
		  Connection  conn =  null;
		  PreparedStatement prstmt = null;
		  conn =(Connection) DBUtil.getConn();
		  prstmt = (PreparedStatement) DBUtil.getPstmt(conn, sql);
		 
		  try {
			  prstmt.setInt(1, favorite.getUser().getUid());
		 	  prstmt.setInt(2, favorite.getGoods().getGid());
		 	  prstmt.executeUpdate();
		} catch (SQLException e) {
			 e.printStackTrace();
		}finally{
			DBUtil.close(conn, prstmt, null);
		}
	}

	public void deleteFavortiesById(int id) {
		String  sql  ="delete from  t_favorite where  id =?";
	 Connection  conn  = null;
	 PreparedStatement   pstmt  =  null;
	 conn   = (Connection) DBUtil.getConn();
	 pstmt   = (PreparedStatement) DBUtil.getPstmt(conn, sql);
	 try {
		pstmt.setInt(1,  id);
		pstmt.executeUpdate();
	 } catch (SQLException e) {
		 e.printStackTrace();
	}finally{
		DBUtil.close(conn, pstmt, null);
	}
	 
	}

	public Favortie findFavoritesByFavorites(Favortie favorite) {
		Favortie   favortie = null;
		String sql = "select * from t_favorite where uid = ?  and  gid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		conn =(Connection) DBUtil.getConn();
		pstmt   = (PreparedStatement)DBUtil.getPstmt(conn, sql);
		try {
			pstmt.setInt(1, favorite.getUser().getUid());
			pstmt.setInt(2, favorite.getGoods().getGid());
			rs  = DBUtil.getRs(pstmt);
			if(rs.next()){
				favortie= new Favortie();
				favortie.setId(rs.getInt(1));
				favortie.setUser(null);
				favortie.setGoods(null);
		 
			}
		} catch (SQLException e) {
		   e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, rs);
		}
		
		 return favortie;
		
	}

}
