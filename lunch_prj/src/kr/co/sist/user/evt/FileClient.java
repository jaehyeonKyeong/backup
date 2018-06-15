package kr.co.sist.user.evt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class FileClient {

	public void uploadProcess(File file) throws IOException {
		// 1.���� ����
		Socket client = new Socket("211.63.89.144", 20000);
		 // 2.���ε��� ������ ���� ���
		 int size = 0;// ������ byte�迭�� �� ����;
		 int len = 0;// �о���� ���� ũ��
		 // HDD�� �ѹ� �о���϶��� ũ�⸸ŭ �����ϱ����� �迭
		 byte[] readData = new byte[512];

		DataOutputStream dos = null;
		DataInputStream dis=null;
		FileOutputStream fos=null;
		

		try {
			dos=new DataOutputStream(client.getOutputStream());
			// ���� ���� ������
			dos.writeUTF(file.getName());
			// ���� ũ�⸦ ������
			dis=new DataInputStream(client.getInputStream());
			size = dis.readInt();
			readData = new byte[512];
			// 3.������ HDD�� File �� ����.
			// 3-1.���� ��Ʈ�� ����
			file = new File("C:/dev/workspace/lunch_prj/src/kr/co/sist/user/img/" + file.getName());
			fos = new FileOutputStream(file);
			
			while (size > 0) {
				// 3.������ HDD�� File�� ���ϴ�.
				len = dis.read(readData);
				fos.write(readData, 0, len);
				fos.flush();
				size--;
			} // end while
			
			fos.close();
		} finally {

			if (dos != null) {
				dos.close();
			} // end if
			if (client != null) {
				client.close();
			}
		} // end

	}// uploadProcess

}
