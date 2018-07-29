package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import kr.co.sist.properties.DataBaseConnection;
import kr.co.sist.user.vo.UserShopVO;

public class UserShopDAO {
	// 1.드라이버로딩
			private static UserShopDAO u_dao;
			public UserShopDAO() {
			}
			public static UserShopDAO getInstance() {
				if (u_dao == null) {
					u_dao = new UserShopDAO();
				}
				return u_dao;
			}

			@SuppressWarnings("unused")
			private Connection getConnection() throws SQLException {
				Connection con = null;
				DataBaseConnection dbc = DataBaseConnection.getInstance();
				String driver = dbc.getDriver();
				String url = dbc.getUrl();
				String id = dbc.getId();
				String pass = dbc.getPass();
				// 1. 드라이버로딩
				try {
					Class.forName(driver);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				//2.커넥션 얻기
				con = DriverManager.getConnection(url, id, pass);

				return con;
			}
			
			public void updateUserInfo(String id,int point) throws SQLException {
				Connection con=null;
				PreparedStatement pstmt=null;
					//1.
					//2.
						try {
							con=DataBaseConnection.getInstance().getConnection();
					//3.
						String updateUserInfo=
								"update fp_user set point=? where id=?";
						pstmt=con.prepareStatement(updateUserInfo);
					//4.
						pstmt.setInt(1, point);
						pstmt.setString(2, id);
					//5.
						pstmt.executeUpdate();
						}finally {
							if(pstmt !=null) {pstmt.close();} //end if
							if(con !=null) {con.close();} //end if
						}
			}
			

}
