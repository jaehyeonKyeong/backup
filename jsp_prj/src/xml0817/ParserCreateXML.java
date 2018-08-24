package xml0817;

import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.omg.Messaging.SyncScopeHelper;

public class ParserCreateXML {
	

	public ParserCreateXML() {
	}
	
	public void createLunchXml() throws IOException {
		//1.최상위 부모 노드 생성
		Element rootNode=new Element("lunch");
		String[] menu= {"탄","닭가슴","직화락","부자곱"};
		
		Element cntNode=new Element("cnt");
		cntNode.setText(String.valueOf(menu.length));
		rootNode.addContent(cntNode);
		//2.최상위 부모노드에 자식노드 배치
		Element subNode=null;
		for(String data:menu) {
			//자식 노드를 생성
			subNode=new Element("menu");
			//자식노드의 값을 설정
			subNode.setText(data);
			//생성된 자식노드를 부모 노드에 추가
			rootNode.addContent(subNode);
		}//for
		Document doc=new Document();
		doc.addContent(rootNode);
		
		//생성된 xml문서 객체를 출력
		
		//getCommpactFormat(),getPrettyFormat(),getRowFormat()
		XMLOutputter x_out=new XMLOutputter(Format.getPrettyFormat());
		//x_out.output(doc,System.out);
		FileOutputStream fos=new FileOutputStream("C:/dev/workspace/jsp_prj/src/xml0817/lunch.xml");
		x_out.output(doc, fos);
		fos.close();
		
		
		
	}

	public static void main(String[] args) {
		ParserCreateXML pcx=new ParserCreateXML();
		try {
			pcx.createLunchXml();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
