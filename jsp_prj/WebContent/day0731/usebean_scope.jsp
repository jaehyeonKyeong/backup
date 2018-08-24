<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main.css">
<!-- CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<!-- page : 요청할 때마다 bean(VO)이 생성되며 이 페이지에서만 사용된다  -->
<!-- request : 요청할 때마다 bean(VO)이 생성되며 forward로 이동한 페이지에서 사용된다  -->
<!-- session : 접속자별 페이지를 요청할 때 한번 bean(VO)이 생성되며 이동한 모든 페이지에서 사용된다  -->
<!-- application : 최초 접속자가 요청할 때 한번 bean(VO)이 생성되며 모든 접속자가 생성된 bean을 사용한다
				      이동한 모든 페이지에서 사용된다  -->
	<!-- useBean의 class는 import를 받지 않는다 -->
	<jsp:useBean id="cv" class="day0731.CounterVO" scope="application"/>
	<jsp:setProperty property="count" name="cv" value="1"/>
	당신은 이 페이지에 [<span><jsp:getProperty property="count" name="cv"/></span>]번째 방문자입니다.
	<br/>
	<%
	int cnt=cv.getCount();
	String count=String.valueOf(cnt);
	for(int i=0; i<count.length(); i++){
	%>
	<img src="images/num_<%=count.charAt(i) %>.png" title="<%=count%>"/>
	<%	
	}//end for
	%>
	
</body>
</html>





