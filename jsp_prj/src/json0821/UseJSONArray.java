package json0821;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class UseJSONArray {

	public UseJSONArray() throws IOException {
		String[][] data = { { "최주오", "반장", "반장이 된만큼 지각을 충실히 하겠다." }, { "송재원", "부반장", "반을 위해서 맛집을 발굴해내겠다." },
				{ "경제현", "총무", "한식뷔페 파티원 모집." }, { "이종민", "경리", "경리는 나인뮤지스 데헷~^o^b" },
				{ "김동희", "고문", "다이어트에는 닭가슴살에 망토" }, { "김우현", "역적", "수료전까지 반장자리를 ..." } };
		FileWriter fw=null;
		try {
			// 1.JSONArray생성
			JSONArray ja = new JSONArray();
			// 2.
			JSONObject temp = null;
			for (int i = 0; i < data.length; i++) {
				// 행이 존재한다면 JSONObject생성
				temp = new JSONObject();
				// 값을 생성된 JSONObject추가
				temp.put("name", data[i][0]);
				temp.put("job", data[i][1]);
				temp.put("msg", data[i][2]);
				ja.add(temp);
			}
			System.out.println(ja);

			fw = new FileWriter("C:/dev/workspace/jsp_prj/src/json0821/arr_data.json");
			ja.writeJSONString(fw);
			fw.flush();
		} finally {
			if(fw!=null) {fw.close();}
		}

	}

	public static void main(String[] args) {
		try {
			new UseJSONArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
