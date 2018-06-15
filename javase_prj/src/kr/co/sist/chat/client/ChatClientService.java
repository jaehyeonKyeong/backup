package kr.co.sist.chat.client;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * ���Ͽ��� �б� stream�� ���� stream�� ���� ����loop�� ��ȭ�� �о���̰ų� ,��ȭ�� ������ ��, ��ȭ������ �������Ͽ�
 * ���Ϸ� ����.
 * 
 * @author owner
 */
public class ChatClientService extends Thread {

	private Socket someClient;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private ObjectInputStream ois;//
	private ChatClientView ccv;

	public ChatClientService(Socket someClient, ChatClientView ccv) throws IOException {
		this.someClient = someClient;

		this.ccv = ccv;
		readStream = new DataInputStream(someClient.getInputStream());
		writeStream = new DataOutputStream(someClient.getOutputStream());
		ois=new ObjectInputStream(someClient.getInputStream());//
	}

	public void clientClose() throws IOException {
		if (readStream != null) {
			readStream.close();
		}
		if (writeStream != null) {
			writeStream.close();
		}
		if (someClient != null) {
			someClient.close();
		}
		ccv.dispose();
	}

	@Override
	public void run() {
		if (readStream != null) {
			try {
				while (true) {
					ccv.getTaTalkDisplay().append(readStream.readUTF() + "\n");
				} // while
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(ccv, "��������");

			} // try
		} // if

	}// run

	public void sendMsg(String msg) throws IOException {
		if (writeStream != null) {
			String nick = ccv.getJtfNick().getText();
			writeStream.writeUTF("[ " + nick + " ] : " + msg);
			writeStream.flush();
		}
	}

	/**
	 * �Էµ� ��ȭ������ �����ϴ� ��
	 * 
	 * @param talkData
	 * @throws IOException
	 */
	public void capture(String talkData) throws IOException {
		// �ڹٰ� ����Ǵ� ��ġ�� ������ ����
		// ����Ǵ� ��ġ�� ����.
		String path = System.getProperties().getProperty("user.dir");
		File file = new File(path + "/" + System.currentTimeMillis() + ".dat");
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(talkData);
			bw.flush();

			JOptionPane.showMessageDialog(ccv, file + "�� ��ȭ������ �����Ͽ����ϴ�.");

		} finally {
			if (bw != null) {
				bw.close();
			}
		}
	}

}
