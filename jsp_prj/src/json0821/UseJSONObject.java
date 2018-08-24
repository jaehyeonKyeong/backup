package json0821;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class UseJSONObject {

	public UseJSONObject() throws IOException {
		String name="송재원";
		int age=25;
		String addr="경기도 성남시 수정구 태평동";
		//1.객체 생성
		JSONObject person=new JSONObject();
		//2.값설정
		person.put("name", name);
		person.put("age", age);
		person.put("addr", addr);
		//3.출력
		System.out.println(person);
		FileWriter fw=new FileWriter("C:/dev/workspace/jsp_prj/src/json0821/data.json");
		//파1로 출력
		person.writeJSONString(fw);
		fw.flush();
		fw.close();
		System.out.println("파일로 생성되었습니다.");
		
		
	}

	public static void main(String[] args) {
		try {
			new UseJSONObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main

}//class
