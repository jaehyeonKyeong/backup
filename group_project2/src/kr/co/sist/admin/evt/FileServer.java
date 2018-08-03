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
	private Socket client;
	public static final int SERVER_PORT = 13880;

	// msg = [이미지 종류_img_(업로드/다운로드)]
	public static final String RESTAURANT_IMAGE_UPLOAD = "[rest_img_up]"; // 클라이언트가 보내오는 msg에따라 일이 달라진다.
	public static final String RESTAURANT_IMAGE_DOWNLOAD = "[rest_img_down]";
	public static final String REVIEW_IMAGE_UPLOAD = "[review_img_up]";
	public static final String REVIEW_IMAGE_DOWNLOAD = "[review_img_down]";
	public static final String MENU_IMAGE_UPLOAD = "[menu_img_up]";
	public static final String MENU_IMAGE_DOWNLOAD = "[menu_img_down]";
	public static final String MAP_IMAGE_UPLOAD = "[map_img_up]";
	public static final String MAP_IMAGE_DOWNLOAD = "[map_img_down]";

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
			client = null;

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
				case REVIEW_IMAGE_UPLOAD:
					reviewImgUpload();
					break;
				case REVIEW_IMAGE_DOWNLOAD:
					reviewImgDownload();
					break;
				case MAP_IMAGE_UPLOAD:
					mapImgUpload();
					break;
				case MAP_IMAGE_DOWNLOAD:
					mapImgDownload();
					break;
				case MENU_IMAGE_UPLOAD:
					menuImgUpload();
					break;
				case MENU_IMAGE_DOWNLOAD:
					menuImgDownload();
					break;
				default:
					// 아무런 응답이 없으면 default로 가서 다시 while문을 탄다.
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void mapImgDownload() throws IOException { //맵 이미지를 서버에서 클라이언트로 download한다
		// 2.업로드 할 파일의 정보 얻기
				int size = 0; // 보내는 byte배열의 총 갯수
				int len = 0; // 읽어들인 실제크기
				String fileName = "";
				// HDD가 한번 읽어 들일때의 크기만큼 저장하기위한 배열
				byte[] readData = new byte[512];

				FileInputStream fis = null;
				DataOutputStream dos = null;

				DataInputStream dis = null;
				FileOutputStream fos = null;
				try {
					dis = new DataInputStream(client.getInputStream());
					dos = new DataOutputStream(client.getOutputStream());
					fileName = dis.readUTF(); // 2 번째 msg
					// 3. id받기
					String rNum = dis.readUTF();

					File file = new File(
							"C:/Users/kimkn/git/backup/group_project2/src/kr/co/sist/img/map_" + rNum + "_" + fileName);
					fis = new FileInputStream(file); // 선택한 파일을 스트림으로 연결
					System.out.println(file.getAbsolutePath());
					dos = new DataOutputStream(client.getOutputStream()); // 소켓에 연결된 outStream
					readData = new byte[512];

					while ((len = fis.read(readData)) > 0) {
						size++; // 읽어들인 배열의 갯수 //클라이언트가 보내오는 총 파일의 크기
					} // end while
						// 보낼 파일의 배열 수(총 갯수)를 얻었다면 연결을 끊는다.
						// 파일의 끝으로 이동한 포인터는 다시 파일의 처음으로 돌아가지 않는다.
					fis.close();

					fis = new FileInputStream(file); // 보내기 위해 새로 연결한다.
					dos = new DataOutputStream(client.getOutputStream());
					// 파일크기를 보내고
					dos.writeInt(size); // 3.파일크기 보내기
					dos.flush();

					while (size > 0) { // 전송할 파일의 갯수가(byte[] 바이트 배열의 세트) 존재한다면
						len = fis.read(readData); // 읽어들인 파일의 크기만큼 크기를 얻어
						dos.write(readData, 0, len); // 데이터와 파일의 크기까지를 기록
						dos.flush(); // 보내기
						size--; // 파일의 내용을 한번 보낼 때 마다 크기를 줄인다.
					} // end while

				} finally {
					if (fis != null) {
						fis.close();
					} // end if
					if (dos != null) {
						dos.close();
					} // end if
				}
	}

	private void mapImgUpload() throws IOException { // 맵 이미지를 서버에 저장한다.
		int size = 0; // 보내는 byte배열의 총 갯수
		int len = 0; // 읽어들인 실제크기
		try {
			String fileName = dis.readUTF(); // client가 보내야할 두번째 String = imgFile의 명을 보낸다
			System.out.println("-----------" + fileName);

			byte[] readData = new byte[512];// HDD가 한번 읽어 들일때의 크기만큼 저장하기위한 배열

			fos = null;
			// file Stream (서버의 하드디스크에 해당하는 Stream)
			size = dis.readInt();// client가 보내야할 세번째 int=file의 size
			readData = new byte[512];
			// client가 보내야할 네번째 String = map의 rNum
			String rNum = dis.readUTF();

			File file = new File(
					"C:/Users/kimkn/git/backup/group_project2/src/kr/co/sist/img/map_" + rNum + "_" + fileName);
			fos = new FileOutputStream(file); // 빈파일을 생성한다.

			while (size > 0) {
				len = dis.read(readData);
				fos.write(readData, 0, len);
				fos.flush();
				size--;
			} // end while
		} finally {
			if (dis != null) {
				dis.close();
			}
			if (fos != null) {
				fos.close();
			}
		}
	}

	private void reviewImgDownload() throws IOException {// 클라이언트가 리뷰 이미지를 가져간다.
		// 2.업로드 할 파일의 정보 얻기
		int size = 0; // 보내는 byte배열의 총 갯수
		int len = 0; // 읽어들인 실제크기
		String fileName = "";
		// HDD가 한번 읽어 들일때의 크기만큼 저장하기위한 배열
		byte[] readData = new byte[512];

		FileInputStream fis = null;
		DataOutputStream dos = null;

		DataInputStream dis = null;
		FileOutputStream fos = null;
		try {
			dis = new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());
			fileName = dis.readUTF(); // 2 번째 msg
			// 3. id받기
			String id = dis.readUTF();

			File file = new File(
					"C:/Users/kimkn/git/backup/group_project2/src/kr/co/sist/img/re_" + id + "_" + fileName);
			fis = new FileInputStream(file); // 선택한 파일을 스트림으로 연결
			System.out.println(file.getAbsolutePath());
			readData = new byte[512];

			while ((len = fis.read(readData)) > 0) {
				size++; // 읽어들인 배열의 갯수 //클라이언트가 보내오는 총 파일의 크기
			} // end while
				// 보낼 파일의 배열 수(총 갯수)를 얻었다면 연결을 끊는다.
				// 파일의 끝으로 이동한 포인터는 다시 파일의 처음으로 돌아가지 않는다.
			fis.close();

			fis = new FileInputStream(file); // 보내기 위해 새로 연결한다.
			dos = new DataOutputStream(client.getOutputStream());
			// 파일크기를 보내고
			dos.writeInt(size); // 3.파일크기 보내기
			dos.flush();

			while (size > 0) { // 전송할 파일의 갯수가(byte[] 바이트 배열의 세트) 존재한다면
				len = fis.read(readData); // 읽어들인 파일의 크기만큼 크기를 얻어
				dos.write(readData, 0, len); // 데이터와 파일의 크기까지를 기록
				dos.flush(); // 보내기
				size--; // 파일의 내용을 한번 보낼 때 마다 크기를 줄인다.
			} // end while

		} finally {
			if (fis != null) {
				fis.close();
			} // end if
			if (dos != null) {
				dos.close();
			} // end if
		}

	}

	private void reviewImgUpload() throws IOException { // 리뷰이미지를 올린다.
		int size = 0; // 보내는 byte배열의 총 갯수
		int len = 0; // 읽어들인 실제크기
		try {
			String fileName = dis.readUTF(); // client가 보내야할 두번째 String = imgFile의 명을 보낸다
			System.out.println("-----------" + fileName);

			byte[] readData = new byte[512];// HDD가 한번 읽어 들일때의 크기만큼 저장하기위한 배열

			fos = null;
			// file Stream (서버의 하드디스크에 해당하는 Stream)
			size = dis.readInt();// client가 보내야할 세번째 int=file의 size
			readData = new byte[512];
			// client가 보내야할 네번째 String = reivew의 id
			String id = dis.readUTF();

			File file = new File(
					"C:/Users/kimkn/git/backup/group_project2/src/kr/co/sist/img/re_" + id + "_" + fileName);
			fos = new FileOutputStream(file); // 빈파일을 생성한다.

			while (size > 0) {
				len = dis.read(readData);
				fos.write(readData, 0, len);
				fos.flush();
				size--;
			} // end while
		} finally {
			if (dis != null) {
				dis.close();
			}
			if (fos != null) {
				fos.close();
			}
		}

	}

	private void menuImgDownload() throws IOException { // 메뉴 이미지를 다운해간다
		// 2.업로드 할 파일의 정보 얻기
		int size = 0; // 보내는 byte배열의 총 갯수
		int len = 0; // 읽어들인 실제크기
		String fileName = "";
		// HDD가 한번 읽어 들일때의 크기만큼 저장하기위한 배열
		byte[] readData = new byte[512];

		FileInputStream fis = null;
		DataOutputStream dos = null;

		DataInputStream dis = null;
		FileOutputStream fos = null;
		try {
			dis = new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());
			fileName = dis.readUTF(); // 2 번째 msg
			// 3. rNum받기
			String rNum = dis.readUTF();

			File file = new File(
					"C:/Users/kimkn/git/backup/group_project2/src/kr/co/sist/img/me_" + rNum + "_" + fileName);
			fis = new FileInputStream(file); // 선택한 파일을 스트림으로 연결
			System.out.println(file.getAbsolutePath());
			dos = new DataOutputStream(client.getOutputStream()); // 소켓에 연결된 outStream
			readData = new byte[512];

			while ((len = fis.read(readData)) > 0) {
				size++; // 읽어들인 배열의 갯수 //클라이언트가 보내오는 총 파일의 크기
			} // end while
				// 보낼 파일의 배열 수(총 갯수)를 얻었다면 연결을 끊는다.
				// 파일의 끝으로 이동한 포인터는 다시 파일의 처음으로 돌아가지 않는다.
			fis.close();
			System.out.println("=====size----=========="+size);

			fis = new FileInputStream(file); // 보내기 위해 새로 연결한다.
			dos = new DataOutputStream(client.getOutputStream());
			// 파일크기를 보내고
			dos.writeInt(size); // 3.파일크기 보내기
			dos.flush();

			while (size > 0) { // 전송할 파일의 갯수가(byte[] 바이트 배열의 세트) 존재한다면
				len = fis.read(readData); // 읽어들인 파일의 크기만큼 크기를 얻어
				dos.write(readData, 0, len); // 데이터와 파일의 크기까지를 기록
				dos.flush(); // 보내기
				size--; // 파일의 내용을 한번 보낼 때 마다 크기를 줄인다.
			} // end while

		} finally {
			if (fis != null) {
				fis.close();
			} // end if
			if (dos != null) {
				dos.close();
			} // end if
		}

	}

	private void menuImgUpload() throws IOException { // 메뉴이미지를 서버에 업로드한다

		int size = 0; // 보내는 byte배열의 총 갯수
		int len = 0; // 읽어들인 실제크기
		try {
			String fileName = dis.readUTF(); // client가 보내야할 두번째 String = imgFile의 명을 보낸다
			System.out.println("-----------" + fileName);

			byte[] readData = new byte[512];// HDD가 한번 읽어 들일때의 크기만큼 저장하기위한 배열

			fos = null;
			// file Stream (서버의 하드디스크에 해당하는 Stream)
			size = dis.readInt();// client가 보내야할 세번째 int=file의 size
			readData = new byte[512];
			// client가 보내야할 네번째 String = menu의 restaurant number
			String rNum = dis.readUTF();

			File file = new File(
					"C:/Users/kimkn/git/backup/group_project2/src/kr/co/sist/img/me_" + rNum + "_" + fileName);
			fos = new FileOutputStream(file); // 빈파일을 생성한다.

			while (size > 0) {
				len = dis.read(readData);
				fos.write(readData, 0, len);
				fos.flush();
				size--;
			} // end while
		} finally {
			if (dis != null) {
				dis.close();
			}
			if (fos != null) {
				fos.close();
			}
		}

	}

	private void restaurantImgUpload() throws IOException {// 레스토랑이미지를 서버에 업로드한다.

		int size = 0; // 보내는 byte배열의 총 갯수
		int len = 0; // 읽어들인 실제크기
		try {
			String fileName = dis.readUTF(); // client가 보내야할 두번째 String = imgFile의 명을 보낸다
			System.out.println("-----------" + fileName);

			byte[] readData = new byte[512];// HDD가 한번 읽어 들일때의 크기만큼 저장하기위한 배열

			fos = null;
			// file Stream (서버의 하드디스크에 해당하는 Stream)
			size = dis.readInt();// client가 보내야할 세번째 int=file의 size
			readData = new byte[512];

			File file = new File("C:/Users/kimkn/git/backup/group_project2/src/kr/co/sist/img/rs_" + fileName);
			fos = new FileOutputStream(file); // 빈파일을 생성한다.

			while (size > 0) {
				len = dis.read(readData);
				fos.write(readData, 0, len);
				fos.flush();
				size--;
			} // end while
		} finally {
			if (dis != null) {
				dis.close();
			}
			if (fos != null) {
				fos.close();
			}
		}

	}

	private void restaurantImgDownload() throws IOException { // 클라이언트가 레스토랑 이미지를 서버에서 다운로드 해간다.
		// 2.업로드 할 파일의 정보 얻기
		int size = 0; // 보내는 byte배열의 총 갯수
		int len = 0; // 읽어들인 실제크기
		String fileName = "";
		// HDD가 한번 읽어 들일때의 크기만큼 저장하기위한 배열
		byte[] readData = new byte[512];

		FileInputStream fis = null;
		DataOutputStream dos = null;

		DataInputStream dis = null;
		FileOutputStream fos = null;
		try {
			dis = new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());
			fileName = dis.readUTF(); // 2 번째 msg

			File file = new File("C:/Users/kimkn/git/backup/group_project2/src/kr/co/sist/img/rs_" + fileName);
			fis = new FileInputStream(file); // 선택한 파일을 스트림으로 연결
			System.out.println(file.getAbsolutePath());
			readData = new byte[512];

			while ((len = fis.read(readData)) > 0) {
				size++; // 읽어들인 배열의 갯수 //클라이언트가 보내오는 총 파일의 크기
			} // end while
				// 보낼 파일의 배열 수(총 갯수)를 얻었다면 연결을 끊는다.
				// 파일의 끝으로 이동한 포인터는 다시 파일의 처음으로 돌아가지 않는다.
			fis.close();

			fis = new FileInputStream(file); // 보내기 위해 새로 연결한다.
			dos = new DataOutputStream(client.getOutputStream());
			// 파일크기를 보내고
			dos.writeInt(size); // 3.파일크기 보내기
			dos.flush();

			while (size > 0) { // 전송할 파일의 갯수가(byte[] 바이트 배열의 세트) 존재한다면
				System.out.println(size);
				len = fis.read(readData); // 읽어들인 파일의 크기만큼 크기를 얻어
				dos.write(readData, 0, len); // 데이터와 파일의 크기까지를 기록
				dos.flush(); // 보내기
				size--; // 파일의 내용을 한번 보낼 때 마다 크기를 줄인다.
			} // end while

		} finally {
			if (fis != null) {
				fis.close();
			} // end if
			if (dos != null) {
				dos.close();
			} // end if
		}

	}

	public ServerSocket getServer() {
		return server;
	}

	public static void main(String[] args) {
		new FileServer().start();
	}
}
