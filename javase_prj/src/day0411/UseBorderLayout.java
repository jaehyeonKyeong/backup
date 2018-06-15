package day0411;

import java.awt.*;
import java.awt.event.*;

/**
 * BorderLayout : 경계레이아웃<br>
 * Container component의 기본 레이아웃<br>
 * 각 위치(South,Noth,west,east)를 설정하여 컴포넌트를 배치한다<br>
 * add("위치",배치할 컴포넌트);<br>
 * add(BorderLayout.상수명, 배치할 컴포턴트);<br>
 * add(컴포넌트); 위치를 설정하지 않으면 Center에 배치된다<br>
 * 
 * @author owner
 */
//1.Window Component 상속
@SuppressWarnings("serial")
public class UseBorderLayout extends Frame {
	
	public UseBorderLayout() {
		super("BorderLayout과 Component의 사용");//title바에 메시지를 설정 할 수 있음
		//2.사용할 Component를 생성
		Button btnNorth=new Button("북쪽");
		Button btnEast=new Button("동쪽"); 
		TextArea taCenter=new TextArea();
		TextField tfSouth=new TextField();
		Label lblWest=new Label("서쪽");
		
		//레이아웃 매니저 설정
//		setLayout(new BorderLayout());
		//배치 : 배치될 위치 설정
		add("North",btnNorth);//문자열 사용
		add(BorderLayout.CENTER,taCenter);//constant
		add(BorderLayout.EAST,btnEast);
		add(BorderLayout.WEST,lblWest);
		add(BorderLayout.SOUTH,tfSouth);
		
		setSize(400,400);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});
	}// Constructor

	public static void main(String[] args) {
		new UseBorderLayout();
	}

}
