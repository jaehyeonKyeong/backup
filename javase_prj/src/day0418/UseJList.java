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
 * MVC Pattern을 도입해서 만들어진 Component인 JList사용 Model:DefaultListModel View : JList
 * Controller:사용자가 만든 클래스
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
		super("MVC Pattern Class 사용");

		ujl = this;

		map = new HashMap<String, String>();// 16개 행 생성
		map.put("지승민", "반장이면서 착하다.조장도 맡고있다.:D");
		map.put("김대현", "갓대현,에이스,취미가 고상하다.XD");

		dlmNames = new DefaultListModel<String>();
		dlmNames.addElement("지승민");
		dlmNames.addElement("김대현");

		listNames = new JList<String>(dlmNames);

		jtfName = new JTextField();
		jtfSpec = new JTextField();
		lblOutput = new JLabel("이름을 선택하세요");

		lblOutput.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		jsp=new JScrollPane(listNames);

		// border
//		listNames.setBorder(new TitledBorder("이름 목록"));
		jsp.setBorder(new TitledBorder("이름목록"));
		jtfName.setBorder(new TitledBorder("이름 입력"));
		jtfSpec.setBorder(new TitledBorder("특징 입력"));
		lblOutput.setBorder(new TitledBorder("출력창"));

		// 배치
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

		// inner class 객체화
		UseJList.MouseEvt me = this.new MouseEvt();
		// 이벤트 등록
		// listNames.addListSelectionListener(this); //Swing에서 제공되는 이벤트
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
			if (me.getClickCount() == 1) {// 보여주기
				lblOutput.setText(name + " : " + map.get(name));
			}
			if (me.getClickCount() == 2) {// 삭제하기
				switch (JOptionPane.showConfirmDialog(ujl/* this는 먹히지 않음 */, name + "님의 정보를 삭제하실건가요?")) {
				case JOptionPane.OK_OPTION:
					// 선택된 데이터를 삭제
					dlmNames.removeElementAt(listNames.getSelectedIndex());
					map.remove(name);
				}

			}
		}

	}
	/////////////////////////////// inner class

	// 1.정수의 변수를 사용
	// int cnt = 0;

	// 2.boolean변수
	// boolean flag;
	//
	// @Override
	// public void valueChanged(ListSelectionEvent e) {
	// // if (cnt % 2 == 0) {
	// if (flag) {
	// System.out.println("값얻기 : " + listNames.getSelectedValue());
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
				// 이름과 특징이 입력되면서 model객체에 추가, map에 추가
				setMapData(name, spec);
			} else {
				JOptionPane.showMessageDialog(this, "이름과 특징을 빠짐없이 입력해주세요:O");
			} // end if
		} // end if
	}// actionPerformed

	private void setMapData(String name, String spec) {// model과 map에 데이터를 추가하는 일
		dlmNames.addElement(name);// model에 데이터 추가
		map.put(name, spec);// map에 데이터 추가

		jtfName.setText("");// TextField초기화
		jtfSpec.setText("");// TextField초기화
		jtfName.requestFocus();// 커서를 이동
	}

	public static void main(String[] args) {
		new UseJList();
	}
}
