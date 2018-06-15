package kr.co.sist.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;

/**
 * 접속자 소켓을 받아 대화를 보내고<br>
 * 읽기 위해 소켓에서 부터 Stream을 얻어 보내온 msg를<br>
 * 무한loop로 읽어들이고, 읽어들인 msg를 모든 접속자 소켓에 출력한다
 * 
 * @author owner
 */
public class ChatServerSocketThread extends Thread {
	private ServerSocket nickNameSocket;
	private DataInputStream dis;
	private DataOutputStream dos;


	@Override
	public void run() {
		try {
			String nick="";
			nickNameSocket = new ServerSocket(50000);
			Socket clientNick = nickNameSocket.accept();
			dis = new DataInputStream(clientNick.getInputStream());
			dos = new DataOutputStream(clientNick.getOutputStream());
			while (true) {
				nick = dis.readUTF();
				broadcast(nick); // 읽어들인 메시지를 모든 접속자에게 출력
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public synchronized void broadcast(String msg) throws IOException {
		List<ChatServerService> list = ChatServerController.connectList;
		for (ChatServerService css : list) {
			dos.writeUTF(msg);
			dos.flush();
		}
	}

}// class
