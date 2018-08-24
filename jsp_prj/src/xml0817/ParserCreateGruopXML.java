package xml0817;

import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class ParserCreateGruopXML {

	public void createXML() throws IOException {
		// 1.최상위 부모노드 생성
		Element rootNode = new Element("group");
		String[] groupNode = { "group_1", "group_2", "group_3" };
		String[][] groupMember = { { "최주오", "신종성", "이종민", "김우현", "강지형", "이진영" }, 
				{ "경제현", "강소예", "박지영", "이동근", "송재원" },
				{ "김대현", "김동희", "후니다123", "뚜딘", "오경림" } };

		// 2.최상위 부모노드에 자식노드 배치
		Element subNode = null;
		Element memberNode = null;
		int i = 0;
		for (String data : groupNode) {
			subNode = new Element(data);
			for (int j = 0; j < groupMember[i].length; j++) {
				memberNode = new Element("member");
				memberNode.setText(groupMember[i][j]);
				subNode.addContent(memberNode);
			}
			i++;
			rootNode.addContent(subNode);
		}
		Document doc = new Document();
		doc.addContent(rootNode);

		// getCommpactFormat(),getPrettyFormat(),getRowFormat()
		XMLOutputter x_out = new XMLOutputter(Format.getPrettyFormat());
		// x_out.output(doc,System.out);
		FileOutputStream fos = new FileOutputStream("C:/dev/workspace/jsp_prj/src/xml0817/group.xml");
		x_out.output(doc, fos);
		fos.close();

	}

	public static void main(String[] args) {
		ParserCreateGruopXML pcgXml = new ParserCreateGruopXML();
		try {
			pcgXml.createXML();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
