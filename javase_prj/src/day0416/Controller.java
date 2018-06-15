package day0416;

import java.awt.Color;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * �̺�Ʈ ó�� �ڵ� (View�� ��ü�� �޾ƿͼ� ���ؾ� �Ѵ�) 
 * �̺�Ʈ ó�� �ڵ� Ŭ������ ȭ�� ������ ��ü�� ������ �־�� �Ѵ�.
 * (has-a����: ���� object���� -�ٸ� Ŭ������ ��ü�� �� Ŭ������ ���޹޾� �ٸ� Ŭ������ ��ü ����� ����ϴ°� - �ٸ�Ŭ������ ��ü�� ������ ���� - �ٸ� Ŭ������ ����� ����Ϸ��� ��ü��.�� �������� ����Ѵ�.)
 * (<-> is-a����:�ٸ� Ŭ������ ��ü�� ����Ͽ� �� ��ü�� �����ϴ� ����� ����Ѵ�.- �ٸ�Ŭ������ ��ü�� ������ �������� �ʴ´�. �ٸ� Ŭ������ ����� ����ó�� ����� �� �ִ�.)
 * 
 * @author owner
 */
public class Controller extends WindowAdapter implements KeyListener {
	
	private View view;
//	private int keyCnt;//����Ű�� Ƚ���� ����
	
	public Controller(View view) {
		this.view=view;
	}// constructor
	
	

	@Override
	public void windowClosing(WindowEvent e) {
		view.dispose();//has a ������ ��� ���
	}



	@Override
	public void keyTyped(KeyEvent e) {
//		System.out.println("2. Typed : ����Ű�� ���ڸ� ������ ����ϰ� ( ����Pressed�� ������ �� �� �� �ִ�)");
//		keyCnt++;
//		int tempLeft=model.countProcess(keyCnt);
		TextArea ta=view.getTaContent();
		//TextArea�� �Էµ� ���ڼ��� ���ͼ� ���
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
//		System.out.println("1. Pressed : ����Ű�� �Է������� �ް�");
		if(e.getKeyCode()==8) {
			view.getTaContent().setEditable(true);
		}

	}// keyPressed

	@Override
	public void keyReleased(KeyEvent e) {
//		System.out.println("3. Released : ����Ű�� �ö���鼭 ����Ű�� �Է������� ����� �� ����");

	}// keyReleased

}
