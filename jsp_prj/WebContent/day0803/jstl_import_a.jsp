<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main.css">
<!--  CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<div>
		외부 JSP
		<div>
			<c:import url="jstl_import_b.jsp"/>
		</div>
		외부 JSP
		<br/>
		<!-- scope 객체에 저장된 값은 변수를 직접 사용하는 것이 아니므로 사용가능하다.  -->
		${name }, 무얼까요 what? => 주석입니당 <%-- 변수를 직접 사용할수 없다. <%=name %> --%>
	</div>
</body>
</html>