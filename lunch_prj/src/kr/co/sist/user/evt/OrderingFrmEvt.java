package kr.co.sist.user.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.user.dao.OrderingDAO;
import kr.co.sist.user.util.ImageResize;
import kr.co.sist.user.view.OrderingFrm;
import kr.co.sist.user.view.OrderingInfo;
import kr.co.sist.user.view.ProductDetail;
import kr.co.sist.user.vo.LunchDetailVO;
import kr.co.sist.user.vo.LunchVO;
import kr.co.sist.user.vo.MyOrderingVO;

public class OrderingFrmEvt extends MouseAdapter implements ActionListener {

	private OrderingFrm of;
	private OrderingInfo oi;

	public OrderingFrmEvt(OrderingFrm of, OrderingInfo oi) {
		this.of = of;
		this.oi = oi;
	}// OrderinFrmEvt

	/**
	 * JTable�� ��ȸ�� ���ö� ��� ����
	 */
	public void setTableLunch() {
		OrderingDAO od_dao = OrderingDAO.getInstance();
		try {
			List<LunchVO> list = od_dao.selectLunch();
			Object[] tempData = null;

			DefaultTableModel dtmLunch = of.getDtm();
			// �𵨿� �ִ� �� �ʱ�ȭ
			dtmLunch.setRowCount(0);
			// ��ȸ�� ��� �޾Ƽ�

			File file = null;
			for (LunchVO lv : list) {
				file = new File("C:/dev/workspace/lunch_prj/src/kr/co/sist/user/img/" + lv.getImg());
				if (!file.exists()) {
					FileClient fc = new FileClient();
					try {
						fc.uploadProcess(file);// �������� �����ϴ� ���� �ޱ�

					} catch (IOException e) {
						// �������� ������ �о������ ���ϴ� ��Ȳ�̸� �⺻�̹����� �����ش�
						e.printStackTrace();
						file = new File("C:/dev/workspace/lunch_prj/src/kr/co/sist/user/img/s_default.jpg");
					}
					// �ش������� ���ٸ� �������� �޾ƿ´�.
					// ���� �̹����� ���� ū �̹����� ����.
				}

				// list�� ��ȸ�� �����͸� �迭�� �����ϰ� �߰�
				tempData = new Object[4];

				tempData[0] = new ImageIcon(file.getAbsolutePath());

				tempData[1] = lv.getPrdName();
				tempData[2] = lv.getLunchInfo();
				tempData[3] = lv.getLunchCode();
				// ������ �迭�� JTable�� �ݿ��ϱ� ���� D.T.M �� �߰��Ѵ�.
				dtmLunch.addRow(tempData);

			} // end for
				// ��ȸ�� ���ö� ���ٸ�
			if (list.isEmpty()) {
				JOptionPane.showMessageDialog(of, "�˼��մϴ� �غ�� ���ö� �����ϴ�.");
			} // end if

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(of, "���� �߻�");
			e.printStackTrace();
		}

	}// setTableLunch

	@Override
	public void actionPerformed(ActionEvent ae) {
		String phone = oi.getTfPhone().getText().trim();
		if (!"".equals(phone)) {
			OrderingDAO o_dao = OrderingDAO.getInstance();

			try {
				List<MyOrderingVO> listOrder = o_dao.selectOrderingLsit(phone);
				if (!listOrder.isEmpty()) {
					DefaultTableModel dtmOrder = oi.getDtm();
					// ��ȸ�� �����Ͱ� �����ϹǷ� DefaultTableModel�� �ʱ�ȭ
					dtmOrder.setRowCount(0);
					Object[] rowData = null;
					DecimalFormat df = new DecimalFormat("#,###");
					for (MyOrderingVO mov : listOrder) {
						rowData = new Object[5];
						rowData[0] = new ImageIcon(
								"C:/dev/workspace/lunch_prj/src/kr/co/sist/user/img/s_" + mov.getImg());
						rowData[1] = mov.getPrdName();
						rowData[2] = df.format(mov.getPrice());
						rowData[3] = df.format(mov.getQuantity());
						rowData[4] = df.format(mov.getPrice() * mov.getQuantity());
						// ������ �����͸� ���̺� �����ֱ� ���� DefaultTableModel�� �߰�
						dtmOrder.addRow(rowData);
					}
				} else {
					JOptionPane.showMessageDialog(oi, phone + "������ �ֹ��� ������ �������� �ʽ��ϴ�.");
				}
			} catch (SQLException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
				JOptionPane.showMessageDialog(oi, "��� �� ������ ��� �˼��մϴ�. ��� �� �ٽ� �õ����ּ���.");
			} // ��ȭ��ȣ�� �ֹ���Ȳ ��ȸ

		} else {
			JOptionPane.showMessageDialog(oi, "��ȭ ��ȣ�� �Է����ּ���");

		}

	}

	public void mouseClicked(MouseEvent me) {
		if (me.getClickCount() == 2) {
			// int time = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
			//
			// if(time<9 || time>13) {
			// JOptionPane.showMessageDialog(of, "�˼��մϴ�.\n�ֹ��� ������ �ð��� �ƴմϴ�.\n�ֹ��� ����9�ú���
			// ����13�ñ����� �����մϴ�.");
			// return;
			// }

			JTable temp = (JTable) me.getSource();
			String prdName = (String) temp.getValueAt(temp.getSelectedRow(), 1);
			// ���õ� ���� ���ö��� �޾ƿͼ�

			ImageIcon img = (ImageIcon) temp.getValueAt(temp.getSelectedRow(), 0);
			File tempFile = new File(img.toString());
			File tempFile1 = new File(tempFile.getParent() + "/" + tempFile.getName().substring(2));

			if (!tempFile1.exists()) {
				// ���� ������ ū ���Ϸ� ����(���ϸ��� "s_"�� ���� �̸�)"
				try {
					ImageResize.imgResize(of, tempFile.getAbsolutePath());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			switch (JOptionPane.showConfirmDialog(of, prdName + "���ö� �ֹ��Ͻðڽ��ϱ�?")) {
			// �ֹ� ��� �� ������ �����.
			case JOptionPane.OK_OPTION:

				// ������ ���� ���ö� �ڵ尪(prd_code)�� ���ͼ�
				String prdCode = (String) temp.getValueAt(temp.getSelectedRow(), 3);
				// �ش� ���ö��� �������� ��ȸ�� ��

				OrderingDAO od = OrderingDAO.getInstance();
				try {
					LunchDetailVO ldv = od.selectDetailLunch(prdCode);
					// �ֹ�â�� ����

					new ProductDetail(ldv);
				} catch (SQLException se) {
					se.printStackTrace();
					JOptionPane.showMessageDialog(of, "���ֹ� ��ȸ�� ���� �߻� ��� �� �ٽ� �õ�");
				} // end catch

			}// end switch

		} // end if

	}//

}
