package kr.co.sist.licensee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.licensee.vo.MenuVO;
import kr.co.sist.licensee.vo.RestaurantLicenseeVO;
import kr.co.sist.properties.DataBaseConnection;

public class RestaurantDAO {
	private static RestaurantDAO r_dao;
	
	private RestaurantDAO() {
	}
	
	public static RestaurantDAO getInstance() {
		if(r_dao ==null) {
			r_dao=new RestaurantDAO();
		}//end if
		return r_dao;
	}//end if
	
	//식당의 조회
	@SuppressWarnings("unused")
	public List<RestaurantLicenseeVO> selectMyRe(String id) throws SQLException {
		List<RestaurantLicenseeVO> list=new ArrayList<RestaurantLicenseeVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//1.드라이버로딩
			//2.커넥션 얻기
			con=DataBaseConnection.getInstance().getConnection();
			//3.쿼리문 생성객체 얻기
			String selectRestaurant=
					"select restaurant_name,restaurant_number from restaurant where id=?";
			pstmt=con.prepareStatement(selectRestaurant);
			//4.바인드변수에 값 넣기
			pstmt.setString(1, id);
			//5.쿼리문 수행 후 결과 얻기
			rs=pstmt.executeQuery();

			RestaurantLicenseeVO rlv=null;
			while(rs.next()) { //조회된 행이 존재한다면

				rlv=new RestaurantLicenseeVO(rs.getString("restaurant_name"),
						rs.getString("restaurant_number"));
				list.add(rlv);
			}//end while
		}finally {

			//6.연결끊기
			if(rs!=null) {rs.close();} //end if
			if(pstmt!=null) {pstmt.close();} //end if
			if(con!=null) {con.close();} //end if

		}//end finally
		
		return list;
	}//selectMyRe
	
	
/*	public boolean deleteRestaurant(String licensee_id) {
		boolean flag=false;
		
		return flag;
	}//deleteRestaurant
*/	
	public void insertMenu(MenuVO mvo) throws SQLException {
		
	}//insertMenu
	
	
	
	////식당목록 식당 삭제//////
	public void deleteRest(String rNumber) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			
			con=DataBaseConnection.getInstance().getConnection();
			String deleteRestaurant="delete from restaurant where restaurant_number=?";
			pstmt=con.prepareStatement(deleteRestaurant);
			pstmt.setString(1, rNumber);
			pstmt.executeUpdate();
			
		}finally {
			if(pstmt !=null) {pstmt.close();} //end if
			if(con !=null) {con.close();} //end if
		}//end finally
	}//deleteRest
	
}//class
