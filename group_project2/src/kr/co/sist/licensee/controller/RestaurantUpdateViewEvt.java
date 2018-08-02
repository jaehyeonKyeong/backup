package kr.co.sist.licensee.controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.licensee.dao.RestaurantUpdateDAO;
import kr.co.sist.licensee.view.MenuChangeView;
import kr.co.sist.licensee.view.MenuRegistrationView;
import kr.co.sist.licensee.view.RestaurantUpdateView;
import kr.co.sist.licensee.vo.MenuVO;
import kr.co.sist.licensee.vo.RestaurantSelectVO;
import kr.co.sist.licensee.vo.RestaurantUpdateVO;

public class RestaurantUpdateViewEvt implements ActionListener {
	private RestaurantUpdateView ruv;
	private String rNum, imgDirName, imgFileName, mapDirName, mapFileName;
	List<String> menuNamelist;

	public RestaurantUpdateViewEvt(RestaurantUpdateView ruv) {
		this.ruv = ruv;
		// 수정버튼이 눌렸을때 JTable에 있는 식당의 식당번호를 가지고 DB에서 정보를 조회하는 일.
		rNum = ruv.getrNum();
		selectRestaurantData(rNum);

	}// RestaurantUpdateViewEvt

	private void selectRestaurantData(String rNum) { // 수정버튼이 눌렸을때 JTable에 있는 식당의 식당번호를 가지고 DB에서 정보를 조회하는 일.
		RestaurantUpdateDAO ru_dao = RestaurantUpdateDAO.getInstance();
		RestaurantSelectVO rsvo = null;
		List<MenuVO> menuList = null;
		try {
			rsvo = ru_dao.selectRestaurant(rNum);
			menuList = rsvo.getMenuList();
			MenuVO mv = null;
			Object[] rowData = null;
			DefaultTableModel dtm = ruv.getDtmMenu();
			dtm.setRowCount(0);
			menuNamelist = new ArrayList<>();
			for (int i = 0; i < menuList.size(); i++) {
				mv = menuList.get(i);
				rowData = new Object[2];
				rowData[0] = mv.getMenuName();
				rowData[1] = mv.getMenuPrice();

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

			imgDirName = r_img.getDirectory();
			imgFileName = r_img.getFile();
			ruv.getLblImg1().setIcon(new ImageIcon(imgDirName + imgFileName));

			System.out.println(imgDirName + imgFileName);

		} // end if

		// 지도이미지
		if (ae.getSource() == ruv.getBtnMapImg()) {
			FileDialog m_img = new FileDialog(ruv, "Open", FileDialog.LOAD);
			m_img.setVisible(true);

			mapDirName = m_img.getDirectory();
			mapFileName = m_img.getFile();
			ruv.getLblImg2().setIcon(new ImageIcon(mapDirName + mapFileName));
			System.out.println(mapDirName + mapFileName);

		} // end if

		// 식당수정버튼
		if (ae.getSource() == ruv.getBtnChange()) {
			RestaurantUpdateVO ruvo = null;
			switch (JOptionPane.showConfirmDialog(ruv, "식당을 수정 하시겠습니까?")) {
			case JOptionPane.OK_OPTION:
				ruvo = new RestaurantUpdateVO(imgDirName + imgFileName, mapDirName + mapFileName,
						ruv.getTfName().getText(), ruv.getTfbNumber().getText(), ruv.getTfCeo().getText(),
						ruv.getTfAddr().getText(), ruv.getTfCustomerTransaction().getText(), ruv.getTfTel().getText(),
						ruv.getTaIntro().getText(), ruv.getCbFoodCategory().getSelectedIndex()+1);
				System.out.println("------"+ruvo.getFoodCategory());
				restaurantChange(rNum, ruvo);
			}
		} // end if

		// 메뉴수정버튼
		if (ae.getSource() == ruv.getBtnMenuChange()) {
			try {
				new MenuChangeView(rNum, menuNamelist.get(ruv.getjMenuTable().getSelectedRow()));
			} catch (ArrayIndexOutOfBoundsException aioobe) {
				JOptionPane.showMessageDialog(ruv, "메뉴를 선택해주세요!", "선택해주세요!", JOptionPane.WARNING_MESSAGE);
				aioobe.printStackTrace();
			} catch (IndexOutOfBoundsException ioobe) {
				JOptionPane.showMessageDialog(ruv, "죄송해요!ㅠ 새로고침버튼을 누르고 다시 시도해주세요", "다시시도해주세요!",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} // end if

		// 메뉴삭제버튼
		if (ae.getSource() == ruv.getBtnMenuDelete()) {
			// TODO
			switch (JOptionPane.showConfirmDialog(ruv, "정말로 삭제하실건가요?")) {
			case JOptionPane.OK_OPTION:
				try {
					removeMenu(rNum, menuNamelist.get(ruv.getjMenuTable().getSelectedRow()));
				} catch (IndexOutOfBoundsException ioobe) {
					JOptionPane.showMessageDialog(ruv, "죄송해요!ㅠ 새로고침버튼을 누르고 다시 시도해주세요", "다시시도해주세요!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		} // end if

		// 확인버튼
		if (ae.getSource() == ruv.getBtnOk()) {
			switch (JOptionPane.showConfirmDialog(ruv, "이대로 등록 하시겠습니까?")) {
			case JOptionPane.OK_OPTION:
				ruv.dispose();
			}
		} // end if

		// 취소버튼
		if (ae.getSource() == ruv.getBtnCc()) {
			ruv.dispose();
		} // end if
		if (ae.getSource() == ruv.getBtnNewMenu()) {
			RestaurantUpdateDAO ru_dao = RestaurantUpdateDAO.getInstance();
			RestaurantSelectVO rsvo = null;
			List<MenuVO> menuList = null;
			try {
				rsvo = ru_dao.selectRestaurant(rNum);
				menuList = rsvo.getMenuList();
				MenuVO mv = null;
				Object[] rowData = null;
				DefaultTableModel dtm = ruv.getDtmMenu();
				dtm.setRowCount(0);
				menuNamelist = new ArrayList<>();
				for (int i = 0; i < menuList.size(); i++) {
					mv = menuList.get(i);
					rowData = new Object[2];
					rowData[0] = mv.getMenuName();
					rowData[1] = mv.getMenuPrice();
					menuNamelist.add(mv.getMenuName());

					dtm.addRow(rowData);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ae.getSource() == ruv.getBtnMenuAdd()) {
			new MenuRegistrationView(rNum, ruv);
		}
	}// actionPerformed

	// 수정버튼을 누르면 레스토랑을 업데이트 한다
	private void restaurantChange(String rNum, RestaurantUpdateVO ruvo) {
		RestaurantUpdateDAO ru_dao = RestaurantUpdateDAO.getInstance();
		try {
			ru_dao.updateRestaurnat(rNum, ruvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(ruv, "수정이 완료되었어요!\n 새로고침버튼을 눌러주세요", "완료", JOptionPane.INFORMATION_MESSAGE);
	}

	// 식당내용 불러오기
	public void setRestaurant(String rNumber) {

		RestaurantUpdateDAO ru_dao = RestaurantUpdateDAO.getInstance();
		try {
			List<RestaurantSelectVO> list = (List<RestaurantSelectVO>) ru_dao.selectRestaurant(rNumber);
			Object[] rowData = null;
			RestaurantSelectVO tv = null;

			String rImg = tv.getrImg();
			String mapImg = tv.getMapImg();
			String rName = tv.getrName().trim();
			String bNumber = tv.getbNumber().trim();
			String cName = tv.getcName().trim();
			String rAddr = tv.getrAddr().trim();
			String cPrice = tv.getcPrice().trim();
			String rTel = tv.getrTel().trim();
			String rIntro = tv.getrIntro().trim();
			int foodCategory = tv.getFoodCategory()-1;

			tv = new RestaurantSelectVO(rImg, mapImg, rName, bNumber, cName, rAddr, cPrice, rTel, rIntro, foodCategory);
			ruv.getTfName().setText(tv.getrName());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return;

	}// selectRestaurant

	private void msgCenter(String msg) {
		JOptionPane.showMessageDialog(ruv, msg);
	}// msgCenter

	// 메뉴삭제
	private void removeMenu(String rNum, String mName) {
		// TODO
		RestaurantUpdateDAO ru_dao = RestaurantUpdateDAO.getInstance();
		try {
			ru_dao.deleteMenu(rNum, mName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(ruv, "삭제가 끝났어요\n새로고침 버튼을 눌러주세요!", "완료!", JOptionPane.INFORMATION_MESSAGE);

	}

	public RestaurantUpdateView getRuv() {
		return ruv;
	}

	public String getrNum() {
		return rNum;
	}

	public String getImgDirName() {
		return imgDirName;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public String getMapDirName() {
		return mapDirName;
	}

	public String getMapFileName() {
		return mapFileName;
	}

	public List<String> getMenuNamelist() {
		return menuNamelist;
	}

}// class
