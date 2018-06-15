package kr.co.sist.chat.server;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 * ���� ȭ���� �����ϰ� event�� ����ϴ� ��
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class ChatServerView extends JFrame {
	private JList<String> viewList;
	private DefaultListModel<String> dlmList;
	private JButton btnStartServer, btnClose;

	public ChatServerView() {
		super("::::::::::::::::ä�� ������ s('_^)v::::::::::::::::::");
		dlmList = new DefaultListModel<>();
		viewList = new JList<>(dlmList);
		btnStartServer = new JButton("���� ����");
		btnClose = new JButton("���� �ݱ�");

		JScrollPane jspList = new JScrollPane(viewList);
		jspList.setBorder(new TitledBorder("������ ���"));

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











