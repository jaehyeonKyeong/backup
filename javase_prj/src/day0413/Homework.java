package day0413;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 메뉴 컴포넌트의 사용.
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class Homework extends Frame implements ActionListener {
	TextArea taText;
	// 메뉴바 생성
	MenuBar mb;
	// 메뉴 생성
	Menu menuFile;
	Menu menuFormat;
	Menu menuHelp;

	// 메뉴 아이템 생성

	// file
	MenuItem miNew;
	MenuItem miOpen;
	MenuItem miSave;
	MenuItem miNewName;
	MenuItem miClose;

	// Format
	MenuItem miTxtFrmt;

	// menuHelp
	MenuItem miInfo;

	public Homework() {
		super("자바 메모");
		taText = new TextArea("Text Area");
		// 메뉴바 생성
		mb = new MenuBar();
		// 메뉴 생성
		menuFile = new Menu("파일");
		menuFormat = new Menu("서식");
		menuHelp = new Menu("도움말");

		// 메뉴 아이템 생성

		// file
		miNew = new MenuItem("새글");
		miOpen = new MenuItem("열기");
		miSave = new MenuItem("저장");
		miNewName = new MenuItem("새이름");
		miClose = new MenuItem("닫기");

		// Format
		miTxtFrmt = new MenuItem("글꼴");

		// menuHelp
		miInfo = new MenuItem("메모장 정보");

		// 4.메뉴아이템을 메뉴에 배치
		// 파일
		menuFile.add(miNew);
		menuFile.addSeparator();
		menuFile.add(miOpen);
		menuFile.add(miSave);
		menuFile.add(miNewName);
		// 구분선
		menuFile.addSeparator();
		menuFile.add(miClose);

		// 서식
		menuFormat.add(miTxtFrmt);

		// 도움말
		menuHelp.add(miInfo);

		// 메뉴바에 배치

		mb.add(menuFile);
		mb.add(menuFormat);
		mb.add(menuHelp);

		// 6.메뉴바를 frame에 설정
		setMenuBar(mb);
		// text area 배치
		add(taText);
		
		miTxtFrmt.addActionListener(this);

		setBounds(600,300,400, 400);
		setVisible(true);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}

		});

	}

	public static void main(String[] args) {
		new Homework();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == miTxtFrmt) {// 글꼴 버튼
			new HomeworkDialog(this);
		}

	}

}
