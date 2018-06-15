package day0330;


public class UsePerson {
	
	/**
	 * JAVA Application : 단독으로 실행 가능한 프로그램
	 * @param args 인자값...
	 */
	public static void main(String[] args) {
		Person jsm=new Person();
		
		jsm.setName("지승민");
		
		System.out.println(jsm.eat());
		System.out.println(jsm.eat("빵",1500));
		
		
		Person jinban=new Person(3,1,1);
		jinban.setName("천진반");
		System.out.println(jinban.eat());
		System.out.println(jinban.eat("선두",1));
		
		
		
	}
	
	

}
