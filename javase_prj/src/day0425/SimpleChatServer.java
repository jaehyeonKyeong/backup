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
		super("ä�� ����");
		jtaDisplay = new TextArea();
		dlmTalk = new DefaultListModel<>();
		jlDisplay = new JList<>(dlmTalk);
		jtfTalk = new JTextField();
		btnOpenServer = new JButton("��������");

		JPanel panel = new JPanel();
		panel.add(btnOpenServer);

		JScrollPane jspCenter = new JScrollPane(jtaDisplay);
		jspCenter.setBorder(new TitledBorder("��ȭ ����"));
		jtfTalk.setBorder(new TitledBorder("��ȭ �Է�"));

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
					dispose();// windowclosed ȣ��
				}

			}// windowclosing

		});// �̸��� ���� Ŭ���� ��ϸս� Ŭ����

		jtfTalk.addActionListener(this);
		btnOpenServer.addActionListener(this);
		// try { ������ ������ �߸�������� �ڵ�
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
	 * ��ȭ ���°� �������� �޽����� ���� loop�� �о� ���δ�.
	 * 
	 * @throws IOException
	 */
	// private void readMsg() throws IOException {//��ȭ��밡 ����� �޼����� ������ �𸣱⶧���� �������� ��
	// ��ŭ �о���δ�.
	@Override
	public void run() {
		String msg = "";
		try {
			while (true) {// ���� ������ �����־ �޽����� ���⸸ ��ٸ�������
				msg = disStream.readUTF();
				// ��ȭâ�� �о���� �޽����� �߰��Ѵ�.
				jtaDisplay.append(msg + "\n");
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "��ȭ��밡 �������ϴ�");
			e.printStackTrace();
		}
	}

	/**
	 * TextField���� �̺�Ʈ �߻� �Էµ� ��ȭ������ ��Ʈ���� ����ϰ� ��Ʈ���� ��ϵ� ������ ������(����)�� ����
	 * 
	 * @param msg
	 * @throws IOException
	 */
	private void sendMsg(String msg) throws IOException {
		// �� ��ȭ â���� ��ȭ ������ �ø���.
		jtaDisplay.append("[��r�� 5�õ� ������ �기 ��r...��]" + msg + "\n");
		// ��ȭ ������ stream������
		dosStream.writeUTF("[��r�� 5�õ� ������ �기 ��r...��]" + msg);
		// ��ȭ������ �����Ѵ�.
		dosStream.flush();
		// ���� �޽����� �Է��ϱ� ���ϵ��� textField�� �ʱ�ȭ �Ѵ�.
		jtfTalk.setText("");
	}// sendMsg

	/**
	 * ���� ������ �����ϰ�(port ����) ������ ���� �޴���
	 * 
	 * @throws IOException
	 */
	public void openServer() throws IOException {
		// 1. ���� ����
		server = new ServerSocket(35000);// 0~65535
		jtaDisplay.append("������ ����Ǿ����ϴ�\n");

		jtaDisplay.append("�����ڰ� ������ ä���� ���۵˴ϴ�\n");
		// 3.�����ϴ� Ŭ���̾�Ʈ ������ �޾��ش�.
		sockClient = server.accept();// blocking(������ �ɶ� �ڿ��ڵ尡 �����)
		disStream = new DataInputStream(sockClient.getInputStream());
		dosStream = new DataOutputStream(sockClient.getOutputStream());
		jtaDisplay.append("ä�û�밡 ���Խ��ϴ�. ��ſ� ä�õǼ���\n");
//		readMsg();
		
		serverThread=new Thread(this);
		serverThread.start();//run()
		

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnOpenServer) {// ���� �������� �̺�Ʈ �߻�
			try {
				if(serverThread==null) {
					openServer();
				}else {
					JOptionPane.showMessageDialog(this, "�̹� ������");
				}
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(this, "���������� ���� �߻�");
				ie.printStackTrace();
			}

		} // end if
		if (ae.getSource() == jtfTalk) {// ��ȭ �Է�â���� �̺�Ʈ �߻�
			String msg = jtfTalk.getText().trim();
			if (!msg.equals("")) {
				try {
					sendMsg(msg);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(this, "�����ڰ� �������� �ʽ��ϴ�!");
					e.printStackTrace();
				} // end catch
			} // end if
		} // end if

	}// action

	public static void main(String[] args) {
		new SimpleChatServer();

	}// main

}// class
