package day0410;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * list의 generic으로 내가 만든 값을 저장하는 객체(VO)를 사용.
 * 
 * @author owner
 */
public class UseList1 {
	public UseList1() {
		List<StudentVO> list = new ArrayList<StudentVO>();
		list.add(new StudentVO(1, "지승민", 28, 87, "인천시 계양구"));
		list.add(new StudentVO(2, "장현준", 27, 91, "수원시 권선구"));
		list.add(new StudentVO(3, "신종성", 27, 73, "용인시 수지구"));
		list.add(new StudentVO(4, "경제현", 25, 99, "경기도 권선구"));
		list.add(new StudentVO(5, "송재원", 25, 85, "성남시 남한산성"));

		// System.out.println(list);
		System.out.println("학번\t이름\t나이\t자바점수\t주소");
		// 1.권선구에 사는 학생의 나이를 Calendar를 사용하여 태어난 해로 변경
		/////////////////////////
		Calendar c1 = Calendar.getInstance();
		int year = c1.get(Calendar.YEAR);
		for (StudentVO sv : list) {
			if (sv.getAddr().endsWith("권선구")) {
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
