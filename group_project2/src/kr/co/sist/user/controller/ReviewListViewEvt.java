package kr.co.sist.user.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import kr.co.sist.user.dao.ReviewDAO;
import kr.co.sist.user.view.ReviewContentsView;
import kr.co.sist.user.view.ReviewListView;
import kr.co.sist.user.view.ReviewRegiView;
import kr.co.sist.user.vo.ReviewVO;

public class ReviewListViewEvt extends MouseAdapter implements ActionListener {
	ReviewListView rlv;
	String	rNum;
	String id;
	List<String> listRankRestNum,listRankReviewNum,listTodayRestNum,listTodayReviewNum;
	boolean flag=false;

	public ReviewListViewEvt(ReviewListView rlv) {
		this.rlv = rlv;
		id=rlv.getId();
		rNum=rlv.getrNum();
		searchRankReview(rNum);
		searchTodayReview(rNum);
	}

	private void searchTodayReview(String rNum) {
		listTodayRestNum=new ArrayList<>();
		listTodayReviewNum=new ArrayList<>();
		List<ReviewVO> reviewList=null;
		ReviewDAO r_dao= ReviewDAO.getInstance();
		try {
			reviewList=r_dao.selectTodayReview(rNum);
			ReviewVO rvo=null;
			Object[] rowData = null;
			DefaultTableModel dtm=rlv.getTodayReviewDtm();
			dtm.setRowCount(0);
			for(int i=0;i<reviewList.size();i++) {
				rvo=reviewList.get(i);
				rowData = new Object[3];
				rowData[0] = rvo.getId();
				rowData[1] = rvo.getReview_title();
				rowData[2] = rvo.getLike_number();
				String restNum=rvo.getRestaurant_number();
				String reviewNum=rvo.getReview_number();
				listTodayRestNum.add(restNum);
				listTodayReviewNum.add(reviewNum);
				
				dtm.addRow(rowData);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void searchRankReview(String rNum) {
		listRankRestNum=new ArrayList<>();
		listRankReviewNum=new ArrayList<>();
		List<ReviewVO> reviewList=null;
		ReviewDAO r_dao= ReviewDAO.getInstance();
		try {
			reviewList=r_dao.selectRankReview(rNum);
			ReviewVO rvo=null;
			Object[] rowData = null;
			DefaultTableModel dtm1=rlv.getRankReviewDtm();
			dtm1.setRowCount(0);
			for(int i=0;i<reviewList.size();i++) {
				rvo=reviewList.get(i);
				rowData = new Object[3];
				rowData[0] = rvo.getId();
				rowData[1] = rvo.getReview_title();
				rowData[2] = rvo.getLike_number();
				String restNum=rvo.getRestaurant_number();
				String reviewNum=rvo.getReview_number();
				listRankRestNum.add(restNum);
				listRankReviewNum.add(reviewNum);
				
				dtm1.addRow(rowData);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rlv.getBtnAddReview()) {//리뷰등록 버튼이 눌렸을때 리뷰를 등록한다(rNum에 대해 등록,id값으로)
			addReview(rNum,id);
		}
		if (e.getSource() == rlv.getBtnViewReview()) {//리뷰 보기
			int row=0;
			String rNum="";
			String riNum="";
			if(flag) {
				row = rlv.getTodayReviewTable().getSelectedRow();
				rNum=listTodayRestNum.get(row);
				riNum=listTodayReviewNum.get(row);
			}else {
				row = rlv.getRankReviewTable().getSelectedRow();
				rNum=listRankRestNum.get(row);
				riNum=listRankReviewNum.get(row);
			}
			viewReview(rNum,riNum);
		}
		if (e.getSource() == rlv.getBtnClose()) {//닫기 버튼
			rlv.dispose();
		}
		if(e.getSource()==rlv.getBtnNewReview()) { // 새로고침 버튼
			searchRankReview(rNum);
			searchTodayReview(rNum);
		}

	}

	


		

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == rlv.getTodayReviewTable()) {
			rlv.getTodayReviewTable().requestFocus(false);
			rlv.getTodayReviewTable().setSelectionBackground(Color.CYAN);
			rlv.getRankReviewTable().setSelectionBackground(Color.WHITE);
			flag=true;
		} else {
			rlv.getRankReviewTable().requestFocus(false);
			rlv.getRankReviewTable().setSelectionBackground(Color.CYAN);
			rlv.getTodayReviewTable().setSelectionBackground(Color.WHITE);
		}
	}

	public void addReview(String rNum, String id) {
		new ReviewRegiView(rNum,id);
	}

	public void viewReview(String rNum, String riNum) {
		new ReviewContentsView(rNum,riNum);
	}

	
}
