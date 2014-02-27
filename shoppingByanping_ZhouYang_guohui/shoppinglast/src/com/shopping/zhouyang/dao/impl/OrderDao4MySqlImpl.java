package com.shopping.zhouyang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shopping.anping.dao.UserDao;
import com.shopping.anping.dao.impl.UserDao4MySqlImpl;
import com.shopping.guoguo.pojo.Order;
import com.shopping.guoguo.pojo.User;
import com.shopping.util.DBUtil;
import com.shopping.zhouyang.dao.OrderDao;

public class OrderDao4MySqlImpl implements OrderDao {

	public int saveOrder(Order order) {
		int result = -1;
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"insert into t_order values(?,now(),?,?,?,?,?,?,?,?)");
		try {
			pstmt.setString(1, order.getOid());
			pstmt.setDouble(2, order.getTotal());
			pstmt.setInt(3, order.getPayway());
			pstmt.setInt(4, order.getBillinfo());
			pstmt.setInt(5, order.getGetmethod());
			pstmt.setInt(6, order.getTimereq());
			pstmt.setString(7, order.getExp());
			pstmt.setInt(8, order.getUser().getUid());
			pstmt.setInt(9, order.getState());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, null);
		}
		return result;

	}

	public Order getOrderByOid(String oid) {
		Order order = new Order();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"select * from t_order where oid=? order by odate desc");
		ResultSet rs = null;
		try {
			pstmt.setString(1, oid);
			rs = DBUtil.getRs(pstmt);
			while (rs.next()) {
				order.setOid(rs.getString(1));
				order.setOdate(rs.getDate(2));
				order.setTotal(rs.getDouble(3));
				order.setPayway(rs.getInt(4));
				order.setBillinfo(rs.getInt(5));
				order.setGetmethod(rs.getInt(6));
				order.setTimereq(rs.getInt(7));
				order.setExp(rs.getString(8));
				order.setUser(new UserDao4MySqlImpl().findUserById(rs.getInt(9)));
				order.setState(rs.getInt(10));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}

		return order;
	}

	public List<Order> getOrdersByUid(int uid) {
		List<Order> orders = new ArrayList<Order>();
		Connection conn = DBUtil.getConn();
		ResultSet rs = null;
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"select * from t_order where uid = ? order by odate desc");
		try {
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setOid(rs.getString(1));
				order.setOdate(rs.getDate(2));
				order.setTotal(rs.getDouble(3));
				order.setPayway(rs.getInt(4));
				order.setBillinfo(rs.getInt(5));
				order.setGetmethod(rs.getInt(6));
				order.setTimereq(rs.getInt(7));
				order.setExp(rs.getString(8));
				order.setUser(new UserDao4MySqlImpl().findUserById(uid));
				order.setState(rs.getInt(10));
				orders.add(order);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return orders;
	}

	public int deleteOrderByOid(String oid) {
		int result = -1;
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"delete from t_order where oid=?");
		try {
			pstmt.setString(1, oid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, null);
		}

		return result;
	}

	public int alterOrderByOid(String oid, Double total) {
		int result = -1;
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"update t_order set total=? where oid=?");
		try {
			pstmt.setDouble(1, total);
			pstmt.setString(2, oid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, null);
		}

		return result;
	}

	public List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<Order>();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"select * from t_order order by state desc");
		ResultSet rs = null;
		try {
			rs = DBUtil.getRs(pstmt);
			while (rs.next()) {
				Order order = new Order();
				order.setOid(rs.getString(1));
				order.setOdate(rs.getDate(2));
				order.setTotal(rs.getDouble(3));
				order.setPayway(rs.getInt(4));
				order.setBillinfo(rs.getInt(5));
				order.setGetmethod(rs.getInt(6));
				order.setTimereq(rs.getInt(7));
				order.setExp(rs.getString(8));
				order.setUser(new UserDao4MySqlImpl().findUserById(rs.getInt(9)));
				order.setState(rs.getInt(10));
				orders.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return orders;
	}

	public int alterOrderStateByOid(String oid, int state) {
		int result = -1;
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"update t_order set state=? where oid=?");
		try {
			pstmt.setDouble(1, state);
			pstmt.setString(2, oid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, null);
		}

		return result;
	}

	public List<Order> getOrdersByState(int state) {
		List<Order> orders = new ArrayList<Order>();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"select * from t_order where state=? order by odate desc");
		ResultSet rs = null;
		try {
			pstmt.setInt(1, state);
			rs = DBUtil.getRs(pstmt);
			while (rs.next()) {
				Order order = new Order();
				order.setOid(rs.getString(1));
				order.setOdate(rs.getDate(2));
				order.setTotal(rs.getDouble(3));
				order.setPayway(rs.getInt(4));
				order.setBillinfo(rs.getInt(5));
				order.setGetmethod(rs.getInt(6));
				order.setTimereq(rs.getInt(7));
				order.setExp(rs.getString(8));
				order.setUser(new UserDao4MySqlImpl().findUserById(rs.getInt(9)));
				order.setState(rs.getInt(10));
				orders.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return orders;
	}


	
	public List<Order> getAllOrdersByPage(int firstIndex, int maxResult) {
		List<Order> orders = new ArrayList<Order>();
		String sql = null;
		Connection conn = DBUtil.getConn();
		sql = " select * from(select * from t_order order by state desc) u limit ?,?";
		PreparedStatement pstmt = DBUtil.getPstmt(conn, sql);

		ResultSet rs = null;
		try {
			pstmt.setInt(1, firstIndex);
			pstmt.setInt(2, maxResult);
			rs = DBUtil.getRs(pstmt);
			while (rs.next()) {
				Order order = new Order();
				order.setOid(rs.getString(1));
				order.setOdate(rs.getDate(2));
				order.setTotal(rs.getDouble(3));
				order.setPayway(rs.getInt(4));
				order.setBillinfo(rs.getInt(5));
				order.setGetmethod(rs.getInt(6));
				order.setTimereq(rs.getInt(7));
				order.setExp(rs.getString(8));
				order.setUser(new UserDao4MySqlImpl().findUserById(rs.getInt(9)));
				order.setState(rs.getInt(10));
				orders.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return orders;
	}
	
	public int getAllOrderCount(){
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getPstmt(conn, "select count(*) from t_order");
		rs = DBUtil.getRs(pstmt);
		try {
			if(rs.next()){
			result =	rs.getInt(1);
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}finally{
			DBUtil.close(conn, pstmt, rs);
		}
		return result;	
	}


		
}
