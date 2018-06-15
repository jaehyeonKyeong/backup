package day0427;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UseURLEncoder {
	
	public UseURLEncoder() {
		String msg="aaa���¹�bbb";
		try {
			//charset : ���� ����ǥ(��� ���ڿ� �����Ǵ� �ڵ尡 �����Ǿ��ִ� ǥ)
			//1byte charset:8859_1 - ����,����,Ư������(���� �����ʹ� 7bit�� ��)
			//2byte charset:EUC-KR(���� ǥ��), KSC5601(����ǥ��), MS949(MSǥ��) -����, ����, Ư������, �ѱ�
			//3byte charset:UTF-8(����ǥ��) - ���� ���ڸ� ǥ���ϴµ� ��������� �� ���� ���
			String encode=URLEncoder.encode(msg, "UTF-8"); //character set�� �������� ���� ���� ����.
			System.out.println("���� : "+ msg);
			System.out.println("��ȯ : "+ encode);
			String Decode=URLDecoder.decode(encode, "UTF-8");
			System.out.println("���ڵ� : "+ Decode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new UseURLEncoder();
	}

}
