package kr.co.sist.user.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GrayFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.user.controller.RestaurantViewInfoEvt;

public class RestaurantViewInfo extends JFrame{
	private JButton btnMapView,btnReviewListView,btnReport;
	private JTable tableMenuView;
	private DefaultTableModel dtm;
	private ImageIcon restaurantImg;
	private JTextArea taRestaurantInfo;
	private JLabel lblRestaurantName,lblGrade;
	private RestaurantSearchView rsv;
	private String rNum;
	
	public RestaurantViewInfo(String rNum)  {
		super("식당");
		this.rNum=rNum;
		setLayout(null);
		ImageIcon imgLogo=new ImageIcon("C:/dev/workspace/group_project2/src/kr/co/sist/user/view/images/logo (3).jpg");
		JLabel lblLogo=new JLabel();
		btnMapView=new JButton("식당 위치");
		btnReviewListView=new JButton("식당 리뷰 보기");
		btnReport=new JButton("신고하기");
		lblGrade=new JLabel("평점 ★★★★★");
		lblRestaurantName=new JLabel("송램지 식당");
		taRestaurantInfo=new JTextArea("세계최고의 셰프\n 송램지의 식당에서 최상의 맛을\n 즐겨보세요\n 美味!");
		taRestaurantInfo.setEditable(false);
		taRestaurantInfo.setBackground(new Color(0xf3, 0xf3, 0xf3));
		JScrollPane scroll=new JScrollPane(taRestaurantInfo);
		String[] title= {"메뉴","소개","가격"};
		String[][] data= {{"불닭","불맛","15000"},{"치즈불닭","치즈불맛","20000"},{"물닭","물맛","14000"}};
		dtm=new DefaultTableModel(title, 3) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		tableMenuView=new JTable(dtm);
		for(int i=0;i<data.length;i++) {
			for(int j=0;j<data[i].length;j++) {
				tableMenuView.setValueAt(data[i][j], i, j);
			}
		}
		tableMenuView.getTableHeader().setReorderingAllowed(false);
		JScrollPane tableScroll=new JScrollPane(tableMenuView);
		
		lblLogo.setIcon(imgLogo);
		tableMenuView=new JTable();
		restaurantImg=new ImageIcon("C:/dev/workspace/group_project2/src/kr/co/sist/user/view/images/restaurant.jpg");
		JLabel lblRestaurantimg=new JLabel(restaurantImg);
		
		
		
		lblRestaurantName.setBounds(220,30,100,20);
		btnReport.setBounds(480,20,100,25);
		scroll.setBounds(200,55,200,200);
		btnMapView.setBounds(420,115,120,25);
		btnReviewListView.setBounds(420,145,120,25);
		tableScroll.setBounds(25,280,500,70);
		lblLogo.setBounds(25,5,45,45);
		lblRestaurantimg.setBounds(25, 55, 170, 200);
		
		lblRestaurantName.setFont(new Font("맑은 고딕", NORMAL, 18));
		
		add(lblRestaurantName);
		add(btnReport);
		add(scroll);
		add(btnMapView);
		add(btnReviewListView);
		add(tableScroll);
		add(lblLogo);
		add(lblRestaurantimg);
		
		
		setBounds(500,100,600,400);
	
		RestaurantViewInfoEvt rvie= new RestaurantViewInfoEvt(this);
		btnReport.addActionListener(rvie);
		btnMapView.addActionListener(rvie);
		btnReviewListView.addActionListener(rvie);
	}


	public JButton getBtnMapView() {
		return btnMapView;
	}

	public JButton getBtnReviewListView() {
		return btnReviewListView;
	}

	public JButton getBtnReport() {
		return btnReport;
	}

	public JTable getTableMenuView() {
		return tableMenuView;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public ImageIcon getRestaurantImg() {
		return restaurantImg;
	}

	public JTextArea getTaRestaurantInfo() {
		return taRestaurantInfo;
	}

	public JLabel getLblRestaurantName() {
		return lblRestaurantName;
	}

	public JLabel getLblGrade() {
		return lblGrade;
	}

	public RestaurantSearchView getRsv() {
		return rsv;
	}

	public String getRNum() {
		return rNum;
	}
	

}
