package kr.co.sist.admin.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import kr.co.sist.admin.dao.LoginDAO;
import kr.co.sist.admin.evt.FileServer;

public class TestLogin extends JFrame implements ActionListener {
	private JTextField tfId;
	private JPasswordField pfPass;
	private JButton btnLogin,btnClose;
	
	
	public TestLogin() {
		super("SQL Injection Test");
		
		tfId=new JTextField();
		pfPass=new JPasswordField();
		btnLogin=new JButton("로그인");
		btnClose=new JButton("닫기");
		
		tfId.setBorder(new TitledBorder("아이디"));
		pfPass.setBorder(new TitledBorder("비밀번호"));
		
		JPanel panel=new JPanel();
		panel.add(btnLogin);
		panel.add(btnClose);
		
		btnLogin.addActionListener(this);
		btnClose.addActionListener(this);
		pfPass.addActionListener(this);
		
		setLayout(new GridLayout(3, 1));
		add(tfId);
		add(pfPass);
		add(panel);
		
		setBounds(100,100,300,200);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//TestLogin
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==btnLogin || ae.getSource()==pfPass) {
			String id=tfId.getText().trim();		
			String pass=new String(pfPass.getPassword());
			if(login(id,pass)) {
				//로그인이 성공하면 관리자 화면을 보여준다.
				new LunchMainFrame();
				
				//파일을 서비스하기 위한 파일 서버 가동
				FileServer fs=new FileServer();
				fs.start();
				
				
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "아이디나 비밀번호를 확인해주세요.");
				
			}//end if
			
		}//end if
		
		if(ae.getSource()==btnClose) {
			dispose();
		}//end if
			
	}//actionPerformed

	private boolean login(String id,String pass){
		boolean flag=false;
		LoginDAO ld=LoginDAO.getInstance();
		try {
			flag=ld.selectLogin(id, pass);
		} catch (SQLException e){
			JOptionPane.showMessageDialog(this, "로그인 중 문제 발생");
			e.printStackTrace();
		}//end if
		return flag;
	}//login


}//class
