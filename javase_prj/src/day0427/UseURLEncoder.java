package day0427;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UseURLEncoder {
	
	public UseURLEncoder() {
		String msg="aaa지승민bbb";
		try {
			//charset : 문자 집합표(모든 문자에 대응되는 코드가 생성되어있는 표)
			//1byte charset:8859_1 - 영어,숫자,특수문자(실제 데이터는 7bit만 씀)
			//2byte charset:EUC-KR(국제 표준), KSC5601(국내표준), MS949(MS표준) -영어, 숫자, 특수문자, 한글
			//3byte charset:UTF-8(국제표준) - 같은 글자를 표현하는데 저장공간을 더 많이 사용
			String encode=URLEncoder.encode(msg, "UTF-8"); //character set을 지원하지 않을 수도 있음.
			System.out.println("원본 : "+ msg);
			System.out.println("변환 : "+ encode);
			String Decode=URLDecoder.decode(encode, "UTF-8");
			System.out.println("디코드 : "+ Decode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new UseURLEncoder();
	}

}
