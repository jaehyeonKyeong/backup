package kr.co.sist.user.view;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import kr.co.sist.user.controller.SignUpEvt;

public class SignUp extends JFrame {
	private JTextField tfID,tfName, tfPassword, tfRePassword;
	private JRadioButton rbUser ,rbBuisnessman;
	private ButtonGroup bgGroup;
	private JLabel lblID,lblName, lblPassword, lblRePassword;
	private JButton btnSignUp, btnCancle;
	private JPanel pUser;



	public SignUp() {
		tfID=new JTextField();
		tfName=new JTextField();
		tfPassword=new JTextField();
		tfRePassword=new JTextField();
		
		pUser=new JPanel();
		rbUser=new JRadioButton("사용자");
		rbBuisnessman=new JRadioButton("사업자");
		bgGroup=new ButtonGroup();//버튼의 중복 허용을 막기위하여
		
		lblID=new JLabel("ID");
		lblName=new JLabel("Name");
		lblPassword=new JLabel("Password");
		lblRePassword=new JLabel("Confirm Password");
		
		btnSignUp=new JButton("회원가입");
		btnCancle=new JButton("취소");
		
		bgGroup.add(rbUser);
		bgGroup.add(rbBuisnessman);
		pUser.add(rbUser);
		pUser.add(rbBuisnessman);
		setLayout(null);
		lblID.setBounds(28, 40, 30, 30);
		lblPassword.setBounds(25, 75, 70, 30);
		tfID.setBounds(145, 40, 200, 30);
		tfPassword.setBounds(145, 75, 200, 30);
		lblRePassword.setBounds(25,110,110,30);
		tfRePassword.setBounds(145, 110, 200, 30);
		lblName.setBounds(25, 145, 70, 30);
		tfName.setBounds(145, 145, 200, 30);
		pUser.setBounds(110, 190, 150, 30);
		btnSignUp.setBounds(80, 240, 90, 22);
		btnCancle.setBounds(190, 240, 90, 22);
		
		SignUpEvt su= new SignUpEvt(this);
		rbBuisnessman.addActionListener(su);
		rbUser.addActionListener(su);
		tfID.addActionListener(su);
		tfPassword.addActionListener(su);
		tfRePassword.addActionListener(su);
		tfName.addActionListener(su);
		btnSignUp.addActionListener(su);
		btnCancle.addActionListener(su);
	
		
		
		
		add(tfID);
		add(tfName);
		add(tfPassword);
		add(tfRePassword);
		add(pUser);
		add(lblID);
		add(lblName);
		add(lblPassword);
		add(lblRePassword);
		add(btnSignUp);
		add(btnCancle);
		
		setBounds(100,100,390,350);
		setVisible(true);
		
	}//SignUp
	
	public JRadioButton getRbUser() {
		return rbUser;
	}

	public JRadioButton getRbBuisnessman() {
		return rbBuisnessman;
	}

	public JTextField getTfID() {
		return tfID;
	}

	public JTextField getTfName() {
		return tfName;
	}

	public JTextField getTfPassword() {
		return tfPassword;
	}

	public JTextField getTfRePassword() {
		return tfRePassword;
	}
	public JButton getBtnSignUp() {
		return btnSignUp;
	}

	public JButton getBtnCancle() {
		return btnCancle;
	}

}
