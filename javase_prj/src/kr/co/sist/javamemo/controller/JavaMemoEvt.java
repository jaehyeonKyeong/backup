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
 * 메인 창에서 발생하는 이벤트 처리클래스
 * 
 * @author owner
 */
public class JavaMemoEvt extends WindowAdapter implements ActionListener {
	private JavaMemo jm;
	private String noteData;// 1.null
	private String openFlag; // 파일이 열리면 경로가저장되고 그 외 작업은 empty로 처리

	public JavaMemoEvt(JavaMemo jm) {// 디자인 객체를 입력받아
		this.jm = jm;// has a 관계 설정
		noteData = "";
		openFlag = "";
	}// constructor

	@Override
	public void windowClosing(WindowEvent we) {
		// TextArea의 내용이 있다면 저장여부를 묻고 종료한다.
		jm.dispose();
	}// windowClosing

	public void windowClosed(WindowEvent we) {
		// 윈도우가 종료되면 현재 글꼴 정보를 파일에 저장하고 프로그램을 종료한다.

		File dir = new File("c:/dev/momodata");
		// 폴더가 없으면 폭더를 생성
		dir.mkdir();
		File file = new File(dir.getAbsolutePath() + "/memo.dat");
		// TextArea에 설정된 글꼴정보를
		Font font = jm.getTaNote().getFont();
		// 객체 스트림에 사용하여 저장
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
				JOptionPane.showMessageDialog(jm, "파일을 읽어들이는 도중에 문제가 발생한 부분 인정?");
			}
		}
		if (ae.getSource() == jm.getMiSave()) {
			try {
				saveProcess();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(jm, "파일 저장중 문제가 발생했어요");
				e.printStackTrace();
			} // catch
		}
		if (ae.getSource() == jm.getMiNewSave()) {
			try {
				newSaveProcess();
			} catch (IOException e) {// throws로 예외를 날리면 호출한 곳에서 예외를 모아서 처리할 수 있다.
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(jm, "저장 작업 중 문제가 발생했어요");
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
	 * 새글을 선택했을 때 업무처리 TextArea에 내용이 없다가 새로운 내용을 입력한 후 새글을 선택하면 저장여부를 묻는다. 또는 열기 작업후
	 * 변경된 내용이 없이 새글이 선택되면 TextArea의 내용을 초기화 시킨다. 변경된 내용이 있다면 저장여부를 묻고나서 TextArea내용을
	 * 초기화 시킨다.
	 */
	private void newProcess() {
		TextArea ta = jm.getTaNote();
		String note = ta.getText();

		boolean flag = false;// 새글을 수행할 것인지에 대한 변수
		if (!note.equals("") && !noteData.equals(note)) {// 열었던 내용과 현재의 내용이 같지 암ㅎ으면
			switch (JOptionPane.showConfirmDialog(jm, "변경 내용을 '제목없음'에 저장하시겠습니까?")) {
			case JOptionPane.OK_OPTION:
				try {
					newSaveProcess();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(jm, "저장 중 문제가 발생했어요.");
				}
				flag = false;
				break;

			case JOptionPane.NO_OPTION:// 저장하지 않고 새글
				flag = false;
				break;

			default:// 취소가 되었을때, 종료버튼이 눌렀을때.
				flag = true;
				break;
			}// end switch
		} // if
		if (!flag) {
			ta.setText("");// 초기화
			// 프레임의 타이틀바의 내용을 변경
			jm.setTitle("메모장 [새 글]");
			noteData = ta.getText();
		}

	}// newProcess

	/**
	 * 열기를 클릭했을때 textArea의 내용이 존재한다면 = 저장여부를 묻고 저장 프로세스를 탄다음에 열기 다이얼로그를 제공한다.
	 * 
	 * @throws IOException
	 */
	private void openProcess() throws IOException {

		// 처음 열었던 TextArea의 내용과 열기 버튼을 눌렀을 때 T.A의 내용이 다른지 체크하여 저장할 것인지 물어보고 저장 한 후 열기를
		// 수행한다.
		boolean openFlag = false;
		if (!noteData.equals(jm.getTaNote().getText())) {
			switch (JOptionPane.showConfirmDialog(jm, "변경된 내용을 저장하시겠습니까?")) {
			case JOptionPane.OK_OPTION:
				break;
			case JOptionPane.NO_OPTION:
				break;
			default:
				openFlag = true;// 취소나 x를 눌렀을때

			}
		}
		if (!openFlag) {

			FileDialog fdOpen = new FileDialog(jm, "메모장 열기", FileDialog.LOAD);
			fdOpen.setVisible(true);

			String path = fdOpen.getDirectory();
			String file = fdOpen.getFile();
			if (path != null && file != null) {
				jm.setTitle("메모장 [" + path + file + "]");

				File selectFile = new File(path + file);

				if (selectFile.exists()) {// 파일이 존재
					// 파일의 내용을 읽어들이기 위해 선택한 파일에 stream을 연결.
					BufferedReader br = null;
					try {
						br = new BufferedReader(new FileReader(selectFile));
						String read = "";
						// 기존의 내용을 지운후
						TextArea ta = jm.getTaNote();
						ta.setText("");
						while ((read = br.readLine()) != null) {
							// TextArea에 추가한다
							ta.append(read);
							ta.append("\n");
						}
						noteData = ta.getText();// 방금 열었던 파일의 내용과 동일한 내용을 저장한다.
						// 열기 작업이 완료되면 저장시에 flag로 사용할 값을 할당.
						this.openFlag = selectFile.getAbsolutePath();
					} finally {// 반드시 실행된다.
						if (br != null) {// br이 null이 아닐때
							br.close();// instance method 사용 객체화 br stream을 끊음
						} // 오류를 막음
					}
				} else {
					JOptionPane.showMessageDialog(jm, selectFile, "파일이 존재하지 않습니다", JOptionPane.ERROR_MESSAGE);
				}
			}
		} // openFlag
	}// openProcess

	/**
	 * 저장을 클릭했을때 TextArea의 내용이 있다면 새이름으로 저장여부를 물어 처리하고, 열기를 한 후, 사용자가 내용을 변경한 후 저장을
	 * 누르면 저장 여부를 묻고 열었던 파일명에 덮어 씌운다.
	 * 
	 * @throws IOException
	 * 
	 */
	private void saveProcess() throws IOException {
		// FileDialog fdSave = new FileDialog(jm, "메모장 저장", FileDialog.SAVE);
		// fdSave.setVisible(true);
		//
		// String path = fdSave.getDirectory();
		// String file = fdSave.getName();
		if (openFlag.equals("")) {// 열기가 아닌 다른 작업들(새글, 저장, 다른이름으로 저장)
			// 파일명이 없으므로 파일명을 지정하도록 유도하고 저장(새 이름과 업무가 같다)
			newSaveProcess();
		} else {// 열기 : 파일명이 이미 존재 하는 경우
			// 해당 파일에 덮어 씌운다.
			// 저장 스트림의 사용은 새이름으로 저장하는 method내 코드와 동일하므로 해당 stream을 사용하는 코드를 method로 뽑아내 호출하게
			// 되면 중복코드를 줄일수 있습니다.
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(openFlag));
				// TextArea의 내용을 stream에 기록
				String saveData = jm.getTaNote().getText();
				bw.write(saveData);// stream에 내용을 기록
				bw.flush();// stream에 기록되어있는 내용 분출
				jm.setTitle("메모장 [저장 " + openFlag + "]");
				noteData = saveData;
			} finally {
				if (bw != null) {
					bw.close();
				}
			}
		} // if

	}// saveProcess

	/**
	 * 새이름으로 저장했을때
	 * 
	 * @throws IOException
	 * 
	 */
	private void newSaveProcess() throws IOException {
		FileDialog fdSave = new FileDialog(jm, "메모장 저장", FileDialog.SAVE);
		fdSave.setVisible(true);

		String path = fdSave.getDirectory();
		String file = fdSave.getFile();
		if (path != null && file != null) {

			// 선택한 폴더 안에 파일을 생성하여
			BufferedWriter bw = null;
			try {
				File saveFile = new File(path + file);

				bw = new BufferedWriter(new FileWriter(saveFile));
				// TextArea의 내용을 연결된 파일에 저장한다.
				String saveData = jm.getTaNote().getText();
				bw.write(saveData);// stream에 내용을 기록
				bw.flush();// stream에 기록된 내용을 목적지에 분출
				// 파일에 기록이 완료되었다면 타이틀바의 내용을 변경한다.
				jm.setTitle("메모장 [새 이름으로 저장 " + path + file + "]");
				// 변경된 내용을 noteData에 저장하여 다음번 비교에 사용한다.
				noteData = saveData;
				openFlag = "";
			} finally {
				if (bw != null) {
					bw.close();// 사용이 끝난 stream을 끊어주어 메모리 누수를 방지 (반드시 실행해야함)
				}
			} // finally

		} // if
	}// newSaveProcess

}// class
