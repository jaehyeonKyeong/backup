package day0405;

/**
 * 인터페이스를 구현한 클래스
 * 
 * @author owner
 */
public class TestInterfaceImpl implements TestInterface {

	@Override
	public String myName() {
		return "지승민";
	}

	@Override
	public String myAddr() {
		return "인천광역시 계양구";
	}

	public static void main(String[] args) {
		//인터페이스는 객체화 될 수 없다.
		//TestInterface ti=new TestInterface();
		TestInterfaceImpl tii=new TestInterfaceImpl();
		//구현한 클래스의 객체를 인터페이스로 저장할 수 있다
		TestInterface ti=new TestInterfaceImpl();// is-a관계의 객체화
		
		System.out.println(tii.myName());
		System.out.println(ti.myName()); //override된 method 호출
		
		//default method 호출
		ti.test();
	}

}
