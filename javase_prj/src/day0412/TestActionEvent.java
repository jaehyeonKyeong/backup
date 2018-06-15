package day0412;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
// 1.�̺�Ʈ�� ó���� listener ����(��ưŬ��(actionEvent�߻�)�̺�Ʈ ó���ϴ� ������ ActionListener)
public class TestActionEvent extends Frame implements ActionListener {
	private Label lblName;
	private TextField tfName;
	private Button btnAdd;

	private TextArea taOutput;

	@SuppressWarnings("unused")
	public TestActionEvent() {
		super("�̸��� �Է��ϼ���.");
		lblName = new Label("�̸�");
		tfName = new TextField(8);
		btnAdd = new Button("�Է�");
		taOutput = new TextArea();
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
		add("Center", taOutput);

		// ũ�� ����
		setBounds(250, 250, 600, 450);
		setVisible(true);

		// ������ ���� �̺�Ʈ ó��
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}

		});
	}// constructor

	// 2.�̺�Ʈ�� �߻� ������ ó���� �ڵ带 ����ϴ� method�� Override.
	@Override
	public void actionPerformed(ActionEvent e) {
		// textField�� �� ���
		String name = tfName.getText();
		// textArea�� �� ����
		// taOutput.setText(name);
		// textArea�� ���� ������
		if (!name.equals("")) {
			taOutput.append(name + "\n");
			// textField�� �� �ʱ�ȭ
			tfName.setText("");
		}
	}

	public static void main(String[] args) {
		new TestActionEvent();
	}

}
