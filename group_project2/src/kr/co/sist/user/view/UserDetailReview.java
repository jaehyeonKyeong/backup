package kr.co.sist.user.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UserDetailReview extends JFrame {
	private JLabel lUserID,lRestaurant,lGradeName; 
	private JPanel pStar;//���� ���� ���
	private JLabel[] lGrade;//�����ִ� ��
	private JLabel[] lBlackGrade; //��
	private ImageIcon iiRestaurant;
	private JTextArea taReview;
	private JScrollPane spScroll;
	private JButton btnConfirm;
	
	
	public UserDetailReview() {
		lGradeName=new JLabel("���� : ");
		lGrade=new JLabel[5];
		pStar=new JPanel();
		iiRestaurant=new ImageIcon("C:/dev/workspace/group_project/src/kr/co/sist/user/images/Chicken.jpg");
		lRestaurant=new JLabel(iiRestaurant);
		taReview=new JTextArea("���䳻��");
		btnConfirm=new JButton("Ȯ��");
		for(int i=0;i<lGrade.length;i++) {
			lGrade[i]=new JLabel("��");
			pStar.add(lGrade[i]);
		}
		
		setLayout(null);
		pStar.setBounds(270, 20, 90, 20);
		lGradeName.setBounds(240,25,50,20);
		lRestaurant.setBounds(30, 80, 170, 200);
		taReview.setBounds(210, 80, 170, 200);
		btnConfirm.setBounds(175,300,60,30);
		add(btnConfirm);
		add(taReview);
		add(lRestaurant);
		add(pStar);
		add(lGradeName);
		setBounds(100,100,450,450);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new UserDetailReview();
		
	}

}
