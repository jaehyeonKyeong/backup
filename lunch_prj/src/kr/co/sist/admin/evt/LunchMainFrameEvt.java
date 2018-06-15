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
 * ������ ȭ���� �̺�Ʈ ó���� ���� ����
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
	 * �����ڿ� ���� �ֹ� ��Ȳ�� ��ȸ�Ͽ� JTable�� ����
	 */
	public void setOrderList() {
		LunchMainDAO lm_dao = LunchMainDAO.getInstance();
		try {
			List<OrderListVO> list = lm_dao.selectTodayOrder();
			Object[] rowData = null;
			OrderListVO olv = null;

			// �ֹ���Ȳ�� ������ DefaultTableModel�� ���
			DefaultTableModel dtm = lmf.getDtmOrderList();
			// dtm �ʱ�ȭ
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
				JOptionPane.showMessageDialog(lmf, "�����ڴ� ȫ���� �ñ��մϴ�.");
				alertFlag=true;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(lmf, "����� ������ ����� �˼��մϴ�. ����� �ٽ� �õ����ּ���.");
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
			JOptionPane.showMessageDialog(lmf, "�ش� ���ö��� �̹� ���� �Ϸ� �Ǿ����ϴ�.");
			return;
		}

		StringBuilder msg = new StringBuilder();
		msg.append("[").append(name).append("-").append(phone).append("]�Բ��� �ֹ��Ͻ� \"").append(prdName)
				.append("\"���ö��� �غ�Ǽ̽��ϱ�?");

		switch (JOptionPane.showConfirmDialog(lmf, msg.toString())) {
		case JOptionPane.OK_OPTION:
			LunchMainDAO lm_dao = LunchMainDAO.getInstance();
			try {
				if (lm_dao.updateStatus(orderCode) == 1) {
					setOrderList();// ���ö��� �ϼ��Ǿ��ٸ� �ֹ� ����Ʈ�� �����Ѵ�.
					JOptionPane.showMessageDialog(lmf, "���ö��� �ϼ��Ǿ����ϴ�.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}// end switch
	}

	/**
	 * ���ö� ��� ��ȸ
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
	 * ���ö��� �����ϴ� ��
	 */
	private void removeLunch() {
		JTable tempTab = lmf.getTabLunchList();

		ImageIcon img = (ImageIcon) tempTab.getValueAt(tempTab.getSelectedRow(), 0);
		String prdName = (String) tempTab.getValueAt(tempTab.getSelectedRow(), 1);
		String lunchCode = (String) tempTab.getValueAt(tempTab.getSelectedRow(), 2);

		StringBuilder msg = new StringBuilder();
		msg.append("[").append(prdName).append("-").append(lunchCode).append("] ���ö��� ���� �Ͻðڽ��ϱ�?");

		switch (JOptionPane.showConfirmDialog(lmf, msg)) {
		case JOptionPane.OK_OPTION:
			LunchMainDAO lm_dao = LunchMainDAO.getInstance();
			try {
				lm_dao.deleteLunch(lunchCode);
				msgCenter(prdName + "���ö��� ���� �Ǿ����ϴ�.");
				//�̹��� ����
				File sfile=new File(img.toString());
				File file=new File(sfile.getParent()+"/"+sfile.getName().substring(2));
				file.delete();
				sfile.delete();
			} catch (SQLException e) {
				e.printStackTrace();
				msgCenter(prdName + "���ö��� ���� �Ǵ� ���ҽ��ϴ�.");
			}
		}
	}// removeLunch

	public void mouseClicked(MouseEvent me) {
		JTabbedPane jtp = lmf.getTabbMain();
		switch (jtp.getSelectedIndex()) {
		case TAB_ORDER: // �ֹ��ǿ��� Ŭ�� �̺�Ʈ �߻�
			if (me.getClickCount() == 2) { // ����Ŭ�� �Ǿ��ٸ� �ֹ����¸� ����
				setStatusUpdate();
			}
			setOrderList();//�ֹ� ���� Ŭ���Ǹ� �ֹ� ���¸� ����
			
			break;
		case TAB_LUNCH: // ���ö� �ǿ��� Ŭ�� �̺�Ʈ �߻�
			if (me.getClickCount() == 2) {
				removeLunch();
			}
			setLunchList();// ���� �Էµ� ���ö��� ����� ��ȸ�Ͽ� JTable�� �����Ѵ�
		}

	}

	private void setLunchImg() {
		FileDialog fd = new FileDialog(lmf, "�̹��� ����", FileDialog.LOAD);
		fd.setVisible(true);
		String path = fd.getDirectory();
		String name = fd.getFile();

		if (name != null) {
			// img���ϸ� ��ϰ��� �ϵ��� ����
			String ext = name.substring(name.lastIndexOf(".") + 1).toLowerCase();
			// ��밡���� Ȯ���� �϶��� ó��
			// jpg,gif,png,bmp
			if ("jpg".equals(ext) || "gif".equals(ext) || "png".equals(ext) || "bmp".equals(ext)) {

				JLabel lblImg = lmf.getLblImg();
				ImageIcon ii = new ImageIcon(path + name);
				lblImg.setIcon(ii);
			} else {// ��밡���� Ȯ���ڰ� �ƴ�
				JOptionPane.showMessageDialog(lmf, name + "�� ��� ������ �̹����� �ƴմϴ�.");
			}
		}
	}// setLunchImg

	private void addLunch() throws IOException {
		String prdName = lmf.getTfPrdName().getText().trim();
		String price = lmf.getTfPrice().getText().trim();
		String lunchInfo = lmf.getTaLunchInfo().getText().trim();

		// �ʼ� �Է»��׿� ���� üũ
		if ("".equals(prdName)) {
			msgCenter("���ö� ���� �ʼ� �Է� ���� �Դϴ�.");
			lmf.getTfPrdName().requestFocus();
			return;
		}
		if ("".equals(price)) {
			msgCenter("������ �ʼ� �Է� ���� �Դϴ�.");
			lmf.getTfPrice().requestFocus();
			return;
		}
		if ("".equals(lunchInfo)) {
			msgCenter("���ö��� ������ �Է����ּ���.");
			lmf.getTaLunchInfo().requestFocus();
			return;
		}

		// �̹����� ����ϴ� ������ ���ε�
		File original = new File(lmf.getLblImg().getIcon().toString());
		File copyFile = new File("C:/dev/workspace/lunch_prj/src/kr/co/sist/img/" + original.getName());
		if (copyFile.exists()) {
			msgCenter(copyFile.getName() + " ������ �����մϴ�. \n�ٸ� ���Ϸ� ������ �ּ���.");
			return;
		}
		// ������ �̹��� ������ ������ ��η� ����
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
			// ���� �̹��� ����
			ImageResize.imgResize(lmf, copyFile.getAbsolutePath());
			// �̹��� ���� ����
			// vo����
			LunchVO lv = new LunchVO(original.getName(), prdName, lunchInfo, Integer.parseInt(price));
			// DB�� �߰�
			LunchMainDAO lm_dao = LunchMainDAO.getInstance();
			try {
				lm_dao.insertLunch(lv);
				msgCenter("[ " + prdName + " ]���� �޴��� �߰� �Ǿ����ϴ�");
			} catch (SQLException e) {
				e.printStackTrace();
				msgCenter("[" + prdName + "]���� �޴��� �߰��Ǵ� �� ������ �߻��Ͽ����ϴ�.");
				// ��� �ø� ������ �����Ѵ�.
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
