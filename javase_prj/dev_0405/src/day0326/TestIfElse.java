package day0326;

/**
 *
 * @author owner
 */
public class TestIfElse {

	public static void main(String[] args) {
		int num=Integer.parseInt(args[0]);
		//입력된 수가 음수,양수인지 판단
		System.out.print("입력된 수 "+num+" 은(는) ");
		if(num>-1) {//양수
			System.out.println("양수 입니다.");
			}else {//음수
			System.out.println("음수 입니다.");	
		}
		
		///입력된 수가 홀수, 짝수인지 판단
		if (num % 2 == 0) {
			System.out.println("짝수 입니다.");
		} else {
			System.out.println("홀수 입니다.");
		}
		
		/// 입력된 수가 0~100 사이면 유효, 그렇지 않으면 무효를 출력
		if (num > -1 && num < 101) {
			System.out.println("유효");
		} else {
			System.out.println("무효");
		}
		
		//입력된 이름이 "지승민"이라면 '반장'을 그렇지 않으면 '평민'을 출력 하세요
		if (args[1].equals("지승민")) {
			System.out.println("반장");
		} else {
			System.out.println("평민");
		}
		
		
		
	}

}
