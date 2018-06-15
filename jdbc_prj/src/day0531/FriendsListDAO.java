package day0531;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import day0530.ColumnVO;
import properties.DataBaseConnection;

public class FriendsListDAO {
	private static FriendsListDAO fl_dao;
	
	private FriendsListDAO() {
		
	}
	public static FriendsListDAO getInstance() {
		if(fl_dao==null) {
			fl_dao=new FriendsListDAO();
		}
		return fl_dao;
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
	public List<FriendsListVO> selectColumnInfo() throws SQLException {
		List<FriendsListVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String selectFriendsList ="Select name,age,phone_num from Friends_list";
			
			pstmt = con.prepareStatement(selectFriendsList);
			rs = pstmt.executeQuery();

			FriendsListVO flVO = null;

			while (rs.next()) {
				flVO = new FriendsListVO(rs.getString("name"), rs.getString("phone_num"),
						rs.getInt("age"));
				list.add(flVO);
			}
		} finally {
			dbClose(rs, pstmt, con);
		}
		return list;
	}
	public void insertColumnInfo(FriendsListVO flVO) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String selectFriendsList ="insert into Friends_list(name,age,phone_num)values(?,?,?)";
			pstmt = con.prepareStatement(selectFriendsList);
			pstmt.setString(1, flVO.getName());
			pstmt.setInt(2, flVO.getAge());
			pstmt.setString(3, flVO.getPhone_num());
			rs = pstmt.executeQuery();
	
		} finally {
			dbClose(rs, pstmt, con);
		}
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
	}//close

}
