package day0330;

/**
 * �������� ���<br>
 * ��ü�� �����ɶ� �����Ǵ� ��ü�� ������ �� �ʱⰪ, �Ǵ� ����Ǿ�� �� �ڵ带 �����ϴ� method�� ����<br>
 * new�θ� ȣ�� ����<br>
 * �����ڴ� ��ӵ��� �ʴ´�<br>
 * ������ �ȿ��� this();�� ����ϸ� �� Ŭ������ �ٸ� �����ڸ� ȣ���ϰ�, super();�� ����ϸ� �θ� Ŭ������ �����ڸ� ȣ���Ҽ�
 * �ִ�.
 * 
 * @author owner
 */
public class UseConstructor {

	 public UseConstructor() {
	 System.out.println("�⺻������");
	 test(1);
	 }
	 public UseConstructor(int i) {
	 System.out.println("���� �ִ� ������");
//	 UseConstructor(); // �����ڴ� methodó�� �����Ҽ� ����.
	 }
	 public void test(int i) {
		 System.out.println(i);
	 }

	public static void main(String[] args) {
		new UseConstructor();
	}// main
}// class
