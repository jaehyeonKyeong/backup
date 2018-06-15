package day0328;

/**
 * method의 형태<br>
 * 
 * @author owner
 */
public class MethodType {

	/**
	 * 반환형이 없고, 매개변수가 없는 형 - 고정일 <br>
	 */
	public void typeA() {
		System.out.println("고정일");
	}// typeA

	/**
	 * 반환형이 없고, 매개변수가 있는 형 - 가변일<br>
	 * 
	 * @param i
	 *            호출할때 정수를 입력해주세요.<br>
	 */
	public void typeB(int i) {
		System.out.println("가변 일 i :" + i);
	}// typeB

	/**
	 * 반환형이 있고, 매개변수가 없는 형 - 고정 값<br>
	 * 반환형이 존재한다면 method의 가장 마지막 줄에 반드시 return을 기술해주어야함<br>
	 * 
	 * @return 지나간 21분이 반환됩니다.
	 */
	public int typeC() { // 반환형이 있기 때문에 반드시 int형의 return이 있어야함.
		return 21;
	}// typeC

	/**
	 * 반환형이 있고, 매개변수도 있는 형 - 가변값<br>
	 * 
	 * @param f
	 *            실수형의 값
	 * @return 입력받은 실수형을 정수형으로 강제형변환한 값
	 */
	public int typeD(float f) {
		return (int) f;
	}// typeD

	public static void main(String[] args) {
		// instatance method를 호출하기 위해 객체화가 필요.
		MethodType mt = new MethodType();
		// 호출
		// 고정일
		mt.typeA();
		// 가변 일
		mt.typeB(3);
		// 고정값 -method가 처리한 결과 값을 받아 사용할수 있도록 method 앞에 결과 값을 저장하는 코드 작성
		int i = mt.typeC()+10;
		System.out.println("고정값 + 10 : "+i);
		System.out.println("고정값 직접호출 :" + mt.typeC());
		// 가변값
		int temp1 = mt.typeD(3.35f);
		int temp2 = mt.typeD(2018.3f);
		int temp3= mt.typeD(33.28f);
		
		System.out.println("가변값 : "+temp1+" / "+ temp2 + " /" + temp3);
		
		

	}// main

}// class
