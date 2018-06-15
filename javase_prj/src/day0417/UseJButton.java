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
		
		JButton btn1=new JButton("버튼1",ii1);//버튼 생성시 텍스트와 아이콘을 같이 설정
		JButton btn2=new JButton("버튼2");// 텍스트만 했음
		JButton btn3=new JButton("버튼3");
		
		//JComponent의 모든 자식은 다 풍선 도움말을 가진다
		btn1.setToolTipText("나는 버튼");
		btn2.setToolTipText("나도 버튼");
		btn3.setToolTipText("마우스를 올려보세요 버튼");
		
		//아이콘은 생성후 method를 통해서 설정 가능
		btn2.setIcon(ii2);
		btn3.setIcon(ii3);
		
		//아이콘을 마우스가 올라갔을때 이미지를 변경할 것(rollOver)
		btn3.setRolloverIcon(ii4);
		
		//텍스트움직이기 : 수직 : top,center,bottom
		
//		btn1.setVerticalTextPosition(JButton.TOP);
		btn1.setVerticalTextPosition(JButton.CENTER);
		
		//텍스트 움직이기 : 수평 : left,center,right
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
