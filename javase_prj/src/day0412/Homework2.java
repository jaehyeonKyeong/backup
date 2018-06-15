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
		super("이름을 입력하세요.");
		lblName = new Label("이름");
		tfName = new TextField(8);
		btnAdd = new Button("입력");
		lblOutput = new Label("주소가 출력되는 Label입니다.");
		//map
		map=new HashMap<>();
		
		//map setting
		map.put("지승민","인천시 계양구");
		map.put("최주오","수원시 권선구");
		map.put("이종민","서울시 광진구");
		map.put("김대현","서울시 관악구");
		map.put("송재원","성남시 수정구");
		
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
		add("Center", lblOutput);

		// 크기 설정
		setBounds(250, 250, 350, 100);
		setVisible(true);

		// 윈도우 종료 이벤트 처리
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
			lblOutput.setText("주소록 업데이트 전");
		}
		tfName.setText("");


	}
	
	public static void main(String[] args) {
		new Homework2();

	}


}
