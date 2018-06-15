package day0326;

/**
 * if~else<br>
 * 둘중 하나의 코드를 실행해야하는 경우 사용<br>
 * if(조건식){<br>
 * 조건에 맞을경우 실행코드;<br>
 * }else{<br>
 * 조건에 맞지 않을경우 실행코드;<br>
 * }<br>
 * 
 * @author owner
 */
public class TestIfElse {

	public static void main(String[] args) {

		int num = Integer.parseInt(args[0]);
		// 입력된 수가 음수인지 양수인지 판단.

		System.out.print("입력된 수 " + num + "(은)는");
		if (num > -1) {// 양수
			System.out.println(" 양수입니다.");
		} else {// 음수
			System.out.println(" 음수입니다.");
		} // end if

		// 입력된 수가 홀수인지 짝수인지 판단.
		if (num % 2 == 0) {
			System.out.println("짝수입니다");
		} else {
			System.out.println("홀수입니다");
		} // end if

		// 입력된 수가 0~100사이면 유효를 그렇지 않으면 무효를 출력
		if (num >= 0 && num <= 100) {
			System.out.println("유효");
		} else {
			System.out.println("무효");
		} // end if

		// 입력된 이름이 "지승민"이라면 '반장'을 그렇지 않으면 '평민'을 출력하세요
		if (args[1].equals("지승민")) {
			System.out.println("반장");
		} else {
			System.out.println("평민");
		} // end if

	}// main

}// class
