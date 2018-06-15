package day0402;

/**
 * ����1. �Ʒ��� ���� �迭�� ����� ��ȿ�� �˻� ����<br>
 * String[]
 * email={"test@sist.co.kr","test@com","test.co.kr","test@kr","test@daum.net"}<br>
 * �̸��� ��ȿ���˻� ~~~~~ ���� ~~~~~ ���� �̸��� ~~~~~<br>
 * 
 * ��ȿ���˻�: �̸��� . , @ �� �����ϸ鼭 10���̻��� ���"�����̸���" ���� ��쿡 �ش����� ������ "����"�� ���<br>
 * 
 * ����2. �����ڿ��� �ֹι�ȣ�� �Է¹޾� instance������ �����ϰ� instance������ ���� ����Ͽ� ����� ���� ��� ���α׷� �ۼ�
 * -�Ʒ��� �׸��� method�� �����Ͽ� �۾� <br>
 * 2-1 �ֹι�ȣ�� - ���� 14�� �̾�� �Ѵ�( ��ȯ���� boolean) <br>
 * 2-2 �ֹι�ȣ�� 7��° �ڸ��� - �̾�� �Ѵ�(��ȯ���� boolean)<br>
 * 2-3 �Էµ� �ֹι�ȣ�� ��������� ���ϴ� ��(��ȯ�� String ex)1988�� 1��1��)<br>
 * 2-4 ���̸� ���ϴ� ��(��ȯ�� int) 2-5 ������ ���ϴ� ��(String "��" "��" ) 1 3= ���� 2 4 ���� (Ȧ �� ¦
 * ��)<br>
 * 2-6 �ܱ����� ���ϴ� �� (��ȯ�� String "������" "�ܱ���")<br>
 * 2-7 �� ���ϱ� ( �� String)<br>
 * 
 * 
 * @author owner
 *
 */
public class Homework {
	String ss;

	public Homework() {
		// ����1.
		System.out.println("===================����1======================");
		String[] email = { "test@sist.co.kr", "test@com", "test.co.kr", "test@kr", "test@daum.net" };
		for (int i = 0; i < email.length; i++) {
			if (email[i].contains(".") && email[i].contains("@") && email[i].length() >= 10) {
				System.out.println(email[i] + " �� ��ȿ�� : �����̸���");
			} else {
				System.out.println(email[i] + " �� ��ȿ�� : ����");
			} // .�� ���ԵǾ��ִ���
		}
		System.out.println("==========================================");
	}// ������
		// ����2
	// * ��)<br>
	// ����2. �����ڿ��� �ֹι�ȣ�� �Է¹޾� instance������ �����ϰ� instance������ ���� ����Ͽ� ����� ���� ��� ���α׷� �ۼ�
	// * -�Ʒ��� �׸��� method�� �����Ͽ� �۾� <br>

	public Homework(String ss) {
		this.ss = ss;
	}//overloading

	// * 2-1 �ֹι�ȣ�� - ���� 14�� �̾�� �Ѵ�( ��ȯ���� boolean) <br>
	public boolean method1() {
		if (ss.length() == 14) {
			return true;
		} else {
			return false;
		}
	}

	// * 2-2 �ֹι�ȣ�� 7��° �ڸ��� - �̾�� �Ѵ�(��ȯ���� boolean)<br>
	public boolean method2() {
		char hf = ss.charAt(6);
		if (hf == '-') {
			return true;
		} else {
			return false;
		}
	}

	// * 2-3 �Էµ� �ֹι�ȣ�� ��������� ���ϴ� ��(��ȯ�� String ex)1988�� 1��1��)<br>
	public String method3() {
		String s = ss.substring(ss.indexOf("-") + 1, ss.indexOf("-") + 2);
		String birth = ss.substring(0, ss.indexOf("-"));
		if (s.equals("1") || s.equals("2")) {
			return "19" + birth.substring(0, 2) + "�� " + birth.substring(2, 4) + "�� " + birth.substring(4, 6)+"��";
		} else if (s.equals("3") || s.equals("4")) {
			return "20" + birth.substring(0, 2) + "�� " + birth.substring(2, 4) + "�� " + birth.substring(4, 6)+"��";
		}else {
			return null;
		}

	}

