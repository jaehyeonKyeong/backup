package day0328;

/**
 * method 정의<br>
 * instance method : 객체안의 인스턴스 변수를 사용하여 일처리하는 경우 작성 = 객체화를 하여
 * 객체명.method명();호출<br>
 * static method : 객체안의 인스턴스 변수를 사용하지 않고 일처리하는 경우 작성 = 클래스 명.method명();<br>
 * int i =Integer.parseInt("11");<br>
 * 
 * @author owner
 */
public class TestMethod {

	public void methodA() {
		System.out.println("instance method : 객체화 필수");
	}// metohd

	public static void methodB() {
		System.out.println("static method : 객체화 불필요");
	}// metohd

	public static void main(String[] args) {
		
		// instance method 호출
		// 객체화 : class명 객체명 = new class명();
		TestMethod tm = new TestMethod();
		// 호출 : 객체명.method명();
		tm.methodA();

		// static method 호출
		//tm.methodB(); //객체를 사용하여 호출 가능하나 static 사용 문법으로 호출
		TestMethod.methodB();
		

	}// main

}// class
