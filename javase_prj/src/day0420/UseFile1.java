package day0420;

import java.io.File;

import javax.swing.JOptionPane;

public class UseFile1 {

	public UseFile1() {
		String dir = JOptionPane.showInputDialog("Directory���� �Է����ּ���\n��) C:/temp_example");

		if (dir != null && !dir.equals("")) {
			File file = new File(dir);
			if (!file.exists()) {
				String msg = dir + "���� ���� ����";
				if (file.mkdirs()) {
					msg = dir + "���� ���� ����";
				}
				JOptionPane.showMessageDialog(null, msg);
			}else {
				JOptionPane.showMessageDialog(null, "�̹� ������ �����ؿ�");
			}
		}

	}// constructor

	public static void main(String[] args) {
		new UseFile1();
	}

}
