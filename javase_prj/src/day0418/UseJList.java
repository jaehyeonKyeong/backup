package day0418;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * MVC Pattern�� �����ؼ� ������� Component�� JList��� Model:DefaultListModel View : JList
 * Controller:����ڰ� ���� Ŭ����
 * 
 * @author owner
 */
@SuppressWarnings({ "serial", "unused" })
public class UseJList extends JFrame implements ActionListener/* , ListSelectionListener */ {
	private JList<String> listNames;
	private DefaultListModel<String> dlmNames;
	private JTextField jtfName, jtfSpec;
	private JLabel lblOutput;
	private UseJList ujl;
	private JScrollPane jsp;

	private Map<String, String> map;

	public UseJList() {
		super("MVC Pattern Class ���");

		ujl = this;

		map = new HashMap<String, String>();// 16�� �� ����
		map.put("���¹�", "�����̸鼭 ���ϴ�.���嵵 �ð��ִ�.:D");
		map.put("�����", "������,���̽�,��̰� ����ϴ�.XD");

		dlmNames = new DefaultListModel<String>();
		dlmNames.addElement("���¹�");
		dlmNames.addElement("�����");

		listNames = new JList<String>(dlmNames);

		jtfName = new JTextField();
		jtfSpec = new JTextField();
		lblOutput = new JLabel("�̸��� �����ϼ���");

		lblOutput.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		jsp=new JScrollPane(listNames);

		// border
//		listNames.setBorder(new TitledBorder("�̸� ���"));
		jsp.setBorder(new TitledBorder("�̸����"));
		jtfName.setBorder(new TitledBorder("�̸� �Է�"));
		jtfSpec.setBorder(new TitledBorder("Ư¡ �Է�"));
		lblOutput.setBorder(new TitledBorder("���â"));

		// ��ġ
		setLayout(null);

//		listNames.setBounds(15, 30, 350, 200);
		jsp.setBounds(15, 30, 350, 200);
		jtfName.setBounds(15, 240, 350, 40);
		jtfSpec.setBounds(15, 290, 350, 40);
		lblOutput.setBounds(15, 340, 350, 60);

//		add(listNames);
		add(jsp);
		add(jtfName);
		add(jtfSpec);
		add(lblOutput);

		// inner class ��üȭ
		UseJList.MouseEvt me = this.new MouseEvt();
		// �̺�Ʈ ���
		// listNames.addListSelectionListener(this); //Swing���� �����Ǵ� �̺�Ʈ
		listNames.addMouseListener(me);
		jtfName.addActionListener(this);
		jtfSpec.addActionListener(this);

		setBounds(100, 100, 400, 450);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// Constructor

	/////////////////////////////// inner class

	public class MouseEvt extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent me) {
			String name = dlmNames.get(listNames.getSelectedIndex());
			if (me.getClickCount() == 1) {// �����ֱ�
				lblOutput.setText(name + " : " + map.get(name));
			}
			if (me.getClickCount() == 2) {// �����ϱ�
				switch (JOptionPane.showConfirmDialog(ujl/* this�� ������ ���� */, name + "���� ������ �����Ͻǰǰ���?")) {
				case JOptionPane.OK_OPTION:
					// ���õ� �����͸� ����
					dlmNames.removeElementAt(listNames.getSelectedIndex());
					map.remove(name);
				}

			}
		}

	}
	/////////////////////////////// inner class

	// 1.������ ������ ���
	// int cnt = 0;

	// 2.boolean����
	// boolean flag;
	//
	// @Override
	// public void valueChanged(ListSelectionEvent e) {
	// // if (cnt % 2 == 0) {
	// if (flag) {
	// System.out.println("����� : " + listNames.getSelectedValue());
	// }
	// flag = !flag;
	// // }
	// // cnt++;
	// }

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == jtfName) {
			jtfSpec.requestFocus();
		} // end if
		if (ae.getSource() == jtfSpec) {
			String name = jtfName.getText().trim();
			String spec = jtfSpec.getText().trim();
			if (!name.equals("") && !spec.equals("")) {
				// �̸��� Ư¡�� �ԷµǸ鼭 model��ü�� �߰�, map�� �߰�
				setMapData(name, spec);
			} else {
				JOptionPane.showMessageDialog(this, "�̸��� Ư¡�� �������� �Է����ּ���:O");
			} // end if
		} // end if
	}// actionPerformed

	private void setMapData(String name, String spec) {// model�� map�� �����͸� �߰��ϴ� ��
		dlmNames.addElement(name);// model�� ������ �߰�
		map.put(name, spec);// map�� ������ �߰�

		jtfName.setText("");// TextField�ʱ�ȭ
		jtfSpec.setText("");// TextField�ʱ�ȭ
		jtfName.requestFocus();// Ŀ���� �̵�
	}

	public static void main(String[] args) {
		new UseJList();
	}
}
