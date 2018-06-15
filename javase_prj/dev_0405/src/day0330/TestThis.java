package day0330;

/**
 *	this 의 keyword 형식 <br>
 *	this 는 호출하는 객체(instance)의 주소로 대치 된다
 * @author owner
 */
public class TestThis {
	private int i;
	public void setI(int i, TestThis param_tt) {
//		i=i; //파라메터 변수값을 동일한 파타메터 변수에 입력 ->무의미
		System.out.println("setI method tt = "+param_tt);
//		param_tt.i=i; //파라메터 객체를 이용
		this.i=i; // this를 이용
		System.out.println("setI method this = "+this);
		System.out.println("stack i = "+i);
	}
	
	public void test() {
		//static 영역은 method를 호출 할 떄 클래스명.method명();
		//으로 호출하기 때문에 어떤 객체가 method를 호출했는지 알수가 없으므로
		//객체의 주소가 변경되는 this를 사용할 수 없다
		System.out.println(this);
	}

	public static void main(String[] args) {
		TestThis tt = new TestThis();
		System.out.println("main method tt = "+tt);
		tt.setI(30,tt);
		System.out.println("instance i = "+tt.i);
		//static 영역은 객체가 생성되기전에 호출되므로 어떤 객체가 호출했는지 알 수 없으므로 this를 사용할 수 없다
//		System.out.println(this);
		
		
		

	}

}
