package day0531;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class UseProperties {
	
	public UseProperties() throws FileNotFoundException, IOException {
		//1.Properties 생성
		Properties prop=new Properties();
		//2.properties 파일 로딩
		prop.load(new InputStreamReader(new FileInputStream("C:/dev/workspace/jdbc_prj/src/day0531/test.properties"), "UTF-8"));
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("addr"));
		System.out.println(prop.getProperty("age"));
		
	}//constructor
	
	public static void main(String[] args) {
		try {
			new UseProperties();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
