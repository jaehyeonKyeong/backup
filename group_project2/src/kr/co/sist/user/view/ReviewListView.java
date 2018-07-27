package kr.co.sist.user.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	JButton btnAddReview, btnViewReview, btnClose;

	public ReviewListView() {
		super("리뷰 목록");
		todayReviewTable=new JTable();
		rankReviewTable=new JTable();
		
		
		btnAddReview=new JButton("리뷰 등록");
		btnViewReview=new JButton("보기");
		btnClose=new JButton("닫기");
		
		JLabel lblTodayReview=new JLabel("오늘 등록된 리뷰");
		JLabel lblThumbsReview=new JLabel("추천 많이받은 리뷰");
		
		//table
		String[] todayTitle= {"ID","리뷰제목","추천수"};
		String[][] todayData= {
				{"ssong1","식당1의 최고","11"},{"gang1","식당1의 최악","11"},{"btt3","식당1의 평범","11"},{"honey4","식당1의 리뷰","22"}
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
				{"ssong1","최고다","1231"},{"gang1","그저그럼","1100"},{"btt3"," 평범","441"},{"honey4","리뷰당","222"}
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
		btnAddReview.setBounds(90,245,100,30);
		btnViewReview.setBounds(200,245,100,30);
		btnClose.setBounds(310,245,100,30);
		
		
		
		//add
		add(lblTodayReview);
		add(scrollTodayReview);
		add(lblThumbsReview);
		add(scrollrankReview);
		add(btnAddReview);
		add(btnViewReview);
		add(btnClose);
		
		ReviewListViewEvt rlve=new ReviewListViewEvt(this);
		btnAddReview.addActionListener(rlve);
		btnClose.addActionListener(rlve);
		btnViewReview.addActionListener(rlve);
		todayReviewTable.addMouseListener(rlve);
		rankReviewTable.addMouseListener(rlve);
		
		setLayout(null);
		setBounds(400,100,500,350);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new ReviewListView();
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
