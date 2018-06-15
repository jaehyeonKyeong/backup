package kr.co.sist.javamemo.view;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;

import kr.co.sist.javamemo.controller.JavaMemoEvt;

/**
 * �޸��� ���� ȭ��
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class JavaMemo extends Frame {
	private TextArea taNote;
	private MenuItem miNew, miOpen, miSave, miNewSave, miClose, miFont, miInfo;

	public JavaMemo(Font font) {
		super("�޸��� [�������]");
		
		//contents
		taNote = new TextArea();
		
		//menuItem
		miNew = new MenuItem("����");
		miOpen = new MenuItem("����");
		miSave = new MenuItem("����");
		miNewSave = new MenuItem("�ٸ� �̸����� ����");
		miClose = new MenuItem("�ݱ�");
		miFont = new MenuItem("�۲�");
		miInfo = new MenuItem("�޸��� ����");
		
		//menu
		Menu menuFile=new Menu("����");
		Menu menuFont=new Menu("����");
		Menu menuInfo=new Menu("����");
		
		//menuItem ��ġ
		menuFile.add(miNew);
		menuFile.addSeparator();
		menuFile.add(miOpen);
		menuFile.add(miSave);
		menuFile.add(miNewSave);
		menuFile.addSeparator();
		menuFile.add(miClose);
		
		menuFont.add(miFont);
		
		menuInfo.add(miInfo);
		
		//�޴��� �޴��ٿ� ��ġ
		MenuBar mb=new MenuBar();
		mb.add(menuFile);
		mb.add(menuFont);
		mb.add(menuInfo);
		
		//�޴��ٸ� �����ӿ� ����
		setMenuBar(mb);
		//textArea�� �����ӿ� ��ġ
		add("Center",taNote);
		
		if(font!=null) {//������ �۲������� ����
			//�۲������� TextArea�� �����Ѵ�.
			taNote.setFont(font);
			
		}
		
		//event ���
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
