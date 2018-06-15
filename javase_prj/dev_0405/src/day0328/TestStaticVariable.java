package day0328;

/**
 *	static ����(class ����) <br>
 *	class field�� static�� �ٿ��� �����ϴ� ���� <br>
 *	����Ǵ� JVM���� �ϳ��� �����ǰ� ���Ǵ� ���� <br>
 *	1. ���� ) public(����) static �������� ������; <br>
 *	2. �� �Ҵ� ) Ŭ������.������ = ��; //��ü������ ������� �ʴ´� <br>
 *	3. �� ��� ) Ŭ������.������ <br>
 * @author owner
 */
public class TestStaticVariable {
	
			//1. static ������ ����
			static int i;
			//instance ������ ����
			int j;		

	public static void main(String[] args) {
		//static ������ �ڵ� �ʱ�ȭ�� �ȴ�.
		System.out.println(TestStaticVariable.i);
		// 2. �� �Ҵ�
		i=100;
		
		// 3. �� ���
		System.out.println(i);
		
		/////// ��ü�� ������ �����Ǵ��� static ������ �ϳ��� ����
		TestStaticVariable tsv1 = new TestStaticVariable();
		TestStaticVariable tsv2 = new TestStaticVariable();
		TestStaticVariable tsv3 = new TestStaticVariable();
		
		tsv1.j=10;
		tsv2.j=20;
		tsv3.j=30;
		
		//Ư�� ��ü�� ���뺯���� �������� �ƴϱ� ������
		//��ü��.static���������� ����ϸ� ����� �ǳ� ��� ��������
		// Ŭ������.������ ���� ��� �� ��!!!!!!
		
		//static ������ ��ü�� �̿��� ������ ������� �ʴ´�
//		tsv1.i=200; //static ���� : ������ ��� ��ü�� �ϳ��� ���� ���
//		System.out.println(TestStaticVariable.i);
//		System.out.println("tsv1 j (����) : "+tsv1.j+", ���� : "+tsv1.i);
//		tsv2.i=300;//static ���� : ������ ��� ��ü�� �ϳ��� ���� ���
//		System.out.println("tsv2 j (����) : "+tsv2.j+", ���� : "+tsv2.i);
//		System.out.println("tsv3 j (����) : "+tsv3.j+", ���� : "+tsv3.i);
		
		
		
		
		
		

	}

}
