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
	<%String subject="JSP(Java Server Page)";int score=98; 
		 /* public String getName(){
			return "꿀형";
		} //scriptlet은 메소드를 만들수 없다(메소드의 중첩정의 불가능) */
	%>
	<strong><%=subject %>을 <%=score %>점 획득하였습니다.</strong>
	<%-- <%= subject,score %>:error:값은 하나만 출력가능 --%>
	
	
</body>
</html>