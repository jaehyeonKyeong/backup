<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.jdom2.Element"%>
<%@page import="java.net.URL"%>
<%@page import="org.jdom2.Document"%>
<%@page import="org.jdom2.input.SAXBuilder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="JTBC에서 제공하는 RSS 파싱"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/jsp_prj/common/css/main.css">
<!-- CDN -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
</script>
<style>
#num {
	width: 80px;
}

#title {
	width: 700px;
}

#inputDate {
	width: 130px
}

table {
	border-spacing: 0px
}

th, td {
	border-bottom: 1px solid #333
}
</style>
</head>
<body>
	<%
		//1.Builder생성
		SAXBuilder sb = new SAXBuilder();

		//2.xml 문서 객체 얻기
		Document doc = sb.build(new URL("http://fs.jtbc.joins.com/RSS/newsflash.xml"));
		//System.out.println(doc);

		//3.최상위 부모node얻기
		Element rootNode = doc.getRootElement();
		//System.out.println(rootNode);//최상위 노드는 rss node

		//4.자식 노드 얻기
		Element channelNode = rootNode.getChild("channel");
		//System.out.println(channelNode);
		//title,copyright,pubDate node값 얻기
		String title = "", copyright = "", pubDate = "";
		Element titleNode = channelNode.getChild("title");
		Element copyrightNode = channelNode.getChild("copyright");
		Element pubDateNode = channelNode.getChild("pubDate");

		title = titleNode.getValue();
		copyright = copyrightNode.getValue();
		pubDate = pubDateNode.getValue();

		//item 노드들 얻기
		List<Element> someNodes = channelNode.getChildren();
		Iterator<Element> someIta = someNodes.iterator();
	%>
	<table>
		<tr>
			<th colspan="3"><span style="font-size: 20px"><%=title%></span>
				<span>(<%=pubDate%>)
			</span></th>
		</tr>
		<tr>
			<th id="num">번호</th>
			<th id="title">제목</th>
			<th id="inputDate">작성일</th>
		</tr>
		<%
			Element someNode = null;
			Element itemSubNode=null;
			Iterator<Element> itemSubIta=null;
			
			String newsTitle="",link="",description="",newsPubDate="";
			StringBuilder content=new StringBuilder();
			int cnt=0;
			while (someIta.hasNext()) {
				someNode = someIta.next();
				//parsing한 노드가 item노드라면
				if ("item".equals(someNode.getName())) {
					//item노드의 하위 노드들 받기
					itemSubIta=someNode.getChildren().iterator();
					out.println("<tr>");
					out.print("<td>");
					out.print(++cnt);
					out.print("</td>");
					while(itemSubIta.hasNext()){
						itemSubNode=itemSubIta.next();
						if("title".equals(itemSubNode.getName())){
							newsTitle=itemSubNode.getValue();
						}
						if("link".equals(itemSubNode.getName())){
							link=itemSubNode.getValue();
						}
						if("description".equals(itemSubNode.getName())){
							description=itemSubNode.getValue();
						}
						if("pubDate".equals(itemSubNode.getName())){
							newsPubDate=itemSubNode.getValue();
						}
					}//end while
					content.append("<td><a href='").append(link)
					.append("' title=\"").append(description).append("\">")
					.append(newsTitle).append("</a></td><td>").append(newsPubDate)
					.append("</td>");
					out.println(content.toString());
					out.println("</tr>");
					content.delete(0,content.length());
				}//end if
			}//end while
		%>
	</table>
</body>
</html>