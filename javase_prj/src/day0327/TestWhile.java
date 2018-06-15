package day0327;

/**
 * while : 시작과 끝을 알 수 없을 때 사용하는 반복문(반복 횟수를 모를때 사용)<br>
 * 문법)<br>
 * 초기값; while(조건식){<br>
 * 반복수행 문장;<br>
 * 증감식; }<br>
 * 
 * @author owner
 */
public class TestWhile {

	public static void main(String[] args) {
		
		//while 기본
		int i = 0;//초기값
		//최소 0번 실행, 최대 조건까지 실행
		while (i < 10) {//조건식
			System.out.println("i : "+i);//반복실행
			i++;//증감식
		} // end while
		
		//무한 loop
		while(true) {
			System.out.println("무한");
			break;
		}
		System.out.println();
		
		

	}// main

}// class
