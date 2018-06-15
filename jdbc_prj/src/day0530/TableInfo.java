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
		super("숙제");
		String[] tableName = { "컬럼명", "데이터형", "크기", "제약사항명" };
		String[][] data = null;
		JPanel panel = new JPanel();

		search = new JButton("조회");

		TableInfoDAO t_dao = TableInfoDAO.getInstance();
		DefaultComboBoxModel<String> dcbm = null;
		try {
			// 모든 테이블명을 조회하여
			List<String> listTable = t_dao.selectTableName();
			String[] tableArr = new String[listTable.size()];
			// 테이블 명을 저장할 배열에 조회된 테이블명을 할당하게 된다.
			listTable.toArray(tableArr);
			//테이블명을 가진 배열을 사용하여 콤보박스 모델을 생성.
			dcbm=new DefaultComboBoxModel<>(tableArr);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "알 수 없는 오류로 인하여 테이블 정보를 불러오지 못하였습니다.");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jbox = new JComboBox<String>(dcbm);
		dtm = new DefaultTableModel(data, tableName);
		jtl = new JTable(dtm);
		JScrollPane jsp = new JScrollPane(jtl);
		jbox.setPreferredSize(new Dimension(200, 25));

		// 컬럼 크기 변경
		jtl.getColumnModel().getColumn(0).setPreferredWidth(320);
		jtl.getColumnModel().getColumn(1).setPreferredWidth(100);
		jtl.getColumnModel().getColumn(2).setPreferredWidth(80);
		jtl.getColumnModel().getColumn(3).setPreferredWidth(200);

		// 컬럼 위치 고정
		jtl.getTableHeader().setReorderingAllowed(false);
		// 컬럼 크기 고정
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
		//선택한 테이블명을 얻기
		String tname=(String)jbox.getSelectedItem();
		setTable(tname);
		
	}
	private void setTable(String tname) {
		//DAO객체 사용
		//Singleton으로 생성된 객체 얻기
		TableInfoDAO t_dao=TableInfoDAO.getInstance();
		//조회
		try {
			List<ColumnVO> list=t_dao.selectColumnInfo(tname);
			//조회된 정보로 javax.swing.JTable에 설정
			//1.JTable의 레코드를 초기화
			dtm.setRowCount(0);
			//2.설정
			Object[] temp=null;
			for(ColumnVO cv : list) {
				//dtm에 데이터를 넣기 위해 배열을 생성하고 조회하느 결과를 입력
				temp=new Object[4];
				temp[0]=cv.getColumnName();
				temp[1]=cv.getDataType();
				temp[2]=cv.getDataLength();
				temp[3]=cv.getConstraintName();
				//데이터를 가진 배열을 dtm에 행으로 설정
				dtm.addRow(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "죄송해요!\\n컬럼 조회중 문제가 발생하였습니다!\n 잠시후 다시 시도해주세요!");
		}
		
	}

	public static void main(String[] args) {
		new TableInfo();
	} // main
} // class
