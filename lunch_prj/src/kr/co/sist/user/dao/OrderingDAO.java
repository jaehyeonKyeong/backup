package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.properties.DataBaseConnection;
import kr.co.sist.user.vo.LunchDetailVO;
import kr.co.sist.user.vo.LunchVO;
import kr.co.sist.user.vo.MyOrderingVO;
import kr.co.sist.user.vo.OrderingVO;

public class OrderingDAO {
	private static OrderingDAO o_dao;

	private OrderingDAO() {

	}//OrderingDAO

	public static OrderingDAO getInstance() {
		if(o_dao == null) {
			o_dao=new OrderingDAO();
		}//end if

		return o_dao;
	}//getInstance


	/**
	 * �ֹ� ������ ���ö��� ����Ʈ
	 * @return
	 * @throws SQLException
	 */
	public List<LunchVO> selectLunch() throws SQLException{
		List<LunchVO> listLunch=new ArrayList<LunchVO>();

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {

			//1.����̹��ε�
			//2.Ŀ�ؼ� ���
			con=DataBaseConnection.getInstance().getConnection();
			//3.������ ������ü ���
			String selectLunch=
					"select lunch_code,prd_name,price,prd_info,img from lunch";
			pstmt=con.prepareStatement(selectLunch);
			//4.���ε庯���� �� �ֱ�
			//5.������ ���� �� ��� ���
			rs=pstmt.executeQuery();

			LunchVO lv=null;
			while(rs.next()) { //��ȸ�� ���� �����Ѵٸ�

				lv=new LunchVO();
				lv.setImg("s_"+rs.getString("img"));
				lv.setLunchCode(rs.getString("lunch_code"));
				lv.setPrdName(rs.getString("prd_name"));
				lv.setLunchInfo(rs.getString("prd_info"));

				listLunch.add(lv);


			}//end while

		}finally {

			//6.�������
			if(rs!=null) {rs.close();} //end if
			if(pstmt!=null) {pstmt.close();} //end if
			if(con!=null) {con.close();} //end if

		}//end finally

		return listLunch;
	}//selectLunch

	/**
	 * �޴��� �ֹ��ϱ� ���� ���ö��� �ڵ�� �ش� ���ö��� �������� ��ȸ
	 * @param prdCode
	 * @return
	 * @throws SQLException
	 */
	public LunchDetailVO selectDetailLunch(String prdCode)throws SQLException{
		LunchDetailVO ldv=null;

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
		//1.����̹��ε�
		//2.connection ���
			con=DataBaseConnection.getInstance().getConnection();
		//3.
			String selectLunch=
					"select prd_name,price,prd_info,img from lunch where lunch_code=?";
			pstmt=con.prepareStatement(selectLunch);
		//4.
			pstmt.setString(1, prdCode);
			
		//5.
			rs=pstmt.executeQuery();
			if(rs.next()) {
				//��ȸ����� VO�� ����
				ldv=new LunchDetailVO(prdCode, rs.getString("prd_name"),
						rs.getString("prd_info"), rs.getString("img"), rs.getInt("price"));
			}//end if
		}finally {
		//6.
			if(rs !=null) {rs.close();} //end if
			if(pstmt !=null) {pstmt.close();} //end if
			if(con !=null) {con.close();} //end if

		}//end finally

		return ldv;
	}//selectDetailLunch

	/**
	 * ��ȭ��ȣ�� ������ ������ �ֹ������� Ȯ���ϴ� �޼ҵ�.
	 * @param phone
	 * @return
	 * @throws SQLException
	 */
	public List<MyOrderingVO> selectOrderingList(String phone)throws SQLException{
		List<MyOrderingVO> list=new ArrayList<MyOrderingVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
			con=DataBaseConnection.getInstance().getConnection();
		//3.
			StringBuilder selectOrder=new StringBuilder();
			selectOrder
			.append(" select lun.img, lun.prd_name, lun.price, ord.quantity")
			.append(" from ordering ord,lunch lun")
			.append(" where ord.lunch_code=lun.lunch_code")
			.append(" and ord.phone=? and to_char(ord.order_date,'yyyymmdd')=to_char(sysdate,'yyyymmdd')")
			.append(" and to_char(ord.order_date,'hh24')between 9 and 13")
			.append(" order  by ord.order_date desc");
		
			pstmt=con.prepareStatement(selectOrder.toString());
		//4.
			pstmt.setString(1, phone);
		//5.
			rs=pstmt.executeQuery();
			
			MyOrderingVO mov=null;
			while(rs.next()) {
				mov=new MyOrderingVO(rs.getString("img"), rs.getString("prd_name"),
						rs.getInt("quantity"),rs.getInt("price"));
				list.add(mov);
				
			}//end while
			
			
			
			
		}finally {
		//6.
			if(rs !=null) {rs.close();} //end if
			if(pstmt!=null) {pstmt.close();} //end if
			if(con !=null) {con.close();} //end if
		}//end finally
		
		return list;
	}//selectOrderingList

	/**
	 * ���ö��� �ֹ� �۾�
	 * @param ov �ֹ������� ���� ��ü.
	 * @throws SQLException
	 */
	public void insertOredr(OrderingVO ov)throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		//1.
		//2.
			con=DataBaseConnection.getInstance().getConnection();
		//3.
			String insertOrder=
		"insert into ordering(order_code,name,phone,address,quantity,ip_address,lunch_code)values(ordering_code,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(insertOrder);
			
		//4.
			pstmt.setString(1, ov.getName());
			pstmt.setString(2, ov.getPhone());
			pstmt.setString(3, ov.getAddress());
			pstmt.setInt(4, ov.getQuantity());
			pstmt.setString(5, ov.getIpAdress());
			pstmt.setString(6, ov.getLunchCode());
		//5.
			pstmt.executeUpdate();
		}finally {
		//6.
			if(pstmt !=null) {pstmt.close();} //end if
			if(con !=null) {con.close();} //end if
			
		}//end finally
		
		
	}//insertOredr

}//class
