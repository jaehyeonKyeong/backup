package kr.co.sist.chat.server;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 * 서버 화면을 구현하고 event에 등록하는 일
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class ChatServerView extends JFrame {
	private JList<String> viewList;
	private DefaultListModel<String> dlmList;
	private JButton btnStartServer, btnClose;

	public ChatServerView() {
		super("::::::::::::::::채팅 관리자 s('_^)v::::::::::::::::::");
		dlmList = new DefaultListModel<>();
		viewList = new JList<>(dlmList);
		btnStartServer = new JButton("서버 가동");
		btnClose = new JButton("서버 닫기");

		JScrollPane jspList = new JScrollPane(viewList);
		jspList.setBorder(new TitledBorder("접속자 목록"));

		JPanel panel = new JPanel();
		panel.add(btnStartServer);
		panel.add(btnClose);
		
		ChatServerController csc=new ChatServerController(this);
		btnStartServer.addActionListener(csc);
		btnClose.addActionListener(csc);
		addWindowListener(csc);
		
		add("Center",jspList);
		add("South",panel);
		
		setBounds(10,20,400,600);
		setVisible(true);
	}//constructor

	public JList<String> getViewList() {
		return viewList;
	}

	public DefaultListModel<String> getDlmList() {
		return dlmList;
	}

	public JButton getBtnStartServer() {
		return btnStartServer;
	}

	public JButton getBtnClose() {
		return btnClose;
	}
	
}// class











