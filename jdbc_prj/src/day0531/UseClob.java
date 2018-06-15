package day0531;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class UseClob {

	public UseClob() throws SQLException, FileNotFoundException, IOException {
		// Properties를 사용하여 dbms의 연동 정보를 얻는다
		Properties prop_db = new Properties();
		prop_db.load(new FileInputStream("C:/dev/workspace/jdbc_prj/src/day0531/database.properties"));

		String driver = prop_db.getProperty("driver");
		String url = prop_db.getProperty("url");
		String id = prop_db.getProperty("id");
		String pass = prop_db.getProperty("pass");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BufferedReader br = null;
		try {
			// 1.드라이버 로딩
			Class.forName(driver);
			try {
				// 2.연결 얻기
				con=DriverManager.getConnection(url,id,pass);
				// 3.쿼리문 생성객체 얻기
				String selectClob="select num,name,spec,input_date from test_clob";
				pstmt=con.prepareStatement(selectClob);
				// 4.바인드 변수에 값넣기
				// 5.쿼리문 수행후 결과얻기
				rs=pstmt.executeQuery();
				int num=0;
				String name="",spec="",input_date="",temp="";
				
				while(rs.next()) {
					num=rs.getInt("num");
					name=rs.getString("name");
//					spec=rs.getString("spec");
					br=new BufferedReader(rs.getClob("spec").getCharacterStream());
					input_date=rs.getString("input_date");
					System.out.printf("번호 : %d\t이름 : %s\t입력일 : %s\n",num,name,input_date);
					while((temp=br.readLine())!=null) {
						System.out.println("경력사항 : "+temp);
					}
				}//end while
			} finally {
				// 6.연결 끊기
				if (br != null) {
					br.close();
				}
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// constructor

	public static void main(String[] args) {
		try {
			new UseClob();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "DBMS사용 중 문제가 발생하였습니다.");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "연결 정보 파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "파일을 읽어오는 도중 문제가 발생하였습니다.");
			e.printStackTrace();
		} // end catch
	}// main

}// UseClob
