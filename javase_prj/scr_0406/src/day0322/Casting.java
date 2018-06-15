package day0322;
/*
	강제 형변환 : 개발자가 원하는 데이터형으로 일시적인 변환을 하는 것
*/
class Casting{
	public static void main(String[] args) {
		float f = (float) 3.22; //상수
		System.out.println("강제 형변환되어 할당된 값 :"+f);

		double d = 3.22;
		float f1 = (float) d; //변수
		System.out.println("double에서 강제 형변환되어 할당된 값 :"+f1);
		
		int i = (int) d; //강제 형변환은 값 손실이 발생할 수 있다
		System.out.println("double에서 int로 강제 형변환되어 할당된 값 :"+i);

		//boolean은 강제 형변환이 다른형으로 될 수 없다
		boolean b = true;
		//int j = (int) b; 불가
		boolean b1 = (boolean) b;
		System.out.println("boolean : "+b+","+b1);

		//자동 형변환된 값을 강제 형변환
		byte num1 = 10, num2 = 20, result = 0;
		result = (byte) (num1 + num2);
		System.out.println(num1+"+"+num2+"="+result);


		//참조형(String)이 기본형(int)로는 강제 형변환이 되지 않는다
		//String s = "22";
		//int temp = (int) s;  //error
		//기본형(int)이 참조형(String)으로는 강제 형변환이 되지 않는다
		//int temp = 22;
		//String s = (String) temp;  //error



	}
}
