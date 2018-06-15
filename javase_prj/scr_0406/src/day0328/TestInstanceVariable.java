package day0328;

/**
 *	instance variable(member ����) ��� <br>
 *	Ŭ����field�� �����ϰ� ����ϴ� ���� <br>
 *	��ü�� ������ ��(��üȭ: Ŭ������ ��ü�� = new Ŭ������();) <br>
 *	�޸𸮿� �ö󰡰�(heap) ��ü�� �Ҹ�� �� ������� <br>
 *	(Garbage collector : �޸𸮸� �����ϴ� ��ü)<br>
 *	�ۼ���)<br>
 *		1. ����) ���� ������ �������� ������ = ��;<br>
 *		2. ��ü ����) Ŭ������ ��ü�� = new Ŭ������(); <br>
 *		3. �� �Ҵ�) ��ü��.������=��; //������ ���ٸ� ��ü���� ���� ���� <br>
 *		4. �� ���) ��ü��.������; //������ ���ٸ� ��ü���� ���� ���� <br>
 *
 * @author owner
 */
public class TestInstanceVariable {
	// 1.����)
	int i; //member ���� = instance ����
	int j; //member ���� = instance ����
	static int s=999;
	TestInstanceVariable(int i, int j){
		this.i=i+j;
		this.j=i*j;
	}

	public static void main(String[] args) {
		// 2. ��üȭ)
		TestInstanceVariable tiv = new TestInstanceVariable(3,5);
		TestInstanceVariable tiv1 = new TestInstanceVariable(2,8);
		
		System.out.println(tiv.i);
		System.out.println(tiv.j);
		
		System.out.println(tiv1.i);
		System.out.println(tiv1.j);
		
		System.out.println("��ü�� : "+tiv); //heap�� �ּ�
		//10dea4e(16����) -> 0001 0000 1101 1110 1010 0100 1110
		System.out.println("��ü�� : "+tiv1);
		//677e05(16����) 
		
		// 3. �� �Ҵ�)
		tiv.i=3;
		tiv.j=28;
		
		tiv1.i=11;
		tiv1.j=9;
		
		// 4. �� ���)
		
		System.out.println("tiv��ü�� ������ �ִ� instance ���� i :"+tiv.i+", j: "+tiv.j);
		System.out.println("tiv1��ü�� ������ �ִ� instance ���� i :"+tiv1.i+", j: "+tiv1.j);
		
		System.out.println(s);
		System.out.println(TestInstanceVariable.s);
//		System.out.println(this.s); // this�� �����ڿ����� ��밡��?
		
		System.out.println(s);
		
		//static ������ ��ü�� �̿��� ������ ������� �ʴ´�
//		TestInstanceVariable newt= new  TestInstanceVariable(1,2);
//		newt.s=888;
//		System.out.println(newt.s);
		
		
		

	}

}
