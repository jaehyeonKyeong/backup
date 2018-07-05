package kr.co.sist.javamemo.controller;

import java.awt.FileDialog;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.JOptionPane;

import kr.co.sist.javamemo.view.JavaMemo;
import kr.co.sist.javamemo.view.MemoFont;
import kr.co.sist.javamemo.view.MemoInfo;

/**
 * ���� â���� �߻��ϴ� �̺�Ʈ ó��Ŭ����
 * 
 * @author owner
 */
public class JavaMemoEvt extends WindowAdapter implements ActionListener {
	private JavaMemo jm;
	private String noteData;// 1.null
	private String openFlag; // ������ ������ ��ΰ�����ǰ� �� �� �۾��� empty�� ó��

	public JavaMemoEvt(JavaMemo jm) {// ������ ��ü�� �Է¹޾�
		this.jm = jm;// has a ���� ����
		noteData = "";
		openFlag = "";
	}// constructor

	@Override
	public void windowClosing(WindowEvent we) {
		// TextArea�� ������ �ִٸ� ���忩�θ� ���� �����Ѵ�.
		jm.dispose();
	}// windowClosing

	public void windowClosed(WindowEvent we) {
		// �����찡 ����Ǹ� ���� �۲� ������ ���Ͽ� �����ϰ� ���α׷��� �����Ѵ�.

		File dir = new File("c:/dev/momodata");
		// ������ ������ ������ ����
		dir.mkdir();
		File file = new File(dir.getAbsolutePath() + "/memo.dat");
		// TextArea�� ������ �۲�������
		Font font = jm.getTaNote().getFont();
		// ��ü ��Ʈ���� ����Ͽ� ����
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(font);
			oos.flush();
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
			} catch (IOException ie) {
				ie.printStackTrace();
			} // try
		} // finally

	}// windowClosed

	@Override

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == jm.getMiNew()) {
			openFlag = "";
			newProcess();

		}
		if (ae.getSource() == jm.getMiOpen()) {
			try {
				openProcess();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(jm, "������ �о���̴� ���߿� ������ �߻��� �κ� ����?");
			}
		}
		if (ae.getSource() == jm.getMiSave()) {
			try {
				saveProcess();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(jm, "���� ������ ������ �߻��߾��");
				e.printStackTrace();
			} // catch
		}
		if (ae.getSource() == jm.getMiNewSave()) {
			try {
				newSaveProcess();
			} catch (IOException e) {// throws�� ���ܸ� ������ ȣ���� ������ ���ܸ� ��Ƽ� ó���� �� �ִ�.
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(jm, "���� �۾� �� ������ �߻��߾��");
				e.printStackTrace();
			}
		}
		if (ae.getSource() == jm.getMiClose()) {
			jm.dispose();
		}
		if (ae.getSource() == jm.getMiFont()) {
			new MemoFont(jm);
		}
		if (ae.getSource() == jm.getMiInfo()) {
			new MemoInfo(jm);
		}

	}// actionPerformed

	/**
	 * ������ �������� �� ����ó�� TextArea�� ������ ���ٰ� ���ο� ������ �Է��� �� ������ �����ϸ� ���忩�θ� ���´�. �Ǵ� ���� �۾���
	 * ����� ������ ���� ������ ���õǸ� TextArea�� ������ �ʱ�ȭ ��Ų��. ����� ������ �ִٸ� ���忩�θ� ������ TextArea������
	 * �ʱ�ȭ ��Ų��.
	 */
	private void newProcess() {
		TextArea ta = jm.getTaNote();
		String note = ta.getText();

		boolean flag = false;// ������ ������ �������� ���� ����
		if (!note.equals("") && !noteData.equals(note)) {// ������ ����� ������ ������ ���� �Ϥ�����
			switch (JOptionPane.showConfirmDialog(jm, "���� ������ '�������'�� �����Ͻðڽ��ϱ�?")) {
			case JOptionPane.OK_OPTION:
				try {
					newSaveProcess();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(jm, "���� �� ������ �߻��߾��.");
				}
				flag = false;
				break;

			case JOptionPane.NO_OPTION:// �������� �ʰ� ����
				flag = false;
				break;

			default:// ��Ұ� �Ǿ�����, �����ư�� ��������.
				flag = true;
				break;
			}// end switch
		} // if
		if (!flag) {
			ta.setText("");// �ʱ�ȭ
			// �������� Ÿ��Ʋ���� ������ ����
			jm.setTitle("�޸��� [�� ��]");
			noteData = ta.getText();
		}

	}// newProcess

	/**
	 * ���⸦ Ŭ�������� textArea�� ������ �����Ѵٸ� = ���忩�θ� ���� ���� ���μ����� ź������ ���� ���̾�α׸� �����Ѵ�.
	 * 
	 * @throws IOException
	 */
	private void openProcess() throws IOException {

		// ó�� ������ TextArea�� ����� ���� ��ư�� ������ �� T.A�� ������ �ٸ��� üũ�Ͽ� ������ ������ ����� ���� �� �� ���⸦
		// �����Ѵ�.
		boolean openFlag = false;
		if (!noteData.equals(jm.getTaNote().getText())) {
			switch (JOptionPane.showConfirmDialog(jm, "����� ������ �����Ͻðڽ��ϱ�?")) {
			case JOptionPane.OK_OPTION:
				break;
			case JOptionPane.NO_OPTION:
				break;
			default:
				openFlag = true;// ��ҳ� x�� ��������

			}
		}
		if (!openFlag) {

			FileDialog fdOpen = new FileDialog(jm, "�޸��� ����", FileDialog.LOAD);
			fdOpen.setVisible(true);

			String path = fdOpen.getDirectory();
			String file = fdOpen.getFile();
			if (path != null && file != null) {
				jm.setTitle("�޸��� [" + path + file + "]");

				File selectFile = new File(path + file);

				if (selectFile.exists()) {// ������ ����
					// ������ ������ �о���̱� ���� ������ ���Ͽ� stream�� ����.
					BufferedReader br = null;
					try {
						br = new BufferedReader(new FileReader(selectFile));
						String read = "";
						// ������ ������ ������
						TextArea ta = jm.getTaNote();
						ta.setText("");
						while ((read = br.readLine()) != null) {
							// TextArea�� �߰��Ѵ�
							ta.append(read);
							ta.append("\n");
						}
						noteData = ta.getText();// ��� ������ ������ ����� ������ ������ �����Ѵ�.
						// ���� �۾��� �Ϸ�Ǹ� ����ÿ� flag�� ����� ���� �Ҵ�.
						this.openFlag = selectFile.getAbsolutePath();
					} finally {// �ݵ�� ����ȴ�.
						if (br != null) {// br�� null�� �ƴҶ�
							br.close();// instance method ��� ��üȭ br stream�� ����
						} // ������ ����
					}
				} else {
					JOptionPane.showMessageDialog(jm, selectFile, "������ �������� �ʽ��ϴ�", JOptionPane.ERROR_MESSAGE);
				}
			}
		} // openFlag
	}// openProcess

	/**
	 * ������ Ŭ�������� TextArea�� ������ �ִٸ� ���̸����� ���忩�θ� ���� ó���ϰ�, ���⸦ �� ��, ����ڰ� ������ ������ �� ������
	 * ������ ���� ���θ� ���� ������ ���ϸ� ���� �����.
	 * 
	 * @throws IOException
	 * 
	 */
	private void saveProcess() throws IOException {
		// FileDialog fdSave = new FileDialog(jm, "�޸��� ����", FileDialog.SAVE);
		// fdSave.setVisible(true);
		//
		// String path = fdSave.getDirectory();
		// String file = fdSave.getName();
		if (openFlag.equals("")) {// ���Ⱑ �ƴ� �ٸ� �۾���(����, ����, �ٸ��̸����� ����)
			// ���ϸ��� �����Ƿ� ���ϸ��� �����ϵ��� �����ϰ� ����(�� �̸��� ������ ����)
			newSaveProcess();
		} else {// ���� : ���ϸ��� �̹� ���� �ϴ� ���
			// �ش� ���Ͽ� ���� �����.
			// ���� ��Ʈ���� ����� ���̸����� �����ϴ� method�� �ڵ�� �����ϹǷ� �ش� stream�� ����ϴ� �ڵ带 method�� �̾Ƴ� ȣ���ϰ�
			// �Ǹ� �ߺ��ڵ带 ���ϼ� �ֽ��ϴ�.
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(openFlag));
				// TextArea�� ������ stream�� ���
				String saveData = jm.getTaNote().getText();
				bw.write(saveData);// stream�� ������ ���
				bw.flush();// stream�� ��ϵǾ��ִ� ���� ����
				jm.setTitle("�޸��� [���� " + openFlag + "]");
				noteData = saveData;
			} finally {
				if (bw != null) {
					bw.close();
				}
			}
		} // if

	}// saveProcess

	/**
	 * ���̸����� ����������
	 * 
	 * @throws IOException
	 * 
	 */
	private void newSaveProcess() throws IOException {
		FileDialog fdSave = new FileDialog(jm, "�޸��� ����", FileDialog.SAVE);
		fdSave.setVisible(true);

		String path = fdSave.getDirectory();
		String file = fdSave.getFile();
		if (path != null && file != null) {

			// ������ ���� �ȿ� ������ �����Ͽ�
			BufferedWriter bw = null;
			try {
				File saveFile = new File(path + file);

				bw = new BufferedWriter(new FileWriter(saveFile));
				// TextArea�� ������ ����� ���Ͽ� �����Ѵ�.
				String saveData = jm.getTaNote().getText();
				bw.write(saveData);// stream�� ������ ���
				bw.flush();// stream�� ��ϵ� ������ �������� ����
				// ���Ͽ� ����� �Ϸ�Ǿ��ٸ� Ÿ��Ʋ���� ������ �����Ѵ�.
				jm.setTitle("�޸��� [�� �̸����� ���� " + path + file + "]");
				// ����� ������ noteData�� �����Ͽ� ������ �񱳿� ����Ѵ�.
				noteData = saveData;
				openFlag = "";
			} finally {
				if (bw != null) {
					bw.close();// ����� ���� stream�� �����־� �޸� ������ ���� (�ݵ�� �����ؾ���)
				}
			} // finally

		} // if
	}// newSaveProcess

}// class
