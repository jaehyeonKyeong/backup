package day0405;

/**
 * 추상클래스는 상속관계의 부모 클래스로 작성된다<br>
 * 추상클래스는 직접 객채화 될 수 없다
 * 모든 자식이 반드시 구현해야하는(override)강제성을 가진 추상method를 가진다
 * 추상 method는 자식이 반드시 구현해야하지만 자식 클래스가 추상클래스 인 경우는 구현하지 않아도 된다.
 * @author owner
 */
public abstract class AbstractSuper {
	int i;
	public AbstractSuper() {
		System.out.println("부모의 기본생성자");
	}
	public void method() {
		System.out.println("일반메소드");
	}
	
	//추상method : method body가 없서 일을 할수 없는 method 자식 클래스는 모든 클래스를 강제적으로 override하여야함
	
	public abstract void absMethod();
	public abstract void absMethod1();
	
	public static void main(String[] args) {

	}

}
