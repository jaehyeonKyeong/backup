package day0405;

/**
 * 자식 클래스들이 반드시 구현해야할 일의 목록만 정의
 * 
 * @author owner
 */
public interface TestInterface /* extends Runnable, Cloneable, Serializable */ {
	// 상수
	// int i; //변수는 작성할 수 없다.
	public static final int I = 100;

	// public TestInterface() { //생성자를 가질 수 없다.
	// }

	// public void test() {//일반 메소드도 가질 수 없다
	// }
	
	//JDK1.7+ 인터페이스도 body가 있는 method를 가질 수 있다.
	//default method
	public default void test() {
		System.out.println("오늘은 목요일 입니다.");
	}
	
	//추상 method를 가질 수 있다. : abstract이 없어도 상관 없음.
	public abstract String myName();
	public String myAddr();

}
