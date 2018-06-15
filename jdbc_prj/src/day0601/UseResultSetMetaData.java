package day0601;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import properties.DataBaseConnection;

/**
 * 조회하는 테이블의 컬럼정보를 얻을 때 사용하는 ResultSetMetaData사용
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
			// 1. 드라이버 로딩
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
			// cursor의 제어권을 가진 ResultSet에서 MetaData를 얻는다
			rsmd = rs.getMetaData();
			// 컬럼의 정보 얻기
			// System.out.println("컬럼의 갯수 :"+rsmd.getColumnCount());
			// System.out.println("처음 컬럼명 :"+rsmd.getColumnName(1));
			// System.out.print("처음 컬럼 데이터형(크기) : "+rsmd.getColumnTypeName(1)+"(");
			// System.out.println(rsmd.getPrecision(1)+")");

			System.out.println("번호\t컬럼명\t데이터형(크기)\tNULL 허용");
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


