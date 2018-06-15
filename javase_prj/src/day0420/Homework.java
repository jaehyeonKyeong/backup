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
		String dir = JOptionPane.showInputDialog("Directory명을 입력해주세요\n예) C:/temp_example");
		directoryList = new ArrayList<>();
		if (dir != null && !dir.equals("")) {
			file = new File(dir);
//			directoryList.add();
			fileArray=file.listFiles();
			if (!file.exists()) {
				String msg = dir + "폴더 생성 실패";
				if (file.mkdirs()) {
					msg = dir + "폴더 생성 성공";
				}
				JOptionPane.showMessageDialog(null, msg);
			}else {
				printData();
			}
		}
		
	}//consturctor
	public void printData() {
		StringBuilder printData = new StringBuilder();
		printData.append("입력폴더:\t").append(file.getAbsolutePath()).append("\n");
		printData.append("-------------------------------------------------------------------------------------------------------------------\n");
		printData.append("이름\t수정한날짜\t유형\t크기\n");
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
