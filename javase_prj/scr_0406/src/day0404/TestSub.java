package day0404;

public class TestSub extends TestSuper {
	
	int j;
	int k;
	
	public TestSub() {
		System.out.println("�ڽ��� ������");
	}//Testsub
	
	public void print() {
		System.out.println("�ڽ� j="+j+", k="+k); //����Ŭ������ ����
//		System.out.println("�ڽ� j="+this.j+", k="+this.k); //����Ŭ������ ���� //����Ŭ������ ������ this.���� ���·� ȣ�� ����
		System.out.println("�ڽ�(�θ�) i="+this.i+"/"+super.i); // this.i�� super.i�� �����ϰ� �θ��� ���� i�� ��Ī - i ������ �θ�Ŭ�������� ����
		//�θ�Ŭ������ �ڽ�Ŭ������ �������� ���ٸ� �ڽİ��� ���� ���
		j=3000; // this.j=3000;
		super.j=1000;
		System.out.println("�ڽ� j="+j+", �θ� j="+super.j);
//		System.out.println("�ڽ� j="+this.j+", �θ� j="+super.j);
		System.out.println("-----------------------------------------------------");
		super.print(); //�θ��� method�� ȣ��
		//print(); //�ڽ��� method ȣ�� (���ȣ�� : recursive call) - StackOverFlowError�� �߻��� �� �ִ�
		
	}

	public static void main(String[] args) {
		TestSub ts= new TestSub();
		ts.print();
//		System.out.println(super); // ��ü�� �����Ǳ� ���� ȣ�� �Ǵ� static ���������� ��ü�� �ּҷ� ��ü�Ǵ� this�� super�� ����� �� ����
		
	}//main

}//class
