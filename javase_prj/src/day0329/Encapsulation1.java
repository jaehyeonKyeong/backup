package day0329;

//class public : �ܺ� ��Ű�� ���� ����
public class Encapsulation1 {
	public int e1_a; //�ܺ� ��밡��
	protected int e1_b; // ���� ��Ű�� ��밡�� , �ܺ�: �ڽ�
	int e1_c; // ���� ��Ű�� ��� ���� , �ܺ�: �Ұ�
	private int e1_d; // �� Ŭ���� �ȿ�����.
	
	public static void main(String[] args) {
		//��Ű���� ���ٸ� Ŭ������ ���� �����ڴ� ������ ���� �ʴ´�
		
		Encapsulation1 e1= new Encapsulation1();
		e1.e1_d=10;
		System.out.println(e1.e1_d);
		
	}
	
}
