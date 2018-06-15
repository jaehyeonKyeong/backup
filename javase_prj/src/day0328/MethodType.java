package day0328;

/**
 * method�� ����<br>
 * 
 * @author owner
 */
public class MethodType {

	/**
	 * ��ȯ���� ����, �Ű������� ���� �� - ������ <br>
	 */
	public void typeA() {
		System.out.println("������");
	}// typeA

	/**
	 * ��ȯ���� ����, �Ű������� �ִ� �� - ������<br>
	 * 
	 * @param i
	 *            ȣ���Ҷ� ������ �Է����ּ���.<br>
	 */
	public void typeB(int i) {
		System.out.println("���� �� i :" + i);
	}// typeB

	/**
	 * ��ȯ���� �ְ�, �Ű������� ���� �� - ���� ��<br>
	 * ��ȯ���� �����Ѵٸ� method�� ���� ������ �ٿ� �ݵ�� return�� ������־����<br>
	 * 
	 * @return ������ 21���� ��ȯ�˴ϴ�.
	 */
	public int typeC() { // ��ȯ���� �ֱ� ������ �ݵ�� int���� return�� �־����.
		return 21;
	}// typeC

	/**
	 * ��ȯ���� �ְ�, �Ű������� �ִ� �� - ������<br>
	 * 
	 * @param f
	 *            �Ǽ����� ��
	 * @return �Է¹��� �Ǽ����� ���������� ��������ȯ�� ��
	 */
	public int typeD(float f) {
		return (int) f;
	}// typeD

	public static void main(String[] args) {
		// instatance method�� ȣ���ϱ� ���� ��üȭ�� �ʿ�.
		MethodType mt = new MethodType();
		// ȣ��
		// ������
		mt.typeA();
		// ���� ��
		mt.typeB(3);
		// ������ -method�� ó���� ��� ���� �޾� ����Ҽ� �ֵ��� method �տ� ��� ���� �����ϴ� �ڵ� �ۼ�
		int i = mt.typeC()+10;
		System.out.println("������ + 10 : "+i);
		System.out.println("������ ����ȣ�� :" + mt.typeC());
		// ������
		int temp1 = mt.typeD(3.35f);
		int temp2 = mt.typeD(2018.3f);
		int temp3= mt.typeD(33.28f);
		
		System.out.println("������ : "+temp1+" / "+ temp2 + " /" + temp3);
		
		

	}// main

}// class
