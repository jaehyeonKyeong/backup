package kr.co.sist.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class HangulConv {
	
	public static String toUTF(String str) {
		if(str!=null&&!"".equals(str)) {
			try {
				str=new String(str.getBytes("8859_1"),"UTF-8");
			}catch(UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return str;
	}
	public static String toEUC(String str) {
		if(str!=null&&!"".equals(str)) {
			try {
				str=new String(str.getBytes("8859_1"),"EUC-KR");
			}catch(UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return str;
	}
	public static String to8859(String str) {
		if(str!=null&&!"".equals(str)) {
			try {
				str=URLEncoder.encode(str,"UTF-8");
			}catch(UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return str;
	}
}
