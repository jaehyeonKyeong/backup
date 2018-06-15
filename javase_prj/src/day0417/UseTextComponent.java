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
		super("JTextField 사용");
		
		jtfid=new JTextField();
		jpfPass=new JPasswordField();
		lblOutput=new JLabel("결과창");
		
		//Border 설정
		
//		jtfid.setBorder(new LineBorder(Color.red));
		jtfid.setBorder(new TitledBorder("아이디"));
		jpfPass.setBorder(new TitledBorder("비밀번호"));
		lblOutput.setBorder(new TitledBorder("결과"));
		
		//이벤트 등록
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
				//텍스트 필드의 내용을 가져와서
				String id=jtfid.getText().trim();
				//결과창에 넣고
				lblOutput.setText("ID : "+id);
				//커서를 패스워드 필드로 이동
				jpfPass.requestFocus();
			}
			if(ae.getSource()==jpfPass) {
				//passwordField의 내용을 가져와서
//				String pass=jpfPass.getText(); //비추천
//				StringBuilder pass=new StringBuilder();
//				char[] temp=jpfPass.getPassword();
//				for(char ch:temp) {
//					pass.append(ch);
//				}
				String pass=new String(jpfPass.getPassword());
				//결과창에 넣는다
				lblOutput.setText("비밀번호 : "+pass);				
			}
	}//actionPerformed

	public static void main(String[] args) {
			new UseTextComponent();
	}//main

}//class
