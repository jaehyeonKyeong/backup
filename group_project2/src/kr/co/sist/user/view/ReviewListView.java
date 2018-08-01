package kr.co.sist.user.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.user.controller.ReviewListViewEvt;

@SuppressWarnings("serial")
public class ReviewListView extends JFrame {
	RestaurantViewInfo rvi;
	DefaultTableModel todayReviewDtm, rankReviewDtm;
	JTable todayReviewTable, rankReviewTable;
	JButton btnAddReview, btnViewReview, btnClose,btnNewReview;
	private JPanel panel;
	private Color b_Color=new Color(0,100,121);
	String rNum,id;

	
	

	public JButton getBtnNewReview() {
		return btnNewReview;
	}


	public JPanel getPanel() {
		return panel;
	}


	public Color getB_Color() {
		return b_Color;
	}


	public String getrNum() {
		return rNum;
	}


	public String getId() {
		return id;
	}


	public ReviewListView(String rNum, String id) {
		super(":::리뷰 목록:::");
		todayReviewTable=new JTable();
		rankReviewTable=new JTable();
		this.rNum=rNum;
		this.id=id;
		
		
		btnAddReview=new JButton("리뷰 등록");
		btnViewReview=new JButton("보기");
		btnClose=new JButton("닫기");
		panel=new JPanel();
		btnNewReview=new JButton("새로고침");
		
		
		JLabel lblTodayReview=new JLabel("오늘 등록된 리뷰");
		JLabel lblThumbsReview=new JLabel("추천 많이받은 리뷰");
		
		
		
		//table
		String[] todayTitle= {"ID","리뷰제목","추천수"};
		String[][] todayData= {
				{"","",""}
		};
		
		todayReviewDtm=new DefaultTableModel(todayTitle, todayData.length) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		todayReviewTable=new JTable(todayReviewDtm);
		//table에 데이터 추가
		for(int i=0;i<todayData.length;i++) {
			for(int j=0;j<todayData[i].length;j++) {
				todayReviewTable.setValueAt(todayData[i][j], i,j);
			}
		}
		todayReviewTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		String[] ThumbsTitle= {"ID","리뷰제목","추천수"};
		String[][] ThumbsData= {
				{"","",""}
			};
		
		rankReviewDtm=new DefaultTableModel(ThumbsTitle, ThumbsData.length) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		rankReviewTable=new JTable(rankReviewDtm);
		for(int i=0;i<ThumbsData.length;i++) {
			for(int j=0;j<ThumbsData[i].length;j++) {
				rankReviewTable.setValueAt(ThumbsData[i][j], i,j);
			}
		}
		rankReviewTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //table record 단일선택
		
		
		//scroll
		JScrollPane scrollTodayReview=new JScrollPane(todayReviewTable);
		JScrollPane scrollrankReview=new JScrollPane(rankReviewTable);
		
		todayReviewTable.getTableHeader().setReorderingAllowed(false);
		rankReviewTable.getTableHeader().setReorderingAllowed(false);
		
		
		//setBounds
		lblTodayReview.setBounds(25,15,450,20);
		scrollTodayReview.setBounds(25,40,450,85);
		lblThumbsReview.setBounds(25,130,450,20);
		scrollrankReview.setBounds(25,150,450,85);
		btnAddReview.setBounds(40,245,100,30);
		btnViewReview.setBounds(145,245,100,30);
		btnClose.setBounds(250,245,100,30);
		btnNewReview.setBounds(355,245,100,30);
		panel.setBounds(0,0,500,360);
		
		
		
		//add
		add(lblTodayReview);
		add(scrollTodayReview);
		add(lblThumbsReview);
		add(scrollrankReview);
		add(btnAddReview);
		add(btnViewReview);
		add(btnClose);
		add(btnNewReview);
		add(panel);
		
		panel.setBackground(Color.WHITE);
		btnAddReview.setBackground(b_Color);
		btnViewReview.setBackground(b_Color);
		btnClose.setBackground(b_Color);
		
		btnAddReview.setFont(new Font("SanSerif",Font.BOLD,15));
		btnViewReview.setFont(new Font("SanSerif",Font.BOLD,15));
		btnClose.setFont(new Font("SanSerif",Font.BOLD,15));
		btnAddReview.setForeground(Color.WHITE);
		btnViewReview.setForeground(Color.WHITE);
		btnClose.setForeground(Color.WHITE);
		
		btnAddReview.setBorderPainted(false);
		btnViewReview.setBorderPainted(false);
		btnClose.setBorderPainted(false);
		
		
		
		
		ReviewListViewEvt rlve=new ReviewListViewEvt(this);
		btnAddReview.addActionListener(rlve);
		btnClose.addActionListener(rlve);
		btnViewReview.addActionListener(rlve);
		btnNewReview.addActionListener(rlve);
		todayReviewTable.addMouseListener(rlve);
		rankReviewTable.addMouseListener(rlve);
		
		setLayout(null);
		setBounds(400,100,500,360);
		setVisible(true);
		
	}


	public RestaurantViewInfo getRvi() {
		return rvi;
	}

	public DefaultTableModel getTodayReviewDtm() {
		return todayReviewDtm;
	}

	public DefaultTableModel getRankReviewDtm() {
		return rankReviewDtm;
	}

	public JTable getTodayReviewTable() {
		return todayReviewTable;
	}

	public JTable getRankReviewTable() {
		return rankReviewTable;
	}

	public JButton getBtnAddReview() {
		return btnAddReview;
	}

	public JButton getBtnViewReview() {
		return btnViewReview;
	}

	public JButton getBtnClose() {
		return btnClose;
	}
	
}
