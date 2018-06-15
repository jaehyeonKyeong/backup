package day0323;
/*
	main method에 인자 값 넣기
	java 클래스명 값 값 값...
	java TestArguments 오늘은 금요일 퇼
*/
class TestArguments {
	public static void main(String[] args) {
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);

		System.out.println(args[0]+args[1]);
		//int i=args[0]; //문자열을 정수에 할당하거나 형 변환할 수 없다
		int i=Integer.parseInt(args[0]); //정수형태의 문자열을 정수로 전달
		int j=Integer.parseInt(args[1]);
		System.out.println(i+j);
	}//main
}//class
