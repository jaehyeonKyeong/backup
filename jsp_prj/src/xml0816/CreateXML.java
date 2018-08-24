package xml0816;

import java.beans.PersistenceDelegate;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateXML {

	public CreateXML() {

	}

	public void createPresonData() throws IOException {
		BufferedWriter bw = null;
		try {
			
			//1.XML생성
			List<PersonVO> list=new ArrayList<PersonVO>();
			list.add(new PersonVO("최주오","경기도 수원시 권선구",1993));
			list.add(new PersonVO("송재원","경기도 성남시 수정구",1994));		
			list.add(new PersonVO("경제현","경기도 구리시 인창동",1995));		
			list.add(new PersonVO("김동희","서울시 중구 신당동" ,1990));
			
			StringBuilder personXml=new StringBuilder();
			personXml.append("<?xml version='1.0' encoding='UTF-8'?>\n");
			personXml.append("\t<persons>\n");
			personXml.append("\t\t<title>class4 닝겐들</title>\n");
			personXml.append("\t\t<pubDate>");
			personXml.append(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
			personXml.append("</pubDate>\n");
			personXml.append("\t\t<recCount>");
			personXml.append(list.size());
			personXml.append("</recCount>\n");
			if(list.size()>0) {
				for(PersonVO pv:list) {
					personXml.append("\t\t<person>\n");
					personXml.append("\t\t\t<name>");
					personXml.append(pv.getName());
					personXml.append("</name>\n");
					personXml.append("\t\t\t<birthYear>");
					personXml.append(pv.getBirthYear());
					personXml.append("</birthYear>\n");
					personXml.append("\t\t\t<addr>");
					personXml.append(pv.getAddr());
					personXml.append("</addr>\n");
					personXml.append("\t\t</person>\n");
				}
			}
			
			personXml.append("\t</persons>\n");
			bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:/dev/workspace/jsp_prj/WebContent/xml0816/person_data.xml"),"UTF-8"));
			bw.write(personXml.toString());
			bw.flush();
			bw.close(); //아래쪽에서 끊어지기는 하겠지만 정상적인 경우에 먼저 끊어준다.
			System.out.println(personXml.toString());
		} finally {
			if (bw != null) {
				bw.close();
			}
		}
		
	}

	public static void main(String[] args) {
		CreateXML cm = new CreateXML();
		try {
			cm.createPresonData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
