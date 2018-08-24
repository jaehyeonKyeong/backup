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
	<%
	//scriptlet:스크립틀릿 - method내 자바코드를 작성할 때
	int i=0;//지역변수 : method내부에서만 사용가능한 변수 method외부에선 사용할 수 없다
	int re=i+7;
	//클래스 생성 가능
	String msg=new String("자바를 했다.");
	if (i==0){ //제어구조
		i=24;
	}
	%>
	i : <%= i %><br>
	re : <%= re %><br>
	msg : <%= msg %><br>
	<% 
	//scriptlet은 필요한 만큼 열수 있다.
	//scriptlet은 jsp가 java로 qusrudehlfEo _jspService method안에
	//scriptlet에 대한 모드 코다 생성되므로 위에 존재하는 scriptlet의 변수를 아래 존재하는 scriptlet에서 사용할 수 있다.
	i=100;
	%>
</body>
</html>