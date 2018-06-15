package day0328;

/**
 *	Method�� ���� <br>
 * @author owner
 */

//public//access modifier
//int //return type
//typeD //method name
//(float f) // parameter


public class MethodType {
	
	/**
	 * ��ȯ�� ����, �Ű����� ���� �� - ������
	 *
	 */
	public void typeA() {
		System.out.println("������");
	}//typeA
	
	/**
	 * ��ȯ�� ����, �Ű����� �ִ� �� - ������
	 * @param i �Ķ����
	 */
	public void typeB(int i) {
		System.out.println("������ i :"+i);
	}//typeB
	
	/**
	 * ��ȯ�� �ְ�, �Ű����� ���� �� - ������
	 * @return ���尪
	 */
	public int typeC() {
//		System.out.println("������");
		return 21;
	}//typeC
	
	/**
	 * ��ȯ�� �ְ�, �Ű����� �ִ� �� - ������
	 * @param f �Ķ����
	 * @return ������
	 */
	public int typeD(float f) {
//		System.out.println("������ i :"+f*2);
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
		System.out.println("������ : "+temp1+" / "+temp2+" / "+temp3);
		System.out.println();

	}//main

}//class
