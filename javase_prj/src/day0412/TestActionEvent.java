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
// 1.이벤트를 처리할 listener 구현(버튼클릭(actionEvent발생)이벤트 처리하는 리스너 ActionListener)
public class TestActionEvent extends Frame implements ActionListener {
	private Label lblName;
	private TextField tfName;
	private Button btnAdd;

	private TextArea taOutput;

	@SuppressWarnings("unused")
	public TestActionEvent() {
		super("이름을 입력하세요.");
		lblName = new Label("이름");
		tfName = new TextField(8);
		btnAdd = new Button("입력");
		taOutput = new TextArea();
		Panel panelNorth = new Panel();

		// 버튼이 클릭됨을 JVM이 알 수 있도록 이벤트 등록
		btnAdd.addActionListener(this);
		tfName.addActionListener(this);

		// 배치
		// Container Component에 Component 배치
		panelNorth.add(lblName);
		panelNorth.add(tfName);
		panelNorth.add(btnAdd);

		// Window Component에 Container Component, component 배치
		add("North", panelNorth);
		add("Center", taOutput);

		// 크기 설정
		setBounds(250, 250, 600, 450);
		setVisible(true);

		// 윈도우 종료 이벤트 처리
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}

		});
	}// constructor

	// 2.이벤트가 발생 했을때 처리할 코드를 기술하는 method를 Override.
	@Override
	public void actionPerformed(ActionEvent e) {
		// textField의 값 얻기
		String name = tfName.getText();
		// textArea의 값 설정
		// taOutput.setText(name);
		// textArea의 값에 덧붙임
		if (!name.equals("")) {
			taOutput.append(name + "\n");
			// textField의 값 초기화
			tfName.setText("");
		}
	}

	public static void main(String[] args) {
		new TestActionEvent();
	}

}
