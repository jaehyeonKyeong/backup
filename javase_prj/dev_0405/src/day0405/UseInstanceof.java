package day0405;

import day0404.Clark;
import day0404.Person;

/**
 *	생성된 객체가 특정 클래스로부터 생성되었는지 물어보는 연산자	
 * @author owner
 */
public class UseInstanceof {
	
	public UseInstanceof() {
		Clark c = new Clark();
		//Clark은 Person과 상속관계이고 Fly와 구현관계(is a)
		//c 객체가 Clark에서 생성되었는지
		if(c instanceof Clark) {
			System.out.println("Clark으로 부터 생성");
		} else {
			System.out.println("Clark으로 부터 생성");
		}
		//c 객체가 Person에서 생성되었는지 - 부모클래스 O
		if (c instanceof Person) {
			System.out.println("Person으로 부터 생성");
		} else {
			System.out.println("Person으로 부터 생성");
		}
		// c 객체가 Fly에서 생성되었는지 - interface O
		if (c instanceof Fly) {
			System.out.println("Fly으로 부터 생성");
		} else {
			System.out.println("Fly으로 부터 생성");
		}
		// c 객체가 UseInstanceof에서 생성되었는지 - X
//		if (c instanceof UseInstanceof) {
//			System.out.println("UseInstanceof으로 부터 생성");
//		} else {
//			System.out.println("UseInstanceof으로 부터 생성");
//		}
		
		

	}// UseInstanceof

	public static void main(String[] args) {

		new UseInstanceof();
		

	}//main

}//class
