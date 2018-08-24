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
<%
	//값삭제 : 세션은 유지되나 값만 삭제
	session.removeAttribute("usr_id");
	session.removeAttribute("usr_name");
	
	//할당받은 세션을 무효화(재접속시 다시 얻어진다.)
	session.invalidate();
%>
location.replace("use_session_a.html");



</script>

</head>
<body>



</body>
</html>