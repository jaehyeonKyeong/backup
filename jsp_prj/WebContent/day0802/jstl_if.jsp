<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main.css">
<!--CDN-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> 
<script type="text/javascript">

</script>

</head>
<body>
	<div>
		<a href="jstl_if.jsp?name=ddudin&age=23">클릭</a>
		<a href="jstl_if.jsp?name=hoonida&age=28">클릭</a>
	<div>
	<c:if test="${empty param.name}">
			위의 클릭을 눌러주세요
		</c:if>
	
		<c:if test="${param.name eq 'ddudin'}">
			<img src="../diary/images/today.png"/>
		</c:if>
	<c:if test="${not empty param.name}">
		이름 : <strong>${param.name}</strong>
		나이 : <strong>${param.age}</strong>
	</c:if>
		
	</div>
	</div>
	
	
</body>
</html>