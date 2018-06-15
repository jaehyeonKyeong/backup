package day0420;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class UseFile2 {
	public UseFile2() throws IOException {
		String fileName = JOptionPane.showInputDialog("삭제할 파일명만 입력");
		
		if (fileName != null && !fileName.equals("")) {
			File file = new File("c:/dev/temp_data/" + fileName);
			String msg = file.getCanonicalPath() + "이 삭제 되지 않았습니다";
			if (file.delete()) {
				msg = file.getCanonicalPath() + "이 삭제 되었습니다.";

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
