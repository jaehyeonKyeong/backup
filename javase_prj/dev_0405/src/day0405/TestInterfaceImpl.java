package day0405;

public class TestInterfaceImpl implements TestInterface{
	
	@Override
	public String myName() {
		return "���¹�";
	}

	@Override
	public String myAddr() {
		return "��õ������ ��籸";
	}

	public static void main(String[] args) {
		//�������̽��� ��üȭ �� �� ����
//		TestInterface ti = new TestInterfaca();
		TestInterfaceImpl tii = new TestInterfaceImpl();
		//������ Ŭ������ ��ü�� �������̽��� ������ �� �ִ�.
		TestInterface ti = new TestInterfaceImpl(); //is a ������ ��üȭ		
		System.out.println(tii.myName());
		System.out.println(ti.myName()); //Override�� method ȣ��
		System.out.println(tii.myAddr());
		System.out.println(ti.myAddr());  //Override�� method ȣ��
		
		//default method ȣ��
		ti.test();
		
		

	}//main

	

}//class
