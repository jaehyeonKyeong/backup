package day0330;

/**
 * 생성자의 사용<br>
 * 객체가 생성될때 생성되는 객체가 가져야 할 초기값, 또는 실행되어야 할 코드를 정의하는 method의 일종<br>
 * new로만 호출 가능<br>
 * 생성자는 상속되지 않는다<br>
 * 생성자 안에서 this();를 사용하면 내 클래스의 다른 생성자를 호출하고, super();를 사용하면 부모 클래스의 생성자를 호출할수
 * 있다.
 * 
 * @author owner
 */
public class UseConstructor {

	 public UseConstructor() {
	 System.out.println("기본생성자");
	 test(1);
	 }
	 public UseConstructor(int i) {
	 System.out.println("인자 있는 생성자");
//	 UseConstructor(); // 생성자는 method처럼 생성할수 없음.
	 }
	 public void test(int i) {
		 System.out.println(i);
	 }

	public static void main(String[] args) {
		new UseConstructor();
	}// main
}// class
