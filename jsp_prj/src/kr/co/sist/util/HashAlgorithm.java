package kr.co.sist.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;

public class HashAlgorithm {
	

	public static String changeMD5(String plainText){
		StringBuilder cipherText=new StringBuilder();
		
		try {
			//1.사용할 알고리즘 선택
			MessageDigest md=MessageDigest.getInstance("MD5"); //단기간 저장하는 암호문
			//2.문자열을 알고리즘을 사용하여 변환
			md.update(plainText.getBytes());
			//3. 알고리즘이 적용되어 변환된 값을 받는다
			byte[]b=md.digest();
			//4. 사람이 알아볼 수 있는 문자열로 변경
			//4-1. 방법 1
			//4-2. 방법 2
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
			//1.사용할 알고리즘 선택
			MessageDigest md=MessageDigest.getInstance("SHA-512"); //장기간 저장하는 암호문
			//2.문자열을 알고리즘을 사용하여 변환
			md.update(plainText.getBytes());
			//3. 알고리즘이 적용되어 변환된 값을 받는다
			byte[]b=md.digest();
			//4. 사람이 알아볼 수 있는 문자열로 변경
			//4-1. 방법 1
			//4-2. 방법 2
			for (int i=0;i<b.length;i++) {
				cipherText.append(Integer.toString((b[i]&0xFF)+0x100,16).substring(1));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return cipherText.toString();
	}

}
