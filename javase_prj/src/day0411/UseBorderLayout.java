package day0411;

import java.awt.*;
import java.awt.event.*;

/**
 * BorderLayout : ��跹�̾ƿ�<br>
 * Container component�� �⺻ ���̾ƿ�<br>
 * �� ��ġ(South,Noth,west,east)�� �����Ͽ� ������Ʈ�� ��ġ�Ѵ�<br>
 * add("��ġ",��ġ�� ������Ʈ);<br>
 * add(BorderLayout.�����, ��ġ�� ������Ʈ);<br>
 * add(������Ʈ); ��ġ�� �������� ������ Center�� ��ġ�ȴ�<br>
 * 
 * @author owner
 */
//1.Window Component ���
@SuppressWarnings("serial")
public class UseBorderLayout extends Frame {
	
	public UseBorderLayout() {
		super("BorderLayout�� Component�� ���");//title�ٿ� �޽����� ���� �� �� ����
		//2.����� Component�� ����
		Button btnNorth=new Button("����");
		Button btnEast=new Button("����"); 
		TextArea taCenter=new TextArea();
		TextField tfSouth=new TextField();
		Label lblWest=new Label("����");
		
		//���̾ƿ� �Ŵ��� ����
//		setLayout(new BorderLayout());
		//��ġ : ��ġ�� ��ġ ����
		add("North",btnNorth);//���ڿ� ���
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