	// * 2-4 ���̸� ���ϴ� ��(��ȯ�� int)
	public int method4() {
		String s = ss.substring(ss.indexOf("-") + 1, ss.indexOf("-") + 2);
		String birth = ss.substring(0, ss.indexOf("-"));
		if (s.equals("1") || s.equals("2")) {
			return 2018-(Integer.parseInt("19" + birth.substring(0, 2)))+1;
		} else if (s.equals("3") || s.equals("4")) {
			return 2018-(Integer.parseInt("20" + birth.substring(0, 2)))+1;
		} else {
			return 1;
		}
	}
	
	//2-5 ������ ���ϴ� ��(String "��" "��" ) 1 3= ���� 2 4 ���� (Ȧ �� ¦ ��)
	public String method5() {
		String s = ss.substring(ss.indexOf("-") + 1, ss.indexOf("-") + 2);
		if (Integer.parseInt(s)%2==0) {
			return "�����Դϴ�";
		} else  {
			return "�����Դϴ�";
		}
	}
	// * 2-6 �ܱ����� ���ϴ� �� (��ȯ�� String "������" "�ܱ���")<br>
	public String method6() {
		String s = ss.substring(ss.indexOf("-") + 1, ss.indexOf("-") + 2);
		if(Integer.parseInt(s)<=4) {
			return "������";
		}else {
			return "�ܱ���";
		}
	}
	// * 2-7 �� ���ϱ� ( ��ȯ�� String)<br>
	public String method7() {
		String s = ss.substring(ss.indexOf("-") + 1, ss.indexOf("-") + 2);
		String birth = ss.substring(0, ss.indexOf("-"));
		int year=0;
		if (s.equals("1") || s.equals("2")) {
			 year=Integer.parseInt("19" + birth.substring(0, 2));
		} else if (s.equals("3") || s.equals("4")) {
			 year=Integer.parseInt("20" + birth.substring(0, 2));
		}
		if(year%12==0) {
			return "������ ��";
		}else if(year%12==1) {
			return "�� ��";
		}else if(year%12==2) {
			return "�� ��";
		}else if(year%12==3) {
			return "���� ��";
		}else if(year%12==4) {
			return "�� ��";
		}else if(year%12==5) {
			return "�� ��";
		}else if(year%12==6) {
			return"ȣ���� ��";
		}else if(year%12==7) {
			return "�䳢 ��";
		}else if(year%12==8) {
			return "�� ��";
		}else if(year%12==9) {
			return "�� ��";
		}else if(year%12==10) {
			return "�� ��";
		}else if(year%12==11) {
			return "�� ��";
		}else {
			return null;
		}
		
	}
	public static void main(String[] args) {
		String ss = "820228-1198446";
		new Homework();
		Homework h = new Homework(ss);
		 /*2-1 �ֹι�ȣ�� - ���� 14�� �̾�� �Ѵ�( ��ȯ���� boolean) <br>-
		 * 2-2 �ֹι�ȣ�� 7��° �ڸ��� - �̾�� �Ѵ�(��ȯ���� boolean)<br>-
		 * 2-3 �Էµ� �ֹι�ȣ�� ��������� ���ϴ� ��(��ȯ�� String ex)1988�� 1��1��)<br>
		 * 2-4 ���̸� ���ϴ� ��(��ȯ�� int) 2-5 ������ ���ϴ� ��(String "��" "��" ) 1 3= ���� 2 4 ���� (Ȧ �� ¦
		 * ��)<br>
		 * 2-6 �ܱ����� ���ϴ� �� (��ȯ�� String "������" "�ܱ���")<br>-
		 * 2-7 �� ���ϱ� ( �� String)<br>*/
		if(h.method1()) {
			if(h.method2()) {
				if(h.method6().equals("������")) {
					System.out.println("���� : "+h.method6());
					System.out.println("������� : "+h.method3());
					System.out.println("���� : "+h.method4());
					System.out.println("���� : "+h.method5());
					System.out.println("�� : "+h.method7());
					
				}else {
					System.out.println("���� : "+h.method6());
				}
			}else {
				System.out.println("�ֹι�ȣ�� 7��° �ڸ��� - �̾�� �մϴ�.");
			}//2-2
		}else {
			System.out.println("�ֹι�ȣ�� 14�ڸ����� �մϴ�.");
		}//2-1
	}

}
