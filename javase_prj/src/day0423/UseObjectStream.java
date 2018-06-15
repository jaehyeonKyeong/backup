package day0423;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ��ü�� �����Ͽ� ������ ��ü�� ObjectOutputStream�� FileOutputStream�� ����Ͽ� ���Ϸ� ��������, ���Ͽ� �����
 * ��ü�� FileInputStream�� ObjectInputStream���� �о���̴� ��
 *
 * @author owner
 */
public class UseObjectStream {

	public UseObjectStream() {
	}// constructor

	public void writeObj() throws IOException {
		MyData md = new MyData("���¹�", 183.6, 93.5);
		ObjectOutputStream oos = null;
		try {
			File file = new File("c:/dev/temp_data/my_info.dat");
			// stream����
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(md);// Stream�� ��ü ����
			oos.flush();// stream�� �ִ� �����͸� ����
			System.out.println("��ü ������ file�� ���� ����");
		} catch (NotSerializableException nse) {
			System.err.println("��ü ����ȭ�� ���� �ʽ��ϴ�.");
		} finally {
			if (oos != null) {
				oos.close();
			}
		}

	}

	public void readObj() throws IOException {
		File file = new File("c:/dev/temp_data/my_info.dat");
		ObjectInputStream ois = null;
		try {
			//���Ͽ��� ��ü�� �б����� stream����
			ois=new ObjectInputStream(new FileInputStream(file));
			//stream���� ��ü �б�
			MyData md=(MyData)ois.readObject();
			System.out.println("-----�о� ���� ��ü�� ��-----");
			System.out.println("�̸� "+md.getName()+", Ű:"+md.getHeight()+",������ : "+md.getWeight());
		}catch(ClassNotFoundException cnfe){
			System.err.println("���Ͽ� ��ü�� �����ϴ� T��T");
			
		}catch(InvalidClassException ice){
			System.err.println("��ȿ�Ⱓ�� ���� ��ü�Դϴ�. ���̻� ����Ҽ� �����");
		} finally {
			if (ois != null) {
				ois.close();
			}
		}

	}

	public static void main(String[] args) {
		UseObjectStream uos = new UseObjectStream();
		try {
//			uos.writeObj();
			uos.readObj();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
