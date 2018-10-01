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
		// 1.JNDI 사용객체 생성
		Context ctx = null;
		try {
			ctx = new InitialContext();
			// 2.DBCP에서 이름으로 연결 객체 얻기
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
			// 1.JNDI사용객체 생성
			Context ctx = new InitialContext();
			// 2.DBCP에서 DataSource얻기
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/test_dbcp");
			// 3.Connection얻기
			con = getConnection();
			// 4.쿼리문 생성객체 얻기
			String selectDept = "select deptno,dname,loc from dept";
			pstmt = con.prepareStatement(selectDept);
			// 5.쿼리 수행 후 결과 얻기
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
			// 6.연결 끊기
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
			// 1.JNDI사용 객체 생성
			// 2.DBCP에서 DataSource얻기
			// 3.Connection얻기
			con = getConnection();
			// 4.쿼리문 생성 객체 얻기
			String selectEmp = "select empno,ename,job,sal,to_char(hiredate,'yyyy-mm-dd') hiredate from emp where deptno=? order by sal";
			pstmt = con.prepareStatement(selectEmp);
			// 4-1.바인드 변수에 값 설정
			pstmt.setInt(1, deptno);
			// 5.쿼리 수행 후 결과 얻기
			rs = pstmt.executeQuery();
			EmpVO ev = null;
			while (rs.next()) {
				ev = new EmpVO(rs.getInt("empno"), rs.getInt("sal"), rs.getString("ename"), rs.getString("job"),
						rs.getString("hiredate"));
				empList.add(ev);
			}
		} finally {
			// 6.연결 후 결과 끊기
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
	// main method로 실행하면 dbcp설정을 가지지 않은 JVM이 실행되므로 lookup으로 찾을 수 있는 객체가 존재하지 않는다
	// main method로 단일 테스트하기 어렵다 - servlet이나 JSP로 테스트
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
