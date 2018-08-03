package kr.co.sist.licensee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.ls.LSInput;

import kr.co.sist.licensee.vo.MenuRegistrationVO;
import kr.co.sist.licensee.vo.MenuVO;
import kr.co.sist.licensee.vo.RestaurantRegistrationVO;
import kr.co.sist.properties.DataBaseConnection;

public class RestaurantRegistrationDAO {
	private static RestaurantRegistrationDAO rr_dao;
	
	
	private RestaurantRegistrationDAO() {
		
	}//RestaurantRegistrationDAO
	
	
	
	public static RestaurantRegistrationDAO getInstance() {
		if(rr_dao ==null) {
			rr_dao=new RestaurantRegistrationDAO();
		}//end if
		return rr_dao;
	}//end if
	
	public String restaurantNumGet() throws SQLException {
		String rNum="";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DataBaseConnection.getInstance().getConnection();
			String sql="select seq_resturant.nextval rNum from dual";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				rNum=rs.getString("rNum");
			}
			
		}finally {
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		return rNum;
	}
	
	//식당등록
	public void insertRestaurant(RestaurantRegistrationVO rrvo ,String rNum) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		//1.
		//2.
			con=DataBaseConnection.getInstance().getConnection();
		//3.
			String insertRestaurant="insert into restaurant(restaurant_number,restaurant_name,corporate_number,ceo_name,restaurant_addr,customer_transaction,phone_number,restaurant_category,restaurant_intro,restaurant_image,map_image,id,input_date,activity)values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate,0)";
			pstmt=con.prepareStatement(insertRestaurant);
			
		//4.
			
			pstmt.setString(1, rNum);
			pstmt.setString(2, rrvo.getrName());
			pstmt.setString(3, rrvo.getbNumber());
			pstmt.setString(4, rrvo.getcName());
			pstmt.setString(5, rrvo.getrAddr());
			pstmt.setString(6, rrvo.getcPrice());
			pstmt.setString(7, rrvo.getrTel());
			pstmt.setInt(8, rrvo.getFoodCategory());
			pstmt.setString(9, rrvo.getrIntro());
			pstmt.setString(10, rrvo.getrImg());
			pstmt.setString(11, rrvo.getMapImg());
			pstmt.setString(12, rrvo.getL_id());
			
		//5.
			pstmt.executeUpdate();
		}finally {
		//6.
			if(pstmt !=null) {pstmt.close();} //end if
			if(con !=null) {con.close();} //end if
			
		}//end finally
	}//insertRestaurant
	
	//메뉴등록 //해봐야함~
	public void insertMenu(MenuRegistrationVO mrvo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		//1.
		//2.
			con=DataBaseConnection.getInstance().getConnection();
		//3.
			String insertMenu="insert into menu(restaurant_number,menu_name,price,menu_intro,menu_image,input_date)values(?,?,?,?,?,sysdate)";
			pstmt=con.prepareStatement(insertMenu);
			
		//4.
			pstmt.setString(1, mrvo.getrNum());
			pstmt.setString(2, mrvo.getMenuName());
			pstmt.setString(3, mrvo.getMenuPrice());
			pstmt.setString(4, mrvo.getMenuIntro());
			pstmt.setString(5, mrvo.getMenuImg());
			
		//5.
			pstmt.executeUpdate();
		}finally {
		//6.
			if(pstmt !=null) {pstmt.close();} //end if
			if(con !=null) {con.close();} //end if
			
		}//end finally
		
		
	}//insertMenu



	//메뉴를 뷰테이블에 조회한다
	//select MENU_NAME, PRICE from menu where restaurant_number=?;
	public List<MenuVO> selectMenu(String rNum) throws SQLException{
		List<MenuVO> menuList=new ArrayList<>();
		MenuVO mvo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DataBaseConnection.getInstance().getConnection();
			String selectSql="select * from menu where trim(restaurant_number)=?";
			pstmt=con.prepareStatement(selectSql);
			pstmt.setString(1, rNum.trim());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				mvo=new MenuVO(rs.getString("menu_name"), rs.getInt("price"));
				menuList.add(mvo);
			}
			
		}finally {
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		return menuList;
	}
	
	
	
}//class
