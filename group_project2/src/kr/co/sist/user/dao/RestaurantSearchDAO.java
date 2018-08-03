package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.properties.DataBaseConnection;
import kr.co.sist.user.vo.RestaurantSearchVO;

public class RestaurantSearchDAO {
	private static RestaurantSearchDAO rs_dao;

	private RestaurantSearchDAO() {

	}

	public static RestaurantSearchDAO getInstance() {
		if (rs_dao == null) {
			rs_dao = new RestaurantSearchDAO();
		}
		return rs_dao;
	}

	public static Connection getConnection() throws SQLException {
		Connection con = null;
		DataBaseConnection dbc = DataBaseConnection.getInstance();
		String driver = dbc.getDriver();
		String url = dbc.getUrl();
		String id = dbc.getId();
		String pass = dbc.getPass();
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		con = DriverManager.getConnection(url, id, pass);
		return con;
	}

	// 레스토랑테이블에서 레스토랑의 이미지와 식당명을 조회하여 List에 담아 반환하는 일
	public List<RestaurantSearchVO> searchAllRestaurant() throws SQLException {
		List<RestaurantSearchVO> rsList = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = getConnection();
			String selectSql = "select restaurant_number, restaurant_image, restaurant_name, restaurant_category from restaurant where activity='1'";
			pstmt = con.prepareStatement(selectSql);
			rs = pstmt.executeQuery();
			RestaurantSearchVO rv = null;
			while (rs.next()) {// 조회된 행 있다면
				rv = new RestaurantSearchVO(rs.getString("restaurant_number"), rs.getString("restaurant_image"),
						rs.getString("restaurant_name"), rs.getInt("restaurant_category"));
				rsList.add(rv);
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
		return rsList;
	}

	// 검색창에 레스토랑 이름이 검생이 된다면 가져온 레스토랑이름으로 해당하는 레스토랑의 이름과 이미지를 조회하여 list에담아 반환하는 일
	public List<RestaurantSearchVO> searchValueRestaurant(String rName) throws SQLException {
		List<RestaurantSearchVO> rsList = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String selectSql = "select restaurant_number, restaurant_image, restaurant_name, restaurant_category from restaurant where restaurant_name like '%"
					+ rName + "%' and activity='1'";
			pstmt = con.prepareStatement(selectSql);
			rs = pstmt.executeQuery();
			RestaurantSearchVO rv = null;
			while (rs.next()) {// 조회된 행 있다면
				rv = new RestaurantSearchVO(rs.getString("restaurant_number"), rs.getString("restaurant_image"),
						rs.getString("restaurant_name"), rs.getInt("restaurant_category"));
				rsList.add(rv);
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

		return rsList;
	}

	// 정렬 콤보박스의 값을 가져와서 정렬 하는 일(combobox item indexnum)
	public List<RestaurantSearchVO> orderbyRestaurant(int cBoxGrade) throws SQLException {
		List<RestaurantSearchVO> rslist = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = getConnection();
			String orderbySql = "";
			if (cBoxGrade == 0) {
				orderbySql = "select restaurant_number, restaurant_image, restaurant_name, restaurant_category from restaurant where activity='1' order by avg_grades desc";
			} else {
				orderbySql = "select restaurant_number, restaurant_image, restaurant_name, restaurant_category from restaurant where activity='1' order by restaurant_name";
			}
			pstmt = con.prepareStatement(orderbySql);
			rs = pstmt.executeQuery();
			RestaurantSearchVO rv = null;
			while (rs.next()) {// 조회된 행 있다면
				rv = new RestaurantSearchVO(rs.getString("restaurant_number"), rs.getString("restaurant_image"),
						rs.getString("restaurant_name"), rs.getInt("restaurant_category"));
				rslist.add(rv);
			}

		} finally {
			if (rs != null) {
				pstmt.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return rslist;
	}
	//정렬 콤보박스와 카테고리 콤보박스의 값을 가져와서 정렬 하는 일(combobox item indexnum)
	public List<RestaurantSearchVO> orderbyRestaurant(int cBoxGrade,int category) throws SQLException {
		List<RestaurantSearchVO> rslist = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			con = getConnection();
			String orderbySql = "";
			if (cBoxGrade == 0) {
				orderbySql = "select restaurant_number, restaurant_image, restaurant_name, restaurant_category from restaurant where restaurant_category="+category+" and activity='1'  order by avg_grades desc";
			} else {
				orderbySql = "select restaurant_number, restaurant_image, restaurant_name, restaurant_category from restaurant where restaurant_category="+category+" and activity='1' order by restaurant_name";
			}
			pstmt = con.prepareStatement(orderbySql);
			rs = pstmt.executeQuery();
			RestaurantSearchVO rv = null;
			while (rs.next()) {// 조회된 행 있다면
				rv = new RestaurantSearchVO(rs.getString("restaurant_number"), rs.getString("restaurant_image"),
						rs.getString("restaurant_name"), rs.getInt("restaurant_category"));
				rslist.add(rv);
			}
			
		} finally {
			if (rs != null) {
				pstmt.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		
		return rslist;
	}
	//음식카테고리의 값을 받아와서 해당하는 코드의 식당을 조회하는 일
	public List<RestaurantSearchVO> categoryCodeRestaurant(int category) throws SQLException {
		List<RestaurantSearchVO> rsList = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String selectSql = "select restaurant_number, restaurant_image, restaurant_name, restaurant_category from restaurant where restaurant_category="+category+" and activity='1'";
			pstmt = con.prepareStatement(selectSql);
			rs = pstmt.executeQuery();
			RestaurantSearchVO rv = null;
			while (rs.next()) {// 조회된 행 있다면
				rv = new RestaurantSearchVO(rs.getString("restaurant_number"), rs.getString("restaurant_image"),
						rs.getString("restaurant_name"), rs.getInt("restaurant_category"));
				rsList.add(rv);
			}

		} finally {
			if (rs != null) {rs.close();}
			if (pstmt != null) {pstmt.close();}
			if (con != null) {con.close();}
		}

		return rsList;
	}

}
