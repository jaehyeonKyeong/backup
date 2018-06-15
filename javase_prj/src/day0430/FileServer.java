package day0430;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class FileServer extends JFrame implements Runnable {

	private TextArea taUpload;
	private ServerSocket server;

	public FileServer() {
		super("���Ͼ��ε� ����");
		taUpload = new TextArea();
		

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(new TitledBorder("���ε� ���"));
		panel.add("Center",taUpload);
		taUpload.setEditable(false);
		taUpload.setBackground(Color.WHITE);
		

		add("Center", panel);
		
		setBounds(100, 100, 500, 600);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@SuppressWarnings("unused")
			public void windowclosing(WindowEvent we) {
					try {
						if (server != null) {
						server.close();}
					} catch (IOException ie) {
						ie.printStackTrace();
					}// end if
					
					dispose();
					
				} //windowClosing
		});

		Thread thread=new Thread(this);
		thread.start();//-> run()
		
	}// FileServer

	@Override
	public void run() {
		//�������� ����
		try {
			server=new ServerSocket(20000);
			taUpload.setText("���Ͼ��ε� ���� ����\n");
			Socket socket=null;
			DataInputStream dis=null;
			FileOutputStream fos=null;
			int size=0;//�������� ������ ũ��(�迭�� �� ����)
			int len=0;//�ѹ��� �������� byte[]�� ä���� ũ��
			String fileName="";
			byte[] readData=null;//Ŭ���̾�Ʈ�� �������� ������ binary�� �ޱ� ���� �迭
			
			File file=null;
			while(true) {
				//1-2 ������ ������ �޴´�.
				socket=server.accept();
			//2.Ŭ���̾�Ʈ�� �������� ���� ���� ������� �ް�
				//2-1.���Ͽ��� ��Ʈ�� ����
				dis=new DataInputStream(socket.getInputStream());
				fileName=dis.readUTF();//Ŭ���̾�Ʈ�� �������� ���ϸ� �ޱ�
				size=dis.readInt();
				readData=new byte[512];
				//3.������ HDD�� File �� ����.
				//3-1.���� ��Ʈ�� ����
				file =new File("C:/dev/workspace/javase_prj/src/upload/"+fileName);
				fos=new FileOutputStream(file);
				while(size>0) {
					//3.������ HDD�� File�� ���ϴ�.
					len=dis.read(readData);
					fos.write(readData, 0, len);
					fos.flush();
					size--;					
				}//end while
				fos.close();
				
				taUpload.append(socket.getInetAddress()+"/"+file.getCanonicalPath()+"�� ���ε�\n");
				
				
			}//end while
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		new FileServer();


	}// main

}// class
