package day0323;
/**
	main method의 인자 값 넣기
	java 클래스명 값 값 값 ...... (~21억개까지 가능)
	java TestArguments 오늘은 금요일 퇼
*/

class  TestArguments{
	public static void main(String[] args) {
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);

		int i =Integer.parseInt(args[0]); // 정수형태의 문자열을 정수로 변환.
		int j =Integer.parseInt(args[1]);
		System.out.println(args[0]+args[1]);
		System.out.println(i+j);
	}//main
}//class
