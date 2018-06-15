package day0327;

/**
 * for 시작과 끝을 알때 사용하는 반복문<br>
 * 문법) <br>
 * for(초기값; 조건식; 증가.감소식;){<br>
 * 반복수행 문장들;<br>
 * }
 * 
 * @author owner
 */
public class TestFor {

	public static void main(String[] args) {

		// for 기본
		for (int i = 0; i < 10; i++) {
			System.out.println("i=" + i);
		} // end for

		// 1~100까지 옆으로 출력
		for (int i = 1; i <= 100; i++) {
			System.out.print(i + " ");
		} // end for

		// 1~100까지 홀수만
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 1) {
				System.out.print(i + " ");
			} // end if
		} // end for
		System.out.println();
		for (int i = 1; i <= 100; i += 2) {
			System.out.print(i + " ");
		} // end for
		System.out.println();

		// 1~100까지 짝수 출력
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			} // end if
		} // end for
		System.out.println();

		// 1~100까지 누적합 : 5050출력
		int sum = 0;
		for (int i = 1; i < 101; i++) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println();

		// 1~100까지 출력 : 3의 배수에 박수
		for (int i = 1; i < 101; i++) {
			if (i % 3 == 0) {
				System.out.print("짝 ");
			} else {
				System.out.print(i + " ");
			} // end else
		} // end for

		///////////////////////// 다중for/////////////////////
		System.out.println("============다중for===========");
		// 다중for 기본
		for (int i = 0; i < 5; i++) {// 바깥 for
			for (int j = 0; j < 6; j++) {// 안쪽for
				System.out.println("i= " + i + " | j= " + j);
			} // end 안쪽 for
			System.out.println("----------------------------");
		} // end 바깥 for
		System.out.println();
		// 9*9단
		for (int i = 2; i < 10; i++) {
			System.out.println(i + "단");
			for (int j = 1; j < 10; j++) {
				System.out.println(i + " * " + j + " = " + (i * j));
			} // end for
			System.out.println("------------------------");
		} // end for

		///////////////// 초기값이 여러개인 for///////////////////

		for (int i = 0, j = 10, k = 5; i < 10; i++, j--, k *= 5) {
			System.out.println("i : " + i + ", j : " + j + ", k : " + k);
		} // end for

		/////////////////// 무한 loop////////////////
		for (;;) { // 증가하는 수를 세지못하는 for
			System.out.println("무한");
			break;
		}//end for
		for (int i = 0;; i++) {// 증가하는 수를 세는 for
			System.out.println(i);
			if (i == 5)
				break;
		}//end for
		System.out.println("____________________________");
		
		////////////////////// 반복문의 실행 건너 뛰기 (continue)//////////////
		for(int i=0; i<50; i++) {
			if(i%2==1) {//홀수인 경우 반복문의 실행을 건너 뛴다.
				continue;
			}//endif
			System.out.println(i+" ");
		}//end for

	}// main

}// class
