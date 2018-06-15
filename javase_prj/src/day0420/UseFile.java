package day0420;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UseFile {

	public UseFile() throws IOException {
		File file = new File("c:/dev/env.bat");
		// 파일에 대한 정보 얻기
		if (file.exists()) {
			System.out.println("파일 존재");
			System.out.println("객체: " + file);
			System.out.println("Canonical: " + file.getCanonicalPath());
			System.out.println("Absolute: " + file.getAbsolutePath());
			System.out.println("path: " + file.getPath());
			System.out.println("폴더명: " + file.getParent());
			System.out.println("파일명: " + file.getName());
			System.out.println(file.isFile() ? "폴더" : "파일");
			System.out.println(file.isDirectory() ? "파일" : "폴더");
			System.out.println(file.canWrite() ? "쓰기 가능" : "쓰기 불가");
			System.out.println(file.canExecute() ? "실행 가능" : "실행 불가");
			System.out.println(file.isHidden() ? "숨김" : "일반");
			System.out.println("파일의 크기: " +file.length()+"byte");
			
			Date date=new Date(file.lastModified());
			SimpleDateFormat sdf=new SimpleDateFormat();
			System.out.println("마지막으로 수정된 날짜 : "+sdf.format(date));

		} else {
			System.out.println("파일없음 : 경로나 파일명을 확인하세요");
		}

	}// constructor

	public static void main(String[] args) {
		try {
			new UseFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
