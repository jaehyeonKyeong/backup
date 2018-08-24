package xml0816;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParsingXML {
	
	

	public ParsingXML() {
		
	}
	
	public void parsing()throws IOException{
		BufferedReader br=null;
		try {
			//1. xml을 연결
			br=new BufferedReader(new InputStreamReader
					(new FileInputStream("C:/dev/workspace/jsp_prj/WebContent/xml0816/msg.xml"),"UTF-8"));
			//2.파일에서 줄단위로 읽어 들이기
			String temp="",parsingNode="",data="";
			while((temp=br.readLine())!=null) {
				//3.노드 얻기
				parsingNode=temp.substring(temp.indexOf("<")+1, temp.indexOf(">"));
				if("msg".equals(parsingNode)) {
					data=temp.substring(temp.indexOf(">")+1,temp.lastIndexOf("<"));
					System.out.println(data);
				}
			}
			
			
		}finally {
			if(br!=null) {
				br.close();
			}
		}
	}

	public static void main(String[] args) {
		ParsingXML p_xml=new ParsingXML();
		try {
			p_xml.parsing();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
