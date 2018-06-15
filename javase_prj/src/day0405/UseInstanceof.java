package day0405;

import day0404.Clark;

/**
 * 생성된 객체가 특정 클래스로부터 생성되었는지 물어보는 연산자
 * @author owner
 */
public class UseInstanceof {
	
	public UseInstanceof() {
		
		Clark c= new Clark();
		//clark은 person과 상속관계이고 fly와 구현관계(is a)
		//c 객체가 clark에서 생성되었는지
		
		if(c instanceof Clark) {
			System.out.println("Clark으로 부터 생성됨");
		}else {
			System.out.println("Clark으로 부터 생성되지 않음");
		}
	}
	public static void main(String[] args) {
		new UseInstanceof();
	}

}
