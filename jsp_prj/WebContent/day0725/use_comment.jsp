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
	<% String lunch="콩나물탄"; %>
	<marquee> 오늘 점심은 <%= lunch %></marquee>
	JSP 주석 : <%-- java코드로 생성되지 않는다<%=lunch%> --%><br>
	HTML주석 : <!--<%=lunch%> -->
</body>
</html>