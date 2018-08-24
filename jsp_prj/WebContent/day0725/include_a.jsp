<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="인크루드 연습" %>
	<!-- include를 사용하면 페이지 지시자의 속성에 대한 충돌이 발생할 수 있다 . 한쪽 JSP에만 속성이 존재하거나 양쪽 모두 같은 속성을 가지면 error가 발생하지 않지만
	같은 속성이 다른 값을 가지면 error가 발생한다.
	 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="http://211.63.89.140:8080/jsp_prj/common/css/main.css">
<!-- CDN -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<div>
	<%String msg="아 오늘은 더운 수요일"; %>
		include_a의 영역
		<div>
			<%@ include file="include_b.jsp"%>
		</div>
		include_a의 영역<br>
		수량 : <strong><%=cnt %></strong><br>
		가격 : <strong><%=price %></strong><br>
		구매자 : <strong><%=getName()%></strong><br>
		특징 : USB포트가 뽑힐뻔했습니다.ㅎㄷㄷ<br>
	</div>
</body>
</html>