package day0406;

/**
 *	����Ŭ������ static ����ó�� ����ϱ� ���� Ŭ����
 * @author owner
 */
public class TestNested {
	
	int i;
	static int j;
	public TestNested() {
		System.out.println("�ٱ� Ŭ������ ������");
	}//TestNested

	public void methodA() {
		System.out.println("�ٱ� Ŭ������ �ν��Ͻ� method");
	}//methodA
	
	public static void methodB() {
		System.out.println("�ٱ� Ŭ������ static method");
	}//methodB
	
	///////////////////////////////////// Nested Class ���� //////////////////////////////////////////////
	//��üȭ�Ͽ� ������� �ʵ��� instance����, instance method�� �������� �ʴ´�
	static class NestedInner{
//		int i; // Nested class������ �Ϲ� instance ������ ����� �ʿ䰡 ����
		static int j;
		public static void inMethod() {
			System.out.println("����Ŭ������ method, j="+j);
//			System.out.println("�ٱ�Ŭ������ ���� i "+i); //���Ұ�
			System.out.println("�ٱ�Ŭ������ ���� j "+TestNested.j); // static ���� j�� ��밡��
//			methodA(); // ������ �ٸ��Ƿ� ���� ȣ�� �Ұ�
			methodB(); // �ܺ� Ŭ������ static method ȣ�� ����
//			TestNested.methodB(); //�� ����� ���� 
		}//inMethod
		
	}// class
	
	///////////////////////////////////// Nested Class ��  //////////////////////////////////////////////
	
	public static void main(String[] args) {
		//��ø Ŭ������ ��üȭ���� �ʰ� ���
		j=200; //TestNested.j
		NestedInner.j=100; // ����Ŭ��������
		NestedInner.inMethod();

	}//main

}//class
