package day0328;

/**
 *	 method ���� <br>
 *	instance method : ��ü���� �ν��Ͻ� ������ ����Ͽ� ��ó�� �ϴ� ��� �ۼ� <br>
 *							��üȭ �Ͽ� ��ü��.������ ���·� ��� <br>
 *	static method : ��ü���� �ν��Ͻ� ������ ������� �ʰ� ��ó�� �ϴ� ��� �ۼ� <br>
 *							��üȭ ���� �ʰ� method��.������ ���·� �ٷ� ��� <br>
 *	
 *	int i=Integer.parseInt("11"); //static method <br>
 *	
 *	���� instance method�̾��ٸ� 	Integer i = new Integer("11"); <br>
 *											int temp = i.parseInt(); <br>
 *	���·� ���Ǿ���� �� ���̴� <br>
 * @author owner
 */
public class TestMethod {
	
	public void methodA() {
		System.out.println("instance method : ��üȭ �ʼ�");
	}//method
	
	public static void methodB() {
		System.out.println("static method : ��üȭ ���� ����");
	}//method

	public static void main(String[] args) {
		
		//instance method ȣ��
		//1. ��üȭ
		TestMethod tm = new TestMethod();
		
		//2. ȣ��
		tm.methodA();
		
		//static method ȣ��
//		tm.methodB(); //����
		// ��ü�������� ȣ�� �����ϴ� static �������� ����� ��õ
		methodB();
		

	}//main

}//class