package day0329;

/**
 *	this Ű���带 method �������� ��� <br>
 *	�� Ŭ������ �ٸ� �����ڸ� ȣ�� �� �� ��� <br>
 *	�������� ù��° �ٿ����� �ۼ��� �� �ִ� 
 * @author owner
 */
public class ThisConstructor {
	public ThisConstructor() {
//		this(30);
		System.out.println("�⺻������");
	}//ThisConstructor

	public ThisConstructor(int i) {
		this();
		System.out.println("�����ִ� ������ : i="+i);
	}//ThisConstructor
	
	public static void main(String[] args) {
//		new ThisConstructor(); //�⺻������
		
		new ThisConstructor(50);

	}

}
