package day0530;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableInfoDAO {
	private static TableInfoDAO t_dao;

	private TableInfoDAO() {
	}// constructor

	public static TableInfoDAO getInstance() {
		if (t_dao == null) {
			t_dao = new TableInfoDAO();
		}
		return t_dao;
	}// getInstance

	private Connection getConnection() throws SQLException {
		Connection con = null;
		try {// 1.
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@211.63.89.140:1521:orcl";
		String id = "scott";
		String pass = "1111";

		con = DriverManager.getConnection(url, id, pass);

		return con;
	}

	private void dbClose(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (con != null) {
			con.close();
		}
	}

	public List<String> selectTableName() throws SQLException {
		List<String> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String selectAllTable = "select tname from tab";
			pstmt = con.prepareStatement(selectAllTable);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("tname"));
			}
		} finally {
			dbClose(rs, pstmt, con);
		}
		return list;
	}

	public List<ColumnVO> selectColumnInfo(String tableName) throws SQLException {
		List<ColumnVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			StringBuilder selectTableInfo = new StringBuilder();
			selectTableInfo.append("select column_name,data_type,nvl(data_precision,data_length) data_length, 		")
					.append("(select ucc.constraint_name		")
					.append("from user_cons_columns ucc where ucc.column_name =utc.column_name and ucc.table_name=?) 		")
					.append("constraint_name		")
					.append("from user_tab_cols utc		")
					.append("where utc.table_name=?		");
			pstmt = con.prepareStatement(selectTableInfo.toString());
			pstmt.setString(1, tableName);
			pstmt.setString(2, tableName);
			rs = pstmt.executeQuery();

			ColumnVO cv = null;

			while (rs.next()) {
				cv = new ColumnVO(rs.getString("column_name"), rs.getString("data_type"),
						rs.getString("constraint_name"), rs.getInt("data_length"));
				list.add(cv);
			}
		} finally {
			dbClose(rs, pstmt, con);
		}
		return list;
	}
}// class
