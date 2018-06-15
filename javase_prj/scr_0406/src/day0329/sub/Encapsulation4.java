package day0329.sub;

import day0329.Encapsulation1;

//Encapsulation1의 자식 클래스
public class Encapsulation4 extends Encapsulation1 {

	public static void main(String[] args) {

		// 상속된 클래스의 접근 범위
		Encapsulation4 e4 = new Encapsulation4();
		e4.e1_a = 400; // public
		e4.e1_b = 400; // protected
		// e4.e1_c=400; // default 사용불가
		// e4.e1_d=400; // private 사용불가

	}

}
