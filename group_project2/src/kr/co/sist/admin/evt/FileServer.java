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
	// 서버는 먼저 클라이언트에 말을 걸수 없다.
	// 클라이언트가 말을 걸어주면 응답은 가능하다.
	private ServerSocket server;
	public static final int SERVER_PORT = 13880;
	// msg = [이미지 종류_img_(업로드/다운로드)]
	public static final String RESTAURANT_IMAGE_UPLOAD = "[rest_img_up]"; // 클라이언트가 보내오는 msg에따라 일이 달라진다.
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
			// 클라이언트에서 보내온 이미지 파일을 생성하는 일을 해주는 클래스
			System.out.println("서버 실행");
			Socket client = null;

			while (true) { // 반복을 시켜 client가 접속할때까지 기다린다(언제 접속할지 모름)
				System.out.println("접속대기");
				client = server.accept(); // 종이컵 전화기 같은 존재

				System.out.println("접속자 : [" + client.getRemoteSocketAddress() + "]");

				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				// data Stream(network : client와 통신하기위한 stream)
				String clientMsg = dis.readUTF(); // 클라이언트가 가장 먼저 해야 하는 일은 서버에 일을 처리할 msg를 보내는 일

				// client에서 보내온 문자열 6가지에 따라 서버에서 하는 일이 달라진다.
				switch (clientMsg) {
				case RESTAURANT_IMAGE_UPLOAD:// 레스토랑이미지를 서버에 업로드한다.
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
					//아무런 응답이 없으면 default로 가서 다시 while문을 탄다.
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void restaurantImgDownload() { // 클라이언트가 레스토랑 이미지를 서버에서 다운로드 해간다.
		
	}

	private void restaurantImgUpload() throws IOException {// 레스토랑이미지를 서버에 업로드한다.
		
		int size = 0; // 보내는 byte배열의 총 갯수
		int len = 0; // 읽어들인 실제크기
		try {
		String fileName = dis.readUTF(); // client가 보내야할 두번째 String = imgFile의 명을 보낸다
		System.out.println("-----------"+fileName);
		
		byte[] readData = new byte[512];// HDD가 한번 읽어 들일때의 크기만큼 저장하기위한 배열
		
		fos = null;
		// file Stream (서버의 하드디스크에 해당하는 Stream)
		size=dis.readInt();//client가 보내야할 세번째 int=file의 size
		readData=new byte[512];
		
		File file=new File("C:/Users/kimkn/git/backup/group_project2/src/kr/co/sist/img/rs_"+fileName);
		fos=new FileOutputStream(file); //빈파일을 생성한다.
		
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
