package day0329;

/**
 * JDK 1.5+ 부터 제공되는 출력 method<br>
 * System.out.printf("출력 메시지", 출력값,,,,,);<br>
 * System.out.format("출력 메시지", 출력값,,,,);<br>
 * 출력 후 줄 변경이 되지 않음.<br>
 * @author owner
 */
public class UsePrintf {
	
	public static void main(String[] args) {
		
		System.out.printf("오늘은 %3d일 입니다.\n",29);
		System.out.format("오늘은 %3d일 입니다.\n",29);
		
		int year=2018;
		System.out.printf("[%d][%6d][%-6d]\n",year,year,year);
		
		char c='A';
		System.out.printf("[%c][%3c][%-3c]\n",c,c,c);
		
		double d=1.2345;
		System.out.printf("[%f][%.2f][%6.2f][%-6.2f]\n",d,d,d,d);
		
		String str="지승민";
		System.out.printf("[%s][%8s][%-8s]",str,str,str);
	}//main
}//class
