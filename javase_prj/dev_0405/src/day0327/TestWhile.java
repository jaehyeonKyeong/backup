package day0327;

/**
 * while : 시작과 끝을 알 수 없을 때 사용하는 반복문<br>
 * (반복할 횟수를 개발자가 모를 경우 사용)<br>
 * 문법) while(조건식){<br>
 * 반복수행문장;<br>
 * }<br>
 * @author owner
 */
public class TestWhile {

	public static void main(String[] args) {

		int i = 0; // 초기값
		// 최소 0번 수행 / 최대 조건까지 수행
		while (i < 10) { // 조건식
			System.out.println("i : " + i);// 반복수행
			i++;// 증.감소식
		} // end while
			
		///// 무한 loop
		while (true) { // 조건식
			System.out.println("무한");// 반복수행
			break;
		} // end while
		
		////
		
		
		
		
	}// main

}// class
