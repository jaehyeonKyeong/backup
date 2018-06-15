package properties;

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
	
	
	private DataBaseConnection() throws FileNotFoundException,IOException{
		Properties prop=new Properties();
		prop.load(new FileInputStream("C:/dev/workspace/jdbc_prj/src/properties/database.properties"));
		driver=prop.getProperty("driver");
		url=prop.getProperty("url");
		id=prop.getProperty("id");
		pass=prop.getProperty("pass");
		
	}//DataBaseConnection
	public static DataBaseConnection getInstance() {
		if(dbc == null) {
			try {
				dbc=new DataBaseConnection();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dbc;
	}
	
	public Connection getConnection() throws SQLException {
		Connection con=null;
		//1.driver 로딩
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.connection 얻기
		con=DriverManager.getConnection(url, id, pass);
		
		return con;
		
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
	
	
}
