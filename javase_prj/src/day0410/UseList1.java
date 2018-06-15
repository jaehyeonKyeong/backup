package day0410;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * list�� generic���� ���� ���� ���� �����ϴ� ��ü(VO)�� ���.
 * 
 * @author owner
 */
public class UseList1 {
	public UseList1() {
		List<StudentVO> list = new ArrayList<StudentVO>();
		list.add(new StudentVO(1, "���¹�", 28, 87, "��õ�� ��籸"));
		list.add(new StudentVO(2, "������", 27, 91, "������ �Ǽ���"));
		list.add(new StudentVO(3, "������", 27, 73, "���ν� ������"));
		list.add(new StudentVO(4, "������", 25, 99, "��⵵ �Ǽ���"));
		list.add(new StudentVO(5, "�����", 25, 85, "������ ���ѻ꼺"));

		// System.out.println(list);
		System.out.println("�й�\t�̸�\t����\t�ڹ�����\t�ּ�");
		// 1.�Ǽ����� ��� �л��� ���̸� Calendar�� ����Ͽ� �¾ �ط� ����
		/////////////////////////
		Calendar c1 = Calendar.getInstance();
		int year = c1.get(Calendar.YEAR);
		for (StudentVO sv : list) {
			if (sv.getAddr().endsWith("�Ǽ���")) {
				sv.setAge(year-sv.getAge()+1);
			}
				System.out.println(sv.getNum() + "\t" + sv.getName() + "\t" + sv.getAge() + "\t" + sv.getJavaScore()
						+ "\t" + sv.getAddr());
			
		}
		//////////////////////
	}

	public static void main(String[] args) {
		new UseList1();
	}// main

}// class
