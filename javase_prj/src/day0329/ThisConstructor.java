package day0329;

/**
 *	this 키워드를 method 형식으로 사용 <br>
 *	내 클래스의 다른 생성자를 호출 할 때 사용 <br>
 *	생성자의 첫번째 줄에서만 작성할 수 있다 
 * @author owner
 */
public class ThisConstructor {
	public ThisConstructor() {
//		this(30);
		System.out.println("기본생성자");
	}//ThisConstructor

	public ThisConstructor(int i) {
		this();
		System.out.println("인자있는 생성자 : i="+i);
	}//ThisConstructor
	
	public static void main(String[] args) {
//		new ThisConstructor(); //기본생성자
		
		new ThisConstructor(50);

	}

}
