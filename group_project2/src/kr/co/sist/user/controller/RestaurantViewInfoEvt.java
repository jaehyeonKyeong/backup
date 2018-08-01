package kr.co.sist.user.controller;

import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.ListView;

import kr.co.sist.user.dao.RestaurantDetailDAO;
import kr.co.sist.user.view.RestaurantMapView;
import kr.co.sist.user.view.RestaurantViewInfo;
import kr.co.sist.user.view.ReviewListView;
import kr.co.sist.user.vo.MenuSearchVO;
import kr.co.sist.user.vo.RestaurantDetailVO;

public class RestaurantViewInfoEvt implements ActionListener {
	private RestaurantViewInfo rvi;
	private String rNum;
	private String id;

	public RestaurantViewInfoEvt(RestaurantViewInfo rvi) {
		this.rvi = rvi;
		rNum=rvi.getRNum();
		id=rvi.getId();
		RestaurantDetailView(rNum,id);
	}

	private void RestaurantDetailView(String rNum, String id) {// restaurantViewInfo에 rNum에 대한 모든 정보를 띄어주는 일
		RestaurantDetailDAO rd_dao = RestaurantDetailDAO.getInstance();
		RestaurantDetailVO rdVO = null;
		List<MenuSearchVO> menuList = null;
		try {
			rdVO = rd_dao.selectAllRestaurantDetail(rNum);
			DefaultTableModel dtm=rvi.getDtm();
			dtm.setRowCount(0);
			menuList = rdVO.getListMenu();
			Object[] rowData = null;
			MenuSearchVO mv=null;
			for (int i = 0; i < menuList.size(); i++) {
				mv=menuList.get(i);
				rowData = new Object[3];
				rowData[0] = mv.getMenuName();
				rowData[1] = mv.getIntro();
				rowData[2] = mv.getPrice();
				
				dtm.addRow(rowData);
			}
			rvi.getLblRestaurantName().setText(rdVO.getrName());
			rvi.getTaRestaurantInfo().setText(rdVO.getrInfo());
			rvi.setVisible(true);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch (NullPointerException npe) {
			JOptionPane.showMessageDialog(rvi, "죄송합니다.현재 식당이 준비중에 있습니다.", "죄송해요 ㅠㅠ", JOptionPane.INFORMATION_MESSAGE);
			rvi.dispose();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rvi.getBtnReport()) {
			reportCenter(rvi.getRNum());
		}
		if (e.getSource() == rvi.getBtnMapView()) {
			restaurantMapView();
		}
		if (e.getSource() == rvi.getBtnReviewListView()) {
			reviewView();
		}
	}

	public void reportCenter(String rNum) {
		switch (JOptionPane.showConfirmDialog(rvi, "신고하시겠습니까?", "신고하기", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE)) {
		case JOptionPane.OK_OPTION:
			int cnt=restaurantReportSearchFlag(rNum);
			if(cnt==0) { //신고테이블에 신고된게 하나도 없다면
				//최초 신고 insert
				insertFirstReport(rNum);
			}else {
				updateReport(rNum,++cnt);
			}
		}
	}

	private void updateReport(String rNum, int cnt) {
		RestaurantDetailDAO rd_dao=RestaurantDetailDAO.getInstance();
		try {
			rd_dao.updateReport(rNum,cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(rvi, "신고가 반영되었습니다.", "완료", JOptionPane.INFORMATION_MESSAGE);
	}

	private void insertFirstReport(String rNum) {
		RestaurantDetailDAO rd_dao=RestaurantDetailDAO.getInstance();
		try {
			rd_dao.insertReport(rNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(rvi, "처음신고되었습니다", "완료", JOptionPane.INFORMATION_MESSAGE);
	}

	//신고테이블을 조회하여 신고가 있다면  cnt를 반환 없다면 0을 반환함
	private int restaurantReportSearchFlag(String rNum) { 
		int reportCnt=0;
		
		RestaurantDetailDAO rd_dao=RestaurantDetailDAO.getInstance();
		try {
			reportCnt=rd_dao.selectRestaurantReport(rNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reportCnt;
	}
	

	public void restaurantMapView() {
		new RestaurantMapView();
	}

	public void reviewView() {
		new ReviewListView(rNum,id);
	}

}
