package com.shopping.lucene.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.shopping.util.DBUtil;

public class GetPPGoodsName {
         public   static String getName(int ctypeid){
        	String name=null;
        	 String sql  = "select  name  from t_sort where sid  in (select pid  from t_sort  where  sid = ?)";
 
        	 Connection  conn   =  null;
        	 PreparedStatement  pstmt   = null;
        	 ResultSet   rs  =  null;
        	 conn= (Connection) DBUtil.getConn();
        	 pstmt  = (PreparedStatement) DBUtil.getPstmt(conn, sql);
        	try {
				pstmt.setInt(1, ctypeid);
				rs=DBUtil.getRs(pstmt);
				if(rs.next()){
					name   = rs.getString(1);
				}
			} catch (SQLException e) {
			 	e.printStackTrace();
			} finally{
				DBUtil.close(conn, pstmt, rs);
			}
        	return name;
         }
}
