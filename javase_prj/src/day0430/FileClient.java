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
		super("���� ���ε� Ŭ���̾�Ʈ");
		btnUpload=new JButton("���� ���ε�");
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
		//1.���� ����
		String serverIp=JOptionPane.showInputDialog("���ε弭�� �ּ�\n)�� 211.63.89.xx");
		Socket client=new Socket(serverIp,20000);
		//2.���ε��� ������ ���� ���
		int size=0;//������ byte�迭�� �� ����;
		int len=0;//�о���� ���� ũ��
		//HDD�� �ѹ� �о���϶��� ũ�⸸ŭ �����ϱ����� �迭
		byte[]readData=new byte[512];
		
		FileInputStream fis=null;
		DataOutputStream dos=null;
		
		
		try {
			fis=new FileInputStream(file); //������ ������ ��Ʈ������ ����
			
			while((len=fis.read(readData))>0) {
				size++;//�о���� �迭�� ����
			}//end while
			//���� ������ �迭 �� (�� ����)�� ����ٸ� ������ ���´�.
			//������ ������ �̵��� �����ʹ� �ٽ� ������ ó������ ���ư��� �ʴ´�.
			fis.close();
			
			fis=new FileInputStream(file);//���������� ���� �����Ѵ�.
			dos=new DataOutputStream(client.getOutputStream());
			
			//���� ���� ������
			dos.writeUTF(file.getName());
			//���� ũ�⸦ ������
			dos.writeInt(size);			
			
			while(size>0) {//������ ������ ������ (byte[]) �����Ѵٸ�
				len=fis.read(readData);
				dos.write(readData,0,len);//�����Ϳ� ������ ũ������� ���
				dos.flush();
				size--;//������ ������ �ѹ� ������ ���� ũ�⸦ ���δ�.
				
			}//end while
			
			
			dos=new DataOutputStream(client.getOutputStream());
			
			JOptionPane.showMessageDialog(this, file+"�� ���� �Ǿ����ϴ�.");
			
		}finally {
			if(fis !=null) {fis.close();}//end if
			if(dos!=null) {dos.close();}//end if
			if(client !=null) {client.close();}
		}//end
		
				
	}//uploadProcess
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		FileDialog fd=new FileDialog(this, "���ε����� ����", FileDialog.LOAD);
		fd.setVisible(true);
		String path=fd.getDirectory();
		String name=fd.getFile();
		
		
		switch(JOptionPane.showConfirmDialog(this, name+"������ ���ε� �Ͻðڽ��ϱ�?")) {
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
