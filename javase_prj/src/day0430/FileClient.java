package day0430;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FileClient extends JFrame implements ActionListener{
	
	JButton btnUpload;
	
	public FileClient() {
		super("파일 업로드 클라이언트");
		btnUpload=new JButton("파일 업로드");
		JPanel panel=new JPanel();
		panel.add(btnUpload);
		
		add("Center",panel);
		setBounds(100,200,300,300);
		setVisible(true);
		
		btnUpload.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}//windowClosing
		});
	}//FileClient
	
	public void uploadProcess(File file) throws IOException {
		//1.소켓 열고
		String serverIp=JOptionPane.showInputDialog("업로드서버 주소\n)예 211.63.89.xx");
		Socket client=new Socket(serverIp,20000);
		//2.업로드할 파일의 정보 얻기
		int size=0;//보내는 byte배열의 총 갯수;
		int len=0;//읽어들인 실제 크기
		//HDD가 한번 읽어들일때의 크기만큼 저장하기위한 배열
		byte[]readData=new byte[512];
		
		FileInputStream fis=null;
		DataOutputStream dos=null;
		
		
		try {
			fis=new FileInputStream(file); //선택한 파일을 스트림으로 연결
			
			while((len=fis.read(readData))>0) {
				size++;//읽어들인 배열의 갯수
			}//end while
			//보낼 파일의 배열 수 (총 갯수)를 얻었다면 연결을 끊는다.
			//파일의 끝으로 이동한 포인터는 다시 파일의 처음으로 돌아가지 않는다.
			fis.close();
			
			fis=new FileInputStream(file);//보내기위해 새로 연결한다.
			dos=new DataOutputStream(client.getOutputStream());
			
			//파일 명을 보내고
			dos.writeUTF(file.getName());
			//파일 크기를 보내고
			dos.writeInt(size);			
			
			while(size>0) {//전송할 파일의 갯수가 (byte[]) 존재한다면
				len=fis.read(readData);
				dos.write(readData,0,len);//데이터와 파일의 크기까지를 기록
				dos.flush();
				size--;//파일의 내용을 한번 보낼때 마다 크기를 줄인다.
				
			}//end while
			
			
			dos=new DataOutputStream(client.getOutputStream());
			
			JOptionPane.showMessageDialog(this, file+"이 전송 되었습니다.");
			
		}finally {
			if(fis !=null) {fis.close();}//end if
			if(dos!=null) {dos.close();}//end if
			if(client !=null) {client.close();}
		}//end
		
				
	}//uploadProcess
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		FileDialog fd=new FileDialog(this, "업로드파일 선택", FileDialog.LOAD);
		fd.setVisible(true);
		String path=fd.getDirectory();
		String name=fd.getFile();
		
		
		switch(JOptionPane.showConfirmDialog(this, name+"파일을 업로드 하시겠습니까?")) {
		case JOptionPane.OK_OPTION:
			File file=new File(path+name);
			try {
				uploadProcess(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
	
		}//end switch
	}//actionPerformed
	

	
	public static void main(String[] args) {
		new FileClient();
	}


}
