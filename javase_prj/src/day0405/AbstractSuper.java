package day0405;

/**
 * �߻�Ŭ������ ��Ӱ����� �θ� Ŭ������ �ۼ��ȴ�<br>
 * �߻�Ŭ������ ���� ��äȭ �� �� ����
 * ��� �ڽ��� �ݵ�� �����ؾ��ϴ�(override)�������� ���� �߻�method�� ������
 * �߻� method�� �ڽ��� �ݵ�� �����ؾ������� �ڽ� Ŭ������ �߻�Ŭ���� �� ���� �������� �ʾƵ� �ȴ�.
 * @author owner
 */
public abstract class AbstractSuper {
	int i;
	public AbstractSuper() {
		System.out.println("�θ��� �⺻������");
	}
	public void method() {
		System.out.println("�Ϲݸ޼ҵ�");
	}
	
	//�߻�method : method body�� ���� ���� �Ҽ� ���� method �ڽ� Ŭ������ ��� Ŭ������ ���������� override�Ͽ�����
	
	public abstract void absMethod();
	public abstract void absMethod1();
	
	public static void main(String[] args) {

	}

}
