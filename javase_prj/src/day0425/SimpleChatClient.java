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
public class SimpleChatClient extends JFrame implements ActionListener,Runnable {
	private TextArea jtaDisplay;

	private JList<String> jlDisplay;
	private DefaultListModel<String> dlmTalk;
	private JTextField jtfTalk;
	private JButton btnconnectToServer;

	private Socket sockClient;
	private DataInputStream disStream;
	private DataOutputStream dosStream;
	
	private Thread clientThread;

	public SimpleChatClient() {
		super("ä�� ����");
		jtaDisplay = new TextArea();
		dlmTalk = new DefaultListModel<>();
		jlDisplay = new JList<>(dlmTalk);
		jtfTalk = new JTextField();
		btnconnectToServer = new JButton("���� ����");

		JPanel panel = new JPanel();
		panel.add(btnconnectToServer);

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
		btnconnectToServer.addActionListener(this);
//		try { //������ ������ �߸�§ �ڵ�
//			connectToServer("211.63.89.132");
//		} catch (IOException e) {
//			
//		}

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
	}

	/**
	 * ��ȭ ���°� �������� �޽����� ���� loop�� �о� ���δ�.
	 * 
	 * @throws IOException
	 */
//	private void readMsg() throws IOException {// ��ȭ��밡 ����� �޼����� ������ �𸣱⶧���� �������� �� ��ŭ �о���δ�.
	@Override
	public void run() {
		String msg = "";
		try {
		while (true) {// ���� ������ �����־ �޽����� ���⸸ ��ٸ�������
			msg = disStream.readUTF();
			// ��ȭâ�� �о���� �޽����� �߰��Ѵ�.
			jtaDisplay.append(msg + "\n");
		}
		}catch(IOException e) {
			JOptionPane.showMessageDialog(this, "�����ڰ� �������� �ʽ��ϴ�");
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
		///��ȭ������ �� ��ȭâ�� �ø���
		jtaDisplay.append("[��r�� 5�õ� ������ �기 ��r...]"+msg);
		// ��ȭ ������ stream������
		dosStream.writeUTF("[��r�� 5�õ� ������ �기 ��r...]" + msg);
		// ��ȭ������ �����Ѵ�.
		dosStream.flush();
		jtfTalk.setText("");
	}// sendMsg

	/**
	 * ���� ������ �����Ͽ� ������ ����(local port ����)
	 * 
	 * @throws IOException
	 */
	public void connectToServer(String ip) throws IOException {
		// 2.���� ����
		// ip�� ���� ��ǻ�Ϳ� port�� ���� �õ�
//		sockClient = new Socket(ip, 35000);// 0~65535
		sockClient = new Socket(ip, 65535);// 0~65535
		jtaDisplay.append("������ ����Ǿ����ϴ�.\n");
		// 3.��ȭ������ �о���̰ų� �������� ��Ʈ������.
		disStream = new DataInputStream(sockClient.getInputStream());
		dosStream = new DataOutputStream(sockClient.getOutputStream());
		jtaDisplay.append("��ſ� ä�� �Ǽ���.\n");
//		readMsg();
		clientThread=new Thread(this);
		clientThread.start();
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnconnectToServer) {// ���� �������� �̺�Ʈ �߻�
			try {
				if(clientThread==null) {
					
				String ip=JOptionPane.showInputDialog(this, "����ip addr�� ������ ������ �Է����ּ���");
				connectToServer("211.63.89."+ip);
				}else {
					JOptionPane.showMessageDialog(this, "�̹� ������ �������Դϴ�.");
				}
			} catch (IOException ie) {
				//130,132,133,134,135,137,139,140,141,142,144,145,146,147,148,149,150,151,152,153,154
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
		new SimpleChatClient();

	}// main

}// class
