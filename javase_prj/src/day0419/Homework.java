package day0419;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import day0410.StudentVO;

@SuppressWarnings("unused")
public class Homework {
	private int flag;
	public final static int NUMBER_ONE = 49;
	public final static int NUMBER_TWO = 50;
	public final static int NUMBER_THREE = 51;
	private List<HomeworkVO> list;

	public Homework() {
		list = new ArrayList<>();
		list.add(new HomeworkVO("장현준", "27", "수원시 권선구"));
		list.add(new HomeworkVO("신종성", "27", "용인시 수지구"));
		list.add(new HomeworkVO("경제현", "25", "경기도 권선구"));
		list.add(new HomeworkVO("송재원", "25", "성남시 남한산성"));
		menu();
	}

	public void menu() {
		while (true) {
			System.out.println("1.입력\t2.조회\t3.종료");
			System.out.println("번호 입력");
			try {
				flag = System.in.read();
				if (flag != NUMBER_ONE && flag != NUMBER_TWO && flag != NUMBER_THREE) {
					JOptionPane.showMessageDialog(null, "번호는 1,2,3 만 입력");
				}
				if (flag == NUMBER_ONE) {
					String sinputdialog = JOptionPane.showInputDialog("이름 , 나이 , 주소를 입력").trim();
					StringTokenizer stk = new StringTokenizer(sinputdialog, ",");
					list.add(new HomeworkVO(stk.nextToken(), stk.nextToken(), stk.nextToken()));
					
				}
				if (flag == NUMBER_TWO) {
					StringBuilder content=new StringBuilder();
					JTextArea ta=new JTextArea(25,50);
					
					JScrollPane jsp=new JScrollPane(ta);
					JOptionPane.showMessageDialog(null, jsp);
				}
				if (flag == NUMBER_THREE) {
					System.out.println("종료되었습니다.");
					System.exit(0);
				}
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
	}

	public static void main(String[] args) {
		new Homework();
	}
}
