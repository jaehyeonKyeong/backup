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
		super("�α��� :D");

		jtfid = new JTextField();
		jpfPass = new JPasswordField();


		jtfid.setBorder(new TitledBorder("���̵�"));
		jpfPass.setBorder(new TitledBorder("��й�ȣ"));

		jtfid.addActionListener(this);
		jpfPass.addActionListener(this);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder("�α���"));
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
				JOptionPane.showMessageDialog(this, "���̵� �Է����ּ���", "���̵� üũ", JOptionPane.ERROR_MESSAGE);
			}else {
				jpfPass.requestFocus();
			}
		}
		if (ae.getSource() == jpfPass) {
			if(pass.equals("")) {
				JOptionPane.showMessageDialog(this, "��й�ȣ�� �Է����ּ���", "��й�ȣ üũ", JOptionPane.WARNING_MESSAGE);				
			}else {
				if(jtfid.getText().equals("admin")&&pass.equals("1234")) {
					JOptionPane.showMessageDialog(this, "�α��� ����", "�α���:D", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(this, "�α��� ����", "�α���:(", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}// actionPerformed

	public static void main(String[] args) {
		new Homework();
	}// main

}// class
