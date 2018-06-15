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

	private Button btnAdd, btnBlockFriends, btnAllAdd;// 친구 추가,친구 차단,차단된 친구 복원

	public FriendsWindow() {
		super("친구관리");
		listFriends = new ArrayList<String>();// 친구를 저장할 리스트 생성
		listViewFriends = new List();
		listViewBlockFriends = new List();
		// 생성된 리스트에 친구 목록 추가
		setFriends();
		btnAdd = new Button("친구등록");
		btnBlockFriends = new Button(">>");
		btnAllAdd = new Button("<<");

		Label lblFriends = new Label("친구 목록");
		Label lblBlockFriends = new Label("차단 목록");

		Font font = new Font("SansSerif", Font.BOLD, 14);
		// 글꼴설정
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

		// 이벤트 등록
		btnAdd.addActionListener(this);
		btnBlockFriends.addActionListener(this);
		btnAllAdd.addActionListener(this);

		// listViewFriends.addItemListener(this);
		// listViewBlockFriends.addItemListener(this);
		FriendsWindow.MouseEvt me = this.new MouseEvt();
		listViewFriends.addMouseListener(me);// mouseClicked호출
		listViewBlockFriends.addMouseListener(me);

		// 창크기 변경 막기
		setResizable(false);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}

		});

	}// constructor

	/**
	 * java.util,list에 존재하는 값으로 java.awt.List를 재설정
	 */
	public void setFriends() {
		// 데이터를 보여주기전에 java.awt.List를 초기화한다
		listViewFriends.removeAll();
		// 데이터를 채워준다
		for (String name : listFriends) {
			listViewFriends.add(name);
		}

	}

	/**
	 * 현재 생성되어있는 java.util.list 객체를 반환함.
	 * 
	 * @return
	 */
	public java.util.List<String> getListFriends() {

		return listFriends;
	}// getListFriends
		///////////////// mouseEvent를 처리하는 inner class/////////////////

	public class MouseEvt extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent me) {
			if (me.getClickCount() == 2) {
				if (me.getSource() == listViewFriends) {// 친구 목록에서 이벤트 발생 //친구 리스트에서선택된 이름을 가져와서
					String name = listViewFriends.getSelectedItem(); // 차단 리스트로 이동하고
					listViewBlockFriends.add(name); // 친구목록에서 삭제 
					 listViewFriends.remove(name);
					setFriendsUpdate();
				}
				if (me.getSource() == listViewBlockFriends) {// 친구 차단 목록에서 이벤트 발생
					// 차단 목록에서 이름을 가져와서
					String name = listViewBlockFriends.getSelectedItem();
					// 친구목록으로 보내고
					listViewFriends.add(name); // 차단목록에서 삭제한후
					listViewBlockFriends.remove(name); // 복구된 친구 목록으로 data를 저장한 list
					setFriendsUpdate();
				}
			}
		}

	}

	////////////////// mouseEvent를 처리하는 inner class 끝 /////////////////
//	@Override
//	public void itemStateChanged(ItemEvent ie) {
//		if (ie.getSource() == listViewFriends) {// 친구 목록에서 이벤트 발생 //친구 리스트에서선택된 이름을 가져와서
//			String name = listViewFriends.getSelectedItem(); // 차단 리스트로 이동하고
//			listViewBlockFriends.add(name); // 친구목록에서 삭제 listViewFriends.remove(name);
//			setFriendsUpdate();
//		}
//		if (ie.getSource() == listViewBlockFriends) {// 친구 차단 목록에서 이벤트 발생
//			// 차단 목록에서 이름을 가져와서
//			String name = listViewBlockFriends.getSelectedItem();
//			// 친구목록으로 보내고
//			listViewFriends.add(name); // 차단목록에서 삭제한후
//			listViewBlockFriends.remove(name); // 복구된 친구 목록으로 data를 저장한 list
//			setFriendsUpdate();
//		}
//	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnAdd) {// 친구 추가 버튼
			new FriendsDialog(this);
		}
		if (ae.getSource() == btnBlockFriends) {// 모두차단>>
			//친구 리스트의 모든 내용을 가져와서
			String[] list=listViewFriends.getItems();
			//차단리스트에 모두 추가하고
			for(String name : list) {				
				listViewBlockFriends.add(name);
			}
			//친구리스트를 초기화하고
			listViewFriends.removeAll();
			//데이터 리스트를 갱신한다
			setFriendsUpdate();
		}
		if (ae.getSource() == btnAllAdd) {// 모두복구<<
			//차단 리스트의 모든 아이템을 가져와서
			String[] list=listViewBlockFriends.getItems();
			//친구리스트에모두 추가하고
			for(String name : list) {				
				listViewFriends.add(name);
			}
			//차단 리스트를 초기화하고
			listViewBlockFriends.removeAll();
			//데이터리스트를 갱신한다.
			setFriendsUpdate();
		}
	}

	private void setFriendsUpdate() {
		listFriends.clear();// list를 초기화하고
		// 뷰 리스트의 아이템들을 배열로 얻는다
		String[] updateFriends = listViewFriends.getItems();
		// 배열로 java.util.List를 설정한다
		for (String updateName : updateFriends) {
			listFriends.add(updateName);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

}
