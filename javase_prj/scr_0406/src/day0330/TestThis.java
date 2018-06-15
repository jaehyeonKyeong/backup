package day0330;

/**
 *	this �� keyword ���� <br>
 *	this �� ȣ���ϴ� ��ü(instance)�� �ּҷ� ��ġ �ȴ�
 * @author owner
 */
public class TestThis {
	private int i;
	public void setI(int i, TestThis param_tt) {
//		i=i; //�Ķ���� �������� ������ ��Ÿ���� ������ �Է� ->���ǹ�
		System.out.println("setI method tt = "+param_tt);
//		param_tt.i=i; //�Ķ���� ��ü�� �̿�
		this.i=i; // this�� �̿�
		System.out.println("setI method this = "+this);
		System.out.println("stack i = "+i);
	}
	
	public void test() {
		//static ������ method�� ȣ�� �� �� Ŭ������.method��();
		//���� ȣ���ϱ� ������ � ��ü�� method�� ȣ���ߴ��� �˼��� �����Ƿ�
		//��ü�� �ּҰ� ����Ǵ� this�� ����� �� ����
		System.out.println(this);
	}

	public static void main(String[] args) {
		TestThis tt = new TestThis();
		System.out.println("main method tt = "+tt);
		tt.setI(30,tt);
		System.out.println("instance i = "+tt.i);
		//static ������ ��ü�� �����Ǳ����� ȣ��ǹǷ� � ��ü�� ȣ���ߴ��� �� �� �����Ƿ� this�� ����� �� ����
//		System.out.println(this);
		
		
		

	}

}
