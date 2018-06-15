package day0406;

/**
 * 클래스 안에 클래스를 정의하고 사용하는 inner class<br>
 * 내부클래스를 인스턴스 변수처럼 사용할 때<br>
 * 외부클래스는 내부클래스의 자원을 반드시 객체화 하여 사용하고,<br>
 * 내부클래스에서는 외부클래스의 자원을 직접 사용할 수 있다.
 * 
 * @author owner
 */
public class TestOuter {
	int i;

	public TestOuter() {
		System.out.println("외부클래스의 생성자");
	}

	public void outMethod() {
		System.out.println("외부클래스의 method i=" + i);
		// System.out.println("내부클래스의 변수 "+j);//직접 사용불가능
		// inMethod();//직접 호출불가능
		
		//내부클래스의 객체화
		TestOuter.Inner in=this.new Inner();
		in.inMethod();
		in.j=100;
	}//out method

	////////////////////////// inner class 시작 /////////////////////////////
	public class Inner {
		int j;

		public Inner() {
			System.out.println("안쪽 클래스의 생성자");
		}// inner

		public void inMethod() {
			System.out.println("안쪽 클래스의 method, j="+j );
			//내부클래스에서는 외부클래스의 바깥 클래스의 자원을 직접 사용가능.
			System.out.println("바깥클래스의 변수 i="+i );
		}// inMethod
	}

	///////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		// 1.바깥 클래스를 객체화
		TestOuter to = new TestOuter();
		to.outMethod();// 바깥 class의 메소드 호출
		// 2.내부 클래스의 자원을 사용하기 위해 내부클래스를 객체화 한다.
		// Inner in = new Inner();//내부 클래스는 일반 객체화로 객체를 생성할 수 없음.
		// 외부클래스명.내부클래스명 객채명= 외부클래스객체명.new 내부클래스 생성자(); 
//		TestOuter.Inner inner = to.new Inner();//외부클래스 명은 생략가능(: Inner inner = to.new Inner();)
//		inner.j=100;//내부클래스의 자원 사용
//		inner.inMethod();// 내부클래스의 method 호출
		

	}// main

}// class
