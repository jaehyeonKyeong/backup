package day0419;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

/**
 * File에 연결하여 File안의 내용을 읽어 들이는 Stream의 사용
 * 
 * @author owner
 */
public class UseFile {

	public UseFile() throws IOException,FileNotFoundException {
//		FileInputStream fis=new FileInputStream("C:/dev/temp_data/java_read.txt");
//		InputStreamReader isr=new InputStreamReader(fis);
//		BufferedReader br= new BufferedReader(isr);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("C:/dev/temp_data/java_read.txt")));
		
		String temp="";
		while((temp=br.readLine())!=null) {
			System.out.println(temp);
		}
		//stream의 사용이 끝났으면, 연결을 끊어준다.
		br.close();
//		int temp=0; // 파일복사할때 사용
//		while((temp=fis.read())!=-1) {
//			System.out.print((char)temp);
//			
//		}
	}// constructor

	public static void main(String[] args) {
		try {
			new UseFile();
		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(null, "파일의 경로를 확인해주세요");
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "읽기도중 문제발생");
			ioe.printStackTrace();
		}
	}

}
