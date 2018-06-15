package day0430;

public class UseLambda {

	public UseLambda() {
		//class를 생성하지 않고 추상 method를 작성하여 호출 할 수 있다.
		TestLambda tl=()->{
			System.out.println("test메소드 구현");
			
		};
//		Runnable test=()->{
//			for(int i=0;i<1000;i++)
//			{
//				System.out.println("run-----i="+i);
//			}
//			
//		};
		//추상 method 호출
//		Thread t=new Thread(test);
//		t.start();
		tl.test();
//		for(int i=0;i<1000;i++)
//		{
//			System.out.println("test "+i);
//			
//		}
		//매개변수 있는  추상 method 호출
		TestLambda1 t2=(/*Lambda로 구현된 메소드 안에 전달해줄이름*/m)->{
			System.out.println("입력 이름 : "+m);
		};
		String name="지승민";
		t2.printName(name);
		if(name.equals("지승민")) {
			System.out.println("다 제 잘못 입니다");
		}
	}//constructor
	
	
	public static void main(String[] args) {
		
		new UseLambda();
		

	}//main

}//class UseLambda
