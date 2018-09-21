package day0827;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle.Control;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CarDAO {
	
	private static CarDAO c_dao;
	
	private CarDAO() {
		
	}
	public static CarDAO getinstance() {
		if(c_dao==null) {
			c_dao=new CarDAO();
			
		}
		return c_dao;
	}
	
	private Connection getConnection()throws SQLException{
		Connection con=null;
		//DBCP
		
		try {
			//1. JNDI를 사용할 수 있는 객체 생성
			Context ctx=new InitialContext();
			//2. DataSource 얻기
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/dbcp");
			//3. Connection얻기
			con=ds.getConnection();
			
		} catch (NamingException ne) {
			
			ne.printStackTrace();
		}//end catch
		
		
		
		return con;
	}

	public List<String> selectMarker(String country)throws SQLException{
		List<String> list=new ArrayList<String>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//3. connection 얻기
			con=getConnection();
			//4.
			String selectMaker="select maker from car_country where country=?";
			pstmt=con.prepareStatement(selectMaker);
			pstmt.setString(1, country);
			//5.
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("maker"));
			}
			
		}finally {
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}//end finally
		
		return list;
	}
	
	public List<String> selectModel(String maker)throws SQLException{
		List<String> list=new ArrayList<String>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//3. connection 얻기
			con=getConnection();
			//4.
			String selectModel="select model from car_maker where maker=?";
			pstmt=con.prepareStatement(selectModel);
			pstmt.setString(1, maker);
			//5.
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("model"));
			}
			
			
		}finally {
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}//end finally
		
		return list;
	}
	public List<CarVO> selectCar(String model)throws SQLException{
		List<CarVO> list=new ArrayList<CarVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//3. connection 얻기
			con=getConnection();
			//4.
			StringBuffer selectCar=new StringBuffer();
			selectCar
			.append(" select car_option,car_img,to_char(hiredate,'yyyy-mm-dd') hiredate,to_char(price,'999,999,999,999') price,cc from ")
			.append(" ( select rownum rnum,car_option,car_img,hiredate,price,cc from ")
			.append("  ( select car_option,car_img,hiredate,price,cc from car_model")
			.append(" where model=? ")
			.append(" order by cc desc)) ");
			pstmt=con.prepareStatement(selectCar.toString());
			pstmt.setString(1, model);
			rs=pstmt.executeQuery();
			
			CarVO cv=null;
			while(rs.next()) {
				cv=new CarVO(rs.getString("car_option"),rs.getString("car_img"),rs.getString("hiredate"),rs.getString("price"),rs.getInt("cc"));
				list.add(cv);
			}
			
		}finally {
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}//end finally
		
		return list;
	}
	
}
