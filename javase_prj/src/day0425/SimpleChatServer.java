package day0425;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings({ "serial", "unused" })
public class SimpleChatServer extends JFrame implements ActionListener, Runnable {
	private TextArea jtaDisplay;

	private JList<String> jlDisplay;
	private DefaultListModel<String> dlmTalk;
	private JTextField jtfTalk;
	private JButton btnOpenServer;

	private ServerSocket server;
	private Socket sockClient;
	private DataInputStream disStream;
	private DataOutputStream dosStream;
	
	private Thread serverThread;

	public SimpleChatServer() {
		super("채팅 서버");
		jtaDisplay = new TextArea();
		dlmTalk = new DefaultListModel<>();
		jlDisplay = new JList<>(dlmTalk);
		jtfTalk = new JTextField();
		btnOpenServer = new JButton("서버시작");

		JPanel panel = new JPanel();
		panel.add(btnOpenServer);

		JScrollPane jspCenter = new JScrollPane(jtaDisplay);
		jspCenter.setBorder(new TitledBorder("대화 내용"));
		jtfTalk.setBorder(new TitledBorder("대화 입력"));

		add("North", panel);
		add("Center", jspCenter);
		add("South", jtfTalk);

		setBounds(100, 100, 500, 700);
		setVisible(true);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent we) {
				// TODO Auto-generated method stub
				try {
					socketClose();
				} catch (IOException ie) {

				} finally {
					dispose();// windowclosed 호출
				}

			}// windowclosing

		});// 이름이 없는 클래스 어나니먼스 클래스

		jtfTalk.addActionListener(this);
		btnOpenServer.addActionListener(this);
		// try { 동작은 하지만 잘못만들어진 코드
		// openServer();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}// simple

	private void socketClose() throws IOException {
		if (disStream != null) {
			disStream.close();
		} // endif
		if (dosStream != null) {
			dosStream.close();
		} // endif
		if (sockClient != null) {
			sockClient.close();
		} // endif
		if (server != null) {
			server.close();
		} // endif
	}

	/**
	 * 대화 상태가 보내오는 메시지를 무한 loop로 읽어 들인다.
	 * 
	 * @throws IOException
	 */
	// private void readMsg() throws IOException {//대화상대가 몇번의 메세지를 보낼지 모르기때문에 보내오는 것
	// 만큼 읽어들인다.
	@Override
	public void run() {
		String msg = "";
		try {
			while (true) {// 무한 루프가 돌고있어서 메시지를 오기만 기다리고있음
				msg = disStream.readUTF();
				// 대화창에 읽어들인 메시지를 추가한다.
				jtaDisplay.append(msg + "\n");
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "대화상대가 나갔습니다");
			e.printStackTrace();
		}
	}

	/**
	 * TextField에서 이벤트 발생 입력된 대화내용을 스트림에 기록하고 스트림에 기록된 내용을 목적지(소켓)로 분출
	 * 
	 * @param msg
	 * @throws IOException
	 */
	private void sendMsg(String msg) throws IOException {
		// 내 대화 창에도 대화 내용을 올린다.
		jtaDisplay.append("[ㄴr는 5늘도 눈물을 흘린 ㄷr...☆]" + msg + "\n");
		// 대화 내용을 stream에쓴다
		dosStream.writeUTF("[ㄴr는 5늘도 눈물을 흘린 ㄷr...☆]" + msg);
		// 대화내용을 분출한다.
		dosStream.flush();
		// 다음 메시지를 입력하기 편하도록 textField를 초기화 한다.
		jtfTalk.setText("");
	}// sendMsg

	/**
	 * 서버 소켓을 생성하고(port 열림) 접속자 소켓 받는일
	 * 
	 * @throws IOException
	 */
	public void openServer() throws IOException {
		// 1. 서버 생성
		server = new ServerSocket(35000);// 0~65535
		jtaDisplay.append("서버가 실행되었습니다\n");

		jtaDisplay.append("접속자가 들어오면 채팅이 시작됩니다\n");
		// 3.접속하는 클라이언트 소켓을 받아준다.
		sockClient = server.accept();// blocking(접속이 될때 뒤에코드가 실행됨)
		disStream = new DataInputStream(sockClient.getInputStream());
		dosStream = new DataOutputStream(sockClient.getOutputStream());
		jtaDisplay.append("채팅상대가 들어왔습니다. 즐거운 채팅되세요\n");
//		readMsg();
		
		serverThread=new Thread(this);
		serverThread.start();//run()
		

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnOpenServer) {// 서버 열림에서 이벤트 발생
			try {
				if(serverThread==null) {
					openServer();
				}else {
					JOptionPane.showMessageDialog(this, "이미 실행중");
				}
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(this, "서버실행중 문제 발생");
				ie.printStackTrace();
			}

		} // end if
		if (ae.getSource() == jtfTalk) {// 대화 입력창에서 이벤트 발생
			String msg = jtfTalk.getText().trim();
			if (!msg.equals("")) {
				try {
					sendMsg(msg);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(this, "접속자가 존재하지 않습니다!");
					e.printStackTrace();
				} // end catch
			} // end if
		} // end if

	}// action

	public static void main(String[] args) {
		new SimpleChatServer();

	}// main

}// class
