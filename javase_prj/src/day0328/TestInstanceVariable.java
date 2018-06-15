package day0328;

/**
 * instance variable(=member ����) ���<br>
 * class field�� �����ϰ� ����ϴ� ����<br>
 * ��ü�� �����ɶ� (��üȭ : class�� ��ü�� = new class��();)<br>
 * �޸𸮿� �ö��(heap) ��ü�� �Ҹ�ɶ�<br>
 * (Garbage collector : �޸𸮸� �����ϴ� �ڹ��� ��ü) �������.<br>
 * �ۼ��� ) <br>
 * 1. ���� : ���������� �������� ������ =(�ʿ��)��; �� �ٷ� ���Ҵ� �ϴ� ���� �������� ���� <br>
 * 2. ��ü ���� : class�� ��ü�� = new class��();<br>
 * 3. �� �Ҵ� : ��ü��.������ = ��; // ������ ���ٸ� ��ü���� ��������<br>
 * 4. �� ��� : ��ü��.������; //������ ���ٸ� ��ü���� ��������
 * 
 * 
 * @author owner
 */
public class TestInstanceVariable {
	// 1)����
	int i; // instance ����(=member ����)
	int j;

	public static void main(String[] args) {
		// static ���������� instance������ ���� �����Ҽ� ���� error
		// System.out.println(i);
		// 2) ��üȭ
		TestInstanceVariable tiv = new TestInstanceVariable();
		TestInstanceVariable tiv1 = new TestInstanceVariable();
		 System.out.println("��ü�� : "+tiv); //heap�� �ּ� : 10dea4e(16����)
		 System.out.println("��ü�� : "+tiv1); //heap�� �ּ� : 647e05
		 //3)���Ҵ�
		// �ν��Ͻ� ������ ��ü���� ���� �̸����� �����ȴ�
		 tiv.i=3;
		 tiv.j=28;
		 
		 tiv1.i=11;
		 tiv1.j=9;
		 
		 //4) �� ���
		 System.out.println("tiv��ü�� �������ִ� �ν��Ͻ� ���� i :"+tiv.i);
		 System.out.println("tiv1�� �������ִ� �ν��Ͻ� ���� j:"+ tiv1.j);
		 System.out.println("���� �� : "+ (tiv.i+tiv1.j));
		 
	}// main

}// class
