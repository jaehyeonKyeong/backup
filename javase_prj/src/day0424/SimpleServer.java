package day0424;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 *Server : Port�� ���� ������ ������ �����ϱ⸦ ��ٷȴٰ� ���ӵ� ������ �޴���
 * @author owner
 */
public class SimpleServer {
	@SuppressWarnings("resource")
	public SimpleServer() throws IOException {
		//1.ServerSocket ���� : port�� ����(����)
		ServerSocket server=new ServerSocket(65000);
		System.out.println("���� ���� ��");
		//3.������Socket�� �ִٸ� ������Socket�� �ޱ�
		Socket client;
		String msg="����!!";
		DataOutputStream dos=null;
		DataInputStream dis=null;
		while(true) {
		client=server.accept();
		//4.������ �����ϴ� �޽����� �����ڿ��� ������ ���� ��� ��Ʈ�� ���
		System.out.println("������ : "+client);
		dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();
		
		dis=new DataInputStream(client.getInputStream());
		JOptionPane.showMessageDialog(null, "����޼���"+client.getInetAddress()+" : "+dis.readUTF());
//		server.close();
		}
		
	}//constructor
	
	public static void main(String[] args) {
		try {
			new SimpleServer();
		} catch (IOException e) { 
			System.err.println("��Ʈ�� �̹� ��� �� �Դϴ�.");
			e.printStackTrace();
		}
	}//main

}//simpleServer
