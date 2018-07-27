package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.properties.DataBaseConnection;

public class LoginDAO {
	private static LoginDAO l_dao;
	private LoginDAO() {
		
	}
	public static LoginDAO getInstance() {
		if(l_dao == null) {
			l_dao= new LoginDAO();
		}
		return l_dao;
	}
	
	private Connection getConnection() throws SQLException{
		Connection con=null;
		DataBaseConnection dbc=DataBaseConnection.getInstance();
		String driver=dbc.getDriver();
		String url=dbc.getUrl();
		String id=dbc.getId();
		String pass=dbc.getPass();
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		con=DriverManager.getConnection(url, id, pass);
		
		
		
		
		
		return con;
	}
	
	public boolean selectLogin(String id,String pass) throws SQLException{
		boolean flag=false;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
//		id=injectionBlock(id);
//		pass=injectionBlock(pass);
		try {
			con=getConnection();
			String selectLogin="select id from admin where id=? and password=?";
			pstmt=con.prepareStatement(selectLogin);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				flag=true;
			}
			
		}finally {
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		
		return flag;
	}
	/**
	 * Statement 를 사용하면 SqlInjection이 발생할수 있으므로 입력되는 문자열의 쿼리와 관련된 문자열은 모두 치환시킨다.
	 * injection 대상 문자열 ' union,공백,select,insert,update,delet,where,--
	 * @param temp
	 * @return
	 */
	public String injectionBlock(String temp) {
		temp=temp.replaceAll("'", "").replaceAll("union","").replaceAll("--","").replaceAll(" ","");
		return temp;
	}
}//LoginDAO
