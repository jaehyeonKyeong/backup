package day0329;

/**
 * 클래스에서 같은 이름의 method를 여러개 작성할때 Overload를 사용
 * 
 * @author owner
 */
public class TestOverload {

	/**
	 * *을 하나 출력하는 일
	 */
	public void printStar() {
		System.out.println("★");
	}// printStar


	/**
	 * *을 입력된 수만큼 출력하는 일
	 * 
	 * @param cnt
	 *            출력할 별의 개수
	 */
	public void printStar(int cnt) {
		//Overloading
		for (int i = 0; i < cnt; i++) {
			System.out.print("☆");
		}
	}// printStar
	

	public static void main(String[] args) {
		TestOverload to=new TestOverload();
		to.printStar();
		to.printStar(5);
	}// main

}// class
