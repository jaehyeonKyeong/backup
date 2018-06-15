package day0321;
/**
	자바 표준 추력 method 사용
	System.out.println(값); -출력 후 줄 변경
	System.out.print(값); -출력 후 줄 변경 X
*/

public class UsePrint{
	public static void main(String[] args){
	//	System.out.println("안녕");
	//	System.out.println("자바");
	//	System.out.print("안녕");
	//	System.out.print("자바");
		//상수 출력//
		System.out.println(3);//정수 상수
		System.out.println(3.21);//실수 상수
		System.out.println(true);//불린 상수
		System.out.println('A');//문자 상수
		System.out.println('가');//문자 상수
		System.out.println('1');//문자 상수
		//System.out.println('12');//문자 상수
		System.out.println("출력연습");//문자열 상수
	
		//변수 출력//
		int i = 0;
		int j = 0;
		System.out.println(i);//변수의 출력
		
		//연산식 : 연산된 결과만 출력
		System.out.println(3+21);
		System.out.println("3+21="+(3+21)	);
		for (i=1;i<10;i++){
			for(j=2;j<10;j++){
				System.out.print(j+"*"+i+"="+(i*j)+'\t');
			}
		System.out.println();
		}
		//byte b=127;
		//char c=' ';
	}//main

}//class

/*
저장 : UsePrint.java
컴파일 : javac UsePrint.java (성공 : bytecode 생성)
실행 : java UsePrint(byte code)

*/