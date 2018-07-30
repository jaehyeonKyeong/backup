package kr.co.sist.user.view;

import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.user.controller.RestaurantSearchViewEvt;

@SuppressWarnings("serial")
public class RestaurantSearchView extends JFrame {
	JTextField tfSearch;
	JList<String> listRestaurantView;
	JTable table;
	DefaultTableModel dtm;
	ImageIcon imgRestaurantImg;
	JComboBox<String> cBoxGrade,cBoxCategory;
	JButton btnRestaurant,btnSearch,btnSelectAll;
	String id;
	
	
	
	
	public RestaurantSearchView(String id) {
		super("�Ĵ�ã��");
		setLayout(null);
		this.id=id;
		
		//����
		tfSearch = new JTextField();
		listRestaurantView = new JList<>();
		cBoxGrade=new JComboBox<>();
		cBoxCategory=new JComboBox<>();
		btnRestaurant=new JButton();
		btnSearch=new JButton("�˻�");
		btnSelectAll=new JButton("��ü����");
		
		//table
		String title[]= {"�̹���","�Ĵ��̸�"};
		String data[][]= {
				{"img","�Ĵ��̸�1"},
				{"img2","�Ĵ��̸�2"},
				{"img3","�Ĵ��̸�3"},
				{"img4","�Ĵ��̸�4"}
			};
		
		int rowCount=data.length;
	
		dtm=new DefaultTableModel(title, rowCount) {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		table=new JTable(dtm);
		
		table.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scroll=new JScrollPane(table);
		
		for(int i=0;i<data.length;i++) {
			for(int j=0;j<data[0].length;j++) {
				table.setValueAt(data[i][j], i, j);
			}
		}
		
		//comboBox
		cBoxGrade.addItem("���� �� ����");
		cBoxGrade.addItem("�̸� �� ����");
		cBoxCategory.addItem("�ѽ�");
		cBoxCategory.addItem("�߽�");
		cBoxCategory.addItem("�Ͻ�");
		cBoxCategory.addItem("���");
		cBoxCategory.addItem("�н�");
		
		//��ġ
		tfSearch.setBounds(270,20,150,30);
		btnSearch.setBounds(170,20,100,28);
		cBoxCategory.setBounds(20,65,100,20);
		cBoxGrade.setBounds(125,65,100,20);
		scroll.setBounds(20,90,400,100);
		btnSelectAll.setBounds(320,65,100,20);
		
		//������Ʈ ����
		add(tfSearch);
		add(btnSearch);
		add(scroll);
		add(cBoxCategory);
		add(cBoxGrade);
		add(btnSelectAll);
		
		
		
		setBounds(500,100,450,250);
		setVisible(true);
		
		RestaurantSearchViewEvt rsve=new RestaurantSearchViewEvt(this);
		tfSearch.addActionListener(rsve);
		btnSearch.addActionListener(rsve);
		table.addMouseListener(rsve);
		cBoxGrade.addActionListener(rsve);
		cBoxCategory.addActionListener(rsve);
		btnSelectAll.addActionListener(rsve);
		
	}

	public JTextField getTfSearch() {
		return tfSearch;
	}

	public JList<String> getListRestaurantView() {
		return listRestaurantView;
	}

	public JTable getTable() {
		return table;
	}

	public ImageIcon getImgRestaurantImg() {
		return imgRestaurantImg;
	}

	public JComboBox<String> getcBoxGrade() {
		return cBoxGrade;
	}

	public JButton getBtnRestaurant() {
		return btnRestaurant;
	}
	

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public JComboBox<String> getcBoxCategory() {
		return cBoxCategory;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public JButton getBtnSelectAll() {
		return btnSelectAll;
	}
	
}
