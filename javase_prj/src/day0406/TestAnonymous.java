package day0406;

public class TestAnonymous {
	public void useInterface(TestInter ti) {
		ti.test();
		String week = ti.week();
		System.out.println("week : " + week);
	}

	public static void main(String[] args) {
		TestAnonymous ta = new TestAnonymous();
		// method�� Interface�� �Ű������� ���� �ϰԵǸ� method�� ȣ���Ҷ�
		// (1.�ش� �������̽��� ������ Ŭ������ ����)�ϰ�
		// (2.��üȭ �ϸ�)
		// (3.method�� �Ű������� ��ü�� �ִ´�)
		TestInterImpl tii = new TestInterImpl();
		ta.useInterface(tii);

		TestInterImpl2 tii2 = new TestInterImpl2();
		ta.useInterface(tii2);
		// Ŭ������ ������ �������� �ʰ� �Ű� ������ ������ : anonymous inner class���
		// class�� �ۼ����� �ʾ����� anonymous�� Ŭ�����̰� �׿����� bytecode�� �����ȴ�.(anonymouse�� �̸��� ���� -> �ܺ�Ŭ������$1.class)
		ta.useInterface(new TestInter() {
			@Override
			public void test() {
				System.out.println("anonymous inner class�� ����!! :-)");
			}

			@Override
			public String week() {
				return "������ �p :-(";
			}
		});
	}

}
