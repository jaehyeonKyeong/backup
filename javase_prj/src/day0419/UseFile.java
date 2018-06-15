package day0419;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

/**
 * File�� �����Ͽ� File���� ������ �о� ���̴� Stream�� ���
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
		//stream�� ����� ��������, ������ �����ش�.
		br.close();
//		int temp=0; // ���Ϻ����Ҷ� ���
//		while((temp=fis.read())!=-1) {
//			System.out.print((char)temp);
//			
//		}
	}// constructor

	public static void main(String[] args) {
		try {
			new UseFile();
		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(null, "������ ��θ� Ȯ�����ּ���");
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "�б⵵�� �����߻�");
			ioe.printStackTrace();
		}
	}

}
