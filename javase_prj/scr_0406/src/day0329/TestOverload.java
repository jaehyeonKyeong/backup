package day0329;


/**
 * Ŭ�������� ���� �̸��� method�� ������ �ۼ��� �� overload�� ��� <br>
 * 
 * @author owner
 */
public class TestOverload {

	/**
	 * '*'�� �ϳ� ����ϴ� ��
	 */
	public void printStar() {		
		System.out.println("��");		
	}

	/**
	 * '*'�� �Էµ� ����ŭ ����ϴ� ��
	 * @param cnt �Էµ� ��
	 */
	public void printStar(int cnt) {
		for (int i = 0; i < cnt; i++) {
			System.out.print("��");
		}
	}

	public static void main(String[] args) {
		TestOverload to = new TestOverload();
		to.printStar();
		System.out.println("-------------------------");
		to.printStar(10);

	}

}
