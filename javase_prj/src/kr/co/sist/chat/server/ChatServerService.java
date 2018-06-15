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
 * 접속자 소켓을 받아 대화를 보내고<br>
 * 읽기 위해 소켓에서 부터 Stream을 얻어 보내온 msg를<br>
 * 무한loop로 읽어들이고, 읽어들인 msg를 모든 접속자 소켓에 출력한다
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
		// 접속자 소켓에서 스트림 얻기
		readStream = new DataInputStream(someClient.getInputStream());
		writeStream = new DataOutputStream(someClient.getOutputStream());

	}// constructor

	@Override
	public void run() {
		// 접속자가 보내오는 메시지를 무한loop 로 읽기
		String msg = "";
		try {
			while (true) {
				msg = readStream.readUTF();
				broadcast(msg); // 읽어들인 메시지를 모든 접속자에게 출력
			}
		} catch (IOException e) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy a HH:mm:ss");
				dlm.addElement(cnt + "번째 접속자가 접속을 종료하였습니다.");
				dlm.addElement("종료정보 : " + sdf.format(new Date()));
				// catch는 예외를 처리하지 못하여 catch안의 예외는 다시 try~catch를 해주어야한다.
				broadcast(cnt + "번째 접속자가 접속을 종료 했어요!");
				// Stream을 끊기
				if (readStream != null) {
					readStream.close();
				}
				if (writeStream != null) {
					writeStream.close();
				}
				if (someClient != null) {
					someClient.close();
				}
				// list에서 현재객체를 제거
				ChatServerController.connectList.remove(this);
			} catch (IOException ie) {
				ie.printStackTrace();
			} // try~catch
			e.printStackTrace();
		} // try~catch
	}

	/**
	 * multi Thread환경에서 동시 호출을 막기(동기화) 접근지정자 synchronized
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
