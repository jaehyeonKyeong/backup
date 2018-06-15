package day0410;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * ��,��,�ϵ� �ϳ��� ��¥������ ���� �� ����ϴ� calendar class
 * 
 * @author owner
 */
public class UseCalendar {
	public UseCalendar() {
		// CalendarŬ������ ��ü ���
		// 1.�ڽ����� ����
		GregorianCalendar gc = new GregorianCalendar();
		// 2.is a ������ ��üȭ
		Calendar c = new GregorianCalendar();
		// 3.��ü�� ��� method���
		Calendar c1 = Calendar.getInstance();
		// Calendar c2=new Calendar();

		System.out.println(gc);
		System.out.println(c);
		System.out.println(c1);
		System.out.println();

		// �⵵
//		int year1 = gc.get(Calendar.YEAR);
//		int year2 = c.get(Calendar.YEAR);
		int year3 = c1.get(Calendar.YEAR);

		System.out.print(/* year1+"/"+year2+"/"+ */year3 + "�� ");

		// ���� 0~11���� �������.���� ����ڰ� �����ϴ� ���� ����� ���� +1�� ���ش�
		int month = c1.get(Calendar.MONTH) + 1;
		System.out.print(month + "�� ");

		// ��¥
		int day = c1.get(Calendar.DAY_OF_MONTH);
		System.out.println(day + "�� ");

		// ���� ����
		int am_pm = c1.get(Calendar.AM_PM);// �����̸� 0, ���ĸ� 1�̳���
		System.out.println(am_pm == Calendar.AM ? "����" : "����");

		// �迭�� �̿��� ���
		// String[] am= {"����","����"};
		// System.out.println(am[am_pm]);
		// System.out.println(new String[] {"����","����"}[am_pm]);
		// System.out.println("����,����".split(",")[am_pm]);

		// Switch~case
		switch (am_pm) {
		case Calendar.AM:
			System.out.println("����");
			break;
		case Calendar.PM:
			System.out.println("����");
			break;
		}// switch

		// ���� : ��1~��7
		int day_of_week = c1.get(Calendar.DAY_OF_WEEK);
		System.out.println(day_of_week);
		String[] week = "��,��,ȭ,��,��,��,��".split(",");
		System.out.println(week[day_of_week - 1]);

		// �ð�
		System.out.println("�ð� : " + c1.get(Calendar.HOUR) + ":" + c1.get(Calendar.HOUR_OF_DAY) + " �� "
				+ c1.get(Calendar.MINUTE) + " �� " + c1.get(Calendar.SECOND) + "��");

		/////////////// ��¥ ���� ���� ///////////////
		
		c.set(Calendar.YEAR,2019);//�� ����
		c.set(Calendar.MONTH,11-1);//�� ����(����� �����ϴ� �� ���� 1����)
		c.set(Calendar.DAY_OF_MONTH, 31);//�� ����
		//�ش� ���� �Ѵ� ���ڰ� �����Ǹ� �ڵ����� �������� ���ڰ� ���ȴ�
		System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH)
				+ " " + week[c.get(Calendar.DAY_OF_WEEK) - 1]);

	}

	public static void main(String[] args) {
		new UseCalendar();
	}

}
