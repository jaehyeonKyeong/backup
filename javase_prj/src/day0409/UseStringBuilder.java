package day0409;

import java.util.concurrent.SynchronousQueue;

/**
 * 긴 문자열을 다루는 String Builder 사용
 * 
 * @author owner
 */
@SuppressWarnings("unused")
public class UseStringBuilder {

	public void useStringBuilder() {
		// 1.생성
		StringBuilder sb = new StringBuilder();
		// 값 덧붙임
		int i = 9;
		double d = 11.31;
		String str = "자바 데헷";

		// sb.append(i);
		// sb.append(d);
		// sb.append(str);
		// method chain : method를 ;로 끊지 않고 .을 이용해 계속 호출하는 문법
		// sb.append(i).append(" ").append(d).append(str);

		sb.append("ABCD EFG");
		// 삽입 : 원하는 인덱스에 값을 넣을 수 있다.

		sb.insert(5, "지승민");
		sb.insert(4, "인천시의 지자랑");
		// ABCD인천시의 지자랑 지승민EFG
		sb.delete(9, 13);// 삭제할때는 끝 index+1
		// ABCD인천시의 지승민EFG

		System.out.println(sb);
		// 객체를 집어넣었을때 주소가 나오지 않는다는 것은 toString으로 override되었기 때문
	}// useStringBuilder

	public void useStringBuffer() {
		// 1.생성
		StringBuffer sb = new StringBuffer();
		// 값 덧붙임
		int i = 9;
		double d = 11.31;
		String str = "자바 데헷";

		// sb.append(i);
		// sb.append(d);
		// sb.append(str);
		// method chain : method를 ;로 끊지 않고 .을 이용해 계속 호출하는 문법
		// sb.append(i).append(" ").append(d).append(str);

		sb.append("ABCD EFG");
		// 삽입 : 원하는 인덱스에 값을 넣을 수 있다.

		sb.insert(5, "지승민");
		sb.insert(4, "인천시의 지자랑");
		// ABCD인천시의 지자랑 지승민EFG
		sb.delete(9, 13);// 삭제할때는 끝 index+1
		// ABCD인천시의 지승민EFG

		System.out.println(sb);
		// 객체를 집어넣었을때 주소가 나오지 않는다는 것은 toString으로 override되었기 때문

	}// useStringBuffer

	public static void main(String[] args) {

		UseStringBuilder usb = new UseStringBuilder();
		System.out.println("------------------Builder------------------");
		usb.useStringBuilder();
		System.out.println("------------------Buffer------------------");
		usb.useStringBuffer();

		// String str=" ";
		// String에 +연산이 들어가면 Compiler가 String Builder 객체를 생성하여 +연산을 append로 변경함.
		// System.out.println(str+"오늘은 "+4+"월 "+9+"일입니다.");
		StringBuilder sb = new StringBuilder("ABCDE");
		String str = "ABCDE";
		// 같은 문자열이 있는지 비교
		// if(str.equals(sb)) {
		// System.out.println("같음");
		// }else {
		// System.out.println("다름");
		// }
		System.out.println(sb.toString().equals(str) ? "같음" : "다름");
		System.out.println(str.equals(sb.toString()) ? "같음" : "다름");// str은 문자열 저장소(한가지) // sb는 heap에 올라감(주소를 담고있
		// 같다가나오게

	}// main

}// class
