package day0327;

/**
 * switch ~ case�� ����� ������ ������ ���� ���ϱ�
 * 
 * @author owner
 */
public class TestSwitchCase2 {

	public static void main(String[] args) {
		int score = 80;
		// char grade = ' '; //break�� �ִ�� ����Ѱ��
		char grade = 64;

		switch (score / 10) { // break�� �ּ�ȭ�Ͽ� ���� ���ϱ�
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

		System.out.println(score + "���� ������ " + grade + "�Դϴ�");

	}// main

}// class
