package kr.co.sist.licensee.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.sist.licensee.controller.MenuChangeViewEvt;

@SuppressWarnings("serial")
public class MenuChangeView extends JFrame {
	private JButton btnAddMenuImg, btnChange, btnCancle;
	private ImageIcon addImg;
	private JTextField jtfName, jtfPrice;
	private JTextArea taIntroduction;
	private String  imgURL;
	private JLabel  lblImg;
	String rNum;
	
	
	public String getrNum() {
		return rNum;
	}


	public MenuChangeView(String rNum) {
		super("메뉴 수정");
		this.rNum=rNum;
		
		imgURL="C:\\Users\\owner\\Pictures\\sist.jpg";
		ImageIcon iiRestaurantImg=new ImageIcon(imgURL);
		lblImg =new JLabel(iiRestaurantImg);
		
		lblImg.setBounds(20,15,110,130);
		
		add(lblImg);
		
		
		
		btnAddMenuImg = new JButton("추가");
		btnChange = new JButton("수정");
		btnCancle = new JButton("취소");
		jtfName=new JTextField();
		jtfPrice=new JTextField();
		taIntroduction=new JTextArea("소개글");
		JLabel lblName=new JLabel("이름");
		JLabel lblPrice=new JLabel("가격");
		
		add(btnAddMenuImg);
		add(btnChange);
		add(btnCancle);
		add(taIntroduction);
		add(jtfName);
		add(jtfPrice);
		add(lblName);
		add(lblPrice);
		
		MenuChangeViewEvt mcve=new MenuChangeViewEvt(this);
		btnAddMenuImg.addActionListener(mcve);
		btnChange.addActionListener(mcve);
		btnCancle.addActionListener(mcve);
		jtfName.addActionListener(mcve);
		jtfPrice.addActionListener(mcve);
		
		
		//수동배치
		setLayout(null);
		
		btnAddMenuImg.setBounds(45, 160, 60, 25);
		btnChange.setBounds(80, 200, 60, 30);
		btnCancle.setBounds(170, 200, 60, 30);
		jtfName.setBounds(150, 30, 150, 25);
		jtfPrice.setBounds(150, 80, 150, 25);
		taIntroduction.setBounds(150, 110, 150, 80);
		lblName.setBounds(150, -5, 40, 50);
		lblPrice.setBounds(150, 45, 40, 50);
		
		setBounds(120, 40, 330, 280);
		setVisible(true);
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}// MenuRegistrationView



	public JButton getBtnAddMenuImg() {
		return btnAddMenuImg;
	}

	public JButton getBtnChange() {
		return btnChange;
	}

	public JButton getBtnCancle() {
		return btnCancle;
	}

	public ImageIcon getAddImg() {
		return addImg;
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






}// class
