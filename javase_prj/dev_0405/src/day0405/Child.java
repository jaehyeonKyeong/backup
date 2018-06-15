package day0405;

public class Child extends Parents {
	int i;
	public Child() {
		
		
		this(300);
		System.out.println("자식의 기본 생성자");
		
		
//		super();
//		this.i=30;
//		super.i=50;
//		System.out.println("자식의 기본 생성자"+", 자식 i="+this.i+", 부모 i="+super.i);
		
	}
	
	public Child(int i) {
		
		super(200);
		System.out.println("자식의 인자 생성자 i="+i);
		
		
//		this();
//		System.out.println("자식의 인자 생성자 i="+i);
	}

}
