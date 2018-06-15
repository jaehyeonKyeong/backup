package day0427;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ObjectServer {

	public ObjectServer() throws IOException {
		//1.보내줄 객체 생성
//		GroupMemberDTO gmd=new GroupMemberDTO("경제현",25);
		List<String> list=new ArrayList<String>();
		list.add("안");
		list.add("녕");
		list.add("하");
		list.add("세");
		list.add("세");
		list.add("세");
		list.add("세");
		list.add("세");
		
		GroupMemberDTO1 gmd1=new GroupMemberDTO1(list);
		
		
		//2.server socket생성 : port열림
		ServerSocket ss=new ServerSocket(65311);
		System.out.println("서버 작동 중이에요...");
		Socket client=null;
		while(true) {
			
			//3.접속자 소켓 받기
			client=ss.accept();
			//4.객체를 내보내기 위해 Stream을 연결
			ObjectOutputStream oos=new ObjectOutputStream(client.getOutputStream());
			//5.Stream에 객체 쓰기
//			oos.writeObject(gmd);
			oos.writeObject(gmd1);
			//6.분출
			oos.flush();
			System.out.println(client.getInetAddress().getHostAddress()+"에게"+gmd1.getList().get(0)+"을 보냈어요!");
		}
	}

	
	public static void main(String[] args) {
		try {
			new ObjectServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//main

}//class
