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
	private Socket client;
	public static final int SERVER_PORT = 13880;

	// msg = [�̹��� ����_img_(���ε�/�ٿ�ε�)]
	public static final String RESTAURANT_IMAGE_UPLOAD = "[rest_img_up]"; // Ŭ���̾�Ʈ�� �������� msg������ ���� �޶�����.
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
			// Ŭ���̾�Ʈ���� ������ �̹��� ������ �����ϴ� ���� ���ִ� Ŭ����
			System.out.println("���� ����");
			client = null;

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
					// �ƹ��� ������ ������ default�� ���� �ٽ� while���� ź��.
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void mapImgDownload() throws IOException { //�� �̹����� �������� Ŭ���̾�Ʈ�� download�Ѵ�
		// 2.���ε� �� ������ ���� ���
				int size = 0; // ������ byte�迭�� �� ����
				int len = 0; // �о���� ����ũ��
				String fileName = "";
				// HDD�� �ѹ� �о� ���϶��� ũ�⸸ŭ �����ϱ����� �迭
				byte[] readData = new byte[512];

				FileInputStream fis = null;
				DataOutputStream dos = null;

				DataInputStream dis = null;
				FileOutputStream fos = null;
				try {
					dis = new DataInputStream(client.getInputStream());
					dos = new DataOutputStream(client.getOutputStream());
					fileName = dis.readUTF(); // 2 ��° msg
					// 3. id�ޱ�
					String rNum = dis.readUTF();

					File file = new File(
							"C:/Users/kimkn/git/backup/group_project2/src/kr/co/sist/img/map_" + rNum + "_" + fileName);
					fis = new FileInputStream(file); // ������ ������ ��Ʈ������ ����
					System.out.println(file.getAbsolutePath());
					dos = new DataOutputStream(client.getOutputStream()); // ���Ͽ� ����� outStream
					readData = new byte[512];

					while ((len = fis.read(readData)) > 0) {
						size++; // �о���� �迭�� ���� //Ŭ���̾�Ʈ�� �������� �� ������ ũ��
					} // end while
						// ���� ������ �迭 ��(�� ����)�� ����ٸ� ������ ���´�.
						// ������ ������ �̵��� �����ʹ� �ٽ� ������ ó������ ���ư��� �ʴ´�.
					fis.close();

					fis = new FileInputStream(file); // ������ ���� ���� �����Ѵ�.
					dos = new DataOutputStream(client.getOutputStream());
					// ����ũ�⸦ ������
					dos.writeInt(size); // 3.����ũ�� ������
					dos.flush();

					while (size > 0) { // ������ ������ ������(byte[] ����Ʈ �迭�� ��Ʈ) �����Ѵٸ�
						len = fis.read(readData); // �о���� ������ ũ�⸸ŭ ũ�⸦ ���
						dos.write(readData, 0, len); // �����Ϳ� ������ ũ������� ���
						dos.flush(); // ������
						size--; // ������ ������ �ѹ� ���� �� ���� ũ�⸦ ���δ�.
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

	private void mapImgUpload() throws IOException { // �� �̹����� ������ �����Ѵ�.
		int size = 0; // ������ byte�迭�� �� ����
		int len = 0; // �о���� ����ũ��
		try {
			String fileName = dis.readUTF(); // client�� �������� �ι�° String = imgFile�� ���� ������
			System.out.println("-----------" + fileName);

			byte[] readData = new byte[512];// HDD�� �ѹ� �о� ���϶��� ũ�⸸ŭ �����ϱ����� �迭

			fos = null;
			// file Stream (������ �ϵ��ũ�� �ش��ϴ� Stream)
			size = dis.readInt();// client�� �������� ����° int=file�� size
			readData = new byte[512];
			// client�� �������� �׹�° String = map�� rNum
			String rNum = dis.readUTF();

			File file = new File(
					"C:/Users/kimkn/git/backup/group_project2/src/kr/co/sist/img/map_" + rNum + "_" + fileName);
			fos = new FileOutputStream(file); // �������� �����Ѵ�.

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

	private void reviewImgDownload() throws IOException {// Ŭ���̾�Ʈ�� ���� �̹����� ��������.
		// 2.���ε� �� ������ ���� ���
		int size = 0; // ������ byte�迭�� �� ����
		int len = 0; // �о���� ����ũ��
		String fileName = "";
		// HDD�� �ѹ� �о� ���϶��� ũ�⸸ŭ �����ϱ����� �迭
		byte[] readData = new byte[512];

		FileInputStream fis = null;
		DataOutputStream dos = null;

		DataInputStream dis = null;
		FileOutputStream fos = null;
		try {
			dis = new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());
			fileName = dis.readUTF(); // 2 ��° msg
			// 3. id�ޱ�
			String id = dis.readUTF();

			File file = new File(
					"C:/Users/kimkn/git/backup/group_project2/src/kr/co/sist/img/re_" + id + "_" + fileName);
			fis = new FileInputStream(file); // ������ ������ ��Ʈ������ ����
			System.out.println(file.getAbsolutePath());
			readData = new byte[512];

			while ((len = fis.read(readData)) > 0) {
				size++; // �о���� �迭�� ���� //Ŭ���̾�Ʈ�� �������� �� ������ ũ��
			} // end while
				// ���� ������ �迭 ��(�� ����)�� ����ٸ� ������ ���´�.
				// ������ ������ �̵��� �����ʹ� �ٽ� ������ ó������ ���ư��� �ʴ´�.
			fis.close();

			fis = new FileInputStream(file); // ������ ���� ���� �����Ѵ�.
			dos = new DataOutputStream(client.getOutputStream());
			// ����ũ�⸦ ������
			dos.writeInt(size); // 3.����ũ�� ������
			dos.flush();

			while (size > 0) { // ������ ������ ������(byte[] ����Ʈ �迭�� ��Ʈ) �����Ѵٸ�
				len = fis.read(readData); // �о���� ������ ũ�⸸ŭ ũ�⸦ ���
				dos.write(readData, 0, len); // �����Ϳ� ������ ũ������� ���
				dos.flush(); // ������
				size--; // ������ ������ �ѹ� ���� �� ���� ũ�⸦ ���δ�.
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

	private void reviewImgUpload() throws IOException { // �����̹����� �ø���.
		int size = 0; // ������ byte�迭�� �� ����
		int len = 0; // �о���� ����ũ��
		try {
			String fileName = dis.readUTF(); // client�� �������� �ι�° String = imgFile�� ���� ������
			System.out.println("-----------" + fileName);

			byte[] readData = new byte[512];// HDD�� �ѹ� �о� ���϶��� ũ�⸸ŭ �����ϱ����� �迭

			fos = null;
			// file Stream (������ �ϵ��ũ�� �ش��ϴ� Stream)
			size = dis.readInt();// client�� �������� ����° int=file�� size
			readData = new byte[512];
			// client�� �������� �׹�° String = reivew�� id
			String id = dis.readUTF();

			File file = new File(
					"C:/Users/kimkn/git/backup/group_project2/src/kr/co/sist/img/re_" + id + "_" + fileName);
			fos = new FileOutputStream(file); // �������� �����Ѵ�.

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

	private void menuImgDownload() throws IOException { // �޴� �̹����� �ٿ��ذ���
		// 2.���ε� �� ������ ���� ���
		int size = 0; // ������ byte�迭�� �� ����
		int len = 0; // �о���� ����ũ��
		String fileName = "";
		// HDD�� �ѹ� �о� ���϶��� ũ�⸸ŭ �����ϱ����� �迭
		byte[] readData = new byte[512];

		FileInputStream fis = null;
		DataOutputStream dos = null;

		DataInputStream dis = null;
		FileOutputStream fos = null;
		try {
			dis = new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());
			fileName = dis.readUTF(); // 2 ��° msg
			// 3. rNum�ޱ�
			String rNum = dis.readUTF();

			File file = new File(
					"C:/Users/kimkn/git/backup/group_project2/src/kr/co/sist/img/me_" + rNum + "_" + fileName);
			fis = new FileInputStream(file); // ������ ������ ��Ʈ������ ����
			System.out.println(file.getAbsolutePath());
			dos = new DataOutputStream(client.getOutputStream()); // ���Ͽ� ����� outStream
			readData = new byte[512];

			while ((len = fis.read(readData)) > 0) {
				size++; // �о���� �迭�� ���� //Ŭ���̾�Ʈ�� �������� �� ������ ũ��
			} // end while
				// ���� ������ �迭 ��(�� ����)�� ����ٸ� ������ ���´�.
				// ������ ������ �̵��� �����ʹ� �ٽ� ������ ó������ ���ư��� �ʴ´�.
			fis.close();
			System.out.println("=====size----=========="+size);

			fis = new FileInputStream(file); // ������ ���� ���� �����Ѵ�.
			dos = new DataOutputStream(client.getOutputStream());
			// ����ũ�⸦ ������
			dos.writeInt(size); // 3.����ũ�� ������
			dos.flush();

			while (size > 0) { // ������ ������ ������(byte[] ����Ʈ �迭�� ��Ʈ) �����Ѵٸ�
				len = fis.read(readData); // �о���� ������ ũ�⸸ŭ ũ�⸦ ���
				dos.write(readData, 0, len); // �����Ϳ� ������ ũ������� ���
				dos.flush(); // ������
				size--; // ������ ������ �ѹ� ���� �� ���� ũ�⸦ ���δ�.
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

	private void menuImgUpload() throws IOException { // �޴��̹����� ������ ���ε��Ѵ�

		int size = 0; // ������ byte�迭�� �� ����
		int len = 0; // �о���� ����ũ��
		try {
			String fileName = dis.readUTF(); // client�� �������� �ι�° String = imgFile�� ���� ������
			System.out.println("-----------" + fileName);

			byte[] readData = new byte[512];// HDD�� �ѹ� �о� ���϶��� ũ�⸸ŭ �����ϱ����� �迭

			fos = null;
			// file Stream (������ �ϵ��ũ�� �ش��ϴ� Stream)
			size = dis.readInt();// client�� �������� ����° int=file�� size
			readData = new byte[512];
			// client�� �������� �׹�° String = menu�� restaurant number
			String rNum = dis.readUTF();

			File file = new File(
					"C:/Users/kimkn/git/backup/group_project2/src/kr/co/sist/img/me_" + rNum + "_" + fileName);
			fos = new FileOutputStream(file); // �������� �����Ѵ�.

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

	private void restaurantImgUpload() throws IOException {// ��������̹����� ������ ���ε��Ѵ�.

		int size = 0; // ������ byte�迭�� �� ����
		int len = 0; // �о���� ����ũ��
		try {
			String fileName = dis.readUTF(); // client�� �������� �ι�° String = imgFile�� ���� ������
			System.out.println("-----------" + fileName);

			byte[] readData = new byte[512];// HDD�� �ѹ� �о� ���϶��� ũ�⸸ŭ �����ϱ����� �迭

			fos = null;
			// file Stream (������ �ϵ��ũ�� �ش��ϴ� Stream)
			size = dis.readInt();// client�� �������� ����° int=file�� size
			readData = new byte[512];

			File file = new File("C:/Users/kimkn/git/backup/group_project2/src/kr/co/sist/img/rs_" + fileName);
			fos = new FileOutputStream(file); // �������� �����Ѵ�.

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

	private void restaurantImgDownload() throws IOException { // Ŭ���̾�Ʈ�� ������� �̹����� �������� �ٿ�ε� �ذ���.
		// 2.���ε� �� ������ ���� ���
		int size = 0; // ������ byte�迭�� �� ����
		int len = 0; // �о���� ����ũ��
		String fileName = "";
		// HDD�� �ѹ� �о� ���϶��� ũ�⸸ŭ �����ϱ����� �迭
		byte[] readData = new byte[512];

		FileInputStream fis = null;
		DataOutputStream dos = null;

		DataInputStream dis = null;
		FileOutputStream fos = null;
		try {
			dis = new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());
			fileName = dis.readUTF(); // 2 ��° msg

			File file = new File("C:/Users/kimkn/git/backup/group_project2/src/kr/co/sist/img/rs_" + fileName);
			fis = new FileInputStream(file); // ������ ������ ��Ʈ������ ����
			System.out.println(file.getAbsolutePath());
			readData = new byte[512];

			while ((len = fis.read(readData)) > 0) {
				size++; // �о���� �迭�� ���� //Ŭ���̾�Ʈ�� �������� �� ������ ũ��
			} // end while
				// ���� ������ �迭 ��(�� ����)�� ����ٸ� ������ ���´�.
				// ������ ������ �̵��� �����ʹ� �ٽ� ������ ó������ ���ư��� �ʴ´�.
			fis.close();

			fis = new FileInputStream(file); // ������ ���� ���� �����Ѵ�.
			dos = new DataOutputStream(client.getOutputStream());
			// ����ũ�⸦ ������
			dos.writeInt(size); // 3.����ũ�� ������
			dos.flush();

			while (size > 0) { // ������ ������ ������(byte[] ����Ʈ �迭�� ��Ʈ) �����Ѵٸ�
				System.out.println(size);
				len = fis.read(readData); // �о���� ������ ũ�⸸ŭ ũ�⸦ ���
				dos.write(readData, 0, len); // �����Ϳ� ������ ũ������� ���
				dos.flush(); // ������
				size--; // ������ ������ �ѹ� ���� �� ���� ũ�⸦ ���δ�.
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
