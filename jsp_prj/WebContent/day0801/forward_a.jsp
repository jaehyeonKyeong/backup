<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main.css">
<!--CDN-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> 
<script type="text/javascript">

</script>

</head>
<body>
<%
	String serverName=request.getServerName();
	String nameLbl = "name", ageLbl="age", addrLbl="addr";
	String submitBtn = "submit", resetBtn="reset";
	
	if("localhost".equals(serverName) || serverName.endsWith("co.kr")){
		nameLbl = "이름";
		ageLbl="나이";
		addrLbl="주소";
		submitBtn="전송";
		resetBtn="취소";
	}//end if
%>
	<form action="distribute.jsp" method="post">
	<label><%=nameLbl %></label>
		<input type="text" name="name" class="inputBox"/><br/>
	<label><%=ageLbl %></label>
		<input type="text" name="age" class="inputBox"/><br/>
	<label><%=addrLbl %></label>
		<input type="text" name="addr" class="inputBox"/><br/>
		<input type="submit" value="전송" class="btn"/>
		<input type="reset" value="초기화" class="btn"/><br/>
	</form>
	<a href="http://localhost:8080/jsp_prj/day0801/forward_a.jsp">
		로컬 테스트</a>
	<a href="http://localhost:8080/jsp_prj/day0801/forward_a.jsp">
		원격 테스트</a>
</body>
</html>