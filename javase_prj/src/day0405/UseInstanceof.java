package day0405;

import day0404.Clark;

/**
 * ������ ��ü�� Ư�� Ŭ�����κ��� �����Ǿ����� ����� ������
 * @author owner
 */
public class UseInstanceof {
	
	public UseInstanceof() {
		
		Clark c= new Clark();
		//clark�� person�� ��Ӱ����̰� fly�� ��������(is a)
		//c ��ü�� clark���� �����Ǿ�����
		
		if(c instanceof Clark) {
			System.out.println("Clark���� ���� ������");
		}else {
			System.out.println("Clark���� ���� �������� ����");
		}
	}
	public static void main(String[] args) {
		new UseInstanceof();
	}

}
