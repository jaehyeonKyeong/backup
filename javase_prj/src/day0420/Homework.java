package day0420;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

@SuppressWarnings("unused")
public class Homework {
	private File file;
	@SuppressWarnings("unused")
	private List<File[]> directoryList;
	File[] fileArray;


	public Homework() {
		String dir = JOptionPane.showInputDialog("Directory���� �Է����ּ���\n��) C:/temp_example");
		directoryList = new ArrayList<>();
		if (dir != null && !dir.equals("")) {
			file = new File(dir);
//			directoryList.add();
			fileArray=file.listFiles();
			if (!file.exists()) {
				String msg = dir + "���� ���� ����";
				if (file.mkdirs()) {
					msg = dir + "���� ���� ����";
				}
				JOptionPane.showMessageDialog(null, msg);
			}else {
				printData();
			}
		}
		
	}//consturctor
	public void printData() {
		StringBuilder printData = new StringBuilder();
		printData.append("�Է�����:\t").append(file.getAbsolutePath()).append("\n");
		printData.append("-------------------------------------------------------------------------------------------------------------------\n");
		printData.append("�̸�\t�����ѳ�¥\t����\tũ��\n");
		printData.append("-------------------------------------------------------------------------------------------------------------------\n");
		for(int i=0;i<fileArray.length;i++) {
			Date date=new Date(fileArray[i].lastModified());
			SimpleDateFormat sdf=new SimpleDateFormat();
			printData.append(fileArray[i]).append("\t").append(sdf.format(date)).append("\n");
		}

		JTextArea jtaOuput = new JTextArea(25, 50);
		jtaOuput.setEditable(false);
		JScrollPane jspOutput = new JScrollPane(jtaOuput);
		jtaOuput.setText(printData.toString());


		JOptionPane.showMessageDialog(null, jspOutput);

	}
	public static void main(String[] args) {
		new Homework();
	}

}
