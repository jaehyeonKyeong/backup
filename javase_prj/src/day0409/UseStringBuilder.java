package day0409;

import java.util.concurrent.SynchronousQueue;

/**
 * �� ���ڿ��� �ٷ�� String Builder ���
 * 
 * @author owner
 */
@SuppressWarnings("unused")
public class UseStringBuilder {

	public void useStringBuilder() {
		// 1.����
		StringBuilder sb = new StringBuilder();
		// �� ������
		int i = 9;
		double d = 11.31;
		String str = "�ڹ� ����";

		// sb.append(i);
		// sb.append(d);
		// sb.append(str);
		// method chain : method�� ;�� ���� �ʰ� .�� �̿��� ��� ȣ���ϴ� ����
		// sb.append(i).append(" ").append(d).append(str);

		sb.append("ABCD EFG");
		// ���� : ���ϴ� �ε����� ���� ���� �� �ִ�.

		sb.insert(5, "���¹�");
		sb.insert(4, "��õ���� ���ڶ�");
		// ABCD��õ���� ���ڶ� ���¹�EFG
		sb.delete(9, 13);// �����Ҷ��� �� index+1
		// ABCD��õ���� ���¹�EFG

		System.out.println(sb);
		// ��ü�� ����־����� �ּҰ� ������ �ʴ´ٴ� ���� toString���� override�Ǿ��� ����
	}// useStringBuilder

	public void useStringBuffer() {
		// 1.����
		StringBuffer sb = new StringBuffer();
		// �� ������
		int i = 9;
		double d = 11.31;
		String str = "�ڹ� ����";

		// sb.append(i);
		// sb.append(d);
		// sb.append(str);
		// method chain : method�� ;�� ���� �ʰ� .�� �̿��� ��� ȣ���ϴ� ����
		// sb.append(i).append(" ").append(d).append(str);

		sb.append("ABCD EFG");
		// ���� : ���ϴ� �ε����� ���� ���� �� �ִ�.

		sb.insert(5, "���¹�");
		sb.insert(4, "��õ���� ���ڶ�");
		// ABCD��õ���� ���ڶ� ���¹�EFG
		sb.delete(9, 13);// �����Ҷ��� �� index+1
		// ABCD��õ���� ���¹�EFG

		System.out.println(sb);
		// ��ü�� ����־����� �ּҰ� ������ �ʴ´ٴ� ���� toString���� override�Ǿ��� ����

	}// useStringBuffer

	public static void main(String[] args) {

		UseStringBuilder usb = new UseStringBuilder();
		System.out.println("------------------Builder------------------");
		usb.useStringBuilder();
		System.out.println("------------------Buffer------------------");
		usb.useStringBuffer();

		// String str=" ";
		// String�� +������ ���� Compiler�� String Builder ��ü�� �����Ͽ� +������ append�� ������.
		// System.out.println(str+"������ "+4+"�� "+9+"���Դϴ�.");
		StringBuilder sb = new StringBuilder("ABCDE");
		String str = "ABCDE";
		// ���� ���ڿ��� �ִ��� ��
		// if(str.equals(sb)) {
		// System.out.println("����");
		// }else {
		// System.out.println("�ٸ�");
		// }
		System.out.println(sb.toString().equals(str) ? "����" : "�ٸ�");
		System.out.println(str.equals(sb.toString()) ? "����" : "�ٸ�");// str�� ���ڿ� �����(�Ѱ���) // sb�� heap�� �ö�(�ּҸ� �����
		// ���ٰ�������

	}// main

}// class
