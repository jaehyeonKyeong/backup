package day0327;

/**
 *switch~case : 정수를 비교할 때 사용하는 조건문
 *문법) switch(변수명){<br>
 *			case 상수 : 변수의 값이 상수와 일치할 때 수행할 문장;<br>
 *				break;<br>
 *			.<br>
 *			.<br>
 *			default : 변수의 값이 상수와 일치하는 것이 없을 때 수행 문장<br>
 *		}
 * @author owner
 */
public class TestSwitchCase {
	public static final int ZERO = 0; //스위치의 가독성을 개선
	public static final int ONE = 1;
	public static final int TWO = 2;
	public static final int THREE = 3;

	public static void main(String[] args) {
		
		int i = 0; //byte, short, int, char 사용가능
		
		switch (i) {
		case ZERO: 
			System.out.println("변수의 값이 0과 같음");
			break;
		case ONE:
			System.out.println("변수의 값이 1과 같음");
			break;
		case TWO:
			System.out.println("변수의 값이 2과 같음");
			break;
		case THREE:
			System.out.println("변수의 값이 3과 같음");
			break;
		default:
			System.out.println("변수의 값이 상수와 일치하는 것이 없음");
		}//end switch
		/*
		char i = 'A'; //byte, short, int, char 사용가능
		
		switch (i) {
		case 'A':   //  == case 65 :
			System.out.println("변수의 값이 0과 같음");
			break;
		case 1:
			System.out.println("변수의 값이 1과 같음");
			break;
		case 2:
			System.out.println("변수의 값이 2과 같음");
			break;
		case 3:
			System.out.println("변수의 값이 3과 같음");
			break;
		default:
			System.out.println("변수의 값이 상수와 일치하는 것이 없음");
		}//end switch
			*/
		
		
			/*
			String j = "화"; //JDK 버전이 1.7이상인 경우에 사용가능					
			switch (j) {
			case "65" :   
				System.out.println("변수의 값이 '65'과 같음");
				break;
			case "화":
				System.out.println("변수의 값이 '화'와 같음");
				break;
			case "수":
				System.out.println("변수의 값이 '수'과 같음");
				break;
			case "목":
				System.out.println("변수의 값이 '목' 과 같음");
				break;
			default:
				System.out.println("변수의 값이 상수와 일치하는 것이 없음");
		}//end switch
		*/
		

	}//main

}//class
