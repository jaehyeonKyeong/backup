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
	//map 이미지를 서버에서 클라이언트로 다운받는 역할
	public String mapDownloadProcess(String rNum)throws IOException{
		String imgPath=null;
		// 1.소켓 열고
		Socket client = new Socket("211.63.89.139", 13880);
		// 2.다운로드 할 파일의 정보 얻기
		FileInputStream fis = null;
		DataOutputStream dos = null;

		DataInputStream dis = null;
		FileOutputStream fos = null;
		
		dos = new DataOutputStream(client.getOutputStream());
		dis = new DataInputStream(client.getInputStream());
		
		byte[] readData=null;
		
		//DAO 정보 조회(File이름은  oracle에서 조회하여 가져옴)
		ClientDAO c_dao=ClientDAO.getInstance();
		String fileName;
		
		try {
			int size = 0; // 보내는 byte배열의 총 갯수
			int len = 0; // 읽어들인 실제크기
			//3. 서버가 해야하는 일의 타입
			fileName = c_dao.selectMapImg(rNum);
			System.out.println("-------fileClient"+fileName);
			
			String imgType="[map_img_down]"; 
			
			dos.writeUTF(imgType);//1.msg
			dos.flush();
			fileName= fileName == null? "":fileName;
			dos.writeUTF(fileName.trim());//2. fileName보내기
			dos.flush();
			
			
			if("".equals(fileName.trim())  ) {
				return imgPath; 
			}
			
			
			dos.writeUTF(rNum.trim()); //3. id보내기
			dos.flush();
			
			size=dis.readInt();
			System.out.println(size);
			readData = new byte[512];
			
			File file=new File("C:/run_group3/img/" + fileName);
			System.out.println("client -----" + file);
			fos= new FileOutputStream(file);//파일 생성
			
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
	
	//map 이미지 파일을 서버에 올리는 역할
	public void mapUploadProcess(String rNum,File file)throws IOException{
		// 1.소켓 열고
				Socket client = new Socket("211.63.89.139", 13880);

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
					fis = new FileInputStream(file); // 선택한 파일을 스트림으로 연결

					dos = new DataOutputStream(client.getOutputStream()); // 소켓에 연결된 outStream

					// 서버에 클라이언트가 원하는 method type을 보낸다. 1.
					String imageType = "[map_img_up]";
					dos.writeUTF(imageType);
					dos.flush();

					dos.writeUTF(file.getName());// 파일명 보내기 2.
					dos.flush();


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
					dos.writeInt(size); //3. size
					dos.flush();
					
					//4. map의 rNum
					dos.writeUTF(rNum);
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
	
	
	//review이미지 파일을 서버에서 가져오는 역할
	public String reviewDownloadProcess(String id,String riNum) throws IOException{
		String imgPath=null;
		// 1.소켓 열고
		Socket client = new Socket("211.63.89.139", 13880);
		// 2.다운로드 할 파일의 정보 얻기
		FileInputStream fis = null;
		DataOutputStream dos = null;

		DataInputStream dis = null;
		FileOutputStream fos = null;
		
		dos = new DataOutputStream(client.getOutputStream());
		dis = new DataInputStream(client.getInputStream());
		
		byte[] readData=null;
		
		//DAO 정보 조회(File이름은  oracle에서 조회하여 가져옴)
		ClientDAO c_dao=ClientDAO.getInstance();
		String fileName;
		
		try {
			int size = 0; // 보내는 byte배열의 총 갯수
			int len = 0; // 읽어들인 실제크기
			//3. 서버가 해야하는 일의 타입
			fileName = c_dao.selectReviewImg(riNum);
			System.out.println("-------fileClient"+fileName);
			
			String imgType="[review_img_down]"; 
			
			dos.writeUTF(imgType);//1.msg
			dos.flush();
			
			dos.writeUTF(fileName);//2. fileName보내기
			dos.flush();
			
			dos.writeUTF(id); //3. id보내기
			dos.flush();
			
			System.out.println(size);
			size=dis.readInt();
			readData = new byte[512];
			
			File file=new File("C:/run_group3/img/" + fileName);
			fos= new FileOutputStream(file);//파일 생성
			
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
	
	//reivew이미지 파일을 서버에 등록하는 역할
	public void reviewUploadProcess(String rNum,String id,File file) throws IOException {
		// 1.소켓 열고
		Socket client = new Socket("211.63.89.139", 13880);

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
			fis = new FileInputStream(file); // 선택한 파일을 스트림으로 연결

			dos = new DataOutputStream(client.getOutputStream()); // 소켓에 연결된 outStream

			// 서버에 클라이언트가 원하는 method type을 보낸다. 1.
			String imageType = "[review_img_up]";
			dos.writeUTF(imageType);
			dos.flush();

			dos.writeUTF(file.getName());// 파일명 보내기 2.
			dos.flush();


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
			dos.writeInt(size); //3. size
			dos.flush();
			
			//4.review 의 id
			dos.writeUTF(id);
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
	
	//menu이미지 파일을 서버에서 가져오는 역할
	public String menuDownloadProcess(String menuName,String rNum) throws IOException{
		String imgPath=null;
		// 1.소켓 열고
		Socket client = new Socket("211.63.89.139", 13880);
		// 2.다운로드 할 파일의 정보 얻기
		FileInputStream fis = null;
		DataOutputStream dos = null;

		DataInputStream dis = null;
		FileOutputStream fos = null;
		
		dos = new DataOutputStream(client.getOutputStream());
		dis = new DataInputStream(client.getInputStream());
		
		byte[] readData=null;
		
		//DAO 정보 조회(File이름은  oracle에서 조회하여 가져옴)
		ClientDAO c_dao=ClientDAO.getInstance();
		String fileName;
		
		try {
			int size = 0; // 보내는 byte배열의 총 갯수
			int len = 0; // 읽어들인 실제크기
			//3. 서버가 해야하는 일의 타입
			fileName = c_dao.selectMenuImg(menuName);
			System.out.println("-------fileClient"+fileName);
			
			String imgType="[menu_img_down]"; 
			
			dos.writeUTF(imgType);//1.msg
			dos.flush();
			
			dos.writeUTF(fileName.trim());//2. fileName보내기
			dos.flush();
			
			dos.writeUTF(rNum.trim());
			dos.flush();
			
			System.out.println(size);
			size=dis.readInt();
			readData = new byte[512];
			
			File file=new File("C:/run_group3/img/" + fileName);
			fos= new FileOutputStream(file);//파일 생성
			
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
	
	
	//menu이미지 파일을 서버에 올리는 역할
	public void menuUploadProcess(File file,String rNum) throws IOException{
		// 1.소켓 열고
				Socket client = new Socket("211.63.89.139", 13880);

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
					fis = new FileInputStream(file); // 선택한 파일을 스트림으로 연결

					dos = new DataOutputStream(client.getOutputStream()); // 소켓에 연결된 outStream

					// 서버에 클라이언트가 원하는 method type을 보낸다. 1.
					String imageType = "[menu_img_up]";
					dos.writeUTF(imageType);
					dos.flush();

					dos.writeUTF(file.getName().trim());// 파일명 보내기 2.
					dos.flush();


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
					dos.writeInt(size); //3. size
					dos.flush();
					
					//4. menu의 rNum
					dos.writeUTF(rNum.trim());
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

	public void restaurantUploadProcess(File file) throws IOException {// 레스토랑 이미지를 파일서버에 올리는 역할

		// 1.소켓 열고
		Socket client = new Socket("211.63.89.139", 13880);

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
			fis = new FileInputStream(file); // 선택한 파일을 스트림으로 연결

			dos = new DataOutputStream(client.getOutputStream()); // 소켓에 연결된 outStream

			// 서버에 클라이언트가 원하는 method type을 보낸다.
			String imageType = "[rest_img_up]";
			dos.writeUTF(imageType);
			dos.flush();

			dos.writeUTF(file.getName());// 파일명 보내기
			dos.flush();


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
			dos.writeInt(size);
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
	}// uploadProcess

	public String restaurantDownloadProcess(String rNum) throws IOException {
		String imgPath=null;
		// 1.소켓 열고
		Socket client = new Socket("211.63.89.139", 13880);
		// 2.다운로드 할 파일의 정보 얻기
		FileInputStream fis = null;
		DataOutputStream dos = null;

		DataInputStream dis = null;
		FileOutputStream fos = null;
		
		dos = new DataOutputStream(client.getOutputStream());
		dis = new DataInputStream(client.getInputStream());
		
		byte[] readData=null;
		
		//DAO 정보 조회(File이름은  oracle에서 조회하여 가져옴)
		ClientDAO c_dao=ClientDAO.getInstance();
		String fileName;
		
		try {
			int size = 0; // 보내는 byte배열의 총 갯수
			int len = 0; // 읽어들인 실제크기
			//3. 서버가 해야하는 일의 타입
			String tempFileName= c_dao.selectRestImg(rNum);
			fileName = tempFileName==null ? "":tempFileName;
			System.out.println("-------fileClient:"+fileName);
			
			String imgType="[rest_img_down]"; 
			
			dos.writeUTF(imgType);//1.msg
			dos.flush();
			
			dos.writeUTF(fileName);//2. fileName보내기
			dos.flush();
			if("".equals(fileName)) {return imgPath;}
			size=dis.readInt();
			readData = new byte[512];
			
			File file=new File("C:/run_group3/img/" + fileName);
			fos= new FileOutputStream(file);//파일 생성
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
