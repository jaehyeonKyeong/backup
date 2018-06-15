package day0330;

/**
 *	생성자의 사용 <br>
 *	생성되는 객체가 가져야 할 초기값, 실행되어야 할 코드를 정의하는 method의 일정 <br>
 *	new로만 호출 가능 <br>
 *	생성자는 상속되지 않는다 <br>
 *	생성자 안에서 this(); 사용하면 내 클래스의 다른 생성자를 호출하고, Super(); 사용하면 부모클래스의 생성자를 호출한다
 * @author owner
 */
public class UseConstructor {
	
	public UseConstructor() {
		System.out.println("기본생성자");
//		UseConstructor(100); // 생성자는 직접 호출 할 수 없다
//		test(100); // method는 직접 호출 가능
	}//UseConstructor
	
	//매개변두를 다르게하여 overloading
	public UseConstructor(int i) {
		System.out.println("인자있는 생성자");
	}//UseConstructor
	
	public void test(int i) {
		System.out.println("test method "+i);
	}

	public static void main(String[] args) {
		new UseConstructor();
		
		

	}//main

}//class
