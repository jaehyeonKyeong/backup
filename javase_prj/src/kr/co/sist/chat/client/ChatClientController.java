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
 * Ŭ���̾�Ʈ ȭ�鿡�� �߻��ϴ� �̺�Ʈ�� ó���ϴ� ��<br>
 * ������ ����, ������ ������ ��ȭ�� �����ų� �б⸦ �����ϴ� Service class�� ����ϴ� ��.
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
			// �����ڰ� ������ ����ϴ� socket�� view��ü�� �Ҵ�
			ccs = new ChatClientService(client, ccv);
			ccs.start();// =>run();
		} catch (UnknownHostException ue) {
			JOptionPane.showMessageDialog(ccv, "������ ã�� �� �����ϴ�");
			ue.printStackTrace();
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(ccv, "������ ���� �߻�");
			ie.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// �г��ӿ��� ���Ͱ� ���Ȱų� ���ӹ�ư�� Ŭ�� �Ǿ�����.
		if (e.getSource() == ccv.getJtfNick() || e.getSource() == ccv.getBtnConnectServer()) {
			if (connectThread == null) {// ������ �Ǿ����� ����
				connectThread = new Thread(this);
				connectThread.start();
			} else {// ���ӵǾ��ִ� ����
				JOptionPane.showMessageDialog(ccv, ccv.getJtfIp().getText() + " ������ �̹� ���� ���̿���");
			}
		}
		if (e.getSource() == ccv.getBtnCapture()) {
			if (ccs != null) {
				switch (JOptionPane.showConfirmDialog(ccv, "��ȭ������ �����Ͻǰǰ���?")) {
				case JOptionPane.OK_OPTION:
					String talkData = ccv.getTaTalkDisplay().getText();
					try {
						ccs.capture(talkData);
					} catch (IOException ie) {
						JOptionPane.showMessageDialog(ccv, "��ȭ ������ ���� �߿� ������ �߻��Ͽ����ϴ�");
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
					JOptionPane.showMessageDialog(ccv, "�������� ���� ����");
					e1.printStackTrace();
				}
				ccv.getJtfTalk().setText("");
			}
		}
	}

}
