<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="http://211.63.89.140:8080/jsp_prj/common/css/main.css">
<!-- CDN -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#name").change(function() {
		if($("#name").val()!="none"){
			if(confirm($("#name").val()+"님의 특징을 보시겠습니까?")){
				$("#frm").submit();
			} 
		}
	});
});
</script>
</head>
<body>
	<%
		//처리된 데이터 받기
		String[] names = (String[]) request.getAttribute("names");
		String data = (String) request.getAttribute("data");
	%>
	<div>
		<form action="forward_a.jsp" method="get" id="frm">
			<select name="name" id="name" style="height:25px">
				<option value="none">-------이름선택-------</option>
				<%for (String name : names) {%>
				<option value="<%=name%>"<%=name.equals(request.getParameter("name"))?" selected='selected'":""%>><%=name%></option>
				<%}%>
			</select>
		</form>
		<div>
			<strong>특징</strong>
			<%if (data != null&&!"".equals(data)) {%>
			<marquee><%=data%></marquee>
			<%}%>
		</div>
	</div>
</body>
</html>