package day0405;

public class Child extends Parents {
	int i;
	public Child() {
//		this(300);//1��
		super();//2��
		i=30;
		System.out.println("�ڽ� �⺻ �ڽ�i="+this.i+" �θ� i="+super.i);
//		System.out.println("�ڽ� �⺻������");//1��
	}
	public Child(int i) {
//		super(200); //1��
		this();//2��
		System.out.println("�ڽ� ���� ������ "+i);
	}
}
