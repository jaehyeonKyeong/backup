package day0329;

/**
 *	Ư������ <br>
 *	\������ ������ ������ ������ ���� �ϴ� ���ڵ� <br>
 *	���ڿ� �ȿ��� ��� <br>
 * @author owner
 */
public class EscapeCharacter {

	public static void main(String[] args) {
		System.out.println("������\tȭ����\t�̼�������\t����\tȲ��\t����");
		// \r -> return (windows�� ��� ����) : Ŀ���� �� ���� ������ �̵��ϴ� ���� ������ Ư�����ڷ� ����ϸ� �ٺ������ ���ش�
		System.out.println("������ \nȭ����\r�Դϴ�."); //�����쿡���� \r == \n
		System.out.println("c\\temp\\new.txt"); 
		
		System.out.println("������ \"ȭ����\" �Դϴ�."); 
		System.out.println("<a href = \'test.jsp\'>��û</a>"); //�ڹٿ����� \�� ������� �ʾƵ� ������ �߻����� ������ JSP������ ������ �߻�
		
		System.out.println("abcd\b\b"); // \b => ����1�� ����
		System.out.println("abcd\f"); //\f => �����ͷ� ��� ��  �ٺ��� 
		
		
		

	}

}
