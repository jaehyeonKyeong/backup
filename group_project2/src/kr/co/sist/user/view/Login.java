package kr.co.sist.user.view;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import kr.co.sist.user.controller.LoginEvt;

@SuppressWarnings("serial")
public class Login extends JFrame  {
	private JButton btnLogin,btnSignUp;
	private JTextField tfId;
	private JPasswordField pfPassword;
	private JLabel lblId,lblPassword;
	private JRadioButton rbUser,rbManager;
	private ButtonGroup bgGroup;
	private JPanel pUser;
	
	public Login() {
		super("로그인");
		btnLogin=new JButton("로그인");
		btnSignUp=new JButton("회원 가입");
		tfId=new JTextField();
		lblPassword=new JLabel("Password");
		lblId=new JLabel("ID");
		pfPassword=new JPasswordField();
		
		 pUser=new JPanel();
		rbUser=new JRadioButton("사용자");
		rbManager=new JRadioButton("사업자");
		bgGroup=new ButtonGroup();
		bgGroup.add(rbUser);
		bgGroup.add(rbManager);
		pUser.add(rbUser);
		pUser.add(rbManager);
		setLayout(null);
		btnLogin.setBounds(40, 220, 120, 30);
		btnSignUp.setBounds(170, 220, 120, 30);
		lblId.setBounds(50, 40, 30, 30);
		lblPassword.setBounds(30, 98, 70, 30);
		tfId.setBounds(110, 40, 200, 30);
		pfPassword.setBounds(110, 100, 200, 30);
		pUser.setBounds(50, 150, 220, 40);
		
		LoginEvt le = new LoginEvt(this);
		btnSignUp.addActionListener(le);
		btnLogin.addActionListener(le);
		
		
		add(pUser);
		add(lblId);
		add(lblPassword);
		add(tfId);
		add(pfPassword);
		add(btnLogin);
		add(btnSignUp);
		setBounds(100,100,350,350);
		setVisible(true);
	}

	public JRadioButton getRbUser() {
		return rbUser;
	}

	public JRadioButton getRbManager() {
		return rbManager;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public JButton getBtnSignUp() {
		return btnSignUp;
	}
	
	public JTextField getTfId() {
		return tfId;
	}

	public JPasswordField getPfPassword() {
		return pfPassword;
	}

}
