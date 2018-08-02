package kr.co.sist.user.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kr.co.sist.user.controller.CategoryEvt;
import kr.co.sist.user.vo.UserInfoVO;

@SuppressWarnings("serial")
public class Category extends JFrame implements Runnable {
	private JButton btnRestaurant,btnReview,btnShop,btnID;
	private JLabel lblUserPoint;
	private JPanel jpLogin;
	private int userPoint;
	private CategoryEvt ce;
	private String id,name;

	public String getName() {
		return name;
	}
	public Category(UserInfoVO uiv)  {
//		int point=10000;//포인트 지급시에 포인트 상승 (현재 가데이터)
		super("CATEGORY");
		id=uiv.getId();
		userPoint=uiv.getPoint();//update시 사용할 포인트데이터
		name=uiv.getName();
//		System.out.println(userPoint);
//		String sPoint="POINT : "+Integer.toString(uiv.getPoint());
		ImageIcon iiRestaurant = new ImageIcon("C:\\Users\\kimkn\\git\\backup\\group_project2\\src\\kr\\co\\sist\\user\\images\\asd2.png");
		ImageIcon iiReview = new ImageIcon("C:\\Users\\kimkn\\git\\backup\\group_project2\\src\\kr\\co\\sist\\user\\images\\asd.png");
		ImageIcon iiPointShop = new ImageIcon("C:\\Users\\kimkn\\git\\backup\\group_project2\\src\\kr\\co\\sist\\user\\images\\pointShop.png");
		btnRestaurant=new JButton(iiRestaurant);
		btnReview=new JButton(iiReview);
		btnShop=new JButton(iiPointShop);
		btnID=new JButton(id);
		lblUserPoint=new JLabel();  
		jpLogin = new JPanel();
		btnRestaurant.setText("오늘 뭐먹지");
//		setTitle(title);
		
		
		
		jpLogin.setBackground(new Color(255, 255, 255));
		btnID.setBackground(new Color(255, 255, 255));
		btnID.setFont(new Font("SanSerif",Font.PLAIN , 12));
//		btnID.setBorderPainted(false);
		setLayout(null);
		jpLogin.setBounds(0,0,490,480);
		btnRestaurant.setBounds(15, 90, 220, 250);
		btnReview.setBounds(236,90,220,250);
		btnShop.setBounds(15,341,440,80);
		btnID.setBounds(260, 40, 120, 30);
		lblUserPoint.setBounds(390, 40, 120, 30);
		
		ce= new CategoryEvt(this);
		btnRestaurant.addActionListener(ce);
		btnReview.addActionListener(ce);
		btnShop.addActionListener(ce);
		btnID.addActionListener(ce);
		
		ce.setPoint();
		add(btnRestaurant);
		add(btnReview);
		add(btnShop);
		add(btnID);
		add(lblUserPoint);
		add(jpLogin);
		setVisible(true);
//		setUndecorated(true);
		setBounds(100,100,490,480);
		Thread th=new Thread(this);
		th.start();
	
	}
	public String getId() {
		return id;
	}
	public JButton getBtnRestaurant() {
		return btnRestaurant;
	}
	public JButton getBtnReview() {
		return btnReview;
	}
	public JButton getBtnShop() {
		return btnShop;
	}
	public JButton getBtnID() {
		return btnID;
	}
	public JLabel getLblUserPoint() {
		return lblUserPoint;
	}
	public int getUserPoint() {
		return userPoint;
	}
	@Override
	public void run() {
		while (true) {
			try {
//				System.out.println("쓰레드으");
				Thread.sleep(1000*5);
				ce.setPoint();
				userPoint=ce.getPoint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public CategoryEvt getCe() {
		return ce;
	}
	

}
