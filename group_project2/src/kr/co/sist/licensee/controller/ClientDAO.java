package kr.co.sist.licensee.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.properties.DataBaseConnection;

public class ClientDAO {
	private static ClientDAO c_dao;

	private ClientDAO() {
	}

	public static ClientDAO getInstance() {
		if (c_dao == null) {
			c_dao = new ClientDAO();
		}
		return c_dao;
	}

	public Connection getConnection() throws SQLException {
		Connection con = null;
		con = DataBaseConnection.getInstance().getConnection();
		return con;
	}

	// 받아올 식당의 이미지를 oracle에서 조회하여 이미지 명을 내보내는 일
	public String selectRestImg(String rNum) throws SQLException {
		String restaurantImgName = null;
		System.out.println("dao select"+rNum);

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String selectSql = "select restaurant_image from restaurant where trim(restaurant_number)=?";
			pstmt = con.prepareStatement(selectSql);
			pstmt.setString(1, rNum.trim());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				restaurantImgName = rs.getString("restaurant_image");
			}
			System.out.println("------clientDao : " + restaurantImgName);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return restaurantImgName;
	}

	public String selectMenuImg(String menuName) throws SQLException{
		String menuImgName = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String selectSql = "select menu_image from menu where trim(menu_name)=?";
			pstmt = con.prepareStatement(selectSql);
			pstmt.setString(1, menuName.trim());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				menuImgName = rs.getString("menu_image");
			}
			System.out.println("------clientDao : " + menuImgName);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return menuImgName;
	}

	public String selectReviewImg(String riNum) throws SQLException{
		String reviewImgName = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String selectSql = "select review_image from review where trim(review_Number)=?";
			pstmt = con.prepareStatement(selectSql);
			pstmt.setString(1, riNum.trim());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				reviewImgName = rs.getString("review_image");
			}
			System.out.println("------clientDao : " + reviewImgName);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return reviewImgName;
	}

	public String selectMapImg(String rNum) throws SQLException {
		String mapImgName = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String selectSql = "select map_image from restaurant where trim(restaurant_number)=?";
			pstmt = con.prepareStatement(selectSql);
			pstmt.setString(1, rNum.trim());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				mapImgName = rs.getString("map_image");
			}
			System.out.println("------clientDao : " + mapImgName);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return mapImgName;
	}

}
