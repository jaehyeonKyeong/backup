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
 * 소켓에서 읽기 stream과 쓰기 stream을 얻어내고 무한loop로 대화를 읽어들이거나 ,대화를 보내는 일, 대화내용을 갈무리하여
 * 파일로 저장.
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
				JOptionPane.showMessageDialog(ccv, "서버종료");

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
	 * 입력된 대화내용을 저장하는 일
	 * 
	 * @param talkData
	 * @throws IOException
	 */
	public void capture(String talkData) throws IOException {
		// 자바가 실행되는 위치에 파일을 생성
		// 실행되는 위치를 얻음.
		String path = System.getProperties().getProperty("user.dir");
		File file = new File(path + "/" + System.currentTimeMillis() + ".dat");
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(talkData);
			bw.flush();

			JOptionPane.showMessageDialog(ccv, file + "로 대화내용을 저장하였습니다.");

		} finally {
			if (bw != null) {
				bw.close();
			}
		}
	}

}
