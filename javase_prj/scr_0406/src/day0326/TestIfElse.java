package day0326;

/**
 *
 * @author owner
 */
public class TestIfElse {

	public static void main(String[] args) {
		int num=Integer.parseInt(args[0]);
		//�Էµ� ���� ����,������� �Ǵ�
		System.out.print("�Էµ� �� "+num+" ��(��) ");
		if(num>-1) {//���
			System.out.println("��� �Դϴ�.");
			}else {//����
			System.out.println("���� �Դϴ�.");	
		}
		
		///�Էµ� ���� Ȧ��, ¦������ �Ǵ�
		if (num % 2 == 0) {
			System.out.println("¦�� �Դϴ�.");
		} else {
			System.out.println("Ȧ�� �Դϴ�.");
		}
		
		/// �Էµ� ���� 0~100 ���̸� ��ȿ, �׷��� ������ ��ȿ�� ���
		if (num > -1 && num < 101) {
			System.out.println("��ȿ");
		} else {
			System.out.println("��ȿ");
		}
		
		//�Էµ� �̸��� "���¹�"�̶�� '����'�� �׷��� ������ '���'�� ��� �ϼ���
		if (args[1].equals("���¹�")) {
			System.out.println("����");
		} else {
			System.out.println("���");
		}
		
		
		
	}

}
