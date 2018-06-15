package day0418;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Throws�� method�� constructor�ڿ� ����<br>
 * constructor �ڿ� ������ throws�� ��üȭ �Ҷ� try~catch�� ó���ϰ�<br>
 * method �ڿ� ������ throws�� method�� ȣ���Ҷ� try~catch�� ó���Ѵ�.<br>
 * <br>
 * throws : method�� constructor�ȿ��� �߻��� ���ܸ� ���� ȣ���� ������ ó���ϵ��� ����°�
 * 
 * @author owner
 */
public class UseThrows {

	public UseThrows() throws ClassNotFoundException {
		Class.forName("java.lang.Integer");// ���ܰ� �߻��ϸ� �Ʒ����� �������� �ʰ� ȣ���� ������ �����ִ� catch�� �̵��ϰ� ��
		System.out.println("Integer class loading ����");
	}

	public void test() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("c:/dev/env.bat");
		System.out.println(fis);
	}

	public static void main(String[] args) {
		try {
			UseThrows ut = new UseThrows();
			ut.test();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}

	}// main

}// class
