package day0330;

/**
 *	�������� ��� <br>
 *	�����Ǵ� ��ü�� ������ �� �ʱⰪ, ����Ǿ�� �� �ڵ带 �����ϴ� method�� ���� <br>
 *	new�θ� ȣ�� ���� <br>
 *	�����ڴ� ��ӵ��� �ʴ´� <br>
 *	������ �ȿ��� this(); ����ϸ� �� Ŭ������ �ٸ� �����ڸ� ȣ���ϰ�, Super(); ����ϸ� �θ�Ŭ������ �����ڸ� ȣ���Ѵ�
 * @author owner
 */
public class UseConstructor {
	
	public UseConstructor() {
		System.out.println("�⺻������");
//		UseConstructor(100); // �����ڴ� ���� ȣ�� �� �� ����
//		test(100); // method�� ���� ȣ�� ����
	}//UseConstructor
	
	//�Ű����θ� �ٸ����Ͽ� overloading
	public UseConstructor(int i) {
		System.out.println("�����ִ� ������");
	}//UseConstructor
	
	public void test(int i) {
		System.out.println("test method "+i);
	}

	public static void main(String[] args) {
		new UseConstructor();
		
		

	}//main

}//class
