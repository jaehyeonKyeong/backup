package kr.co.sist.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.admin.vo.LunchListVO;
import kr.co.sist.admin.vo.OrderListVO;
import kr.co.sist.properties.DataBaseConnection;
import kr.co.sist.admin.vo.LunchVO;

public class LunchMainDAO {

	private static LunchMainDAO lm_dao;

	private LunchMainDAO() {

	}

	public static LunchMainDAO getInstance() {
		if (lm_dao == null) {
			lm_dao = new LunchMainDAO();
		} // end if
		return lm_dao;
	}// getInstance

	/**
	 * ���ö��� ��� ��ȸ
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<LunchListVO> selectLunchList() throws SQLException {
		List<LunchListVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			// 1.
			// 2.
			con = DataBaseConnection.getInstance().getConnection();

			// 3.
			String selectLunch = "select lunch_code,prd_name,price,prd_info,'s_'||img img from lunch";
			pstmt = con.prepareStatement(selectLunch);
			// 4. ���ε� ���� �� �ֱ�
			// 5.
			rs = pstmt.executeQuery();
			LunchListVO lv = null;
			while (rs.next()) {// ��ȸ�� �� �ִٸ�
				lv = new LunchListVO();
				lv.setImg(rs.getString("img"));
				lv.setLunchCode(rs.getString("lunch_code"));
				lv.setPrdName(rs.getString("prd_name"));
				lv.setLunchInfo(rs.getString("prd_info"));
				lv.setPrice(rs.getInt("price"));

				list.add(lv);

			}

		} finally {
			// 6. ���� ����
			if (rs != null) {
				rs.close();
			} // end if
			if (pstmt != null) {
				pstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		}

		return list;
	}// selectLunchList

	/**
	 * ������ �ֹ� ��Ȳ ��ȸ(���� 9�ú��� 13�� ������ �ֹ� �� ��ȸ)
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<OrderListVO> selectTodayOrder() throws SQLException {
		List<OrderListVO> list = new ArrayList<OrderListVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1.
			// 2.
			con = DataBaseConnection.getInstance().getConnection();
			// 3.
			StringBuilder selectOrder = new StringBuilder();
			selectOrder.append(
					"	select	ord.order_code,lun.prd_name, lun.lunch_code, ord.name, ord.phone, ord.order_date,ord.status,ord.quantity	")
					.append("	from lunch lun,ordering ord	").append("	where ord.lunch_code=lun.lunch_code and	")
					.append("	to_char(ord.order_date,'yymmdd')=to_char(sysdate,'yymmdd') 	")
					// .append(" and to_char(ord.order_date,'hh24') between 9 and 13 ")
					.append("	order by ord.status 	");
			pstmt = con.prepareStatement(selectOrder.toString());
			// 4.
			// 5.
			rs = pstmt.executeQuery();
			OrderListVO olv = null;
			while (rs.next()) {
				olv = new OrderListVO(rs.getString("order_code"), rs.getString("prd_name"), rs.getString("lunch_code"),
						rs.getString("name"), rs.getString("phone"), rs.getString("order_date"), rs.getString("status"),
						rs.getInt("quantity"));

				list.add(olv);
			}
		} finally {
			// 6.
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

		return list;
	}// selectTodayOrder

	/**
	 * ���ö� �߰�
	 * 
	 * @param lv
	 * @throws SQLException
	 */
	public void insertLunch(LunchVO lv) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DataBaseConnection.getInstance().getConnection();
			String insertLunch = "insert into lunch(lunch_code,prd_name,price,prd_info,img)values(lunch_code,?,?,?,?)";
			pstmt = con.prepareStatement(insertLunch);
			pstmt.setString(1, lv.getPrdName());
			pstmt.setInt(2, lv.getPrice());
			pstmt.setString(3, lv.getLunchInfo());
			pstmt.setString(4, lv.getImg());

			pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

	}// insertLunch

	/**
	 * �ֹ��� ���ö��� �ϼ��Ǿ������� ���� ���� ��ȭ
	 * 
	 * @param orderCode
	 *            ���� �Ϸ�� ���ö��� �ֹ� �ڵ�
	 * @return ����� ���
	 * @throws SQLException
	 */
	public int updateStatus(String orderCode) throws SQLException {
		int cnt = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DataBaseConnection.getInstance().getConnection();
			String updateOrder = "update ordering set status='Y' where order_code=?";

			pstmt = con.prepareStatement(updateOrder);

			pstmt.setString(1, orderCode);

			cnt = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return cnt;
	}// updateStatus

	/**
	 * ���ö��� �����ϴ� ��
	 * 
	 * @param lunchCode
	 *            ������ ���ö��� �ڵ�
	 * @return ������ ���
	 * @throws SQLException
	 */
	public int deleteLunch(String lunchCode) throws SQLException {
		int cnt = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = DataBaseConnection.getInstance().getConnection();
			String deletLunch = "delete from lunch where lunch_code=?";
			pstmt = con.prepareStatement(deletLunch);

			pstmt.setString(1, lunchCode);
			cnt = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return cnt;
	}

}// class
