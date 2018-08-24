package json0821;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class UseJSONTerribleHype {
	
	public UseJSONTerribleHype() throws IOException {
		
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String date=sdf.format(d);
		
		String[][] dataSource= {{"최주오","지의 의지"},{"경제현","탈붓다"},{"송재원","송북"}};
		JSONObject pubJSON=new JSONObject();
		JSONArray data=null;
		JSONObject dataSourceJSON=null;

		data=new JSONArray();
		for(int i=0;i<dataSource.length;i++) {
			dataSourceJSON=new JSONObject();
			dataSourceJSON.put("name", dataSource[i][0]);
			dataSourceJSON.put("nick", dataSource[i][1]);
			data.add(dataSourceJSON);
		}
		pubJSON.put("pubDate", date);
		pubJSON.put("cnt", dataSource.length);
		pubJSON.put("data", data);
		
		FileWriter fw=new FileWriter("C:/dev/workspace/jsp_prj/src/json0821/json_terible_hype.json");
		pubJSON.writeJSONString(fw);
		fw.flush();
		fw.close();
		
	}

	public static void main(String[] args) {
		try {
			new UseJSONTerribleHype();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
