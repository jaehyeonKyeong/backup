package day0404;

/**
 *	��Ӱ��迡�� �θ�Ŭ���� <br>
 *	�θ� : ��� �ڽ��� �������� ���� Ư¡ ���� <br>
 *	
 * @author owner
 */
public class Parent {
	public int p_a;
	protected int p_b;
	int p_c;
	private int p_d;
	
	public Parent() {
		System.out.println("�θ�Ŭ������ �⺻������");
		System.out.println("private int p_d : "+p_d);
	}//Parent
	
	public void pMethod() {
		System.out.println("�θ�Ŭ������ method");
	}//pMethod
	

}//class
