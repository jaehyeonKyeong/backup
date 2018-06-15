package day0406;

/**
 *	method 내 클래스를 정의하는 Local class <br>
 *	method내에서만 사용되는 클래스<br>
 *	compile 되면 "바깥클래스명$1내부클래스명.class"
 * @author owner
 */
public class TestLocal {
	int i;
	public TestLocal() {
		System.out.println("바깥클래스의 생성자");
	}//TestLocal
	public void test(int param_i, final int param_j) {
		int loc_i=0;
		final int loc_j=10;
		
		
		//////////////////////////////////지역클래스 시작///////////////////////////////////////////
		class LocalInner{
			int ii;
			public LocalInner() {
				System.out.println("지역클래스의 생성자");
			}//LocalInner
			public void locMethod() {
				System.out.println("지역클래스의 method, "+ii);
				//final이 붙어있는 변수만 사용가능 : JDK1.8부터는 final이 붙어있지 않아도 사용가능(값 할당불가)
//				loc_i=300;
				System.out.println("method내 지역변수loc_i="+loc_i+", loc_j="+loc_j );
				System.out.println("method내 매개변수 param_i="+param_i+", param_j="+param_j);
				
			}//locMethod
			
			
			
		}//class
		//////////////////////////////////지역클래스 끝 ///////////////////////////////////////////
		System.out.println("변수 "+loc_i+","+loc_j);
		System.out.println("매개변수 "+param_i+","+param_j);
		//////지역클래스 객체화
		LocalInner li = new LocalInner();
		li.ii=100;
		li.locMethod();
		
		
	}//test
	public static void main(String[] args) {
		TestLocal tl = new TestLocal();
		tl.test(100, 200);
		
	}

}
