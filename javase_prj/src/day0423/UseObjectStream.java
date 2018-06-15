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
 * 객체를 생성하여 생성된 객체를 ObjectOutputStream과 FileOutputStream을 사용하여 파일로 내보내고, 파일에 저장된
 * 객체를 FileInputStream과 ObjectInputStream으로 읽어들이는 일
 *
 * @author owner
 */
public class UseObjectStream {

	public UseObjectStream() {
	}// constructor

	public void writeObj() throws IOException {
		MyData md = new MyData("지승민", 183.6, 93.5);
		ObjectOutputStream oos = null;
		try {
			File file = new File("c:/dev/temp_data/my_info.dat");
			// stream생성
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(md);// Stream에 객체 쓰기
			oos.flush();// stream에 있는 데이터를 분출
			System.out.println("객체 생성후 file에 쓰기 성공");
		} catch (NotSerializableException nse) {
			System.err.println("객체 직렬화가 되지 않습니다.");
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
			//파일에서 객체를 읽기위한 stream생성
			ois=new ObjectInputStream(new FileInputStream(file));
			//stream에서 객체 읽기
			MyData md=(MyData)ois.readObject();
			System.out.println("-----읽어 들인 객체의 값-----");
			System.out.println("이름 "+md.getName()+", 키:"+md.getHeight()+",몸무게 : "+md.getWeight());
		}catch(ClassNotFoundException cnfe){
			System.err.println("파일에 객체가 없습니다 TㅅT");
			
		}catch(InvalidClassException ice){
			System.err.println("유효기간이 지난 객체입니다. 더이상 사용할수 없어요");
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
