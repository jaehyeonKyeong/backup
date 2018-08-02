package kr.co.sist.user.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
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
	JLabel lblId;
	private JPanel panel;
	private Color b_Color=new Color(0,100,121);
	String id;
	

	
	
	
	
	public JLabel getLblId() {
		return lblId;
	}


	public JPanel getPanel() {
		return panel;
	}


	public Color getB_Color() {
		return b_Color;
	}


	public String getId() {
		return id;
	}


	public RestaurantSearchView(String id) {
		super(":::�Ĵ�ã��:::");
		setLayout(null);
		this.id=id;
		//����
		lblId=new JLabel(id);
		tfSearch = new JTextField();
		listRestaurantView = new JList<>();
		cBoxGrade=new JComboBox<>();
		cBoxCategory=new JComboBox<>();
		btnRestaurant=new JButton();
		btnSearch=new JButton("�˻�");
		btnSelectAll=new JButton("��ü����");
		panel=new JPanel();
		
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
				return false;
			}
			
		};
		
		table=new JTable(dtm) {
			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}
		};
		
		table.setRowHeight(150);
		
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
		lblId.setBounds(40, 30, 50, 30);
		tfSearch.setBounds(580,20,150,30);
		btnSearch.setBounds(480,20,100,28);
		cBoxCategory.setBounds(30,65,100,20);
		cBoxGrade.setBounds(135,65,100,20);
		scroll.setBounds(30,90,700,600);
		btnSelectAll.setBounds(630,65,100,20);
		panel.setBounds(0,0, 800,800);
		
		//������Ʈ ����
		add(lblId);
		add(tfSearch);
		add(btnSearch);
		add(scroll);
		add(cBoxCategory);
		add(cBoxGrade);
		add(btnSelectAll);
		add(panel);
		
		lblId.setFont(new Font("SanSerif",Font.BOLD,15));
		panel.setBackground(Color.WHITE);
		btnSelectAll.setFont(new Font("SanSerif",Font.PLAIN,12));
		btnSelectAll.setBackground(b_Color);
		btnSelectAll.setBorderPainted(false);
		btnSelectAll.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("SanSerif",Font.BOLD,14));
		btnSearch.setBackground(b_Color);
		btnSearch.setBorderPainted(false);
		btnSearch.setForeground(Color.WHITE);
		btnSelectAll.setForeground(Color.WHITE);
		cBoxCategory.setBackground(Color.WHITE);
		cBoxGrade.setBackground(Color.WHITE);
		
		setBounds(500,100,800,800);
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
