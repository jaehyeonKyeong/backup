<%@page import="kr.co.sist.util.HashAlgorithm"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
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

<%=HashAlgorithm.changeMD5("123") %>
<%
	Date date=new Date();
	int i=1991;
	double d=1111.111;
	
	pageContext.setAttribute("date", date);
	pageContext.setAttribute("i", i);
	pageContext.setAttribute("d", d);

%>
EL사용 : <fmt:formatDate value="${date}" 
pattern="yyyy-MM-dd a hh(HH,kk):mm:ss" /><br/>

표현식 사용 : <fmt:formatDate value="<%= date %>" 
pattern="yyyy-MM-dd a hh(HH,kk):mm:ss" /><br/>

정수 0 패턴 사용 : <fmt:formatNumber value="${i}" pattern="0,000,000" /><br/>
정수 # 패텬 사용 : <fmt:formatNumber value="${i}" pattern="#,###,###" /><br/>
실수 0 패턴 사용 : <fmt:formatNumber value="${d}" pattern="0,000,000.00" /><br/>
실수 # 패텬 사용 : <fmt:formatNumber value="${d}" pattern="#,###,###.##" /><br/>


</body>
</html>