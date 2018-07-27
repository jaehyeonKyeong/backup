package kr.co.sist.user.view;

import java.awt.Color;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.sist.user.controller.ReviewContentsViewEvt;

public class ReviewContentsView extends JFrame {
	ReviewListView rlv;
	ImageIcon reviewImg, reviewerIcon;
	JTextArea taReviewContent;
	JTextField tfReviewerID;
	JButton btnSubmit, btnReport,btnThumbsUp;
	int Thumbsdata;
	JLabel lblReviewGrade;

	public ReviewContentsView() {
		super("리뷰");
		reviewImg = new ImageIcon("C:/dev/workspace/group_project2/src/kr/co/sist/user/view/images/review1.jpg");
		reviewerIcon = new ImageIcon("C:/dev/workspace/group_project2/src/kr/co/sist/user/view/images/profile.png");
		ImageIcon thumbsUp=new ImageIcon("C:/dev/workspace/group_project2/src/kr/co/sist/user/view/images/thumbsUp.PNG");
		JLabel lblReviewerIcon = new JLabel();
		JLabel lblReviewImg=new JLabel();
		taReviewContent = new JTextArea();
		tfReviewerID = new JTextField("HonneyBro");
		JScrollPane scroll = new JScrollPane(taReviewContent);
		btnSubmit = new JButton("확인");
		btnReport = new JButton("신고");
		JLabel lblGrade = new JLabel("평점 ★★★★★");
		btnThumbsUp=new JButton(thumbsUp);
		DecimalFormat df=new DecimalFormat("###,###,###");
		Thumbsdata=111111;
		lblReviewGrade=new JLabel(df.format(Thumbsdata));
		
		lblReviewerIcon.setIcon(reviewerIcon);
		lblReviewImg.setIcon(reviewImg);
		taReviewContent.setText("송램지의 손맛이 느껴지는 일품요리였어요 진짜 JMT!!!");
		taReviewContent.setEditable(false);
		tfReviewerID.setEditable(false);
		

		tfReviewerID.setBounds(75, 50, 125, 20);
		lblReviewerIcon.setBounds(40, 50, 20, 20);
		lblReviewImg.setBounds(40,100,200,250);
		lblGrade.setBounds(300, 50, 100, 20);
		scroll.setBounds(270, 100, 300, 250);
		btnThumbsUp.setBounds(495,363,20,20);
		btnSubmit.setBounds(270, 400, 80, 30);
		lblReviewGrade.setBounds(520,360,50,30);
		btnReport.setBounds(10, 430, 80, 20);

		add(tfReviewerID);
		add(lblReviewerIcon);
		add(lblReviewImg);
		add(lblGrade);
		add(scroll);
		add(lblReviewGrade);
		add(btnThumbsUp);
		add(btnSubmit);
		add(btnReport);
		
		ReviewContentsViewEvt rcve=new ReviewContentsViewEvt(this);
		btnThumbsUp.addActionListener(rcve);
		

		setLayout(null);
		setBounds(500, 100, 600, 500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ReviewContentsView();
	}

	public ReviewListView getRlv() {
		return rlv;
	}

	public ImageIcon getReviewImg() {
		return reviewImg;
	}

	public ImageIcon getReviewerIcon() {
		return reviewerIcon;
	}

	public JTextArea getTaReviewContent() {
		return taReviewContent;
	}

	public JTextField getTfReviewerID() {
		return tfReviewerID;
	}

	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	public JButton getBtnReport() {
		return btnReport;
	}

	public JButton getBtnThumbsUp() {
		return btnThumbsUp;
	}

	public JLabel getLblReviewGrade() {
		return lblReviewGrade;
	}

	public int getThumbsdata() {
		return Thumbsdata;
	}
	

}
