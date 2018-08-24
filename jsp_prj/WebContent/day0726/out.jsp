<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"href="http://211.63.89.140:8080/jsp_prj/common/css/main.css">
<!-- CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<%String[] url={"nexon.com","naver.com","youtube.com","sist.co.kr"};
		for(String site:url){
			out.print("<a href='http://");
			out.print(site);
			out.print("'>");
			out.print(site);
			out.print("</a><br>");
		}
	%>
	<div style="border:1px solid #333">
	<%
		for(String site:url){
			%>
			<a href="http://<%= site %>"><%= site %></a><br>
			<%
		}
	%>
</body>
</html>