<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="처리된 데이터를 가지고 화면을 만드는 일(view)"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"href="http://localhost:8080/mvc_lecture_prj/common/css/main.css">
<!-- CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
<!-- Model2에서 JSP는 Controller가 보내오는 데이터를 보여주는 일을 하게 되는데, 
JSP가 직접호출 되면 처리된 데이터가 없으므로 JSP를 직접호출하게 되는 일을 막아야한다. DD사용(web.xml)-->
	<img src="common/images/mvc.jpg"/>
	<ul>
		<li><a href="a.do">a.do요청</a></li>
		<li><a href="b.do">b.do요청</a></li>
		<li><a href="c.do">c.do요청</a></li>
		<li><a href="yana.do">yana.do요청</a></li>
		<li><a href="main_controller.do">main_controller.do요청</a></li>
	</ul>
	<div>
		요청방식 : <strong>${method }</strong>
	</div>
	<form action=test.do method=get>
		<input type="submit" value=get방식요청 class=btn>
	</form>
	<form action=test.do method=post>
		<input type="submit" value=post방식요청 class=btn>
	</form>
</body>
</html>