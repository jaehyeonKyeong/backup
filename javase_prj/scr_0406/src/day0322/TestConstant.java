package day0322;
/*
	변수를 상수처럼 사용하기
*/
class TestConstant{
	public static final int MAX_VALUE = 100;
	public static final int MIN_VALUE = 0;
	public static void main(String[] args) {
		//상수명
		System.out.println(MAX_VALUE+"/"+MIN_VALUE);
		int myScore = 85;
		//Constant는 값을 변경할 수 없다
		//TestConstant.MAX_VALUE = 50; //error
		//클래스명.상수명
		System.out.println("획득점수 : "+myScore+"만점 : "+TestConstant.MAX_VALUE+", 만점과의 차 : "+(TestConstant.MAX_VALUE-myScore)+"점");
			
	}//main
}//class
