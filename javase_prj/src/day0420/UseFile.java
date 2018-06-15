package day0420;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UseFile {

	public UseFile() throws IOException {
		File file = new File("c:/dev/env.bat");
		// ���Ͽ� ���� ���� ���
		if (file.exists()) {
			System.out.println("���� ����");
			System.out.println("��ü: " + file);
			System.out.println("Canonical: " + file.getCanonicalPath());
			System.out.println("Absolute: " + file.getAbsolutePath());
			System.out.println("path: " + file.getPath());
			System.out.println("������: " + file.getParent());
			System.out.println("���ϸ�: " + file.getName());
			System.out.println(file.isFile() ? "����" : "����");
			System.out.println(file.isDirectory() ? "����" : "����");
			System.out.println(file.canWrite() ? "���� ����" : "���� �Ұ�");
			System.out.println(file.canExecute() ? "���� ����" : "���� �Ұ�");
			System.out.println(file.isHidden() ? "����" : "�Ϲ�");
			System.out.println("������ ũ��: " +file.length()+"byte");
			
			Date date=new Date(file.lastModified());
			SimpleDateFormat sdf=new SimpleDateFormat();
			System.out.println("���������� ������ ��¥ : "+sdf.format(date));

		} else {
			System.out.println("���Ͼ��� : ��γ� ���ϸ��� Ȯ���ϼ���");
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
