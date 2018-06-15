package day0529;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableView extends JFrame{
	private JComboBox<String> jcbTableCombobox;
	private JButton btnSearch;
	private DefaultTableModel dtm;
	private JTable jtTable;
		
	public TableView() {
		super("테이블 조회");
		
		JPanel panel=new JPanel();
		jcbTableCombobox=new JComboBox<>();
		btnSearch= new JButton("조회");
		
		String[] rowName= {"컬럼명","데이터형","크기","제약사항"};
		String[][] data=null;
		dtm= new DefaultTableModel(data, rowName);
		jtTable=new JTable(dtm);
		JScrollPane jsp=new JScrollPane(jtTable);
		
		jtTable.getColumnModel().getColumn(0).setPreferredWidth(200);
		jtTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		jtTable.getColumnModel().getColumn(2).setPreferredWidth(70);
		jtTable.getColumnModel().getColumn(3).setPreferredWidth(70);
		
		jcbTableCombobox.setPreferredSize(new Dimension(250,25));
		
		panel.add(jcbTableCombobox);
		panel.add(btnSearch);
		add("North",panel);
		add(jsp,"Center");
		
		
		setBounds(100,100,450,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new TableView();
	}

}
