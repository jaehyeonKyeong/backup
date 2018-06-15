package day0402;

/**
 * ���ڿ��� �����ϰ� ����� �� �ִ� Ŭ������ String Ŭ������ ��� java���� �����ϴ� Ŭ������ �̸��� ���� ����� Ŭ������ �̸���
 * ���ٸ� �� ��Ű���� ��� Ŭ���������� ���� ���� Ŭ������ ���� ����ϰ� �ȴ� (�̸��� ���� Ŭ������ ������ �ʴ���, �ƴϸ� Ŭ������
 * ����ϴ� ��� �ڵ忡�� full path�� �����Ͽ� ����Ѵ�) full path : ��Ű����.Ŭ������ �� �������� ����Ѵ�
 * 
 * @author owner
 */
public class UseString {

	public static void main(String[] args) {
		// �⺻�� ����: String str = "���ڿ�";
		String str = "ABCDE";

		// ������ ���� : String str = new String("���ڿ�");
		String str1 = new String("ABCDE");

		// ����Ǵ� JVM���� ���� ���ڿ��� �ϳ��� �����ǰ� ���
		// �� : == : ��ü�� == �ּҰ� ���� �� ��
		System.out.println("str = " + str);
		if (str == "ABCDE") {
			System.out.println("�⺻�� �������� ���� : ����");
		} else {
			System.out.println("�⺻�� �������� ���� : �ٸ���");
		} // end else

		System.out.println("str1 = " + str1);
		if (str1 == "ABCDE") {
			System.out.println("������ �������� ���� : ����");
		} else {
			System.out.println("������ �������� ���� : �ٸ���");
		}
		// ���ڿ��� �񱳴� String Ŭ������ ��� �����ߴ����� ���þ��� ������ �� ����� �����ִ� .equals�� ����Ѵ�
		System.out.println("�⺻�� " + (str.equals("ABCDE") ? "����" : "�ٸ���"));
		System.out.println("������ " + (str1.equals("ABCDE") ? "����" : "�ٸ���"));
		
		String temp="AbcDcecfG";
		String email = "ircw@naver.com";
		
		System.out.println(temp+"�� ���� "+temp.length());
		System.out.println(email+"�� ���� "+email.length());
		System.out.println(temp+" �빮�� "+temp.toUpperCase());
		System.out.println(temp+" �ҹ��� "+temp.toLowerCase());
		System.out.println(temp+"���� ó�� \'c\'�� �ε��� "+temp.indexOf("c"));
		System.out.println(temp+"���� ó�� \'k\'�� �ε��� "+temp.indexOf("k"));
		System.out.println(temp+"���� ������ \'c\'�� �ε��� "+temp.lastIndexOf("c"));
		
		System.out.println(temp+"���� 4��° �ε����� �ش��ϴ� ���ڴ� "+temp.charAt(4));
		System.out.println(temp+"���� 5��° �ε����� �ش��ϴ� ���ڴ� "+temp.charAt(5));
		// �ڽĹ��ڿ� ��� substring(�����ε���, ���ε���+1)
		System.out.println(temp+"���� 3��°���� 5��°������ �ڽĹ��ڿ� "+temp.substring(3,6));
		// �����ε����� ������ ������ �߶��ش�
		System.out.println(email+"���� �������ּ� "+email.substring(email.indexOf("@")+1));
		System.out.println(email+"���� �����ּ� "+email.substring(0,email.indexOf("@")));
		
		//���� ���ڿ��� ���� ��
		String temp1 = "�������";
		if(temp1.startsWith("����")) {
			System.out.println("�� ����� �ּ���!");
		} else {
			System.out.println(temp1);
		}
		
		//temp1 = "����� ���ʱ� ���ʵ�";
		temp1 = "��û���� ���ֽ� ������ ���ָ�";
		if(temp1.endsWith("��")) {
			System.out.println("����");
		} else {
			System.out.println("�ð�");
		}
		temp1="�� ���� �Ǿ����ε�! �� ���� �������";
		if(temp1.contains("�����")) {
			System.out.println("�� ����� �ּ���!");
		}else {
			System.out.println(temp1);
		}
		
		temp1="�� ���� �Ǿ����ε�! �� ���� �������";
		System.out.println(temp1.replaceAll("�����","***"));
		
		temp1 = "   �� �¹�   ";
		System.out.println(temp1);
		System.out.println("["+temp1+"]");
		System.out.println("["+temp1.trim()+"]");
		
		String temp3=temp1.concat("����");
		System.out.println(temp3);
		
		int i=4;
		temp3=String.valueOf(i);
		System.out.println("���ڿ� "+temp3+", ���� "+i);
		
		//format : �������� ���� ������ ���� ����� ��
		double d=10.123;
		boolean b=true;
		temp3=String.format("���� : %-5d, �Ǽ� : %.2f, �Ҹ� : %b",i,d,b);
		System.out.println(temp3);
		
		
	
		
		
		
		
		
		
		
		

	} // main

} // class
