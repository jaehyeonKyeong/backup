package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.properties.DataBaseConnection;
import kr.co.sist.user.vo.LoginVO;
import kr.co.sist.user.vo.SignUpVO;
import kr.co.sist.user.vo.UserInfoVO;
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
}
