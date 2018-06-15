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
		System.out.println(df3.format(2147483647));//지정한 자리수를 넘어가는 수가 들어가면 패턴을 찾아내 ,을 알아서 찍어준다.
		//jdk1.7+ 숫자에 '_'구분자를 사용하여 읽기 편하게 작성할 수 있다.
		System.out.println(df3.format(2_147_483_647));
		System.out.println(df4.format(2147));
		System.out.println(df4.format(2147.55));//패턴은 섞어서 사용할 수 있다.
	}

	public static void main(String[] args) {
		new UseDecimalFormat();
	}//main

}//class
