package day0417;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings({ "serial", "unused" })
public class Homework extends JFrame implements ActionListener {
	private JTextField jtfid;
	private JPasswordField jpfPass;

	public Homework() {
		super("로그인 :D");

		jtfid = new JTextField();
		jpfPass = new JPasswordField();


		jtfid.setBorder(new TitledBorder("아이디"));
		jpfPass.setBorder(new TitledBorder("비밀번호"));

		jtfid.addActionListener(this);
		jpfPass.addActionListener(this);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder("로그인"));
		panel.setLayout(new GridLayout(2, 1));
		panel.add(jtfid);
		panel.add(jpfPass);
		add(panel);

		setBounds(100, 100, 250, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String pass=new String(jpfPass.getPassword());
		if (ae.getSource() == jtfid) {
			if (jtfid.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "아이디를 입력해주세요", "아이디 체크", JOptionPane.ERROR_MESSAGE);
			}else {
				jpfPass.requestFocus();
			}
		}
		if (ae.getSource() == jpfPass) {
			if(pass.equals("")) {
				JOptionPane.showMessageDialog(this, "비밀번호를 입력해주세요", "비밀번호 체크", JOptionPane.WARNING_MESSAGE);				
			}else {
				if(jtfid.getText().equals("admin")&&pass.equals("1234")) {
					JOptionPane.showMessageDialog(this, "로그인 성공", "로그인:D", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(this, "로그인 실패", "로그인:(", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}// actionPerformed

	public static void main(String[] args) {
		new Homework();
	}// main

}// class
