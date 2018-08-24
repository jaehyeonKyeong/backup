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
<!-- 변수선언 -->
<c:set var="name" value="최주오"/>
<c:set var="age" value="26"/>

<!-- 출력 : 속성값으로 출력할 때에는 EL만 사용한다. 사용자가 보이는 쪽(WEB BROWSER)으로 출력해야할때 C:OUT을 사용한다. -->
이름 : <c:out value="${name}"/><br>
나이 : <c:out value="${age}"/><br>
<a href="jstl_variable.jsp?name=${name }&age=${age}">클릭</a><br>
파라메터 : <!-- 위의 클릭 링크가 클릭되면 이름과 나이를 브라우저로 출력 -->
${param.name},${param.age}<br>
<!-- 변수의 제거 : 제거된 변수는 출력하면 아무것도 출력되지 않는다. -->
<c:remove var="name"/>
<c:remove var="age"/>
삭제 후 이름 : <c:out value="${name }"/>, 나이 : <c:out value="${age }"/>
<%-- ${name} --%>

</body>
</html>