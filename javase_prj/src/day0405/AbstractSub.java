package day0405;

public class AbstractSub extends AbstractSuper {

	@Override
	public void absMethod() {
		System.out.println("자식에서 override");
	}

	@Override
	public void absMethod1() {
		System.out.println("자식에서 알아서 override");
		// super.absMethod1();//부모의 method가 추상method일 경우 호출할 수 없음.
	}

	public static void main(String[] args) {
		AbstractSub as = new AbstractSub();
		as.absMethod();
		as.absMethod1();
		
		//is a 관계의 객체화: 부모클래스 객체명 = new 자식클래스 생성자();
		AbstractSuper as1=new AbstractSub();
		as1.absMethod();//자식클래스가 override했다면 어떤식으로 객채화를 하더라도 자식의 method가 최!우!선!적으로 호출된다.
		

	}

}
