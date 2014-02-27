package com.shopping.anping.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.shopping.anping.dao.NoticeDao;
import com.shopping.guoguo.pojo.Comment;
import com.shopping.guoguo.pojo.Notice;
import com.shopping.util.DBUtil;

public class NoticeDao4MySqlImpl implements NoticeDao {

	public void add(Notice notice) {
		String sql  = "insert into  t_notice values(null,?,?,?,?)";
		 Connection conn = null;
		 PreparedStatement  pstmt = null;
		 conn  = (Connection) DBUtil.getConn();
		 pstmt=  (PreparedStatement) DBUtil.getPstmt(conn, sql);
		 try {
			pstmt.setString(1, notice.getTitle());
		  pstmt.setString(2, notice.getContent());
		  pstmt.setDate(3,  new Date(notice.getPdate().getTime()));
		  pstmt.setDate(4,  new Date(notice.getOverdate().getTime()));
		  pstmt.executeUpdate();
		  
		 } catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, null);
		}
		 
	}

	public void deleteById(int id) {
		String sql   ="delete from  t_notice  where id  =?";
	 Connection  conn  = null;
	 PreparedStatement   pstmt   = null;
	 conn =  (Connection) DBUtil.getConn();
	 pstmt=   (PreparedStatement) DBUtil.getPstmt(conn, sql);
	    try {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
		  	e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, null);
		}
	    
	}
	
	public    void update(Notice notice){
		this.deleteById(notice.getId());
		this.add(notice);
	}

	public Notice findNoticeById(int id) {
		Notice notice  = new Notice();
		String sql  = "select * from t_notice where id=?";
		Connection conn  = null;
		PreparedStatement pstmt = null;
		ResultSet   rs  = null;
		conn = (Connection) DBUtil.getConn();
		pstmt= (PreparedStatement) DBUtil.getPstmt(conn, sql);
		try {
			pstmt.setInt(1, id);
			rs = DBUtil.getRs(pstmt);
			if(rs.next()){
				 rsToNotice(rs,notice);
			}
		} catch (SQLException e) {
			 e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, rs);
		}
		
	 	return notice;
	}

	public void checkNoticeIsNotGuoQiToDelte(){
		 String sql  = "delete  from t_notice  where  (year(now())=year(overdate)) and (month(now())=month(overdate)) and (day(now())=day(overdate)) ";   
		  Connection  conn = null;
		   PreparedStatement   pstmt  =null;
		   ResultSet  rs  = null;
		   conn  = (Connection) DBUtil.getConn();
		   pstmt  = (PreparedStatement) DBUtil.getPstmt(conn, sql);
		   try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			 e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, null);
		}
		   
	}
	
	public List<Notice> findNoticeByPage(int firstIndex, int maxResult) {
		List<Notice> notices = new ArrayList<Notice>();
		 	String sql  = "select * from  (select * from t_notice order by id desc) n limit  ? , ?";
		Connection conn  = null;
		PreparedStatement pstmt = null;
		ResultSet   rs  = null;
		conn = (Connection) DBUtil.getConn();
		pstmt= (PreparedStatement) DBUtil.getPstmt(conn, sql);
		try {
		
			pstmt.setInt(1, firstIndex);
			pstmt.setInt(2, maxResult);
			
			rs = DBUtil.getRs(pstmt);
			while(rs.next()){
				Notice notice  = new Notice();
				
				 rsToNotice(rs,notice);
			 
				 notices.add(notice);
			}
		} catch (SQLException e) {
			 e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, rs);
		}
		
	 	return notices;
	}
private  void rsToNotice(ResultSet rs,Notice notice) throws SQLException{
	notice.setId(rs.getInt(1));
	notice.setTitle(rs.getString(2));
	notice.setContent(rs.getString(3));
	notice.setPdate(rs.getDate(4));
	notice.setOverdate(rs.getDate(5));
}

public int getTotalNotice() {
   int total=-1;
	String sql  = "select count(*) from t_notice";
	  Connection conn = null;
	  PreparedStatement   pstmt = null;
	  ResultSet rs  = null;
	   conn =  (Connection) DBUtil.getConn();
	   pstmt=  (PreparedStatement) DBUtil.getPstmt(conn, sql);
	   rs= DBUtil.getRs(pstmt);
	   try {
		if(rs.next()){
			total  = rs.getInt(1);
		   }
	} catch (SQLException e) {
		 e.printStackTrace();
	}
	return total;
}
}
