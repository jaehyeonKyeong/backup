package day0420;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class UseFileWriter {

	public UseFileWriter() throws IOException {
		String data = "gkgkt ����� :D";

		File file = new File("c:/dev/temp_data/�����.txt");
		boolean flag = false;
		if (file.exists()) {
			switch (JOptionPane.showConfirmDialog(null, "������ �����մϴ�. �������?")) {
			case JOptionPane.OK_OPTION:
				break;
			default:
				flag = true;//�ƴϿ�,���, ���̾�α� x��ư
			}

		} // end if

		if (!flag) {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));// ����߿� ���丮 ���� �ٸ��ٸ� exception�� ������
	
			bw.write(data);// stream�� ���(�������δ� ���� �ʾ���)
			bw.flush();// �������� ����
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
