package day0416;

import java.awt.Color;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 이벤트 처리 코드 (View의 객체를 받아와서 비교해야 한다) 
 * 이벤트 처리 코드 클래스는 화면 디자인 객체를 가지고 있어야 한다.
 * (has-a관계: 포함 object관계 -다른 클래스의 객체를 이 클래스가 전달받아 다른 클래스의 객체 기능을 사용하는것 - 다른클래스의 객체가 별도로 생성 - 다른 클래스의 기능을 사용하려면 객체명.의 문법으로 사용한다.)
 * (<-> is-a관계:다른 클래스의 객체를 사용하여 그 객체가 제공하는 기능을 사용한다.- 다른클래스의 객체를 별도로 생성하지 않는다. 다른 클래스의 기능을 내것처럼 사용할 수 있다.)
 * 
 * @author owner
 */
public class Controller extends WindowAdapter implements KeyListener {
	
	private View view;
//	private int keyCnt;//눌린키의 횟수를 설정
	
	public Controller(View view) {
		this.view=view;
	}// constructor
	
	

	@Override
	public void windowClosing(WindowEvent e) {
		view.dispose();//has a 관계의 기능 사용
	}



	@Override
	public void keyTyped(KeyEvent e) {
//		System.out.println("2. Typed : 눌린키가 문자를 가지면 출력하고 ( 이전Pressed와 조합이 될 수 도 있다)");
//		keyCnt++;
//		int tempLeft=model.countProcess(keyCnt);
		TextArea ta=view.getTaContent();
		//TextArea에 입력된 글자수를 얻어와서 계산
		int tempLeft=Model.countProcess(ta.getText().length());
		Label lbl=view.getLblOutput();
		lbl.setText(tempLeft+"/50");//call by reference
		if(tempLeft<0) {
			lbl.setForeground(Color.red);
			ta.setEditable(false);
//			ta.setText(ta.getText().substring(0, 50));
		}else {
			lbl.setForeground(Color.BLACK);
		}
		
	}// keyTyped

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
//		System.out.println("1. Pressed : 눌린키의 입력정보를 받고");
		if(e.getKeyCode()==8) {
			view.getTaContent().setEditable(true);
		}

	}// keyPressed

	@Override
	public void keyReleased(KeyEvent e) {
//		System.out.println("3. Released : 눌린키가 올라오면서 눌린키의 입력정보를 사용할 수 있음");

	}// keyReleased

}
