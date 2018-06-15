package day0402;

/**
 * ���ڿ��� �����ϰ� ����� �� �ִ� Ŭ������ string Ŭ���� �� ���<br>
 *  java���� �����ϴ� Ŭ������ �̸��� ����� ������ Ŭ���� �̸���<br>
 * ���ٸ� ���� ��Ű���� ��� Ŭ���������� ����� ������ Ŭ������ ���� ����ϰ� �ȴ�
 * <br>(method���� �����̸��� instance �������� ���������� �����ϴ°Ͱ� ����).<br>
 * (���� �̸��� ���ٸ� Ŭ������ ����ϴ� ��� �ڵ忡�� full path�� �����Ͽ� ����Ѵ�.)<br>
 * full path : ��Ű����.Ŭ������ �� ����
 * 
 * @author owner
 */
public class UseString {

	public static void main(String[] args) { 
		// �⺻������ : String str="���ڿ�";
		String str = "ABCDE";

		// ���������� : String str=new String("���ڿ�");
		String str1 = new String("ABCDE"); 
		System.out.println("str:"+str);
		//���� �Ǵ� JVM���� ���� ���ڿ��� �ϳ��� �����ǰ� ����.
		//��: == : ��ü���� ==�� �ּҰ� �������� ����.
		if(str=="ABCDE") {
			System.out.println("==���� �⺻�� ������ ����");
		}else {
			System.out.println("==���� �⺻�� ������ �ٸ���");
		}//end else
		System.out.println("str1:"+str1);
		if(str1=="ABCDE") {
			System.out.println("==���� ������ ������ ����");
		}else {
			System.out.println("==���� ������ ������ �ٸ���");
		}//end else
				
		//���ڿ��� �񱳴� StringŬ������ ��� �����޴����� ���þ��� ������ �񱳰���� �����ִ� .equals�� ������.
		System.out.println("�⺻�� "+(str.equals("ABCDE")?"����":"�ٸ���"));
		System.out.println("������ "+(str1.equals("ABCDE")?"����":"�ٸ���"));
		
		String temp="AbcDcecfG";
		String email="rudwpgus25@naver.com";
		
		System.out.println(temp+"�� ���� "+temp.length());
		System.out.println(email+"�� ���� "+email.length());
		System.out.println(temp+"�빮�� "+temp.toUpperCase());
		System.out.println(temp+"�ҹ��� "+temp.toLowerCase());
		
		System.out.println(temp+"���� ó��'c'�� �ε��� "+temp.indexOf("c"));
		System.out.println(temp+"���� 'k'�� �ε��� "+temp.indexOf("k"));
		System.out.println(temp+"���� ������'c'�� �ε��� "+temp.lastIndexOf("c"));
		System.out.println(temp+"���� 5��°�� �ε����� �ش�Ǵ� ���� "+temp.charAt(5));
		
		//AbcDcecfG
		//012345678
		//�ڽ� ���ڿ� ��� substring(�����ε���,���ε���+1)
		System.out.println(temp.substring(3,6));
		//���� �ε����� ������ ������ �߶��ش�.
		System.out.println(email+"���� domain�ּҸ� ���"+email.substring(email.indexOf("@")+1));
		System.out.println(email+"���� mail�ּҸ� ���"+email.substring(0,email.indexOf("@")));
		
		//���� ���ڿ��� ���� ��
		String temp1="�Ǿ���";
		if(temp1.startsWith("����")) {
			System.out.println("���� ������ּ���!");
		}else {
			System.out.println(temp1);
		}
		
		temp1="����� ���ʱ� ���ʵ�";//��û���� ���ֽ� ������ ���ָ�
		if(temp1.endsWith("��")) {
			System.out.println("����");
		}else {
			System.out.println("�ð�");
		}
		temp1="�� ���� �Ǿ����ε�! �� ���� ���� �������!";
		if(temp1.contains("�����")) {
			System.out.println("��!");
			System.out.println(temp1.replaceAll("�����", "***"));
		}else {
			System.out.println(temp1);
		}
		
		temp1="   rasdf fdsa    ";
		
		System.out.println(temp1+"�� �յ� �������� ["+temp1.trim()+"]");
		
		String temp3=temp1.concat("����");
		System.out.println(temp3);
		
		int i=4;
		//����(�⺻�� ��������)�� ���ڿ� ������ ��ȯ
		temp3=String.valueOf(i);
		System.out.println("���� "+i);
		System.out.println("���ڿ� "+temp3);
		
		//format : �������� ���� ������ ���� ����Ҷ�
		double d=10.123;
		boolean b=true;
		temp3=String.format("����: %-5d, �Ǽ�: %.2f, �Ҹ�: %b",i,d,b);
		System.out.println(temp3);
		
		
		
	}

}
