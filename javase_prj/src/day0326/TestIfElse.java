package day0326;

/**
 * if~else<br>
 * ���� �ϳ��� �ڵ带 �����ؾ��ϴ� ��� ���<br>
 * if(���ǽ�){<br>
 * ���ǿ� ������� �����ڵ�;<br>
 * }else{<br>
 * ���ǿ� ���� ������� �����ڵ�;<br>
 * }<br>
 * 
 * @author owner
 */
public class TestIfElse {

	public static void main(String[] args) {

		int num = Integer.parseInt(args[0]);
		// �Էµ� ���� �������� ������� �Ǵ�.

		System.out.print("�Էµ� �� " + num + "(��)��");
		if (num > -1) {// ���
			System.out.println(" ����Դϴ�.");
		} else {// ����
			System.out.println(" �����Դϴ�.");
		} // end if

		// �Էµ� ���� Ȧ������ ¦������ �Ǵ�.
		if (num % 2 == 0) {
			System.out.println("¦���Դϴ�");
		} else {
			System.out.println("Ȧ���Դϴ�");
		} // end if

		// �Էµ� ���� 0~100���̸� ��ȿ�� �׷��� ������ ��ȿ�� ���
		if (num >= 0 && num <= 100) {
			System.out.println("��ȿ");
		} else {
			System.out.println("��ȿ");
		} // end if

		// �Էµ� �̸��� "���¹�"�̶�� '����'�� �׷��� ������ '���'�� ����ϼ���
		if (args[1].equals("���¹�")) {
			System.out.println("����");
		} else {
			System.out.println("���");
		} // end if

	}// main

}// class
