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
		super("파일복사");
		JButton btn = new JButton("복사할 파일 선택");
		dlm = new DefaultListModel<>();
		JList<String> jl = new JList<>(dlm);
		JScrollPane jsp = new JScrollPane(jl);
		jsp.setBorder(new TitledBorder("복사한 파일 목록"));
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
			JOptionPane.showMessageDialog(this, "파일 복사중 문제 발생매우 죄송한 부분");
		}
	}

	/**
	 * 8bit stream을 사용하여 파일 복사: 어떤 형식을 사용하는 파일이든 복사 가능
	 * 
	 * @throws IOException
	 */
	public void copyFileBinary() throws IOException {
		FileDialog fd = new FileDialog(this, "복사할 파일 선택", FileDialog.LOAD);
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
				// HDD의 읽는 크기를 고려한 코드
				byte[] readData=new byte[512];
				int cnt=0;
				while((cnt=fis.read(readData))!=-1) {//한번에 512byte를 읽어들여값이 존제한다면
					fos.write(readData,	0, cnt);//읽어들인 배열을 데이터가 있는 만큼 stream에 기록
					fos.flush();
				}//while
				// HDD의 읽는 속도를 무시한 코드
				// 입력 스트림에서 1byte를 읽어들여 데이터가 존재하면
				// while ((temp = fis.read()) != -1) {
				// 출력 스트림에 기록하고
				// fos.write(temp);
				// 출력 스트림의 내용을 분출한다
				// fos.flush();
				// }
				dlm.addElement(path + name);
				JOptionPane.showMessageDialog(this, backupName.toString() + "으로 파일이 복사되었습니다.");
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
	 * 16bit를 사용한 파일 복사 : 독자 포멧이 없는 text파일만 복사 가능.
	 * 
	 * @throws IOException
	 */
	public void copyFile() throws IOException {
		FileDialog fd = new FileDialog(this, "복사할 파일 선택", FileDialog.LOAD);
		fd.setVisible(true);

		String path = fd.getDirectory();
		String name = fd.getFile();

		if (name != null) {
			// 원본 파일명 : aaa.txt,복사할 파일명 : aaa_backup_currentTimeMillies.txt
			StringBuilder backupName = new StringBuilder(path + name);
			backupName.insert(backupName.lastIndexOf("."), "_backup_" + System.currentTimeMillis());

			File readFile = new File(path + name);
			File writeFile = new File(backupName.toString());

			BufferedReader br = null;
			BufferedWriter bw = null;
			// 읽기스트림에연결된 파일에서 한줄씩 읽어드려 쓰기스트림에 연결된 파일에 기록
			try {
				br = new BufferedReader(new FileReader(readFile));
				bw = new BufferedWriter(new FileWriter(writeFile));
				String temp = "";
				while ((temp = br.readLine()) != null) {// 읽어드린 내용이 있다면 //스트림에 연결된 파일에 기록
					bw.write(temp);// 스트림에 읽어들니 내용 쓰기
					bw.flush();// 스트림에 기록된 내용 분출
				} // while
					// DefaultListModel에서 기록된 파일명 추가
				dlm.addElement(path + name);
				JOptionPane.showMessageDialog(this, backupName.toString() + "으로 파일이 복사되었습니다.");
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
