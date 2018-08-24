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
	<c:catch var="e">
	<%
		String[] className={"java.lang.String","day0703.TestVO","kr.co.sist.util.HashAlgorithm	"};
	//_jspService method 안으로 코드가 생성되는데
	//_jspService method 안에는 try~catch 코드가 자동 생성되어있으므로 
	// scriptlet, expression에서는 compile Exception, Runtime Exception이 자동처리된다.
	Class cls=Class.forName(className[new Random().nextInt(className.length)]);
	%>
	클래스 로딩 성공<br/>
	로딩된 클래스 : <strong><%= cls %></strong>
	</c:catch>
	<c:if test="${e ne null }">
		클래스 로딩 실패!! : ${e}
	</c:if>
	
</body>
</html>