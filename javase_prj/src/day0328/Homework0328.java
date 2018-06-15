package day0328;

import java.time.Year;

public class Homework0328 {
	/////////////////////////////////method///////////////////////////////
	//숙제 1
	public static int bornYear (int age) {
		int bornYear=0;
		int nowYear=Year.now().getValue();
		bornYear = nowYear - age + 1;
		return bornYear;
	}//bornYear
	
	//숙제 2
	public static int unicode(char c) {
		return (int) c;		
	}//unicode
	
	//숙제 3
	public static void printName(String myName) {
		System.out.println(myName);
	}
	
	//숙제 4
	public static void printSmallNumber(int num1, int num2) {
		System.out.print(num1+"과 "+num2+"중 작은 수는 : ");
		System.out.println((num1>num2)?num2:num1);
	}
	
	//숙제 5
	public static int thisYear() {
		return Year.now().getValue();
	}
	
	//숙제 6
	public static int betweenSum(int num3, int num4) {
		int result = 0;
		int temp=0;
		if (num3>num4) {
			temp=num3;
			num3=num4;
			num4=temp;
		}
		for(int i=num3;i<num4+1;i++) {
			result+=i;
		}
		return result;
	}

	public static void main(String[] args) {
		
		//숙제 1 
		int age=42;
		int bornYear = bornYear(age);
		System.out.println("당신의 나이는 "+age+"살 입니다. 당신이 태어난 해는 "+bornYear+"년 입니다.");
		
		//숙제 2 
		char c = 'A';
		int result = unicode(c);
		System.out.println(c+"의 unicode는 "+result+"입니다.");
		
		//숙제 3
		String myName="이형식";
		printName(myName);
		
		//숙제 4
		int num1= -10, num2=5;
		printSmallNumber(num1,num2);
		
		//숙제 5 
		int thisYear = thisYear();
		System.out.println("올해는 "+thisYear+"년 입니다.");
				
		//숙제 6
		int num3=10,num4=-10;
		int sum = betweenSum(num3,num4);
		System.out.println("입력된 두수 "+num3+", "+num4+" 간의 모든 정수의 합은 "+sum+"입니다." );

	}

}
