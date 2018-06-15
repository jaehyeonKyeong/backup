package day0424;

import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Homework extends JFrame implements ActionListener {
	private JButton btnInput;
	File file;
	File[] fileArray;
	String[] name;
	JButton btnFile;
	ImageIcon[] ii;

	public Homework() {
		super("폴더 선택");
		btnInput = new JButton("버튼");
		Panel p = new Panel();

		btnInput.addActionListener(this);

		p.add(btnInput);
		add(p);
		setBounds(100, 100, 300, 150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}// constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		String dir = JOptionPane.showInputDialog(this, "폴더입력");
		file = new File(dir);
		fileArray = file.listFiles();
		if (file.exists()) {
			printData();
		}

	}

	private void printData() {
		int cnt = 0;
		JPanel view = new JPanel();
		for (int i = 0; i < fileArray.length; i++) {
			cnt++;
		}
		view.setLayout(new GridLayout(cnt, 1));
		for (int i = 0; i < fileArray.length; i++) {
			String s = fileArray[i].getName();
			btnFile = new JButton(s);
			if (fileArray[i].isFile()) {
				view.add(btnFile);
			} else {
				cnt--;
			}
		}
		view.setLayout(new GridLayout(cnt, 1));
		JScrollPane jspOutput = new JScrollPane(view);
		JOptionPane.showMessageDialog(null, jspOutput);

	}

	public static void main(String[] args) {
		new Homework();
	}
}
