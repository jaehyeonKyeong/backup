package day0328;

/**
 *	�Ű������� �ϳ� ������ �Է� ���� ������ ������� ����� �� �ִ� variable argument�� ��� <br>
 *	����) public void method�� (�������� ... �Ű�������){ <br>
 *			�Ű������� �迭�� ó���ǹǷ� �ݺ����� ����Ͽ� �Է°��� ó���Ѵ�. <br>
 * @author owner
 */
public class VariableArguments {

	public void method(int ... param) {
//		System.out.println(param);
		for (int value : param) {
			System.out.print(value+" ");
		}
		System.out.println();
	}// method
	
	//�������ڸ� ó���ϴ� parameter�� �������� parameter�� ���� ���� �� ������ ���� ���������� ���� ����
	public void methodB(int repeat, char c, int ... va) {
		for (int value : va) {
			for(int j=0;j<repeat;j++) {
				System.out.print(c);				
			}
			System.out.print(value+" ");
		}
		System.out.println();
	}// method

	public static void main(String[] args) {
		VariableArguments va = new VariableArguments();

		// ���� �������� ȣ�� �� ���� ������ ������� �Է��� �� �ִ�
		// va.method();
		va.method(999999);
		va.method(1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 9, 9, 9, 9, 100);
		System.out.println("-------------------------------------------------");
		
		//�������� parameter�� ���� ���ǵ� V.A ȣ��
		va.methodB(2,'W',1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 9, 9, 9, 9, 100);
		
		System.out.println("'�ȳ��ϼ���?'");
		System.out.println("\"�ȳ�\t�ϼ���?\"");
		System.out.println("\"�ȳ�\n�ϼ���?\"");
		System.out.println("\"�ȳ�\r�ϼ���?\"");

	}

}
