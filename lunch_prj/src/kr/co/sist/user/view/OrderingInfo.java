package kr.co.sist.user.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class OrderingInfo extends JFrame {
	private JLabel lblPhone;
	private JTextField tfPhone;
	private JButton btnOrder;
	private JTable tableView;
	public JPanel panelAll = new JPanel(new BorderLayout());

	private DefaultTableModel dtm;

	public OrderingInfo() {
		// �г� ����
		JPanel panelNorth = new JPanel(new FlowLayout());
		JPanel panelCenter = new JPanel(new BorderLayout());

		lblPhone = new JLabel("��ȭ��ȣ");
		tfPhone = new JTextField(30);
		btnOrder = new JButton("��ȸ");

		String tableName[] = { "�̹���","��ǰ��","�ܰ�", "����", "�ݾ�" };

		dtm = new DefaultTableModel(tableName,0) {
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
		
		tableView.getColumnModel().getColumn(0).setPreferredWidth(60);
		tableView.getColumnModel().getColumn(1).setPreferredWidth(60);
		tableView.getColumnModel().getColumn(2).setPreferredWidth(30);
		tableView.getColumnModel().getColumn(3).setPreferredWidth(30);
		tableView.getColumnModel().getColumn(4).setPreferredWidth(60);

		tableView.getTableHeader().setReorderingAllowed(false);
		JScrollPane jsp = new JScrollPane(tableView);

		panelNorth.add(lblPhone);
		panelNorth.add(tfPhone);
		panelNorth.add(btnOrder);
		panelNorth.setBorder(new TitledBorder("�ֹ��� ����"));

		panelCenter.add(jsp);
		panelCenter.setBorder(new TitledBorder("���ö� ����"));

		panelAll.add("North", panelNorth);
		panelAll.add("Center", panelCenter);

		add("Center", panelAll);

	}// UserOrderInfo

	
	public JLabel getLblPhone() {
		return lblPhone;
	}

	public JTextField getTfPhone() {
		return tfPhone;
	}

	public JButton getBtnOrder() {
		return btnOrder;
	}

	public JTable getTableView() {
		return tableView;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}


}// class
