<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="외부페이지"%>
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
외부 JSP<Br/>
<img src="../common/images/add.png" />

<div>
	<jsp:include page="include_b.jsp" />
	<jsp:include page="sub/include_c.jsp" />
</div>
외부 JSP
<%
//include directive와 다르게 변수나 method의 공유가 되지 않는다.
//out.println(name);
%>
</div>


</body>
</html>