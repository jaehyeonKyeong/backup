package day0409;

import java.util.ArrayList;
import java.util.Date;
//import java.sql.Date; //��Ű���� �ٸ��� Ŭ���� ���� ���ٸ� ���� �ϳ��� import ���� �� ����.
import java.util.List;
//import java.awt.List;

/**
 * import(�ٸ���Ű�� ���� Ŭ������ interface�� ����Ҷ�)�� <br>
 * static import(�ٸ� ��Ű������ Ŭ���� �� static ������ static method�� ����Ҷ�)�� ���<br>
 * �ʿ��� ��ŭ �����ϰ� ��
 * 
 * @author owner
 */
//Ư�� Ŭ������ interface�� ���� ������ �� �ִ�.
//import java.util.Date;
//import java.util.List;
//import java.util.ArrayList;

//Ư����Ű���� ��� Ŭ������ interface���
//import java.util.*;//�ӵ��� ���� //ctrl+shift+o �ѹ��� ����Ʈ

//static import �ٸ�Ŭ���� ���� static ����, method�� �� Ŭ���� �ȿ� �����ϴ� ��ó�� Ŭ���� ���� �����ϰ� ���°�.
//���� : import static ��Ű����.Ŭ������.static������;
import static java.lang.Integer.parseInt; //method���
import static java.lang.Long.MAX_VALUE;	//constant ���


public class UseImport {

	@SuppressWarnings({ "unused", "rawtypes" })
	public static void main(String[] args) {
		
		Date d=new Date();
		//�ٸ� ��Ű���� ���ϸ� Ŭ����(method)�� ����ϱ����ؼ� full path�� �ɾ��־����
		java.sql.Date d1=new java.sql.Date(1L);//sql��Ű���� Date 
		List l=new ArrayList();//(is-a (���)������ ��üȭ) //��ü�پ缺�� ��������
		java.awt.List l1=new java.awt.List();// java.awt�� ����Ʈ
		
		String s1="4";
		String s2="65";
		String s3="166";
		
//		int i1=Integer.parseInt(s1);
//		int i2=Integer.parseInt(s2);
//		int i3=Integer.parseInt(s3);
		int i1=parseInt(s1);
		int i2=parseInt(s2);
		int i3=parseInt(s3);
		
		System.out.println(MAX_VALUE);
		
		
	}

}
