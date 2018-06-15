package day0424;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

/**
 * ������ �����Ͽ� ������ ������ �����ϴ� �� (���� port�� ����� ������ ���� �𸥴�.)
 * @author owner
 */
public class SimpleClient {
	//130,132,133,134,135,137,139,140,141,142,144,145,146,147,148,149,150,151,152,153,154
	@SuppressWarnings({ "unused", "resource" })
	public SimpleClient() throws UnknownHostException, IOException {
		Socket socket=new Socket("211.63.89.133",35000);
		System.out.println("Client ���� ������ ���ӽõ�");
		//�������� �������� �޼����� �ޱ����� �Է� ��Ʈ���� ���Ͽ������� ����.
		DataInputStream dis=new DataInputStream(socket.getInputStream());
		//�Է� ��Ʈ������ encoding�� �ѱ��� ���´�
		String msg=dis.readUTF();//���ڵ��� �ѱ��� ������ �ѱ۷� ��ȯ�Ͽ� ���ڿ��� �о� ���δ�
		
		//������ �޼��� ������
		String sendMsg=JOptionPane.showInputDialog("���� �޼���" +msg+"\n���� �޽��� �ۼ�");
		DataOutputStream dos =new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(sendMsg);
		
		
	}//constructor
	public static void main(String[] args) {
		try {
			new SimpleClient();
		} catch (UnknownHostException e) {
			System.err.println("ip address�� ������ �������� �ʽ��ϴ�");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("��� �߿� ��ְ� �߻��Ͽ����ϴ�.");
			e.printStackTrace();
		}
	}//main

}//SimpleClient
