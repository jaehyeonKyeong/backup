package day0418;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UseRuntimeException1 extends JFrame implements ActionListener {
	private JTextField jtfNum1, jtfNum2,jtfResult;


	public UseRuntimeException1() {
		super("나누기");
		jtfNum1=new JTextField(10);
		jtfNum2=new JTextField(10);
		jtfResult=new JTextField(20);
		jtfResult.setEditable(false);
		
		jtfNum1.addActionListener(this);
		jtfNum2.addActionListener(this);
		
		setLayout(new FlowLayout());
		add(jtfNum1);
		add(new JLabel("/"));
		add(jtfNum2);
		add(new JLabel("="));
		add(jtfResult);
		
		setBounds(100,100,600,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}// constructor

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==jtfNum1) {
			jtfNum2.requestFocus();
		}
		if(ae.getSource()==jtfNum2) {
			String resultText="";
			try {
				int i=Integer.parseInt(jtfNum1.getText().replaceAll(" ", ""));
				int j=Integer.parseInt(jtfNum2.getText().replaceAll(" ", ""));
				int result=i/j;
				resultText=String.valueOf(result);
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(this, "숫자만 가능해요", "오류 :)", JOptionPane.ERROR_MESSAGE);
				nfe.printStackTrace();
			}catch(ArithmeticException e) {
				resultText="오류";
				e.printStackTrace();
			}
			
			jtfResult.setText(resultText);
		}
	}

	public static void main(String[] args) {
		new UseRuntimeException1();
	}

}
