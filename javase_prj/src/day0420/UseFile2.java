package day0420;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class UseFile2 {
	public UseFile2() throws IOException {
		String fileName = JOptionPane.showInputDialog("������ ���ϸ� �Է�");
		
		if (fileName != null && !fileName.equals("")) {
			File file = new File("c:/dev/temp_data/" + fileName);
			String msg = file.getCanonicalPath() + "�� ���� ���� �ʾҽ��ϴ�";
			if (file.delete()) {
				msg = file.getCanonicalPath() + "�� ���� �Ǿ����ϴ�.";

			}
			JOptionPane.showMessageDialog(null, msg);
		}else {
			 
		}
	}

	public static void main(String[] args) {
		try {
			new UseFile2();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
