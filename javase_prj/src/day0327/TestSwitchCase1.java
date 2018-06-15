package day0327;

/**
 * switch ~case:정수를 비교할때 사용하는 조건문<br>
 * switch (변수명){<br>
 * case 상수 : 수행 문장;<br>
 * break;<br>
 * . . . default: 변수의 값이 상수와 일치하는 것이 없을때 수행 문장; }
 * 
 * @author owner
 */
public class TestSwitchCase1 {
	public static final int ZERO=0;
	public static final int ONE=1;
	public static void main(String[] args) {
		 char i = 1; // byte, short, int, char만 가능
		//String i = "화"; // 문자열도 case상수의 형이 같으면 사용가능(JDK 1.7이상만 사용가능)
		// char 형일 경우 case의 상수를 문자상수나 그에 대한 Unicode값을 사용
		//int temp=0;//
		switch (i) {
		case ZERO: //case의 가독성을 높이기위해 constants를 사용
			System.out.println("변수의 값이 0과 같음");
			break;
		case ONE:
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
		}// end switch

	}// main

}// class
