package day0406;

public class TestAnonymous {
	
	public void useInterface(TestInter ti) {
		ti.test();
		String week = ti.week();
		System.out.println("week "+week);
	} //useInterface

	public static void main(String[] args) {
		TestAnonymous ta = new TestAnonymous();
		//method가 interface를 매개변수로 정의하게 되면 method를 호출할 때 
		// 1.해당 인터페이스를 구현한 클래스를 생성
		// 2. 객체화
		// 3. method의 매개변수로 객체를 넣는다
		TestInterImpl tii = new TestInterImpl();
		ta.useInterface(tii);
		
		TestInterImpl2 tii2 = new TestInterImpl2();
		ta.useInterface(tii2);
		
		// 클래스를 별도로 생성하지 않고 매개변수를 넣을 때 : Anonymous inner class
		// class를 작성하지 않았지만 anonymous 클래스이고 그에대한 bytecode가 생성된다
		// 외부클래스명$1.class 
		ta.useInterface(new TestInter() {
			@Override
			public void test() {
				System.out.println("anonymous inner class가 구현!!! :-)");
			}//test
			
			public String week() {
				return "내일은 퇼 :-(";
			}//week
		});
		
//		ta.useInterface(new TestInterImpl());
//		ta.useInterface(new TestInterImpl2());

	}//main

}//class
