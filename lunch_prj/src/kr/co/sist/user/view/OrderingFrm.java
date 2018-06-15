package kr.co.sist.user.view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.user.evt.OrderingFrmEvt;

/**
 * 도시락 주문시스템 메인 View
 * 
 * @author trueyoung
 */
@SuppressWarnings("serial")
public class OrderingFrm extends JFrame implements Runnable {

	private JTabbedPane tab;
	private JTable tableView;
	private DefaultTableModel dtm;
	private OrderingInfo uoi;
	private OrderingFrmEvt ofe;

	public OrderingFrm() {
		super("도시락 주문 시스템");
		tab = new JTabbedPane();

		String[] TableName = { "미리보기", "메뉴", "설명", "메뉴ID" };
		String[][] data = null;

		dtm = new DefaultTableModel(data, TableName) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};

		tableView = new JTable(dtm) {

			@Override
			public Class<?> getColumnClass(int column) {

				return getValueAt(0, column).getClass();
			}

		};
		tableView.setRowHeight(90);
		// tableView.setEnabled(false);
		JScrollPane jsp = new JScrollPane(tableView);

		add("Center", tab);

		tableView.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableView.getColumnModel().getColumn(1).setPreferredWidth(50);
		tableView.getColumnModel().getColumn(2).setPreferredWidth(150);
		tableView.getColumnModel().getColumn(3).setPreferredWidth(10);
		tableView.getTableHeader().setReorderingAllowed(false);

		tab.add("메뉴", jsp);
		uoi = new OrderingInfo();
		tab.addTab("주문확인", uoi.panelAll);

		// 이벤트 처리
		ofe = new OrderingFrmEvt(this, uoi);

		tableView.addMouseListener(ofe);
		uoi.getBtnOrder().addActionListener(ofe);

		// 도시락 목록을 조회하여 테이블설정
		Thread thread = new Thread(this);
		thread.start();
		
		setBounds(100, 100, 650, 500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// LunchSystemView

	@Override
	public void run() {
		try {
			while (true) {
				ofe.setTableLunch();
				Thread.sleep(1000 * 30);
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	public JTabbedPane getTab() {
		return tab;
	}

	public JTable getTableView() {
		return tableView;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public OrderingInfo getUoi() {
		return uoi;
	}

}// class
