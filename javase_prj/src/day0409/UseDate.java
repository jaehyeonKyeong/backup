package day0409;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * ��¥ ���� Ŭ����
 * 
 * @author owner
 */
@SuppressWarnings("unused")
public class UseDate {
	public UseDate() {
		//1.����)
		Date date=new Date();
		System.out.println(date);//���ϴ� ��¥ ������ �ƴ�
		
		//���ϴ� ��¥ ������ ��� ���� SimpleDateFormat���
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd EEEE a hh:mm:ss");
		System.out.println(sdf);//toString override���� �ʾұ⶧���� �ּҰ� ����
		
		String formatDate=sdf.format(date);
		System.out.println(formatDate);
		
	}//Contructor


	public static void main(String[] args) {
		new UseDate();
		// long start_time = System.currentTimeMillis();// �ڵ��� ����ð� ����
		// int sum = 0;
		// for (int i = 0; i < 100000; i++) {
		// // ����� ���� �ϸ� �ڵ��� ����ð��� �������Ƿ� �����ϴ� �ڵ忡���� �ܼ� ��±����� ��������� �ȵȴ�
		// System.out.println("i=" + i);
		// sum += i;
		// }
		// System.out.println("��� : " + sum);
		// long end_time = System.currentTimeMillis();
		// System.out.println("���� �ð�" + (end_time - start_time) + "ms");
	}

}
