package day0328;

/**
 *	매개변수는 하나 이지만 입력 값의 갯수를 마음대로 사용할 수 있는 variable argument형 사용 <br>
 *	문법) public void method명 (데이터형 ... 매개변수명){ <br>
 *			매개변수는 배열로 처리되므로 반복문을 사용하여 입력값을 처리한다. <br>
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
	
	//가변인자를 처리하는 parameter는 여러개의 parameter와 같이 정의 할 때에는 가장 마지막에만 정의 가능
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

		// 가변 인자형은 호출 시 값의 갯수를 마음대로 입력할 수 있다
		// va.method();
		va.method(999999);
		va.method(1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 9, 9, 9, 9, 100);
		System.out.println("-------------------------------------------------");
		
		//여러개의 parameter와 같께 정의된 V.A 호출
		va.methodB(2,'W',1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 9, 9, 9, 9, 100);
		
		System.out.println("'안녕하세요?'");
		System.out.println("\"안녕\t하세요?\"");
		System.out.println("\"안녕\n하세요?\"");
		System.out.println("\"안녕\r하세요?\"");

	}

}
