package day0321;
/**
	지역변수의 사용
	method내에 선언하는 변수
*/
class TestLocalVarable{

	public static void main(String[] args){

		//1. 변수의 선언 : 데이터형 변수명;
		int age;
		//double age;// 같은 이름의 변수를 선언하게 되면 error
		//int month;//초기화 하지 않은 변수의 사용 error
		//초기화 : 변수 선언과 값 할당을 동시에 한 것
		//2. 값할당 : 변수명=값;
		int month=3;
		//변수명은 한글도 가능(아무도 쓰지 않음)
		int 나이=25;
		//숫자는 변수명의 가장 처음에 쓰지 못함(마지막이나 중간은 가능)
		//int 1age=3; //error
		// 지역변수에 사용가능한 특수문자'_','$' // _ 는 마이너스와 혼란 $는 다른 기능과 헷갈리기 때문에 권장하지 않음.
		int my_age;
		int my$age;
		int age1;
		age1=21;
		my_age=22;
		my$age=23;
		age=20;
		//3.값 사용 : 출력, 재할당(다른변수에 할당), 연산
		System.out.println(age);
		System.out.println(month);
		System.out.println(나이);
		System.out.println(age1);
		System.out.println(my_age);
		System.out.println(my$age);
		System.out.println(age1+my_age+my$age);

	}//main

}//class