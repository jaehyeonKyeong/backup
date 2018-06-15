package day0409;

import java.util.StringTokenizer;

/**
 * StringTokenizer: ���ڿ��� ������ �������� ������� Ŭ����
 * 
 * @author owner
 */
public class UseStringTokenizer {
	public UseStringTokenizer() {
		String csvData = "�ڹ�, ����Ŭ, JSP, HTML5, CSS. ���¹�~ �赿�� �����";
		// Tokenizer�� �Ű�����
		// �������� ����
		// StringTokenizer stk=new StringTokenizer(csvData);
		// ���ϴ� ���ڷ� ��ū ����(���й��ڷ� ��ū ���� , ���й��ڴ� ����)
//		 StringTokenizer stk=new StringTokenizer(csvData,",");
		//���� ���ڴ� ������ ���� �� ����
		 StringTokenizer stk=new StringTokenizer(csvData,",.~");
		// ���ϴ� ���ڷ� ��ū�� ������ ���ع��ڸ� ��ū���� ����ϴ� �� ���θ� boolean������ ����
//		StringTokenizer stk = new StringTokenizer(csvData, ",", false);

		System.out.println("Token�� �� : " + stk.countTokens());
		String str = "";
		while (stk.hasMoreTokens()) {// ��ū ����?
			str = stk.nextToken();// ��ū�� ��� �����͸� �̵�
			System.out.println("Token ���� : " + str);
		} // while
	}// Constructor

	public static void main(String[] args) {
		new UseStringTokenizer();
	}

}
