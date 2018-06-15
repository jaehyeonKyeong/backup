package day0409;

/**
 * 추상클래스는 아니지만 객체를 생성하여 사용하지 않는 클래스
 * 
 * @author owner
 */
public class UseMath {
	public UseMath() {
		// Math m=new Math(); // 생성자가 private접근지정자여서 객체를 생성할 수 없음
		System.out.println("-9의 절대값 : "+Math.abs(-9));
		System.out.println("3.4의 반올림 : "+Math.round(3.4));
		System.out.println("3.4의 올림 : "+Math.ceil(3.4));
		System.out.println("3.4의 내림 : "+Math.floor(3.4));
		double d=Math.random();
		System.out.println("발생 난수 : "+d);
		System.out.println("범위 난수 : "+d*10);
		System.out.println("정수 난수 : "+(int)(d*10));
		
		//영어 소문자 (a(97)~z(122) : 25개)
		//대문자 (65)
		//숫자(4)
		System.out.println((char)(d*26+97));
		
		
		

	}// contructor

	public static void main(String[] args) {
		new UseMath();
	}// main

}// class
