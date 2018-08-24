package kr.co.sist.licensee.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

public class FileClient {
	//map �̹����� �������� Ŭ���̾�Ʈ�� �ٿ�޴� ����
	public String mapDownloadProcess(String rNum)throws IOException{
		String imgPath=null;
		// 1.���� ����
		Socket client = new Socket("211.63.89.139", 13880);
		// 2.�ٿ�ε� �� ������ ���� ���
		FileInputStream fis = null;
		DataOutputStream dos = null;

		DataInputStream dis = null;
		FileOutputStream fos = null;
		
		dos = new DataOutputStream(client.getOutputStream());
		dis = new DataInputStream(client.getInputStream());
		
		byte[] readData=null;
		
		//DAO ���� ��ȸ(File�̸���  oracle���� ��ȸ�Ͽ� ������)
		ClientDAO c_dao=ClientDAO.getInstance();
		String fileName;
		
		try {
			int size = 0; // ������ byte�迭�� �� ����
			int len = 0; // �о���� ����ũ��
			//3. ������ �ؾ��ϴ� ���� Ÿ��
			fileName = c_dao.selectMapImg(rNum);
			System.out.println("-------fileClient"+fileName);
			
			String imgType="[map_img_down]"; 
			
			dos.writeUTF(imgType);//1.msg
			dos.flush();
			fileName= fileName == null? "":fileName;
			dos.writeUTF(fileName.trim());//2. fileName������
			dos.flush();
			
			
			if("".equals(fileName.trim())  ) {
				return imgPath; 
			}
			
			
			dos.writeUTF(rNum.trim()); //3. id������
			dos.flush();
			
			size=dis.readInt();
			System.out.println(size);
			readData = new byte[512];
			
			File file=new File("C:/run_group3/img/" + fileName);
			System.out.println("client -----" + file);
			fos= new FileOutputStream(file);//���� ����
			
			while(size >0) {
				len=dis.read(readData);
				fos.write(readData, 0, len);
				fos.flush();
				size--;
			}//end while
			fos.close();
			
			imgPath=file.getAbsolutePath();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(fos!=null) {fos.close();}
			if(fis!=null) {fis.close();}
			if(dos !=null) {dos.close();} //end if
			if(dis !=null) {dis.close();} //end if
		}//end finally
		
		return imgPath;
	}
	
