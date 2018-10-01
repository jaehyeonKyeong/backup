<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div>외부 JSP</div>
	<div>
		처리된 데이터의 공통디자인<br/>
		<jsp:include page="/day0920/name_data.do"/>
	</div><br/>
	
	<a href="../index.do">리스트</a>
</div>


</body>
</html>