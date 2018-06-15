package day0418;

import static java.lang.Integer.parseInt;

/**
 * JVM이 자동으로 예외처리를 해주는 RuntimeException사용
 * @author owner
 */
public class UseRuntimeException {
	
	public static void main(String[] args) {
		//main method에서 숫자형태의 arguments를 두개 받아서
		//숫자로 변환 후 나누기 연산 수행
		try {
		int num1=parseInt(args[0]);
		int num2=parseInt(args[1]);
		
		int result = num1/num2;
		
		System.out.println(num1+"/"+num2+"="+result);
		}catch(ArrayIndexOutOfBoundsException aioobe) {
			System.err.println("사용예) java UseRuntimeException 값1 값2");//err = 빨간색으로 글자가 나옴
		}catch(NumberFormatException nfe) {
			System.err.println("값은 숫자형태여야 합니다");
			System.out.println("간단한 메세지:"+nfe.getMessage());
			System.out.println("예외발생 클래스명, 메시지: "+nfe);
			nfe.printStackTrace();//method자체가 출력해준다
		}catch(ArithmeticException ae) {
			System.err.println("0으로는 나눌수 없습니다");
		}catch(Exception e) {
			System.err.println("개발자가 인지하지 못한 예외");
		}finally{
			System.out.println("반드시 실행되어야할 코드");
		}
		
		
	}

}
