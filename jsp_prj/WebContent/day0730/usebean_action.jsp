<%@page import="day0730.TestVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="useBean 사용"
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main.css">
<!-- CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> 
<script type="text/javascript">

</script>

</head>
<body>
<%
	//scriptlet안에서 자바코드로 객체화
	TestVO tv=new TestVO("후니다2","짬타이거의 생활환경과 그들의 복지에 대한 연구",28);
%>
	<!-- scriptlet밖에서 액션태그로 객체화 : 기본생성자가 존재하지 않으면 Error -->
	<jsp:useBean id="tv1" class="day0730.TestVO" scope="page" />

	<!-- setter를 호출하여 값 넣기 
		property는 처음 단어는 모두 소문자로 그 뒤는 대소문자를 가려서 작성한다.
	-->
	<jsp:setProperty property="name" name="tv1" value="송재원" />
	<jsp:setProperty property="thesisSubject" name="tv1" 
		value="고비용의 엥겔계수와 점심의 만족도에 대한 연구-샛바닥중심으로" />
	<jsp:setProperty property="age" name="tv1" value="25" />
	<!-- getter를 호출하여 값 출력 -->
	<div>
	<ul>
		<li>tv객체 :</li>
		<li>이름 :<%= tv.getName() %></li>
		<li>논문제목 :<%= tv.getThesisSubject() %></li>
		<li>나이 :<%= tv.getAge() %></li>
	</ul> 
	<ul>
		<li>tv1객체 :</li>
		<li>이름 :<jsp:getProperty property="name" name="tv1"/></li>
		<li>논문제목 :<jsp:getProperty property="thesisSubject" name="tv1"/></li>
		<li>나이 :<jsp:getProperty property="age" name="tv1"/></li>
	</ul> 
	
	<%
	//<jsp:useBean의 id속성은 객체이므로 자바코드에서 사용할 수 있다.
	tv1.setAge(26);
	tv1.setThesisSubject("고비용 엥겔계수와 허리띠 증가에 대한 연구");
	%>
	<ul>
		<li>tv1객체의 setter사용</li>
		<li>이름 : <%= tv1.getName() %></li>
		<li>논문 : <%= tv1.getThesisSubject() %></li>
		<li>나이 : <%= tv1.getAge() %></li>
	</ul>
	
	<!-- 자바코드로 생성한 객체를 액션태그로 처리/사용할 수 없다.-->

	</ul>
	</div>



 
</body>
</html>