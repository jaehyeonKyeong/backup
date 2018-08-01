package day0530;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.PrinterIsAcceptingJobs;

/**
 * �̱��� ������ ������ Ŭ����
 * 
 * @author owner
 *
 */
public class PreparedStatemnetDAO {

	private static PreparedStatemnetDAO ps_dao;

	private PreparedStatemnetDAO() {

	}// DAO

	public static PreparedStatemnetDAO getInstance() {
		if (ps_dao == null) {
			ps_dao = new PreparedStatemnetDAO();
		} // end if
		return ps_dao;
	}// getinstance

	private Connection getConnection() throws SQLException {
		Connection con = null;
		// 1. ����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2. Ŀ�ؼ� ���
		String url = "jdbc:oracle:thin:@211.63.89.140:1521:orcl";
		String id = "scott";
		String pass = "1111";
		con = DriverManager.getConnection(url, id, pass);
		return con;
	}// getconnection

	private void dbClose(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
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

	public void insertCpDept(CpDeptVO cdv) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 2. Ŀ�ؼ� ���
			con = getConnection();
			// 3. ������ ������ü ���
			String insertCpDept = "insert into cp_dept(deptno,dname,loc) values(?,?,?)";
			pstmt = con.prepareStatement(insertCpDept);
			// 4. bind ������ �� �ֱ�
			pstmt.setInt(1, cdv.getDeptno());
			pstmt.setString(2, cdv.getDname());
			pstmt.setString(3, cdv.getLoc());
			// 5. ������ ������ ��� ���
			pstmt.executeUpdate();
		} finally {
			// 6. ���� ����
			dbClose(null, pstmt, con);
		}

	}// insert

	public int updateCpDept(CpDeptVO cdv) throws SQLException {
		int row_count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 1.
			// 2.
			con = getConnection();
			// 3.
			String updateCpDept = "update cp_dept set dname=?,loc=? where deptno=?";
			pstmt = con.prepareStatement(updateCpDept);
			// 4.bind������ ���ֱ�
			pstmt.setString(1, cdv.getDname());
			pstmt.setString(2, cdv.getLoc());
			pstmt.setInt(3, cdv.getDeptno());
			// 5.
			row_count = pstmt.executeUpdate();
		} finally {
			// 6.
			dbClose(null, pstmt, con);
		}
		return row_count;
	}// update

	public int deleteCpDept(int data) throws SQLException {
		int row_count = 0;
		int deptno = data;

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 1.
			// 2.
			con = getConnection();
			// 3.
			String deleteCpDept = "delete from cp_dept where deptno=?";
			pstmt = con.prepareStatement(deleteCpDept);
			// 4.���ε� ������ ���ֱ�
			pstmt.setInt(1, deptno);
			// 5.
			row_count = pstmt.executeUpdate();
		} finally {
			// 6.
			dbClose(null, pstmt, con);
		}
		return row_count;
	}// delete

	public List<CpDeptVO> selectAllCpDept() throws SQLException {
		List<CpDeptVO> list = new ArrayList<CpDeptVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1.
			// 2.
			con = getConnection();
			String selectAllCpDept = "select deptno,dname,loc from dept";
			// 3.
			pstmt = con.prepareStatement(selectAllCpDept);
			// 4.
			// 5.������ ������ ������
			rs = pstmt.executeQuery();

			CpDeptVO cdv = null;
			while (rs.next()) {// ��ȸ�� ���� �����Ѵٸ�
				// ���ڵ忡 �÷����� �����ͼ� VO�� ����
				cdv = new CpDeptVO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				// cdv��� �ϳ��� �̸��� ��� �Ҵ� �ϱ� ������ ���� ������ ��ü�� �����ϰ� �ȴ�
				list.add(cdv);
				// ���� �Ҵ��� ���� ������� �ʰ� list�� ���� �����ش�.
			} // end while

		} finally {
			// 6. ���� ����
			dbClose(rs, pstmt, con);
		}

		return list;
	}// selectAllCpDept

	public OneCpDeptV selectOneCpDept(int deptno) throws SQLException {
		OneCpDeptV ocdv = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1.
			// 2.
			con=getConnection();
			// 3.
			String selectOneCpDept="select dname,loc from cp_dept where deptno=?";
			pstmt=con.prepareStatement(selectOneCpDept);
			// 4. bind������ �� ����
			pstmt.setInt(1, deptno);					
			// 5.���� ������ ������
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //��ȸ����� �Ѱ��̶�� if�� ���Ͽ� ó��
				ocdv=new OneCpDeptV(deptno,rs.getString("dname"),rs.getString("loc"));
				
			}
		} finally {
			// 6.
			dbClose(rs, pstmt, con);
		}
		return ocdv;
	}

}// class
