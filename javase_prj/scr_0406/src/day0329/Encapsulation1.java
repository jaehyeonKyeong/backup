package day0329;

// class ���� ������ : public : �ܺ� ��Ű������ ���� ����
public class Encapsulation1 {
	public int e1_a; //�ܺλ�밡��
	protected int e1_b;//������Ű�� ��밡��, �ܺ� : �ڽ�
	int e1_c; //���� ��Ű�� ��밡��, �ܺ� : ���Ұ�
	private int e1_d; //�� Ŭ���� �ȿ����� ��밡��
	
	public static void main(String[] args) {
		//��Ű���� ���ٸ� Ŭ������ ���������ڴ� ������ ���� �ʴ´�
		Encapsulation2 e2=new Encapsulation2();
		e2.e2_a=200; // public
		e2.e2_b=200; // pritected
		e2.e2_c=200; // default
//		e2.e2.d=200; // private
		
		Encapsulation1 e1=new Encapsulation1();
		e1.e1_d=10;
		System.out.println(e1.e1_d);
		
	
	}

}
