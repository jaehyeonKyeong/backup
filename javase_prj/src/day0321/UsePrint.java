package day0321;
/**
	자바 표준 출력 method 사용
	System.out.println(값);		-출력 후 줄 변경o
	Systme.out.print(값);		-출력 후 줄 변경x
*/
class UsePrint{

	public static void main(String[] args){

		/* System.out.print("안녕");
		System.out.print("자바");*/

		//////////////상수 출력///////////////
		System.out.println(3);//정수 상수
		System.out.println(3.21);//실수상수
		System.out.println(true);//boolean상수	
		System.out.println('A');//문자상수
		System.out.println('가');//문자상수
		System.out.println('1');//문자상수
		//System.out.println('12');//문자상수 : Error
		System.out.println("출력연습");//문자열 상수

		/////변수
		int i = 0;
		System.out.println(i);//변수의 출력

		///// 연산식 : 연산된 결과만 출력
		System.out.println(3+21);
		System.out.println("3+21="+3+21); //문자열을 사용후 + 연산자를 사용하게 되면 정수상수를 숫자로 인식하지 않고 문자열로 인식함.

	} //main	

} //class

/*
저장 : UsePirnt.Java
컴파일 : javac UsePrint.Java (성공 : bytecode생성)
실행 : java UsePrint
*/