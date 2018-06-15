package day0413;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class FriendsWindow extends Frame implements ActionListener, ItemListener {
	private java.util.List<String> listFriends;
	private List listViewFriends, listViewBlockFriends;

	private Button btnAdd, btnBlockFriends, btnAllAdd;// ģ�� �߰�,ģ�� ����,���ܵ� ģ�� ����

	public FriendsWindow() {
		super("ģ������");
		listFriends = new ArrayList<String>();// ģ���� ������ ����Ʈ ����
		listViewFriends = new List();
		listViewBlockFriends = new List();
		// ������ ����Ʈ�� ģ�� ��� �߰�
		setFriends();
		btnAdd = new Button("ģ�����");
		btnBlockFriends = new Button(">>");
		btnAllAdd = new Button("<<");

		Label lblFriends = new Label("ģ�� ���");
		Label lblBlockFriends = new Label("���� ���");

		Font font = new Font("SansSerif", Font.BOLD, 14);
		// �۲ü���
		lblFriends.setFont(font);
		lblBlockFriends.setFont(font);
		btnAdd.setFont(font);
		btnBlockFriends.setFont(font);
		btnAllAdd.setFont(font);
		listViewFriends.setFont(font);
		listViewBlockFriends.setFont(font);

		setLayout(null);
		lblFriends.setBounds(15, 40, 80, 30);
		listViewFriends.setBounds(15, 70, 180, 450);
		lblBlockFriends.setBounds(300, 40, 80, 30);
		listViewBlockFriends.setBounds(300, 70, 180, 450);
		btnAdd.setBounds(15, 530, 80, 30);
		btnBlockFriends.setBounds(220, 250, 60, 40);
		btnAllAdd.setBounds(220, 300, 60, 40);

		add(lblFriends);
		add(listViewFriends);
		add(lblBlockFriends);
		add(listViewBlockFriends);
		add(btnAdd);
		add(btnBlockFriends);
		add(btnAllAdd);

		setBounds(100, 100, 500, 580);
		setVisible(true);

		// �̺�Ʈ ���
		btnAdd.addActionListener(this);
		btnBlockFriends.addActionListener(this);
		btnAllAdd.addActionListener(this);

		// listViewFriends.addItemListener(this);
		// listViewBlockFriends.addItemListener(this);
		FriendsWindow.MouseEvt me = this.new MouseEvt();
		listViewFriends.addMouseListener(me);// mouseClickedȣ��
		listViewBlockFriends.addMouseListener(me);

		// âũ�� ���� ����
		setResizable(false);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}

		});

	}// constructor

	/**
	 * java.util,list�� �����ϴ� ������ java.awt.List�� �缳��
	 */
	public void setFriends() {
		// �����͸� �����ֱ����� java.awt.List�� �ʱ�ȭ�Ѵ�
		listViewFriends.removeAll();
		// �����͸� ä���ش�
		for (String name : listFriends) {
			listViewFriends.add(name);
		}

	}

	/**
	 * ���� �����Ǿ��ִ� java.util.list ��ü�� ��ȯ��.
	 * 
	 * @return
	 */
	public java.util.List<String> getListFriends() {

		return listFriends;
	}// getListFriends
		///////////////// mouseEvent�� ó���ϴ� inner class/////////////////

	public class MouseEvt extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent me) {
			if (me.getClickCount() == 2) {
				if (me.getSource() == listViewFriends) {// ģ�� ��Ͽ��� �̺�Ʈ �߻� //ģ�� ����Ʈ�������õ� �̸��� �����ͼ�
					String name = listViewFriends.getSelectedItem(); // ���� ����Ʈ�� �̵��ϰ�
					listViewBlockFriends.add(name); // ģ����Ͽ��� ���� 
					 listViewFriends.remove(name);
					setFriendsUpdate();
				}
				if (me.getSource() == listViewBlockFriends) {// ģ�� ���� ��Ͽ��� �̺�Ʈ �߻�
					// ���� ��Ͽ��� �̸��� �����ͼ�
					String name = listViewBlockFriends.getSelectedItem();
					// ģ��������� ������
					listViewFriends.add(name); // ���ܸ�Ͽ��� ��������
					listViewBlockFriends.remove(name); // ������ ģ�� ������� data�� ������ list
					setFriendsUpdate();
				}
			}
		}

	}

	////////////////// mouseEvent�� ó���ϴ� inner class �� /////////////////
//	@Override
//	public void itemStateChanged(ItemEvent ie) {
//		if (ie.getSource() == listViewFriends) {// ģ�� ��Ͽ��� �̺�Ʈ �߻� //ģ�� ����Ʈ�������õ� �̸��� �����ͼ�
//			String name = listViewFriends.getSelectedItem(); // ���� ����Ʈ�� �̵��ϰ�
//			listViewBlockFriends.add(name); // ģ����Ͽ��� ���� listViewFriends.remove(name);
//			setFriendsUpdate();
//		}
//		if (ie.getSource() == listViewBlockFriends) {// ģ�� ���� ��Ͽ��� �̺�Ʈ �߻�
//			// ���� ��Ͽ��� �̸��� �����ͼ�
//			String name = listViewBlockFriends.getSelectedItem();
//			// ģ��������� ������
//			listViewFriends.add(name); // ���ܸ�Ͽ��� ��������
//			listViewBlockFriends.remove(name); // ������ ģ�� ������� data�� ������ list
//			setFriendsUpdate();
//		}
//	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnAdd) {// ģ�� �߰� ��ư
			new FriendsDialog(this);
		}
		if (ae.getSource() == btnBlockFriends) {// �������>>
			//ģ�� ����Ʈ�� ��� ������ �����ͼ�
			String[] list=listViewFriends.getItems();
			//���ܸ���Ʈ�� ��� �߰��ϰ�
			for(String name : list) {				
				listViewBlockFriends.add(name);
			}
			//ģ������Ʈ�� �ʱ�ȭ�ϰ�
			listViewFriends.removeAll();
			//������ ����Ʈ�� �����Ѵ�
			setFriendsUpdate();
		}
		if (ae.getSource() == btnAllAdd) {// ��κ���<<
			//���� ����Ʈ�� ��� �������� �����ͼ�
			String[] list=listViewBlockFriends.getItems();
			//ģ������Ʈ����� �߰��ϰ�
			for(String name : list) {				
				listViewFriends.add(name);
			}
			//���� ����Ʈ�� �ʱ�ȭ�ϰ�
			listViewBlockFriends.removeAll();
			//�����͸���Ʈ�� �����Ѵ�.
			setFriendsUpdate();
		}
	}

	private void setFriendsUpdate() {
		listFriends.clear();// list�� �ʱ�ȭ�ϰ�
		// �� ����Ʈ�� �����۵��� �迭�� ��´�
		String[] updateFriends = listViewFriends.getItems();
		// �迭�� java.util.List�� �����Ѵ�
		for (String updateName : updateFriends) {
			listFriends.add(updateName);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

}
