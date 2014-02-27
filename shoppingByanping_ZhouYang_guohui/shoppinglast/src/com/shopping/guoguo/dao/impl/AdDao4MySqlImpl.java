package com.shopping.guoguo.dao.impl;

import com.shopping.guoguo.dao.AdDao;
import com.shopping.guoguo.pojo.Ad;
import com.shopping.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AdDao4MySqlImpl implements AdDao {

	public void addAd(Ad ad) {
		
		Connection conn = null;
		PreparedStatement pstmt =  null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getPstmt(conn, "insert into t_ad values(null,?,?,?)");
		
		 try {
			 pstmt.setString(1, ad.getaURL());
			pstmt.setDate(2,  new Date(ad.getOverdate().getTime()));
			pstmt.setString(3, ad.getExp());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, null);
		}
		

	}

	public void deleteAdByAid(int aid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getPstmt(conn, "delete from t_ad where aid = ?");
		try {
			pstmt.setInt(1, aid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, null);
		}
		
	}

	public List<Ad> showAllAds() {
		List<Ad> ad = new ArrayList<Ad>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getPstmt(conn, "select * from t_ad");
		try {
			pstmt.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		rs = DBUtil.getRs(pstmt);
		try {
			while(rs.next()){
				Ad adver = new Ad();
				adver.setAid(rs.getInt(1));
				adver.setaURL(rs.getString(2));
				adver.setOverdate(rs.getDate(3));
				adver.setExp(rs.getString(4));
				ad.add(adver);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ad;
	}

}