	//map �̹��� ������ ������ �ø��� ����
	public void mapUploadProcess(String rNum,File file)throws IOException{
		// 1.���� ����
				Socket client = new Socket("211.63.89.139", 13880);

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
					fis = new FileInputStream(file); // ������ ������ ��Ʈ������ ����

					dos = new DataOutputStream(client.getOutputStream()); // ���Ͽ� ����� outStream

					// ������ Ŭ���̾�Ʈ�� ���ϴ� method type�� ������. 1.
					String imageType = "[map_img_up]";
					dos.writeUTF(imageType);
					dos.flush();

					dos.writeUTF(file.getName());// ���ϸ� ������ 2.
					dos.flush();


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
					dos.writeInt(size); //3. size
					dos.flush();
					
					//4. map�� rNum
					dos.writeUTF(rNum);
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
	
	
	//review�̹��� ������ �������� �������� ����
	public String reviewDownloadProcess(String id,String riNum) throws IOException{
		String imgPath=null;
		// 1.���� ����
		Socket client = new Socket("211.63.89.139", 13880);
		// 2.�ٿ�ε� �� ������ ���� ���
		FileInputStream fis = null;
		DataOutputStream dos = null;

		DataInputStream dis = null;
		FileOutputStream fos = null;
		
		dos = new DataOutputStream(client.getOutputStream());
		dis = new DataInputStream(client.getInputStream());
		
		byte[] readData=null;
		
		//DAO ���� ��ȸ(File�̸���  oracle���� ��ȸ�Ͽ� ������)
		ClientDAO c_dao=ClientDAO.getInstance();
		String fileName;
		
		try {
			int size = 0; // ������ byte�迭�� �� ����
			int len = 0; // �о���� ����ũ��
			//3. ������ �ؾ��ϴ� ���� Ÿ��
			fileName = c_dao.selectReviewImg(riNum);
			System.out.println("-------fileClient"+fileName);
			
			String imgType="[review_img_down]"; 
			
			dos.writeUTF(imgType);//1.msg
			dos.flush();
			
			dos.writeUTF(fileName);//2. fileName������
			dos.flush();
			
			dos.writeUTF(id); //3. id������
			dos.flush();
			
			System.out.println(size);
			size=dis.readInt();
			readData = new byte[512];
			
			File file=new File("C:/run_group3/img/" + fileName);
			fos= new FileOutputStream(file);//���� ����
			
			while(size >0) {
				len=dis.read(readData);
				fos.write(readData, 0, len);
				fos.flush();
				size--;
			}//end while
			fos.close();
			imgPath=file.getAbsolutePath();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(fos!=null) {fos.close();}
			if(fis!=null) {fis.close();}
			if(dos !=null) {dos.close();} //end if
			if(dis !=null) {dis.close();} //end if
			if(client !=null) {client.close();} //end if
		}//end finally
		
		return imgPath;
	}
	
	//reivew�̹��� ������ ������ ����ϴ� ����
	public void reviewUploadProcess(String rNum,String id,File file) throws IOException {
		// 1.���� ����
		Socket client = new Socket("211.63.89.139", 13880);

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
			fis = new FileInputStream(file); // ������ ������ ��Ʈ������ ����

			dos = new DataOutputStream(client.getOutputStream()); // ���Ͽ� ����� outStream

			// ������ Ŭ���̾�Ʈ�� ���ϴ� method type�� ������. 1.
			String imageType = "[review_img_up]";
			dos.writeUTF(imageType);
			dos.flush();

			dos.writeUTF(file.getName());// ���ϸ� ������ 2.
			dos.flush();


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
			dos.writeInt(size); //3. size
			dos.flush();
			
			//4.review �� id
			dos.writeUTF(id);
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
	
	//menu�̹��� ������ �������� �������� ����
	public String menuDownloadProcess(String menuName,String rNum) throws IOException{
		String imgPath=null;
		// 1.���� ����
		Socket client = new Socket("211.63.89.139", 13880);
		// 2.�ٿ�ε� �� ������ ���� ���
		FileInputStream fis = null;
		DataOutputStream dos = null;

		DataInputStream dis = null;
		FileOutputStream fos = null;
		
		dos = new DataOutputStream(client.getOutputStream());
		dis = new DataInputStream(client.getInputStream());
		
		byte[] readData=null;
		
		//DAO ���� ��ȸ(File�̸���  oracle���� ��ȸ�Ͽ� ������)
		ClientDAO c_dao=ClientDAO.getInstance();
		String fileName;
		
		try {
			int size = 0; // ������ byte�迭�� �� ����
			int len = 0; // �о���� ����ũ��
			//3. ������ �ؾ��ϴ� ���� Ÿ��
			fileName = c_dao.selectMenuImg(menuName);
			System.out.println("-------fileClient"+fileName);
			
			String imgType="[menu_img_down]"; 
			
			dos.writeUTF(imgType);//1.msg
			dos.flush();
			
			dos.writeUTF(fileName.trim());//2. fileName������
			dos.flush();
			
			dos.writeUTF(rNum.trim());
			dos.flush();
			
			System.out.println(size);
			size=dis.readInt();
			readData = new byte[512];
			
			File file=new File("C:/run_group3/img/" + fileName);
			fos= new FileOutputStream(file);//���� ����
			
			while(size >0) {
				len=dis.read(readData);
				fos.write(readData, 0, len);
				fos.flush();
				size--;
			}//end while
			fos.close();
			
			imgPath=file.getAbsolutePath();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(fos!=null) {fos.close();}
			if(fis!=null) {fis.close();}
			if(dos !=null) {dos.close();} //end if
			if(dis !=null) {dis.close();} //end if
		}//end finally
		
		return imgPath;
		
	}
	
	
	//menu�̹��� ������ ������ �ø��� ����
	public void menuUploadProcess(File file,String rNum) throws IOException{
		// 1.���� ����
				Socket client = new Socket("211.63.89.139", 13880);

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
					fis = new FileInputStream(file); // ������ ������ ��Ʈ������ ����

					dos = new DataOutputStream(client.getOutputStream()); // ���Ͽ� ����� outStream

					// ������ Ŭ���̾�Ʈ�� ���ϴ� method type�� ������. 1.
					String imageType = "[menu_img_up]";
					dos.writeUTF(imageType);
					dos.flush();

					dos.writeUTF(file.getName().trim());// ���ϸ� ������ 2.
					dos.flush();


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
					dos.writeInt(size); //3. size
					dos.flush();
					
					//4. menu�� rNum
					dos.writeUTF(rNum.trim());
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

	public void restaurantUploadProcess(File file) throws IOException {// ������� �̹����� ���ϼ����� �ø��� ����

		// 1.���� ����
		Socket client = new Socket("211.63.89.139", 13880);

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
			fis = new FileInputStream(file); // ������ ������ ��Ʈ������ ����

			dos = new DataOutputStream(client.getOutputStream()); // ���Ͽ� ����� outStream

			// ������ Ŭ���̾�Ʈ�� ���ϴ� method type�� ������.
			String imageType = "[rest_img_up]";
			dos.writeUTF(imageType);
			dos.flush();

			dos.writeUTF(file.getName());// ���ϸ� ������
			dos.flush();


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
			dos.writeInt(size);
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
	}// uploadProcess

	public String restaurantDownloadProcess(String rNum) throws IOException {
		String imgPath=null;
		// 1.���� ����
		Socket client = new Socket("211.63.89.139", 13880);
		// 2.�ٿ�ε� �� ������ ���� ���
		FileInputStream fis = null;
		DataOutputStream dos = null;

		DataInputStream dis = null;
		FileOutputStream fos = null;
		
		dos = new DataOutputStream(client.getOutputStream());
		dis = new DataInputStream(client.getInputStream());
		
		byte[] readData=null;
		
		//DAO ���� ��ȸ(File�̸���  oracle���� ��ȸ�Ͽ� ������)
		ClientDAO c_dao=ClientDAO.getInstance();
		String fileName;
		
		try {
			int size = 0; // ������ byte�迭�� �� ����
			int len = 0; // �о���� ����ũ��
			//3. ������ �ؾ��ϴ� ���� Ÿ��
			String tempFileName= c_dao.selectRestImg(rNum);
			fileName = tempFileName==null ? "":tempFileName;
			System.out.println("-------fileClient:"+fileName);
			
			String imgType="[rest_img_down]"; 
			
			dos.writeUTF(imgType);//1.msg
			dos.flush();
			
			dos.writeUTF(fileName);//2. fileName������
			dos.flush();
			if("".equals(fileName)) {return imgPath;}
			size=dis.readInt();
			readData = new byte[512];
			
			File file=new File("C:/run_group3/img/" + fileName);
			fos= new FileOutputStream(file);//���� ����
			System.out.println("-------"+file);
			
			while(size >0) {
				len=dis.read(readData);
				fos.write(readData, 0, len);
				fos.flush();
				size--;
			}//end while
			fos.close();
			
			imgPath=file.getAbsolutePath();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(fos!=null) {fos.close();}
			if(fis!=null) {fis.close();}
			if(dos !=null) {dos.close();} //end if
			if(dis !=null) {dis.close();} //end if
		}//end finally
		
		return imgPath;
	}
}// class
