package kr.co.sist.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {
	private static DataBaseConnection dbc;
	private String driver;
	private String url;
	private String id;
	private String pass;
	private DataBaseConnection() throws FileNotFoundException, IOException {
		Properties prop=new Properties();
		prop.load(new FileInputStream("C:/Users/kimkn/git/backup/group_project2/src/kr/co/sist/properties/database.properties"));
		
		driver=prop.getProperty("driver");
		url=prop.getProperty("url");      
		id=prop.getProperty("id");
		pass=prop.getProperty("pass");
System.out.println(  driver +" / "+ url +" / "+ id+" / "+ pass);
	}//DataBaseConnection

	public static DataBaseConnection getInstance() {
		if(dbc==null) {
			try {
				dbc=new DataBaseConnection();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end catch	
		}//end if

		return dbc;
	}//getInstance

	public Connection getConnection()throws SQLException {
		Connection con=null;

		//1. 드라이버 로딩
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end catch

		//2. 커넥션 얻기
		con=DriverManager.getConnection(url,id, pass);
		return con;


	}//getConnection



	public static DataBaseConnection getDbc() {
		return dbc;
	}
	public String getDriver() {
		return driver;
	}
	public String getUrl() {
		return url;
	}
	public String getId() {
		return id;
	}
	public String getPass() {
		return pass;
	}


//	public static void main(String[] args)throws SQLException {
//		System.out.println(getInstance().getConnection());
//
//	}//main

}//class
