package day0420;

import java.text.DecimalFormat;

public class UseDecimalFormat {
	
	public UseDecimalFormat() {
		int i=2018;
		
		DecimalFormat df1=new DecimalFormat("#,###,###");
		DecimalFormat df2=new DecimalFormat("0,000,000");
		DecimalFormat df3=new DecimalFormat("#,###");
		DecimalFormat df4=new DecimalFormat("#,###.00");
		
		System.out.println(df1.format(i));
		System.out.println(df2.format(i));
		System.out.println(df3.format(2147483647));//������ �ڸ����� �Ѿ�� ���� ���� ������ ã�Ƴ� ,�� �˾Ƽ� ����ش�.
		//jdk1.7+ ���ڿ� '_'�����ڸ� ����Ͽ� �б� ���ϰ� �ۼ��� �� �ִ�.
		System.out.println(df3.format(2_147_483_647));
		System.out.println(df4.format(2147));
		System.out.println(df4.format(2147.55));//������ ��� ����� �� �ִ�.
	}

	public static void main(String[] args) {
		new UseDecimalFormat();
	}//main

}//class
