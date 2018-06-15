package day0327;

/**
 *	switch~case를 사용한 설정된 점수의 학점 구하기 *	
 * @author owner
 */
public class TestSwitchCase1 {

	public static void main(String[] args) {
		
		/*//break를 최대로 사용한 경우
		int score = 89;
		char grade=' ';  
		
		switch(score/10) {
		case GradeType.GRADE_A_PLUS : 
		case GradeType.GRADE_A : grade='A'; break;
		case GradeType.GRADE_B : grade='B'; break;
		case GradeType.GRADE_C : grade='C'; break;
		case GradeType.GRADE_D : grade='D'; break;
		default : grade='F';		
		}//end switch
		*/
		
		int score = 60;
		char grade=64;  
		
		switch(score/10) {
		default : grade+=2;
		case GradeType.GRADE_D : grade++; 
		case GradeType.GRADE_C : grade++;
		case GradeType.GRADE_B : grade++;
		case GradeType.GRADE_A : 
		case GradeType.GRADE_A_PLUS : grade++; break;
		
		}//end switch
		
		System.out.println(score+"점수의 학점은 "+grade+"입니다");
	}//main

}//class
