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
		//1.�ֻ��� �θ� ��� ����
		Element rootNode=new Element("lunch");
		String[] menu= {"ź","�߰���","��ȭ��","���ڰ�"};
		
		Element cntNode=new Element("cnt");
		cntNode.setText(String.valueOf(menu.length));
		rootNode.addContent(cntNode);
		//2.�ֻ��� �θ��忡 �ڽĳ�� ��ġ
		Element subNode=null;
		for(String data:menu) {
			//�ڽ� ��带 ����
			subNode=new Element("menu");
			//�ڽĳ���� ���� ����
			subNode.setText(data);
			//������ �ڽĳ�带 �θ� ��忡 �߰�
			rootNode.addContent(subNode);
		}//for
		Document doc=new Document();
		doc.addContent(rootNode);
		
		//������ xml���� ��ü�� ���
		
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
