package day0329;

/**
 *	JDK1.5에서부터 제공되는 출력 method <br>
 *	System.out.printf("출력메세지",출력 값......); <br>
 *	System.out.format("출력메세지",출력 값....); <br>
 *	출력 후 줄변경이 되지 않는다 <br>
 * @author owner
 */
public class UsePrintf {

	public static void main(String[] args) {
		System.out.printf("오늘은 %d일 입니다\n",29);
		System.out.format("오늘은 %d일 입니다\n",29);
		//정수 출력
		int year=2018;
		System.out.printf("[%d][%6d][%-6d]\n",year,year,year);
		//문자
		char c='A';
		System.out.printf("[%c][%3c][%-3c]\n",c,c,c);
		//실수
		double d=1.2345;
		System.out.printf("[%f][%.2f][%-6.2f][%-6.2f]\n",d,d,d,d);
		//문자열
		String str="지승민";
		System.out.printf("[%s][%8s][%-8s]\n",str,str,str);
		
	}//main

}//class
