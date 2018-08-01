package kr.co.sist.licensee.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;



public class FileClient {
	Socket client;

	public void downloadProcess(File file) {
		try {
			client=new Socket("211.63.89.140", 55000);
			
			DataInputStream dis = null;
			DataOutputStream dos = null;
			
			int size = 0;// �������� ������ ũ��(�迭�� �� ����)
			int len = 0;// �ѹ��� �������� byte[]�� ä���� ũ��
			
			String fileName = "";
			byte[] readData = null;// Ŭ���̾�Ʈ�� �������� ������ binary�� �ޱ� ���� �迭
			
			FileInputStream fis = null;
			
			while (true) {
				// 2-1.���Ͽ��� ��Ʈ�� ����
				dis = new DataInputStream(client.getInputStream());

				fileName = dis.readUTF();// Ŭ���̾�Ʈ�� �������� "���ϸ�" �ޱ�
				System.out.println(fileName);
				file = new File("C:/Users/kimkn/git/backup/group_project2/src/kr/co/sist/img/" + fileName);
				fis = new FileInputStream(file); // ������ ������ ��Ʈ������ ����
				
				readData= new byte[512];
				while ((len = fis.read(readData)) > 0) {
					size++;// �о���� �迭�� ����
				} // end while
					// ���� ������ �迭 �� (�� ����)�� ����ٸ� ������ ���´�.
					// ������ ������ �̵��� �����ʹ� �ٽ� ������ ó������ ���ư��� �ʴ´�.
				fis.close();

				fis = new FileInputStream(file);// ���������� ���� �����Ѵ�.
				dos = new DataOutputStream(client.getOutputStream());
				dos.writeInt(size);
				
				System.out.println(file.exists());
				
				while (size > 0) {// ������ ������ ������ (byte[]) �����Ѵٸ�
					len = fis.read(readData);
					dos.write(readData, 0, len);// �����Ϳ� ������ ũ������� ���
					dos.flush();
					size--;// ������ ������ �ѹ� ������ ���� ũ�⸦ ���δ�.
				} // end while
				
				if (fis != null) {fis.close();}
				if (dos != null) {dos.close();}
				if (client!=null) {client.close();}
				
			}//end while
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void uploadProcess(File file)throws IOException {
		//1.���� ����
		client=new Socket("211.63.89.140", 55000);

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
