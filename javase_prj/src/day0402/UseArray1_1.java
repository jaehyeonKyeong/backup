package day0402;

/**
 * 배열의 기본형 형식 사용<br>
 * 데이터형[] 배열명={값,...,값}
 * 
 * @author owner
 */
public class UseArray1_1 {
	public UseArray1_1() {
		// 1.선언:
		int[] score = { 85, 79, 90, 69, 98, 50 };
		String[] name = { "고양이", "개", "닭", "쥐", "돼지", "양" };
		// 기본형으로 선언하더라도 값이 할당된다.
		score[5] = 50;
		// 모든 방의 값 출력
		System.out.println("번호\t이름\tjava 점수");
		System.out.println("===========================");
		int total = 0;
		int topScore = score[0];
		int worstScore = score[0];

		for (int i = 0; i < score.length; i++) {
			System.out.printf("%d\t%s\t%d\n", i + 1, name[i], score[i]);
			total += score[i];
			if (topScore < score[i]) {
				topScore = score[i];
			}
			if (worstScore > score[i]) {
				worstScore = score[i];
			}
		}
		System.out.println("-------------------------");
		System.out.printf("총 응시인원[%d명]\n", score.length);
		System.out.printf("총점[%d점]\t평균[%.2f]\n", total, (double) total / score.length);
		System.out.printf("최고점[%d점]\t최하점[%d점]\n", topScore, worstScore);

		int temp = 0;
		for (int i = 0; i < score.length - 1; i++) {// 가장 마지막 방은 비교할 필요가 업으니 length-1
			for (int j = i + 1; j < score.length; j++) {
				if (score[i] < score[j]) {// 앞방<뒷방 내림차순,앞방 >뒷방 오름차순
					temp = score[i];
					score[i] = score[j];
					score[j] = temp;
				}
			}
		}
		for (int i = 0; i < score.length; i++) {
			System.out.printf("%-4d", score[i]);
		}
	}// 생성자

	public static void main(String[] args) {
		new UseArray1_1();
	}
}
