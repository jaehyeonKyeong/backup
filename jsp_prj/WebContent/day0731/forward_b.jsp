<%@page import="day0731.ForwardVO"%>
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
	<jsp:include page="/common/jsp/main_menu.jsp"></jsp:include>

<div>

	<a href="forward_a.jsp?name=jongseong.shin&age=27">요청</a>
</div>
<div>
	<%
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String addr=request.getParameter("addr");
	if(name !=null){
		
	%>
	<ui>
		<li>이름 : <%=name %></li>
		<li>나이 : <%=age %></li>
		<li>주소 : <%=addr %></li>
	</ui>
	<%}//end if %>
	</div>
	<div>
	scope="request" <br/>
	<%
	//useBean의 id속성의 이름을 사용
	ForwardVO fv=(ForwardVO)request.getAttribute("fv1");
	%>
	이름 : <%=fv.getName() %><br/>
	나이 : <%=fv.getAge() %><br/>
	주소 : <%=fv.getAddr() %><br/>
	
	
	scope="session" <br/>
	<%
	//useBean의 id속성의 이름을 사용하여 객체를 얻는다.
	ForwardVO fv1=(ForwardVO)session.getAttribute("fv2");
	%>
	이름 : <%=fv1.getName() %><br/>
	나이 : <%=fv1.getAge() %><br/>
	주소 : <%=fv1.getAddr() %><br/>
	
	
	</div>
	





</body>
</html>