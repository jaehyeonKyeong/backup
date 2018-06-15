package day0410;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 년,월,일등 하나의 날짜정보를 얻을 때 사용하는 calendar class
 * 
 * @author owner
 */
public class UseCalendar {
	public UseCalendar() {
		// Calendar클래스의 객체 얻기
		// 1.자식으로 생성
		GregorianCalendar gc = new GregorianCalendar();
		// 2.is a 관계의 객체화
		Calendar c = new GregorianCalendar();
		// 3.객체를 얻는 method사용
		Calendar c1 = Calendar.getInstance();
		// Calendar c2=new Calendar();

		System.out.println(gc);
		System.out.println(c);
		System.out.println(c1);
		System.out.println();

		// 년도
//		int year1 = gc.get(Calendar.YEAR);
//		int year2 = c.get(Calendar.YEAR);
		int year3 = c1.get(Calendar.YEAR);

		System.out.print(/* year1+"/"+year2+"/"+ */year3 + "년 ");

		// 월은 0~11월로 얻어진다.따라서 사용자가 생각하는 월로 만들기 위해 +1을 해준다
		int month = c1.get(Calendar.MONTH) + 1;
		System.out.print(month + "월 ");

		// 날짜
		int day = c1.get(Calendar.DAY_OF_MONTH);
		System.out.println(day + "일 ");

		// 오전 오후
		int am_pm = c1.get(Calendar.AM_PM);// 오전이면 0, 오후면 1이나옴
		System.out.println(am_pm == Calendar.AM ? "오전" : "오후");

		// 배열을 이용한 출력
		// String[] am= {"오전","오후"};
		// System.out.println(am[am_pm]);
		// System.out.println(new String[] {"오전","오후"}[am_pm]);
		// System.out.println("오전,오후".split(",")[am_pm]);

		// Switch~case
		switch (am_pm) {
		case Calendar.AM:
			System.out.println("오전");
			break;
		case Calendar.PM:
			System.out.println("오후");
			break;
		}// switch

		// 요일 : 일1~토7
		int day_of_week = c1.get(Calendar.DAY_OF_WEEK);
		System.out.println(day_of_week);
		String[] week = "일,월,화,수,목,금,토".split(",");
		System.out.println(week[day_of_week - 1]);

		// 시간
		System.out.println("시간 : " + c1.get(Calendar.HOUR) + ":" + c1.get(Calendar.HOUR_OF_DAY) + " 시 "
				+ c1.get(Calendar.MINUTE) + " 분 " + c1.get(Calendar.SECOND) + "초");

		/////////////// 날짜 정보 변경 ///////////////
		
		c.set(Calendar.YEAR,2019);//년 변경
		c.set(Calendar.MONTH,11-1);//월 변경(사람이 생각하는 월 보다 1적게)
		c.set(Calendar.DAY_OF_MONTH, 31);//일 변경
		//해당 월이 넘는 일자가 설정되면 자동으로 다음달의 날자가 계산된다
		System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH)
				+ " " + week[c.get(Calendar.DAY_OF_WEEK) - 1]);

	}

	public static void main(String[] args) {
		new UseCalendar();
	}

}
