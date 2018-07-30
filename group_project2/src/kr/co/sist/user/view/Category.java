package kr.co.sist.user.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kr.co.sist.user.controller.CategoryEvt;
import kr.co.sist.user.vo.SignUpVO;
import kr.co.sist.user.vo.UserInfoVO;

@SuppressWarnings("serial")
public class Category extends JFrame implements Runnable {
	private JButton btnRestaurant,btnReview,btnShop,btnID;
	private JLabel lblUserPoint;
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
		btnRestaurant=new JButton("오늘 뭐 먹지");
		btnReview=new JButton("리뷰");
		btnShop=new JButton("포인트 상점");
		btnID=new JButton(id);
		lblUserPoint=new JLabel();
		
		
		setLayout(null);
		btnRestaurant.setBounds(50, 140, 200, 250);
		btnReview.setBounds(290,140,200,250);
		btnShop.setBounds(50,420,440,70);
		btnID.setBounds(260, 50, 120, 30);
		lblUserPoint.setBounds(390, 50, 120, 30);
		
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
		setVisible(true);
		setBounds(100,100,600,600);
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
	

}
