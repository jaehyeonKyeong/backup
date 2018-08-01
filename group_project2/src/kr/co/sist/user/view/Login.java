package kr.co.sist.user.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import kr.co.sist.user.controller.LoginEvt;

@SuppressWarnings("serial")
public class Login extends JFrame {
	private JButton btnLogin, btnSignUp;
	private JTextField tfId;
	private JPasswordField pfPassword;
	private JLabel lblId, lblPassword, imgBox1, imgBox2;
	private JRadioButton rbUser, rbManager;
	private ButtonGroup bgGroup;
	private JPanel pUser, w_panel, g_panel;
	Color b_Color = new Color(0,100,121);

	public Login() {
		super();
		ImageIcon logoFile1 = new ImageIcon(
				"C:/dev/workspace/group_project2/src/kr/co/sist/user/images/logo1.JPG");
		ImageIcon logoFile2 = new ImageIcon(
				"C:/dev/workspace/group_project2/src/kr/co/sist/user/images/logo2.JPG");
		
		btnLogin = new JButton("·Î±×ÀÎ");
		btnSignUp = new JButton("È¸¿ø °¡ÀÔ");
		tfId = new JTextField();
		lblPassword = new JLabel("Password");
		lblId = new JLabel("ID");
		imgBox1 = new JLabel(logoFile1);
		imgBox2 = new JLabel(logoFile2);
		pfPassword = new JPasswordField();

		pUser = new JPanel();
		w_panel = new JPanel();
		g_panel = new JPanel();
		rbUser = new JRadioButton("»ç¿ëÀÚ");
		rbManager = new JRadioButton("»ç¾÷ÀÚ");
		bgGroup = new ButtonGroup();
		bgGroup.add(rbUser);
		bgGroup.add(rbManager);
		pUser.add(rbUser);
		pUser.add(rbManager);
		setLayout(null);
		w_panel.setBounds(0, 0, 350, 400);
		g_panel.setBounds(20,110,300,100);
		btnLogin.setBounds(40, 270, 120, 30);
		btnSignUp.setBounds(170, 270, 120, 30);
		lblId.setBounds(50, 105, 30, 60);
		lblPassword.setBounds(30, 155, 70, 60);
		tfId.setBounds(105, 120, 200, 30);
		pfPassword.setBounds(105, 165, 200, 30);
		pUser.setBounds(50, 220, 220, 40);
		imgBox1.setBounds(140, 40, 80, 60);
		imgBox2.setBounds(20,10,100,40);
		
		LoginEvt le = new LoginEvt(this);
		btnSignUp.addActionListener(le);
		btnLogin.addActionListener(le);

		add(imgBox1);
		add(imgBox2);
		add(pUser);
		add(lblId);
		add(lblPassword);
		add(tfId);
		add(pfPassword);
		add(btnLogin);
		add(btnSignUp);
		add(g_panel);
		add(w_panel);
		setBounds(100, 100, 350, 400);
		setVisible(true);
		setTitle(":::·Î±×ÀÎ:::");

		rbUser.setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,17));
		rbManager.setFont(new Font("¸¼Àº°íµñ", Font.PLAIN, 17));
		btnLogin.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 17));
		btnSignUp.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 17));


		pUser.setBackground(Color.white);
		rbUser.setBackground(Color.white);
		rbManager.setBackground(Color.white);
		w_panel.setBackground(Color.white);
		btnLogin.setBackground(b_Color);
		btnLogin.setBorderPainted(false);
		btnSignUp.setBackground(b_Color);
		btnSignUp.setBorderPainted(false);
		btnLogin.setForeground(Color.WHITE);
		btnSignUp.setForeground(Color.WHITE);
		
		//g_panel
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

	public static void main(String[] args) {
		new Login();
	}
}
