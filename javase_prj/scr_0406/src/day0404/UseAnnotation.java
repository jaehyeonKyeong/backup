package day0404;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *	JDK1.5부터 지원되는 Annotation의 사용
 * @author owner
 */
public class UseAnnotation {
	@Override
	public String toString() {
        return "오지마을 이장님도 인정하는 자바 인지용?";
//        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }//toString
	
	@Deprecated
	public void printName() {
		System.out.println("이종민");
	}

	@SuppressWarnings({"unused","rawtypes"}) //여러 속성을 모아서 사용
	public void test() {
//	@SuppressWarnings("unused")
		String str="흑흑모래모래자갈자갈";
//		@SuppressWarnings("rawtypes")
		List list = new ArrayList();
	}

	public static void main(String[] args) {
		UseAnnotation ua = new UseAnnotation();
		//객체를 출력하면 출력 method 안에서 해당 객체의 toString()를 호출하여 주소를 출력한다.
		
		System.out.println(ua+"\n"+ua.toString());
		String str = new String("날이 오져서 날이 오지지 않아서 모든날이 오졌다.");
		System.out.println(str+"\n"+str.toString());
		System.out.println("------------------------------------------------");
		ua.printName();
		
		Date date = new Date();
		System.out.println(date);
		
//		System.out.println(date.getYear()+1900); //곧 삭제 예정이므로 사용하지 말라는 경고 
		
		
		
		
	}//main

}//class
