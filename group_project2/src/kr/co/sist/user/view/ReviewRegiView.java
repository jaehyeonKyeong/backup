package kr.co.sist.user.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.sist.user.controller.ReviewRegiViewEvt;

public class ReviewRegiView extends JFrame {
	ReviewListView rlv;
	ImageIcon reviewImg,reviewerIcon;
	JTextArea taReviewContent;
	JTextField tfReviewerID;
	JButton btnAdd,btnClose,btnRegiImg;
	JComboBox<String> cGradeBox; 
	
	public ReviewRegiView() {
		super("리뷰");
		reviewImg = new ImageIcon("C:/dev/workspace/group_project2/src/kr/co/sist/user/view/images/review1.jpg");
		reviewerIcon = new ImageIcon("C:/dev/workspace/group_project2/src/kr/co/sist/user/view/images/profile.png");
		JLabel lblReviewerIcon = new JLabel();
		JLabel lblReviewImg=new JLabel();
		taReviewContent = new JTextArea();
		tfReviewerID = new JTextField("HonneyBro");
		JScrollPane scroll = new JScrollPane(taReviewContent);
		btnAdd = new JButton("등록");
		btnClose= new JButton("닫기");
		cGradeBox = new JComboBox<String>();
		JLabel lblGrade=new JLabel("평점");
		btnRegiImg=new JButton("사진추가");
		
		lblReviewerIcon.setIcon(reviewerIcon);
		lblReviewImg.setIcon(reviewImg);
		
		cGradeBox.addItem("★★★★★");
		cGradeBox.addItem("★★★★");
		cGradeBox.addItem("★★★");
		cGradeBox.addItem("★★");
		cGradeBox.addItem("★");

		tfReviewerID.setBounds(75, 50, 125, 20);
		lblReviewerIcon.setBounds(40, 50, 20, 20);
		lblReviewImg.setBounds(40,100,200,220);
		btnRegiImg.setBounds(100,330,90,25);
		lblGrade.setBounds(300,50,50,20);
		cGradeBox.setBounds(350, 50, 100, 20);
		scroll.setBounds(270, 100, 300, 250);
		btnAdd.setBounds(190, 400, 80, 30);
		btnClose.setBounds(275,400, 80, 30);

		add(tfReviewerID);
		add(lblReviewerIcon);
		add(lblReviewImg);
		add(lblGrade);
		add(cGradeBox);
		add(scroll);
		add(btnAdd);
		add(btnClose);
		add(btnRegiImg);
		
		ReviewRegiViewEvt rrve=new ReviewRegiViewEvt(this);
		btnAdd.addActionListener(rrve);
		btnClose.addActionListener(rrve);

		setLayout(null);
		setBounds(500, 100, 600, 500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public static void main(String[] args) {
		new ReviewRegiView();
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


	public JButton getBtnAdd() {
		return btnAdd;
	}


	public JComboBox<String> getcGradeBox() {
		return cGradeBox;
	}


	public JButton getBtnClose() {
		return btnClose;
	}


	public JButton getBtnRegiImg() {
		return btnRegiImg;
	}
	

}
