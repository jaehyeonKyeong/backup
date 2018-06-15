package day0406;

/**
 * 클래스 안에 클래스를 정의하고 사용하는 inner class <br>
 * 내부클래스를 인스턴스 변수처럼 사용할 때 <br>
 * 	외부 클래스는 내부클래스의 자원을 반드시 객체화 하여 사용하고, 내부클래스에서는 외부클래스의 자원을 직접 사용할 수 있다
 * @author owner
 */
public class TestOuter {
	int i;
	public TestOuter() {
		System.out.println("외부클래스의 생성자");
	}//TestOuter
	
	public void outMethod() {
		System.out.println("외부 클래스의 method");
		System.out.println("외부 클래스의 변수 i "+i);
//		System.out.println("내부 클래스의 변수 j "+j); // 외부클래스에서는 내부클래스의 자원 사용불가
		
		//내부 클래스를 객체화!!!
		TestOuter.Inner in = this.new Inner();
		in.j=300; //객체화 후 내부클래스 자원 사용 가능
		in.inMethod(); //객체화 후 내부클래스 자원 사용 가능
	}//out Method
	
	//////////////////////////////////////inner class 시작//////////////////////////////////////
	public class Inner{
		int j=0;
		public Inner() {
			System.out.println("내부 클래스의 생성자");
		}//Inner
		public void inMethod() {
			System.out.println("내부 클래스의 method, j "+j);
			System.out.println("바깥 클래스의 변수 i "+i);//내부클래스에서는 외부클래스 자원 사용 가능
//			outMethod(); //내부클래스에서는 외부클래스 자원 사용 가능
		}//inMethod
	}// inner class
	//////////////////////////////////////inner class 끝//////////////////////////////////////
	

	public static void main(String[] args) {
		//1. 바깥 클래스를 객체화
		TestOuter to = new TestOuter();
		to.i=100;
		to.outMethod(); //바깥 클래스의 method 호출
		System.out.println("바깥 클래스의 변수 i :"+to.i);
//		to.inMethod(); //외부클래스에서 내부클래스의 자원 사용 불가
//		System.out.println("바깥 클래스의 변수 i :"+to.j); //외부클래스에서 내부클래스의 자원 사용 불가
		
//		Inner in = new Inner(); //내부클래스는 일반객체화로 객체를 생성할 수 없다
		//외부클래스명.내부클래스명 내부객체명 = 외부클래스객체명.new 내부클래스생성자();
		TestOuter.Inner in = to.new Inner(); //외부클래스명은 생략 가능
		@SuppressWarnings("unused")
		Inner in2 = to.new Inner();
		in.j=200;
		in.inMethod(); //안쪽 클래스의 method 호출
		

	}// main

}//class
