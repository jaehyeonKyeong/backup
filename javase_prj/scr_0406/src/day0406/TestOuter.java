package day0406;

/**
 * Ŭ���� �ȿ� Ŭ������ �����ϰ� ����ϴ� inner class <br>
 * ����Ŭ������ �ν��Ͻ� ����ó�� ����� �� <br>
 * 	�ܺ� Ŭ������ ����Ŭ������ �ڿ��� �ݵ�� ��üȭ �Ͽ� ����ϰ�, ����Ŭ���������� �ܺ�Ŭ������ �ڿ��� ���� ����� �� �ִ�
 * @author owner
 */
public class TestOuter {
	int i;
	public TestOuter() {
		System.out.println("�ܺ�Ŭ������ ������");
	}//TestOuter
	
	public void outMethod() {
		System.out.println("�ܺ� Ŭ������ method");
		System.out.println("�ܺ� Ŭ������ ���� i "+i);
//		System.out.println("���� Ŭ������ ���� j "+j); // �ܺ�Ŭ���������� ����Ŭ������ �ڿ� ���Ұ�
		
		//���� Ŭ������ ��üȭ!!!
		TestOuter.Inner in = this.new Inner();
		in.j=300; //��üȭ �� ����Ŭ���� �ڿ� ��� ����
		in.inMethod(); //��üȭ �� ����Ŭ���� �ڿ� ��� ����
	}//out Method
	
	//////////////////////////////////////inner class ����//////////////////////////////////////
	public class Inner{
		int j=0;
		public Inner() {
			System.out.println("���� Ŭ������ ������");
		}//Inner
		public void inMethod() {
			System.out.println("���� Ŭ������ method, j "+j);
			System.out.println("�ٱ� Ŭ������ ���� i "+i);//����Ŭ���������� �ܺ�Ŭ���� �ڿ� ��� ����
//			outMethod(); //����Ŭ���������� �ܺ�Ŭ���� �ڿ� ��� ����
		}//inMethod
	}// inner class
	//////////////////////////////////////inner class ��//////////////////////////////////////
	

	public static void main(String[] args) {
		//1. �ٱ� Ŭ������ ��üȭ
		TestOuter to = new TestOuter();
		to.i=100;
		to.outMethod(); //�ٱ� Ŭ������ method ȣ��
		System.out.println("�ٱ� Ŭ������ ���� i :"+to.i);
//		to.inMethod(); //�ܺ�Ŭ�������� ����Ŭ������ �ڿ� ��� �Ұ�
//		System.out.println("�ٱ� Ŭ������ ���� i :"+to.j); //�ܺ�Ŭ�������� ����Ŭ������ �ڿ� ��� �Ұ�
		
//		Inner in = new Inner(); //����Ŭ������ �Ϲݰ�üȭ�� ��ü�� ������ �� ����
		//�ܺ�Ŭ������.����Ŭ������ ���ΰ�ü�� = �ܺ�Ŭ������ü��.new ����Ŭ����������();
		TestOuter.Inner in = to.new Inner(); //�ܺ�Ŭ�������� ���� ����
		@SuppressWarnings("unused")
		Inner in2 = to.new Inner();
		in.j=200;
		in.inMethod(); //���� Ŭ������ method ȣ��
		

	}// main

}//class
