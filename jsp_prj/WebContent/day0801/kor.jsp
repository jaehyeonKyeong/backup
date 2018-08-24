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
	안녕하세요? 한국어로 서비스되는 페이지입니다.<br/>
	입력 데이터는 아래와 같습니다.<br/>
	<%
		request.setCharacterEncoding("UTF-8");
		//HTML Form Contrl에 입력된 값
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String addr=request.getParameter("addr");
		//<jsp:param으로 설정된 값
		String lang=request.getParameter("lang");
	%>
	
	<ul>
		<li>이름 : <%=name %></li>
		<li>나이 : <%=age %></li>
		<li>주소 : <%=addr %></li>
		<li>사용언어 : <%=lang %></li>
	</ul>
	<a href="forward_a.jsp">다시입력</a>
</body>
</html>