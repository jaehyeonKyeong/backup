package day0406;

/**
 * Ŭ���� �ȿ� Ŭ������ �����ϰ� ����ϴ� inner class<br>
 * ����Ŭ������ �ν��Ͻ� ����ó�� ����� ��<br>
 * �ܺ�Ŭ������ ����Ŭ������ �ڿ��� �ݵ�� ��üȭ �Ͽ� ����ϰ�,<br>
 * ����Ŭ���������� �ܺ�Ŭ������ �ڿ��� ���� ����� �� �ִ�.
 * 
 * @author owner
 */
public class TestOuter {
	int i;

	public TestOuter() {
		System.out.println("�ܺ�Ŭ������ ������");
	}

	public void outMethod() {
		System.out.println("�ܺ�Ŭ������ method i=" + i);
		// System.out.println("����Ŭ������ ���� "+j);//���� ���Ұ���
		// inMethod();//���� ȣ��Ұ���
		
		//����Ŭ������ ��üȭ
		TestOuter.Inner in=this.new Inner();
		in.inMethod();
		in.j=100;
	}//out method

	////////////////////////// inner class ���� /////////////////////////////
	public class Inner {
		int j;

		public Inner() {
			System.out.println("���� Ŭ������ ������");
		}// inner

		public void inMethod() {
			System.out.println("���� Ŭ������ method, j="+j );
			//����Ŭ���������� �ܺ�Ŭ������ �ٱ� Ŭ������ �ڿ��� ���� ��밡��.
			System.out.println("�ٱ�Ŭ������ ���� i="+i );
		}// inMethod
	}

	///////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		// 1.�ٱ� Ŭ������ ��üȭ
		TestOuter to = new TestOuter();
		to.outMethod();// �ٱ� class�� �޼ҵ� ȣ��
		// 2.���� Ŭ������ �ڿ��� ����ϱ� ���� ����Ŭ������ ��üȭ �Ѵ�.
		// Inner in = new Inner();//���� Ŭ������ �Ϲ� ��üȭ�� ��ü�� ������ �� ����.
		// �ܺ�Ŭ������.����Ŭ������ ��ä��= �ܺ�Ŭ������ü��.new ����Ŭ���� ������(); 
//		TestOuter.Inner inner = to.new Inner();//�ܺ�Ŭ���� ���� ��������(: Inner inner = to.new Inner();)
//		inner.j=100;//����Ŭ������ �ڿ� ���
//		inner.inMethod();// ����Ŭ������ method ȣ��
		

	}// main

}// class
