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
<style type="text/css">
	table { border-spacing: 0px; }
	th,td{ border: 1px solid #333; font-weight: normal; }
	#numTitle{ width: 80px }
	#nameTitle{ width: 150px }
	#addrTitle{ width: 80px }
</style>
</head>
<body>
	<!-- HttpServletRequest에 속성으로 설정된 값 출력  -->
<div>
<table>
	<thead>
	<tr>
		<th colspan="3">오늘의 지각자(결석자) 명단!!!</th>
	</tr>
	<tr>
		<th id="numTitle">번호</th>
		<th id="nameTitle">이름</th>
		<th id="addrTitle">주소</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach var="lv" items="${late_list }">
		<c:set var="i" value="${i+1 }"/>
		<tr>
			<td><c:out value="${i }"/></td>
			<td><c:out value="${lv.name }"/></td>		
			<td><c:out value="${lv.addr }"/></td>		
		</tr>
		</c:forEach>
	</tbody>
</table>
<a href="../index.do">목록</a>

</div>
</body>
</html>