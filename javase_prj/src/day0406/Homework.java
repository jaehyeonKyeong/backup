package day0406;

/**
 * �Ʒ��� �迭�� �Է¹޾� �䱸������ ó���ϼ���. String[][] temp={ {"�����","��⵵ ��õ�� ���","26","����"},
 * {"���¹�","��õ�ñ����� ��굿","26","����"}, {"�赿��","����� ���Ǳ� ��õ��","26","����"}, {"������","��⵵
 * ������ ","26","����"}, {"�����","��û���� ����� ������","26","����"}, {"���ҿ�","����� ������
 * ���ﵿ","26","����"}, {"���ֿ�","��⵵ ����� ������","26","����"}, {"������","�λ�� ����
 * ���鵿","26","����"} }; ���� 1. ���� �����͸� �Ʒ��� �󺧿� ���� ����ϼ���. �̸� �ּ� ���� ���� ���� 2. ��������
 * '��'�� ����� �ο����� ����ϼ���.
 * 
 * ����3. ������ ���� �̸鼭 '��'���� ����� ��� ����ϼ���.
 * 
 * ���� 4. ���� �� ���� ���� ���̸� ����ϼ���.
 * 
 * ���� 5. ���� �� ������ ����%�� ���� ����%�� ����ϼ���.
 * 
 * 
 * @author owner
 */
public class Homework {

	public Homework() {
	}

	@SuppressWarnings("unused")
	public Homework(String[][] temp) {
		int count = 0;
		int[] num = null;
		num=new int[8];
		System.out.println("�̸�\t�ּ�\t\t����\t����\t");
		System.out.println("-------------------------------------");
		for (int i = 0; i < temp.length; i++) {

			for (int j = 0; j < temp[i].length; j++) {
				System.out.printf("%s\t", temp[i][j]);
			}
			if (temp[i][1].endsWith("��")) {
				count++;
			}
			System.out.println();
		}
		System.out.println("------------------------------------");
		System.out.printf("�������� '��'�� ��� [%d]��\n", count);
		System.out.print("������ ���� �̸鼭 '��'���� ��� : ");
		int age=Integer.parseInt(temp[0][2]);
		int s_count=1;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i][3].startsWith("��")) {
				if(temp[i][0].startsWith("��")) {
				System.out.printf("%s ", temp[i][0]);
				}
				s_count++;
			}
			if(i+1<7) {
				if (Integer.parseInt(temp[i][2]) < Integer.parseInt(temp[i + 1][2])) {
					age = Integer.parseInt(temp[i + 1][2]);
				}//if
			}else {
				break;
			}
			
		}//for
		int malePersent=((int)(s_count*100/8));
		int femalePersent=100-malePersent;
		System.out.println();
		System.out.println("���� ���� ���� "+age+"��");
		System.out.println("���ο��� ���� ���� : "+malePersent+"%\n���ο��� ������ ���� : "+femalePersent+"%");
	
	}//Homework
}//class
