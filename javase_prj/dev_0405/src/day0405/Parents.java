package day0405;

public class Parents {
	int i;
	
	public Parents() {
		
		super();
		System.out.println("부모 기본 생성자");
		
//		this(300);
//		System.out.println("부모 기본 생성자");
	}
	
	public Parents(int i) {
	
		this();
		System.out.println("부모 인자 생성자 i="+i);
		
		
//		System.out.println("부모 인자 생성자 i="+i);
	}
	

}
