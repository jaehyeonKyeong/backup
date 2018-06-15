package day0530;

/**
 * singleton pattern 을 적용한 클래스 
 * @author owner
 *
 */
public class Singleton {
	private static Singleton s;
	
	// 1. 외부에서 객체화 할 수 없도록 생성자 접근지정자 private으로
	private Singleton() {
		System.out.println("객체화");
		
	}

	public static Singleton getInstance() {
		// TODO Auto-generated method stub
		if(s==null) {
			s =new Singleton();	
		}//end if
		
		return s;
	}//singleton
	//2. instance를 얻는 method를 생성
	

}
