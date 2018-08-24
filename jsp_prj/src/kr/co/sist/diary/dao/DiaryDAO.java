package kr.co.sist.diary.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.sist.diary.vo.DiaryDeleteVO;
import kr.co.sist.diary.vo.DiaryInsertVO;
import kr.co.sist.diary.vo.DiaryListVO;
import kr.co.sist.diary.vo.DiaryUpdateVO;
import kr.co.sist.diary.vo.DiaryVO;
import kr.co.sist.diary.vo.ListVO;
import kr.co.sist.diary.vo.MonthInfoVO;
import kr.co.sist.diary.vo.MonthVO;

public class DiaryDAO {
	private static DiaryDAO d_dao;

	private DiaryDAO() {
	}

	public static DiaryDAO getInstance() {
		if (d_dao == null) {
			d_dao = new DiaryDAO();
		} // end if
		return d_dao;
	}// DiaryDAO

	private Connection getConn() throws SQLException {

		Connection con = null;

		try {
			// 1.
			Context ctx = new InitialContext();
			// 2.
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/dbcp");
			// 3.
			con = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} // end catch

		return con;
	}// getConn

	/**
	 * ��,���� �Է¹޾� �ش� ���� �ۼ��� ����(�̺�Ʈ)�� ��ȸ.
	 * 
	 * @param miv
	 *            ��,���� ���� VO
	 * @return ���� �ۼ��� �̺�Ʈ�� ���� Map
	 * @throws SQLException
	 */
	public Map<String, List<MonthVO>> selectMonth(MonthInfoVO miv) throws SQLException {

		Map<String, List<MonthVO>> monthMap = new HashMap<String, List<MonthVO>>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 3.
			con = getConn();
			// 4.
			String selectMonth = "select num,subject from diary where e_year=? and e_month=? and e_day=? order by num";
			pstmt = con.prepareStatement(selectMonth);

			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, Integer.parseInt(miv.getYear()));
			cal.set(Calendar.MONTH, Integer.parseInt(miv.getMonth()) - 1);
			int lastDay = cal.getActualMaximum(Calendar.DATE) + 1;
			// 5.
			pstmt.setString(1, miv.getYear());
			pstmt.setString(2, miv.getMonth());

