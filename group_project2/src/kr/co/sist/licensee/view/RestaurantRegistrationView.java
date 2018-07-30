package kr.co.sist.licensee.view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.licensee.controller.RestaurantRegistrationViewEvt;

@SuppressWarnings("serial")
public class RestaurantRegistrationView extends JFrame {
	private JButton btnRImg, btnMapImg, btnRegistration, btnMenuegistration, btnOk, btnCc,btnNewMenu;
	private ImageIcon iiRestaurantImg, iiMapImg;
	private JTable jMenuTable;
	private JTextArea taIntro;
	private JTextField tfName, tfbNumber, tfCeo, tfAddr, tfCustomerTransaction, tfTel;
	private JComboBox<String> cbFoodCategory;
	private String imgURL1, imgURL2;
	private JLabel lblImg1, lblImg2;
	private DefaultTableModel dtmMenu;
	String id;

	public RestaurantRegistrationView(String id) {
		super("식당등록");
		this.id = id;

		imgURL1 = "C:\\Users\\owner\\Pictures\\sist.jpg";
		ImageIcon iiRestaurantImg = new ImageIcon(imgURL1);
		lblImg1 = new JLabel(iiRestaurantImg);

		lblImg1.setBounds(40, 10, 150, 80);

		add(lblImg1);

		imgURL2 = "C:\\Users\\owner\\Pictures\\sist.jpg";
		ImageIcon iiMapImg = new ImageIcon(imgURL2);
		lblImg2 = new JLabel(iiMapImg);

		lblImg2.setBounds(40, 130, 150, 80);

		add(lblImg2);

		// 음식카테고리
		String category[] = { "한식", "중식", "일식", "양식", "분식" };

		//////////// 메뉴등록 table 시작/////////////
		String[] header = { "메뉴", "가격" };
		String[][] data= {};

		dtmMenu = new DefaultTableModel(header, data.length) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}// isCellEditable{
		};
		for(int i=1;i<data.length;i++) {
			for(int j=1;j<data[i].length;j++) {
				dtmMenu.setValueAt(data[i][j], i, j);
			}
		}

		jMenuTable = new JTable(dtmMenu);
		JScrollPane jsp1 = new JScrollPane(jMenuTable);

		btnRImg = new JButton("식당 이미지");
		btnMapImg = new JButton("지도 이미지");
		btnRegistration = new JButton("등록");
		btnMenuegistration = new JButton("메뉴등록");
		btnNewMenu=new JButton("새로고침");
		btnOk = new JButton("확인");
		btnCc = new JButton("취소");
		iiRestaurantImg = new ImageIcon();
		iiMapImg = new ImageIcon();
		taIntro = new JTextArea();
		tfName = new JTextField();
		tfbNumber = new JTextField();
		tfCeo = new JTextField();
		tfAddr = new JTextField();
		tfCustomerTransaction = new JTextField();
		tfTel = new JTextField();
		cbFoodCategory = new JComboBox<String>(category);

		JLabel lblName = new JLabel("상호명");
		JLabel lblNumber = new JLabel("사업자번호");
		JLabel lblCeoName = new JLabel("대표자명");
		JLabel lblAddr = new JLabel("사업장주소");
		JLabel lblPrice = new JLabel("객단가");
		JLabel lblTel = new JLabel("전화번호");
		JLabel lblFCategory = new JLabel("음식 카테고리");
		JLabel lblIntro = new JLabel("업소 소개");
		JLabel lblMenu = new JLabel("메뉴목록");

		lblName.setFont(new Font("맑은고딕", NORMAL, 16));
		lblNumber.setFont(new Font("맑은고딕", NORMAL, 16));
		lblCeoName.setFont(new Font("맑은고딕", NORMAL, 16));
		lblAddr.setFont(new Font("맑은고딕", NORMAL, 16));
		lblPrice.setFont(new Font("맑은고딕", NORMAL, 16));
		lblTel.setFont(new Font("맑은고딕", NORMAL, 16));
		lblFCategory.setFont(new Font("맑은고딕", NORMAL, 16));
		lblIntro.setFont(new Font("맑은고딕", NORMAL, 16));
		lblMenu.setFont(new Font("맑은고딕", NORMAL, 16));

		add(btnRImg);
		add(btnMapImg);
		add(btnRegistration);
		add(btnMenuegistration);
		add(btnOk);
		add(btnCc);
		add(btnNewMenu);

		add(lblName);
		add(lblNumber);
		add(lblCeoName);
		add(lblAddr);
		add(lblPrice);
		add(lblTel);
		add(lblFCategory);
		add(lblIntro);
		add(lblMenu);

		add(tfName);
		add(tfbNumber);
		add(tfCeo);
		add(tfAddr);
		add(tfCustomerTransaction);
		add(tfTel);
		add(cbFoodCategory);
		add(jsp1).setBounds(40, 430, 420, 160);

		////
		RestaurantRegistrationViewEvt rrve = new RestaurantRegistrationViewEvt(this);
		btnRImg.addActionListener(rrve);
		btnMapImg.addActionListener(rrve);
		btnRegistration.addActionListener(rrve);
		btnMenuegistration.addActionListener(rrve);
		btnNewMenu.addActionListener(rrve);
		btnOk.addActionListener(rrve);
		btnCc.addActionListener(rrve);

		tfName.addActionListener(rrve);
		tfbNumber.addActionListener(rrve);
		tfCeo.addActionListener(rrve);
		tfAddr.addActionListener(rrve);
		tfCustomerTransaction.addActionListener(rrve);
		tfTel.addActionListener(rrve);

		// 수동배치
		setLayout(null);

		// 위치설정
		btnRImg.setBounds(60, 95, 110, 20);
		btnMapImg.setBounds(60, 220, 110, 20);
		btnRegistration.setBounds(370, 380, 90, 25);
		btnMenuegistration.setBounds(370, 600, 90, 25);
		btnOk.setBounds(160, 630, 70, 25);
		btnCc.setBounds(260, 630, 70, 25);
		btnNewMenu.setBounds(260,600,90,25);

		lblName.setBounds(210, 10, 70, 70);
		lblNumber.setBounds(210, 50, 100, 50);
		lblCeoName.setBounds(210, 80, 70, 50);
		lblAddr.setBounds(210, 110, 105, 50);
		lblPrice.setBounds(210, 142, 70, 50);
		lblTel.setBounds(210, 175, 70, 50);
		lblFCategory.setBounds(210, 195, 100, 70);
		lblIntro.setBounds(40, 240, 70, 50);
		lblMenu.setBounds(40, 390, 70, 50);

		tfName.setBounds(320, 30, 150, 25);
		tfbNumber.setBounds(320, 65, 150, 25);
		tfCeo.setBounds(320, 95, 150, 25);
		tfAddr.setBounds(320, 125, 150, 25);
		tfCustomerTransaction.setBounds(320, 155, 150, 25);
		tfTel.setBounds(320, 190, 150, 25);
		cbFoodCategory.setBounds(360, 220, 100, 25);

		JScrollPane sp = new JScrollPane(taIntro);
		sp.setBounds(40, 275, 420, 100);
		add(sp);

		setTitle("식당등록");
		setBounds(120, 40, 500, 700);
		setVisible(true);
		setResizable(false);

	}// RestaurantRegistrationView

	public JButton getBtnRImg() {
		return btnRImg;
	}

	public JButton getBtnMapImg() {
		return btnMapImg;
	}

	public JButton getBtnRegistration() {
		return btnRegistration;
	}

	public String getImgURL1() {
		return imgURL1;
	}

	public String getImgURL2() {
		return imgURL2;
	}

	public JLabel getLblImg1() {
		return lblImg1;
	}

	public JLabel getLblImg2() {
		return lblImg2;
	}

	public void setIiRestaurantImg(ImageIcon iiRestaurantImg) {
		this.iiRestaurantImg = iiRestaurantImg;
	}

	public JButton getBtnMenuegistration() {
		return btnMenuegistration;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public JButton getBtnCc() {
		return btnCc;
	}

	public ImageIcon getIiRestaurantImg() {
		return iiRestaurantImg;
	}

	public ImageIcon getIiMapImg() {
		return iiMapImg;
	}

	public JTable getjMenuTable() {
		return jMenuTable;
	}

	public JTextArea getTaIntro() {
		return taIntro;
	}

	public JTextField getTfName() {
		return tfName;
	}

	public JTextField getTfbNumber() {
		return tfbNumber;
	}

	public JTextField getTfCeo() {
		return tfCeo;
	}

	public JTextField getTfAddr() {
		return tfAddr;
	}

	public JTextField getTfCustomerTransaction() {
		return tfCustomerTransaction;
	}

	public JTextField getTfTel() {
		return tfTel;
	}

	public JComboBox<String> getCbFoodCategory() {
		return cbFoodCategory;
	}

	public DefaultTableModel getDtmMenu() {
		return dtmMenu;
	}

	public String getId() {
		return id;
	}

	public JButton getBtnNewMenu() {
		return btnNewMenu;
	}
	

}// class
