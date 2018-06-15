package day0405;

public class Child extends Parents {
	int i;
	public Child() {
//		this(300);//1번
		super();//2번
		i=30;
		System.out.println("자식 기본 자식i="+this.i+" 부모 i="+super.i);
//		System.out.println("자식 기본생성자");//1번
	}
	public Child(int i) {
//		super(200); //1번
		this();//2번
		System.out.println("자식 인자 생성자 "+i);
	}
}
