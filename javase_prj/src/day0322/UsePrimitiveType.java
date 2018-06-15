package day0322;
/**
	기본형 데이터형에 대한 사용
*/
class UsePrimitiveType{
	public static void main(String[] args) 
	{
		//정수형 데이터형을 사용한 변수 선언
		byte a=10;
		short b=20;
		int c=30;
		long d=40;//할당되는 정수의 범위가 4byte 내라면 형명시를 생략할수 있다.
		long e=2147483648L;//형명시 : literal의 크기를 일시적으로 변경
		System.out.println("byte: "+a+", short: "+b+", int : "+c+", long: "+d+" e : "+e);
		/////////////////////문자형 : 문자에대한 unicode값이 저장
		char f='A';//65
		char g='0'; //48
		char h='가';//44032
		System.out.println("char : "+f+", "+g+", " +h);
		///////실수형
		float i =3.22F;//형명시(8byte -> 4byte)
		double j=3.22;//형명시 생략가능
		double k=3.22D;//형명시 사용
		System.out.println("float: "+i+", double: "+j+", "+k);
		///////boolean형
		boolean l = true;
		boolean m=false;
		System.out.println("boolean: "+l+", "+m);
		byte num1=10;
		byte num2=20;
		int num3=0;
		num3=num1+num2;
		System.out.println(num1+"+"+num2+"="+num3);
		
	}//main
}//class
