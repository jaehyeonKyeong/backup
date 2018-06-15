package day0427;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPClient {
	
	public UDPClient() throws IOException {
		//소켓 열기
		DatagramSocket ds=new DatagramSocket(1025);
		//패킷을 받을 수 있는 패킷 객체 생성.
		byte[] data=new byte[512];
		DatagramPacket dp=new DatagramPacket(data, data.length);
		//소켓으로 부터 전달되는 패킷 받기
		ds.receive(dp);
		//패킷에 전달딘 데이터 얻기

		byte[] receiveData=dp.getData();
		System.out.println("보낸사람"+dp.getAddress()+"데이터"+new String(receiveData));
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
