package day0718;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author owner
 *
 */
/**
 * @author owner
 *
 */
public class EmployeeDAO {
	private static EmployeeDAO e_dao;

	private EmployeeDAO() {

	}

	public static EmployeeDAO getInstance() {
		if (e_dao == null) {
			e_dao = new EmployeeDAO();
		}
		return e_dao;
	}

	public Connection getConnection() throws SQLException {
		Connection con = null;
		// 1.JNDI ��밴ü ����
		Context ctx = null;
		try {
			ctx = new InitialContext();
			// 2.DBCP���� �̸����� ���� ��ü ���
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/test_dbcp");
			// 3.
			con = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}// getConnection

	public List<DeptVO> selectAllDept() throws SQLException {
		List<DeptVO> deptList = new ArrayList<DeptVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.JNDI��밴ü ����
			Context ctx = new InitialContext();
			// 2.DBCP���� DataSource���
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/test_dbcp");
			// 3.Connection���
			con = getConnection();
			// 4.������ ������ü ���
			String selectDept = "select deptno,dname,loc from dept";
			pstmt = con.prepareStatement(selectDept);
			// 5.���� ���� �� ��� ���
			rs = pstmt.executeQuery();
			DeptVO dv = null;
			while (rs.next()) {
				dv = new DeptVO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				deptList.add(dv);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 6.���� ����
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
		return deptList;
	}

	public List<EmpVO> selectEmp(int deptno) throws SQLException {
		List<EmpVO> empList = new ArrayList<EmpVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1.JNDI��� ��ü ����
			// 2.DBCP���� DataSource���
			// 3.Connection���
			con = getConnection();
			// 4.������ ���� ��ü ���
			String selectEmp = "select empno,ename,job,sal,to_char(hiredate,'yyyy-mm-dd') hiredate from emp where deptno=? order by sal";
			pstmt = con.prepareStatement(selectEmp);
			// 4-1.���ε� ������ �� ����
			pstmt.setInt(1, deptno);
			// 5.���� ���� �� ��� ���
			rs = pstmt.executeQuery();
			EmpVO ev = null;
			while (rs.next()) {
				ev = new EmpVO(rs.getInt("empno"), rs.getInt("sal"), rs.getString("ename"), rs.getString("job"),
						rs.getString("hiredate"));
				empList.add(ev);
			}
		} finally {
			// 6.���� �� ��� ����
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

		return empList;
	}

	// public static void main(String[] args) {
	// try {
	// main method�� �����ϸ� dbcp������ ������ ���� JVM�� ����ǹǷ� lookup���� ã�� �� �ִ� ��ü�� �������� �ʴ´�
	// main method�� ���� �׽�Ʈ�ϱ� ��ƴ� - servlet�̳� JSP�� �׽�Ʈ
	// System.out.println(getInstance().getConnection());
	// } catch (NamingException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }//main

}// EmployeeDAO
