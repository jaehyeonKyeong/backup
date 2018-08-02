package kr.co.sist.licensee.controller;

import java.awt.FileDialog;
import java.io.File;
import java.io.IOException;

import kr.co.sist.user.view.Login;

public class clientTest {
	
	public clientTest() {
		FileDialog fd=new FileDialog(new Login(), "¿˙¿Â", FileDialog.LOAD);
		fd.setVisible(true);
		File file=new File(fd.getDirectory()+fd.getFile());
		FileClient fc=new FileClient();
		try {
			fc.uploadProcess(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		new clientTest();
	}
}
