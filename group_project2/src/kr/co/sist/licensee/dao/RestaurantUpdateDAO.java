package kr.co.sist.licensee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.licensee.vo.MenuUpdateVO;
import kr.co.sist.licensee.vo.MenuVO;
import kr.co.sist.licensee.vo.RestaurantSelectVO;
import kr.co.sist.licensee.vo.RestaurantUpdateVO;
import kr.co.sist.properties.DataBaseConnection;

public class RestaurantUpdateDAO {
	private static RestaurantUpdateDAO ru_dao;
	
	private RestaurantUpdateDAO() {
		
	}//RestaurantUpdateDAO
	
	public static RestaurantUpdateDAO getInstance() {
		if(ru_dao==null) {
			ru_dao=new RestaurantUpdateDAO();
		}
		return ru_dao;
	}//getInstance
	
	
	//레스토랑 정보 가져오기
	public RestaurantSelectVO selectRestaurant(String rNumber) throws SQLException{
		List<MenuVO> menuList=new ArrayList<>();
		MenuVO mnuVO=null;
		RestaurantSelectVO ruvo=null;
		

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
		//1.드라이버로딩
		//2.connection 얻기
			con=DataBaseConnection.getInstance().getConnection();
		//3.
			String selectRestaurant=
					"select r.restaurant_image,r.map_image,r.restaurant_name,r.corporate_number,r.ceo_name,r.restaurant_addr, r.phone_number,r.customer_transaction,r.restaurant_category,r.restaurant_intro,m.menu_name,m.price from restaurant r,menu m where m.restaurant_number=r.restaurant_number(+) and r.restaurant_number=?";
			pstmt=con.prepareStatement(selectRestaurant);
		//4.
			pstmt.setString(1, rNumber);
			
		//5.
			rs=pstmt.executeQuery();
			while(rs.next()) {
				//조회결과를 VO에 설정
				ruvo=new RestaurantSelectVO(rs.getString("restaurant_image"),
						rs.getString("map_image"),
						rs.getString("restaurant_name"),
						rs.getString("corporate_number"),
						rs.getString("ceo_name"),
						rs.getString("restaurant_addr"),
						rs.getString("customer_transaction"),
						rs.getString("phone_number"),
						rs.getString("restaurant_intro"), 
						rs.getInt("restaurant_category"));
				mnuVO=new MenuVO(rs.getString("menu_name"), rs.getInt("Price"));
				menuList.add(mnuVO);
				
			}//end if
			ruvo.setMenuList(menuList);
			
		}finally {
		//6.
			if(rs !=null) {rs.close();} //end if
			if(pstmt !=null) {pstmt.close();} //end if
			if(con !=null) {con.close();} //end if

		}//end finally
	
		
		
		return ruvo;
		
	}//selectRestaurant
	
	public List<MenuVO> selectMenu(String rNumber)throws SQLException{
		List<MenuVO> list=new ArrayList<MenuVO>();
		
		
		MenuVO mv=null;

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
		//1.드라이버로딩
		//2.connection 얻기
			con=DataBaseConnection.getInstance().getConnection();
		//3.
			String selectRestaurant=
					"select menu_name, price from menu where restaurant_number=?";
			pstmt=con.prepareStatement(selectRestaurant);
		//4.
			pstmt.setString(1, rNumber);
			
		//5.
			rs=pstmt.executeQuery();
			if(rs.next()) {
				//조회결과를 VO에 설정
				mv=new MenuVO(rs.getString("menu_name"),
						rs.getInt("price"));
				list.add(mv);
			}//end if
			
		}finally {
		//6.
			if(rs !=null) {rs.close();} //end if
			if(pstmt !=null) {pstmt.close();} //end if
			if(con !=null) {con.close();} //end if

		}//end finally
		
		return list;
	}//selectMenu
	
	
	///식당수정 테이블에서 메뉴목록 업데이트 //확인해야봐야함
	public void updateMenu(MenuUpdateVO mv,String menuName) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=DataBaseConnection.getInstance().getConnection();
			
			String updateMenu=
					"update menu set menu_name=? price=? menu_intro=? menu_image=? input_date=sysdate where restaurant_number=? and menu_name=?";
			pstmt=con.prepareStatement(updateMenu);
			
			pstmt.setString(1, mv.getMenuName());
			pstmt.setInt(2, mv.getMenuPrice());
			pstmt.setString(3, mv.getMenuIntro());
			pstmt.setString(4, mv.getMenuImage());
			pstmt.setString(5, mv.getrNum());
			pstmt.setString(6, menuName);
			
			
			pstmt.executeUpdate();
		
		}finally {
		//6.
			if(pstmt !=null) {pstmt.close();} //end if
			if(con !=null) {con.close();} //end if
		
		}//end finally
	}//deleteRestaurant
	
	
	//식당 수정테이블에서 메뉴목록 삭제 //확인해봐야함
	public void deleteMenu(String rNum,String mName)throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=DataBaseConnection.getInstance().getConnection();
			String deleteMenu=
					"delete from menu where menu_name=? and trim(restaurant_number)=?";
			pstmt=con.prepareStatement(deleteMenu);
			pstmt.setString(1, mName);
			pstmt.setString(2, rNum.trim());
			
			pstmt.executeUpdate();
		}finally {
			if(pstmt !=null) {pstmt.close();} //end if
			if(con !=null) {con.close();} //end if
		
		}//end finally
	}//deleteMenu

	//식당 수정 버튼이 눌렸을때 식당의 값을 받아서 dataBase에 업데이트 한다.
	//update restaurant set column=value where restaurant_number=?
	public void updateRestaurnat(String rNum, RestaurantUpdateVO ruvo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			
			con=DataBaseConnection.getInstance().getConnection();
			String updateSql="update restaurant set restaurant_name=?,corporate_number=?,ceo_name=?,restaurant_addr=?"
					+ ",restaurant_image=?,map_image=?,customer_transaction=?,phone_number=?,restaurant_category=?"
					+ ",restaurant_intro where restaurant_number=?";
			pstmt=con.prepareStatement(updateSql);
			pstmt.setString(1,ruvo.getrName());
			pstmt.setString(2,ruvo.getbNumber());
			pstmt.setString(3,ruvo.getcName());
			pstmt.setString(4,ruvo.getrAddr());
			pstmt.setString(5,ruvo.getrImg());
			pstmt.setString(6,ruvo.getMapImg());
			pstmt.setString(7,ruvo.getcPrice());
			pstmt.setString(8,ruvo.getrTel());
			pstmt.setInt(9,ruvo.getFoodCategory());
			pstmt.setString(10,ruvo.getrIntro());
			pstmt.setString(11,rNum);
			
			pstmt.executeUpdate();
			
			
			
		}finally {
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
	}
	
	
	
	
}//class
