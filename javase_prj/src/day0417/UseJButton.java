package day0417;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class UseJButton extends JFrame {
	
	public UseJButton() {
		ImageIcon ii1=new ImageIcon("C:/dev/workspace/javase_prj/src/day0417/img/img1.png");
		ImageIcon ii2=new ImageIcon("C:/dev/workspace/javase_prj/src/day0417/img/img2.png");
		ImageIcon ii3=new ImageIcon("C:/dev/workspace/javase_prj/src/day0417/img/img3.png");
		ImageIcon ii4=new ImageIcon("C:/dev/workspace/javase_prj/src/day0417/img/img4.png");
		
		JButton btn1=new JButton("��ư1",ii1);//��ư ������ �ؽ�Ʈ�� �������� ���� ����
		JButton btn2=new JButton("��ư2");// �ؽ�Ʈ�� ����
		JButton btn3=new JButton("��ư3");
		
		//JComponent�� ��� �ڽ��� �� ǳ�� ������ ������
		btn1.setToolTipText("���� ��ư");
		btn2.setToolTipText("���� ��ư");
		btn3.setToolTipText("���콺�� �÷������� ��ư");
		
		//�������� ������ method�� ���ؼ� ���� ����
		btn2.setIcon(ii2);
		btn3.setIcon(ii3);
		
		//�������� ���콺�� �ö����� �̹����� ������ ��(rollOver)
		btn3.setRolloverIcon(ii4);
		
		//�ؽ�Ʈ�����̱� : ���� : top,center,bottom
		
//		btn1.setVerticalTextPosition(JButton.TOP);
		btn1.setVerticalTextPosition(JButton.CENTER);
		
		//�ؽ�Ʈ �����̱� : ���� : left,center,right
		btn2.setHorizontalTextPosition(JButton.LEFT);
		
//		btn3.setVerticalTextPosition(JButton.BOTTOM);
//		btn3.setHorizontalTextPosition(JButton.CENTER);
		btn3.setVerticalTextPosition(JButton.TOP);
		btn3.setHorizontalTextPosition(JButton.LEFT);
		
		
		setLayout(new GridLayout(1,3));
		
		add(btn1);
		add(btn2);
		add(btn3);
		
		setBounds(100,100,2000,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}//constructor
	public static void main(String[] args) {
		new UseJButton();

	}

}
