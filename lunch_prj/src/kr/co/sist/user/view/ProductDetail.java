package kr.co.sist.user.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import kr.co.sist.user.evt.ProductDetailEvt;
import kr.co.sist.user.vo.LunchDetailVO;

@SuppressWarnings("serial")
public class ProductDetail extends JFrame {

	private JTextField tfLunch_code, tfPrd_name, tfPrice, tfName, tfPhone, tfAddress, tfTotal_price;
	private JTextArea taPrd_info;
	private JComboBox<Integer> cbQuantity;
	private JButton btnOrder, btnClose;

	public ProductDetail(LunchDetailVO ldv) {
		super("상세화면");
		JLabel lblImg = new JLabel();
		ImageIcon icon_img;

		icon_img = new ImageIcon("C:/dev/workspace/lunch_prj/src/kr/co/sist/user/img/"+ldv.getImg());
		lblImg = new JLabel(icon_img);

		JLabel lblLunch_code = new JLabel("코드");
		JLabel lblPrd_name = new JLabel("이름");
		JLabel lblPrd_info = new JLabel("설명");
		JLabel lblPrice = new JLabel("가격");
		JLabel lblName = new JLabel("이름");
		JLabel lblPhone = new JLabel("전화번호");
		JLabel lblAddress = new JLabel("주소");
		JLabel lblQuantity = new JLabel("수량");
		JLabel lblTotal_price = new JLabel("총주문가격");
		
		tfLunch_code = new JTextField(ldv.getLunch_code(),20);
		tfPrd_name = new JTextField(ldv.getPrdName(),20);
		tfPrice = new JTextField(String.valueOf(ldv.getPrice()),20);
		
		tfLunch_code.setEditable(false); //수정x
		tfPrd_name.setEditable(false);
		tfPrice.setEditable(false);
		
		tfName = new JTextField(10);
		tfPhone = new JTextField(15);
		tfAddress = new JTextField(40);
		tfTotal_price = new JTextField(String.valueOf(ldv.getPrice())+"원",10);
		tfTotal_price.setEditable(false);
		
		
		taPrd_info = new JTextArea(ldv.getPrdInfo(), 5, 20);
		taPrd_info.setEditable(false);
		
		JScrollPane jsp = new JScrollPane(taPrd_info);
		Integer[] temp = { 1,2,3,4,5,6,7,8,9 };
		
		cbQuantity = new JComboBox<Integer>(temp);
		btnOrder = new JButton("주문");
		btnClose = new JButton("닫기");

		JPanel panelPrd = new JPanel();
		JPanel panelPrd_1 = new JPanel();
		JPanel panelPrd_2 = new JPanel();
		JPanel panelOrderer = new JPanel();

		JPanel panelPrd_1_grid = new JPanel();

		JPanel panelOrderer_flow1 = new JPanel();
		JPanel panelOrderer_flow2 = new JPanel();
		JPanel panelOrderer_flow3 = new JPanel();
		JPanel panelOrderer_flow4 = new JPanel();
		JPanel panelPrd_flow1 = new JPanel();
		JPanel panelPrd_flow2 = new JPanel();
		JPanel panelPrd_flow3 = new JPanel();

		panelPrd.setLayout(new GridLayout(1, 1));
		panelPrd_1.setLayout(new GridLayout(1, 1));
		panelPrd_2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelPrd_1_grid.setLayout(new GridLayout(3, 1));
		panelOrderer.setLayout(new GridLayout(4, 1));

		panelOrderer_flow1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelOrderer_flow2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelOrderer_flow3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelOrderer_flow4.setLayout(new FlowLayout());
		
		panelPrd_flow1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelPrd_flow1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelPrd_flow3.setLayout(new FlowLayout(FlowLayout.LEFT));

		panelPrd_flow1.add(lblLunch_code);
		panelPrd_flow1.add(tfLunch_code);
		panelPrd_flow2.add(lblPrd_name);
		panelPrd_flow2.add(tfPrd_name);
		panelPrd_flow3.add(lblPrice);
		panelPrd_flow3.add(tfPrice);

		panelPrd_1_grid.add(panelPrd_flow1);
		panelPrd_1_grid.add(panelPrd_flow2);
		panelPrd_1_grid.add(panelPrd_flow3);
		
		panelPrd_2.add(panelPrd_1_grid);
		panelPrd_2.add(lblPrd_info);
		panelPrd_2.add(jsp);

		panelPrd_1.add(lblImg);

		panelPrd.add(panelPrd_1);
		panelPrd.add(panelPrd_2);

		panelOrderer_flow1.add(lblName);
		panelOrderer_flow1.add(tfName);
		panelOrderer_flow1.add(lblPhone);
		panelOrderer_flow1.add(tfPhone);
		panelOrderer_flow2.add(lblAddress);
		panelOrderer_flow2.add(tfAddress);
		panelOrderer_flow3.add(lblQuantity);
		panelOrderer_flow3.add(cbQuantity);
		panelOrderer_flow3.add(lblTotal_price);
		panelOrderer_flow3.add(tfTotal_price);

		panelOrderer.add(panelOrderer_flow1);
		panelOrderer.add(panelOrderer_flow2);
		panelOrderer.add(panelOrderer_flow3);
		panelOrderer.add(panelOrderer_flow4);

		panelOrderer_flow4.add(btnOrder);
		panelOrderer_flow4.add(btnClose);

		panelOrderer.setBorder(new TitledBorder("주문자정보"));

		add("North", panelPrd);
		add("Center", panelPrd_2);
		add("South", panelOrderer);
		
		//이벤트 객체 생성
		ProductDetailEvt pde=new ProductDetailEvt(this);
		btnOrder.addActionListener(pde);
		btnClose.addActionListener(pde);
		cbQuantity.addItemListener(pde);
		
		setBounds(100, 100, 600, 660);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}// windowClosing
		});
		
		setVisible(true);
		setResizable(false);
		
		tfName.requestFocus();

	}// order_detail

	
	
	public JTextField getTfLunch_code() {
		return tfLunch_code;
	}

	public JTextField getTfPrd_name() {
		return tfPrd_name;
	}

	public JTextField getTfPrice() {
		return tfPrice;
	}

	public JTextField getTfName() {
		return tfName;
	}

	public JTextField getTfPhone() {
		return tfPhone;
	}

	public JTextField getTfAddress() {
		return tfAddress;
	}

	public JTextField getTfTotal_price() {
		return tfTotal_price;
	}

	public JTextArea getTaPrd_info() {
		return taPrd_info;
	}

	public JComboBox<Integer> getCbQuantity() {
		return cbQuantity;
	}

	public JButton getBtnOrder() {
		return btnOrder;
	}

	public JButton getBtnClose() {
		return btnClose;
	}

	
	
	
	
}// class


