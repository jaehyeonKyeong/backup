package day0326;

/**
 *	else~if(���� if)<br>
 *	������ ���� ������ ��<br>
 *	����) if(���ǽ�){} else if {} else if {} .....   } else{}<br>
 *
 * @author owner
 */
public class TestElseIf {

	public static void main(String[] args) {
//		�Էµ� ������ ���� ���� ����
//		0~100 ���� ������� "����"�� �׷��� ������ ������ ������ �����ִ� ���� if
		int score = Integer.parseInt(args[0]);
		System.out.print(score+" �� ");
		if (score < 0) {
			System.out.println("�� 0���� ���� �� �����ϴ�. ����! ToT");
		} else if (score > 100) {
			System.out.println("�� 100���� Ŭ �� �����ϴ�. ����! ToT");
		} else {
			System.out.println("�� �Է¼���. s(^.~)v");
		}
		
//		�̸��� �¾ �ظ� �Է¹޾� �Ʒ��� ���� �츦 ���
//		�Ʒ��� ���� ���
//		��-11, ��-10, ��-9, ��,�䳢,ȣ����,��,��,����,��,��,������-0
		int born = Integer.parseInt(args[2]);
		int num=born%12;
		if (num==11) {
			System.out.println(args[1]+"�� "+args[2]+"��� ���̴� "+(2018-born+1)+"�� ��� "+"���");
		} else if (num==10) {
			System.out.println(args[1]+"�� "+args[2]+"��� ���̴� "+(2018-born+1)+"�� ��� "+"����");
		} else if (num==9) {
			System.out.println(args[1]+"�� "+args[2]+"��� ���̴� "+(2018-born+1)+"�� ��� "+"���");
		} else if (num==8) {
			System.out.println(args[1]+"�� "+args[2]+"��� ���̴� "+(2018-born+1)+"�� ��� "+"���");
		} else if (num==7) {
			System.out.println(args[1]+"�� "+args[2]+"��� ���̴� "+(2018-born+1)+"�� ��� "+"�䳢��");
		} else if (num==6) {
			System.out.println(args[1]+"�� "+args[2]+"��� ���̴� "+(2018-born+1)+"�� ��� "+"ȣ���̶�");
		} else if (num==5) {
			System.out.println(args[1]+"�� "+args[2]+"��� ���̴� "+(2018-born+1)+"�� ��� "+"�Ҷ�");
		} else if (num==4) {
			System.out.println(args[1]+"�� "+args[2]+"��� ���̴� "+(2018-born+1)+"�� ��� "+"���");
		} else if (num==3) {
			System.out.println(args[1]+"�� "+args[2]+"��� ���̴� "+(2018-born+1)+"�� ��� "+"������");
		} else if (num==2) {
			System.out.println(args[1]+"�� "+args[2]+"��� ���̴� "+(2018-born+1)+"�� ��� "+"����");
		} else if (num==1) {
			System.out.println(args[1]+"�� "+args[2]+"��� ���̴� "+(2018-born+1)+"�� ��� "+"�߶�");
		} else {
			System.out.println(args[1]+"�� "+args[2]+"��� ���̴� "+(2018-born+1)+"�� ��� "+"�����̶�");
		} 
		
		
		
		/*
		int born = Integer.parseInt(args[2]);
		String animal[]= {"��","��","��","��","�䳢","ȣ����","��","��","����","��","��","������"};
		System.out.println(args[1]+"�� "+args[2]+"��� ���̴� "+(2018-born+1)+"�� ��� "+animal[11-(born%12)]+"��");
		
		*/

	}

}
