package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.properties.DataBaseConnection;
import kr.co.sist.user.view.UserDetailReview;
import kr.co.sist.user.vo.LoginVO;
import kr.co.sist.user.vo.SignUpVO;
import kr.co.sist.user.vo.UserDetailReviewVO;
import kr.co.sist.user.vo.UserInfoVO;
import kr.co.sist.user.vo.UserReviewVO;
import kr.co.sist.user.vo.UserShopVO;

public class MemberDAO {
	// 1.드라이버로딩
		private static MemberDAO m_dao;
		private MemberDAO() {
		}
		public static MemberDAO getInstance() {
			if (m_dao == null) {
				m_dao = new MemberDAO();
			}
			return m_dao;
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

		
		public int selectPoint(String id) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs=null;
			int point=0;
			try {
				//1. 드라이버로딩
				//2.
				con = getConnection();
					String selectPoint = 
							"select point from fp_user where id=?";
							pstmt=con.prepareStatement(selectPoint);
					//4.
					pstmt.setString(1,id);
					rs=pstmt.executeQuery();
					if(rs.next()) {
						point=rs.getInt("point");
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(pstmt!=null) {pstmt.close();}
				if(con!=null) {con.close();}
				if(rs!=null) {rs.close();}
			}//end finally
			
			return point;
		}//insertMember
		public List<UserReviewVO> selectReview(String id) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs=null;
			String reviewTitle="";
			String restaurantNumber="";
			int grades=0;
			String reviewNumber="";
			UserReviewVO urv=null;
			List<UserReviewVO> lUrv=new ArrayList<>();
			try {
				con = getConnection();
					String UserSelectReview = 
							"select review_number,review_title,restaurant_number,grades from review where id=?";
							pstmt=con.prepareStatement(UserSelectReview);
					//4.bind변수에 값 넣기
					pstmt.setString(1,id);
					
					rs=pstmt.executeQuery();
					while(rs.next()) {
						
						reviewTitle=rs.getString("review_title");
						restaurantNumber=rs.getString("restaurant_number");
						grades=rs.getInt("grades");
						reviewNumber=rs.getString("review_number");
						urv=new UserReviewVO(reviewTitle,restaurantNumber,reviewNumber,grades);
						lUrv.add(urv);
					}
					
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(pstmt!=null) {pstmt.close();}
				if(con!=null) {con.close();}
				if(rs!=null) {rs.close();}
			}//end finally
			return lUrv;
		}//selectReview
		
		public UserDetailReviewVO selectDetailReview(String id,String reviewNum) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs=null;
			String review_image="";
			String review_contents="";
			int grades=0;
			UserDetailReviewVO udrv=null;
			
			try {
				con = getConnection();
				String UserSelectReview = 
						"select review_image,review_contents,grades from review where id=? and review_number=?";
				pstmt=con.prepareStatement(UserSelectReview);
				//4.bind변수에 값 넣기
				pstmt.setString(1,id);
				pstmt.setString(2,reviewNum);
				
				rs=pstmt.executeQuery();
				if(rs.next()) {
					review_image=rs.getString("review_image");
					review_contents=rs.getString("review_contents");
					grades=rs.getInt("grades");
					
					udrv=new UserDetailReviewVO(review_image, review_contents, grades);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(pstmt!=null) {pstmt.close();}
				if(con!=null) {con.close();}
				if(rs!=null) {rs.close();}
			}//end finally
			return udrv;
		}//selectReview
		
		
}
