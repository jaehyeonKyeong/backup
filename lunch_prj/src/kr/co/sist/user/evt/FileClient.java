package kr.co.sist.user.evt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class FileClient {

	public void uploadProcess(File file) throws IOException {
		// 1.소켓 열고
		Socket client = new Socket("211.63.89.144", 20000);
		 // 2.업로드할 파일의 정보 얻기
		 int size = 0;// 보내는 byte배열의 총 갯수;
		 int len = 0;// 읽어들인 실제 크기
		 // HDD가 한번 읽어들일때의 크기만큼 저장하기위한 배열
		 byte[] readData = new byte[512];

		DataOutputStream dos = null;
		DataInputStream dis=null;
		FileOutputStream fos=null;
		

		try {
			dos=new DataOutputStream(client.getOutputStream());
			// 파일 명을 보내고
			dos.writeUTF(file.getName());
			// 파일 크기를 보내고
			dis=new DataInputStream(client.getInputStream());
			size = dis.readInt();
			readData = new byte[512];
			// 3.서버의 HDD에 File 로 쓴다.
			// 3-1.파일 스트림 연결
			file = new File("C:/dev/workspace/lunch_prj/src/kr/co/sist/user/img/" + file.getName());
			fos = new FileOutputStream(file);
			
			while (size > 0) {
				// 3.서버의 HDD에 File로 씁니다.
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
