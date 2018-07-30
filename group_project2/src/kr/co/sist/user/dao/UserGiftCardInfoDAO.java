package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.properties.DataBaseConnection;
import kr.co.sist.user.vo.LoginVO;
import kr.co.sist.user.vo.UserGiftCardInfoVO;
import kr.co.sist.user.vo.UserGiftCardVO;
import kr.co.sist.user.vo.UserInfoVO;

public class UserGiftCardInfoDAO {
	// 1.드라이버로딩
			private static UserGiftCardInfoDAO u_dao;
			private UserGiftCardInfoDAO() {
			}
			public static UserGiftCardInfoDAO getInstance() {
				if (u_dao == null) {
					u_dao = new UserGiftCardInfoDAO();
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

			public void insertUserGiftCard(UserGiftCardInfoVO ugci_vo) throws SQLException {
				Connection con = null;
				PreparedStatement pstmt = null;
				try {
					//1. 드라이버로딩
					//2.
					con = getConnection();
						String InsertUserGiftCard = 
					"insert into USER_GIFT_CARD (code_number, id, card_name, using_card, add_date) values(?,?,?,?,sysdate)";
						pstmt=con.prepareStatement(InsertUserGiftCard);
						//4.
						pstmt.setString(1,ugci_vo.getGiftCardNum());
						pstmt.setString(2,ugci_vo.getId());
						pstmt.setString(3,ugci_vo.getGiftCardName());
						pstmt.setString(4,ugci_vo.getUse());
						pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					if(pstmt!=null) {pstmt.close();}
					if(con!=null) {con.close();}
				}//end finally
				
			}//insertMember
			
			/*
			 	매개변수 id=로그인시 받아올 아이디
			 */
			public List<UserGiftCardVO> selectGiftCard(String id) throws SQLException {
//				String id,pass="";
				Connection con=null;
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				UserGiftCardVO ugc=null;
				List<UserGiftCardVO> lUgc=new ArrayList<>();
				try {
					con=getConnection();
				//3.
					String UserSelectLogin=
							"select add_date,card_name,using_card from user_gift_card where id=? ";
						
					pstmt=con.prepareStatement(UserSelectLogin);
					//4.bind변수에 값 넣기
					pstmt.setString(1, id);
					
				//5.
					rs=pstmt.executeQuery();
					while(rs.next()) {
						ugc=new UserGiftCardVO();
						ugc.setDateIssued(rs.getString("add_date"));
						ugc.setGiftCardName(rs.getString("card_name"));//USING_CARD, CARD_NAME
						ugc.setUse(rs.getString("using_card"));
						lUgc.add(ugc);
					}//end if
					
				}finally {
				//6.연결끊기
					if(rs !=null) {rs.close();} //end if
					if(pstmt !=null) {pstmt.close();} //end if
					if(con !=null) {con.close();} //end if
				}//end finally
				return lUgc;
			}//selectLogin
			
	
}
