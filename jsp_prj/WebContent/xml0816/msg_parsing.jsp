<%@page import="java.util.Iterator"%>
<%@page import="javax.servlet.jsp.tagext.IterationTag"%>
<%@page import="java.util.List"%>
<%@page import="org.jdom2.Element"%>
<%@page import="org.jdom2.Document"%>
<%@page import="java.net.URL"%>
<%@page import="org.jdom2.input.SAXBuilder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"href="http://localhost:8080/jsp_prj/common/css/main.css">
<!-- CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<%
		//1.Builder
		SAXBuilder sb=new SAXBuilder();
		//2.XML문서를 객체로 얻는다
		Document doc=sb.build(new URL("http://localhost:8080/jsp_prj/xml0816/msg.xml"));
		//System.out.println(doc);
		
		//3.최상위 부모 노드 얻기
		Element rootNode=doc.getRootElement();
		//System.out.println(rootNode);
		
		//4.자식 노드들 얻기
		List<Element> msgNodes=rootNode.getChildren();
		//out.println("노드의 수"+msgNodes.size());
		
		Iterator<Element> msgIta=msgNodes.iterator();
	%>
	<ul>
	<%
	Element msgNode=null;
	while(msgIta.hasNext()){//요소가 존재한다면
		msgNode=msgIta.next();//요소를 Element객체에 저장
	%>
	<li><%= msgNode.getName() %> : <%=msgNode.getValue() %></li>
	<%}%>
	
	</ul>
</body>
</html>