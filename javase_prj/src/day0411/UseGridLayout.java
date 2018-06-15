package day0411;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * GridLayout:격자레이아웃<br>
 * 행과 열로 구성된 레이아웃 : 모든 행의 열의 갯수와 크기가 같다.<br>
 * component가 배치되면 고유 크기대로 배치 되지 않음.
 * 
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class UseGridLayout extends Frame {
	public UseGridLayout() {
		super("GridLayout 연습");
		
		//여러개가 선택되는 컴포넌트
		Checkbox cb1=new Checkbox("게임",true);
		Checkbox cb2=new Checkbox("야구관람",false);
		Checkbox cb3=new Checkbox("영화감상",false);
		Checkbox cb4=new Checkbox("당구",false);
		
		//하나만 선택되는 컴포넌트
		CheckboxGroup cbg=new CheckboxGroup();
		Checkbox rb1=new Checkbox("남자", true, cbg);
		Checkbox rb2=new Checkbox("여자", false, cbg);
		
		setLayout(new GridLayout(3,2));
		//컴포넌트 배치
		add(cb1);
		add(cb2);
		add(cb3);
		add(cb4);
		add(rb1);
		add(rb2);
		
		//크기 설정
		setSize(450,250);
		setVisible(true);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});
		
	}//constructor
	public static void main(String[] args) {
		new UseGridLayout();
	}

}
