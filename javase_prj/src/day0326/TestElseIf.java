package day0326;

/**
 * else~if(���� if)<br>
 * ������ ���� ������ ��<br>
 * ����) if(���ǽ�){<br>
 * ���ǿ� ������ ���� �ڵ�;<br>
 * }else if(���ǽ�){<br>
 * ���ǿ� ������ �����ڵ�;<br>
 * .<br>
 * .<br>
 * .<br>
 * }else{<br>
 * ��� ���ǿ� ���� ������ �����ڵ�;<br>
 * }<br>
 * 
 * @author owner
 */
public class TestElseIf {

	public static void main(String[] args) {
		// �Էµ� ������ ���� ���� ����
		// 0~100���� ������� "����"�� �׷��� ������ "����"�� ������ �����ִ� ���� if���� ����
		int score = Integer.parseInt(args[0]);
		System.out.print(score + "��");
		if (score < 0) {
			System.out.println("�� 0���� ������ �����ϴ�! T0T");
		} else if (score > 100) {
			System.out.println("�� 100���� ������ �����ϴ�! o(T-T)o");
		} else {
			System.out.println("�� �Է� ����! v(^_~)v");
		} // end else

		// �̸��� �¾ �ظ� �Է¹޾Ƽ� �츦 ���
		// �Ʒ��� ���� ���
		// xxx�� xxxx��� ���̴� xx�� xx�� �Դϴ�.
		//�� -11, ��-10, ��-9 ��-8 �䳢-7 ȣ����-6��-5 ��-4 ����-3 ��-2 ��-1 ������ -0
		int year=Integer.parseInt(args[2]);
		System.out.print(args[1]+"�� "+year+"��� ���̴� "+(2018-year+1)+"�� ");
		if(year%12==0) {
			System.out.print("������");
		}else if(year%12==1) {
			System.out.print("��");
		}else if(year%12==2) {
			System.out.print("��");
		}else if(year%12==3) {
			System.out.print("����");
		}else if(year%12==4) {
			System.out.print("��");
		}else if(year%12==5) {
			System.out.print("��");
		}else if(year%12==6) {
			System.out.print("ȣ����");
		}else if(year%12==7) {
			System.out.print("�䳢");
		}else if(year%12==8) {
			System.out.print("��");
		}else if(year%12==9) {
			System.out.print("��");
		}else if(year%12==10) {
			System.out.print("��");
		}else if(year%12==11) {
			System.out.print("��");
		}
		System.out.println("�� �Դϴ�.");

	}// main

}// class
