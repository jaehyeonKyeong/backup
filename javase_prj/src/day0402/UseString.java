package day0402;

/**
 * 문자열을 저장하고 사용할 수 있는 클레스인 string 클래스 의 사용<br>
 *  java에서 제공하는 클래스의 이름과 사용자 설정의 클래스 이름이<br>
 * 같다면 같은 패키지의 모든 클래스에서는 사용자 설정의 클래스를 먼저 사용하게 된다
 * <br>(method에서 같은이름의 instance 변수보다 지역변수를 참조하는것과 같음).<br>
 * (따라서 이름이 같다면 클래스를 사용하는 모든 코드에서 full path를 설정하여 사용한다.)<br>
 * full path : 패키지명.클래스명 의 형식
 * 
 * @author owner
 */
public class UseString {

	public static void main(String[] args) { 
		// 기본형형식 : String str="문자열";
		String str = "ABCDE";

		// 참조형형식 : String str=new String("문자열");
		String str1 = new String("ABCDE"); 
		System.out.println("str:"+str);
		//실행 되는 JVM에서 같은 문자열은 하나만 생성되고 사용됨.
		//비교: == : 객체에서 ==은 주소가 같은지를 비교함.
		if(str=="ABCDE") {
			System.out.println("==에서 기본형 형식은 같다");
		}else {
			System.out.println("==에서 기본형 형식은 다르다");
		}//end else
		System.out.println("str1:"+str1);
		if(str1=="ABCDE") {
			System.out.println("==에서 참조형 형식은 같다");
		}else {
			System.out.println("==에서 참조형 형식은 다르다");
		}//end else
				
		//문자열의 비교는 String클래스를 어떻게 선언햇는지와 관련없이 동일한 비교결과를 내어주는 .equals를 권장함.
		System.out.println("기본형 "+(str.equals("ABCDE")?"같다":"다르다"));
		System.out.println("참조형 "+(str1.equals("ABCDE")?"같다":"다르다"));
		
		String temp="AbcDcecfG";
		String email="rudwpgus25@naver.com";
		
		System.out.println(temp+"의 길이 "+temp.length());
		System.out.println(email+"의 길이 "+email.length());
		System.out.println(temp+"대문자 "+temp.toUpperCase());
		System.out.println(temp+"소문자 "+temp.toLowerCase());
		
		System.out.println(temp+"에서 처음'c'의 인덱스 "+temp.indexOf("c"));
		System.out.println(temp+"에서 'k'의 인덱스 "+temp.indexOf("k"));
		System.out.println(temp+"에서 마지막'c'의 인덱스 "+temp.lastIndexOf("c"));
		System.out.println(temp+"에서 5번째의 인덱스에 해당되는 문자 "+temp.charAt(5));
		
		//AbcDcecfG
		//012345678
		//자식 문자열 얻기 substring(시작인덱스,끝인덱스+1)
		System.out.println(temp.substring(3,6));
		//시작 인덱스만 넣으면 끝까지 잘라준다.
		System.out.println(email+"에서 domain주소만 얻기"+email.substring(email.indexOf("@")+1));
		System.out.println(email+"에서 mail주소만 얻기"+email.substring(0,email.indexOf("@")));
		
		//시작 문자열에 대한 비교
		String temp1="피씨방";
		if(temp1.startsWith("씨방")) {
			System.out.println("고운말을 사용해주세요!");
		}else {
			System.out.println(temp1);
		}
		
		temp1="서울시 서초구 서초동";//충청남도 공주시 공주읍 공주리
		if(temp1.endsWith("동")) {
			System.out.println("도시");
		}else {
			System.out.println("시골");
		}
		temp1="나 지금 피씨방인데! 넌 지금 어디니 씨방새야!";
		if(temp1.contains("씨방새")) {
			System.out.println("고운말!");
			System.out.println(temp1.replaceAll("씨방새", "***"));
		}else {
			System.out.println(temp1);
		}
		
		temp1="   rasdf fdsa    ";
		
		System.out.println(temp1+"의 앞뒤 공백제거 ["+temp1.trim()+"]");
		
		String temp3=temp1.concat("반장");
		System.out.println(temp3);
		
		int i=4;
		//정수(기본형 데이터형)를 문자열 값으로 변환
		temp3=String.valueOf(i);
		System.out.println("정수 "+i);
		System.out.println("문자열 "+temp3);
		
		//format : 여러개의 값을 형식을 맞춰 출력할때
		double d=10.123;
		boolean b=true;
		temp3=String.format("정수: %-5d, 실수: %.2f, 불린: %b",i,d,b);
		System.out.println(temp3);
		
		
		
	}

}
