package day0419;

/**
 * 사용자 정의 예외처리 클래스<br>
 * 제작하는 클래스가 예외를 처리할 수 있도록 Exception, RuntimeException을 상속 받는다.<br>
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class TabaccoException extends Exception {

	public TabaccoException() {
		this("흡연은 건강에 해롭습니다.");

	}// constructor

	public TabaccoException(String msg) {
		super(msg);// 부모 class의 생성자에 전달된 message는 getMessage(),또는 예외처리 객체를 출력하거나 printStackTrace()를
					// 호출할때 출력된다.
	}// constructor

}// class
