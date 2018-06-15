package day0412;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Design extends Frame {
	public Design() {
		super("디자인 클래스");
		// 컴포넌트를 생성하고, 배치하는 일
		Button btn1 = new Button("UseMenuComponent");
		btn1.setFont(new Font("SansSerif",Font.BOLD,30));
		Button btn2 = new Button("Exit");
		btn2.setFont(new Font("Dialog",Font.ITALIC|Font.BOLD,30));
		// 컴포넌트를 이벤트에 등록하는일
		// JVM이 이벤트를 감지하고 해당 객체를 호출할 수 있도록 등록)
		// 외부 클래스가 이벤트를 처리한다.
		// EventTest et=new EventTest();
		// btn1.addActionListener(et); //버튼에서 actionEvent가 발생하면 등록된 et에 가서 처리하라
		
		//anonymous inner class
//		btn1.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("클릭!!!!!!!!");
//				
//			}
//		});
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		InnerEvt ie=this.new InnerEvt();
		btn1.addActionListener(ie);
		

		// container component에 일반 component를 배치
		Panel p = new Panel();
		p.add(btn1);
		p.add(btn2);

		// frame에 배치
		add(p);

		setBounds(100, 100, 500, 500);
		setVisible(true);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}

		});

	}// constructor
	
	///////////////////////////////INNER CLASS//////////////////////////////////////
	
	public class InnerEvt implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Inner class로 처리!!!");
			new Homework1();
			dispose();
		}
		
	}
	
	//////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) {
		new Design();
	}

}
