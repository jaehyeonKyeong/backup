package day0405;

public class AbstactSub extends AbstractSuper{
	
	@Override
	public void absMethod() {
		System.out.println("자식에서 Override");
	}
	
	@Override
	public void absMethod1() {
		System.out.println("자식에서 알아서 Override");
		//추상method Override
//		super.absMethod1(); //부모의 method가 추상 method인 경우 super로 호출할 수 없다
	}//absmethod1
	
	public static void main(String[] args) {
//		AbstractSuper as = new AbstractSuper(); //추상클래스는 직접 객체화할 수 없음
		AbstactSub as = new AbstactSub();
		as.absMethod();
		as.absMethod1();
		System.out.println("-------------------------------------------");
		
		//is a 관계의 객체화 : 부모클래스 객체명 = new 자식클래스생성자();
		AbstractSuper as1 = new AbstactSub();
		as1.absMethod(); // 자식클래스가 Override 했다면 어떤 식으로 객체화를 하더라도 자식의 method가 최!우!선! 적으로 호출된다
		as1.absMethod1();
		
		
	}//main
}//class
