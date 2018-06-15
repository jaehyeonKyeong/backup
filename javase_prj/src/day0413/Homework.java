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
 * �޴� ������Ʈ�� ���.
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class Homework extends Frame implements ActionListener {
	TextArea taText;
	// �޴��� ����
	MenuBar mb;
	// �޴� ����
	Menu menuFile;
	Menu menuFormat;
	Menu menuHelp;

	// �޴� ������ ����

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
		super("�ڹ� �޸�");
		taText = new TextArea("Text Area");
		// �޴��� ����
		mb = new MenuBar();
		// �޴� ����
		menuFile = new Menu("����");
		menuFormat = new Menu("����");
		menuHelp = new Menu("����");

		// �޴� ������ ����

		// file
		miNew = new MenuItem("����");
		miOpen = new MenuItem("����");
		miSave = new MenuItem("����");
		miNewName = new MenuItem("���̸�");
		miClose = new MenuItem("�ݱ�");

		// Format
		miTxtFrmt = new MenuItem("�۲�");

		// menuHelp
		miInfo = new MenuItem("�޸��� ����");

		// 4.�޴��������� �޴��� ��ġ
		// ����
		menuFile.add(miNew);
		menuFile.addSeparator();
		menuFile.add(miOpen);
		menuFile.add(miSave);
		menuFile.add(miNewName);
		// ���м�
		menuFile.addSeparator();
		menuFile.add(miClose);

		// ����
		menuFormat.add(miTxtFrmt);

		// ����
		menuHelp.add(miInfo);

		// �޴��ٿ� ��ġ

		mb.add(menuFile);
		mb.add(menuFormat);
		mb.add(menuHelp);

		// 6.�޴��ٸ� frame�� ����
		setMenuBar(mb);
		// text area ��ġ
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
		if (ae.getSource() == miTxtFrmt) {// �۲� ��ư
			new HomeworkDialog(this);
		}

	}

}
