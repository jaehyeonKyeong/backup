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
		
		JScrollPane jsp= new JScrollPane(jta2); //��ũ�ѹ� ��ü�� ������Ʈ ��ġ
		jsp.setBorder(new TitledBorder("TA2"));
		
		//textArea�� ���� ������ �� ����
		jta1.setLineWrap(true);
		//���� ����ɶ� �ܾ�� (�ѱ�x) �ٺ���
		jta1.setWrapStyleWord(true);
		
		//ta������ ���� ����Ǹ� Ⱦ��ũ�ѹٴ� �������� �ʴ´�.
		jta2.setLineWrap(true);
		jta2.setWrapStyleWord(true);
		
		add(jta1);
		add(jsp);//��ũ�ѹ� ��ü ��ġ
		
		setBounds(100,100,400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//constructor
	
	public static void main(String[] args) {
		new UseJTextArea();
	}
	
}
