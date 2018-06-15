package day0419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UseKeyboardInput {
	
	public UseKeyboardInput() {
		System.out.println("아무키나 누르고 엔터");
		try {			
			//8bit stream과 16bit Strinm을 연결하여 줄 단위 얻기
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String data=br.readLine();
			System.out.println("입력 데이터"+data);
//			int key=0;
//			while(true) {
//			key=System.in.read();
//			
//			//읽어들인 문자하나를 조합할 수 없기 때문에 한글은 사용할 수 없다.
//			if(key==13) {
//				break;
//			}
//			System.out.println("읽어드린 값 : "+(char)key+","+key);
//			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}//constructor
	public static void main(String[] args) {
		new UseKeyboardInput();
	}

}
