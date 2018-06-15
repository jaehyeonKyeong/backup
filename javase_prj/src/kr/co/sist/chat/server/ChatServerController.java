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
 * view���� �߻��ϴ� �̺�Ʈ�� ó���ϰ�, Thread�� ����Ͽ�<br>
 * ������ ������ �޾� service��ü�� �Ѱ��ְ�,service��ü�� List�� �־ ����
 * 
 * @author owner
 */
public class ChatServerController extends WindowAdapter implements ActionListener, Runnable {
	private ChatServerView csv;
	private ServerSocket server;// ��Ʈ�� ���� ������ ������ �޾Ƶ���.
	private ServerSocket nickName;
	private Thread threadListen;// ���� ���ۿ� ���� ���� ó���ϴ� Thread
	static List<ChatServerService> connectList;

	public ChatServerController(ChatServerView csv) {
		this.csv = csv;
		connectList = new ArrayList<>(); // ����ȭ�� �Ǿ����� �ʱ� ������ multi Thread���� ������ �� ����.
	}// constructor

	@Override
	public void windowClosing(WindowEvent we) {
		serverClose();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == csv.getBtnStartServer()) {
			if (threadListen == null) {// ���� ���� �ʾ�����
				threadListen = new Thread(this);
				threadListen.start();
			} else {// ������
				JOptionPane.showMessageDialog(csv, "Server�� �̹� ������ �Դϴ�.", "���� ���� ��", JOptionPane.INFORMATION_MESSAGE);
			}

		} // getBtnStartServer
		if (ae.getSource() == csv.getBtnClose()) {
			switch (JOptionPane.showConfirmDialog(csv, "ä�ü����� ������ �����Ͻǰǰ���?")) {
			case JOptionPane.OK_OPTION:
				serverClose();
			}
		} // getBtnClose

	}// actionPerformed

	/**
	 * ���� ������ ���� �����ڼ����� �޴� �۾��� ���� loop�� ���� �ϰ� ������ ������ service��ü�� �߰��ϰ�, service��ü��
	 * list�� �߰�.
	 */
	@Override
	public void run() {

		try {
			server = new ServerSocket(65535);
			DefaultListModel<String> dlm = csv.getDlmList();
			dlm.addElement("���� ���� ����...");
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

					dlm.addElement(cnt + " ] �� ������ �� ä�ù濡 �����Ͽ����ϴ�!");
					dlm.addElement("������ IP Address [" + inet.getLocalHost() + "]");
					// ������ ���Ͽ� �޼����� �аų� ������ ���� ��ü ����.
					css = new ChatServerService(client, cnt, dlm);
					// ���� �̸��� ���� ���� �ϱ� ���� list�� �߰�
					connectList.add(css);
					// �޼����� �о� ���� �� �ֵ��� run() ȣ��
					css.start();
					css.broadcast(cnt + "��° ��ȭ���� ����");

				} // for
			} catch (SocketException se) {
				// ���α׷� ����� ���Ͽ� ���� ���ܰ� �߻��ϰ�, ���̻� ���α׷��� ������� ������ ���̱� ������ �������� JVM�� �����Ų��.
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
