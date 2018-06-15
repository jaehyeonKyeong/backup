package day0406;

/**
 *	����Ŭ������ static ����ó�� ����ϱ� ���� Ŭ����
 *
 * @author owner
 */
public class TestNested {
	int i;
	static int j;
	
	public TestNested() {
		System.out.println("�ٱ�Ŭ������ ������");
	}//TestNested
	
	public void methodA() {
		System.out.println("�ٱ� �ν��Ͻ� method");
	}
	public static void methodB() {
		System.out.println("�ٱ� static method");
	}
	//////////////////////// nested ����///////////////////////////////
	//��üȭ�Ͽ� ������� �ʵ��� instance����, instance�޼ҵ带 �������� �ʴ´�.
	static class NestedInner {
		static int j;
		public static void inMethod() {
//			System.out.println("�ٱ�Ŭ������ i"+i); 
			//�ƹ��� ����Ŭ�������� ������ �ٸ��� ����� �� ����.
			System.out.println("����Ŭ������ method");
			System.out.println("�ٱ�Ŭ������ ����"+TestNested.j);
			System.out.println("���� Ŭ������ ���� "+j);
			
			TestNested.methodB();
		}
		
	}
	//////////////////////////////////////////////////////////////////
	
	
	public static void main(String[] args) {
		j=200;//��øŬ������ ��üȭ ���� �ʰ� ���
		NestedInner.j=100;
		NestedInner.inMethod();
	}

}
