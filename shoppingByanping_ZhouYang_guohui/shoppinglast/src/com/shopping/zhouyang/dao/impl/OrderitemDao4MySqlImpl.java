package com.shopping.zhouyang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.guoguo.dao.impl.GoodsDao4MySqlImpl;
import com.shopping.guoguo.pojo.Orderitem;
import com.shopping.util.DBUtil;
import com.shopping.zhouyang.dao.OrderitemDao;

public class OrderitemDao4MySqlImpl implements OrderitemDao {

	public List<Orderitem> getOrderitemByOid(String oid) {
		List<Orderitem> orderitems = new ArrayList<Orderitem>();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"select * from t_orderitem where oid=?");
		ResultSet rs = null;

		try {
			pstmt.setString(1, oid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Orderitem orderitem = new Orderitem();
				orderitem.setId(rs.getInt(1));
				orderitem.setOrder(new OrderDao4MySqlImpl().getOrderByOid(rs
						.getString(2)));
				orderitem.setGoods(new GoodsDao4MySqlImpl().getGoodByGid(rs
						.getInt(3)));
				orderitem.setNum(rs.getInt(4));
				orderitems.add(orderitem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}

		return orderitems;
	}

	public int saveOrderitem(Orderitem orderitem) {
		int result = -1;
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"insert into t_orderitem values(null,?,?,?)");
		try {
			pstmt.setString(1, orderitem.getOrder().getOid());
			pstmt.setInt(2, orderitem.getGoods().getGid());
			pstmt.setInt(3, orderitem.getNum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, null);
		}
		return result;
	}

	public int removeOrderitemByOid(String oid) {
		int result = -1;
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, "delete from t_orderitem where oid=?");
		try {
			pstmt.setString(1, oid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, null);
		}
		return result;
	}

}
