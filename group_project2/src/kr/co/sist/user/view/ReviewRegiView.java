package kr.co.sist.user.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.sist.user.controller.ReviewRegiViewEvt;

public class ReviewRegiView extends JFrame {
	ReviewListView rlv;
	ImageIcon reviewImg,reviewerIcon;
	JTextArea taReviewContent;
	JTextField tfReviewerID,tfReviewTitle;
	JButton btnAdd,btnClose,btnRegiImg;
	JComboBox<String> cGradeBox; 
	String rNum,id;
	JLabel lblReviewImg;
	JLabel lblReviewerIcon;
	private JPanel panel;
	private Color b_Color=new Color(0,100,121);
	private Color t_Color=new Color(245,247,249);
	
	public JLabel getLblReviewImg() {
		return lblReviewImg;
	}


	public JLabel getLblReviewerIcon() {
		return lblReviewerIcon;
	}


	public String getrNum() {
		return rNum;
	}


	public String getId() {
		return id;
	}


	public JPanel getPanel() {
		return panel;
	}


	public Color getB_Color() {
		return b_Color;
	}


	public Color getT_Color() {
		return t_Color;
	}


	public ReviewRegiView(String rNum, String id) {
		super(":::리뷰:::");
		this.rNum=rNum;
		this.id=id;
		
		tfReviewTitle=new JTextField();
		reviewImg = new ImageIcon("C:/dev/workspace/group_project2/src/kr/co/sist/user/view/images/review1.jpg");
		reviewerIcon = new ImageIcon("C:/dev/workspace/group_project2/src/kr/co/sist/user/view/images/profile.png");
		lblReviewerIcon = new JLabel();
		lblReviewImg=new JLabel();
		taReviewContent = new JTextArea();
		tfReviewerID = new JTextField("HonneyBro");
		JScrollPane scroll = new JScrollPane(taReviewContent);
		btnAdd = new JButton("등록");
		btnClose= new JButton("닫기");
		cGradeBox = new JComboBox<String>();
		JLabel lblGrade=new JLabel("평점");
		btnRegiImg=new JButton("사진추가");
		panel=new JPanel();
		JLabel lblReviewTitle=new JLabel("리뷰제목");
		tfReviewerID.setEditable(false);
		
		lblReviewerIcon.setIcon(reviewerIcon);
		lblReviewImg.setIcon(reviewImg);
		
		cGradeBox.addItem("★★★★★");
		cGradeBox.addItem("★★★★");
		cGradeBox.addItem("★★★");
		cGradeBox.addItem("★★");
		cGradeBox.addItem("★");
		
		tfReviewTitle.setBounds(370,100,200,20);
		lblReviewTitle.setBounds(270,100,80,20);
		tfReviewerID.setBounds(75, 50, 125, 20);
		lblReviewerIcon.setBounds(40, 50, 20, 20);
		lblReviewImg.setBounds(40,100,200,220);
		btnRegiImg.setBounds(100,330,100,25);
		lblGrade.setBounds(300,50,50,20);
		cGradeBox.setBounds(350, 50, 100, 20);
		scroll.setBounds(270, 125, 300, 225);
		btnAdd.setBounds(190, 400, 80, 30);
		btnClose.setBounds(295,400, 80, 30);
		panel.setBounds(0,0, 600, 500);

		add(tfReviewerID);
		add(lblReviewerIcon);
		add(lblReviewImg);
		add(lblGrade);
		add(cGradeBox);
		add(scroll);
		add(btnAdd);
		add(btnClose);
		add(btnRegiImg);
		add(panel);
		add(tfReviewTitle);
		add(lblReviewTitle);
		
		panel.setBackground(Color.WHITE);
		
		btnRegiImg.setBackground(b_Color);
		btnAdd.setBackground(b_Color);
		btnClose.setBackground(b_Color);
		
		btnRegiImg.setFont(new Font("SanSerif",Font.BOLD,15));
		btnAdd.setFont(new Font("SanSerif",Font.BOLD,15));
		btnClose.setFont(new Font("SanSerif",Font.BOLD,15));
		btnRegiImg.setForeground(Color.WHITE);
		btnAdd.setForeground(Color.WHITE);
		btnClose.setForeground(Color.WHITE);
		taReviewContent.setBackground(t_Color);
		
		btnRegiImg.setBorderPainted(false);
		btnAdd.setBorderPainted(false);
		btnClose.setBorderPainted(false);
		
		
		
		ReviewRegiViewEvt rrve=new ReviewRegiViewEvt(this);
		btnAdd.addActionListener(rrve);
		btnClose.addActionListener(rrve);
		btnRegiImg.addActionListener(rrve);

		setLayout(null);
		setBounds(500, 100, 600, 500);
		setResizable(false);
		setVisible(true);
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


	public JTextField getTfReviewTitle() {
		return tfReviewTitle;
	}
	

}
