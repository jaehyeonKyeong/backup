package day0419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UseKeyboardInput {
	
	public UseKeyboardInput() {
		System.out.println("�ƹ�Ű�� ������ ����");
		try {			
			//8bit stream�� 16bit Strinm�� �����Ͽ� �� ���� ���
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String data=br.readLine();
			System.out.println("�Է� ������"+data);
//			int key=0;
//			while(true) {
//			key=System.in.read();
//			
//			//�о���� �����ϳ��� ������ �� ���� ������ �ѱ��� ����� �� ����.
//			if(key==13) {
//				break;
//			}
//			System.out.println("�о�帰 �� : "+(char)key+","+key);
//			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}//constructor
	public static void main(String[] args) {
		new UseKeyboardInput();
	}

}
