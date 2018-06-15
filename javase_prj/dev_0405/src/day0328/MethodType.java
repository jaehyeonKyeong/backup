package day0328;

/**
 *	Method의 형태 <br>
 * @author owner
 */

//public//access modifier
//int //return type
//typeD //method name
//(float f) // parameter


public class MethodType {
	
	/**
	 * 반환형 없고, 매개변수 없는 형 - 고정일
	 *
	 */
	public void typeA() {
		System.out.println("고정일");
	}//typeA
	
	/**
	 * 반환형 없고, 매개변수 있는 형 - 가변일
	 * @param i 파라메터
	 */
	public void typeB(int i) {
		System.out.println("가변일 i :"+i);
	}//typeB
	
	/**
	 * 반환형 있고, 매개변수 없는 형 - 고정값
	 * @return 고장값
	 */
	public int typeC() {
//		System.out.println("고정값");
		return 21;
	}//typeC
	
	/**
	 * 반환형 있고, 매개변수 있는 형 - 가변값
	 * @param f 파라메터
	 * @return 가변값
	 */
	public int typeD(float f) {
//		System.out.println("가변값 i :"+f*2);
		return (int)f;
	}//typeD
	
	public static void main(String[] args) {
		
		MethodType mt = new MethodType();
		mt.typeA();
		mt.typeB(3);
		mt.typeB(30);
		mt.typeB(300);
		System.out.println(mt.typeC());
		int temp1=mt.typeD(3.35f);
		int temp2=mt.typeD(2018.3f);
		int temp3=mt.typeD(33.28f);
		System.out.println("가변값 : "+temp1+" / "+temp2+" / "+temp3);
		System.out.println();

	}//main

}//class
