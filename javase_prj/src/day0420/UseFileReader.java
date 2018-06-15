package day0420;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

@SuppressWarnings("unused")
public class UseFileReader {

	@SuppressWarnings("resource")
	public UseFileReader() throws IOException {
		File file = new File("c:/dev/temp_data/java_read1.txt");
		
		if (file.exists()) {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String str = "";
			int temp = 0;
			DecimalFormat df=new DecimalFormat("#,###");

			while ((str = br.readLine()) != null) {
			
				try {
					temp = Integer.parseInt(str);
					System.out.println(df.format(temp));
				} catch (NumberFormatException e) {
					System.out.println("숫자 아님:" + str);
				}
				
			}
			
		} else {
			System.out.println("경로를 확인하세요");
		}
		
	}// constructor

	public static void main(String[] args) {
		try {
			new UseFileReader();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
