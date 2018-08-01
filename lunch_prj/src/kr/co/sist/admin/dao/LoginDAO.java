package kr.co.sist.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kr.co.sist.properties.DataBaseConnection;


public class LoginDAO {
	private static LoginDAO l_dao;

	
	private LoginDAO() {
	
	}//LoginDAO
	
	public static LoginDAO getInstance() {
		if(l_dao == null) {
			l_dao=new LoginDAO();
		}//end if

		return l_dao;
	}//end if

	private Connection getConnection() throws SQLException {
		Connection con=null;
		DataBaseConnection dbc=DataBaseConnection.getInstance();
		String driver=dbc.getDriver();
		String url=dbc.getUrl();
		String id=dbc.getId();
		String pass=dbc.getPass();
		
		//1.
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}//end catch
		
		con=DriverManager.getConnection(url, id, pass);
		
		return con;
	}//getConnection
	
	public boolean selectLogin(String id,String pass) throws SQLException {
		boolean flag=false;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		//SQLInjection에 대한 문장을 치환
//		id=InjectionBlock(id);
//		pass=InjectionBlock(pass);
		
		try {
			
		//1.
		//2.
			con=getConnection();
		//3.
			String selectLogin=
					"select name from login where id=? and pass=?";
			
			pstmt=con.prepareStatement(selectLogin);
		//4.bind변수에 값 넣기
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
		//5.
			rs=pstmt.executeQuery();
			if(rs.next()) {
				flag=true;
				
			}//end if
			
		}finally {
			
		//6.
			if(rs !=null) {rs.close();} //end if
			if(pstmt !=null) {pstmt.close();} //end if
			if(con !=null) {con.close();} //end if
		}//end finally
		
		return flag;
		
	}//selectLogin
 	
	/**
	 * Statement를 사용하면 SQLInjection이 발생할 수 있으므로 입력되는 문자열의
	 * 쿼리와 관련된 문자열을 모두 치환시킨다.
	 * Injection 대상문자열 : ', union, 공백,select,insert,update,delete,where,--
	 * @param temp
	 * @return
	 */
	public String InjectionBlock(String temp) {
		temp=temp.replace("'", "").replaceAll(" ","")
				.replaceAll("--", "").replaceAll("union","");
		return temp;
	}//injectionBlock
	
}//class
