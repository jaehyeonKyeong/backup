package day0406;

/**
 *	자식클래스의 크기에 영향을 끼치지 않고, 다형성(객체다형성)을 사용할 수 있다 <br>
 *	interface의 장점
 * @author owner
 */
//@FunctionalInterface  : lambda식으로 사용하도록 인터페이스가 추상 method를 하나만 가지도록 체크하는 annotation : JDK1.8에서 제공 
public interface TestInter {
	public void test();
	public String week();
	

}
