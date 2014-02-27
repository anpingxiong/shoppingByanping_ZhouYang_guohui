package com.shopping.anping.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.shopping.anping.dao.UserDao;

import com.shopping.guoguo.pojo.User;
import com.shopping.util.DBUtil;

public class UserDao4MySqlImpl implements UserDao {

	public User findUserById(int id) {
		User user = new User();
		String sql = "select * from t_user where uid =?";
		Connection conn = null;
		PreparedStatement prstmt = null;
		ResultSet rs = null;
		conn = (Connection) DBUtil.getConn();
		prstmt = (PreparedStatement) DBUtil.getPstmt(conn, sql);
		try {
			prstmt.setInt(1, id);
			rs = prstmt.executeQuery();
			if (rs.next()) {
				setUserProptiy(rs, user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, prstmt, rs);
		}
		return user;
	}

	private void setUserProptiy(ResultSet rs, User user) {

		try {
			user.setUid(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setEmail(rs.getString(4));
			user.setName(rs.getString(5));
			user.setAddress(rs.getString(6));
			user.setProvince(rs.getString(7));
			user.setCity(rs.getString(8));
			user.setUrban(rs.getString(9));
			user.setPost(rs.getString(10));
			user.setTel(rs.getString(11));
			user.setExpense(rs.getDouble(12));
			user.setLevel(rs.getInt(13));
			user.setState(rs.getInt(14));
			user.setPdate(rs.getDate(15));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int add(User user) {
		int result = -1;
		String sql = "insert into t_user values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,now())";
		Connection conn = null;
		PreparedStatement prtmt = null;
		conn = (Connection) DBUtil.getConn();
		prtmt = (PreparedStatement) DBUtil.getPstmt(conn, sql);
		try {
			prtmt.setString(1, user.getUsername());
			prtmt.setString(2, user.getPassword());
			prtmt.setString(3, user.getEmail());
			prtmt.setString(4, user.getName());
			prtmt.setString(5, user.getAddress());
			prtmt.setString(6, user.getProvince());
			prtmt.setString(7, user.getCity());
			prtmt.setString(8, user.getUrban());
			prtmt.setString(9, user.getPost());
			prtmt.setString(10, user.getTel());
			prtmt.setDouble(11, user.getExpense());
			prtmt.setInt(12, user.getLevel());
			prtmt.setInt(13, user.getState());
			result = prtmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, prtmt, null);
		}
		return result;
	}

	public void deleteUserById(int id) {
	 
		String sql = "delete from t_user where uid = ?";
		Connection conn = null;
		PreparedStatement prstmt = null;
		conn = (Connection) DBUtil.getConn();
		prstmt = (PreparedStatement) DBUtil.getPstmt(conn, sql);
		try {
			prstmt.setInt(1, id);
			prstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, prstmt, null);
		}
	}

	public void updateUserById(User user,String username) {
//		this.deleteUserByUsername(username);
//		this.add(user);
		String sql   = "update  t_user set username=? ,password=? ,email=? ,name=?,address=?,province=?,city=?,urban=?,post=?,tel=?,expense=?,level=?,state=?  where  username=?";
		Connection  conn  =  null;
		PreparedStatement   pstmt   = null;
		conn  = (Connection) DBUtil.getConn();
		pstmt  = (PreparedStatement) DBUtil.getPstmt(conn, sql);
		try {
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2,user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getName());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getProvince());
			pstmt.setString(7, user.getCity());
			pstmt.setString(8, user.getUrban());
			pstmt.setString(9,user.getPost());
			pstmt.setString(10,user.getTel());
			pstmt.setDouble(11,user.getExpense());
			pstmt.setInt(12,user.getLevel());
			pstmt.setInt(13, user.getState());
			pstmt.setString(14, username);
			pstmt.executeUpdate();
		} catch (SQLException e) {
		e.printStackTrace();
		}finally {
			DBUtil.close(conn, pstmt, null);
		}
		
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		String sql = "select * from t_user ";
		Connection conn = null;
		PreparedStatement prstmt = null;
		ResultSet rs = null;
		conn = (Connection) DBUtil.getConn();
		prstmt = (PreparedStatement) DBUtil.getPstmt(conn, sql);
		try {

			rs = prstmt.executeQuery();
			if (rs.next()) {
				User user = new User();
				setUserProptiy(rs, user);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, prstmt, rs);
		}
		return users;
	}

	public User findUserByName(String username) {

		User user = null;
		String sql = "select * from t_user where username =?";
		Connection conn = null;
		PreparedStatement prstmt = null;
		ResultSet rs = null;
		conn = (Connection) DBUtil.getConn();
		prstmt = (PreparedStatement) DBUtil.getPstmt(conn, sql);
		try {
			prstmt.setString(1, username);
			rs = prstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				setUserProptiy(rs, user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, prstmt, rs);
		}
		return user;
	}

