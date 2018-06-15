package day0601;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import properties.DataBaseConnection;

public class UseHelloProcedure {
	public UseHelloProcedure() throws SQLException {
		Connection con = null;
		CallableStatement cstmt = null;

		DataBaseConnection dbc=DataBaseConnection.getInstance();
		// 1.드라이버 로딩
		try {
			Class.forName(dbc.getDriver());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			// 2.연결 얻기
			con=DriverManager.getConnection(dbc.getUrl(), dbc.getId(), dbc.getPass());
			// 3.프로시저 실행 객체 얻기
			cstmt=con.prepareCall("{call proc_hello(?,?)}");
			// 4.bind변수 값 넣기
			cstmt.setString(1, "지승민");
			// 5.outParameter로 저장될 값을 등록하기
			cstmt.registerOutParameter(2, Types.VARCHAR);
			// 6.실행
			cstmt.execute();
			// 7.outParameter에 저장된 값 얻기
			String msg=cstmt.getString(2);
			System.out.println(msg);
		} finally {
			// 8.연결 끊기
			if (cstmt != null) {
				cstmt.close();
			}
			if (con != null) {
				con.close();
			}

		}
	}// constructor

	public static void main(String[] args) {
		try {
			new UseHelloProcedure();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// main

}// UseHelloProcedure
