package day0405;

public class Parents {
	int i;
	public Parents() {
//		this(300);
		i=50;
		System.out.println("부모 기본생성자");
	}
	
	public Parents(int i) {
//		this(); //1번
		System.out.println("부모 인자 생성자 "+i);
	}
}
