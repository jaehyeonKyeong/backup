package day0405;

/**
 *	�߻�Ŭ������ ��Ӱ����� �θ�Ŭ������ �ۼ��ȴ� <br>
 *	�߻�Ŭ������ ������üȭ �� �� ���� <br>
 *	��� �ڽ��� �ݵ�� �����ؾ��ϴ�(Override) �������� ���� �߻� method�� ������ <br>
 *	�߻�Ŭ������ �ڽ��� �ݵ�� �����ؾ� ������ �ڽ�Ŭ������ �߻�Ŭ������ ���� �������� �ʾƵ� �ȴ�
 * @author owner
 */
public abstract class AbstractSuper {
	int i;
	public AbstractSuper() {
		System.out.println("�θ� �⺻������");
	}//AbstractSuper
	
	public void method() {
		System.out.println("�Ϲ� method");
	}//method
	
	public abstract void absMethod();
	public abstract void absMethod1();
	
	
	
	
	
	
//	public static void main(String[] args) {
//		// �߻�Ŭ������ ���� ��üȭ �� �� ����
//		AbstractSuper as =new AbstractSuper();
//	}

}//class
