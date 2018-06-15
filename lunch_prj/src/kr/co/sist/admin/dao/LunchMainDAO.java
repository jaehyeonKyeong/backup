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
	 * 도시락의 목록 조회
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
			// 4. 바인드 변수 값 넣기
			// 5.
			rs = pstmt.executeQuery();
			LunchListVO lv = null;
			while (rs.next()) {// 조회된 행 있다면
				lv = new LunchListVO();
				lv.setImg(rs.getString("img"));
				lv.setLunchCode(rs.getString("lunch_code"));
				lv.setPrdName(rs.getString("prd_name"));
				lv.setLunchInfo(rs.getString("prd_info"));
				lv.setPrice(rs.getInt("price"));

				list.add(lv);

			}

		} finally {
			// 6. 연결 끊기
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
	 * 오늘의 주문 현황 조회(오전 9시부터 13시 까지의 주문 만 조회)
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
	 * 도시락 추가
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
	 * 주문된 도시락이 완성되었는지에 대한 상태 변화
	 * 
	 * @param orderCode
	 *            제작 완료된 도시락의 주문 코드
	 * @return 변경된 행수
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
	 * 도시락을 삭제하는 일
	 * 
	 * @param lunchCode
	 *            삭제할 도시락의 코드
	 * @return 삭제된 행수
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
