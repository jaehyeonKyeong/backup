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
$(function(){
	$("#subject").change(function(){
	if($("#subject").val()!="none"){
		var data=$("#output").text();
		data+=" "+$("#subject").val();
		$("#output").text(data);
	}
	});
})//ready
</script>
</head>
<body>
<c:set var="names" value="송재원,강소예,경제현,이동근"/>
<ul>
<c:forTokens items="${names}" delims="," var="name">
	<li><c:out value="${name }"/></li>
</c:forTokens>
</ul>
<%
		String subjectData="Java SE,Oracle,JDBC,HTML,CSS,JavaScript,jQuery,Java EE(Servlet/JSP)";
		pageContext.setAttribute("data", subjectData);
%>
	<div>
	<select id="subject">
		<option value="none">과목선택</option>
	<c:forTokens var="subject" items="${data }" delims=",">
		<option value="${subject }"><c:out value="${subject }"/></option>
	</c:forTokens>
	</select>
		<div id="output">
		</div>
	</div>
</body>
</html>