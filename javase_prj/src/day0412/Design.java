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
		super("������ Ŭ����");
		// ������Ʈ�� �����ϰ�, ��ġ�ϴ� ��
		Button btn1 = new Button("UseMenuComponent");
		btn1.setFont(new Font("SansSerif",Font.BOLD,30));
		Button btn2 = new Button("Exit");
		btn2.setFont(new Font("Dialog",Font.ITALIC|Font.BOLD,30));
		// ������Ʈ�� �̺�Ʈ�� ����ϴ���
		// JVM�� �̺�Ʈ�� �����ϰ� �ش� ��ü�� ȣ���� �� �ֵ��� ���)
		// �ܺ� Ŭ������ �̺�Ʈ�� ó���Ѵ�.
		// EventTest et=new EventTest();
		// btn1.addActionListener(et); //��ư���� actionEvent�� �߻��ϸ� ��ϵ� et�� ���� ó���϶�
		
		//anonymous inner class
//		btn1.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Ŭ��!!!!!!!!");
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
		

		// container component�� �Ϲ� component�� ��ġ
		Panel p = new Panel();
		p.add(btn1);
		p.add(btn2);

		// frame�� ��ġ
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
			System.out.println("Inner class�� ó��!!!");
			new Homework1();
			dispose();
		}
		
	}
	
	//////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) {
		new Design();
	}

}
