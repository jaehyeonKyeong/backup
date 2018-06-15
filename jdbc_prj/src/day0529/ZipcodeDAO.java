package day0529;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ZipcodeDAO {
	private Connection getConnection() throws SQLException{
		Connection con=null;
		//1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.연결 얻기
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String id="scott";
		String pass="1111";
		
		con=DriverManager.getConnection(url, id, pass);
		
		return con;
	}//getConnection
	
	public List<ZipcodeVO> selectZipcode(String dong) throws SQLException{
		List<ZipcodeVO> list= new ArrayList<>();
		
		Connection con =null;
		Statement stmt=null;
		ResultSet rs=null;
		
		//05-31-2018 코드 추가
		PreparedStatement pstmt=null;
	
		try {
			con=getConnection();
//			stmt=con.createStatement();
			StringBuilder selectZipcode=new StringBuilder();
			//%를 preparedStatement 에서 사용하려면 %를 '로 묶어 일반 문자열로 변경한 후 ||를 사용하여 bind변수와 연결한다.
			selectZipcode.append("select zipcode,sido,gugun,dong,nvl(bunji,' ') bunji").append(" from zipcode").append(" where dong like ?||'%'");
			pstmt=con.prepareStatement(selectZipcode.toString());
			pstmt.setString(1, dong);
			rs=pstmt.executeQuery();
//			rs=stmt.executeQuery(selectZipcode.toString());
			
//			ZipcodeVO zv=null;
//			while(rs.next()) {
//				zv=new ZipcodeVO(rs.getString("zipcode"), rs.getString("sido"), rs.getString("gugun"), rs.getString("dong"), rs.getString("bunji"));
//				list.add(zv);
//			}
			
		}finally {
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
			if(con!=null) {con.close();}
		}
		
		
		
		return list;
	}
}







