package day0406;

/**
 *	내부클래스를 static 변수처럼 사용하기 위한 클래스
 * @author owner
 */
public class TestNested {
	
	int i;
	static int j;
	public TestNested() {
		System.out.println("바깥 클래스의 생성자");
	}//TestNested

	public void methodA() {
		System.out.println("바깥 클래스의 인스턴스 method");
	}//methodA
	
	public static void methodB() {
		System.out.println("바깥 클래스의 static method");
	}//methodB
	
	///////////////////////////////////// Nested Class 시작 //////////////////////////////////////////////
	//객체화하여 사용하지 않도록 instance변수, instance method를 정의하지 않는다
	static class NestedInner{
//		int i; // Nested class에서는 일반 instance 변수는 사용할 필요가 없다
		static int j;
		public static void inMethod() {
			System.out.println("내부클래스의 method, j="+j);
//			System.out.println("바깥클래스의 변수 i "+i); //사용불가
			System.out.println("바깥클래스의 변수 j "+TestNested.j); // static 변수 j는 사용가능
//			methodA(); // 영역이 다르므로 직접 호출 불가
			methodB(); // 외부 클래스의 static method 호출 가능
//			TestNested.methodB(); //이 방법도 가능 
		}//inMethod
		
	}// class
	
	///////////////////////////////////// Nested Class 끝  //////////////////////////////////////////////
	
	public static void main(String[] args) {
		//중첩 클래스는 객체화하지 않고 사용
		j=200; //TestNested.j
		NestedInner.j=100; // 내부클래스변수
		NestedInner.inMethod();

	}//main

}//class
