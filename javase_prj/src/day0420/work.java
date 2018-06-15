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

				System.out.println("작업을 선택해주세요");
				System.out.println("1. 입력 2. 출력  3.종료");
				inputNum =new BufferedReader(new InputStreamReader(System.in)).readLine();
				switch (inputNum) {

				case INPUT:
					inputData();
					break;
				case OUTPUT:
					printData();
					break;
				case END:
					JOptionPane.showMessageDialog(null, "사용해주셔 감사합니다. 저장된 데이터는 종료 즉시 삭제됩니다.");
					exitFlag = true;
					break;
				default:
					JOptionPane.showMessageDialog(null, "입력은 1,2,3,만 가능합니다.");

				}

			} while (!exitFlag);
	}

	public void inputData() {
		String tempData = JOptionPane.showInputDialog("친구추가\n입력 형식) 이름, 나이, 주소");
		String[] tempArr = tempData.split(",");

		if (tempArr.length != 3) {
			JOptionPane.showMessageDialog(null, "입력형식이 올바르지 않습니다.");
			return;
		}
		try {
			WorkVO wv = new WorkVO(tempArr[0], Integer.parseInt(tempArr[1]), tempArr[2]);
			// vo가 사라지지 않도록 관리하기 위해 list추가
			dataList.add(wv);
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "나이는 숫자형태입니다");
		}
		// 입력 데이터를 VO로 저장
	}

	public void printData() {
		if (dataList.size() == 0) {
			JOptionPane.showMessageDialog(null, "입력된 친구가 없습니다");
			return;
		}
		StringBuilder printData = new StringBuilder();
		printData.append("--------------------------------------------------------------------------------\n").append("\t저장된 친구\n").append("이름\t나이\t주소\n")
				.append("--------------------------------------------------------------------------------\n");

		WorkVO wv = null;
		int totalAge = 0;
		for (int i = 0; i < dataList.size(); i++) {
			wv = dataList.get(i); // 리스트 방에 입력된 VO를 꺼내옴
			printData.append(i + 1).append("\t").append((wv.getName())).append("\t").append((wv.getAge())).append("\t")
					.append((wv.getAddr())).append("\n");
			totalAge += wv.getAge();
		}
		printData.append("--------------------------------------------------------------------------------\n");
		printData.append("나이의 합:[").append(totalAge).append("]");
		JTextArea jtaOuput = new JTextArea(25, 41);
		jtaOuput.setEditable(false);
		JScrollPane jspOutput = new JScrollPane(jtaOuput);
		jtaOuput.setText(printData.toString());

		jspOutput.setBorder(new TitledBorder("나의 친구들"));

		JOptionPane.showMessageDialog(null, jspOutput);

	}

	public static void main(String[] args) {

		try {
			new work();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "사용중 문제 발생");
			e.printStackTrace();
		}

	}

}
