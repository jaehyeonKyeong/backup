package day0420;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class UseFileWriter {

	public UseFileWriter() throws IOException {
		String data = "gkgkt 송재원 :D";

		File file = new File("c:/dev/temp_data/송재원.txt");
		boolean flag = false;
		if (file.exists()) {
			switch (JOptionPane.showConfirmDialog(null, "파일이 존재합니다. 덮어씌울까요?")) {
			case JOptionPane.OK_OPTION:
				break;
			default:
				flag = true;//아니오,취소, 다이얼로그 x버튼
			}

		} // end if

		if (!flag) {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));// 경로중에 디렉토리 명이 다르다면 exception이 떨어짐
	
			bw.write(data);// stream에 기록(목적지로는 가지 않았음)
			bw.flush();// 목적지에 분출
			bw.close();
		}

	}// constructor

	public static void main(String[] args) {
		try {
			new UseFileWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
