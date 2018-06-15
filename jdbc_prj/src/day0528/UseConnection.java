package day0528;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * R-DBMS(Relationship DataBase Management System)�� ����
 * @author owner
 */
public class UseConnection {
	
	public UseConnection() {
		
		try {

			//1.����̹� �ε�
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("����̹� �ε� ����!");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//endCatch
		
		//2.�ε��� ����̹��� ����Ͽ� Connection���
		
		String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id="scott";
		String pass="1111";
		
		try {
			Connection con=DriverManager.getConnection(url, id, pass);
			System.out.println("DBMS�� ���� ��� : "+con);

			//3. ������ ������ü ���
			Statement stmt=con.createStatement();

			//4. ������ ������ ��� ���
			String delete_sql="delete from cp_emp where empno=1111";
			String sql="insert into cp_emp(empno,ename,hiredate,sal,comm)values(1111,'���¹�',sysdate,100,0)";

			int d_cnt=stmt.executeUpdate(delete_sql);
			int cnt=stmt.executeUpdate(sql);

			System.out.println(d_cnt+"�� �߰�");
			System.out.println(cnt+"�� �߰�");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}//constructor

	public static void main(String[] args) {
		new UseConnection();

	}//main

}