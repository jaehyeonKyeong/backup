package day0417;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings({ "serial", "unused" })
public class UseTextComponent extends JFrame implements ActionListener {
	private JTextField jtfid;
	private JPasswordField jpfPass;
	private JLabel lblOutput;
	
	public UseTextComponent() {
		super("JTextField ���");
		
		jtfid=new JTextField();
		jpfPass=new JPasswordField();
		lblOutput=new JLabel("���â");
		
		//Border ����
		
//		jtfid.setBorder(new LineBorder(Color.red));
		jtfid.setBorder(new TitledBorder("���̵�"));
		jpfPass.setBorder(new TitledBorder("��й�ȣ"));
		lblOutput.setBorder(new TitledBorder("���"));
		
		//�̺�Ʈ ���
		jtfid.addActionListener(this);
		jpfPass.addActionListener(this);
		
		setLayout(new GridLayout(3, 1));
		
		add(jtfid);
		add(jpfPass);
		add(lblOutput);
		
		setBounds(100,100,250,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==jtfid) {
				//�ؽ�Ʈ �ʵ��� ������ �����ͼ�
				String id=jtfid.getText().trim();
				//���â�� �ְ�
				lblOutput.setText("ID : "+id);
				//Ŀ���� �н����� �ʵ�� �̵�
				jpfPass.requestFocus();
			}
			if(ae.getSource()==jpfPass) {
				//passwordField�� ������ �����ͼ�
//				String pass=jpfPass.getText(); //����õ
//				StringBuilder pass=new StringBuilder();
//				char[] temp=jpfPass.getPassword();
//				for(char ch:temp) {
//					pass.append(ch);
//				}
				String pass=new String(jpfPass.getPassword());
				//���â�� �ִ´�
				lblOutput.setText("��й�ȣ : "+pass);				
			}
	}//actionPerformed

	public static void main(String[] args) {
			new UseTextComponent();
	}//main

}//class
