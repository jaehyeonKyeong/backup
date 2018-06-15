package day0329.sub;

import day0329.Encapsulation1;

public class Encapsulation3 {
	public static void main(String[] args) {
		// 패키지가 다르면 퍼블릭인 클래스만 접근가능
		Encapsulation1 e1 = new Encapsulation1();
		// Encapsulation2 e2 = new encapsulation2();
		e1.e1_a = 300;// public
		// e1.e1_b=300;//protected 사용불가
		// e1.e1_c=300;//default 사용불가
		// e1.e1_d=300;//private 사용불가

	}
}
