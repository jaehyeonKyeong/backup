package day0419;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class FriendsListView extends JFrame {
	
	private JButton btnAdd,btnDelete,btnAdjust,btnClose;
	private JTextField tfName, tfAge, tfPhone1, tfPhone2,tfPhone3;
	private JList<String> friendsList;
	
	private DefaultListModel<String> dlm;
	
	public FriendsListView() {
		super("내 친구");
		//패널생성
		JPanel panelCenter = new JPanel(new GridLayout(1, 2));
		JPanel panelSouth = new JPanel();
		JPanel panelNorth = new JPanel();
		JPanel panelWest = new JPanel();
		JPanel panelEast = new JPanel();
		JPanel panelLeft = new JPanel(null);
		JPanel panelRight = new JPanel(new BorderLayout());
		JPanel panelPhone = new JPanel();
		//버튼생성
		btnAdd = new JButton("입력");
		btnDelete = new JButton("삭제");
		btnAdjust = new JButton("수정");
		btnClose = new JButton("닫기");
		//텍스트필드 생성
		tfName = new JTextField();
		tfAge = new JTextField();
		tfPhone1 = new JTextField(3);
		tfPhone2 = new JTextField(4);
		tfPhone3 = new JTextField(4);
		
		//Model 생성
		dlm=new DefaultListModel<String>();
		
		//리스트생성
		friendsList = new JList<String>( dlm );
		//스크롤 생성 , 리스트대입
		JScrollPane jsp = new JScrollPane(friendsList);
		//라벨생성
		JLabel lblName = new JLabel("이름");
		JLabel lblAge = new JLabel("나이");
		JLabel lblPhone = new JLabel("전화번호");

		
		//센터페널에 좌측,우측패널 넣기
		panelCenter.add(panelLeft );
		panelCenter.add(panelRight);
		
		//우측패널
		panelRight.add(jsp);
		
		
		//좌측패널에 컴포넌트 추가
		panelLeft.add(lblName);
		panelLeft.add(tfName);
		panelLeft.add(lblAge);
		panelLeft.add(tfAge);
		panelLeft.add(lblPhone);
		panelLeft.add(panelPhone);
		panelPhone.add(tfPhone1);
		panelPhone.add(new JLabel("-"));
		panelPhone.add(tfPhone2);
		panelPhone.add(new JLabel("-"));
		panelPhone.add(tfPhone3);
		
		//좌측패널에 컴포넌트 배치
		lblName.setBounds(5,5,60,30);
		tfName.setBounds(65,5,175,30);
		
		lblAge.setBounds(5,35,60,30);
		tfAge.setBounds(65,35,175,30);
		
		lblPhone.setBounds(5,70,60,30);
		panelPhone.setBounds(65,70,175,30);
		
		
		//하단 패널 셋팅
		panelSouth.add(btnAdd);
		panelSouth.add(btnDelete);
		panelSouth.add(btnAdjust);
		panelSouth.add(btnClose);
		
		add("Center",panelCenter);
		add("South",panelSouth);
		add("North",panelNorth);
		add("West",panelWest);
		add("East",panelEast);

		
		//이벤트 등록
		FriendsListController fle = new FriendsListController(this);
		
		btnAdd.addActionListener(fle);
		btnDelete.addActionListener(fle);
		btnAdjust.addActionListener(fle);
		btnClose.addActionListener(fle);
		friendsList.addMouseListener(fle);
		
		
		setBounds(750,250,530,250);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public DefaultListModel<String> getDlm() {
		return dlm;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnAdjust() {
		return btnAdjust;
	}

	public JButton getBtnClose() {
		return btnClose;
	}

	public JTextField getTfName() {
		return tfName;
	}

	public JTextField getTfAge() {
		return tfAge;
	}

	public JTextField getTfPhone1() {
		return tfPhone1;
	}

	public JTextField getTfPhone2() {
		return tfPhone2;
	}

	public JTextField getTfPhone3() {
		return tfPhone3;
	}

	public JList<String> getFriendsList() {
		return friendsList;
	}
	
	public static void main(String[] args) {
		new FriendsListView();
	}
}
