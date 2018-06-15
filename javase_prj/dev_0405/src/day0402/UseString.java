package day0402;

/**
 * 문자열을 저장하고 사용할 수 있는 클래스인 String 클래스의 사용 java에서 저공하는 클래스의 이름과 내가 만드는 클래스의 이름이
 * 같다면 이 패키지의 모든 클래스에서는 내가 만든 클래스를 먼저 사용하게 된다 (이름이 같은 클래스를 만들지 않던가, 아니면 클래스를
 * 사용하는 모든 코드에서 full path를 설정하여 사용한다) full path : 패키지명.클래스명 의 형식으로 사용한다
 * 
 * @author owner
 */
public class UseString {

	public static void main(String[] args) {
		// 기본형 형식: String str = "문자열";
		String str = "ABCDE";

		// 참조형 형식 : String str = new String("문자열");
		String str1 = new String("ABCDE");

		// 실행되는 JVM에서 같은 문자열은 하나만 생성되고 사용
		// 비교 : == : 객체에 == 주소가 같은 지 비교
		System.out.println("str = " + str);
		if (str == "ABCDE") {
			System.out.println("기본형 형식으로 선언 : 같다");
		} else {
			System.out.println("기본형 형식으로 선언 : 다르다");
		} // end else

		System.out.println("str1 = " + str1);
		if (str1 == "ABCDE") {
			System.out.println("참조형 형식으로 선언 : 같다");
		} else {
			System.out.println("참조형 형식으로 선언 : 다르다");
		}
		// 문자열의 비교는 String 클래스를 어떻게 선언했는지와 관련없이 동일한 비교 결과를 내어주눈 .equals를 사용한다
		System.out.println("기본형 " + (str.equals("ABCDE") ? "같다" : "다르다"));
		System.out.println("참조형 " + (str1.equals("ABCDE") ? "같다" : "다르다"));
		
		String temp="AbcDcecfG";
		String email = "ircw@naver.com";
		
		System.out.println(temp+"의 길이 "+temp.length());
		System.out.println(email+"의 길이 "+email.length());
		System.out.println(temp+" 대문자 "+temp.toUpperCase());
		System.out.println(temp+" 소문자 "+temp.toLowerCase());
		System.out.println(temp+"에서 처음 \'c\'의 인덱스 "+temp.indexOf("c"));
		System.out.println(temp+"에서 처음 \'k\'의 인덱스 "+temp.indexOf("k"));
		System.out.println(temp+"에서 마지막 \'c\'의 인덱스 "+temp.lastIndexOf("c"));
		
		System.out.println(temp+"에서 4번째 인덱서에 해당하는 문자는 "+temp.charAt(4));
		System.out.println(temp+"에서 5번째 인덱서에 해당하는 문자는 "+temp.charAt(5));
		// 자식문자열 얻기 substring(시작인덱스, 끝인덱스+1)
		System.out.println(temp+"에서 3번째에서 5번째까지의 자식문자열 "+temp.substring(3,6));
		// 시작인덱스만 넣으면 끝까지 잘라준다
		System.out.println(email+"에서 도메인주소 "+email.substring(email.indexOf("@")+1));
		System.out.println(email+"에서 메일주소 "+email.substring(0,email.indexOf("@")));
		
		//시작 문자열에 대한 비교
		String temp1 = "씨방새리";
		if(temp1.startsWith("씨방")) {
			System.out.println("고운말 사용해 주세요!");
		} else {
			System.out.println(temp1);
		}
		
		//temp1 = "서울시 서초구 서초동";
		temp1 = "충청남도 공주시 공주읍 공주리";
		if(temp1.endsWith("동")) {
			System.out.println("도시");
		} else {
			System.out.println("시골");
		}
		temp1="나 지금 피씨방인데! 넌 어디니 씨방새야";
		if(temp1.contains("씨방새")) {
			System.out.println("고운말 사용해 주세요!");
		}else {
			System.out.println(temp1);
		}
		
		temp1="나 지금 피씨방인데! 넌 어디니 씨방새야";
		System.out.println(temp1.replaceAll("씨방새","***"));
		
		temp1 = "   지 승민   ";
		System.out.println(temp1);
		System.out.println("["+temp1+"]");
		System.out.println("["+temp1.trim()+"]");
		
		String temp3=temp1.concat("반장");
		System.out.println(temp3);
		
		int i=4;
		temp3=String.valueOf(i);
		System.out.println("문자열 "+temp3+", 정수 "+i);
		
		//format : 여러개의 값을 형식을 맞춰 출력할 때
		double d=10.123;
		boolean b=true;
		temp3=String.format("정수 : %-5d, 실수 : %.2f, 불린 : %b",i,d,b);
		System.out.println(temp3);
		
		
	
		
		
		
		
		
		
		
		

	} // main

} // class
