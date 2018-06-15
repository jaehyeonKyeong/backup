package day0420;

import java.io.File;

import javax.swing.JOptionPane;

public class UseFile1 {

	public UseFile1() {
		String dir = JOptionPane.showInputDialog("Directory명을 입력해주세요\n예) C:/temp_example");

		if (dir != null && !dir.equals("")) {
			File file = new File(dir);
			if (!file.exists()) {
				String msg = dir + "폴더 생성 실패";
				if (file.mkdirs()) {
					msg = dir + "폴더 생성 성공";
				}
				JOptionPane.showMessageDialog(null, msg);
			}else {
				JOptionPane.showMessageDialog(null, "이미 파일이 존재해요");
			}
		}

	}// constructor

	public static void main(String[] args) {
		new UseFile1();
	}

}
