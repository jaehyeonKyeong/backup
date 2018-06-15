package day0329;

// class 접근 지정자 : default : 외부 패키지에서 접근불가
class Encapsulation2 {
	public int e2_a; // 같은 패키지의 다른 class에서 사용가능
	protected int e2_b;// 같은패키지의 클래스가 이 클래스를 상속하면 사용가능, 같은 패키지의 다른 클래스에서 사용 가능
	int e2_c; // 상동
	private int e2_d; // 외부 접근 불가

	public static void main(String[] args) {
		// 같은 패키지의 다른 클래스(Encapsulation1) 사용
		Encapsulation1 e1 = new Encapsulation1();
		e1.e1_a = 100; // public
		e1.e1_b = 100; // protected
		e1.e1_c = 100; // default
		// e1.e1_d=100; //private 사용불가 // Error
		
		Encapsulation2 e2=new Encapsulation2();
		e2.e2_d=20;
		System.out.println(e2.e2_d);
		
	}

}
