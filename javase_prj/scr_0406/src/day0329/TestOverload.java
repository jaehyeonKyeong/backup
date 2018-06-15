package day0329;


/**
 * 클래스에서 같은 이름의 method를 여러개 작성할 때 overload를 사용 <br>
 * 
 * @author owner
 */
public class TestOverload {

	/**
	 * '*'을 하나 출력하는 일
	 */
	public void printStar() {		
		System.out.println("★");		
	}

	/**
	 * '*'을 입력된 수만큼 출력하는 일
	 * @param cnt 입력된 수
	 */
	public void printStar(int cnt) {
		for (int i = 0; i < cnt; i++) {
			System.out.print("★");
		}
	}

	public static void main(String[] args) {
		TestOverload to = new TestOverload();
		to.printStar();
		System.out.println("-------------------------");
		to.printStar(10);

	}

}
