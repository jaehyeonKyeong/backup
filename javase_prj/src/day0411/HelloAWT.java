package day0411;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *AWT를 사용한 component programming
 * @author owner
 */
@SuppressWarnings("serial")
//1.window 컴포넌트를 상속받는다.
public class HelloAWT extends Frame{
	public HelloAWT() {
		super("안녕!AWT");
		//2.사용할 컴포넌트 생성
		Button btn= new Button("이것은 버튼");
		Label lbl=new Label("이것은 이름표");
		//3.배치관리자에게 배치(부착)
		add("Center",btn);
		add("East",lbl);
		
		setSize(500,250);
		setVisible(true);
		
		//윈도우 종료 이벤트 처리 : anonymous inner class
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose(); //윈도우 종료하는 일 System.exit(0);
			}//windowClosing
			
		});
	}//Constructor
	public static void main(String[] args) {
		new HelloAWT();
	}

}
