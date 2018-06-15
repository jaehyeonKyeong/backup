package day0409;

import java.util.ArrayList;
import java.util.Date;
//import java.sql.Date; //패키지는 다르나 클래스 명이 같다면 둘중 하나만 import 받을 수 있음.
import java.util.List;
//import java.awt.List;

/**
 * import(다른패키지 내의 클래스나 interface를 사용할때)와 <br>
 * static import(다른 패키지사의 클래스 내 static 변수와 static method를 사용할때)의 사용<br>
 * 필요한 만큼 정의하게 됨
 * 
 * @author owner
 */
//특정 클래스나 interface를 각각 선언할 수 있다.
//import java.util.Date;
//import java.util.List;
//import java.util.ArrayList;

//특정패키지내 모든 클래스나 interface사용
//import java.util.*;//속도가 느림 //ctrl+shift+o 한번에 임폴트

//static import 다른클래스 안의 static 변수, method를 내 클래스 안에 존재하는 것처럼 클래스 명을 생략하고 쓰는것.
//문법 : import static 패키지명.클래스명.static변수명;
import static java.lang.Integer.parseInt; //method사용
import static java.lang.Long.MAX_VALUE;	//constant 사용


public class UseImport {

	@SuppressWarnings({ "unused", "rawtypes" })
	public static void main(String[] args) {
		
		Date d=new Date();
		//다른 패키지의 동일명 클래스(method)를 사용하기위해선 full path를 걸어주어야함
		java.sql.Date d1=new java.sql.Date(1L);//sql패키지의 Date 
		List l=new ArrayList();//(is-a (상속)관계의 객체화) //객체다양성을 쓰기위해
		java.awt.List l1=new java.awt.List();// java.awt의 리스트
		
		String s1="4";
		String s2="65";
		String s3="166";
		
//		int i1=Integer.parseInt(s1);
//		int i2=Integer.parseInt(s2);
//		int i3=Integer.parseInt(s3);
		int i1=parseInt(s1);
		int i2=parseInt(s2);
		int i3=parseInt(s3);
		
		System.out.println(MAX_VALUE);
		
		
	}

}
