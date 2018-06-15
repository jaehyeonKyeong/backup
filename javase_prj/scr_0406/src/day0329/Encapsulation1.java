package day0329;

// class 접근 지정자 : public : 외부 패키지에서 접근 가능
public class Encapsulation1 {
	public int e1_a; //외부사용가능
	protected int e1_b;//같은패키지 사용가능, 외부 : 자식
	int e1_c; //같은 패키지 사용가능, 외부 : 사용불가
	private int e1_d; //내 클래스 안에서만 사용가능
	
	public static void main(String[] args) {
		//패키지가 같다면 클래스의 접근지정자는 영향을 주지 않는다
		Encapsulation2 e2=new Encapsulation2();
		e2.e2_a=200; // public
		e2.e2_b=200; // pritected
		e2.e2_c=200; // default
//		e2.e2.d=200; // private
		
		Encapsulation1 e1=new Encapsulation1();
		e1.e1_d=10;
		System.out.println(e1.e1_d);
		
	
	}

}
