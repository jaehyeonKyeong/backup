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
		super("파일업로드 서버");
		taUpload = new TextArea();
		

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(new TitledBorder("업로드 목록"));
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
		//서버소켓 열고
		try {
			server=new ServerSocket(20000);
			taUpload.setText("파일업로드 서버 동작\n");
			Socket socket=null;
			DataInputStream dis=null;
			FileOutputStream fos=null;
			int size=0;//보내오는 파일의 크기(배열의 총 갯수)
			int len=0;//한번에 보내오는 byte[]내 채워진 크기
			String fileName="";
			byte[] readData=null;//클라이언트가 보내오는 파일의 binary를 받기 위한 배열
			
			File file=null;
			while(true) {
				//1-2 접속자 소켓을 받는다.
				socket=server.accept();
			//2.클라이언트가 보내오는 파일 정보 순서대로 받고
				//2-1.소켓에서 스트림 연결
				dis=new DataInputStream(socket.getInputStream());
				fileName=dis.readUTF();//클라이언트가 보내오는 파일명 받기
				size=dis.readInt();
				readData=new byte[512];
				//3.서버의 HDD에 File 로 쓴다.
				//3-1.파일 스트림 연결
				file =new File("C:/dev/workspace/javase_prj/src/upload/"+fileName);
				fos=new FileOutputStream(file);
				while(size>0) {
					//3.서버의 HDD에 File로 씁니다.
					len=dis.read(readData);
					fos.write(readData, 0, len);
					fos.flush();
					size--;					
				}//end while
				fos.close();
				
				taUpload.append(socket.getInetAddress()+"/"+file.getCanonicalPath()+"로 업로드\n");
				
				
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
