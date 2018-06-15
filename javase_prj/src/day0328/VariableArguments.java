package day0328;

/**
 * �Ű������� �ϳ� ������ �Է� ���� ������ ������� ����� �� �ִ� ���� ������ ���.<br>
 * ����) public void method��(�������� ... �Ű�������){<br>
 * �Ű������� �迭�� ó���ǹǷ� �ݺ����� ����Ͽ� �Է°��� ó���Ѵ�.<br>
 * }
 * 
 * @author owner
 */
public class VariableArguments {
	public void method(int... param) {
		for (int value : param)
			System.out.print(value);
	}// method

	// �������ڸ� ó���ϴ� parameter�� �������� parameter�� ���� �����Ҷ����� ���� ���������� ���� ����
	public void methodB(int i, char c, int... va) {
		System.out.println("�Ϲ� �Ű����� i : " + i + " , c: " + c);
		System.out.println("���������� �Ű����� ");
		for (int value : va)
			System.out.println(value);
	}

	public static void main(String[] args) {

		VariableArguments va = new VariableArguments();

		// ���� �������� ȣ�� �� ���� ������ ������� �Է°���
		// va.method();
		va.method(1);
		System.out.println();
		va.method(1);
		System.out.println();
		va.method(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

		System.out.println("---------------------------------------------------");

		// �������� parameter�� �Բ� ���� �� Variable Arguments�� ȣ��
		va.methodB(3, 'W',0,1,2,3,4,5,6,7,8,9);
		System.out.println("\"�ȳ��ϼ���?\"");

	}

}
