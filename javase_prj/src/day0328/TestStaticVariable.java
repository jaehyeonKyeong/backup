package day0328;

/**
 * static ����(=class����)<br>
 * class field�� static�� �ٿ��� �����ϴ� ����<br>
 * ����Ǵ� JVM���� �ϳ��� �����ǰ� ���Ǵ� ����.<br>
 * 1.�����) static+@ �������� ������; 2.�� �Ҵ�) class��.������=��; // ��ü������ ������� �ʴ´� 3.�� ���)
 * class��.������
 * 
 * @author owner
 */
public class TestStaticVariable {
	// 1. static ������ ����
	static int i;
	int j; // instance ����

	public static void main(String[] args) {

		// static������ �ڵ� �ʱ�ȭ
		System.out.println(i);
		// 2.�� �Ҵ�
		i = 100;
		// �� ���
		System.out.println(i);

		// ��ü�� ������ �����Ǵ��� static������ �ϳ��� ����
		TestStaticVariable tsv1= new TestStaticVariable();
		TestStaticVariable tsv2= new TestStaticVariable();
		TestStaticVariable tsv3= new TestStaticVariable();
		
		//instance ������ �� �Ҵ�(������ ��ü�� ���� ���� ���
		tsv1.j=10;
		tsv2.j=20;
		tsv3.j=30;
		
		/*//Ư�� ��ü�� ���� ������ �������� �ƴϱ� ������ ��ü��.static���������� ����ϸ� ����� �ǳ� ��� ������.
		tsv1.i=200;//static ���� : ������ ��� ��ü�� �ϳ��� ���� ���
		System.out.println("tsv1 j(����) : "+tsv1.j+", ���� : "+tsv1.i);
		System.out.println("tsv2 j(����) : "+tsv2.j+", ���� : "+tsv2.i);
		System.out.println("tsv3 j(����) : "+tsv3.j+", ���� : "+tsv3.i);
		tsv1.i=300;//static ���� : ������ ��� ��ü�� �ϳ��� ���� ���
		System.out.println("tsv1 j(����) : "+tsv1.j+", ���� : "+tsv1.i);
		System.out.println("tsv2 j(����) : "+tsv2.j+", ���� : "+tsv2.i);
		System.out.println("tsv3 j(����) : "+tsv3.j+", ���� : "+tsv3.i);*/
		

	}// main

}// class
