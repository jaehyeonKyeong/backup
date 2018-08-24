<%@page import="java.util.Random"%>
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
	<%
	if(new Random().nextBoolean()){
		response.sendRedirect("response_b.jsp");
		return;
	}
	%>
	<div>
	<img src="images/success.PNG"><br>
	캬~~~~이맛이고만
	</div>
	<%
	//System.out.println("ㅋㅋㅋㅋㅋㅋㅋ"); // 콘솔출력
	log("-----------실행---------");//콘솔 출력 - 어떤파일에서 출력되었는지 확인
	%>
</body>
</html>