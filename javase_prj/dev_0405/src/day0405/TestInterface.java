package day0405;

/**
 *	자식클래스들이 반드시 구현해야 할 일의 목록만 정의
 * @author owner
 */
public interface TestInterface {
	
	//상수
//	int i; // 변수는 작성할 수 없다
	public static final int I=100;
	
	//생성자를 가길 수 없다
//	public TestInterface(){
//		
//	}
	
	//일반 method를 가질 수 없다
//	public void int method() {
//		
//	}
	
	//JDK1.7부터는 인터페이스도 body와 있는 method를 가질 수 있다
	public default void test() {
		System.out.println("오늘은 목요일 입니다");
	}//test
	
	//추상 method를 가질 수 있다 : abstract이 없어도 상관없음
	public abstract String myName();
	public String myAddr();
	
	
	

}
