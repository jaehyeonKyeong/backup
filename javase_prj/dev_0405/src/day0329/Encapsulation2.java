package day0329;

// class ���� ������ : default : �ܺ� ��Ű������ ���ٺҰ�
class Encapsulation2 {
	public int e2_a; // ���� ��Ű���� �ٸ� class���� ��밡��
	protected int e2_b;// ������Ű���� Ŭ������ �� Ŭ������ ����ϸ� ��밡��, ���� ��Ű���� �ٸ� Ŭ�������� ��� ����
	int e2_c; // ��
	private int e2_d; // �ܺ� ���� �Ұ�

	public static void main(String[] args) {
		// ���� ��Ű���� �ٸ� Ŭ����(Encapsulation1) ���
		Encapsulation1 e1 = new Encapsulation1();
		e1.e1_a = 100; // public
		e1.e1_b = 100; // protected
		e1.e1_c = 100; // default
		// e1.e1_d=100; //private ���Ұ� // Error
		
		Encapsulation2 e2=new Encapsulation2();
		e2.e2_d=20;
		System.out.println(e2.e2_d);
		
	}

}
