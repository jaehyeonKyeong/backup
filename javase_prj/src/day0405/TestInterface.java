package day0405;

/**
 * �ڽ� Ŭ�������� �ݵ�� �����ؾ��� ���� ��ϸ� ����
 * 
 * @author owner
 */
public interface TestInterface /* extends Runnable, Cloneable, Serializable */ {
	// ���
	// int i; //������ �ۼ��� �� ����.
	public static final int I = 100;

	// public TestInterface() { //�����ڸ� ���� �� ����.
	// }

	// public void test() {//�Ϲ� �޼ҵ嵵 ���� �� ����
	// }
	
	//JDK1.7+ �������̽��� body�� �ִ� method�� ���� �� �ִ�.
	//default method
	public default void test() {
		System.out.println("������ ����� �Դϴ�.");
	}
	
	//�߻� method�� ���� �� �ִ�. : abstract�� ��� ��� ����.
	public abstract String myName();
	public String myAddr();

}
