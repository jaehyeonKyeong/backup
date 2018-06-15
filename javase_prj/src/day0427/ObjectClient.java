package day0427;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;

public class ObjectClient {
	
	public ObjectClient() throws IOException, ClassNotFoundException{
		//소켓 생성 서버와 연동
		Socket client=new Socket("211.63.89.133", 65311);
		//서버에서 전달하는 객체를 읽기
		ObjectInputStream ois=null;
		try {
			ois=new ObjectInputStream(client.getInputStream());
//			GroupMemberDTO gmd = (GroupMemberDTO) ois.readObject(); //return이 object이기 때문에 자식클래스인 GroupMemberDTO로 캐스팅 해주어야한다.
//			System.out.println("받아온 이름 : "+gmd.getName()+",나이 :"+gmd.getAge());
			GroupMemberDTO1 gmd1= (GroupMemberDTO1)ois.readObject();
			List<String> list=gmd1.getList();
			System.out.println("받아온 조원들 ");
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
