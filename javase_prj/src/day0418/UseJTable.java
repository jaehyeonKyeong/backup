package day0418;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class UseJTable extends JFrame {
	public UseJTable() {
		super("테이블");
		String[] columnName = { "번호", "이름", "나이", "주소" };
		String[][] rowData = { { "1", "지승민", "28", "인천시 계양구" }, { "2", "김대현", "27", "서울시 관악구" },
				{ "3", "김동희", "29", "서울시 중구" }, { "4", "장현준", "27", "서울시 역삼동" } };

		// Model 객체 생성
		DefaultTableModel dtm = new DefaultTableModel(rowData, columnName);
		
		//데이터 추가
		dtm.addRow(new String[] {"5","이진형","28","서울시 광진구"});
		
		//view객체 생성
		JTable table= new JTable(dtm);//칼럼명이 보여지지 않음\
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBorder(new TitledBorder("친구목록"));
		
		//column의 크기조절(각각조절)
		//테이블 하나의 컬럼을 얻어와서 table.getColumnModel().getColumn(0)
		//해당 컬럼의 넓이를 변경.setPreferredWidth(40);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(240);
		add("Center",jsp);
		
		setBounds(100,100,400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}// Constructor

	public static void main(String[] args) {
		new UseJTable();
	}// main

}// class UseJTable
