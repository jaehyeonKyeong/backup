package day0404;

/**
 *	��Ӱ��迡�� �ڽ� Ŭ���� <br>
 *	����Ư¡�� �θ��� �ڿ��� ����ϰ�(�ڵ��� ���뼺) <br>
 *	�ڽŸ��� Ư¡�� �����Ͽ� ��� <br>
 *	
 * @author owner
 */
public class Child extends Parent {
	int c_a;
	public Child() {
		System.out.println("�ڽ�Ŭ������ ������");
	}//Child
	
	public void cMethod() {
		System.out.println("�ڽ�Ŭ������ method");
	}//cMethod

	public static void main(String[] args) {
		Child c = new Child(); //�ڽ��� ��üȭ �ϸ� �θ� ���� �����ȴ�
		//�ڽİ�ü�� �θ��� �ڿ��� �ڽ� ��ó�� ����Ѵ�
		System.out.println("�θ� public "+c.p_a); //��밡
		System.out.println("�θ� protected "+c.p_b); //��밡
		System.out.println("�θ� default "+c.p_c);//��Ȳ�� ���� (���� package�� �ֱ� ������ ��밡��)
//		System.out.println("�θ� private "+c.p_d); //���Ұ� (���ٱ��� ����)
		System.out.println("�ڽ� default "+c.c_a); //�ڽ��� �ڿ��� ��밡��
		
		c.pMethod();
		c.cMethod();

	}//main

}//class
