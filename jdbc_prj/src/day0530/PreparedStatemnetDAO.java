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
 * 싱글톤 패턴을 적용한 클래스
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
		// 1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2. 커넥션 얻기
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
			// 2. 커넥션 얻기
			con = getConnection();
			// 3. 쿼리문 생성객체 얻기
			String insertCpDept = "insert into cp_dept(deptno,dname,loc) values(?,?,?)";
			pstmt = con.prepareStatement(insertCpDept);
			// 4. bind 변수에 값 넣기
			pstmt.setInt(1, cdv.getDeptno());
			pstmt.setString(2, cdv.getDname());
			pstmt.setString(3, cdv.getLoc());
			// 5. 쿼리문 수행후 결과 얻기
			pstmt.executeUpdate();
		} finally {
			// 6. 연결 끊기
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
			// 4.bind변수에 값넣기
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
			// 4.바인드 변수에 값넣기
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
			// 5.쿼리문 수행후 결과얻기
			rs = pstmt.executeQuery();

			CpDeptVO cdv = null;
			while (rs.next()) {// 조회된 행이 존재한다면
				// 레코드에 컬럼값을 가져와서 VO에 저장
				cdv = new CpDeptVO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				// cdv라는 하나의 이름에 계속 할당 하기 때문에 가장 마지막 객체만 참조하게 된다
				list.add(cdv);
				// 이전 할당한 값이 사라지지 않게 list에 덮어 씌어준다.
			} // end while

		} finally {
			// 6. 연결 끊기
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
			// 4. bind변수에 값 설정
			pstmt.setInt(1, deptno);					
			// 5.쿼리 수행후 결과얻기
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //조회결과가 한건이라면 if로 비교하여 처리
				ocdv=new OneCpDeptV(deptno,rs.getString("dname"),rs.getString("loc"));
				
			}
		} finally {
			// 6.
			dbClose(rs, pstmt, con);
		}
		return ocdv;
	}

}// class
