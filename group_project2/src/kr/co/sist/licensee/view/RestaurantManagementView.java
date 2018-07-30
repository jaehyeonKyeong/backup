package kr.co.sist.licensee.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.licensee.controller.RestaurantManagementViewEvt;
import kr.co.sist.licensee.controller.licenssenameDate;

@SuppressWarnings("serial")
public class RestaurantManagementView extends JFrame {
	private JButton btnRegistration, btnChange, btnRemove,btnNew;
	private JList<String> jRestaurantList;
	private JLabel lblLicencing;
	private DefaultTableModel dtmRestaurant;
	private JTable jtRestaurant;
	String id;
	
	public RestaurantManagementView(licenssenameDate ld) {
		super("사업자 식당관리");
		this.id=ld.getName();
		
		//////식당목록 시작///////
		String[] data = { "식당" };
		dtmRestaurant = new DefaultTableModel(data, 0) {

			public boolean isCellEditable(int row, int column) {
				return false;
			}// isCellEditable{
		};

		jtRestaurant = new JTable(dtmRestaurant);
		JScrollPane jsp = new JScrollPane(jtRestaurant);

		//////식당목록 끝///////
		
		
		btnRegistration = new JButton("등록");
		btnChange = new JButton("수정");
		btnRemove = new JButton("삭제");
		btnNew= new JButton("새로고침");
		lblLicencing = new JLabel(ld.getName() + "님의 식당");
		jRestaurantList = new JList<String>();

		add(btnRegistration);
		add(btnChange);
		add(btnRemove);
		add(btnNew);
		add(lblLicencing);


		// 수동배치
		setLayout(null);

		lblLicencing.setBounds(30, 10, 100, 30);
		btnRegistration.setBounds(50, 180, 60, 30);
		btnChange.setBounds(120, 180, 60, 30);
		btnRemove.setBounds(185, 180, 60, 30);
		btnNew.setBounds(250, 180,100, 30);

		jsp.setBounds(30, 40, 330, 120);
		add(jsp);

		setBounds(120, 40, 400, 250);
		setVisible(false);
		setResizable(false);
		
		RestaurantManagementViewEvt rmve = new RestaurantManagementViewEvt(this);
		btnRegistration.addActionListener(rmve);
		btnChange.addActionListener(rmve);
		btnRemove.addActionListener(rmve);
		btnNew.addActionListener(rmve);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// RestaurantManagementView

	public JButton getBtnRegistration() {
		return btnRegistration;
	}

	public JButton getBtnChange() {
		return btnChange;
	}

	public JButton getBtnRemove() {
		return btnRemove;
	}

	public JButton getBtnNew() {
		return btnNew;
	}

	public JList<String> getjRestaurantList() {
		return jRestaurantList;
	}

	public JLabel getLblLicencing() {
		return lblLicencing;
	}

	public DefaultTableModel getDtmRestaurant() {
		return dtmRestaurant;
	}

	public JTable getJtRestaurant() {
		return jtRestaurant;
	}

	public String getId() {
		return id;
	}

	
/*	public static void main(String[] args) {
		new RestaurantManagementView();
	}// main
*/
	
	
}// class
