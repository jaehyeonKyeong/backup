package kr.co.sist.licensee.controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.licensee.dao.RestaurantUpdateDAO;
import kr.co.sist.licensee.view.MenuChangeView;
import kr.co.sist.licensee.view.RestaurantUpdateView;
import kr.co.sist.licensee.vo.MenuVO;
import kr.co.sist.licensee.vo.RestaurantSelectVO;

public class RestaurantUpdateViewEvt implements ActionListener {
	private RestaurantUpdateView ruv;
	String rNum;

	public RestaurantUpdateViewEvt(RestaurantUpdateView ruv) {
		this.ruv = ruv;
		//수정버튼이 눌렸을때 JTable에 있는 식당의 식당번호를 가지고 DB에서 정보를 조회하는 일.
		rNum=ruv.getrNum();
		System.out.println("constrants"+rNum);
		selectRestaurantData(rNum);
		
	}// RestaurantUpdateViewEvt

	private void selectRestaurantData(String rNum) {		//수정버튼이 눌렸을때 JTable에 있는 식당의 식당번호를 가지고 DB에서 정보를 조회하는 일.
		RestaurantUpdateDAO ru_dao=RestaurantUpdateDAO.getInstance();
		RestaurantSelectVO rsvo=null;
		List<MenuVO> menuList=null;
		try {
			rsvo=ru_dao.selectRestaurant(rNum);
			menuList=rsvo.getMenuList();
			MenuVO mv=null;
			Object[] rowData=null;
			DefaultTableModel dtm=ruv.getDtmMenu();
			dtm.setRowCount(0);
			for(int i=0; i<menuList.size();i++) {
				mv=menuList.get(i);
				rowData=new Object[2];
				rowData[0]=mv.getMenuName();
				rowData[1]=mv.getMenuPrice();
				
				dtm.addRow(rowData);
			}
			ruv.getTfName().setText(rsvo.getrName());
			ruv.getTfbNumber().setText(rsvo.getbNumber());
			ruv.getTfCeo().setText(rsvo.getcName());
			ruv.getTfAddr().setText(rsvo.getrAddr());
			ruv.getTfCustomerTransaction().setText(rsvo.getcPrice());
			ruv.getTfTel().setText(rsvo.getrTel());
			ruv.getCbFoodCategory().setSelectedIndex(rsvo.getFoodCategory());
			ruv.getTaIntro().setText(rsvo.getrIntro());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// 텍스트필드
		if (ae.getSource() == ruv.getTfName()) {
			ruv.getTfbNumber().requestFocus();
		} // end if
		if (ae.getSource() == ruv.getTfbNumber()) {
			ruv.getTfCeo().requestFocus();
		} // end if
		if (ae.getSource() == ruv.getTfCeo()) {
			ruv.getTfAddr().requestFocus();
		} // end if
		if (ae.getSource() == ruv.getTfAddr()) {
			ruv.getTfCustomerTransaction().requestFocus();
		} // end if
		if (ae.getSource() == ruv.getTfCustomerTransaction()) {
			ruv.getTfTel().requestFocus();
		} // end if

		// 식당이미지
		if (ae.getSource() == ruv.getBtnAddImg()) {
			FileDialog r_img = new FileDialog(ruv, "Open", FileDialog.LOAD);
			r_img.setVisible(true);

			String DirName = r_img.getDirectory();
			String FileName = r_img.getFile();
			ruv.getLblImg1().setIcon(new ImageIcon(DirName + FileName));

			System.out.println(DirName + FileName);

		} // end if

		// 지도이미지
		if (ae.getSource() == ruv.getBtnMapImg()) {
			FileDialog m_img = new FileDialog(ruv, "Open", FileDialog.LOAD);
			m_img.setVisible(true);

			String DirName = m_img.getDirectory();
			String FileName = m_img.getFile();
			ruv.getLblImg2().setIcon(new ImageIcon(DirName + FileName));
			System.out.println(DirName + FileName);

		} // end if

		// 식당수정버튼
		if (ae.getSource() == ruv.getBtnChange()) {
			switch (JOptionPane.showConfirmDialog(ruv, "수정 하시겠습니까?")) {
			case JOptionPane.OK_OPTION:
				
			}
		} // end if

		// 메뉴수정버튼
		if (ae.getSource() == ruv.getBtnMenuChange()) {
			
			new MenuChangeView(rNum);

		} // end if

		// 메뉴삭제버튼
		if (ae.getSource() == ruv.getBtnMenuDelete()) {
			//removeMenu();

		} // end if

		// 확인버튼
		if (ae.getSource() == ruv.getBtnOk()) {
			switch (JOptionPane.showConfirmDialog(ruv, "등록 하시겠습니까?")) {
			case JOptionPane.OK_OPTION:
			}
		} // end if

		// 취소버튼
		if (ae.getSource() == ruv.getBtnCc()) {
			ruv.dispose();
		} // end if

	}// actionPerformed
	

	
	
	//식당내용 불러오기
	public void setRestaurant(String rNumber) {
		
		RestaurantUpdateDAO ru_dao=RestaurantUpdateDAO.getInstance();
		try {
			List<RestaurantSelectVO> list=(List<RestaurantSelectVO>) ru_dao.selectRestaurant(rNumber);
		Object[] rowData=null;
		RestaurantSelectVO tv=null;
		
		String rImg=tv.getrImg();
		String mapImg=tv.getMapImg();
		String rName=tv.getrName().trim();
		String bNumber=tv.getbNumber().trim();
		String cName=tv.getcName().trim();
		String rAddr=tv.getrAddr().trim();
		String cPrice=tv.getcPrice().trim();
		String rTel=tv.getrTel().trim();
		String rIntro=tv.getrIntro().trim();
		int foodCategory=tv.getFoodCategory();
		
		tv=new RestaurantSelectVO
				(rImg,mapImg,rName,bNumber,cName,rAddr,cPrice,rTel,rIntro,foodCategory);
		ruv.getTfName().setText(tv.getrName());
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return;
		
	}//selectRestaurant
	


	private void msgCenter(String msg) {
		JOptionPane.showMessageDialog(ruv, msg);
	}// msgCenter

	// 메뉴삭제
	private void removeMenu() throws SQLException {
		JTable menuTab = ruv.getjMenuTable();
		String menuName = (String) menuTab.getValueAt(menuTab.getSelectedRow(), 1);
		String menuPrice = (String) menuTab.getValueAt(menuTab.getSelectedRow(), 2);

		StringBuilder msg = new StringBuilder();
		msg.append("[").append(menuName).append("-").append(menuPrice).append("] 메뉴를 삭제하시겠습니까?");

		switch (JOptionPane.showConfirmDialog(ruv, msg)) {
		case JOptionPane.OK_OPTION:
			RestaurantUpdateDAO ru_dao = RestaurantUpdateDAO.getInstance();

			ru_dao.deleteMenu(menuPrice);
			msgCenter(menuName + "메뉴가 삭제 되었습니다.");

			// 테이블을 갱신한다.
		}// end switch
	}// removeMenu

}// class
