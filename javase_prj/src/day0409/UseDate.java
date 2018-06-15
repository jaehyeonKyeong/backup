package day0409;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 날짜 관련 클래스
 * 
 * @author owner
 */
@SuppressWarnings("unused")
public class UseDate {
	public UseDate() {
		//1.생성)
		Date date=new Date();
		System.out.println(date);//원하는 날짜 정보가 아님
		
		//원하는 날짜 정보를 얻기 위해 SimpleDateFormat사용
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd EEEE a hh:mm:ss");
		System.out.println(sdf);//toString override하지 않았기때문에 주소가 나옴
		
		String formatDate=sdf.format(date);
		System.out.println(formatDate);
		
	}//Contructor


	public static void main(String[] args) {
		new UseDate();
		// long start_time = System.currentTimeMillis();// 코드의 실행시간 측정
		// int sum = 0;
		// for (int i = 0; i < 100000; i++) {
		// // 출력을 실행 하면 코드의 실행시간이 느려지므로 서비스하는 코드에서는 콘솔 출력구문이 들어있으면 안된다
		// System.out.println("i=" + i);
		// sum += i;
		// }
		// System.out.println("결과 : " + sum);
		// long end_time = System.currentTimeMillis();
		// System.out.println("수행 시간" + (end_time - start_time) + "ms");
	}

}
