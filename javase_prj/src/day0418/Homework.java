package day0418;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import day0410.StudentVO;

@SuppressWarnings({ "serial", "unused" })
public class Homework extends JFrame implements ActionListener {
	Homework hw;
	JTextField jtfName, jtfAge, jtfPhoneNum1, jtfPhoneNum2, jtfPhoneNum3;
	JList<String> jlistData;
	JButton btnInput, btnDelete, btnEdit, btnClose;
	DefaultTableModel dtm;
	String[][] rowData;


	public Homework() {
		
		super("내친구");
		
		hw = this;
		
		jtfName = new JTextField();
		jtfAge = new JTextField();
		jtfPhoneNum1 = new JTextField();
		jtfPhoneNum2 = new JTextField();
		jtfPhoneNum3 = new JTextField();
		jlistData = new JList<>();
		
		btnClose = new JButton("닫기");
		btnDelete = new JButton("삭제");
		btnEdit = new JButton("수정");
		btnInput = new JButton("입력");
		
		JLabel jlblHypun = new JLabel("-");
		JLabel jlblHypun2 = new JLabel("-");
		JLabel jlblName = new JLabel("이름");
		JLabel jlblAge = new JLabel("나이");
		JLabel jlblPhone = new JLabel("전화번호");

		dtm = new DefaultTableModel();
		
		JScrollPane jsp = new JScrollPane(jlistData);

		jlblHypun.setFont(new Font("SansSerif", Font.PLAIN, 16));
		setLayout(null);
		jlblName.setBounds(15, 30, 60, 20);
		jlblAge.setBounds(15, 70, 60, 20);
		jlblPhone.setBounds(15, 110, 60, 20);
		jtfName.setBounds(80, 30, 140, 20);
		jtfAge.setBounds(80, 70, 140, 20);
		jtfPhoneNum1.setBounds(80, 110, 30, 20);
		jlblHypun.setBounds(115, 108, 10, 20);
		jtfPhoneNum2.setBounds(125, 110, 40, 20);
		jlblHypun2.setBounds(170, 108, 10, 20);
		jtfPhoneNum3.setBounds(180, 110, 40, 20);
		jsp.setBounds(240, 30, 215, 100);

		btnInput.setBounds(100, 160, 60, 30);
		btnDelete.setBounds(170, 160, 60, 30);
		btnEdit.setBounds(240, 160, 60, 30);
		btnClose.setBounds(310, 160, 60, 30);

		add(jlblName);
		add(jlblAge);
		add(jlblPhone);
		add(jtfName);
		add(jtfAge);
		add(jtfPhoneNum1);
		add(jlblHypun);
		add(jtfPhoneNum2);
		add(jlblHypun2);
		add(jtfPhoneNum3);
		add(jsp);

		add(btnInput);
		add(btnDelete);
		add(btnEdit);
		add(btnClose);
		
		//이벤트 등록
		
		jtfName.addActionListener(this);
		jtfAge.addActionListener(this);
		jtfPhoneNum1.addActionListener(this);
		jtfPhoneNum2.addActionListener(this);
		jtfPhoneNum3.addActionListener(this);

		setBounds(100, 100, 500, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		String name=jtfName.getText();
		String age=jtfAge.getText();
		String phoneNum1=jtfPhoneNum1.getText();
		String phoneNum2=jtfPhoneNum2.getText();
		String phoneNum3=jtfPhoneNum3.getText();
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Homework();
	}

}
