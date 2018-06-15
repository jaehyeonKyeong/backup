package day0420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

@SuppressWarnings("unused")
public class work {
	public static final String INPUT = "1";
	public static final String OUTPUT = "2";
	public static final String END = "3";

	private List<WorkVO> dataList;

	public work() throws IOException {
		boolean exitFlag = false;
		String inputNum = "";
		dataList = new ArrayList<WorkVO>();
			do {

				System.out.println("�۾��� �������ּ���");
				System.out.println("1. �Է� 2. ���  3.����");
				inputNum =new BufferedReader(new InputStreamReader(System.in)).readLine();
				switch (inputNum) {

				case INPUT:
					inputData();
					break;
				case OUTPUT:
					printData();
					break;
				case END:
					JOptionPane.showMessageDialog(null, "������ּ� �����մϴ�. ����� �����ʹ� ���� ��� �����˴ϴ�.");
					exitFlag = true;
					break;
				default:
					JOptionPane.showMessageDialog(null, "�Է��� 1,2,3,�� �����մϴ�.");

				}

			} while (!exitFlag);
	}

	public void inputData() {
		String tempData = JOptionPane.showInputDialog("ģ���߰�\n�Է� ����) �̸�, ����, �ּ�");
		String[] tempArr = tempData.split(",");

		if (tempArr.length != 3) {
			JOptionPane.showMessageDialog(null, "�Է������� �ùٸ��� �ʽ��ϴ�.");
			return;
		}
		try {
			WorkVO wv = new WorkVO(tempArr[0], Integer.parseInt(tempArr[1]), tempArr[2]);
			// vo�� ������� �ʵ��� �����ϱ� ���� list�߰�
			dataList.add(wv);
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "���̴� ���������Դϴ�");
		}
		// �Է� �����͸� VO�� ����
	}

	public void printData() {
		if (dataList.size() == 0) {
			JOptionPane.showMessageDialog(null, "�Էµ� ģ���� �����ϴ�");
			return;
		}
		StringBuilder printData = new StringBuilder();
		printData.append("--------------------------------------------------------------------------------\n").append("\t����� ģ��\n").append("�̸�\t����\t�ּ�\n")
				.append("--------------------------------------------------------------------------------\n");

		WorkVO wv = null;
		int totalAge = 0;
		for (int i = 0; i < dataList.size(); i++) {
			wv = dataList.get(i); // ����Ʈ �濡 �Էµ� VO�� ������
			printData.append(i + 1).append("\t").append((wv.getName())).append("\t").append((wv.getAge())).append("\t")
					.append((wv.getAddr())).append("\n");
			totalAge += wv.getAge();
		}
		printData.append("--------------------------------------------------------------------------------\n");
		printData.append("������ ��:[").append(totalAge).append("]");
		JTextArea jtaOuput = new JTextArea(25, 41);
		jtaOuput.setEditable(false);
		JScrollPane jspOutput = new JScrollPane(jtaOuput);
		jtaOuput.setText(printData.toString());

		jspOutput.setBorder(new TitledBorder("���� ģ����"));

		JOptionPane.showMessageDialog(null, jspOutput);

	}

	public static void main(String[] args) {

		try {
			new work();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "����� ���� �߻�");
			e.printStackTrace();
		}

	}

}
