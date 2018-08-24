<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>
	요청방식<%=request.getMethod() %>
	<% request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String gender=request.getParameter("gender");
		String addr=request.getParameter("addr");
		String mail=request.getParameter("mail");
		String remember=request.getParameter("remember");
		String group=request.getParameter("group");
		String intro=request.getParameter("intro");
		
		String[] hobby=request.getParameterValues("hobby");
		%>
	이름 : <%=name %>
	
</body>
</html>