package day0327;

/**
 *	 do~while : 시작과 끝을 모를 때 사용하는 반복문 <br>
 *	최소 1번 수행, 최대 조건까지 수행<br>
 *	문법) do{ <br>
 *				반복할 코드;<br>
 *				} while (조건식);<br>
 * @author owner
 */
public class TestDoWhile {

	public static void main(String[] args) {
		int i=100;
		do {
			System.out.println(i);
			i++;
		} while(i<10);
		
		
		///무한루프
		do {
			System.out.println(i);
			i++;
		} while(true);
		

	}//main

}//class
