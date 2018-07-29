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
	private JPanel pStar;//별을 담을 페널
	private JLabel[] lGrade;//색상있는 별
	private JLabel[] lBlackGrade; //빈별
	private ImageIcon iiRestaurant;
	private JTextArea taReview;
	private JScrollPane spScroll;
	private JButton btnConfirm;
	
	
	public UserDetailReview() {
		lGradeName=new JLabel("평점 : ");
		lGrade=new JLabel[5];
		pStar=new JPanel();
		iiRestaurant=new ImageIcon("C:/dev/workspace/group_project/src/kr/co/sist/user/images/Chicken.jpg");
		lRestaurant=new JLabel(iiRestaurant);
		taReview=new JTextArea("리뷰내용");
		btnConfirm=new JButton("확인");
		for(int i=0;i<lGrade.length;i++) {
			lGrade[i]=new JLabel("★");
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
