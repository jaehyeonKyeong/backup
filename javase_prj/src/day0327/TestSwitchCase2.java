package day0327;

/**
 * switch ~ case를 사용한 설정된 점수의 학점 구하기
 * 
 * @author owner
 */
public class TestSwitchCase2 {

	public static void main(String[] args) {
		int score = 80;
		// char grade = ' '; //break를 최대로 사용한경우
		char grade = 64;

		switch (score / 10) { // break를 최소화하여 학점 구하기
		case GradeType.GRADE_D:
			grade++;
		case GradeType.GRADE_C:
			grade++;
		case GradeType.GRADE_B:
			grade++;
		case GradeType.GRADE_A:
		case GradeType.GRADE_A_PLUS:
			grade++;
			break;
		default:
			grade += 6;

		}

		/*
		 * switch (score / 10) { case GradeType.GRADE_A_PLUS: case GradeType.GRADE_A:
		 * grade = 'A'; break; case GradeType.GRADE_B: grade = 'B'; break; case
		 * GradeType.GRADE_C: grade = 'C'; break; case GradeType.GRADE_D: grade = 'D';
		 * break; default: grade = 'F'; }//end switch
		 */

		System.out.println(score + "점의 학점은 " + grade + "입니다");

	}// main

}// class
