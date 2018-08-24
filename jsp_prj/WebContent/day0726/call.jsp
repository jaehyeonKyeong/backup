<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="html에서 jsp를 요청 연습!"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"href="http://211.63.89.140:8080/jsp_prj/common/css/main.css">
<!-- CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
</script>
<style type="text/css">
#get{font-size:20px;color:#FF0000;font-weight:bold}
#post{font-size:25px;color:#0000FF;font-weight:bold}
</style>
</head>
<body>
<%String method=request.getMethod(); %>
	<div id="<%="GET".equals(method.toUpperCase())?"get":"post"%>">
	<%=method %>방식으로 요청하셨어요!
	</div>
	<a href="javascript:history.back()">뒤로</a>
</body>
</html>