			for (int tempDay = 1; tempDay < lastDay; tempDay++) {
				pstmt.setString(3, String.valueOf(tempDay));

				List<MonthVO> list = new ArrayList<MonthVO>();
				MonthVO mv = null;

				rs = pstmt.executeQuery();

				while (rs.next()) {
					// �ش� ���ڿ� �̺�Ʈ�� �����Ѵٸ� �˻������ VO������
					mv = new MonthVO(rs.getInt("num"), rs.getString("subject"));
					// VO�� List ����
					list.add(mv);
				} // end while
					// �̺�Ʈ�� �ۼ��� �ϸ� �ʿ� �߰��Ѵ�.
				if (!list.isEmpty()) {
					monthMap.put(String.valueOf(tempDay), list);
				} // end if

				// rs�� �����־� ���� ������ cursor�� �Ѱܹ޴´�.
				rs.close();

			} // end for

		} finally {
			// 6.
			if (rs != null) {
				rs.close();
			} // end if
			if (pstmt != null) {
				pstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally

		return monthMap;
	}// selectMonth

	/**
	 * �۹�ȣ(�ĺ���)�� �޾Ƽ� �ش� �۹�ȣ�� ������ ��ȸ(�̺�Ʈ �б�)
	 * 
	 * @param num
	 *            �۹�ȣ
	 * @return ����, ����, �ۼ���, ip, �ۼ����� ��ȸ�Ͽ� ��ȯ
	 * @throws SQLException
	 */
	public DiaryVO selectDay(int num) throws SQLException {
		DiaryVO dv = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 3.
			con = getConn();
			// 4.
			String selectEvt = "select subject, writer, content, ip_address,to_char(input_date,'yyyy-mm-dd hh24:mi') input_date from diary where num=?";
			pstmt = con.prepareStatement(selectEvt);
			pstmt.setInt(1, num);
			// 5.
			rs = pstmt.executeQuery();

			if (rs.next()) {
				StringBuilder content = new StringBuilder();
				BufferedReader br = new BufferedReader(rs.getClob("content").getCharacterStream());

				String temp = "";
				try {
					while ((temp = br.readLine()) != null) {
						content.append(temp).append("\n");
					} // end if
				} catch (IOException ie) {
					ie.printStackTrace();
				} // end catch

				dv = new DiaryVO(num, rs.getString("subject"), rs.getString("writer"), content.toString(),
						rs.getString("input_date"), rs.getString("ip_address"));

			} // end if
				// ���� ���� cnt�� ���� ��Ų��.
			pstmt.close();
			String updateCnt = "update diary set cnt=cnt+1 where num=?";
			pstmt = con.prepareStatement(updateCnt);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();

		} finally {
			// 6.
			if (rs != null) {
				rs.close();
			} // end if
			if (pstmt != null) {
				pstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // finally

		return dv;
	}// selectDay

	/**
	 * ����ڰ� �Է��� ���� Diary DB Table�� �߰� �Ϸ翡 5���� ������ �ۼ��� �� �ִ�.(��Ģ)
	 * 
	 * @param div
	 * @throws SQLException
	 */
	public boolean insertDiary(DiaryInsertVO div) throws SQLException {

		boolean flag = false;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 3.
			con = getConn();
			StringBuilder selectCnt = new StringBuilder();
			selectCnt.append("select count(*) cnt from diary where e_year=? ").append("and e_month=? and e_day=?");

			pstmt = con.prepareStatement(selectCnt.toString());
			pstmt.setString(1, div.getParam_year());
			pstmt.setString(2, div.getParam_month());
			pstmt.setString(3, div.getParam_day());

			rs = pstmt.executeQuery();

			int cnt = 0;
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			} // end if
			pstmt.close();

			if (cnt < 5) { // �۾��� ����
				flag = true;
			} // end if

			if (flag) {
				// 4.�̺�Ʈ �߰�(�ۼ��� �̺�Ʈ�� 5�� ���϶��)
				StringBuilder insertDiary = new StringBuilder();
				insertDiary.append("insert into diary")
						.append("(num,writer,pwd,subject,content,e_year,e_month,e_day,ip_address)")
						.append("values(seq_diary.nextval,?,?,?,?,?,?,?,?)");

				pstmt = con.prepareStatement(insertDiary.toString());
				pstmt.setString(1, div.getWriter());
				pstmt.setString(2, div.getPwd());
				pstmt.setString(3, div.getSubject());
				pstmt.setString(4, div.getContent());
				pstmt.setString(5, div.getParam_year());
				pstmt.setString(6, div.getParam_month());
				pstmt.setString(7, div.getParam_day());
				pstmt.setString(8, div.getIp_address());
				// 5.
				pstmt.executeUpdate();

			} // end if

		} finally {
			// 6.

			if (rs != null) {
				rs.close();
			} // end if
			if (pstmt != null) {
				pstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally

		return flag;
	}// insertDiary

	/**
	 * �۹�ȣ(�ĺ���)�� pwd�� ������ ����, ip_address�� ����
	 * 
	 * @param duv
	 *            �۹�ȣ, ���, ����, ip�� ���� VO
	 * @return ����� ���
	 * @throws SQLException
	 */
	public int updateDiary(DiaryUpdateVO duv) throws SQLException {
		int cnt = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// 3.
			con = getConn();
			// 4.
			StringBuilder updateDiary = new StringBuilder();
			updateDiary.append("update diary ").append("set content=?, ip_address=? ")
					.append("where num=? and  pwd=? ");

			pstmt = con.prepareStatement(updateDiary.toString());
			pstmt.setString(1, duv.getContent());
			pstmt.setString(2, duv.getIp_address());
			pstmt.setInt(3, duv.getNum());
			pstmt.setString(4, duv.getPwd());
			// 5.
			cnt = pstmt.executeUpdate();
		} finally {
			// 6.
			if (pstmt != null) {
				pstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally
		return cnt;
	}// updateDiary

	/**
	 * �۹�ȣ�� ��й�ȣ�� �޾Ƽ� �ش� ���� ����.
	 * 
	 * @param ddv
	 * @return
	 * @throws SQLException
	 */
	public int deleteDiary(DiaryDeleteVO ddv) throws SQLException {
		int cnt = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// 3.
			con = getConn();
			// 4.
			StringBuilder deleteDiary = new StringBuilder();
			deleteDiary.append("delete from diary where num=? and  pwd=? ");

			pstmt = con.prepareStatement(deleteDiary.toString());
			pstmt.setInt(1, ddv.getNum());
			pstmt.setString(2, ddv.getPwd());
			// 5.
			cnt = pstmt.executeUpdate();
		} finally {
			// 6.
			if (pstmt != null) {
				pstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally
		return cnt;
	}// deleteDiary

	/**
	 * �˻� ���ǰ� ���۹�ȣ,����ȣ ���̿� �ش��ϴ� �Խù� ���
	 * 
	 * @param lv
	 * @return
	 * @throws SQLException
	 */
	public List<DiaryListVO> selectDiaryList(ListVO lv) throws SQLException {
		List<DiaryListVO> list = new ArrayList<DiaryListVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConn();

			StringBuilder selectList = new StringBuilder();
			selectList.append(
					"select num,cnt,subject,writer,to_char(input_date,'yyyy-mm-dd hh24:mi') input_date,e_year,e_month,e_day,ip_address from")
					.append(" (select rownum rnum, num,cnt,subject,writer,input_date,e_year,e_month,e_day,ip_address from")
					.append(" (select num,cnt,subject,writer,input_date,e_year,e_month,e_day,ip_address from diary");
			if (lv.getKeyword() != null && !"".equals(lv.getKeyword())) {
				//���ǿ����� �������� ����Ǵ� ��. Dynamic Query
				selectList.append(" where ").append(lv.getFieldName()).append(" like '%'||?||'%' ");
			}
			selectList.append(" order by input_date desc))").append(" where rnum between ? and ?");

			pstmt = con.prepareStatement(selectList.toString());

			int bindNum = 0;
			if (lv.getKeyword() != null && !"".equals(lv.getKeyword())) {
				pstmt.setString(++bindNum, lv.getKeyword());
			}
			pstmt.setInt(++bindNum, lv.getStartNum());
			pstmt.setInt(++bindNum, lv.getEndNum());
			rs = pstmt.executeQuery();

			DiaryListVO dlv = null;
			while (rs.next()) {
				dlv = new DiaryListVO(rs.getInt("num"), rs.getInt("cnt"), rs.getString("subject"),
						rs.getString("writer"), rs.getString("input_date"), rs.getString("e_year"),
						rs.getString("e_month"), rs.getString("e_day"), rs.getString("ip_address"));
				list.add(dlv);
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
		return list;
	}// selectdiaryList

	/**
	 * ��ü �Խù��� ��
	 * 
	 * @param lv
	 * @return
	 * @throws SQLException
	 */
	public int rowCnt(ListVO lv) throws SQLException {
		int cnt = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = getConn();
			StringBuilder selectCnt = new StringBuilder();
			selectCnt.append("select count(*) cnt from diary");
			// �˻� ���� ������ �˻� ���� �����ϴ� ���� ���� ��´�.
			if (lv.getKeyword() != null && !"".equals(lv.getKeyword())) {
				selectCnt.append(" where ").append(lv.getFieldName()).append(" like '%'||?||'%' ");
			}
			pstmt = con.prepareStatement(selectCnt.toString());
			if (lv.getKeyword() != null && !"".equals(lv.getKeyword())) {
				pstmt.setString(1, lv.getKeyword());
			}
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt("cnt");
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

		return cnt;
	}// rowCnt

}// class
