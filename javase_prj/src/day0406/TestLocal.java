package day0406;

import javax.swing.plaf.synth.SynthSpinnerUI;

/**
 * method내의 class를 정의하는 local클래스<br>
 * method 내에서만 사용되는 class <br>
 * compile 되면 : 바깥클래스명$1내부클래스명.class
 * 
 * @author owner
 */
@SuppressWarnings("unused")
public class TestLocal {
	int i;
	
	public TestLocal() {
		System.out.println("생성자");
	}
	
	public void test(int param_i, final int param_j) {
		int loc_i=0;
		final int loc_j=0;
		////////////////// 지역클래스 //////////////////////
		class LocalInner{
			@SuppressWarnings("unused")
			int ii;
			public LocalInner() {
				System.out.println("지역클래스 생성자");
			}//지역클래스의 생성자
			public void locMethod() {
				System.out.println("지역클래스의 method");
				//final이 붙어있는 변수만 사용가능 : JDK 1.8부터는 final이 붙어있지 않아도 사용가능(값 할당 불가)
				System.out.println("method내 지역변수 loc_i ="+loc_i+",loc_j="+loc_j);
				System.out.println("Param_i="+param_i+", param_j="+param_j);
			}
		}//class
		////////////////////////////////////////////////
		System.out.println("변수 "+loc_i+", "+loc_j);
		System.out.println("매개 변수 "+param_i+", "+param_j);
		LocalInner li=new LocalInner();
		li.locMethod();
	}//test
	
	public static void main(String[] args) {
		TestLocal tl=new TestLocal();
		tl.test(100, 200);

	}//main

}//class
