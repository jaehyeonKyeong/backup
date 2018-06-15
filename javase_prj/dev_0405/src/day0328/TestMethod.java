package day0328;

/**
 *	 method 정의 <br>
 *	instance method : 객체안의 인스턴스 변수를 사용하여 일처리 하는 경우 작성 <br>
 *							객체화 하여 객체명.변수명 형태로 사용 <br>
 *	static method : 객체안의 인스턴스 변수를 사용하지 않고 일처리 하는 경우 작성 <br>
 *							객체화 하지 않고 method명.변수명 형태로 바로 사용 <br>
 *	
 *	int i=Integer.parseInt("11"); //static method <br>
 *	
 *	만약 instance method이었다면 	Integer i = new Integer("11"); <br>
 *											int temp = i.parseInt(); <br>
 *	형태로 사용되었어야 할 것이다 <br>
 * @author owner
 */
public class TestMethod {
	
	public void methodA() {
		System.out.println("instance method : 객체화 필수");
	}//method
	
	public static void methodB() {
		System.out.println("static method : 객체화 하지 않음");
	}//method

	public static void main(String[] args) {
		
		//instance method 호출
		//1. 객체화
		TestMethod tm = new TestMethod();
		
		//2. 호출
		tm.methodA();
		
		//static method 호출
//		tm.methodB(); //비추
		// 객체형식으로 호출 가능하다 static 문법으로 사용을 추천
		methodB();
		

	}//main

}//class