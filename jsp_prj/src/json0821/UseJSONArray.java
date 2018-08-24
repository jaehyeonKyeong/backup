package json0821;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class UseJSONArray {

	public UseJSONArray() throws IOException {
		String[][] data = { { "���ֿ�", "����", "������ �ȸ�ŭ ������ ����� �ϰڴ�." }, { "�����", "�ι���", "���� ���ؼ� ������ �߱��س��ڴ�." },
				{ "������", "�ѹ�", "�ѽĺ��� ��Ƽ�� ����." }, { "������", "�渮", "�渮�� ���ι����� ����~^o^b" },
				{ "�赿��", "��", "���̾�Ʈ���� �߰����쿡 ����" }, { "�����", "����", "���������� �����ڸ��� ..." } };
		FileWriter fw=null;
		try {
			// 1.JSONArray����
			JSONArray ja = new JSONArray();
			// 2.
			JSONObject temp = null;
			for (int i = 0; i < data.length; i++) {
				// ���� �����Ѵٸ� JSONObject����
				temp = new JSONObject();
				// ���� ������ JSONObject�߰�
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
