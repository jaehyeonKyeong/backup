package kr.co.sist.web.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.tomcat.util.buf.B2CConverter;

import kr.co.sist.web.member.vo.WebMemberVO;
import kr.co.sist.web.member.vo.ZipcodeVO;

public class MemberDAO {
	private static MemberDAO m_dao;

	private MemberDAO() {

	}

	public static MemberDAO getInstance() {
		if (m_dao == null) {
			m_dao = new MemberDAO();
		}
		return m_dao;
	}

	private Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			// 1.JNDI��밴ü ����
			Context ctx = new InitialContext();
			// 2.DBCP���� ���ᰴü ���
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/test_dbcp");
			// 3.Connection���
			con = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}

		return con;
	}

	// ID�ߺ��˻� : ���̵� �̹� �����ϴ��� �Ǵ�
	public boolean idDup(String id) throws SQLException {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 3.Connection ���
			con = getConnection();
			// 4.������ ���� ��ü���
			String selectID = "select id from web_member where id=?";
			pstmt = con.prepareStatement(selectID);
			pstmt.setString(1, id);
			// 5.������ ������ ��� ���
			rs = pstmt.executeQuery();
			if (rs.next()) {// id�� ������϶�
				flag = true;
			}
		} finally {
			// 6.���� ����;
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
		return flag;
	}

	// �����ȣ �˻�
	public List<ZipcodeVO> selectZipcode(String dong) throws SQLException {
		List<ZipcodeVO> ziplist = new ArrayList<ZipcodeVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			StringBuilder selectZipcode = new StringBuilder();
			selectZipcode.append("select zipcode,sido,gugun,dong,nvl(bunji,' ') bunji").append(" from zipcode")
					.append(" where dong like ?||'%'");
			pstmt = con.prepareStatement(selectZipcode.toString());
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			ZipcodeVO zv = null;
			while (rs.next()) {
				zv = new ZipcodeVO(rs.getString("zipcode"), rs.getString("sido"), rs.getString("gugun"),
						rs.getString("dong"), rs.getString("bunji"));
				ziplist.add(zv);
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
		return ziplist;
	}

	public void insertWebMember(WebMemberVO wmv) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 3.Ŀ�ؼ� ���
			con = getConnection();
			// 4.������ ������ü ���
			StringBuilder insertMember = new StringBuilder();
			insertMember.append("insert into web_member")
					.append("(ID,PASSWD,NAME,TEL,ZIPCODE,ADDR1,ADDR2,SSN,GENDER,BIRTH,MARRIAGE,MARR_DATE,GREETING,IP)")
					.append("values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt = con.prepareStatement(insertMember.toString());

			// 5.������ ������ ��� ���
			pstmt.setString(1, wmv.getId());
			pstmt.setString(2, wmv.getPasswd());
			pstmt.setString(3, wmv.getName());
			pstmt.setString(4, wmv.getTel());
			pstmt.setString(5, wmv.getZipcode());
			pstmt.setString(6, wmv.getAddr1());
			pstmt.setString(7, wmv.getAddr2());
			pstmt.setString(8, wmv.getSsn());// ��ȯ
			pstmt.setString(9, wmv.getGender());
			pstmt.setString(10, wmv.getBirth());
			pstmt.setString(11, wmv.getMarriage());
			pstmt.setString(12, wmv.getMarr_date());
			pstmt.setString(13, wmv.getGreeting());
			pstmt.setString(14, wmv.getIp());

			pstmt.executeUpdate();
			// ������ ��̰� �����Ѵٸ�
			if (wmv.getHobby() != null) {
				//������ ����� ����ŭ �߰��ؾ� �ϹǷ� �ݺ�����
				for (int i = 0; i < wmv.getHobby().length; i++) {
					//pstmt�� ������ �����ϳ� ���� pstmt�� close���� ������ memory������ �߻��� �� �����Ƿ� ������ ��
					pstmt.close();
					String insertHobby = "insert into web_member_hobby(id,hobby)values(?,?)";
					//pstmt�� �ٽ� ���ͼ�
					pstmt = con.prepareStatement(insertHobby);
					//���� �ְ�
					pstmt.setString(1, wmv.getId());
					pstmt.setString(2, wmv.getHobby()[i]);
					//DB Table�� �߰��Ѵ�.
					pstmt.executeUpdate();
				}
			}

		} finally {
			// 6.���� ����
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}// insert
}
