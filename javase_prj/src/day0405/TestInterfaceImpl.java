package day0405;

/**
 * �������̽��� ������ Ŭ����
 * 
 * @author owner
 */
public class TestInterfaceImpl implements TestInterface {

	@Override
	public String myName() {
		return "���¹�";
	}

	@Override
	public String myAddr() {
		return "��õ������ ��籸";
	}

	public static void main(String[] args) {
		//�������̽��� ��üȭ �� �� ����.
		//TestInterface ti=new TestInterface();
		TestInterfaceImpl tii=new TestInterfaceImpl();
		//������ Ŭ������ ��ü�� �������̽��� ������ �� �ִ�
		TestInterface ti=new TestInterfaceImpl();// is-a������ ��üȭ
		
		System.out.println(tii.myName());
		System.out.println(ti.myName()); //override�� method ȣ��
		
		//default method ȣ��
		ti.test();
	}

}
