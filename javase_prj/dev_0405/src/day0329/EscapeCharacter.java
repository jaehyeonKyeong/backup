package day0329;

/**
 *	특수문자 <br>
 *	\문자의 형식을 가지면 정해진 일을 하는 문자들 <br>
 *	문자열 안에서 사용 <br>
 * @author owner
 */
public class EscapeCharacter {

	public static void main(String[] args) {
		System.out.println("오늘은\t화요일\t미세먼지는\t가고\t황사\t도래");
		// \r -> return (windows만 사용 가능) : 커서를 그 줄의 앞으로 이동하는 일을 하지만 특수문자로 사용하면 줄변경까지 해준다
		System.out.println("오늘은 \n화요일\r입니다."); //윈도우에서는 \r == \n
		System.out.println("c\\temp\\new.txt"); 
		
		System.out.println("오늘은 \"화요일\" 입니다."); 
		System.out.println("<a href = \'test.jsp\'>요청</a>"); //자바에서는 \를 사용하지 않아도 문제가 발생하지 않으나 JSP에서는 문제가 발생
		
		System.out.println("abcd\b\b"); // \b => 문자1개 삭제
		System.out.println("abcd\f"); //\f => 프린터로 출력 시  줄변경 
		
		
		

	}

}
