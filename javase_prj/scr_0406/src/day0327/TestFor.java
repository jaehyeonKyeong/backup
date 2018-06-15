package day0327;

/**
 * for : 시작과 끝을 알 때 사용하는 반복문<br>
 * 문법) for ( 시작값; 끝값; 증.감소식;){<br>
 * 반복수행 문장들.... ; <br>
 * }<br>
 * * @author owner
 */
public class TestFor {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println("편한부분 인정?" + i);
		} // end for

		// 1~100까지 옆으로 출력
		for (int i = 1; i < 101; i++) {
			System.out.print(i + " ");
		} // end for
		System.out.println();

		// 1~100까지 홀수만 옆으로 출력
		for (int i = 1; i < 101; i = i + 2) {
			System.out.print(i + " ");
		} // end for
		System.out.println();

		// 1~100까지 짝수만 옆으로 출력
		for (int i = 1; i < 101; i++) {
			if (i % 2 == 0)
				System.out.print(i + " ");
		} // end for
		System.out.println();

		// 1~100까지 누적합 출력
		int sum = 0;
		for (int i = 1; i < 101; sum += i++)
			;// end for
		System.out.println("1~100까지의 누적합은 " + sum);

		// 1~100까지 출력 : 1 2 짝 4 5 짝 7 8.....
		for (int i = 1; i < 101; i++) {
			if (i % 3 == 0) {
				System.out.print("짝 ");
			} else {
				System.out.print(i + " ");
			}
		} // end for

		/////////////////////////////// 다중 for////////////////////////////
		System.out.println("-----------------------------다중 for-------------------------");
		for (int i = 0; i < 5; i++) {// 바깥 for
			for (int j = 0; j < 6; j++) {// 안쪽 for
				System.out.print("i=" + i + ", j=" + j + " / ");
			} // end for j
			System.out.println();
			System.out.println("--------------------------");
		} // end for i

		// 구구단
		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				System.out.print(j + "*" + i + "=" + i * j + " \t");
			} // end for j
			System.out.println();
		} // end for i

		//////////////// 초기값이 여러개인 for /////////////////////////
		for (int i = 0, j = 10, k = 5; i < 10; i++, j--, k *= 5) {
			System.out.print("i: " + i + ",j= " + j + ", k= " + k + "   ");
		} // end for
		System.out.println();
		///////// 무한 loop ////////////////////
		for (;;) {
			System.out.println("무한");
			break;
		} // end for
		System.out.println("안녕");

		for (byte i = 0;; i++) {// 증가하는 수를 세는 for
			System.out.print(i+"  ");
			if (i == 5) {
				break;
			} // end if
		} // end for
		System.out.println();

		///// 반복문의 실행 건너 뛰기///////////
		for (int i = 0; i < 50; i++) {
			if (i % 2 == 1) {//홀수인 결우 반복문의 실행을 건너뜀
				continue;
			}//end if
			System.out.print(i+" ");
		} // end for
		System.out.println();
		
	}// main
}// class