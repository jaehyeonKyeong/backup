package day0409;

import java.util.StringTokenizer;

/**
 * StringTokenizer: 문자열을 구분할 목적으로 만들어진 클래스
 * 
 * @author owner
 */
public class UseStringTokenizer {
	public UseStringTokenizer() {
		String csvData = "자바, 오라클, JSP, HTML5, CSS. 지승민~ 김동희 김대현";
		// Tokenizer의 매개변수
		// 공백으로 구분
		// StringTokenizer stk=new StringTokenizer(csvData);
		// 원하는 문자로 토큰 생성(구분문자로 토큰 구분 , 구분문자는 삭제)
//		 StringTokenizer stk=new StringTokenizer(csvData,",");
		//구분 문자는 여러개 넣을 수 있음
		 StringTokenizer stk=new StringTokenizer(csvData,",.~");
		// 원하는 문자로 토큰을 생성후 기준문자를 토큰으로 취급하는 지 여부를 boolean값으로 결정
//		StringTokenizer stk = new StringTokenizer(csvData, ",", false);

		System.out.println("Token의 수 : " + stk.countTokens());
		String str = "";
		while (stk.hasMoreTokens()) {// 토큰 존재?
			str = stk.nextToken();// 토큰을 얻고 포인터를 이동
			System.out.println("Token 존재 : " + str);
		} // while
	}// Constructor

	public static void main(String[] args) {
		new UseStringTokenizer();
	}

}
