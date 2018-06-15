package kr.co.sist.javamemo.view;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;

import kr.co.sist.javamemo.controller.JavaMemoEvt;

/**
 * 메모장 메인 화면
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class JavaMemo extends Frame {
	private TextArea taNote;
	private MenuItem miNew, miOpen, miSave, miNewSave, miClose, miFont, miInfo;

	public JavaMemo(Font font) {
		super("메모장 [제목없음]");
		
		//contents
		taNote = new TextArea();
		
		//menuItem
		miNew = new MenuItem("새글");
		miOpen = new MenuItem("열기");
		miSave = new MenuItem("저장");
		miNewSave = new MenuItem("다른 이름으로 저장");
		miClose = new MenuItem("닫기");
		miFont = new MenuItem("글꼴");
		miInfo = new MenuItem("메모장 정보");
		
		//menu
		Menu menuFile=new Menu("파일");
		Menu menuFont=new Menu("서식");
		Menu menuInfo=new Menu("도움말");
		
		//menuItem 배치
		menuFile.add(miNew);
		menuFile.addSeparator();
		menuFile.add(miOpen);
		menuFile.add(miSave);
		menuFile.add(miNewSave);
		menuFile.addSeparator();
		menuFile.add(miClose);
		
		menuFont.add(miFont);
		
		menuInfo.add(miInfo);
		
		//메뉴를 메뉴바에 배치
		MenuBar mb=new MenuBar();
		mb.add(menuFile);
		mb.add(menuFont);
		mb.add(menuInfo);
		
		//메뉴바를 프레임에 설정
		setMenuBar(mb);
		//textArea를 프레임에 배치
		add("Center",taNote);
		
		if(font!=null) {//설정된 글꼴정보가 존재
			//글꼴정보를 TextArea에 설정한다.
			taNote.setFont(font);
			
		}
		
		//event 등록
		JavaMemoEvt jme=new JavaMemoEvt(this);
		miNew.addActionListener(jme);
		miOpen.addActionListener(jme);
		miSave.addActionListener(jme);
		miNewSave.addActionListener(jme);
		miClose.addActionListener(jme);
		miFont.addActionListener(jme);
		miInfo.addActionListener(jme);
		addWindowListener(jme);
		
		//window
		setBounds(100,100,900,700);
		setVisible(true);
	}// constructor

	public TextArea getTaNote() {
		return taNote;
	}

	public MenuItem getMiNew() {
		return miNew;
	}

	public MenuItem getMiOpen() {
		return miOpen;
	}

	public MenuItem getMiSave() {
		return miSave;
	}

	public MenuItem getMiNewSave() {
		return miNewSave;
	}

	public MenuItem getMiClose() {
		return miClose;
	}

	public MenuItem getMiFont() {
		return miFont;
	}

	public MenuItem getMiInfo() {
		return miInfo;
	}

}// class
