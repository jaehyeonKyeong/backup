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
		super("시간");
		btnTime=new JButton("시간보기");
		btnInput=new JButton("입력");
		jtfTime=new JTextField("시간",20);
		jtfTime.setEditable(false);
		jtfTime.setFont(new Font("SansSerif", Font.BOLD,14));
		
		lblOutput=new JLabel("출력창");
		lblOutput.setBorder(new TitledBorder("출력창"));
		
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
				JOptionPane.showMessageDialog(this, "시간을 출력할 수없습니다");
				e.printStackTrace();
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnInput) {
			String name=JOptionPane.showInputDialog("이름입력");
			lblOutput.setText(name+"님 현재시각은"+jtfTime.getText()+"입니다");
		}
		if(e.getSource()==btnTime) {
			if(tempThread ==null) {//Thread가 생성되지 않았다면
				tempThread=new Thread(this);
				tempThread.start();
			}else {
				JOptionPane.showMessageDialog(this, "시간의 실행은 한번만 가능");
			}
		}
	}//actionPerformed
	
	public static void main(String[] args) {
		new ThreadTime();
	}

}
