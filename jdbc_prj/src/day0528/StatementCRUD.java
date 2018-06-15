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
	 * DB���� �۾� 1.����̹� �ε� 2.connection ���
	 * 
	 * @return
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			// 1.����̹� �ε�
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch
			// 2.connection ���
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id = "scott";
		String pass = "1111";

		con = DriverManager.getConnection(url, id, pass);

		return con;
	}

	/**
	 * �����ȣ ����� ���� ���ʽ��� �Է¹޾� cp_emp���̺� �߰��ϴ� ��
	 * 
	 * @param cev
	 * @throws SQLException
	 */
	public void insertCpEmp(CpEmpVO cev) throws SQLException {
		// 1,2. connection ���
		Connection con = null;
		Statement stmt = null;
		try {
			con = getConnection();
			// 3. ������ ������ü ���
			stmt = con.createStatement();
			// 4. ������ ����� ��� ���
			// String insertQuery = "insert into
			// cp_emp(empno,ename,hiredate,sal,comm)values(" + cev.getEmpno() + ",'"
			// + cev.getEname() + "',sysdate," + cev.getSal() + "," + cev.getComm() + ")";
			StringBuilder insertQuery = new StringBuilder();
			insertQuery.append("insert into cp_emp(empno,ename,hiredate,sal,comm)values(").append(cev.getEmpno())
					.append(",'").append(cev.getEname()).append("',sysdate,").append(cev.getSal()).append(",")
					.append(cev.getComm()).append(")");
			int cnt = stmt.executeUpdate(insertQuery.toString());
			System.out.println(cnt + "�� �߰�");
		} finally {
			// 5. ���� ����
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} // end final
	}// insertCpEmp

	/**
	 * �����ȣ ����� ������ �Է¹޾� �����ȣ�� �ش��ϴ� ����� ����� ������ �����ϴ� ��
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
			// 3.������ ������ü ���
			stmt = con.createStatement();
			// 4.������ ���� �� ��� ���
			// String updateCpEmp = "update cp_emp set ename='" + cevu.getEname() + "',
			// sal=" + cevu.getSal()
			// + " where empno=" + cevu.getEmpno();
			StringBuilder updateCpEmp = new StringBuilder();
			updateCpEmp.append("update cp_emp set ename='").append(cevu.getEname()).append("', sal=")
					.append(cevu.getSal()).append(" where empno=").append(cevu.getEmpno());
			cnt = stmt.executeUpdate(updateCpEmp.toString());
		} finally {
			// 5.�������
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
	 * �����ȣ�� �Է¹޾� CP_EMP���̺��� �����ϴ� ��
	 * 
	 * @param empno
	 * @return ������ ���
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
			// 5. ���� ����
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
			while (rs.next()) {//������ ����Ǿ� ��ȸ�� ���ڵ尡 �����Ѵٸ�
				empno=rs.getInt("empno");
				ename=rs.getString("ename");
				sal=rs.getInt("sal");
				comm=rs.getInt("comm");
				hi1=rs.getDate("hi1");
				hi2=rs.getString("hi2");
				//��ȸ����� vo�� ����
				ceav=new CpEmpAllVO(empno,sal,comm,ename,hi2,hi1);
				//��ȸ����� ���� vo�� list�� �߰�(ceav�� ���ڵ��ϳ��� �����Եǰ�,�ݺ����� �ɶ����� ���� �̸��� ��ü�� �����ϰ� �Ǿ�
				//garbage collector�� �����ϰ� �Ǵµ�, garbage collector�� �������� �ʵ��� list�� �߰��Ѵ�.
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
