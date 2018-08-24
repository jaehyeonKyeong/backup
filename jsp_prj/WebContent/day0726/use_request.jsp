<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://211.63.89.140:8080/jsp_prj/common/css/main.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("li:even").css("backgruond-color","#d4d3d4");
	});

</script>

</head>
<body>

	<div>
	<ul>
		<li> <strong>리퀘스트 내장객체 사용</strong></li>
		<li> 요청 URL : <%=request.getRequestURI() %></li>
		<li> 요청 프로토콜 : <%=request.getProtocol() %></li>
		<li> 요청 방식 : <%=request.getMethod() %></li>
		<li> 요청 서버명 : <%=request.getServerName() %></li>
		<li> 요청 서버포트 : <%=request.getServerPort() %></li>
		<li> 요청 URI : <%=request.getRequestURI() %></li>
		<li> 요청 servletPath : <%=request.getServletPath() %></li>
		<li> 접속자 IP : <%=request.getRemoteAddr() %></li>
		<li> 접속자 PORT : <%=request.getRemotePort() %></li>
		<li> QueryString : <%=request.getQueryString() %></li>
		<li> Parameter : <%=request.getParameter("name") %>,
							<%=request.getParameter("age") %>,
							<%=request.getParameter("addr") %></li>
		<li> ParameterValues : <% 
								String[] age=request.getParameterValues("age");
								if(age!=null){
									for(int i=0; i<age.length; i++){
										out.println(age[i]);
									}//end for
								}//end if  %>	</li>
		<li> ParameterNames : <% 
								Enumeration<String> en=request.getParameterNames();
								while(en.hasMoreElements()){
									
										out.print(en.nextElement());
										out.print(" ");
									
								}//while
								%>	</li>
							
	</ul>
	<div>
	<a href="use_request.jsp?name=hoonida&age=29&age=28&addr=rhkdwn">요청</a>
	</div>


	</div>


</body>
</html>