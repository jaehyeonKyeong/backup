package kr.co.sist.user.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.licensee.controller.FileClient;
import kr.co.sist.user.dao.RestaurantSearchDAO;
import kr.co.sist.user.view.RestaurantSearchView;
import kr.co.sist.user.view.RestaurantViewInfo;
import kr.co.sist.user.vo.RestaurantSearchVO;

public class RestaurantSearchViewEvt extends MouseAdapter implements ActionListener {
	RestaurantSearchView rsv;
	int categoriNum, orderbyNum;
	File file;
	
	List<String> listRNum;
	boolean flag = false;

	public RestaurantSearchViewEvt(RestaurantSearchView rsv) {
		this.rsv = rsv;
		selectAllRestaurant();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rsv.getBtnSearch() || e.getSource() == rsv.getTfSearch()) {
			searchRestaurant(rsv.getTfSearch().getText()); // 검색
		} // BtnSearch, tTfSearch.
		if (e.getSource() == rsv.getcBoxCategory()) {
			categoriNum = rsv.getcBoxCategory().getSelectedIndex() + 1;
			selectCategoryRestaurant(categoriNum);
			flag = true;
		}
		if (e.getSource() == rsv.getcBoxGrade()) {
			orderbyNum = rsv.getcBoxGrade().getSelectedIndex();
			if (!flag) {
				orderingRestaurant(orderbyNum);// 평점순 정렬
			} else {
				orderingRestaurant(orderbyNum, categoriNum);// 평점순 정렬
			}
		}
		if(e.getSource()==rsv.getBtnSelectAll()) {
			flag=false;
			selectAllRestaurant();
		}
	}// actionLisenter

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == rsv.getTable()) {
			if (e.getClickCount() == 2) {
				selectRestaurant();
			}
		}
	}// 마우스클릭

	private void searchRestaurant(String rName) {
		if ("".equals(rName)) {
			JOptionPane.showMessageDialog(rsv, "검색창에 식당을 검색해주세요", "검색", JOptionPane.ERROR_MESSAGE);
			return;
		}
		RestaurantSearchDAO rs_dao = RestaurantSearchDAO.getInstance();
		List<RestaurantSearchVO> list = null;
		try {
			list = rs_dao.searchValueRestaurant(rName);
			Object[] rowData = null;
			RestaurantSearchVO rv = null;

			
			// 주문현황을 보여줄 DefaultTableModel을 얻기
			DefaultTableModel dtm = rsv.getDtm();
			// dtm 초기화
			dtm.setRowCount(0);
			String rNum="";
			listRNum=new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				rv = list.get(i);
				rowData = new Object[2];
				rowData[0] = new ImageIcon(file.getAbsolutePath());
				rowData[1] = rv.getrName();
				rNum=rv.getrNum();
				
				dtm.addRow(rowData);
				listRNum.add(rNum);
			} // end for

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void orderingRestaurant(int itemNum) {
		RestaurantSearchDAO rs_dao = RestaurantSearchDAO.getInstance();
		List<RestaurantSearchVO> list = null;
		try {
			list = rs_dao.orderbyRestaurant(itemNum);
			Object[] rowData = null;
			RestaurantSearchVO rv = null;

			// 주문현황을 보여줄 DefaultTableModel을 얻기
			DefaultTableModel dtm = rsv.getDtm();
			// dtm 초기화
			dtm.setRowCount(0);
			String rNum="";
			listRNum=new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				rv = list.get(i);
				rowData = new Object[2];
				rowData[0] = new ImageIcon(file.getAbsolutePath());
				rowData[1] = rv.getrName();
				rNum=rv.getrNum();
				
				dtm.addRow(rowData);
				listRNum.add(rNum);
			} // end for

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void orderingRestaurant(int itemNum, int categoriNum) {
		RestaurantSearchDAO rs_dao = RestaurantSearchDAO.getInstance();
		List<RestaurantSearchVO> list = null;
		try {
			list = rs_dao.orderbyRestaurant(itemNum, categoriNum);
			Object[] rowData = null;
			RestaurantSearchVO rv = null;

			// 주문현황을 보여줄 DefaultTableModel을 얻기
			DefaultTableModel dtm = rsv.getDtm();
			// dtm 초기화
			dtm.setRowCount(0);
			String rNum="";
			listRNum=new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				rv = list.get(i);
				rowData = new Object[2];
				rowData[0] = new ImageIcon(file.getAbsolutePath());
				rowData[1] = rv.getrName();
				rNum=rv.getrNum();
				
				dtm.addRow(rowData);
				listRNum.add(rNum);
			} // end for

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void selectCategoryRestaurant(int itemNum) {
		RestaurantSearchDAO rs_dao = RestaurantSearchDAO.getInstance();
		List<RestaurantSearchVO> list = null;
		try {
			list = rs_dao.categoryCodeRestaurant(itemNum);
			Object[] rowData = null;
			RestaurantSearchVO rv = null;

			// 주문현황을 보여줄 DefaultTableModel을 얻기
			DefaultTableModel dtm = rsv.getDtm();
			// dtm 초기화
			dtm.setRowCount(0);
			String rNum="";
			listRNum=new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				rv = list.get(i);
				rowData = new Object[2];
				rowData[0] = new ImageIcon(file.getAbsolutePath());
				rowData[1] = rv.getrName();
				rNum=rv.getrNum();
				
				dtm.addRow(rowData);
				listRNum.add(rNum);
			} // end for

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void selectRestaurant() { //Restaurant선택했을때
		int row = rsv.getTable().getSelectedRow();
		String rNum=listRNum.get(row);
		new RestaurantViewInfo(rNum,rsv.getId(),file.getAbsolutePath());
	}
	private void selectAllRestaurant() { // 최초실행하였을때 모든 레스토랑을 보여준다
		RestaurantSearchDAO rs_dao = RestaurantSearchDAO.getInstance();
		List<RestaurantSearchVO> list = null;
		try {
			list = rs_dao.searchAllRestaurant();
			Object[] rowData = null;
			RestaurantSearchVO rv = null;

			// 주문현황을 보여줄 DefaultTableModel을 얻기
			DefaultTableModel dtm = rsv.getDtm();
			// dtm 초기화
			dtm.setRowCount(0);
			String rNum="";
			listRNum=new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				rv = list.get(i);
				//TODO
				FileClient fc=new FileClient();
				System.out.println("searchevt+++++"+rv.getrNum());
				String img="";
				try {
					img=fc.restaurantDownloadProcess(rv.getrNum());
					if(img!=null) {
						file=new File(img);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				rowData = new Object[2];
				if(file!=null) {
				rowData[0] = new ImageIcon(file.getAbsolutePath());
				}
				rowData[1] = rv.getrName();
				rNum=rv.getrNum();
				
				dtm.addRow(rowData);
				listRNum.add(rNum);
			} // end for

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}