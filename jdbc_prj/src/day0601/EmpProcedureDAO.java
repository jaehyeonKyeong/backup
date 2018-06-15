package day0601;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;
import properties.DataBaseConnection;

public class EmpProcedureDAO {
	private static EmpProcedureDAO ep_dao;

	private EmpProcedureDAO() {

	}

	public static EmpProcedureDAO getInstance() {
		if (ep_dao == null) {
			ep_dao = new EmpProcedureDAO();
		}
		return ep_dao;
	}// getInstance

	private static Connection getConnection() throws SQLException {
		Connection con = null;
		DataBaseConnection dbc = DataBaseConnection.getInstance();
		try {
			Class.forName(dbc.getDriver());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 1.드라이버 로딩
		con = DriverManager.getConnection(dbc.getUrl(), dbc.getId(), dbc.getPass());

		// 2.연결 얻기
		return con;
	}

	public List<EmpVO> selectAllEmp() throws SQLException {
		List<EmpVO> list = new ArrayList<>();
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
			// 1.
			// 2.
			con = getConnection();
			// 3.
			cstmt = con.prepareCall("{call proc_all_cp_emp(?)}");
			// 4.
			// out parameter에 할당 된 값을 저장하기 위해 bind변수를 등록
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			// 5.
			cstmt.execute();
			// 6.아웃 파라메터에 저장된 값 받기
			rs = (ResultSet) cstmt.getObject(1);

			EmpVO ev = null;
			while (rs.next()) {

				// 데이터의 흐름 (D) : D1.테이블의 레코드(Tuple,Row)를 VO에 저장
				ev = new EmpVO(rs.getInt("empno"), rs.getInt("sal"), rs.getInt("comm"), rs.getString("ename"),
						rs.getString("hiredate"));
				// D2. VO를 list에 저장(조회된 모든 레코드가 list방에 저장
				list.add(ev);
			}

		} finally {
			// 7.
			if (rs != null) {
				rs.close();
			}
			if (cstmt != null) {
				cstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return list;
	}

	public static void main(String[] args) {
		EmpProcedureDAO e = EmpProcedureDAO.getInstance();
		try {
			e.selectAllEmp();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public String insertCpEmp(EmpInsertVO ev) throws SQLException {
		String msg = "";
		Connection con = null;
		CallableStatement cstmt = null;

		try {

			// 1.드라이버얻기
			// 2.connection얻기
			con = getConnection();
			// 3.쿼리문 생성객체 얻기
			cstmt = con.prepareCall("{call insert_cp_emp(?,?,?,?,?)}");
			// 4.바인드 변수에 값넣기

			// in parameter
			cstmt.setInt(1, ev.getEmpno());
			cstmt.setString(2, ev.getEname());
			cstmt.setInt(3, ev.getSal());
			cstmt.setInt(4, ev.getComm());

			// out parameter
			cstmt.registerOutParameter(5, Types.VARCHAR);

			// 5.프로시저 실행
			cstmt.executeQuery();
			// 6. outparameter에 존재하는 값 받기
			msg = cstmt.getString(5);

		} finally {
			if (cstmt != null) {
				cstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return msg;
	}

	public String updateCpEmp(EmpUpdateVO euv) throws SQLException {
		String msg = "";

		Connection con = null;
		CallableStatement cstmt = null;

		try {

			con = getConnection();
			cstmt = con.prepareCall("{call update_cp_emp(?,?,?)}");

			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setInt(2, euv.getEmpno());
			cstmt.setInt(3, euv.getSal());

			cstmt.executeQuery();
			msg = cstmt.getString(1);

		} finally {
			if (cstmt != null) {
				cstmt.close();
			}
			if (con != null) {
				cstmt.close();
			}
		}

		return msg;
	}

	public String deleteCpEmp(int empno) throws SQLException {
		String msg = "";
		Connection con = null;
		CallableStatement cstmt = null;
		try {
			
			// 1.
			// 2.
			con=getConnection();
			// 3.
			cstmt=con.prepareCall("{call delete_cp_emp(?,?)}");
			// 4.
			cstmt.setInt(1, empno);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			// 5.
			cstmt.execute();
			// 6.
			msg=cstmt.getString(2);
			
		} finally {
			// 7.
			if(cstmt!=null) {cstmt.close();}
			if(con!=null) {con.close();}
		}
		return msg;
	}

}// class
