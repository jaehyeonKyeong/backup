<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//이동한 페이지에서 사용할 값을 scope객체에 설정합니다.
	request.setAttribute("name", "송재원");
	session.setAttribute("lunch", "46cm 제주 치즈 피자 - 빅셋트");
	//application.setAttribute("강사님", "질문");
	
%>
<jsp:forward page="el_forward_session_value.jsp"></jsp:forward>
<!-- Web Applicatino에서 외부 jar파일(외부 Library)을 사용할때에는 
      Web-INF\lib 폴더에 복사하여 사용한다. 아주 중요 중요하다
       classpath를 빌드패스를 잡지않고노 쓸수있는 방법이다. -->

