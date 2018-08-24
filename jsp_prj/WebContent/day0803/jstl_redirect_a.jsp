<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main.css">
<!--  CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<img src="../day0802/images/fri.png"/>
	
	<%
		boolean flag=new Random().nextBoolean();
		pageContext.setAttribute("flag", flag);
	%>
	
	<c:if test="${ pageScope.flag}">
	<c:redirect url="jstl_redirect_b.jsp"/>
	</c:if>
	
</body>
</html>