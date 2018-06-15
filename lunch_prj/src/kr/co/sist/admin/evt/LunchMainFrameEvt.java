package kr.co.sist.admin.evt;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.admin.dao.LunchMainDAO;
import kr.co.sist.admin.util.ImageResize;
import kr.co.sist.admin.view.LunchMainFrame;
import kr.co.sist.admin.vo.LunchListVO;
import kr.co.sist.admin.vo.LunchVO;
import kr.co.sist.admin.vo.OrderListVO;

/**
 * 관리자 화면의 이벤트 처리와 업무 로직
 * 
 * @author owner
 */
public class LunchMainFrameEvt extends MouseAdapter implements ActionListener {

	public static final int TAB_ORDER = 0;
	public static final int TAB_LUNCH = 2;

	private LunchMainFrame lmf;

	public LunchMainFrameEvt(LunchMainFrame lmf) {
		this.lmf = lmf;
	}

	private boolean alertFlag;
	/**
	 * 오늘자에 대한 주문 현황을 조회하여 JTable에 설정
	 */
	public void setOrderList() {
		LunchMainDAO lm_dao = LunchMainDAO.getInstance();
		try {
			List<OrderListVO> list = lm_dao.selectTodayOrder();
			Object[] rowData = null;
			OrderListVO olv = null;

			// 주문현황을 보여줄 DefaultTableModel을 얻기
			DefaultTableModel dtm = lmf.getDtmOrderList();
			// dtm 초기화
			dtm.setRowCount(0);

			for (int i = 0; i < list.size(); i++) {
				olv = list.get(i);
				rowData = new Object[8];
				rowData[0] = i + 1;
				rowData[1] = olv.getOrderCode();
				rowData[2] = olv.getPrdName();
				rowData[3] = olv.getLunchCode();
				rowData[4] = olv.getName();
				rowData[5] = olv.getPhone();
				rowData[6] = olv.getQuantity();
				rowData[7] = olv.getStatus();

				dtm.addRow(rowData);
			} // end for

			if (!alertFlag && list.isEmpty()) {
				JOptionPane.showMessageDialog(lmf, "관리자님 홍보가 시급합니다.");
				alertFlag=true;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(lmf, "사용중 불편을 드려서 죄송합니다. 잠시후 다시 시도해주세요.");
			e.printStackTrace();
		}

	}// setOrderList

	public void setStatusUpdate() {

		JTable tab = lmf.getTabOrderList();
		String orderCode = (String) tab.getValueAt(tab.getSelectedRow(), 1);
		String prdName = (String) tab.getValueAt(tab.getSelectedRow(), 2);
		String name = (String) tab.getValueAt(tab.getSelectedRow(), 4);
		String phone = (String) tab.getValueAt(tab.getSelectedRow(), 5);
		String flag = (String) tab.getValueAt(tab.getSelectedRow(), 7);

		if ("Y".equals(flag)) {
			JOptionPane.showMessageDialog(lmf, "해당 도시락은 이미 제작 완료 되었습니다.");
			return;
		}

		StringBuilder msg = new StringBuilder();
		msg.append("[").append(name).append("-").append(phone).append("]님께서 주문하신 \"").append(prdName)
				.append("\"도시락이 준비되셨습니까?");

		switch (JOptionPane.showConfirmDialog(lmf, msg.toString())) {
		case JOptionPane.OK_OPTION:
			LunchMainDAO lm_dao = LunchMainDAO.getInstance();
			try {
				if (lm_dao.updateStatus(orderCode) == 1) {
					setOrderList();// 도시락이 완성되었다면 주문 리스트를 갱신한다.
					JOptionPane.showMessageDialog(lmf, "도시락이 완성되었습니다.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}// end switch
	}

	/**
	 * 도시락 목록 조회
	 */
	private void setLunchList() {

		LunchMainDAO lm_dao = LunchMainDAO.getInstance();
		try {
			List<LunchListVO> list = lm_dao.selectLunchList();
			DefaultTableModel dtm = lmf.getDtmLunchList();
			dtm.setRowCount(0);

			Object[] rowData = null;
			for (LunchListVO llv : list) {
				rowData = new Object[5];
				rowData[0] = new ImageIcon("C:/dev/workspace/lunch_prj/src/kr/co/sist/img/" + llv.getImg());
				rowData[1] = llv.getPrdName();
				rowData[2] = llv.getLunchCode();
				rowData[3] = llv.getLunchInfo();
				rowData[4] = llv.getPrice();

				dtm.addRow(rowData);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 도시락을 삭제하는 일
	 */
	private void removeLunch() {
		JTable tempTab = lmf.getTabLunchList();

		ImageIcon img = (ImageIcon) tempTab.getValueAt(tempTab.getSelectedRow(), 0);
		String prdName = (String) tempTab.getValueAt(tempTab.getSelectedRow(), 1);
		String lunchCode = (String) tempTab.getValueAt(tempTab.getSelectedRow(), 2);

		StringBuilder msg = new StringBuilder();
		msg.append("[").append(prdName).append("-").append(lunchCode).append("] 도시락을 삭제 하시겠습니까?");

		switch (JOptionPane.showConfirmDialog(lmf, msg)) {
		case JOptionPane.OK_OPTION:
			LunchMainDAO lm_dao = LunchMainDAO.getInstance();
			try {
				lm_dao.deleteLunch(lunchCode);
				msgCenter(prdName + "도시락이 삭제 되었습니다.");
				//이미지 삭제
				File sfile=new File(img.toString());
				File file=new File(sfile.getParent()+"/"+sfile.getName().substring(2));
				file.delete();
				sfile.delete();
			} catch (SQLException e) {
				e.printStackTrace();
				msgCenter(prdName + "도시락이 삭제 되다 말았습니다.");
			}
		}
	}// removeLunch

	public void mouseClicked(MouseEvent me) {
		JTabbedPane jtp = lmf.getTabbMain();
		switch (jtp.getSelectedIndex()) {
		case TAB_ORDER: // 주문탭에서 클릭 이벤트 발생
			if (me.getClickCount() == 2) { // 더블클릭 되었다면 주문상태를 변경
				setStatusUpdate();
			}
			setOrderList();//주문 탭이 클릭되면 주문 상태를 변경
			
			break;
		case TAB_LUNCH: // 도시락 탭에서 클릭 이벤트 발생
			if (me.getClickCount() == 2) {
				removeLunch();
			}
			setLunchList();// 현재 입력된 도시락의 목록을 조회하여 JTable에 설정한다
		}

	}

	private void setLunchImg() {
		FileDialog fd = new FileDialog(lmf, "이미지 선택", FileDialog.LOAD);
		fd.setVisible(true);
		String path = fd.getDirectory();
		String name = fd.getFile();

		if (name != null) {
			// img파일만 등록가능 하도록 설정
			String ext = name.substring(name.lastIndexOf(".") + 1).toLowerCase();
			// 사용가능한 확장자 일때만 처리
			// jpg,gif,png,bmp
			if ("jpg".equals(ext) || "gif".equals(ext) || "png".equals(ext) || "bmp".equals(ext)) {

				JLabel lblImg = lmf.getLblImg();
				ImageIcon ii = new ImageIcon(path + name);
				lblImg.setIcon(ii);
			} else {// 사용가능한 확장자가 아님
				JOptionPane.showMessageDialog(lmf, name + "은 사용 가능한 이미지가 아닙니다.");
			}
		}
	}// setLunchImg

	private void addLunch() throws IOException {
		String prdName = lmf.getTfPrdName().getText().trim();
		String price = lmf.getTfPrice().getText().trim();
		String lunchInfo = lmf.getTaLunchInfo().getText().trim();

		// 필수 입력사항에 대한 체크
		if ("".equals(prdName)) {
			msgCenter("도시락 명은 필수 입력 사항 입니다.");
			lmf.getTfPrdName().requestFocus();
			return;
		}
		if ("".equals(price)) {
			msgCenter("가격은 필수 입력 사항 입니다.");
			lmf.getTfPrice().requestFocus();
			return;
		}
		if ("".equals(lunchInfo)) {
			msgCenter("도시락의 정보를 입력해주세요.");
			lmf.getTaLunchInfo().requestFocus();
			return;
		}

		// 이미지를 사용하는 폴더로 업로드
		File original = new File(lmf.getLblImg().getIcon().toString());
		File copyFile = new File("C:/dev/workspace/lunch_prj/src/kr/co/sist/img/" + original.getName());
		if (copyFile.exists()) {
			msgCenter(copyFile.getName() + " 파일은 존재합니다. \n다른 파일로 변경해 주세요.");
			return;
		}
		// 선택한 이미지 파일을 지정한 경로로 복사
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(original);
			fos = new FileOutputStream(copyFile);

			int cnt = 0;
			byte[] temp = new byte[512];
			while ((cnt = fis.read(temp)) != -1) {
				fos.write(temp, 0, cnt);
				fos.flush();
			}
			// 작은 이미지 생성
			ImageResize.imgResize(lmf, copyFile.getAbsolutePath());
			// 이미지 복사 종료
			// vo생성
			LunchVO lv = new LunchVO(original.getName(), prdName, lunchInfo, Integer.parseInt(price));
			// DB에 추가
			LunchMainDAO lm_dao = LunchMainDAO.getInstance();
			try {
				lm_dao.insertLunch(lv);
				msgCenter("[ " + prdName + " ]으로 메뉴가 추가 되었습니다");
			} catch (SQLException e) {
				e.printStackTrace();
				msgCenter("[" + prdName + "]으로 메뉴가 추가되는 중 문제가 발생하였습니다.");
				// 방금 올린 파일을 삭제한다.
				copyFile.delete();
			}
			lmf.getTfPrdName().setText("");
			lmf.getTfPrice().setText("");
			lmf.getTaLunchInfo().setText("");
			lmf.getLblImg().setIcon(new ImageIcon("C:/dev/workspace/lunch_prj/src/kr/co/sist/img/default.jpg"));
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (fos != null) {
				fos.close();
			}
		}

	}

	private void msgCenter(String msg) {
		JOptionPane.showMessageDialog(lmf, msg);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == lmf.getBtnImg()) {
			setLunchImg();
		} // end if
		if (ae.getSource() == lmf.getBtnInput()) {
			try {
				addLunch();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // end if

	}// actionPerformed

}
