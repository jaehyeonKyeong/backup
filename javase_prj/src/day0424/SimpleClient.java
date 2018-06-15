package day0424;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

/**
 * 소켓을 생성하여 지정한 서버에 접속하는 일 (로컬 port는 몇번이 열리게 될지 모른다.)
 * @author owner
 */
public class SimpleClient {
	//130,132,133,134,135,137,139,140,141,142,144,145,146,147,148,149,150,151,152,153,154
	@SuppressWarnings({ "unused", "resource" })
	public SimpleClient() throws UnknownHostException, IOException {
		Socket socket=new Socket("211.63.89.133",35000);
		System.out.println("Client 생성 서버에 접속시도");
		//서버에서 보내오는 메세지를 받기위해 입력 스트림을 소켓에서부터 얻어내기.
		DataInputStream dis=new DataInputStream(socket.getInputStream());
		//입력 스트림에는 encoding된 한글이 들어온다
		String msg=dis.readUTF();//인코딩된 한글을 원래의 한글로 변환하여 문자열로 읽어 들인다
		
		//서버로 메세지 보내기
		String sendMsg=JOptionPane.showInputDialog("받은 메세지" +msg+"\n보낼 메시지 작성");
		DataOutputStream dos =new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(sendMsg);
		
		
	}//constructor
	public static void main(String[] args) {
		try {
			new SimpleClient();
		} catch (UnknownHostException e) {
			System.err.println("ip address상에 서버가 존재하지 않습니다");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("통신 중에 장애가 발생하였습니다.");
			e.printStackTrace();
		}
	}//main

}//SimpleClient
