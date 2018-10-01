<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/spring_mvc_template/common/css/main.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#get").click(function() {
		document.frm.method="GET";
		$("#frm").submit();
	});//click
	$("#post").click(function() {
		document.frm.method="POST";
		$("#frm").submit();
	});//click
});//ready
</script>
</head>
<body>
	<div>
	<strong>method parameter를 사용한 파라메터 처리 폼</strong>
	<br/>
	<form action="use_param_process.do" method="get" name="frm" id="frm">
		<label>이름</label>
		<input type="text" name="name" class="inputBox"/><br/>
		<label>나이</label>
		<input type="text" name="age" class="inputBox"/><br/>
		<label>수강과목</label>
		<input type="checkbox" name="subject" value="자바"/>자바
		<input type="checkbox" name="subject" value="오라클"/>오라클
		<input type="checkbox" name="subject" value="HTML"/>HTML
		<br/>
		<input type="checkbox" name="subject" value="JavaScript"/>JavaScript
		<input type="checkbox" name="subject" value="CSS"/>CSS
		<input type="checkbox" name="subject" value="jQuery"/>jQuery
		<br/>
		<input type="button" value="GET전송" id="get" class="btn"/>
		<input type="button" value="POST전송" id="post" class="btn"/>
	</form>
	</div>
</body>
</html>
