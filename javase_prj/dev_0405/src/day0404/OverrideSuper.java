package day0404;

/**
 *	Override 연습
 * @author owner
 */
public class OverrideSuper {
	protected void test (int i) {
		System.out.println("부모의 test method  "+i);
	}//test
	
	void test1(String str) {
		System.out.println("부모의 test1 method  "+str);
	}//test
	
	public String myName() {
		return "이종민";
	}
	
	
	
}//class
