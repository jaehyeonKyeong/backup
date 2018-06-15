package day0412;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class Homework2 extends Frame implements ActionListener {
	private Label lblName;
	private TextField tfName;
	private Button btnAdd;

	private Label lblOutput;
	
	Map<String,String> map;
	
	public Homework2() {
		super("�̸��� �Է��ϼ���.");
		lblName = new Label("�̸�");
		tfName = new TextField(8);
		btnAdd = new Button("�Է�");
		lblOutput = new Label("�ּҰ� ��µǴ� Label�Դϴ�.");
		//map
		map=new HashMap<>();
		
		//map setting
		map.put("���¹�","��õ�� ��籸");
		map.put("���ֿ�","������ �Ǽ���");
		map.put("������","����� ������");
		map.put("�����","����� ���Ǳ�");
		map.put("�����","������ ������");
		
		Panel panelNorth = new Panel();

		// ��ư�� Ŭ������ JVM�� �� �� �ֵ��� �̺�Ʈ ���
		btnAdd.addActionListener(this);
		tfName.addActionListener(this);

		// ��ġ
		// Container Component�� Component ��ġ
		panelNorth.add(lblName);
		panelNorth.add(tfName);
		panelNorth.add(btnAdd);

		// Window Component�� Container Component, component ��ġ
		add("North", panelNorth);
		add("Center", lblOutput);

		// ũ�� ����
		setBounds(250, 250, 350, 100);
		setVisible(true);

		// ������ ���� �̺�Ʈ ó��
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}

		});
		
	}//constructor
	@Override
	public void actionPerformed(ActionEvent e) {
		String key=tfName.getText();
		String value=map.get(key);
		if(map.containsKey(key)) {
		lblOutput.setText(value);
		}else {
			lblOutput.setText("�ּҷ� ������Ʈ ��");
		}
		tfName.setText("");


	}
	
	public static void main(String[] args) {
		new Homework2();

	}


}
