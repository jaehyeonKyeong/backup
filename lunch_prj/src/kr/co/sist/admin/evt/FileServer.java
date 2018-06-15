package kr.co.sist.admin.evt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer extends Thread {

	private ServerSocket server;

	@Override
	public void run() {
		// 서버소켓 열고
		try {
			server = new ServerSocket(20000);
			System.out.println("파일업로드 서버 동작\n");
			Socket socket = null;

			DataInputStream dis = null;
			DataOutputStream dos = null;

			int size = 0;// 보내오는 파일의 크기(배열의 총 갯수)
			int len = 0;// 한번에 보내오는 byte[]내 채워진 크기
			String fileName = "";
			byte[] readData = null;// 클라이언트가 보내오는 파일의 binary를 받기 위한 배열

			File file = null;

			FileInputStream fis = null;
			while (true) {
				// 1-2 접속자 소켓을 받는다.
				socket = server.accept();
				// 2.클라이언트가 보내오는 파일 정보 순서대로 받고
				// 2-1.소켓에서 스트림 연결
				dis = new DataInputStream(socket.getInputStream());

				fileName = dis.readUTF();// 클라이언트가 보내오는 파일명 받기
				file = new File("C:/dev/workspace/lunch_prj/src/kr/co/sist/img/" + fileName);
				fis = new FileInputStream(file); // 선택한 파일을 스트림으로 연결
				
				readData= new byte[512];
				while ((len = fis.read(readData)) > 0) {
					size++;// 읽어들인 배열의 갯수
				} // end while
					// 보낼 파일의 배열 수 (총 갯수)를 얻었다면 연결을 끊는다.
					// 파일의 끝으로 이동한 포인터는 다시 파일의 처음으로 돌아가지 않는다.
				fis.close();

				fis = new FileInputStream(file);// 보내기위해 새로 연결한다.
				dos = new DataOutputStream(socket.getOutputStream());
				dos.writeInt(size);
				
				System.out.println( file.exists());
				
				while (size > 0) {// 전송할 파일의 갯수가 (byte[]) 존재한다면
					len = fis.read(readData);
					dos.write(readData, 0, len);// 데이터와 파일의 크기까지를 기록
					dos.flush();
					size--;// 파일의 내용을 한번 보낼때 마다 크기를 줄인다.

				} // end while

				if (fis != null) {
					fis.close();
				}
				if (dos != null) {
					dos.close();
				}

			} // end while

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}// class
