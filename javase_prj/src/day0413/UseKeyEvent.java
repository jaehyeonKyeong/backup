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
		super("Ű���� �̺�Ʈ ����");

		taOutput = new TextArea();
		tfInput = new TextField();

		add("North", tfInput);
		add("Center", taOutput);

		// �̺�Ʈ ���
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

	// �߻�method�� �ϳ� �̻��� �̺�Ʈ ó�� Ŭ������ �̸� ������ AdapterŬ������ ����Ͽ� �̺�Ʈ ó��(�ʿ��� �߻� method��
	// �����ϸ� ��)
	/////////////////////// inner class ����
	// ////////////////////////////////////////////////////

	public class KeyEvt extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent ke) {
			// ���� Ű�� �ڵ尪�� ����Ű�� ���ڸ� ���ͼ� TextArea�� �߰�
			//ASCII code���� �ƴϹǷ�, �빮�ڳ� �ҹ��ڰ� �ڵ� ���� ����.
			int code=ke.getKeyCode();
			char character=ke.getKeyChar();
			
			taOutput.append(character+"("+code+")\n");
			if(code==27) {
//				dispose();
			}
		}

	}
	/////////////////////////////// inner class ��
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
