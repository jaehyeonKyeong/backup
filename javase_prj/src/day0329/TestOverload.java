package day0329;

/**
 * Ŭ�������� ���� �̸��� method�� ������ �ۼ��Ҷ� Overload�� ���
 * 
 * @author owner
 */
public class TestOverload {

	/**
	 * *�� �ϳ� ����ϴ� ��
	 */
	public void printStar() {
		System.out.println("��");
	}// printStar


	/**
	 * *�� �Էµ� ����ŭ ����ϴ� ��
	 * 
	 * @param cnt
	 *            ����� ���� ����
	 */
	public void printStar(int cnt) {
		//Overloading
		for (int i = 0; i < cnt; i++) {
			System.out.print("��");
		}
	}// printStar
	

	public static void main(String[] args) {
		TestOverload to=new TestOverload();
		to.printStar();
		to.printStar(5);
	}// main

}// class
