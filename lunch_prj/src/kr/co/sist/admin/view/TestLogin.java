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
		btnLogin=new JButton("�α���");
		btnClose=new JButton("�ݱ�");
		
		tfId.setBorder(new TitledBorder("���̵�"));
		pfPass.setBorder(new TitledBorder("��й�ȣ"));
		
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
				//�α����� �����ϸ� ������ ȭ���� �����ش�.
				new LunchMainFrame();
				
				//������ �����ϱ� ���� ���� ���� ����
				FileServer fs=new FileServer();
				fs.start();
				
				
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "���̵� ��й�ȣ�� Ȯ�����ּ���.");
				
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
			JOptionPane.showMessageDialog(this, "�α��� �� ���� �߻�");
			e.printStackTrace();
		}//end if
		return flag;
	}//login


}//class
