package day0329;

/**
 * Ư������ <br>
 * \������ ������ ������ ������ ���� �ϴ� ���ڵ�<br>
 * ���ڿ� �ȿ��� ���.<br>
 * 
 * @author owner
 */
public class EcapeCharacter {

	public static void main(String[] args) {
		System.out.println("������\tȭ����\t�̼�������\t����\tȲ�簡\t�����߽��ϴ�.");
		// \r - return(windows�� ��밡��): Ŀ���� �� �ٿ� �� ������ �̵���Ű�� ���� ������ Ư�����ڷ� ����ϰ� �Ǹ� �ٺ������
		// �������ش�.
		System.out.println("������\nȭ����\r�Դϴ�");
		System.out.println("c:\\temp\\new.text");
		System.out.println("������ \"ȭ����\" �Դϴ�.");
		System.out.println("<a href=\'test.jsp\'>��û</a>");
		System.out.println("abcd\b");
		System.out.println("abce\f");// �����ͷ� ����Ҷ� �ٺ���
		// System.out.println("\k"); // ������ ���� �̿ܿ��� ����� �� ����
	}

}
