package day0330;

/**
 * this�� Ű���� ����<br>
 * this�� ȣ���ϴ� ��ü�� �ּҸ� ������. * @author owner
 */
public class TestThis {

	private int i;

	public void setI(int i, TestThis param_tt) {
		// i=i; //�Ķ���� ������ ���� �Ķ���Ϳ� �Ҵ� : ȿ���� ����
		// param_tt.i=i;
		this.i = i; // this�� new�� ���� �ּ�
		System.out.println("seti������ tt=" + param_tt);
		System.out.println("seti method this=" + this);
		System.out.println("stack i=" + i);
	}

	public static void test() {
		// static ������ method�� ȣ�� �Ҷ� Ŭ������.method��(); ���� ȣ���ϱ� ������
		// � ��ü�� method�� ȣ���޴��� �˼� �����Ƿ� ��ü�� �ּҰ� ����Ǵ� this Ű���带 ����� �� ����
		// System.out.println(this);
	}

	public static void main(String[] args) {
		TestThis tt = new TestThis();
		System.out.println("main method tt =" + tt);
		tt.setI(30, tt);
		System.out.println("heap i=" + tt.i);
		// static������ ��ü�� �����Ǳ� ���� ȣ��ǹǷ� � ��ü�� ȣ���ߴ��� �˼� �����Ƿ� this�� ����� �� ����.
		// System.out.println(this);//error (instance���������� �� �� ����)
		TestThis.test();
	}

}
