package day0321;
/**
	지역변수
	method 내에 선언하는 변수
*/
class TestLocalVariable{
	public static void main(String[] args){
		//1.변수 선언 : 데이터형 변수명;
		int age1=21;
		int my_age;
		int my$age;
		//같은 이름의 변수를 선언하면 error
		//double age;
		//2.값 할당 : 변수명 = 값;
		
		age1 = 21;
		my_age = 22;
		my$age = 23;
		//3. 값 사용 : 출력, 다른 변수에 할당, 연산
		System.out.println(age1);
		System.out.println(my_age);
		System.out.println(my$age);
		System.out.println(age1+my_age+my$age);


	}//main
}//class