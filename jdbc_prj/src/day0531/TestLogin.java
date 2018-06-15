package day0531;

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

import day0530.TableInfo;

@SuppressWarnings("serial")
public class TestLogin extends JFrame implements ActionListener {
	private JTextField tfId;
	private JPasswordField pfPass;
	private JButton btnLogin,btnClose;
	public TestLogin() {
		super("SQL Injection :: Test");
		tfId=new JTextField();
		pfPass=new JPasswordField();
		btnLogin=new JButton("Login");
		btnClose=new JButton("Close");
		
		tfId.setBorder(new TitledBorder("���̵�"));
		pfPass.setBorder(new TitledBorder("��й�ȣ"));
		
		JPanel panel= new JPanel();
		panel.add(btnLogin);
		panel.add(btnClose);
		
		btnLogin.addActionListener(this);
		btnClose.addActionListener(this);
		pfPass.addActionListener(this);
		
		setLayout(new GridLayout(3, 1));
		add(tfId);
		add(pfPass);
		add(panel);
		
		setBounds(300,300,300,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//constructor
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==btnLogin||ae.getSource()==pfPass) {
			String id=tfId.getText().trim();
			String pass=new String(pfPass.getPassword());
			if(login(id, pass)) {
				new TableInfo();
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "ID�� ��й�ȣ�� Ȯ�����ּ���!");
			}
		}//end if
		
		if(ae.getSource()==btnClose) {
			dispose();
		}//end if
		
	}//actionPerformed
	
	private boolean login(String id,String pass) {
		boolean flag=false;
		LoginDAO ld= LoginDAO.getInstance();
		try {
			flag=ld.selectLogin(id, pass);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "login�� ������ �߻��Ͽ����ϴ�");
			e.printStackTrace();
		}
		return flag;
	}//login

	public static void main(String[] args) {
		new TestLogin();
	}//main

}//TestLogin
