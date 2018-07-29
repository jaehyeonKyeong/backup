package kr.co.sist.user.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kr.co.sist.user.controller.UserShopEvt;

@SuppressWarnings("serial")
public class UserShop extends JFrame {
	private JButton btnThousandImg,btnFiveThousandImg,btnTenThousandImg;
	private ImageIcon iiThousandImg,iiFiveThousandImg,iiTenThousandImg;
	private JPanel jpCategory;
	private Category cg;
//	private UserShopEvt use 
	public UserShop(Category cg) {
		super("모바일상품권 상점");
		this.cg=cg;
		jpCategory=new JPanel();
		iiThousandImg=new ImageIcon("C:/dev/workspace/group_project/src/kr/co/sist/user/images/1000.png");
		iiFiveThousandImg=new ImageIcon("C:/dev/workspace/group_project/src/kr/co/sist/user/images/5000.png");
		iiTenThousandImg=new ImageIcon("C:/dev/workspace/group_project/src/kr/co/sist/user/images/10000.png");
		btnThousandImg=new JButton(iiThousandImg);
		btnFiveThousandImg=new JButton(iiFiveThousandImg);
		btnTenThousandImg=new JButton(iiTenThousandImg);
		JLabel lblTitle=new JLabel("상품권 목록");
		Font fGothic = new Font("맑은 고딕", Font.BOLD, 24);
		jpCategory.setBounds(0, 0, 550, 300);
		lblTitle.setBounds(190, 30, 150, 40);
		btnThousandImg.setBounds(40, 80, 131, 126);
		btnFiveThousandImg.setBounds(190, 80, 131, 126);
		btnTenThousandImg.setBounds(340, 80, 131, 126);
		jpCategory.setBackground(new Color(255, 255, 255));
		setLayout(null);
	
		UserShopEvt use=new UserShopEvt(this);
		btnThousandImg.addActionListener(use);
		btnFiveThousandImg.addActionListener(use);
		btnTenThousandImg.addActionListener(use);
		btnThousandImg.setBorderPainted(false);
		btnFiveThousandImg.setBorderPainted(false);
		btnTenThousandImg.setBorderPainted(false);
		lblTitle.setFont(fGothic);
		add(lblTitle);
		add(btnThousandImg);
		add(btnFiveThousandImg);
		add(btnTenThousandImg);
		add(jpCategory);
		setBounds(100,100,550,300);
		setVisible(true);
	}
	public Category getCg() {
		return cg;
	}
	public JButton getBtnThousandImg() {
		return btnThousandImg;
	}
	public JButton getBtnFiveThousandImg() {
		return btnFiveThousandImg;
	}
	public JButton getBtnTenThousandImg() {
		return btnTenThousandImg;
	}
}
