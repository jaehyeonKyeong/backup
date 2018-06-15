package day0530;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class TableInfo extends JFrame implements ActionListener {

	private JComboBox<String> jbox;
	private JButton search;
	private JTable jtl;
	private DefaultTableModel dtm;

	public TableInfo() {
		super("����");
		String[] tableName = { "�÷���", "��������", "ũ��", "������׸�" };
		String[][] data = null;
		JPanel panel = new JPanel();

		search = new JButton("��ȸ");

		TableInfoDAO t_dao = TableInfoDAO.getInstance();
		DefaultComboBoxModel<String> dcbm = null;
		try {
			// ��� ���̺���� ��ȸ�Ͽ�
			List<String> listTable = t_dao.selectTableName();
			String[] tableArr = new String[listTable.size()];
			// ���̺� ���� ������ �迭�� ��ȸ�� ���̺���� �Ҵ��ϰ� �ȴ�.
			listTable.toArray(tableArr);
			//���̺���� ���� �迭�� ����Ͽ� �޺��ڽ� ���� ����.
			dcbm=new DefaultComboBoxModel<>(tableArr);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "�� �� ���� ������ ���Ͽ� ���̺� ������ �ҷ����� ���Ͽ����ϴ�.");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jbox = new JComboBox<String>(dcbm);
		dtm = new DefaultTableModel(data, tableName);
		jtl = new JTable(dtm);
		JScrollPane jsp = new JScrollPane(jtl);
		jbox.setPreferredSize(new Dimension(200, 25));

		// �÷� ũ�� ����
		jtl.getColumnModel().getColumn(0).setPreferredWidth(320);
		jtl.getColumnModel().getColumn(1).setPreferredWidth(100);
		jtl.getColumnModel().getColumn(2).setPreferredWidth(80);
		jtl.getColumnModel().getColumn(3).setPreferredWidth(200);

		// �÷� ��ġ ����
		jtl.getTableHeader().setReorderingAllowed(false);
		// �÷� ũ�� ����
		jtl.getTableHeader().setResizingAllowed(false);

		panel.add(jbox);
		panel.add(search);

		add("North", panel);
		add("Center", jsp);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 700, 600);
		setVisible(true);
		search.addActionListener(this);

	}// TableInfo

	@Override
	public void actionPerformed(ActionEvent ae) {
		//������ ���̺���� ���
		String tname=(String)jbox.getSelectedItem();
		setTable(tname);
		
	}
	private void setTable(String tname) {
		//DAO��ü ���
		//Singleton���� ������ ��ü ���
		TableInfoDAO t_dao=TableInfoDAO.getInstance();
		//��ȸ
		try {
			List<ColumnVO> list=t_dao.selectColumnInfo(tname);
			//��ȸ�� ������ javax.swing.JTable�� ����
			//1.JTable�� ���ڵ带 �ʱ�ȭ
			dtm.setRowCount(0);
			//2.����
			Object[] temp=null;
			for(ColumnVO cv : list) {
				//dtm�� �����͸� �ֱ� ���� �迭�� �����ϰ� ��ȸ�ϴ� ����� �Է�
				temp=new Object[4];
				temp[0]=cv.getColumnName();
				temp[1]=cv.getDataType();
				temp[2]=cv.getDataLength();
				temp[3]=cv.getConstraintName();
				//�����͸� ���� �迭�� dtm�� ������ ����
				dtm.addRow(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "�˼��ؿ�!\\n�÷� ��ȸ�� ������ �߻��Ͽ����ϴ�!\n ����� �ٽ� �õ����ּ���!");
		}
		
	}

	public static void main(String[] args) {
		new TableInfo();
	} // main
} // class
