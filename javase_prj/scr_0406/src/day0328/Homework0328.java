package day0328;

import java.time.Year;

public class Homework0328 {
	/////////////////////////////////method///////////////////////////////
	//���� 1
	public static int bornYear (int age) {
		int bornYear=0;
		int nowYear=Year.now().getValue();
		bornYear = nowYear - age + 1;
		return bornYear;
	}//bornYear
	
	//���� 2
	public static int unicode(char c) {
		return (int) c;		
	}//unicode
	
	//���� 3
	public static void printName(String myName) {
		System.out.println(myName);
	}
	
	//���� 4
	public static void printSmallNumber(int num1, int num2) {
		System.out.print(num1+"�� "+num2+"�� ���� ���� : ");
		System.out.println((num1>num2)?num2:num1);
	}
	
	//���� 5
	public static int thisYear() {
		return Year.now().getValue();
	}
	
	//���� 6
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
		
		//���� 1 
		int age=42;
		int bornYear = bornYear(age);
		System.out.println("����� ���̴� "+age+"�� �Դϴ�. ����� �¾ �ش� "+bornYear+"�� �Դϴ�.");
		
		//���� 2 
		char c = 'A';
		int result = unicode(c);
		System.out.println(c+"�� unicode�� "+result+"�Դϴ�.");
		
		//���� 3
		String myName="������";
		printName(myName);
		
		//���� 4
		int num1= -10, num2=5;
		printSmallNumber(num1,num2);
		
		//���� 5 
		int thisYear = thisYear();
		System.out.println("���ش� "+thisYear+"�� �Դϴ�.");
				
		//���� 6
		int num3=10,num4=-10;
		int sum = betweenSum(num3,num4);
		System.out.println("�Էµ� �μ� "+num3+", "+num4+" ���� ��� ������ ���� "+sum+"�Դϴ�." );

	}

}
