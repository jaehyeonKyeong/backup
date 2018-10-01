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

	session name : ${sessionScope.name}<br/> 
	request name : ${requestScope.name}<br/> 
	<c:forEach var="date" items="${date}">
		<input type="date" value="${date}"/><br/>
	</c:forEach>
	<a href="../index.do">메인</a>
	



</body>
</html>




