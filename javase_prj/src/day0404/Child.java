package day0404;

/**
 *	상속관계에서 자식 클래스 <br>
 *	공통특징은 부모의 자원을 사용하고(코드의 재사용성) <br>
 *	자신만의 특징만 정의하여 사용 <br>
 *	
 * @author owner
 */
public class Child extends Parent {
	int c_a;
	public Child() {
		System.out.println("자식클래스의 생성자");
	}//Child
	
	public void cMethod() {
		System.out.println("자식클래스의 method");
	}//cMethod

	public static void main(String[] args) {
		Child c = new Child(); //자식을 객체화 하면 부모 먼저 생성된다
		//자식객체로 부모의 자원을 자신 것처럼 사용한다
		System.out.println("부모 public "+c.p_a); //사용가
		System.out.println("부모 protected "+c.p_b); //사용가
		System.out.println("부모 default "+c.p_c);//상황에 따라 (같은 package에 있기 때문에 사용가능)
//		System.out.println("부모 private "+c.p_d); //사용불가 (접근권한 없음)
		System.out.println("자식 default "+c.c_a); //자신의 자원은 사용가능
		
		c.pMethod();
		c.cMethod();

	}//main

}//class
