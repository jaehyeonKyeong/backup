package kr.co.sist.javamemo.run;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import kr.co.sist.javamemo.view.JavaMemo;

/**
 * 메모장을 실행하는 일
 * @author owner
 */
public class MemoRun {
	public MemoRun() throws IOException{
		Font font=null;
		ObjectInputStream ois=null;
		try {
			//stream을 연결하여 지정된 경로의 파일에 있는 font객체 얻기
			File file=new File("c:/dev/memodata/memo.dat");
			if(file.exists()) {
			ois=new ObjectInputStream(new FileInputStream(file));
			font=(Font)ois.readObject();
			}
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}finally {
			new JavaMemo(font);
		}
	}

	public static void main(String[] args) {
		try {
			new MemoRun();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//main

}//class
