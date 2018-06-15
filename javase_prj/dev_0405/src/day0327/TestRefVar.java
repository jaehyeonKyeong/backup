package day0327;

public class TestRefVar {

	public static void main(String[] args) {
		Week today,birthday,finalMatch;
		today=Week.SUNDAY;
		birthday=Week.SUNDAY;
		finalMatch=Week.SUNDAY;
		System.out.println(today);
		System.out.println(birthday);
		System.out.println(finalMatch);
		System.out.println(today==birthday);
		System.out.println(today==finalMatch);
		System.out.println(today.equals(birthday));
		System.out.println(today.equals(finalMatch));
		Week weekDay=Week.valueOf("SATURDAY");
		System.out.println(weekDay);
		Week weekDay2=Week.SATURDAY;
		System.out.println(weekDay2);
		System.out.println(weekDay==weekDay2);
		System.out.println(weekDay.equals(weekDay2));
		
		Week[] days=Week.values();
		for(Week value:days) {
			System.out.println(value);
		}//end for
		
	}//main

}//class
