<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"href="http://localhost:8080/jsp_prj/common/css/main.css">
<!-- CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<% String[] imgArr={"add.png","daum.png","sist_logo.jsp","img.png"};
	pageContext.setAttribute("img", imgArr);
	%>
	<!-- 배열에 있는 이미지를 forEach를 사용하여 이미지를 보여주고 아래에 이미지 만큼의 버튼을 만들어서 버튼을 클릭 할때마드아 위에 있는 이미지를 숨겼다가 보여주는 jQuer를 만들기 -->
	<c:forEach var="name" items="${requestScope.imgArr}">
		<%-- <img src="${requestScope.img }"/> --%>
			<input type="button" name="img" value="넹" class="inputBox"/>
			<span style="vertical-align: top;">
			</span>
		</c:forEach>
</body>
</html>