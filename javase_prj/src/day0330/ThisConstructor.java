package day0330;

/**
 *	this�� method�������� ���<br>
 *	�� Ŭ������ �ִ� �ٸ� �����ڸ� ȣ�� �� �� ���.<br>
 *	�������� ù�ٿ����� �ۼ� ����.<br>
 *	���ȣ��Ǹ� error�� ��µȴ�<br>	
 * @author owner
 */
public class ThisConstructor {
	public ThisConstructor() {
		this(30);
		System.out.println("�⺻������");
	}//ThisConstructor
	public ThisConstructor(int i) {
//		this();
		System.out.println("�����ִ� ������ : i ="+i);
	}
	public static void main(String[] args) {
//		new ThisConstructor();
		new ThisConstructor(30);
	}

}
