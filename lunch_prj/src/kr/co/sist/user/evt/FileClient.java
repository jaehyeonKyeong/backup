package kr.co.sist.user.evt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileClient{
	Socket client;

	public void uploadProcess(File file)throws IOException {
		//1.소켓 열고
		client=new Socket("211.63.89.140", 20000);

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
			fis=new FileInputStream(file); //선택한 파일을 스트림으로 연결
			

			dos=new DataOutputStream(client.getOutputStream());

			//파일명을 보내고
			dos.writeUTF(file.getName());
			dos.flush();
			
			dis=new DataInputStream(client.getInputStream());
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
			if(client !=null) {client.close();} //end if
		}//end finally
	}//uploadProcess
	

}//class
