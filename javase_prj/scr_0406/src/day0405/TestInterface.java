package day0405;

/**
 *	�ڽ�Ŭ�������� �ݵ�� �����ؾ� �� ���� ��ϸ� ����
 * @author owner
 */
public interface TestInterface {
	
	//���
//	int i; // ������ �ۼ��� �� ����
	public static final int I=100;
	
	//�����ڸ� ���� �� ����
//	public TestInterface(){
//		
//	}
	
	//�Ϲ� method�� ���� �� ����
//	public void int method() {
//		
//	}
	
	//JDK1.7���ʹ� �������̽��� body�� �ִ� method�� ���� �� �ִ�
	public default void test() {
		System.out.println("������ ����� �Դϴ�");
	}//test
	
	//�߻� method�� ���� �� �ִ� : abstract�� ��� �������
	public abstract String myName();
	public String myAddr();
	
	
	

}
