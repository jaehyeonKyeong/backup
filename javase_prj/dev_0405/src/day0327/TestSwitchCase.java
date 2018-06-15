package day0327;

/**
 *switch~case : ������ ���� �� ����ϴ� ���ǹ�
 *����) switch(������){<br>
 *			case ��� : ������ ���� ����� ��ġ�� �� ������ ����;<br>
 *				break;<br>
 *			.<br>
 *			.<br>
 *			default : ������ ���� ����� ��ġ�ϴ� ���� ���� �� ���� ����<br>
 *		}
 * @author owner
 */
public class TestSwitchCase {
	public static final int ZERO = 0; //����ġ�� �������� ����
	public static final int ONE = 1;
	public static final int TWO = 2;
	public static final int THREE = 3;

	public static void main(String[] args) {
		
		int i = 0; //byte, short, int, char ��밡��
		
		switch (i) {
		case ZERO: 
			System.out.println("������ ���� 0�� ����");
			break;
		case ONE:
			System.out.println("������ ���� 1�� ����");
			break;
		case TWO:
			System.out.println("������ ���� 2�� ����");
			break;
		case THREE:
			System.out.println("������ ���� 3�� ����");
			break;
		default:
			System.out.println("������ ���� ����� ��ġ�ϴ� ���� ����");
		}//end switch
		/*
		char i = 'A'; //byte, short, int, char ��밡��
		
		switch (i) {
		case 'A':   //  == case 65 :
			System.out.println("������ ���� 0�� ����");
			break;
		case 1:
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
		}//end switch
			*/
		
		
			/*
			String j = "ȭ"; //JDK ������ 1.7�̻��� ��쿡 ��밡��					
			switch (j) {
			case "65" :   
				System.out.println("������ ���� '65'�� ����");
				break;
			case "ȭ":
				System.out.println("������ ���� 'ȭ'�� ����");
				break;
			case "��":
				System.out.println("������ ���� '��'�� ����");
				break;
			case "��":
				System.out.println("������ ���� '��' �� ����");
				break;
			default:
				System.out.println("������ ���� ����� ��ġ�ϴ� ���� ����");
		}//end switch
		*/
		

	}//main

}//class
