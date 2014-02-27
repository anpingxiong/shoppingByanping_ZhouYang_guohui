package com.shopping.zhouyang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopping.guoguo.pojo.Address;
import com.shopping.util.DBUtil;
import com.shopping.zhouyang.dao.AddressDao;

public class AddressDao4MySqlImpl implements AddressDao {

	public int saveAddress(Address address) {
		int result = -1;
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"insert into t_address values(?,?,?,?,?)");
		try {
			pstmt.setString(1, address.getGetname());
			pstmt.setString(2, address.getAddress());
			pstmt.setString(3, address.getPost());
			pstmt.setString(4, address.getTel());
			pstmt.setString(5, address.getOrder().getOid());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, null);
		}
		return result;
	}

	public Address getAddressByOid(String oid) {
		Address address = new Address();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, "select * from t_address where oid=?");
		ResultSet rs = null;
		try {
			pstmt.setString(1, oid);
			rs =DBUtil.getRs(pstmt);
			while(rs.next()){
				address.setGetname(rs.getString(1));
				address.setAddress(rs.getString(2));
				address.setPost(rs.getString(3));
				address.setTel(rs.getString(4));
				address.setOrder(new OrderDao4MySqlImpl().getOrderByOid(oid));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, rs);
		}
		return address;
	}

	public int removeAddressByOid(String oid) {
		int result = -1;
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, "delete from t_address where oid =?");
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
