package day0328;

/**
 * method ����<br>
 * instance method : ��ü���� �ν��Ͻ� ������ ����Ͽ� ��ó���ϴ� ��� �ۼ� = ��üȭ�� �Ͽ�
 * ��ü��.method��();ȣ��<br>
 * static method : ��ü���� �ν��Ͻ� ������ ������� �ʰ� ��ó���ϴ� ��� �ۼ� = Ŭ���� ��.method��();<br>
 * int i =Integer.parseInt("11");<br>
 * 
 * @author owner
 */
public class TestMethod {

	public void methodA() {
		System.out.println("instance method : ��üȭ �ʼ�");
	}// metohd

	public static void methodB() {
		System.out.println("static method : ��üȭ ���ʿ�");
	}// metohd

	public static void main(String[] args) {
		
		// instance method ȣ��
		// ��üȭ : class�� ��ü�� = new class��();
		TestMethod tm = new TestMethod();
		// ȣ�� : ��ü��.method��();
		tm.methodA();

		// static method ȣ��
		//tm.methodB(); //��ü�� ����Ͽ� ȣ�� �����ϳ� static ��� �������� ȣ��
		TestMethod.methodB();
		

	}// main

}// class
