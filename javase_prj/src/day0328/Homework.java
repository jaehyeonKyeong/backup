package day0328;

public class Homework {
	
	public int homework1(int i) {
		int year=2018;
		int age=year-i+1;
		return age;
	}
	public int homework2(char c) {
		int uni=(int)c;
		return uni;
	}
	public void homework3() {
		System.out.println("�� �̸��� �������Դϴ�.");
	}
	public void homework4(int num1,int num2) {
		
		if(num1>num2) {
			System.out.println("�Է¹��� �� "+num1+"�� "+num2+"�߿��� ���� ���� ���� "+num2+"�Դϴ�.");
		}else if(num1<num2) {
				System.out.println("�Է¹��� �� "+num1+"�� "+num2+"�߿��� ���� ���� ���� "+num1+"�Դϴ�.");
		}else {
			System.out.println("�Է¹��� �� "+num1+"�� "+num2+"(��)�� �����ϴ�");
		}
	}//homework4
	public int homework5() {
		int year=2018;
		return year;
	}
	public int homework6(int num1,int num2) {
		int sum=0;
		if(num1>num2) {
			for(int i=num2; i<=num1; i++ )
				sum+=i;
		}else if(num1<num2){
			for(int i=num1; i<=num2; i++ )
				sum+=i;
		}else{
			sum=num1+num2;
		}
		return sum;
	}
	public static void main(String[] args) {
		
		Homework h=new Homework();
		System.out.println("---------------------����1---------------------");
		int age = 25;
		int birthYear=h.homework1(age);
		System.out.println("���� "+age+"���� �¾ �⵵�� " +birthYear+"�� �Դϴ�.");
		
		System.out.println("---------------------����2---------------------");
		char inputChar='A';
		int uni=h.homework2(inputChar);
		System.out.println("�Էµ� ���� '"+inputChar+"' �� �����ڵ� ���� "+uni+" �Դϴ�.");
		
		System.out.println("---------------------����3---------------------");
		h.homework3();
		
		System.out.println("---------------------����4---------------------");
		int inputNum1=23;
		int inputNum2=28;
		h.homework4(inputNum1, inputNum2);
		
		
		System.out.println("---------------------����5---------------------");
		int year=h.homework5();
		System.out.println("���ش� "+year+"�� �Դϴ�.");

		System.out.println("---------------------����6---------------------");
		int num1=33;
		int num2=31;
		int sum=h.homework6(num1, num2);
		System.out.println(" �� ������ ���� "+sum+"�Դϴ�.");


		
	}
}
