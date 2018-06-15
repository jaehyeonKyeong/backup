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
		super("�ȳ� ���� :D");
		btnAwt=new Button("AWT ��ư");
		btnSwing=new JButton("Swing ��ư");
		
		setLayout(new GridLayout(1,2));
		
		add(btnAwt);//Swing Component�� AWT Component�� ȣȯ�ȴ�.
		add(btnSwing);
		
		//�̺�Ʈ ���
		btnAwt.addActionListener(this);
		btnSwing.addActionListener(this);
		
		setBounds(100,100,300,200);
		setVisible(true);
		
		//���� ó�� : setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
	}//constructor
	
	public static void main(String[] args) {
		new HelloSwing();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		//swing component�� AWT Eventó��Ŭ������ ����Ͽ� event�� ó����
		if(ae.getSource()==btnAwt) {
			JOptionPane.showMessageDialog(this, "AWT Component�� �̺�Ʈ�� �߻����׾��", "�޼��� :D", JOptionPane.QUESTION_MESSAGE);
		}
		if(ae.getSource()==btnSwing) {
			JOptionPane.showMessageDialog(this, "Swing Component�� �̺�Ʈ�� �߻����׾��", "�޼��� :-)", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
