package kr.co.sist.admin.evt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer extends Thread {
	// ������ ���� Ŭ���̾�Ʈ�� ���� �ɼ� ����.
	// Ŭ���̾�Ʈ�� ���� �ɾ��ָ� ������ �����ϴ�.
	private ServerSocket server;
	public static final int SERVER_PORT = 13880;
	// msg = [�̹��� ����_img_(���ε�/�ٿ�ε�)]
	public static final String RESTAURANT_IMAGE_UPLOAD = "[rest_img_up]"; // Ŭ���̾�Ʈ�� �������� msg������ ���� �޶�����.
	public static final String RESTAURANT_IMAGE_DOWNLOAD = "[rest_img_down]";
	public static final String REVIEW_IMAGE_UPLOAD = "[review_img_up]";
	public static final String REVIEW_IMAGE_DOWNLOAD = "[review_img_down]";
	public static final String MENU_IMAGE_UPLOAD = "[menu_img_up]";
	public static final String MENU_IMAGE_DOWNLOAD = "[menu_img_down]";

	private DataInputStream dis;
	private DataOutputStream dos;

	private FileInputStream fis;
	private FileOutputStream fos;

	@Override
	public void run() {
		try {
			server = new ServerSocket(SERVER_PORT);
			// Ŭ���̾�Ʈ���� ������ �̹��� ������ �����ϴ� ���� ���ִ� Ŭ����
			System.out.println("���� ����");
			Socket client = null;

			while (true) { // �ݺ��� ���� client�� �����Ҷ����� ��ٸ���(���� �������� ��)
				System.out.println("���Ӵ��");
				client = server.accept(); // ������ ��ȭ�� ���� ����

				System.out.println("������ : [" + client.getRemoteSocketAddress() + "]");

				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				// data Stream(network : client�� ����ϱ����� stream)
				String clientMsg = dis.readUTF(); // Ŭ���̾�Ʈ�� ���� ���� �ؾ� �ϴ� ���� ������ ���� ó���� msg�� ������ ��

				// client���� ������ ���ڿ� 6������ ���� �������� �ϴ� ���� �޶�����.
				switch (clientMsg) {
				case RESTAURANT_IMAGE_UPLOAD:// ��������̹����� ������ ���ε��Ѵ�.
					restaurantImgUpload();
					break;
				case RESTAURANT_IMAGE_DOWNLOAD:
					restaurantImgDownload();
					break;
//				case REVIEW_IMAGE_UPLOAD:
//					reviewImgUpload();
//					break;
//				case REVIEW_IMAGE_DOWNLOAD:
//					reviewImgDownload();
//					break;
//				case MENU_IMAGE_UPLOAD:
//					menuImgUpload();
//					break;
//				case MENU_IMAGE_DOWNLOAD:
//					menuImgDownload();
//					break;
				default:
					//�ƹ��� ������ ������ default�� ���� �ٽ� while���� ź��.
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void restaurantImgDownload() { // Ŭ���̾�Ʈ�� ������� �̹����� �������� �ٿ�ε� �ذ���.
		
	}

	private void restaurantImgUpload() throws IOException {// ��������̹����� ������ ���ε��Ѵ�.
		
		int size = 0; // ������ byte�迭�� �� ����
		int len = 0; // �о���� ����ũ��
		try {
		String fileName = dis.readUTF(); // client�� �������� �ι�° String = imgFile�� ���� ������
		System.out.println("-----------"+fileName);
		
		byte[] readData = new byte[512];// HDD�� �ѹ� �о� ���϶��� ũ�⸸ŭ �����ϱ����� �迭
		
		fos = null;
		// file Stream (������ �ϵ��ũ�� �ش��ϴ� Stream)
		size=dis.readInt();//client�� �������� ����° int=file�� size
		readData=new byte[512];
		
		File file=new File("C:/Users/kimkn/git/backup/group_project2/src/kr/co/sist/img/rs_"+fileName);
		fos=new FileOutputStream(file); //�������� �����Ѵ�.
		
		while(size >0) {
			len=dis.read(readData);
			fos.write(readData, 0, len);
			fos.flush();
			size--;
		}//end while
		}finally {
		if(dis!=null) {dis.close();}
		if(fos!=null) {fos.close();}
		}
		
		
	}

	public ServerSocket getServer() {
		return server;
	}

	public static void main(String[] args) {
		new FileServer().start();
	}
}
