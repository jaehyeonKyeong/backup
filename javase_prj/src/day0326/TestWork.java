package day0326;

/**
 * 단일 if문을 사용한 코드<br>
 * 문법)<br> if( 조건식){<br>
 * 				조건에 맞을때 수행알 코드;<br>
 * 			} <br><br>
 * main method에 arguments를 받아서 처리하는 프로그램<br>
 * 사용법) java TestWork 고객등급 이름 상품명 가격
 * @author owner
 */
public class TestWork {
	
	public static void main(String[] args) {
		int price=0;
		double sale=0.9;
		
		//특별 회원일 경우에는 할인율이 변경된다.
		if(args[0].equals("특별")) {
			sale=0.7;//형명시는 생략할 수 있다.
		}//end if
		price=Integer.parseInt(args[3]);
		
		System.out.println(args[1]+" 회원님의 고객 등급은 "+args[0]+"이며 "+ args[2]+" 상품의 정가는 "+args[3]+"이지만 할인된 가격은 "+(int)(price*sale)+"원입니다.");
	}//main

}//class
