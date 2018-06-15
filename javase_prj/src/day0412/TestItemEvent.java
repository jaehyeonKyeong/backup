package day0412;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class TestItemEvent extends Frame implements ItemListener {
	private List leftList, rightList;

	public TestItemEvent() {
		super("������ �̺�Ʈ");
		
		leftList=new List();
		rightList=new List();
		
		leftList.add("���¹�");
		leftList.add("������");
		leftList.add("������");
		leftList.add("������");
		leftList.add("���ֿ�");
		leftList.add("�̻���");
		
		Panel centerPanel=new Panel();
		centerPanel.setLayout(new GridLayout(1, 2));
		
		//��ġ
		centerPanel.add(leftList);
		centerPanel.add(rightList);
		
		add(centerPanel,"Center");
		
		setBounds(100,200,300,500);
		setVisible(true);
		//�̺�Ʈ ���
		leftList.addItemListener(this);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});
	}// constructor

	@Override
	public void itemStateChanged(ItemEvent e) {
		//���� ����Ʈ���� ������ �������� �����ͼ�
		String item=leftList.getSelectedItem();
		//������ ����Ʈ�� �߰��ϰ�
		rightList.add(item);
		//���� ����Ʈ�� ������ �������� �����Ѵ�.
		leftList.remove(leftList.getSelectedIndex());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestItemEvent();
	}

}
