package day0413;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class UseKeyEvent extends Frame implements KeyListener {
	private TextArea taOutput;
	private TextField tfInput;

	public UseKeyEvent() {
		super("키보드 이벤트 연습");

		taOutput = new TextArea();
		tfInput = new TextField();

		add("North", tfInput);
		add("Center", taOutput);

		// 이벤트 등록
		//tfInput.addKeyListener(this);
		
		UseKeyEvent.KeyEvt ke= this.new KeyEvt();
		tfInput.addKeyListener(ke);
		setBounds(200, 200, 400, 600);
		setVisible(true);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}

		});

	}// constructor

	// 추상method가 하나 이상인 이벤트 처리 클래스를 미리 구현한 Adapter클래스를 사용하여 이벤트 처리(필요한 추상 method만
	// 구현하면 됨)
	/////////////////////// inner class 시작
	// ////////////////////////////////////////////////////

	public class KeyEvt extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent ke) {
			// 눌린 키의 코드값과 눌린키의 문자를 얻어와서 TextArea에 추가
			//ASCII code값이 아니므로, 대문자나 소문자가 코드 값이 같다.
			int code=ke.getKeyCode();
			char character=ke.getKeyChar();
			
			taOutput.append(character+"("+code+")\n");
			if(code==27) {
//				dispose();
			}
		}

	}
	/////////////////////////////// inner class 끝
	/////////////////////////////// ////////////////////////////////////////////

	// //abstract method
	// @Override
	// public void keyTyped(KeyEvent e) {
	// // TODO Auto-generated method stub
	// System.out.println("keyTyped");
	// }
	//
	// @Override
	// public void keyPressed(KeyEvent e) {
	// // TODO Auto-generated method stub
	// System.out.println("keyPressed");
	// }
	//
	// @Override
	// public void keyReleased(KeyEvent e) {
	// // TODO Auto-generated method stub
	// System.out.println("keyReleased");
	// }
	//
	public static void main(String[] args) {
		new UseKeyEvent();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
