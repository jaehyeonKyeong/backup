package day0406;

/**
 *	내부클래스를 static 변수처럼 사용하기 위한 클래스
 *
 * @author owner
 */
public class TestNested {
	int i;
	static int j;
	
	public TestNested() {
		System.out.println("바깥클래스의 생성자");
	}//TestNested
	
	public void methodA() {
		System.out.println("바깥 인스턴스 method");
	}
	public static void methodB() {
		System.out.println("바깥 static method");
	}
	//////////////////////// nested 시작///////////////////////////////
	//객체화하여 사용하지 않도록 instance변수, instance메소드를 정의하지 않는다.
	static class NestedInner {
		static int j;
		public static void inMethod() {
//			System.out.println("바깥클래스의 i"+i); 
			//아무리 내부클래스여도 영역이 다르면 사용할 수 없음.
			System.out.println("내부클래스의 method");
			System.out.println("바깥클래스의 변수"+TestNested.j);
			System.out.println("내부 클래스의 변수 "+j);
			
			TestNested.methodB();
		}
		
	}
	//////////////////////////////////////////////////////////////////
	
	
	public static void main(String[] args) {
		j=200;//중첩클래스는 객체화 하지 않고 사용
		NestedInner.j=100;
		NestedInner.inMethod();
	}

}
