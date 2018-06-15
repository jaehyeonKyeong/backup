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
		super("이벤트 비교");
		btnOpen=new Button("파일 열기");//FileDialog
		btnSave=new Button("파일 저장");
		btnClose=new Button("닫기");
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
			FileDialog fdOpen=new FileDialog(this, "파일 열기", FileDialog.LOAD);
			fdOpen.setVisible(true);//window component이므로 setVisible()을 호출하여 사용자에게 보여지도록 해야한다.
			//파일 경로 얻기
			String path=fdOpen.getDirectory();
			//파일 명 얻기
			String fileName=fdOpen.getFile();
			//취소 버튼 눌렀을때
			if(path!=null) {
			taPath.append("열기 : "+path+"\\"+fileName+"\n");
			}
		}
		if(ae.getSource()==btnSave) {
			FileDialog fdSave=new FileDialog(this, "파일 저장", FileDialog.SAVE);
			fdSave.setVisible(true);
			String path=fdSave.getDirectory();
			String fileName=fdSave.getFile();
			if(path!=null) {
			taPath.append("저장 : "+path+"\\"+fileName+"\n");
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
