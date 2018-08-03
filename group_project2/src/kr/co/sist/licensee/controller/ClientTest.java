package kr.co.sist.licensee.controller;

import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;

import kr.co.sist.user.view.Login;

public class ClientTest extends JFrame implements ActionListener{
	JButton upload,download;
	
	public ClientTest() {
		super("Ŭ���̾�Ʈ �׽�Ʈ");
		upload=new JButton("���ε�");
		download=new JButton("�ٿ�ε�");
		setLayout(new FlowLayout());
		add(upload);
		add(download);
		upload.addActionListener(this);
		download.addActionListener(this);
		setSize(500,500);
		setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==upload) {
			upload();
		}
		if(e.getSource()==download) {
			new testDalog(this);
		}
		
	}
	
	public void upload() {
		FileDialog fd=new FileDialog(this, "����", FileDialog.LOAD);
		fd.setVisible(true);
		File file=new File(fd.getDirectory()+fd.getFile());
		FileClient fc=new FileClient();
		try {
			fc.restaurantUploadProcess(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String download() {
		FileClient fc= new FileClient();
		String rimg = null;
			try {
				rimg=fc.restaurantDownloadProcess("41");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return rimg;
	}

	
	public static void main(String[] args) {
		new ClientTest();
	}
	
}
