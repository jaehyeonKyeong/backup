package kr.co.sist.user.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import kr.co.sist.user.controller.UserDetailReviewEvt;
import oracle.net.aso.b;

public class UserDetailReview extends JFrame {
	private JLabel lUserID,lRestaurant,lGradeName; 
	private JPanel pStar;//별을 담을 페널
	private JLabel[] lGrade;//색상있는 별
	private JLabel[] lBlackGrade; //빈별
	private ImageIcon iiRestaurant;
	private JTextArea taReview;
	private JScrollPane spScroll;
	private JButton btnConfirm;
	private String rNum,id;
	
	public UserDetailReview(String rNum,String id) {
		super(id+"님의 리뷰");
		this.rNum=rNum;
		this.id=id;
		lGradeName=new JLabel("평점 : ");
		lGrade=new JLabel[5];
		pStar=new JPanel();
		lUserID=new JLabel(id);
		iiRestaurant=new ImageIcon("C:/Users/Administrator/eclipse-workspace/group_project2/src/kr/co/sist/user/images/Chicken.jpg");
		lRestaurant=new JLabel(iiRestaurant);
		taReview=new JTextArea("리뷰내용");
		spScroll=new JScrollPane(taReview);
		btnConfirm=new JButton("확인");
	
		
		setLayout(null);
		lUserID.setBounds(30,50,50,30);
		pStar.setBounds(270, 20, 90, 20);
		lGradeName.setBounds(240,25,50,20);
		lRestaurant.setBounds(30, 80, 170, 200);
		spScroll.setBounds(210, 80, 170, 200);
		btnConfirm.setBounds(175,300,60,30);
		
		UserDetailReviewEvt udre=new UserDetailReviewEvt(this);
		btnConfirm.addActionListener(udre);
		for(int i=0;i<udre.getGrade();i++) {
			lGrade[i]=new JLabel("★");
			pStar.add(lGrade[i]);
		}
		add(lUserID);
		add(btnConfirm);
		add(spScroll);
		add(lRestaurant);
		add(pStar);
		add(lGradeName);
		
		ImageIcon ii=new ImageIcon(udre.getReviewImg());
		JLabel background=new JLabel(ii);
		background.setBounds(0, 0, 450, 450);
		add(background);
		
		setBounds(100,100,450,450);
		setVisible(true);
	}

	public JTextArea getTaReview() {
		return taReview;
	}

	public String getrNum() {
		return rNum;
	}

	public String getId() {
		return id;
	}
	

}
