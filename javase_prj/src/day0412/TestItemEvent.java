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
		super("아이템 이벤트");
		
		leftList=new List();
		rightList=new List();
		
		leftList.add("지승민");
		leftList.add("이종민");
		leftList.add("경제현");
		leftList.add("이진영");
		leftList.add("최주오");
		leftList.add("이상훈");
		
		Panel centerPanel=new Panel();
		centerPanel.setLayout(new GridLayout(1, 2));
		
		//배치
		centerPanel.add(leftList);
		centerPanel.add(rightList);
		
		add(centerPanel,"Center");
		
		setBounds(100,200,300,500);
		setVisible(true);
		//이벤트 등록
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
		//왼쪽 리스트에서 선택한 아이템을 가져와서
		String item=leftList.getSelectedItem();
		//오른쪽 리스트에 추가하고
		rightList.add(item);
		//왼쪽 리스트의 선택한 아이템을 삭제한다.
		leftList.remove(leftList.getSelectedIndex());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestItemEvent();
	}

}
