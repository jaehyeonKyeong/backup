package day0330;

/**
 *	this를 method형식으로 사용<br>
 *	내 클레스에 있는 다른 생성자를 호출 할 때 사용.<br>
 *	생성자의 첫줄에서만 작성 가능.<br>
 *	재귀호출되면 error가 출력된다<br>	
 * @author owner
 */
public class ThisConstructor {
	public ThisConstructor() {
		this(30);
		System.out.println("기본생성자");
	}//ThisConstructor
	public ThisConstructor(int i) {
//		this();
		System.out.println("인자있는 생성자 : i ="+i);
	}
	public static void main(String[] args) {
//		new ThisConstructor();
		new ThisConstructor(30);
	}

}
