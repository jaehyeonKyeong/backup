package day0322;
/**
	다른 클래스 안에 존재하는 상수 사용
*/
class UseConstant{
	public static void main(String[] args) 
	{
		//TestConstant.MAX_VALUE=10000;//값 변경 불가능
		//클래스명.상수명
		System.out.println(TestConstant.MAX_VALUE);
		System.out.println("byte의 최소값 : "+Byte.MIN_VALUE+", 최대값 :"+Byte.MAX_VALUE+", 크기:"+Byte.BYTES);
		System.out.println("long의 최소값 : "+Long.MIN_VALUE+", 최대값 :"+ Long.MAX_VALUE);

		int num1=10;//10진수
		int num2=012;//8진수
		int num3=0xa;//16진수

		System.out.println(num1+" / "+num2+" / "+num3);
		System.out.println(num1+num2+num3);

		//Wrapper class(Integer)의 기능 (method 호출)
		//10진수 값을 2진수의 문자열로 얻기
		System.out.println(num1+" 을(를) 2진수로 "+Integer.toBinaryString(num1));
		System.out.println(num1+" 을(를) 8진수로 "+Integer.toOctalString(num1));
		System.out.println(num1+" 을(를) 16진수로 "+Integer.toHexString(num1));

		

	}//main
}//class
