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
<div>
	<img src="../day0919/images/img.jpg" width="250" />
	<br/>
	죄송합니다. 잠시 문제가 발생하였습니다.<br/>
	간단한 메세지 : <c:out value="${msg1}" /><br/>
	예외처리 객체와 간단한 메세지 : <c:out value="${msg2}" /><br/>
	예외처리 객체 : <c:out value="${obj}" /><br/>
	
	
	
	
</div>

</body>
</html>