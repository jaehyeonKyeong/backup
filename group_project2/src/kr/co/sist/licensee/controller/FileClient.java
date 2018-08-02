package kr.co.sist.licensee.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class FileClient {

	public void uploadProcess(File file)throws IOException {//이미지를 파일서버에 올리는 역할
		//1.소켓 열고
		Socket client=new Socket("211.63.89.140", 13880);

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
			

			dos=new DataOutputStream(client.getOutputStream()); //소켓에 연결된 outStream
			
			//서버에 클라이언트가 원하는 method를 보낸다.
			String ImageType="[rest_img_up]";
			dos.writeUTF(ImageType);
			dos.flush();

			dos.writeUTF(file.getName());//파일명 보내기
			dos.flush();
			
			fis=new FileInputStream(file);//선택한 파일 
			
			readData=new byte[512];
			
			while((len=fis.read(readData))>0) {
				size++; //읽어들인 배열의 갯수 //클라이언트가 보내오는 총 파일의 크기
			}//end while
			//보낼 파일의 배열 수(총 갯수)를 얻었다면 연결을 끊는다.
			//파일의 끝으로 이동한 포인터는 다시 파일의 처음으로 돌아가지 않는다.
			fis.close(); 

			fis=new FileInputStream(file); //보내기 위해 새로 연결한다.
			dos=new DataOutputStream(client.getOutputStream());
			//파일크기를 보내고
			dos.writeInt(size);

			while(size>0) { //전송할 파일의 갯수가(byte[] 바이트 배열의 세트) 존재한다면
				len=fis.read(readData); //읽어들인 파일의 크기만큼 크기를 얻어
				dos.write(readData,0,len); //데이터와 파일의 크기까지를 기록
				dos.flush(); //보내기
				size--; //파일의 내용을 한번 보낼 때 마다 크기를 줄인다.
			}//end while
			
		}finally {
			if(fis !=null) {fis.close();} //end if
			if(dos !=null) {dos.close();} //end if
		}
	}//uploadProcess
	public void downloadProcess()throws IOException{
		
	}
}// class
