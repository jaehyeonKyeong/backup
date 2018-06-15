package kr.co.sist.chat.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * 클라이언트 화면을 만들고 event를 등록
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class ChatClientView extends JFrame {
	private JTextField jtfIp, jtfNick, jtfTalk;
	private JButton btnConnectServer, btnCapture;
	private TextArea taTalkDisplay;

	public ChatClientView() {
		super("chat client");
		jtfIp = new JTextField("211.63.89.", 8);
		jtfNick = new JTextField(12);
		jtfTalk = new JTextField();
		btnConnectServer = new JButton("서버연결");
		btnCapture = new JButton("대화 내용 저장");
		taTalkDisplay = new TextArea();

		JPanel panelNorth = new JPanel();
		panelNorth.setBorder(new TitledBorder("접속정보"));

		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new BorderLayout());
		panelCenter.setBorder(new TitledBorder("대화"));

		panelNorth.add(new JLabel("서버주소", JLabel.CENTER));
		panelNorth.add(jtfIp);
		panelNorth.add(new JLabel("대화명", JLabel.CENTER));
		panelNorth.add(jtfNick);
		panelNorth.add(btnConnectServer);
		panelNorth.add(btnCapture);

		panelCenter.add("Center", taTalkDisplay);
		taTalkDisplay.setEditable(false);
		taTalkDisplay.setBackground(Color.WHITE);

		add("North", panelNorth);
		add("Center", panelCenter);
		add("South", jtfTalk);

		ChatClientController ccc = new ChatClientController(this);
		jtfNick.addActionListener(ccc);
		btnConnectServer.addActionListener(ccc);
		btnCapture.addActionListener(ccc);
		jtfTalk.addActionListener(ccc);
		addWindowListener(ccc);

		setBounds(100, 200, 650, 400);
		setVisible(true);

	}

	public JTextField getJtfIp() {
		return jtfIp;
	}

	public JTextField getJtfNick() {
		return jtfNick;
	}

	public JTextField getJtfTalk() {
		return jtfTalk;
	}

	public JButton getBtnConnectServer() {
		return btnConnectServer;
	}

	public JButton getBtnCapture() {
		return btnCapture;
	}

	public TextArea getTaTalkDisplay() {
		return taTalkDisplay;
	}

}
