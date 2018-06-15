package day0329;

/**
 * 특수문자 <br>
 * \문자의 형식을 가지면 정해진 일을 하는 문자들<br>
 * 문자열 안에서 사용.<br>
 * 
 * @author owner
 */
public class EcapeCharacter {

	public static void main(String[] args) {
		System.out.println("오늘은\t화요일\t미세먼지는\t가고\t황사가\t도래했습니다.");
		// \r - return(windows만 사용가능): 커서를 그 줄에 맨 앞으로 이동시키는 일을 하지만 특수문자로 사용하게 되면 줄변경까지
		// 수행해준다.
		System.out.println("오늘은\n화요일\r입니다");
		System.out.println("c:\\temp\\new.text");
		System.out.println("오늘은 \"화요일\" 입니다.");
		System.out.println("<a href=\'test.jsp\'>요청</a>");
		System.out.println("abcd\b");
		System.out.println("abce\f");// 프린터로 출력할때 줄변경
		// System.out.println("\k"); // 정해진 문자 이외에는 사용할 수 없음
	}

}
