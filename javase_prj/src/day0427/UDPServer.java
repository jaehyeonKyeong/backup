package day0427;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPServer {

	public UDPServer() throws IOException {
		String data1 = "아";
		String data2 = "어?";
		byte[] dataArr = data1.getBytes();
		DatagramPacket dp = new DatagramPacket(dataArr, dataArr.length, InetAddress.getByName("211.63.89.141"), 1025);
		DatagramPacket dp1 = new DatagramPacket(data2.getBytes(), data2.getBytes().length,
				InetAddress.getByName("211.63.89.130"), 1025);
		// 소켓생성
		DatagramSocket ds = new DatagramSocket();
		// 패킷데이터를 소켓을 통해 보내기
		ds.send(dp);
		ds.send(dp1);
		// 소켓 닫기
		ds.close();
	}

	public static void main(String[] args) {
		try {
			new UDPServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// String temp="sist.co.kr";
		// try {
		// System.out.println(InetAddress.getByName(temp));
		// } catch (UnknownHostException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

}
