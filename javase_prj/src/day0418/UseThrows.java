package day0418;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Throws는 method나 constructor뒤에 정의<br>
 * constructor 뒤에 정의한 throws는 객체화 할때 try~catch로 처리하고<br>
 * method 뒤에 정의한 throws는 method를 호출할때 try~catch로 처리한다.<br>
 * <br>
 * throws : method나 constructor안에서 발생된 예외를 날려 호출한 곳에서 처리하도록 만드는것
 * 
 * @author owner
 */
public class UseThrows {

	public UseThrows() throws ClassNotFoundException {
		Class.forName("java.lang.Integer");// 예외가 발생하면 아랫줄을 수행하지 않고 호출한 곳에서 감싸있는 catch로 이동하게 됨
		System.out.println("Integer class loading 성공");
	}

	public void test() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("c:/dev/env.bat");
		System.out.println(fis);
	}

	public static void main(String[] args) {
		try {
			UseThrows ut = new UseThrows();
			ut.test();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}

	}// main

}// class
