package day0417;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class HelloSwing extends JFrame implements ActionListener{
	Button btnAwt;
	JButton btnSwing;
	public HelloSwing() {
		super("안녕 스윙 :D");
		btnAwt=new Button("AWT 버튼");
		btnSwing=new JButton("Swing 버튼");
		
		setLayout(new GridLayout(1,2));
		
		add(btnAwt);//Swing Component는 AWT Component와 호환된다.
		add(btnSwing);
		
		//이벤트 등록
		btnAwt.addActionListener(this);
		btnSwing.addActionListener(this);
		
		setBounds(100,100,300,200);
		setVisible(true);
		
		//종료 처리 : setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
	}//constructor
	
	public static void main(String[] args) {
		new HelloSwing();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		//swing component는 AWT Event처리클래스를 사용하여 event를 처리함
		if(ae.getSource()==btnAwt) {
			JOptionPane.showMessageDialog(this, "AWT Component가 이벤트를 발생시켰어요", "메세지 :D", JOptionPane.QUESTION_MESSAGE);
		}
		if(ae.getSource()==btnSwing) {
			JOptionPane.showMessageDialog(this, "Swing Component가 이벤트를 발생시켰어요", "메세지 :-)", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
