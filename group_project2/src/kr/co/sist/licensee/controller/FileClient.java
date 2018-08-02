package kr.co.sist.licensee.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class FileClient {

	public void uploadProcess(File file)throws IOException {//�̹����� ���ϼ����� �ø��� ����
		//1.���� ����
		Socket client=new Socket("211.63.89.140", 13880);

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
			

			dos=new DataOutputStream(client.getOutputStream()); //���Ͽ� ����� outStream
			
			//������ Ŭ���̾�Ʈ�� ���ϴ� method�� ������.
			String ImageType="[rest_img_up]";
			dos.writeUTF(ImageType);
			dos.flush();

			dos.writeUTF(file.getName());//���ϸ� ������
			dos.flush();
			
			fis=new FileInputStream(file);//������ ���� 
			
			readData=new byte[512];
			
			while((len=fis.read(readData))>0) {
				size++; //�о���� �迭�� ���� //Ŭ���̾�Ʈ�� �������� �� ������ ũ��
			}//end while
			//���� ������ �迭 ��(�� ����)�� ����ٸ� ������ ���´�.
			//������ ������ �̵��� �����ʹ� �ٽ� ������ ó������ ���ư��� �ʴ´�.
			fis.close(); 

			fis=new FileInputStream(file); //������ ���� ���� �����Ѵ�.
			dos=new DataOutputStream(client.getOutputStream());
			//����ũ�⸦ ������
			dos.writeInt(size);

			while(size>0) { //������ ������ ������(byte[] ����Ʈ �迭�� ��Ʈ) �����Ѵٸ�
				len=fis.read(readData); //�о���� ������ ũ�⸸ŭ ũ�⸦ ���
				dos.write(readData,0,len); //�����Ϳ� ������ ũ������� ���
				dos.flush(); //������
				size--; //������ ������ �ѹ� ���� �� ���� ũ�⸦ ���δ�.
			}//end while
			
		}finally {
			if(fis !=null) {fis.close();} //end if
			if(dos !=null) {dos.close();} //end if
		}
	}//uploadProcess
	public void downloadProcess()throws IOException{
		
	}
}// class
