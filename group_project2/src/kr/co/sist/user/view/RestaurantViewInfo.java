package kr.co.sist.user.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
	private String rNum,id,imgFile;
	private JPanel panel;
	private Color b_Color=new Color(0,100,121);
	private Color t_Color = new Color(245, 247, 249);
	JLabel lblRestaurantimg;
	
	
	public JLabel getLblRestaurantimg() {
		return lblRestaurantimg;
	}


	public String getrNum() {
		return rNum;
	}


	public String getId() {
		return id;
	}


	public String getImgFile() {
		return imgFile;
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


	public RestaurantViewInfo(String rNum, String id, String imgFile)  {
		super(":::식당:::");
		this.rNum=rNum;
		this.id=id;
		this.imgFile=imgFile;
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
		panel=new JPanel();
		
		String[] title= {"메뉴","소개","가격"};
		String[][] data= {{"","",""}};
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
		lblRestaurantimg=new JLabel(restaurantImg);
		
		//tableMenuView.getTableHeader().setFont(new Font("SanSerif",Font.BOLD,13));
		//tableMenuView.getTableHeader().setBackground(t_Color);
		
		
		lblRestaurantName.setBounds(210,30,150,20);
		btnReport.setBounds(460,20,100,25);
		scroll.setBounds(200,55,200,200);
		btnMapView.setBounds(420,115,120,25);
		btnReviewListView.setBounds(420,145,120,25);
		tableScroll.setBounds(30,280,515,90);
		lblLogo.setBounds(25,5,45,45);
		lblRestaurantimg.setBounds(20, 55, 200, 200);
		panel.setBounds(0,0,600,450);
		
		lblRestaurantName.setFont(new Font("SanSerif", Font.BOLD, 12));
		
		add(lblRestaurantName);
		add(btnReport);
		add(scroll);
		add(btnMapView);
		add(btnReviewListView);
		add(tableScroll);
		add(lblLogo);
		add(lblRestaurantimg);
		add(panel);
		
		
		
		
		panel.setBackground(Color.white);
		
		btnReport.setBackground(b_Color);
		btnMapView.setBackground(b_Color);
		btnReviewListView.setBackground(b_Color);
		btnReport.setFont(new Font("SanSerif",Font.BOLD,14));
		btnMapView.setFont(new Font("SanSerif",Font.BOLD,14));
		btnReviewListView.setFont(new Font("SanSerif",Font.BOLD,12));
		btnReport.setForeground(Color.WHITE);
		btnMapView.setForeground(Color.WHITE);
		btnReviewListView.setForeground(Color.WHITE);
		btnReport.setBorderPainted(false);
		btnMapView.setBorderPainted(false);
		btnReviewListView.setBorderPainted(false);
		
		
		
		setBounds(500,100,600,450);
	
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
