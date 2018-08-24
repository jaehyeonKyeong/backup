<!-- 페이지 지시자는 JSP페이지 내 어디에서든 정의하여 사용할 수 있다. -->
<!-- 하나의 지시자에 여러개의 속성을 정의하여 사용 -->
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="페이지 지시자의 사용"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat"%>
<%@ page buffer="8kb" autoFlush="true" isThreadSafe="false"%>
<%@ page session="true"%>
<%@ page isELIgnored="false"%>
<%@ page errorPage="err.jsp"%>
<%
	session.setAttribute("name", "송재원");
	if (new Random().nextBoolean()) {
		throw new Exception("오지고요 지리고요 고요고요 고요한 밤이고요");}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="http://211.63.89.140:8080/jsp_prj/common/css/main.css">
<!-- CDN -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<%
		//1.import받은 객체 사용
			Calendar cal = Calendar.getInstance();
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	%>
	<%=cal%><br>
	<%=d%><br>
	<%=sdf.format(d)%><br> 7+25=${7+25} 파라메터 : ${param.msg}
	<a href="use_page_directive.jsp?msg=오늘은 수요일">요청</a>
</body>
</html>