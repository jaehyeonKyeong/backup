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
		<select>
			<option>--과목--</option>
			<c:forEach var="subject" items="${subject }">
			<option value="${subject }"><c:out value="${subject }"/></option>
			</c:forEach>
		</select>
		<select>
			<option>--이름--</option>
			<c:forEach var="names" items="${names }">
			<option value="${names }"><c:out value="${names }"/></option>
			</c:forEach>
		</select>
		<select>
			<option>--점수--</option>
			<c:forEach var="i" begin="0" end="100" step="1">
			<option value="${i }"><c:out value="${i }"/></option>
			</c:forEach>
		</select>
	</div>
	<a href="../index.do">메인</a>
	
</body>
</html>