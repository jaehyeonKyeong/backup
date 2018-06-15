package kr.co.sist.chat.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import kr.co.sist.chat.client.ChatClientView;

/**
 * view에서 발생하는 이벤트를 처리하고, Thread를 사용하여<br>
 * 접속자 소켓을 받아 service객체에 넘겨주고,service객체를 List에 넣어서 관리
 * 
 * @author owner
 */
public class ChatServerController extends WindowAdapter implements ActionListener, Runnable {
	private ChatServerView csv;
	private ServerSocket server;// 포트를 열고 접속자 소켓을 받아들임.
	private ServerSocket nickName;
	private Thread threadListen;// 서버 동작에 대한 일을 처리하는 Thread
	static List<ChatServerService> connectList;

	public ChatServerController(ChatServerView csv) {
		this.csv = csv;
		connectList = new ArrayList<>(); // 동기화가 되어있지 않기 때문에 multi Thread에서 접근할 수 있음.
	}// constructor

	@Override
	public void windowClosing(WindowEvent we) {
		serverClose();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == csv.getBtnStartServer()) {
			if (threadListen == null) {// 동작 하지 않았을때
				threadListen = new Thread(this);
				threadListen.start();
			} else {// 동작중
				JOptionPane.showMessageDialog(csv, "Server가 이미 동작중 입니다.", "서버 동작 중", JOptionPane.INFORMATION_MESSAGE);
			}

		} // getBtnStartServer
		if (ae.getSource() == csv.getBtnClose()) {
			switch (JOptionPane.showConfirmDialog(csv, "채팅서버를 정말로 종료하실건가요?")) {
			case JOptionPane.OK_OPTION:
				serverClose();
			}
		} // getBtnClose

	}// actionPerformed

	/**
	 * 서버 소켓을 열고 접속자소켓을 받는 작업을 무한 loop로 실행 하고 접속자 소켓을 service객체에 추가하고, service객체를
	 * list에 추가.
	 */
	@Override
	public void run() {

		try {
			server = new ServerSocket(65535);
			DefaultListModel<String> dlm = csv.getDlmList();
			dlm.addElement("서버 가동 시작...");
			Socket client = null;
			ChatServerService css = null;

			try {
				InetAddress inet = null;
				// String Nick=null;
				for (int cnt = 0;; cnt++) {
					client = server.accept();
//					List<String> list = new ArrayList<String>();//
//					list.add();//
					inet = client.getInetAddress();

					dlm.addElement(cnt + " ] 님 접속자 가 채팅방에 접속하였습니다!");
					dlm.addElement("접속자 IP Address [" + inet.getLocalHost() + "]");
					// 접속자 소켓에 메세지를 읽거나 보내기 위한 객체 생성.
					css = new ChatServerService(client, cnt, dlm);
					// 같은 이름의 객를 관리 하기 위해 list에 추가
					connectList.add(css);
					// 메세지를 읽어 들일 수 있도록 run() 호출
					css.start();
					css.broadcast(cnt + "번째 대화상태 접속");

				} // for
			} catch (SocketException se) {
				// 프로그램 종료시 소켓에 대한 예외가 발생하고, 더이상 프로그램을 사용하지 않응ㄹ 것이기 때문에 실행중인 JVM을 종료시킨다.
				System.exit(0);

			}
		} catch (IOException e) {
			e.printStackTrace();
		} // try~catch

	}// run

	private void serverClose() {
		if (server != null) {
			try {
				server.close();
			} catch (IOException ie) {
				ie.printStackTrace();
			} // try~catch
		} // if
		csv.dispose();
	}// serverClose()

}
