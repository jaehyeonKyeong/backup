package day0413;

import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;


@SuppressWarnings({ "serial", "unused" })
public class UseEventCompare extends Frame implements ActionListener {
	
	private Button btnOpen,btnSave,btnClose;
	private TextArea taPath;
	
	
	public UseEventCompare() {
		super("�̺�Ʈ ��");
		btnOpen=new Button("���� ����");//FileDialog
		btnSave=new Button("���� ����");
		btnClose=new Button("�ݱ�");
		taPath=new TextArea();
		
		Panel center=new Panel();
		
		center.add(btnOpen);
		center.add(btnSave);
		center.add(btnClose);
		
		add(center,"North");
		add("Center",taPath);
		btnOpen.addActionListener(this);
		btnSave.addActionListener(this);
		btnClose.addActionListener(this);
		
		setBounds(300,300,600,400);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
//		System.out.println(ae.getSource());
		if(ae.getSource()==btnOpen) {
			FileDialog fdOpen=new FileDialog(this, "���� ����", FileDialog.LOAD);
			fdOpen.setVisible(true);//window component�̹Ƿ� setVisible()�� ȣ���Ͽ� ����ڿ��� ���������� �ؾ��Ѵ�.
			//���� ��� ���
			String path=fdOpen.getDirectory();
			//���� �� ���
			String fileName=fdOpen.getFile();
			//��� ��ư ��������
			if(path!=null) {
			taPath.append("���� : "+path+"\\"+fileName+"\n");
			}
		}
		if(ae.getSource()==btnSave) {
			FileDialog fdSave=new FileDialog(this, "���� ����", FileDialog.SAVE);
			fdSave.setVisible(true);
			String path=fdSave.getDirectory();
			String fileName=fdSave.getFile();
			if(path!=null) {
			taPath.append("���� : "+path+"\\"+fileName+"\n");
			}
		}
		if(ae.getSource()==btnClose) {
			dispose();
		}
	}

	public static void main(String[] args) {
		new UseEventCompare();
	}


}
