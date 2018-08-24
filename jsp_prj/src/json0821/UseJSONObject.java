package json0821;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class UseJSONObject {

	public UseJSONObject() throws IOException {
		String name="�����";
		int age=25;
		String addr="��⵵ ������ ������ ����";
		//1.��ü ����
		JSONObject person=new JSONObject();
		//2.������
		person.put("name", name);
		person.put("age", age);
		person.put("addr", addr);
		//3.���
		System.out.println(person);
		FileWriter fw=new FileWriter("C:/dev/workspace/jsp_prj/src/json0821/data.json");
		//��1�� ���
		person.writeJSONString(fw);
		fw.flush();
		fw.close();
		System.out.println("���Ϸ� �����Ǿ����ϴ�.");
		
		
	}

	public static void main(String[] args) {
		try {
			new UseJSONObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main

}//class
