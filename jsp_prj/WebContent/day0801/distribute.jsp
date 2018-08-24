<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="요청 URL에 따른 페이지 분배"%>
    
<%

	request.setCharacterEncoding("UTF-8");
	String serverName=request.getServerName();
	String url="eng.jsp";
	String lang = "english";

	if(("localhost").equals(serverName)||serverName.endsWith("co.kr")){
		url="kor.jsp";
		lang="한국어";
	}	
%>

<jsp:forward page="<%=url %>">
	<jsp:param value="<%=lang%>" name="lang"/>
</jsp:forward>
