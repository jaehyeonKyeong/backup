package day0328;

/**
 * 매개변수는 하나 이지만 입력 값의 갯수를 마음대로 사용할 수 있는 가변 인자형 사용.<br>
 * 문법) public void method명(데이터형 ... 매개변수명){<br>
 * 매개변수는 배열로 처리되므로 반복문을 사용하여 입력값을 처리한다.<br>
 * }
 * 
 * @author owner
 */
public class VariableArguments {
	public void method(int... param) {
		for (int value : param)
			System.out.print(value);
	}// method

	// 가변인자를 처리하는 parameter는 여러개의 parameter와 같이 정의할때에는 가장 마지막에만 정의 가능
	public void methodB(int i, char c, int... va) {
		System.out.println("일반 매개변수 i : " + i + " , c: " + c);
		System.out.println("가변인자형 매개변수 ");
		for (int value : va)
			System.out.println(value);
	}

	public static void main(String[] args) {

		VariableArguments va = new VariableArguments();

		// 가변 인자형은 호출 시 값의 갯수를 마음대로 입력가능
		// va.method();
		va.method(1);
		System.out.println();
		va.method(1);
		System.out.println();
		va.method(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

		System.out.println("---------------------------------------------------");

		// 여러개의 parameter와 함께 정의 된 Variable Arguments를 호출
		va.methodB(3, 'W',0,1,2,3,4,5,6,7,8,9);
		System.out.println("\"안녕하세요?\"");

	}

}
