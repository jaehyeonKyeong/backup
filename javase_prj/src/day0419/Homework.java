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
		list.add(new HomeworkVO("������", "27", "������ �Ǽ���"));
		list.add(new HomeworkVO("������", "27", "���ν� ������"));
		list.add(new HomeworkVO("������", "25", "��⵵ �Ǽ���"));
		list.add(new HomeworkVO("�����", "25", "������ ���ѻ꼺"));
		menu();
	}

	public void menu() {
		while (true) {
			System.out.println("1.�Է�\t2.��ȸ\t3.����");
			System.out.println("��ȣ �Է�");
			try {
				flag = System.in.read();
				if (flag != NUMBER_ONE && flag != NUMBER_TWO && flag != NUMBER_THREE) {
					JOptionPane.showMessageDialog(null, "��ȣ�� 1,2,3 �� �Է�");
				}
				if (flag == NUMBER_ONE) {
					String sinputdialog = JOptionPane.showInputDialog("�̸� , ���� , �ּҸ� �Է�").trim();
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
					System.out.println("����Ǿ����ϴ�.");
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