	public List<User> findUserByPage(int firstIndex, int MaxResult) {
		List<User> users = new ArrayList<User>();
		String sql = "select  * from  (select * from t_user  order by uid  desc) u  limit ?,?";
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = (Connection) DBUtil.getConn();
		pstmt = (PreparedStatement) DBUtil.getPstmt(conn, sql);
		try {
			pstmt.setInt(1, firstIndex);
			pstmt.setInt(2, MaxResult);
			rs = DBUtil.getRs(pstmt);
			while (rs.next()) {
				User user = new User();
				setUserProptiy(rs, user);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return users;
	}

	public int getUserTotal() {
		int count = -1;
		String sql = "select count(*) from t_user";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = (Connection) DBUtil.getConn();
		pstmt = (PreparedStatement) DBUtil.getPstmt(conn, sql);
		try {
			rs = DBUtil.getRs(pstmt);
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int modifyUserState(int uid, int state) {
		int result = -1;
		String sql = "update t_user set state= ? where  uid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = (Connection) DBUtil.getConn();
		pstmt = (PreparedStatement) DBUtil.getPstmt(conn, sql);

		try {
			pstmt.setInt(1, state);
			pstmt.setInt(2, uid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, null);
		}
		return result;
	}

	public void deleteUserByUsername(String username) {
	
		String sql = "delete from t_user where username= ?";
		Connection conn = null;
		PreparedStatement prstmt = null;
		conn = (Connection) DBUtil.getConn();
		prstmt = (PreparedStatement) DBUtil.getPstmt(conn, sql);
		try {
			prstmt.setString(1, username);
			prstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, prstmt, null);
		}
		
	}

	public User selectUserByOrder(String id, String username) {
		User user   = new User();
	 
		String sql ="select * from t_user where   username=?";    
	     int uid = 0;
		  if(username==null){
			     uid  = Integer.parseInt(id);
		    	 sql ="select * from t_user where uid=? ";
		     }
		else 	if(username !=null  && id  != null ){
			   uid  = Integer.parseInt(id);
			sql="select * from  t_user where uid  =?  and   username =?";
		}
		Connection conn   = null;
		PreparedStatement   pstmt  = null;
		ResultSet  rs   = null;
		conn = (Connection) DBUtil.getConn();
		
		pstmt= (PreparedStatement) DBUtil.getPstmt(conn, sql);
		try {
			if(username==null){
				pstmt.setInt(1, uid);
			}else if(id==null){
				pstmt.setString(1, username);
			}else{
				pstmt.setInt(1, uid);
				pstmt.setString(2, username);
			}
			rs  =DBUtil.getRs(pstmt);
			if(rs.next()){
				setUserProptiy(rs,user);
			}
		} catch (SQLException e) {
			 e.printStackTrace();
		}
		
		return user;
	}

	public void addUserExpense(double expense,int uid ) {

		 Double   oldExpense   =   new UserDao4MySqlImpl().getUserExpense(uid);
			Double      modifyExpense=expense + oldExpense;
		 	 String sql    =  "update  t_user set  expense =  ? where uid  = ?";  
	   	Connection  conn  = null;
		  PreparedStatement  pstmt  = null;
		  conn  = (Connection) DBUtil.getConn();
         pstmt   = (PreparedStatement) DBUtil.getPstmt(conn, sql);
	
	  try {
		  pstmt.setDouble(1, modifyExpense);
	    	pstmt.setInt(2, uid);
		  pstmt.executeUpdate();
	 if(modifyExpense > 20000){
		   new UserDao4MySqlImpl().modifyUserLevel(uid);
	 }
	} catch (SQLException e) {
	 e.printStackTrace();
	}finally{
		DBUtil.close(conn, pstmt, null);
	}
	}

	public void modifyUserLevel(int  id) {
		String sql  = "update  t_user set level =1 where uid = ? ";
	 Connection  conn =null;
	 PreparedStatement   pstmt  = null;
	 conn  = (Connection) DBUtil.getConn();
	 pstmt  = (PreparedStatement) DBUtil.getPstmt(conn, sql);
			 try {
				pstmt.setInt(1, id);
				  pstmt.executeUpdate();
			} catch (SQLException e) {
		 		e.printStackTrace();
			}finally{
				DBUtil.close(conn, pstmt, null);
			}
			 
	}

	public Double getUserExpense(int id) {
		Double expense=-1.0;
		String  sql   = "select   expense  from t_user where  uid   = ?";
		Connection  conn  = null;
		 PreparedStatement   pstmt  =  null;
		 ResultSet  rs  = null;
		 conn     = (Connection) DBUtil.getConn();
		 pstmt  = (PreparedStatement) DBUtil.getPstmt(conn, sql);
       try {
		pstmt.setInt(1, id);
		 rs=  pstmt.executeQuery();
		if(rs.next()){
			expense  = rs.getDouble(1);
		}
	} catch (SQLException e) {
		 e.printStackTrace();
	}finally{
		DBUtil.close(conn, pstmt, null);
	}
       return   expense;
	}

	 
}
