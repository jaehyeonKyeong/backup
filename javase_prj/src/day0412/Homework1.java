package day0412;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * �޴� ������Ʈ�� ���.
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class Homework1 extends Frame {
	public Homework1() {
		super("�ڹ� �޸�");
		TextArea taText=new TextArea("Text Area");
		// �޴��� ����
		MenuBar mb = new MenuBar();
		// �޴� ����
		Menu menuFile = new Menu("����");
		Menu menuFormat = new Menu("����");
		Menu menuHelp =new Menu("����");
		
		// �޴� ������ ����

		// file
		MenuItem miNew = new MenuItem("����");
		MenuItem miOpen=new MenuItem("����");
		MenuItem miSave = new MenuItem("����");
		MenuItem miNewName=new MenuItem("���̸�");
		MenuItem miClose = new MenuItem("�ݱ�");

		// Format
		MenuItem miTxtFrmt = new MenuItem("�۲�");
		
		//menuHelp
		MenuItem miInfo=new MenuItem("�޸��� ����");
		
		

		// 4.�޴��������� �޴��� ��ġ
		//����
		menuFile.add(miNew);
		menuFile.addSeparator();
		menuFile.add(miOpen);
		menuFile.add(miSave);
		menuFile.add(miNewName);
		//���м�
		menuFile.addSeparator();
		menuFile.add(miClose);
		
		//����
		menuFormat.add(miTxtFrmt);
		
		//����
		menuHelp.add(miInfo);

		// �޴��ٿ� ��ġ

		mb.add(menuFile);
		mb.add(menuFormat);
		mb.add(menuHelp);

		// 6.�޴��ٸ� frame�� ����
		setMenuBar(mb);
		//text area ��ġ
		add(taText);

		setSize(350, 350);
		setVisible(true);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}

		});

	}

	public static void main(String[] args) {
		new Homework1();
	}

}
