package kr.co.sist.admin.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.admin.evt.LunchMainFrameEvt;

@SuppressWarnings("serial")
public class LunchMainFrame extends JFrame implements Runnable {
	private JTabbedPane tabbMain;
	private JTable tabOrderList, tabLunchList;
	private DefaultTableModel dtmOrderList, dtmLunchList;
	private JLabel lblImg;
	private ImageIcon iiImg;
	private JTextField tfPrdName, tfPrice;
	private JTextArea taLunchInfo;
	private JButton btnImg, btnInput, btnClose;

	private LunchMainFrameEvt lmfe;

	// ���ö���,�ڵ�,����,�ֹ��ڸ�,����,�ֹ�����,����
	public LunchMainFrame() {
		super("������ȭ��");
		// �� �����
		tabbMain = new JTabbedPane();
		String[] strTabTitle = { "�ֹ���Ȳ", "���ö��߰�", "���ö����" };
		JPanel pnOrderStatus = new JPanel(new BorderLayout());
		JPanel pnAddLunch = new JPanel(new BorderLayout());
		JPanel pnLunchList = new JPanel(new BorderLayout());
		tabbMain.addTab(strTabTitle[0], pnOrderStatus);
		tabbMain.addTab(strTabTitle[1], pnAddLunch);
		tabbMain.addTab(strTabTitle[2], pnLunchList);
		add("Center", tabbMain);
		////////////////// �ֹ���Ȳ ����
		String[] orderTabColumnNames = { "��ȣ", "�ֹ��ڵ�", "���ö���", "�ڵ�", "�ֹ��ڸ�", "��ȭ��ȣ", "����", "���ۻ���" };

		dtmOrderList = new DefaultTableModel(orderTabColumnNames, 0) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		tabOrderList = new JTable(dtmOrderList);
		JScrollPane jspOrderTab = new JScrollPane(tabOrderList);
		pnOrderStatus.add("Center", jspOrderTab);
		tabOrderList.setRowHeight(20);
		////////////////////////////////// �ֹ���Ȳ ��
		///////////////// ���ö� �߰� ����
		iiImg = new ImageIcon();
		lblImg = new JLabel();
		tfPrdName = new JTextField();
		tfPrice = new JTextField();
		taLunchInfo = new JTextArea();
		btnImg = new JButton("�̹�������");
		btnInput = new JButton("�Է�");
		btnClose = new JButton("�ݱ�");
		JLabel lblLunchName = new JLabel("���ö���");
		JLabel lblprice = new JLabel("����");
		JLabel lblPoint = new JLabel("Ư¡");
		JScrollPane jspTalunchInfo = new JScrollPane(taLunchInfo);
		JPanel panelCenter = new JPanel(new GridLayout(1, 2));
		JPanel panelLeft = new JPanel(null);
		JPanel panelRight = new JPanel(null);
		JPanel panelSouth = new JPanel();

		panelLeft.add(lblImg);
		panelLeft.add(btnImg);
		panelRight.add(lblLunchName);
		panelRight.add(lblprice);
		panelRight.add(lblPoint);
		panelRight.add(tfPrdName);
		panelRight.add(tfPrice);
		panelRight.add(jspTalunchInfo);

		panelCenter.add(panelLeft);
		panelCenter.add(panelRight);

		lblImg.setBorder(new TitledBorder("����"));
		lblImg.setBounds(70, 10, 300, 250);
		btnImg.setBounds(145, 280, 150, 30);

		lblLunchName.setBounds(5, 10, 60, 30);
		lblprice.setBounds(5, 70, 60, 30);
		lblPoint.setBounds(5, 130, 60, 30);
		tfPrdName.setBounds(80, 13, 300, 25);
		tfPrice.setBounds(80, 73, 300, 25);
		jspTalunchInfo.setBounds(80, 133, 300, 300);

		panelSouth.add(btnInput);
		panelSouth.add(btnClose);
		pnAddLunch.add("Center", panelCenter);
		pnAddLunch.add("South", panelSouth);
		//////////////// ���ö� �߰� ��

		////////// ���ö� ����Ʈ ����/////////
		String[] lunchListColumnNames = { "�̹���", "���ö���", "�ڵ�", "����", "����" };

		dtmLunchList = new DefaultTableModel(lunchListColumnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tabLunchList = new JTable(dtmLunchList) {

			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}

		};
		tabLunchList.setRowHeight(90);
		JScrollPane jspLunchList = new JScrollPane(tabLunchList);
		pnLunchList.add("Center", jspLunchList);
		//////////// ���ö� ����Ʈ �� /////////////////

		setVisible(true);

		// �̺�Ʈ ���
		lmfe = new LunchMainFrameEvt(this);
		tabbMain.addMouseListener(lmfe);
		btnClose.addActionListener(lmfe);
		btnImg.addActionListener(lmfe);
		btnInput.addActionListener(lmfe);
		tabOrderList.addMouseListener(lmfe);
		tabLunchList.addMouseListener(lmfe);
		// lmfe.setOrderList();
		Thread thread = new Thread(this);
		thread.start();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 150, 850, 700);
	}// AdminMain

	public DefaultTableModel getDtmOrderList() {
		return dtmOrderList;
	}

	public DefaultTableModel getDtmLunchList() {
		return dtmLunchList;
	}

	@Override
	public void run() {
		try {
			while (true) {
				lmfe.setOrderList();
				Thread.sleep(1000 * 5);
			}
		} catch (InterruptedException ie) {
			JOptionPane.showMessageDialog(this, "�ֹ���Ȳ�� �����ϴٰ� ���ҽ��ϴ�.");
		}
	}

	public JTabbedPane getTabbMain() {
		return tabbMain;
	}

	public JTable getTabOrderList() {
		return tabOrderList;
	}

	public JTable getTabLunchList() {
		return tabLunchList;
	}

	public JLabel getLblImg() {
		return lblImg;
	}

	public ImageIcon getIiImg() {
		return iiImg;
	}

	public JTextField getTfPrdName() {
		return tfPrdName;
	}

	public JTextField getTfPrice() {
		return tfPrice;
	}

	public JTextArea getTaLunchInfo() {
		return taLunchInfo;
	}

	public JButton getBtnImg() {
		return btnImg;
	}

	public JButton getBtnInput() {
		return btnInput;
	}

	public JButton getBtnClose() {
		return btnClose;
	}

}// Class
