package com.shopping.anping.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.shopping.anping.dao.CommentDao;
import com.shopping.guoguo.dao.impl.GoodsDao4MySqlImpl;
import com.shopping.guoguo.pojo.Comment;
import com.shopping.guoguo.pojo.User;
import com.shopping.util.DBUtil;

public class CommentDao4MySqlImpl implements CommentDao {

	public void add(Comment comment) {
	   String sql  = "insert  into t_comment  values(null,?,?,?)";
		Connection conn = null;
	    PreparedStatement   pstmt = null;
	    conn = (Connection) DBUtil.getConn();
	    pstmt  = (PreparedStatement) DBUtil.getPstmt(conn, sql);
  
	    try {
	        pstmt.setInt(1, comment.getGoods().getGid());
			pstmt.setInt(2, comment.getUser().getUid());
			pstmt.setString(3, comment.getContent());
		  pstmt.executeUpdate(); 
	    } catch (SQLException e) {
		 	e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, null);
		}
	}

	public void deleteById(int id) {
	  
	}

	public Comment findCommentById(int id) {
		Comment comment  = new Comment();
		String sql  = "select * from t_comment where id=?";
		Connection conn  = null;
		PreparedStatement pstmt = null;
		ResultSet   rs  = null;
		conn = (Connection) DBUtil.getConn();
		pstmt= (PreparedStatement) DBUtil.getPstmt(conn, sql);
		try {
			pstmt.setInt(1, id);
			rs = DBUtil.getRs(pstmt);
			if(rs.next()){
				rsToComment(rs,comment);
			}
		} catch (SQLException e) {
			 e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, rs);
		}
		
	 	return comment;
	}

	  
	public List<Comment> findCommendByPage(int firstIndex, int maxResult,int gid) {
		List<Comment>  commneds= new ArrayList<Comment>();
		
		String sql  = "select * from t_comment  where gid  = ?  limit ? ,? ";
		Connection conn  = null;
		PreparedStatement pstmt = null;
		ResultSet   rs  = null;
		conn = (Connection) DBUtil.getConn();
		pstmt= (PreparedStatement) DBUtil.getPstmt(conn, sql);
		try {
			pstmt.setInt(1, gid);
			pstmt.setInt(2, firstIndex);
			pstmt.setInt(3, maxResult);
			rs = DBUtil.getRs(pstmt);
			while(rs.next()){
				Comment comment  = new Comment();
			 	rsToComment(rs,comment);
				commneds.add(comment);
			}
		} catch (SQLException e) {
			 e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, rs);
		}
		
	 	return commneds;
	}
	
	private void  rsToComment(ResultSet rs ,Comment comment) throws SQLException{
		comment.setId(rs.getInt(1));
		comment.setGoods(new GoodsDao4MySqlImpl().getGoodByGid(rs.getInt(2)));
		comment.setUser(new UserDao4MySqlImpl().findUserById(rs.getInt(3)));
		comment.setContent(rs.getString(4));
	 	}

	public List<Comment> findcommentByGid(int gid) {
		List<Comment> comments = new ArrayList<Comment>();
		Connection  conn   =  null;
		PreparedStatement   pstmt  = null;
		ResultSet  rs  = null;
		conn   = (Connection) DBUtil.getConn();
		pstmt = (PreparedStatement) DBUtil.getPstmt(conn, "select * from t_comment where gid=?");
		try {
			pstmt.setInt(1, gid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Comment comment = new Comment();
				comment.setId(rs.getInt(1));
				comment.setGoods(new GoodsDao4MySqlImpl().getGoodByGid(rs.getInt(2)));
				comment.setUser(new UserDao4MySqlImpl().findUserById(rs.getInt(3)));
				comment.setContent(rs.getString(4));
				comments.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, rs);
		}
		
		
		
		return comments;
	}

}
