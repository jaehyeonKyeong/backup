package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.licensee.controller.RestaurantManagementViewEvt;
import kr.co.sist.licensee.controller.licenssenameDate;
import kr.co.sist.properties.DataBaseConnection;
import kr.co.sist.user.controller.LoginEvt;
import kr.co.sist.user.vo.LoginVO;
import kr.co.sist.user.vo.SignUpVO;
import kr.co.sist.user.vo.UserInfoVO;


public class LoginDAO {
	// 1.����̹��ε�
	private static LoginDAO l_dao;
	private LoginDAO() {
	}
	public static LoginDAO getInstance() {
		if (l_dao == null) {
			l_dao = new LoginDAO();
		}
		return l_dao;
		
	}

	@SuppressWarnings("unused")
	private Connection getConnection() throws SQLException {
		Connection con = null;
		DataBaseConnection dbc = DataBaseConnection.getInstance();
		String driver = dbc.getDriver();
		String url = dbc.getUrl();
		String id = dbc.getId();
		String pass = dbc.getPass();
	
		// 1. ����̹��ε�
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//2.Ŀ�ؼ� ���
		System.out.println("ȣ�ηη�"+url+"/"+id+"/"+pass);
		con = DriverManager.getConnection(url, id, pass);
		System.out.println("�α��δٿ�"+id+"/"+pass+"/"+driver);
		return con;
	}
	
	/**
	 * ����� �α���
	 * @param lv
	 * @return
	 * @throws SQLException
	 */
	public licenssenameDate licenseeLogin(LoginVO lv) throws SQLException {
		boolean flag=false;
		String id,pass="";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		id=lv.getId();
		pass=lv.getPassword();
		RestaurantManagementViewEvt rmve=null;
		licenssenameDate Id=null;
		try {
			con=getConnection();
			//3.
			String UserSelectLogin=
					"select name from "+lv.getTableName()+" where id=? and PASSWORD=?";
			
			pstmt=con.prepareStatement(UserSelectLogin);
			//4.bind������ �� �ֱ�
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			//5.
			rs=pstmt.executeQuery();
			if(rs.next()) {
				Id=new licenssenameDate(rs.getString("name"));
			}//end if
		}finally {
			//6.�������
			if(rs !=null) {rs.close();} //end if
			if(pstmt !=null) {pstmt.close();} //end if
			if(con !=null) {con.close();} //end if
		}//end finally
		return Id; 
	}//selectLogin
	/**
	 * ���� �α���
	 * @param lv
	 * @return
	 * @throws SQLException
	 */
	public UserInfoVO selectLogin(LoginVO lv) throws SQLException {
		String id,pass="";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		id=lv.getId();
		pass=lv.getPassword();
		UserInfoVO uiv=null;
		try {
			con=getConnection();
		//3.
			String UserSelectLogin=
					"select id,point,name from "+lv.getTableName()+" where id=? and PASSWORD=?";
				
			pstmt=con.prepareStatement(UserSelectLogin);
			//4.bind������ �� �ֱ�
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
		//5.
			rs=pstmt.executeQuery();
			if(rs.next()) {
				uiv=new UserInfoVO();
				uiv.setId(rs.getString("id"));
				uiv.setPoint(rs.getInt("point"));
				uiv.setName(rs.getString("name"));
			}//end if
		}finally {
		//6.�������
			if(rs !=null) {rs.close();} //end if
			if(pstmt !=null) {pstmt.close();} //end if
			if(con !=null) {con.close();} //end if
		}//end finally
		return uiv;
	}//selectLogin
	
	
	
	public void insertMember(SignUpVO suv) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//1. ����̹��ε�
			//2.
			con = getConnection();
				String InsertMember = 
			"insert into "+suv.getTableName()+"(id,password,name,input_date) values(?,?,?,sysdate)";
				pstmt=con.prepareStatement(InsertMember);
				//4.
				pstmt.setString(1,suv.getId());
				pstmt.setString(2,suv.getPassword());
				pstmt.setString(3,suv.getName());
				pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}//end finally
		
		
	}//insertMember
	
	//�α��� �� ����� �̸��� ����������
	public void nameSelect() throws SQLException{
		
	}
}
