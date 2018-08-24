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
			
			//1.XML����
			List<PersonVO> list=new ArrayList<PersonVO>();
			list.add(new PersonVO("���ֿ�","��⵵ ������ �Ǽ���",1993));
			list.add(new PersonVO("�����","��⵵ ������ ������",1994));		
			list.add(new PersonVO("������","��⵵ ������ ��â��",1995));		
			list.add(new PersonVO("�赿��","����� �߱� �Ŵ絿" ,1990));
			
			StringBuilder personXml=new StringBuilder();
			personXml.append("<?xml version='1.0' encoding='UTF-8'?>\n");
			personXml.append("\t<persons>\n");
			personXml.append("\t\t<title>class4 �װյ�</title>\n");
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
			bw.close(); //�Ʒ��ʿ��� ��������� �ϰ����� �������� ��쿡 ���� �����ش�.
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
