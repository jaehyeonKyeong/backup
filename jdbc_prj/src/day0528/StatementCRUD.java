package day0528;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * CRUD(Create Read Update Delete)
 * 
 * @author owner
 */
public class StatementCRUD {

	/**
	 * DB연동 작업 1.드라이버 로딩 2.connection 얻기
	 * 
	 * @return
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			// 1.드라이버 로딩
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch
			// 2.connection 얻기
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id = "scott";
		String pass = "1111";

		con = DriverManager.getConnection(url, id, pass);

		return con;
	}

	/**
	 * 사원번호 사원명 연봉 보너스를 입력받아 cp_emp테이블에 추가하는 일
	 * 
	 * @param cev
	 * @throws SQLException
	 */
	public void insertCpEmp(CpEmpVO cev) throws SQLException {
		// 1,2. connection 얻기
		Connection con = null;
		Statement stmt = null;
		try {
			con = getConnection();
			// 3. 쿼리문 생성객체 얻기
			stmt = con.createStatement();
			// 4. 쿼리문 수행우 결과 얻기
			// String insertQuery = "insert into
			// cp_emp(empno,ename,hiredate,sal,comm)values(" + cev.getEmpno() + ",'"
			// + cev.getEname() + "',sysdate," + cev.getSal() + "," + cev.getComm() + ")";
			StringBuilder insertQuery = new StringBuilder();
			insertQuery.append("insert into cp_emp(empno,ename,hiredate,sal,comm)values(").append(cev.getEmpno())
					.append(",'").append(cev.getEname()).append("',sysdate,").append(cev.getSal()).append(",")
					.append(cev.getComm()).append(")");
			int cnt = stmt.executeUpdate(insertQuery.toString());
			System.out.println(cnt + "건 추가");
		} finally {
			// 5. 연결 끊기
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} // end final
	}// insertCpEmp

	/**
	 * 사원번호 사원명 연봉을 입력받아 사원번호에 해당하는 사원의 사원명 연봉을 변경하는 일
	 * 
	 * @param cevu
	 * @return
	 * @throws SQLException
	 */
	public int updateCpEmp(CpEmpVOUpdate cevu) throws SQLException {

		int cnt = 0;
		Connection con = null;
		Statement stmt = null;
		try {
			// 1,2.
			con = getConnection();
			// 3.쿼리문 생성객체 얻기
			stmt = con.createStatement();
			// 4.쿼리문 실행 후 결과 얻기
			// String updateCpEmp = "update cp_emp set ename='" + cevu.getEname() + "',
			// sal=" + cevu.getSal()
			// + " where empno=" + cevu.getEmpno();
			StringBuilder updateCpEmp = new StringBuilder();
			updateCpEmp.append("update cp_emp set ename='").append(cevu.getEname()).append("', sal=")
					.append(cevu.getSal()).append(" where empno=").append(cevu.getEmpno());
			cnt = stmt.executeUpdate(updateCpEmp.toString());
		} finally {
			// 5.연결끊기
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				stmt.close();
			}
		}

		return cnt;
	}// deleteCpEmp

	/**
	 * 사원번호를 입력받아 CP_EMP테이블에서 삭제하는 일
	 * 
	 * @param empno
	 * @return 삭제된 행수
	 * @throws SQLException
	 */
	public int deleteCpEmp(int empno) throws SQLException {
		int cnt = 0;
		Connection con = null;
		Statement stmt = null;
		try {
			// 1.2
			con = getConnection();
			// 3.
			stmt = con.createStatement();
			// 4.
			StringBuilder deleteCpEmp = new StringBuilder();
			deleteCpEmp.append("delete from cp_emp where empno=").append(empno);
			cnt = stmt.executeUpdate(deleteCpEmp.toString());
		} finally {
			// 5. 연결 끊기
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return cnt;
	}// deleteCpEmp

	public List<CpEmpAllVO> selectAllCpEmp() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<CpEmpAllVO> list=new ArrayList<>();
		CpEmpAllVO ceav=null;
		try {
			// 1.2.
			con = getConnection();
			// 3.
			stmt = con.createStatement();
			// 4.
			String selectCpEmp = "select empno,ename,sal,comm,hiredate hi1,to_char(hiredate,'yyyy-mm-dd') hi2 from cp_emp";
			rs = stmt.executeQuery(selectCpEmp);
			
			int empno=0,sal=0,comm=0;
			String ename="",hi2="";
			Date hi1=null;
			SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
			System.out.println("EMPNO\tENAME\tSAL\tCOMM\tHI1\t\tHI2");
			while (rs.next()) {//쿼리가 실행되어 조회된 레코드가 존재한다면
				empno=rs.getInt("empno");
				ename=rs.getString("ename");
				sal=rs.getInt("sal");
				comm=rs.getInt("comm");
				hi1=rs.getDate("hi1");
				hi2=rs.getString("hi2");
				//조회결과를 vo에 저장
				ceav=new CpEmpAllVO(empno,sal,comm,ename,hi2,hi1);
				//조회결과를 가진 vo를 list에 추가(ceav는 레코드하나를 가지게되고,반복수행 될때마다 같은 이름의 객체를 생성하게 되어
				//garbage collector가 수거하게 되는데, garbage collector가 수거하지 않도록 list에 추가한다.
				list.add(ceav);
			}//end while
		} finally {
			// 5.
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return list;
	}// selectAllCpEmp

}
