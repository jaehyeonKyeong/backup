package day0405;

/**
 *	추상클래스는 상속관계의 부모클래스로 작성된다 <br>
 *	추상클래스는 직접객체화 될 수 없다 <br>
 *	모든 자식이 반드시 구현해야하는(Override) 강제성을 가진 추상 method를 가진다 <br>
 *	추상클래스는 자식이 반드시 구현해야 하지만 자식클래스가 추상클래스인 경우는 구현하지 않아도 된다
 * @author owner
 */
public abstract class AbstractSuper {
	int i;
	public AbstractSuper() {
		System.out.println("부모 기본생성자");
	}//AbstractSuper
	
	public void method() {
		System.out.println("일반 method");
	}//method
	
	public abstract void absMethod();
	public abstract void absMethod1();
	
	
	
	
	
	
//	public static void main(String[] args) {
//		// 추상클래스는 직접 객체화 될 수 없다
//		AbstractSuper as =new AbstractSuper();
//	}

}//class
