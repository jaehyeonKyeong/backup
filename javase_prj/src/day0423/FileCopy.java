package day0423;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class FileCopy extends JFrame implements ActionListener {

	private DefaultListModel<String> dlm;

	public FileCopy() {
		super("���Ϻ���");
		JButton btn = new JButton("������ ���� ����");
		dlm = new DefaultListModel<>();
		JList<String> jl = new JList<>(dlm);
		JScrollPane jsp = new JScrollPane(jl);
		jsp.setBorder(new TitledBorder("������ ���� ���"));
		JPanel panel = new JPanel();

		panel.add(btn);

		btn.addActionListener(this);

		add("Center", jsp);
		add("South", panel);

		setBounds(100, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}// constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			// copyFile();
			copyFileBinary();
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(this, "���� ������ ���� �߻��ſ� �˼��� �κ�");
		}
	}

	/**
	 * 8bit stream�� ����Ͽ� ���� ����: � ������ ����ϴ� �����̵� ���� ����
	 * 
	 * @throws IOException
	 */
	public void copyFileBinary() throws IOException {
		FileDialog fd = new FileDialog(this, "������ ���� ����", FileDialog.LOAD);
		fd.setVisible(true);

		String path = fd.getDirectory();
		String name = fd.getFile();

		if (name != null) {
			StringBuilder backupName = new StringBuilder(path + name);
			backupName.insert(backupName.lastIndexOf("."), "_backup_" + System.currentTimeMillis());

			File readFile = new File(path + name);
			File writeFile = new File(backupName.toString());

			// 8bit stream
			FileInputStream fis = null;
			FileOutputStream fos = null;
			try {
				fis = new FileInputStream(readFile);
				fos = new FileOutputStream(writeFile);
				@SuppressWarnings("unused")
				int temp = 0;
				// HDD�� �д� ũ�⸦ ����� �ڵ�
				byte[] readData=new byte[512];
				int cnt=0;
				while((cnt=fis.read(readData))!=-1) {//�ѹ��� 512byte�� �о�鿩���� �����Ѵٸ�
					fos.write(readData,	0, cnt);//�о���� �迭�� �����Ͱ� �ִ� ��ŭ stream�� ���
					fos.flush();
				}//while
				// HDD�� �д� �ӵ��� ������ �ڵ�
				// �Է� ��Ʈ������ 1byte�� �о�鿩 �����Ͱ� �����ϸ�
				// while ((temp = fis.read()) != -1) {
				// ��� ��Ʈ���� ����ϰ�
				// fos.write(temp);
				// ��� ��Ʈ���� ������ �����Ѵ�
				// fos.flush();
				// }
				dlm.addElement(path + name);
				JOptionPane.showMessageDialog(this, backupName.toString() + "���� ������ ����Ǿ����ϴ�.");
			} finally {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}

			}
		}

	}// copyFileBinary

	/**
	 * 16bit�� ����� ���� ���� : ���� ������ ���� text���ϸ� ���� ����.
	 * 
	 * @throws IOException
	 */
	public void copyFile() throws IOException {
		FileDialog fd = new FileDialog(this, "������ ���� ����", FileDialog.LOAD);
		fd.setVisible(true);

		String path = fd.getDirectory();
		String name = fd.getFile();

		if (name != null) {
			// ���� ���ϸ� : aaa.txt,������ ���ϸ� : aaa_backup_currentTimeMillies.txt
			StringBuilder backupName = new StringBuilder(path + name);
			backupName.insert(backupName.lastIndexOf("."), "_backup_" + System.currentTimeMillis());

			File readFile = new File(path + name);
			File writeFile = new File(backupName.toString());

			BufferedReader br = null;
			BufferedWriter bw = null;
			// �б⽺Ʈ��������� ���Ͽ��� ���پ� �о��� ���⽺Ʈ���� ����� ���Ͽ� ���
			try {
				br = new BufferedReader(new FileReader(readFile));
				bw = new BufferedWriter(new FileWriter(writeFile));
				String temp = "";
				while ((temp = br.readLine()) != null) {// �о�帰 ������ �ִٸ� //��Ʈ���� ����� ���Ͽ� ���
					bw.write(temp);// ��Ʈ���� �о��� ���� ����
					bw.flush();// ��Ʈ���� ��ϵ� ���� ����
				} // while
					// DefaultListModel���� ��ϵ� ���ϸ� �߰�
				dlm.addElement(path + name);
				JOptionPane.showMessageDialog(this, backupName.toString() + "���� ������ ����Ǿ����ϴ�.");
			} finally {
				if (br != null) {
					br.close();
				}
				if (bw != null) {
					bw.close();
				}

			} // finally

		} // if

	}// copyFile

	public static void main(String[] args) {
		new FileCopy();
	}

}
