<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"href="http://localhost:8080/spring_orm/common/css/main.css">
<!-- CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
</script>
<style type="text/css">
	table{border:1px solid #333; border-spacing: 0px}
	th,td{border-bottom: 1px solid #333}
	#numTitle{width:80px;}
	#enumTitle{width:120}
	#enameTitle{width:180px}
	#salTitle{width:100px}
	#hiredateTitle{width:150px}

</style>
</head>
<body>
	<table>
		<tr>
			<th id="numTitle">번호</th>
			<th id="enumTitle">사원번호</th>
			<th id="enameTitle">사원명</th>
			<th id="salTitle">연봉</th>
			<th id="hiredateTitle">입사일</th>
		</tr>
		<c:forEach var="emp" items="${emp_list }">
			<c:set var="i" value="${i+1 }"/>
			<tr>
				<td><c:out value="${i }"/></td>
				<td><c:out value="${emp.empno }"/></td>
				<td><c:out value="${emp.ename }"/></td>
				<td><c:out value="${emp.sal}"/></td>
				<td><c:out value="${emp.hiredate}"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>