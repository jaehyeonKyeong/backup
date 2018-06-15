package day0330;

/**
 * this의 키워드 형식<br>
 * this는 호출하는 객체의 주소를 따른다. * @author owner
 */
public class TestThis {

	private int i;

	public void setI(int i, TestThis param_tt) {
		// i=i; //파라메터 변수의 값을 파라메터에 할당 : 효과가 없음
		// param_tt.i=i;
		this.i = i; // this는 new에 대한 주소
		System.out.println("seti에서의 tt=" + param_tt);
		System.out.println("seti method this=" + this);
		System.out.println("stack i=" + i);
	}

	public static void test() {
		// static 영역은 method를 호출 할때 클래스명.method명(); 으로 호출하기 때문에
		// 어떤 객체가 method를 호출햇는지 알수 없으므로 객체의 주소가 변경되는 this 키워드를 사용할 수 없다
		// System.out.println(this);
	}

	public static void main(String[] args) {
		TestThis tt = new TestThis();
		System.out.println("main method tt =" + tt);
		tt.setI(30, tt);
		System.out.println("heap i=" + tt.i);
		// static영역은 객체가 생성되기 전에 호출되므로 어떤 객체가 호출했는지 알수 없으므로 this를 사용할 수 없다.
		// System.out.println(this);//error (instance영역에서만 쓸 수 있음)
		TestThis.test();
	}

}
