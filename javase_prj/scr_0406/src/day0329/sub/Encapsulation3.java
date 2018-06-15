package day0329.sub;

import day0329.Encapsulation1;

public class Encapsulation3 {
	
	public static void main(String[] args) {
		
		//패키지가 다르면 public인 클래스만 접근가능
		Encapsulation1 e1=new Encapsulation1();
		e1.e1_a=300; // public 접근 가능
//		e1.e1_b=300; // protected 접근 불가
//		e1.e1_c=300; // default 접근 불가
//		e1.e1_d=300; // private 접근 불가
		
//		Encapsulation2 e2=new Encapsulation2(); // Encapsulation2는 public이 아니어서 호출 불가
	}

}
