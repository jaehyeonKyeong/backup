package day0329;

//class의 접근 지정자 : default(package) : 외부 패키지에서 접근 불가.
class Encapsulation2 {
	public int e2_a; // 사용가능
	protected int e2_b; // 같은 패키지의 클래스가 이 클래스를 상속하면 사용가능, 상속을 받지 않더라도 같은 패키지의 다른 클래스에서 사용가능.
	int e2_c;// 같은 패키지의 클래스가 이 클래스를 상속하면 사용가능, 상속을 받지 않더라도 같은 패키지의 다른 클래스에서 사용가능.
//	private int e2_d; // 외부 접근 불가.

	public static void main(String[] args) {
		Encapsulation1 e1 = new Encapsulation1();
		e1.e1_a = 100;// public
		e1.e1_b = 100;// protected
		e1.e1_c = 100;//default
		// e1.e1_d=100//error (private사용 불가)
		Encapsulation2 e2=new Encapsulation2();
		e2.e2_a=200; //public
		e2.e2_b=200; //protected
		e2.e2_c=200; //default
//		e2.e2_d=200;//private
	}
}
