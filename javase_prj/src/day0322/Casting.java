package day0322;
/**
	강제 형 변환: 개발자가 원하는 데이트형으로 일시적으로 변환을 하는것.
*/
class Casting{
	public static void main(String[] args) {
		
		float f=(float)3.22;//상수
		System.out.println("강제형변환되어 할당된값 : "+f);

		double d=3.22;
		float f1=(float)d;//변수
		System.out.println("강제형변환되어 할당된값 : "+f1);

		int i=(int)d;//강제형변환은 값 손실이 발생할 수 있다
		System.out.println("원본값 : "+d+", 변환 값 : "+i);
		//boolean은 강제형변환이 다른형으로는 될 수 없다.
		boolean b=true;
		//int j = (int)b;
		boolean b1=(boolean)b;
		System.out.println("원본값 : "+b+", 변환 값 : "+b1);

		//자동형 변환된 값을 강제 형 변환
		byte num1=10,num2=20,result=0;
		//자동형 변환: int의 하위데이터형이 연산되면 결과는 int로 발생된다.
		result=(byte)(num1+num2);
		System.out.println(num1+"+"+num2+"="+result);
		
		//참조형(String)이 기본형(int)로는 강제형변환이 되지 않는다.(반대도 마찬가지)
		/*String s="22";
		int temp=s;*/
		/*int temp=22;
		String s=(String)temp;*/ // error

	}//main
}//class
