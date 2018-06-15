package day0604;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UseTable extends JFrame {
	public UseTable() {

		super("테이블에 이미지 넣기");
		String[] columnNames = { "이미지", "이름" };
		Object[][] data = { { new ImageIcon("C:/dev/workspace/jdbc_prj/src/day0604/s_m1_l4.gif"), "도련님 도시락" },
				{ new ImageIcon("C:/dev/workspace/jdbc_prj/src/day0604/s_m1_l5.gif"), "진달래 도시락" } };

		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
		JTable jt = new JTable(dtm) {

			@Override
			public Class<?> getColumnClass(int column) {
				// 테이블에 생성된 행이 붙으면 그 행은 붙고나서 사라지기때문에 항상 생성된 행은 0행이다.
				// 해당 컬럼의 데이터형을 원래의 클래스 형으로 만들어 컬럼을 생성한다.
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
