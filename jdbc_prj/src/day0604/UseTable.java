package day0604;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UseTable extends JFrame {
	public UseTable() {

		super("���̺� �̹��� �ֱ�");
		String[] columnNames = { "�̹���", "�̸�" };
		Object[][] data = { { new ImageIcon("C:/dev/workspace/jdbc_prj/src/day0604/s_m1_l4.gif"), "���ô� ���ö�" },
				{ new ImageIcon("C:/dev/workspace/jdbc_prj/src/day0604/s_m1_l5.gif"), "���޷� ���ö�" } };

		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
		JTable jt = new JTable(dtm) {

			@Override
			public Class<?> getColumnClass(int column) {
				// ���̺� ������ ���� ������ �� ���� �ٰ��� ������⶧���� �׻� ������ ���� 0���̴�.
				// �ش� �÷��� ���������� ������ Ŭ���� ������ ����� �÷��� �����Ѵ�.
				return getValueAt(0, column).getClass();
			}

		};
		jt.setRowHeight(80);
		JScrollPane jsp = new JScrollPane(jt);

		add(jsp);
		setBounds(100, 100, 500, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new UseTable();
	}
}
