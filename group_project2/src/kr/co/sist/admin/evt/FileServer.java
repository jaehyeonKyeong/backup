package kr.co.sist.admin.evt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer extends Thread {
	private ServerSocket server;

	@Override
	public void run() {
		try {
			//서버소켓을 열고
			server=new ServerSocket(55000);
			System.out.println("파일업로드 서버 동작\n");
			Socket socket = null; //접속자가 보내온 소켓을 담음.
			
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

				fileName = dis.readUTF();// 클라이언트가 보내오는 "파일명" 받기
				System.out.println(fileName);
				file = new File("C:/Users/kimkn/git/backup/group_project2/src/kr/co/sist/img/" + fileName);
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
				
				System.out.println(file.exists());
				
				while (size > 0) {// 전송할 파일의 갯수가 (byte[]) 존재한다면
					len = fis.read(readData);
					dos.write(readData, 0, len);// 데이터와 파일의 크기까지를 기록
					dos.flush();
					size--;// 파일의 내용을 한번 보낼때 마다 크기를 줄인다.
				} // end while
				
				if (fis != null) {fis.close();}
				if (dos != null) {dos.close();}
				
			}//end while
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void uploadProcess(File file)throws IOException {
		//1.소켓 열고
		System.out.println("파일업로드 서버 동작\n");
		Socket socket = null; //접속자가 보내온 소켓을 담음.

		//2.업로드 할 파일의 정보 얻기
		int size=0; //보내는 byte배열의 총 갯수
		int len=0; //읽어들인 실제크기
		String fileName="";
		//HDD가 한번 읽어 들일때의 크기만큼 저장하기위한 배열
		byte[] readData=new byte[512]; 

		FileInputStream fis=null;
		DataOutputStream dos=null;

		DataInputStream dis=null;
		FileOutputStream fos=null;
		
		try {	
			
			socket = server.accept();
			fis=new FileInputStream(file); //선택한 파일을 스트림으로 연결
			

			dos=new DataOutputStream(socket.getOutputStream());

			//파일명을 보내고
			dos.writeUTF(file.getName());
			dos.flush();
			
			dis=new DataInputStream(socket.getInputStream());
			//서버에서 보내오는 파일크기(byte[512]의 갯수) 받는다.
			size=dis.readInt();
			readData=new byte[512];
			//3.서버의 HDD에 File로 쓴다
			//3-1. 파일 스트림 연결
			file=new File("C:/Users/kimkn/git/backup/lunch_prj/src/kr/co/sist/img/"+file.getName());
			fos=new FileOutputStream(file); //파일 명 생성

			while(size >0) {
				len=dis.read(readData);
				fos.write(readData, 0, len);
				fos.flush();
				size--;
			}//end while
			fos.close();

		}finally {

			if(dos !=null) {dos.close();} //end if
			if(dis !=null) {dis.close();} //end if
			if(socket !=null) {socket.close();} //end if
		}//end finally
	}//uploadProcess

	public static void main(String[] args) {
		new FileServer().start();
	}
}
