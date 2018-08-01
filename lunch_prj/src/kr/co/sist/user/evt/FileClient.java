package kr.co.sist.user.evt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileClient{
	Socket client;

	public void uploadProcess(File file)throws IOException {
		//1.���� ����
		client=new Socket("211.63.89.140", 20000);

		//2.���ε� �� ������ ���� ���
		int size=0; //������ byte�迭�� �� ����
		int len=0; //�о���� ����ũ��
		String fileName="";
		//HDD�� �ѹ� �о� ���϶��� ũ�⸸ŭ �����ϱ����� �迭
		byte[] readData=new byte[512]; 

		FileInputStream fis=null;
		DataOutputStream dos=null;

		DataInputStream dis=null;
		FileOutputStream fos=null;
		
		try {	
			fis=new FileInputStream(file); //������ ������ ��Ʈ������ ����
			

			dos=new DataOutputStream(client.getOutputStream());

			//���ϸ��� ������
			dos.writeUTF(file.getName());
			dos.flush();
			
			dis=new DataInputStream(client.getInputStream());
			//�������� �������� ����ũ��(byte[512]�� ����) �޴´�.
			size=dis.readInt();
			readData=new byte[512];
			//3.������ HDD�� File�� ����
			//3-1. ���� ��Ʈ�� ����
			file=new File("C:/Users/kimkn/git/backup/lunch_prj/src/kr/co/sist/img/"+file.getName());
			fos=new FileOutputStream(file); //���� �� ����

			while(size >0) {
				len=dis.read(readData);
				fos.write(readData, 0, len);
				fos.flush();
				size--;
			}//end while
			fos.close();

		}finally {

			if(dos !=null) {dos.close();} //end if
			if(dis !=null) {dis.close();} //end if
			if(client !=null) {client.close();} //end if
		}//end finally
	}//uploadProcess
	

}//class
