package day0327;

/**
 * switch ~case:������ ���Ҷ� ����ϴ� ���ǹ�<br>
 * switch (������){<br>
 * case ��� : ���� ����;<br>
 * break;<br>
 * . . . default: ������ ���� ����� ��ġ�ϴ� ���� ������ ���� ����; }
 * 
 * @author owner
 */
public class TestSwitchCase1 {
	public static final int ZERO=0;
	public static final int ONE=1;
	public static void main(String[] args) {
		 char i = 1; // byte, short, int, char�� ����
		//String i = "ȭ"; // ���ڿ��� case����� ���� ������ ��밡��(JDK 1.7�̻� ��밡��)
		// char ���� ��� case�� ����� ���ڻ���� �׿� ���� Unicode���� ���
		//int temp=0;//
		switch (i) {
		case ZERO: //case�� �������� ���̱����� constants�� ���
			System.out.println("������ ���� 0�� ����");
			break;
		case ONE:
			System.out.println("������ ���� 1�� ����");
			break;
		case 2:
			System.out.println("������ ���� 2�� ����");
			break;
		case 3:
			System.out.println("������ ���� 3�� ����");
			break;
		default:
			System.out.println("������ ���� ����� ��ġ�ϴ� ���� ����");
		}// end switch

	}// main

}// class
