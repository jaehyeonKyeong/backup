package kr.co.sist.licensee.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.sist.licensee.controller.MenuRegistrationViewEvt;

@SuppressWarnings("serial")
public class MenuRegistrationView extends JFrame {
	private JButton btnAdd, btnRegistration, btnCancle;
	private ImageIcon menuAdd;
	private JTextField jtfName, jtfPrice;
	private JTextArea taIntroduction;
	private String  imgURL;
	private JLabel  lblImg;
	private String  rNum;
	private RestaurantRegistrationView rrv;
	private RestaurantUpdateView ruv;
	

	

	public MenuRegistrationView(String rNum, RestaurantRegistrationView rrv) {
		super("메뉴 등록");
		this.rNum=rNum;
		this.rrv=rrv;
		
		imgURL="C:\\Users\\owner\\Pictures\\sist.jpg";
		ImageIcon iiRestaurantImg=new ImageIcon(imgURL);
		lblImg =new JLabel(iiRestaurantImg);
		
		lblImg.setBounds(20,15,110,130);
		
		add(lblImg);
		
		
		btnAdd = new JButton("추가");
		btnRegistration = new JButton("등록");
		btnCancle = new JButton("취소");
		jtfName=new JTextField();
		jtfPrice=new JTextField();
		taIntroduction=new JTextArea("소개글");
		JScrollPane jsp=new JScrollPane(taIntroduction);
		JLabel lblName=new JLabel("이름");
		JLabel lblPrice=new JLabel("가격");
		
		add(btnAdd);
		add(btnRegistration);
		add(btnCancle);
		add(jtfName);
		add(jtfPrice);
		add(jsp);
		add(lblName);
		add(lblPrice);
		
		
	
		
		//수동배치
		setLayout(null);
		
		btnAdd.setBounds(45, 160, 60, 25);
		btnRegistration.setBounds(80, 200, 60, 30);
		btnCancle.setBounds(170, 200, 60, 30);
		jtfName.setBounds(150, 30, 150, 25);
		jtfPrice.setBounds(150, 80, 150, 25);
		jsp.setBounds(150, 110, 150, 80);
		lblName.setBounds(150, -5, 40, 50);
		lblPrice.setBounds(150, 45, 40, 50);
		
		setBounds(120, 40, 330, 280);
		setVisible(false);
		setResizable(false);
		
		MenuRegistrationViewEvt mrve=new MenuRegistrationViewEvt(this);
		btnAdd.addActionListener(mrve);
		btnRegistration.addActionListener(mrve);
		btnCancle.addActionListener(mrve);
		jtfName.addActionListener(mrve);
		jtfPrice.addActionListener(mrve);
		
		
		
		
	}// MenuRegistrationView


	public MenuRegistrationView(String rNum2, RestaurantUpdateView ruv) {
		super("메뉴 등록");
		this.rNum=rNum2;
		this.ruv=ruv;
		
		imgURL="C:\\Users\\owner\\Pictures\\sist.jpg";
		ImageIcon iiRestaurantImg=new ImageIcon(imgURL);
		lblImg =new JLabel(iiRestaurantImg);
		
		lblImg.setBounds(20,15,110,130);
		
		add(lblImg);
		
		
		btnAdd = new JButton("추가");
		btnRegistration = new JButton("등록");
		btnCancle = new JButton("취소");
		jtfName=new JTextField();
		jtfPrice=new JTextField();
		taIntroduction=new JTextArea("소개글");
		JLabel lblName=new JLabel("이름");
		JLabel lblPrice=new JLabel("가격");
		
		add(btnAdd);
		add(btnRegistration);
		add(btnCancle);
		add(jtfName);
		add(jtfPrice);
		add(taIntroduction);
		add(lblName);
		add(lblPrice);
		
		
	
		
		//수동배치
		setLayout(null);
		
		btnAdd.setBounds(45, 160, 60, 25);
		btnRegistration.setBounds(80, 200, 60, 30);
		btnCancle.setBounds(170, 200, 60, 30);
		jtfName.setBounds(150, 30, 150, 25);
		jtfPrice.setBounds(150, 80, 150, 25);
		taIntroduction.setBounds(150, 110, 150, 80);
		lblName.setBounds(150, -5, 40, 50);
		lblPrice.setBounds(150, 45, 40, 50);
		
		setBounds(120, 40, 330, 280);
		setVisible(false);
		setResizable(false);
		
		MenuRegistrationViewEvt mrve=new MenuRegistrationViewEvt(this);
		btnAdd.addActionListener(mrve);
		btnRegistration.addActionListener(mrve);
		btnCancle.addActionListener(mrve);
		jtfName.addActionListener(mrve);
		jtfPrice.addActionListener(mrve);
		
	}


	public RestaurantRegistrationView getRrv() {
		return rrv;
	}


	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnRegistration() {
		return btnRegistration;
	}

	public JButton getBtnCancle() {
		return btnCancle;
	}

	public ImageIcon getMenuAdd() {
		return menuAdd;
	}

	public JTextField getJtfName() {
		return jtfName;
	}

	public JTextField getJtfPrice() {
		return jtfPrice;
	}

	public JTextArea getTaIntroduction() {
		return taIntroduction;
	}

	public String getImgURL() {
		return imgURL;
	}

	public JLabel getLblImg() {
		return lblImg;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public void setLblImg(JLabel lblImg) {
		this.lblImg = lblImg;
	}
	public String getrNum() {
		return rNum;
	}

}// class
