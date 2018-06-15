package day0528;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * R-DBMS(Relationship DataBase Management System)와 연동
 * @author owner
 */
public class UseConnection {
	
	public UseConnection() {
		
		try {

			//1.드라이버 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버 로딩 성공!");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//endCatch
		
		//2.로딩된 드라이버를 사용하여 Connection얻기
		
		String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id="scott";
		String pass="1111";
		
		try {
			Connection con=DriverManager.getConnection(url, id, pass);
			System.out.println("DBMS와 연결 얻기 : "+con);

			//3. 쿼리문 생성객체 얻기
			Statement stmt=con.createStatement();

			//4. 쿼리문 수행후 결과 얻기
			String delete_sql="delete from cp_emp where empno=1111";
			String sql="insert into cp_emp(empno,ename,hiredate,sal,comm)values(1111,'지승민',sysdate,100,0)";

			int d_cnt=stmt.executeUpdate(delete_sql);
			int cnt=stmt.executeUpdate(sql);

			System.out.println(d_cnt+"건 추가");
			System.out.println(cnt+"건 추가");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}//constructor

	public static void main(String[] args) {
		new UseConnection();

	}//main

}