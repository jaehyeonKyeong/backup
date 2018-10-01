<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main.css">
<!-- CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> 
<script type="text/javascript">

</script>

</head>
<body>
	<strong>${sessionScope.name }</strong><br/>
	<ul>
	<c:forEach var="date" items="${sessionScope.date }">
		<li><c:out value="${date}" />
	</c:forEach>
	</ul><br/>
	<a href="../index.do">리스트</a>
	
</body>
</html>