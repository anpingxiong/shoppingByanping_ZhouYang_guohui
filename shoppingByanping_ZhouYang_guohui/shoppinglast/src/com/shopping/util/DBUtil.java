package com.shopping.util;
import java.sql.*;

public class DBUtil {
	
	private static String driverName;
	private static String url;
	private static String username;
	private static String password;
	
	private DBUtil(){}
	
	static {
		driverName = PropUtil.getValue("driverName", "DBConfig.properties");
		url = PropUtil.getValue("url", "DBConfig.properties");
		username = PropUtil.getValue("username", "DBConfig.properties");
		password = PropUtil.getValue("password", "DBConfig.properties");
		
	}
	
	
	
	
	static{
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("与数据库连接的驱动程序未找到。 ");
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConn(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			   System.out.println("获取数据库连接时出现了异常。。。");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static PreparedStatement getPstmt (Connection conn,String sql){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("获取预编译表达式语句时出现了异常。。。");
			e.printStackTrace();
		}
		return pstmt;
	}
	
	public static ResultSet getRs(PreparedStatement pstmt){
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 System.out.println("获取查询的结果集时出现了异常。。。");
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				 System.out.println("关闭结果集时出现了异常。。。");
				e.printStackTrace();
			}
			rs = null;
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("关闭表达式语句时出现了异常。。。");
				e.printStackTrace();
			}
			pstmt = null;
			
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("关闭连接时出现了异常。。。");
				e.printStackTrace();
			}
			conn = null;
		}
		
	}
	
	
	

}
