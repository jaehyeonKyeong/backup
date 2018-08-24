package ajax0823;

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

import day0806.DeptVO;

public class AjaxDAO {
	public static AjaxDAO a_dao;

	private AjaxDAO() {

	}

	public static AjaxDAO getInstance() {
		if (a_dao == null) {
			a_dao = new AjaxDAO();
		}
		return a_dao;
	}

	private Connection getConnection() throws SQLException {
		Connection con=null;
		try{
			//1. JNDI 사용객체 생성
			Context ctx=new InitialContext();
			//2. DBCP에서 객체 얻기
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/dbcp");
			//3. Connection얻기
			con=ds.getConnection();
		}catch(NamingException ne) {
			ne.printStackTrace();
		}
		return con;
	}
	
	public List<DeptVO> selectAllDept() throws SQLException{
		List<DeptVO> list=new ArrayList<DeptVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			//4. 쿼리문수행 객체 얻기
			String selectDept="select deptno,dname,loc from dept";
			pstmt=con.prepareStatement(selectDept);
			
			//5. 쿼리문 수행후 결과 얻기
			rs=pstmt.executeQuery();
			
			DeptVO dv=null;
			while( rs.next() ){
				dv=new DeptVO( rs.getInt("deptno"),rs.getString("dname"),
							rs.getString("loc"));
				list.add(dv);
			}//end while
		}finally {
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		
		return list;
	}
	public List<EmpVO> selectEmp(int deptno) throws SQLException{
		List<EmpVO> list=new ArrayList<EmpVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			//4. 쿼리문수행 객체 얻기
			String selectEmp="select empno,ename,job,sal,to_char(hiredate,'yyyy-mm-dd') hiredate from emp where deptno=?";
			pstmt=con.prepareStatement(selectEmp);
			//4-1. 바인드 변수에 값넣기
			pstmt.setInt(1, deptno);
			
			//5. 쿼리문 수행후 결과 얻기
			rs=pstmt.executeQuery();
			
			EmpVO ev=null;
			while( rs.next() ){
				ev=new EmpVO(rs.getInt("empno"),rs.getInt("sal"),rs.getString("ename"),rs.getString("job"),rs.getString("hiredate"));
				list.add(ev);
			}//end while
		}finally {
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		
		return list;
	}
	public List<LatLngVO> selectLatLng(int loc) throws SQLException{
		List<LatLngVO> list=new ArrayList<LatLngVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			//4. 쿼리문수행 객체 얻기
			String selectLag="select lat,lng,title from lat_lng where loc=?";
			pstmt=con.prepareStatement(selectLag);
			//4-1. 바인드 변수에 값넣기
			pstmt.setInt(1, loc);
			
			//5. 쿼리문 수행후 결과 얻기
			rs=pstmt.executeQuery();
			
			LatLngVO lv=null;
			while( rs.next() ){
				lv=new LatLngVO(rs.getString("title"),rs.getDouble("lat"),rs.getDouble("lng"));
				list.add(lv);
			}//end while
		}finally {
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		
		return list;
	}

}
