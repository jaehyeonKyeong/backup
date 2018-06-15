package kr.co.sist.chat.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

/**
 * 클라이언트 화면에서 발생하는 이벤트를 처리하는 일<br>
 * 서버에 접속, 접속한 서버로 대화를 보내거나 읽기를 수행하는 Service class를 사용하는 일.
 * 
 * @author owner
 */
public class ChatClientController extends WindowAdapter implements ActionListener, Runnable {

	private ChatClientView ccv;
	private Thread connectThread;
	private ChatClientService ccs;

	public ChatClientController(ChatClientView ccv) {
		this.ccv = ccv;
	}// constructor

	@Override
	public void windowClosing(WindowEvent we) {
		try {
			if(ccs!=null) {ccs.clientClose();}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ccv.dispose();
	}// windowClosing

	@Override
	public void run() {
		String host = ccv.getJtfIp().getText().replaceAll(" ", "");
		String nick = ccv.getJtfNick().getText();
		try {
			Socket client = new Socket(host, 65535);
			Socket client2 = new Socket(host, 50000);
			// 접속자간 연결을 사용하는 socket과 view객체를 할당
			ccs = new ChatClientService(client, ccv);
			ccs.start();// =>run();
		} catch (UnknownHostException ue) {
			JOptionPane.showMessageDialog(ccv, "서버를 찾을 수 없습니다");
			ue.printStackTrace();
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(ccv, "연결중 문제 발생");
			ie.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 닉네임에서 엔터가 눌렸거나 접속버튼이 클릭 되었을때.
		if (e.getSource() == ccv.getJtfNick() || e.getSource() == ccv.getBtnConnectServer()) {
			if (connectThread == null) {// 접속이 되어있지 않음
				connectThread = new Thread(this);
				connectThread.start();
			} else {// 접속되어있는 상태
				JOptionPane.showMessageDialog(ccv, ccv.getJtfIp().getText() + " 서버로 이미 접속 중이에요");
			}
		}
		if (e.getSource() == ccv.getBtnCapture()) {
			if (ccs != null) {
				switch (JOptionPane.showConfirmDialog(ccv, "대화내용을 저장하실건가요?")) {
				case JOptionPane.OK_OPTION:
					String talkData = ccv.getTaTalkDisplay().getText();
					try {
						ccs.capture(talkData);
					} catch (IOException ie) {
						JOptionPane.showMessageDialog(ccv, "대화 내용을 저장 중에 문제가 발생하였습니다");
						ie.printStackTrace();
					}
				}
			}
		}
		if (e.getSource() == ccv.getJtfTalk()) {
			if (ccs != null) {
				String msg = ccv.getJtfTalk().getText();
				try {
					ccs.sendMsg(msg);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(ccv, "서버와의 연결 끊김");
					e1.printStackTrace();
				}
				ccv.getJtfTalk().setText("");
			}
		}
	}

}
