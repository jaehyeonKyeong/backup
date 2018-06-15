package day0424;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 *Server : Port를 열고 접속자 소켓이 접속하기를 기다렸다가 접속된 소켓을 받는일
 * @author owner
 */
public class SimpleServer {
	@SuppressWarnings("resource")
	public SimpleServer() throws IOException {
		//1.ServerSocket 생성 : port가 열림(선점)
		ServerSocket server=new ServerSocket(65000);
		System.out.println("서버 가동 중");
		//3.접속자Socket이 있다면 접속자Socket을 받기
		Socket client;
		String msg="접속!!";
		DataOutputStream dos=null;
		DataInputStream dis=null;
		while(true) {
		client=server.accept();
		//4.서버에 존재하는 메시지를 접속자에게 보내기 위해 출력 스트림 얻기
		System.out.println("접속자 : "+client);
		dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();
		
		dis=new DataInputStream(client.getInputStream());
		JOptionPane.showMessageDialog(null, "상대방메세지"+client.getInetAddress()+" : "+dis.readUTF());
//		server.close();
		}
		
	}//constructor
	
	public static void main(String[] args) {
		try {
			new SimpleServer();
		} catch (IOException e) { 
			System.err.println("포트가 이미 사용 중 입니다.");
			e.printStackTrace();
		}
	}//main

}//simpleServer
