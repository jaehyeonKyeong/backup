package day0406;

public class TestAnonymous {
	
	public void useInterface(TestInter ti) {
		ti.test();
		String week = ti.week();
		System.out.println("week "+week);
	} //useInterface

	public static void main(String[] args) {
		TestAnonymous ta = new TestAnonymous();
		//method�� interface�� �Ű������� �����ϰ� �Ǹ� method�� ȣ���� �� 
		// 1.�ش� �������̽��� ������ Ŭ������ ����
		// 2. ��üȭ
		// 3. method�� �Ű������� ��ü�� �ִ´�
		TestInterImpl tii = new TestInterImpl();
		ta.useInterface(tii);
		
		TestInterImpl2 tii2 = new TestInterImpl2();
		ta.useInterface(tii2);
		
		// Ŭ������ ������ �������� �ʰ� �Ű������� ���� �� : Anonymous inner class
		// class�� �ۼ����� �ʾ����� anonymous Ŭ�����̰� �׿����� bytecode�� �����ȴ�
		// �ܺ�Ŭ������$1.class 
		ta.useInterface(new TestInter() {
			@Override
			public void test() {
				System.out.println("anonymous inner class�� ����!!! :-)");
			}//test
			
			public String week() {
				return "������ �p :-(";
			}//week
		});
		
//		ta.useInterface(new TestInterImpl());
//		ta.useInterface(new TestInterImpl2());

	}//main

}//class
