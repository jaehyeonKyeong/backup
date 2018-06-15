package day0327;

/**
 * do~while : 시작과 끝을 모를 때 사용하는 반복문<br>
 * 최소 1번 실행에 최대 조건까지 실행<br>
 * 문법)<br>
 * 		초기값;<br>
 * 		do{<br>
 * 			반복실행 문장;<br>
 * 			증,감소식;<br>
 * 		}while(조건식);<br>
 * 
 * @author owner
 */
public class TestDoWhile {
	
	public static void main(String[] args) {
		
		//do~while 기본
		int i = 100; 
		do {
			System.out.println(i);
			i++;
		}while(i<10); // 100이 10보다 작을리가 없지만 한번은 무조건 실행함(조건을 나중에 확인하기 때문)
		
		// do~while 무한loop
		do {
			System.out.println("무한");
			break;//무한루프 빠져나가는 구문
		}while(true);
	}//main
	
}//class
