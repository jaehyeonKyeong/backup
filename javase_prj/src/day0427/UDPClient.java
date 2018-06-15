package day0427;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPClient {
	
	public UDPClient() throws IOException {
		//���� ����
		DatagramSocket ds=new DatagramSocket(1025);
		//��Ŷ�� ���� �� �ִ� ��Ŷ ��ü ����.
		byte[] data=new byte[512];
		DatagramPacket dp=new DatagramPacket(data, data.length);
		//�������� ���� ���޵Ǵ� ��Ŷ �ޱ�
		ds.receive(dp);
		//��Ŷ�� ���޵� ������ ���

		byte[] receiveData=dp.getData();
		System.out.println("�������"+dp.getAddress()+"������"+new String(receiveData));
	}

	public static void main(String[] args) {
		try {
			new UDPClient();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
