package day0405;

public class Child extends Parents {
	int i;
	public Child() {
		
		
		this(300);
		System.out.println("�ڽ��� �⺻ ������");
		
		
//		super();
//		this.i=30;
//		super.i=50;
//		System.out.println("�ڽ��� �⺻ ������"+", �ڽ� i="+this.i+", �θ� i="+super.i);
		
	}
	
	public Child(int i) {
		
		super(200);
		System.out.println("�ڽ��� ���� ������ i="+i);
		
		
//		this();
//		System.out.println("�ڽ��� ���� ������ i="+i);
	}

}
