package day0413;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class UseColor extends Frame implements ItemListener {
	private Label lblOutput;
	private Checkbox rbRed,rbGreen,rbBlue,likeColor;
	public UseColor() {
		super("������");
		CheckboxGroup cg= new CheckboxGroup();
		rbRed=new Checkbox("������", cg,false);
		rbGreen=new Checkbox("���", cg,false);
		rbBlue=new Checkbox("�Ķ���", cg,false);
		likeColor=new Checkbox("�����ϴ»�", cg,false);
		
		lblOutput= new Label("���â",Label.CENTER);
		lblOutput.setFont(new Font("SansSerif",Font.BOLD,80));
		lblOutput.setForeground(new Color(0x000000));
		
		
		Panel panel=new Panel();
		panel.add(rbRed);
		panel.add(rbGreen);
		panel.add(rbBlue);
		panel.add(likeColor);
		
		add("Center",lblOutput);
		add("South",panel);
		
		rbRed.addItemListener(this);
		rbGreen.addItemListener(this);
		rbBlue.addItemListener(this);
		likeColor.addItemListener(this);
		
		setBounds(100, 100, 400, 250);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});
		
	}//constance
	public static void main(String[] args) {
		new UseColor();
	}
	@Override
	public void itemStateChanged(ItemEvent ie) {
		if(ie.getSource()==rbRed) {
			lblOutput.setBackground(Color.RED);
//			lblOutput.setForeground(Color.yellow);
		}
		if(ie.getSource()==rbGreen) {
			lblOutput.setBackground(Color.GREEN);
//			lblOutput.setForeground(Color.CYAN);
		}
		if(ie.getSource()==rbBlue) {
			lblOutput.setBackground(Color.BLUE);
//			lblOutput.setForeground(Color.magenta);
		}
		if(ie.getSource()==likeColor) {
			lblOutput.setBackground(new Color(0xBF2323));
//			lblOutput.setForeground(Color.magenta);
		}
	}
}
