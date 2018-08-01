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
 * @author ower
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
				//모든 컬럼(Cell)의 편집상태를 막는다.
				return false;
			}//isCellEditable
		};

		tableView = new JTable(dtm) {


			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}
		};

		tableView.setRowHeight(90);
		//		tableView.setEnabled(false); //사용할 수 없는 상태로 만들어 편집불가


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

		//이벤트 처리 객체 생성 : has a
		ofe=new OrderingFrmEvt(this,uoi);
		//이벤트 등록
		tableView.addMouseListener(ofe);
		uoi.getBtnOrder().addActionListener(ofe);
		//도시락 목록을 조회하여 테이블에 설정
		Thread thread=new Thread(this);
		thread.start(); //->run


		setBounds(100, 100, 650, 500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// LunchSystemView

	
	@Override
	public void run() {
		try {
			while(true) {
				ofe.setTableLunch();
				Thread.sleep(1000*30);
			}//end while
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}//end catch
	}//run

	
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
