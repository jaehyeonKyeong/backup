package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.properties.DataBaseConnection;
import kr.co.sist.user.vo.MenuSearchVO;
import kr.co.sist.user.vo.RestaurantDetailVO;

public class RestaurantDetailDAO {
	private static RestaurantDetailDAO rd_dao;

	private RestaurantDetailDAO() {

	}

	public static RestaurantDetailDAO getInstance() {
		if (rd_dao == null) {
			rd_dao = new RestaurantDetailDAO();
		}
		return rd_dao;
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
	
	//레스토랑 넘버를 받아서 레스토랑이름,이미지,메뉴리스트,정보를 띄어주는일
	public RestaurantDetailVO selectAllRestaurantDetail(String rNum) throws SQLException,NullPointerException {
		RestaurantDetailVO rdvo=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			
			con=getConnection();
			String sql="select r.restaurant_number, r.restaurant_image, r.restaurant_name, restaurant_intro,menu_name, price, menu_intro from restaurant r, menu m where r.restaurant_number(+)=m.restaurant_number and r.restaurant_number=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, rNum);
			rs=pstmt.executeQuery();
			List<MenuSearchVO> menuList=new ArrayList<>();;
			MenuSearchVO menuVO=null;
			while(rs.next()) {
			rdvo = new RestaurantDetailVO(rs.getString("restaurant_number"), rs.getString("restaurant_name") , rs.getString("restaurant_intro"));
				menuVO=new MenuSearchVO(rs.getString("menu_name"), rs.getString("price"), rs.getString("menu_intro"));
				menuList.add(menuVO);
			}
			rdvo.setListMenu(menuList);
			
		}finally {
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {	con.close();}
		}
		return rdvo;
	}
	//신고버튼이 눌리면 신고테이블을 식당넘버를 이용하여 조회하는 일
	public int selectRestaurantReport(String rNum) throws SQLException {
		int selectFlag=0;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		con=getConnection();
		String selectReportSql="select report_cnt from restaurant_report where restaurant_number=?";
		pstmt=con.prepareStatement(selectReportSql);
		pstmt.setString(1, rNum);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			selectFlag=rs.getInt("report_cnt");
		}
		}finally {
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		
		
		return selectFlag;
	}

	//신고버튼이 눌렸을때 신고테이블을 식당넘버를 이용하여 insert쿼리를 날리는일
	public void insertReport(String rNum) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		con=getConnection();
		String selectReportSql="insert into restaurant_report(restaurant_number,report_date,report_cnt) values(?,sysdate,1)";
		pstmt=con.prepareStatement(selectReportSql);
		pstmt.setString(1, rNum);
		pstmt.executeUpdate();
		
		}finally {
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
	}

	//신고버튼이 눌렸을때 신고테이블을 식당넘버를 이용하여  update쿼리를 날리는일
	public void updateReport(String rNum, int cnt) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String updateSql="update restaurant_report set report_cnt=? where restaurant_number=?";
			pstmt=con.prepareStatement(updateSql);
			pstmt.setInt(1, cnt);
			pstmt.setString(2, rNum);
			pstmt.executeUpdate();
		}finally {
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		
	}

}
