package day0411;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * GridLayout:���ڷ��̾ƿ�<br>
 * ��� ���� ������ ���̾ƿ� : ��� ���� ���� ������ ũ�Ⱑ ����.<br>
 * component�� ��ġ�Ǹ� ���� ũ���� ��ġ ���� ����.
 * 
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class UseGridLayout extends Frame {
	public UseGridLayout() {
		super("GridLayout ����");
		
		//�������� ���õǴ� ������Ʈ
		Checkbox cb1=new Checkbox("����",true);
		Checkbox cb2=new Checkbox("�߱�����",false);
		Checkbox cb3=new Checkbox("��ȭ����",false);
		Checkbox cb4=new Checkbox("�籸",false);
		
		//�ϳ��� ���õǴ� ������Ʈ
		CheckboxGroup cbg=new CheckboxGroup();
		Checkbox rb1=new Checkbox("����", true, cbg);
		Checkbox rb2=new Checkbox("����", false, cbg);
		
		setLayout(new GridLayout(3,2));
		//������Ʈ ��ġ
		add(cb1);
		add(cb2);
		add(cb3);
		add(cb4);
		add(rb1);
		add(rb2);
		
		//ũ�� ����
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
