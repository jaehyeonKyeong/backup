package day0329;

//class�� ���� ������ : default(package) : �ܺ� ��Ű������ ���� �Ұ�.
class Encapsulation2 {
	public int e2_a; // ��밡��
	protected int e2_b; // ���� ��Ű���� Ŭ������ �� Ŭ������ ����ϸ� ��밡��, ����� ���� �ʴ��� ���� ��Ű���� �ٸ� Ŭ�������� ��밡��.
	int e2_c;// ���� ��Ű���� Ŭ������ �� Ŭ������ ����ϸ� ��밡��, ����� ���� �ʴ��� ���� ��Ű���� �ٸ� Ŭ�������� ��밡��.
//	private int e2_d; // �ܺ� ���� �Ұ�.

	public static void main(String[] args) {
		Encapsulation1 e1 = new Encapsulation1();
		e1.e1_a = 100;// public
		e1.e1_b = 100;// protected
		e1.e1_c = 100;//default
		// e1.e1_d=100//error (private��� �Ұ�)
		Encapsulation2 e2=new Encapsulation2();
		e2.e2_a=200; //public
		e2.e2_b=200; //protected
		e2.e2_c=200; //default
//		e2.e2_d=200;//private
	}
}
