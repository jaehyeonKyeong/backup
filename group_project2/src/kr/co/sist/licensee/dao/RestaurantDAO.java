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
	
	//�Ĵ��� ��ȸ
	@SuppressWarnings("unused")
	public List<RestaurantLicenseeVO> selectMyRe(String id) throws SQLException {
		List<RestaurantLicenseeVO> list=new ArrayList<RestaurantLicenseeVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//1.����̹��ε�
			//2.Ŀ�ؼ� ���
			con=DataBaseConnection.getInstance().getConnection();
			//3.������ ������ü ���
			String selectRestaurant=
					"select restaurant_name,restaurant_number from restaurant where id=?";
			pstmt=con.prepareStatement(selectRestaurant);
			//4.���ε庯���� �� �ֱ�
			pstmt.setString(1, id);
			//5.������ ���� �� ��� ���
			rs=pstmt.executeQuery();

			RestaurantLicenseeVO rlv=null;
			while(rs.next()) { //��ȸ�� ���� �����Ѵٸ�

				rlv=new RestaurantLicenseeVO(rs.getString("restaurant_name"),
						rs.getString("restaurant_number"));
				list.add(rlv);
			}//end while
		}finally {

			//6.�������
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
	
	
	
	////�Ĵ��� �Ĵ� ����//////
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
