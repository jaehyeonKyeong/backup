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
		// 1.����̹� �ε�
		try {
			Class.forName(dbc.getDriver());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			// 2.���� ���
			con=DriverManager.getConnection(dbc.getUrl(), dbc.getId(), dbc.getPass());
			// 3.���ν��� ���� ��ü ���
			cstmt=con.prepareCall("{call proc_hello(?,?)}");
			// 4.bind���� �� �ֱ�
			cstmt.setString(1, "���¹�");
			// 5.outParameter�� ����� ���� ����ϱ�
			cstmt.registerOutParameter(2, Types.VARCHAR);
			// 6.����
			cstmt.execute();
			// 7.outParameter�� ����� �� ���
			String msg=cstmt.getString(2);
			System.out.println(msg);
		} finally {
			// 8.���� ����
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
