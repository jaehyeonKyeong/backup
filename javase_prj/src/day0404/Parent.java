package day0404;

/**
 *	상속관계에서 부모클래스 <br>
 *	부모 : 모든 자식이 가져야할 공통 특징 정의 <br>
 *	
 * @author owner
 */
public class Parent {
	public int p_a;
	protected int p_b;
	int p_c;
	private int p_d;
	
	public Parent() {
		System.out.println("부모클래스의 기본생성자");
		System.out.println("private int p_d : "+p_d);
	}//Parent
	
	public void pMethod() {
		System.out.println("부모클래스의 method");
	}//pMethod
	

}//class
