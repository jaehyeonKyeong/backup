package kr.co.sist.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;

public class HashAlgorithm {
	

	public static String changeMD5(String plainText){
		StringBuilder cipherText=new StringBuilder();
		
		try {
			//1.����� �˰��� ����
			MessageDigest md=MessageDigest.getInstance("MD5"); //�ܱⰣ �����ϴ� ��ȣ��
			//2.���ڿ��� �˰����� ����Ͽ� ��ȯ
			md.update(plainText.getBytes());
			//3. �˰����� ����Ǿ� ��ȯ�� ���� �޴´�
			byte[]b=md.digest();
			//4. ����� �˾ƺ� �� �ִ� ���ڿ��� ����
			//4-1. ��� 1
			//4-2. ��� 2
			for (int i=0;i<b.length;i++) {
				cipherText.append(Integer.toString((b[i]&0xFF)+0x100,16).substring(1));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return cipherText.toString();
	}
	public static String changeSHA512(String plainText){
		StringBuilder cipherText=new StringBuilder();
		
		try {
			//1.����� �˰��� ����
			MessageDigest md=MessageDigest.getInstance("SHA-512"); //��Ⱓ �����ϴ� ��ȣ��
			//2.���ڿ��� �˰����� ����Ͽ� ��ȯ
			md.update(plainText.getBytes());
			//3. �˰����� ����Ǿ� ��ȯ�� ���� �޴´�
			byte[]b=md.digest();
			//4. ����� �˾ƺ� �� �ִ� ���ڿ��� ����
			//4-1. ��� 1
			//4-2. ��� 2
			for (int i=0;i<b.length;i++) {
				cipherText.append(Integer.toString((b[i]&0xFF)+0x100,16).substring(1));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return cipherText.toString();
	}

}
