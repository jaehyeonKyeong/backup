package day0427;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ObjectServer {

	public ObjectServer() throws IOException {
		//1.������ ��ü ����
//		GroupMemberDTO gmd=new GroupMemberDTO("������",25);
		List<String> list=new ArrayList<String>();
		list.add("��");
		list.add("��");
		list.add("��");
		list.add("��");
		list.add("��");
		list.add("��");
		list.add("��");
		list.add("��");
		
		GroupMemberDTO1 gmd1=new GroupMemberDTO1(list);
		
		
		//2.server socket���� : port����
		ServerSocket ss=new ServerSocket(65311);
		System.out.println("���� �۵� ���̿���...");
		Socket client=null;
		while(true) {
			
			//3.������ ���� �ޱ�
			client=ss.accept();
			//4.��ü�� �������� ���� Stream�� ����
			ObjectOutputStream oos=new ObjectOutputStream(client.getOutputStream());
			//5.Stream�� ��ü ����
//			oos.writeObject(gmd);
			oos.writeObject(gmd1);
			//6.����
			oos.flush();
			System.out.println(client.getInetAddress().getHostAddress()+"����"+gmd1.getList().get(0)+"�� ���¾��!");
		}
	}

	
	public static void main(String[] args) {
		try {
			new ObjectServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//main

}//class
