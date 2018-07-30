package kr.co.sist.licensee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.licensee.vo.MenuUpdateVO;
import kr.co.sist.properties.DataBaseConnection;

public class MenuUpdateDAO {
	private static MenuUpdateDAO mu_dao;

	private MenuUpdateDAO() {

	}

	public static MenuUpdateDAO getInstance() {
		if (mu_dao == null) {
			mu_dao = new MenuUpdateDAO();
		}
		return mu_dao;
	}

	// 메뉴정보를 불러서 셋팅하는 역활
	public MenuUpdateVO settingMenuInfo(String rNum, String mName) throws SQLException {
		MenuUpdateVO muvo = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DataBaseConnection.getInstance().getConnection();
			String selectSql = "select * from menu where trim(restaurant_number)=? and menu_name=?";
			pstmt = con.prepareStatement(selectSql);
			pstmt.setString(1, rNum.trim());
			pstmt.setString(2, mName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				muvo = new MenuUpdateVO(rs.getString("menu_name"), rs.getInt("price"), rs.getString("menu_intro"),
						rs.getString("menu_image"), rs.getString("restaurant_number"));
			}
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
		return muvo;
	}

	public void menuUpdate(String mName, String price, String intro, String imgFile, String orimName, String rNum)
			throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DataBaseConnection.getInstance().getConnection();
			String updateSql = "update menu set menu_name=?,price=?,menu_intro=?,menu_image=? where menu_name=? and trim(restaurant_number)=?";
			pstmt = con.prepareStatement(updateSql);
			pstmt.setString(1, mName);
			pstmt.setString(2, price);
			pstmt.setString(3, intro);
			pstmt.setString(4, imgFile);
			pstmt.setString(5, orimName);
			pstmt.setString(6, rNum.trim());
			pstmt.executeUpdate();
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}

	}

}
