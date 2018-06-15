package day0329;

/**
 * JDK 1.5+ ���� �����Ǵ� ��� method<br>
 * System.out.printf("��� �޽���", ��°�,,,,,);<br>
 * System.out.format("��� �޽���", ��°�,,,,);<br>
 * ��� �� �� ������ ���� ����.<br>
 * @author owner
 */
public class UsePrintf {
	
	public static void main(String[] args) {
		
		System.out.printf("������ %3d�� �Դϴ�.\n",29);
		System.out.format("������ %3d�� �Դϴ�.\n",29);
		
		int year=2018;
		System.out.printf("[%d][%6d][%-6d]\n",year,year,year);
		
		char c='A';
		System.out.printf("[%c][%3c][%-3c]\n",c,c,c);
		
		double d=1.2345;
		System.out.printf("[%f][%.2f][%6.2f][%-6.2f]\n",d,d,d,d);
		
		String str="���¹�";
		System.out.printf("[%s][%8s][%-8s]",str,str,str);
	}//main
}//class
