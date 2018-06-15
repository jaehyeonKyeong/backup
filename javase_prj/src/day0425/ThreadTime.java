package day0425;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.xml.transform.sax.TemplatesHandler;

@SuppressWarnings("serial")
public class ThreadTime extends JFrame implements ActionListener,Runnable{
	private JButton btnTime,btnInput;
	private JLabel lblOutput;
	private JTextField jtfTime;
	private Thread tempThread;
	
	public ThreadTime() {
		super("�ð�");
		btnTime=new JButton("�ð�����");
		btnInput=new JButton("�Է�");
		jtfTime=new JTextField("�ð�",20);
		jtfTime.setEditable(false);
		jtfTime.setFont(new Font("SansSerif", Font.BOLD,14));
		
		lblOutput=new JLabel("���â");
		lblOutput.setBorder(new TitledBorder("���â"));
		
		btnInput.addActionListener(this);
		btnTime.addActionListener(this);
		
		JPanel jpNorth=new JPanel();
		jpNorth.add(jtfTime);
		jpNorth.add(btnTime);
		jpNorth.add(btnInput);
		
		add("North",jpNorth);
		add("Center",lblOutput);
		
		setBounds(100,100,450,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//ThreadTime
	@Override
	public void run() {
		while(true) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss EEEE");
			Date date=new Date();
			jtfTime.setText(sdf.format(date));			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				JOptionPane.showMessageDialog(this, "�ð��� ����� �������ϴ�");
				e.printStackTrace();
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnInput) {
			String name=JOptionPane.showInputDialog("�̸��Է�");
			lblOutput.setText(name+"�� ����ð���"+jtfTime.getText()+"�Դϴ�");
		}
		if(e.getSource()==btnTime) {
			if(tempThread ==null) {//Thread�� �������� �ʾҴٸ�
				tempThread=new Thread(this);
				tempThread.start();
			}else {
				JOptionPane.showMessageDialog(this, "�ð��� ������ �ѹ��� ����");
			}
		}
	}//actionPerformed
	
	public static void main(String[] args) {
		new ThreadTime();
	}

}
