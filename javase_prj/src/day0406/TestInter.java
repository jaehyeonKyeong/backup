package day0406;

/**
 * 자식클래스의 크기에 영향을 끼치지 않고, 다형성(객체 다형성)을 사용할 수 있다.
 * @author owner
 */
//@FunctionalInterface : lamda식에서 사용할 수 있게 인터페이스의 추상method를 
//하나만 가지도록 체크하는 annotation : JDK1.8+
public interface TestInter {
	public void test();
	public String week();
	
	
	
}
