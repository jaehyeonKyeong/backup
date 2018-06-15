package kr.co.sist.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
public class ChatServerService extends Thread {
	private Socket someClient;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private int cnt;
	private DefaultListModel<String> dlm;

	public ChatServerService(Socket someClient, int cnt, DefaultListModel<String> dlm) throws IOException {

		this.someClient = someClient;
		this.cnt = cnt;
		this.dlm = dlm;
		// ������ ���Ͽ��� ��Ʈ�� ���
		readStream = new DataInputStream(someClient.getInputStream());
		writeStream = new DataOutputStream(someClient.getOutputStream());

	}// constructor

	@Override
	public void run() {
		// �����ڰ� �������� �޽����� ����loop �� �б�
		String msg = "";
		try {
			while (true) {
				msg = readStream.readUTF();
				broadcast(msg); // �о���� �޽����� ��� �����ڿ��� ���
			}
		} catch (IOException e) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy a HH:mm:ss");
				dlm.addElement(cnt + "��° �����ڰ� ������ �����Ͽ����ϴ�.");
				dlm.addElement("�������� : " + sdf.format(new Date()));
				// catch�� ���ܸ� ó������ ���Ͽ� catch���� ���ܴ� �ٽ� try~catch�� ���־���Ѵ�.
				broadcast(cnt + "��° �����ڰ� ������ ���� �߾��!");
				// Stream�� ����
				if (readStream != null) {
					readStream.close();
				}
				if (writeStream != null) {
					writeStream.close();
				}
				if (someClient != null) {
					someClient.close();
				}
				// list���� ���簴ü�� ����
				ChatServerController.connectList.remove(this);
			} catch (IOException ie) {
				ie.printStackTrace();
			} // try~catch
			e.printStackTrace();
		} // try~catch
	}

	/**
	 * multi Threadȯ�濡�� ���� ȣ���� ����(����ȭ) ���������� synchronized
	 * 
	 * @param msg
	 * @throws IOException
	 */
	public synchronized void broadcast(String msg) throws IOException {
		List<ChatServerService> list = ChatServerController.connectList;
		for (ChatServerService css : list) {
			css.writeStream.writeUTF(msg);
			css.writeStream.flush();
		}
	}

}// class
