package day0601;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import properties.DataBaseConnection;

/**
 * ��ȸ�ϴ� ���̺��� �÷������� ���� �� ����ϴ� ResultSetMetaData���
 * 
 * @author owner
 */
public class UseResultSetMetaData {
	public UseResultSetMetaData() throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;

		DataBaseConnection dbc = DataBaseConnection.getInstance();

		try {
			// 1. ����̹� �ε�
			Class.forName(dbc.getDriver());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			// 2.
			con = DriverManager.getConnection(dbc.getUrl(), dbc.getId(), dbc.getPass());
			// 3.
			String selectQuery = "select * from dept";
			pstmt = con.prepareStatement(selectQuery);
			// 4.
			// 5.
			rs = pstmt.executeQuery();
			// cursor�� ������� ���� ResultSet���� MetaData�� ��´�
			rsmd = rs.getMetaData();
			// �÷��� ���� ���
			// System.out.println("�÷��� ���� :"+rsmd.getColumnCount());
			// System.out.println("ó�� �÷��� :"+rsmd.getColumnName(1));
			// System.out.print("ó�� �÷� ��������(ũ��) : "+rsmd.getColumnTypeName(1)+"(");
			// System.out.println(rsmd.getPrecision(1)+")");

			System.out.println("��ȣ\t�÷���\t��������(ũ��)\tNULL ���");
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				System.out.println(i + "\t" + rsmd.getColumnLabel(i) + "\t" + rsmd.getColumnTypeName(i) + "("
						+ rsmd.getPrecision(i) + ")\t"+(rsmd.isNullable(i)==0?"NOT NULL":""));
			}

		} finally {
			// 6.
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}

	}// constructor

	public static void main(String[] args) {
		try {
			new UseResultSetMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// main

}// UseResultSetMetaData


