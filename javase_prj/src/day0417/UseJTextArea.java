package day0417;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UseJTextArea extends JFrame {

	public UseJTextArea() {
		super("JTextArea");
		JTextArea jta1=new JTextArea();
		JTextArea jta2=new JTextArea();
		
		jta1.setBorder(new TitledBorder("TA1"));
//		jta2.setBorder(new TitledBorder("TA2"));
		setLayout(new GridLayout(1, 2));
		
		JScrollPane jsp= new JScrollPane(jta2); //스크롤바 객체에 컴포넌트 배치
		jsp.setBorder(new TitledBorder("TA2"));
		
		//textArea의 끝을 만나면 줄 변경
		jta1.setLineWrap(true);
		//줄이 변경될때 단어별로 (한글x) 줄변경
		jta1.setWrapStyleWord(true);
		
		//ta끝에서 줄이 변경되면 횡스크롤바는 생성되지 않는다.
		jta2.setLineWrap(true);
		jta2.setWrapStyleWord(true);
		
		add(jta1);
		add(jsp);//스크롤바 객체 배치
		
		setBounds(100,100,400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//constructor
	
	public static void main(String[] args) {
		new UseJTextArea();
	}
	
}
