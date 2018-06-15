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
		System.out.println("제 이름은 경제현입니다.");
	}
	public void homework4(int num1,int num2) {
		
		if(num1>num2) {
			System.out.println("입력받은 값 "+num1+"과 "+num2+"중에서 값이 작은 값은 "+num2+"입니다.");
		}else if(num1<num2) {
				System.out.println("입력받은 값 "+num1+"과 "+num2+"중에서 값이 작은 값은 "+num1+"입니다.");
		}else {
			System.out.println("입력받은 값 "+num1+"과 "+num2+"(은)는 같습니다");
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
		System.out.println("---------------------문제1---------------------");
		int age = 25;
		int birthYear=h.homework1(age);
		System.out.println("나이 "+age+"살의 태어난 년도는 " +birthYear+"년 입니다.");
		
		System.out.println("---------------------문제2---------------------");
		char inputChar='A';
		int uni=h.homework2(inputChar);
		System.out.println("입력된 문자 '"+inputChar+"' 의 유니코드 값은 "+uni+" 입니다.");
		
		System.out.println("---------------------문제3---------------------");
		h.homework3();
		
		System.out.println("---------------------문제4---------------------");
		int inputNum1=23;
		int inputNum2=28;
		h.homework4(inputNum1, inputNum2);
		
		
		System.out.println("---------------------문제5---------------------");
		int year=h.homework5();
		System.out.println("올해는 "+year+"년 입니다.");

		System.out.println("---------------------문제6---------------------");
		int num1=33;
		int num2=31;
		int sum=h.homework6(num1, num2);
		System.out.println(" 두 수간의 합은 "+sum+"입니다.");


		
	}
}
