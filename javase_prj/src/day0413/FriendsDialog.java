package day0413;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

/**
 * 친구 추가용 자식창
 * @author owner
 */
@SuppressWarnings("serial")
public class FriendsDialog extends Dialog implements ActionListener {
	@SuppressWarnings("unused")
	private FriendsWindow fw;
	private TextField tfName;
	private Button btnAdd,btnClose;
	@SuppressWarnings("unused")
	private List<String> listFriends;
	
	public FriendsDialog(FriendsWindow fw) {
		super(fw,"친구추가",true);
		//modal여부:자식 창이 실행되었을때 부모창이 선택되지 않으면 "모달"이라고 하고 부모창이 선택되면 "비모달" 이라고한다
		listFriends=fw.getListFriends();//부모창이 현재가지고 있는 친구 목록 (callByReferance)
		//매개변수로 들어온 부모객체를 인스턴스 변쉐 할당
		this.fw=fw;
		
		Label lblTitle=new Label("친구추가");
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 25));
		
		Font font=new Font("SansSerif",Font.PLAIN,14);
		Label lblName=new Label("이름");
		tfName=new TextField(20);
		btnAdd=new Button("추가");
		btnClose=new Button("닫기");
		
		lblName.setFont(font);
		tfName.setFont(font);
		btnAdd.setFont(font);
		btnClose.setFont(font);
		
		Panel panCenter=new Panel();
		
		panCenter.add(lblName);
		panCenter.add(tfName);
		panCenter.add(btnAdd);
		panCenter.add(btnClose);
		
		//윈도우 컴포넌트(dialog)
		
		add("North",lblTitle);
		add("Center",panCenter);
		
		//이벤트 등록
		btnAdd.addActionListener(this);
		btnClose.addActionListener(this);
		tfName.addActionListener(this);
		tfName.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent ke) {
				if(ke.getKeyCode()==27) {
					dispose();
				}
			}
			
		});
		
		
		setBounds(fw.getX()+150,fw.getY()+200,350,200);
		//////dialog는 window 종료 이벤트가 항상 visible위에 있어야함.//////
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});
		//////////////////////////////////////////////////////
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==btnAdd||ae.getSource()==tfName) {
			//입력된 이름을 얻어와서
			//공백을 제거한 후
			String name=tfName.getText().replaceAll(" ", "");
			//부모창이 생성한 java.util.List에 추가하고
			listFriends.add(name);			
			//부모창에 보여지는 java.awt.List를 갱신한다.
			fw.setFriends();
			//다음 입력이 편하도록 TextField를 초기화
			tfName.setText("");
		}
		if(ae.getActionCommand().equals("닫기")){
			dispose();
		}
	}

}
