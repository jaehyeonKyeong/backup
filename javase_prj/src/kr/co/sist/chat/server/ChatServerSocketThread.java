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
 * ������ ������ �޾� ��ȭ�� ������<br>
 * �б� ���� ���Ͽ��� ���� Stream�� ��� ������ msg��<br>
 * ����loop�� �о���̰�, �о���� msg�� ��� ������ ���Ͽ� ����Ѵ�
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
				broadcast(nick); // �о���� �޽����� ��� �����ڿ��� ���
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
