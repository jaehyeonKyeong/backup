package day0427;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;

public class ObjectClient {
	
	public ObjectClient() throws IOException, ClassNotFoundException{
		//���� ���� ������ ����
		Socket client=new Socket("211.63.89.133", 65311);
		//�������� �����ϴ� ��ü�� �б�
		ObjectInputStream ois=null;
		try {
			ois=new ObjectInputStream(client.getInputStream());
//			GroupMemberDTO gmd = (GroupMemberDTO) ois.readObject(); //return�� object�̱� ������ �ڽ�Ŭ������ GroupMemberDTO�� ĳ���� ���־���Ѵ�.
//			System.out.println("�޾ƿ� �̸� : "+gmd.getName()+",���� :"+gmd.getAge());
			GroupMemberDTO1 gmd1= (GroupMemberDTO1)ois.readObject();
			List<String> list=gmd1.getList();
			System.out.println("�޾ƿ� ������ ");
			for(String name:list) {
				System.out.println(name);
			}
		}finally {
			if(ois!=null) {ois.close();}
			if(client!=null) {client.close();}
		}
	}//constructor

	public static void main(String[] args) {
		try {
			new ObjectClient();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
