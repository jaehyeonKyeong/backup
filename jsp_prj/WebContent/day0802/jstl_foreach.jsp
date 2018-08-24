<%@page import="day0731.ForwardVO"%>
<%@page import="day0730.TestVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
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
	<c:forEach var="i" begin="1" end="10" step="1">
		${i }
	</c:forEach>
	<%
		Calendar cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		pageContext.setAttribute("nowYear", year);
		
	%>
	<select>
		<option>-----년-----</option>
		<c:forEach var="temp" begin="1950" end="${pageScope.nowYear }" step="1">
			<option><c:out value="${temp }"></c:out></option>
		</c:forEach>
	</select>
	<div>
		<%
			String[] names={"이종민","최주오","김동희","뚜딘","강소예","이상훈"};
			request.setAttribute("names", names);
		%>
		<c:forEach var="name" items="${requestScope.names}">
			<input type="checkbox" name="name" value="${name }" class="inputBox"/>
			<span style="vertical-align: top;">
			<c:out value="${name }"/><br/>
			</span>
		</c:forEach>
	</div>
	<%
		List<TestVO> list=new ArrayList<TestVO>();
		list.add(new TestVO("신종성","딴짓하며 훌륭한 개발자의 연구",27));
		list.add(new TestVO("송재원","혀에서 느끼는 미각에 대한 반응성연구",25));
		list.add(new TestVO("강소예","뚜딘의 외부자극에 대한 신호연구",25));
		list.add(new TestVO("김대현","견스타그램의 홍보전략에 대한 폐해 연구",27));
		
		request.setAttribute("list", list);
	%>
	<strong> * 흥미있는 논문 선택하기 * </strong><br/>
	<c:forEach items="${list }" var="tv">
		<input type="radio" name="thesis" value="${tv.name }">
		<c:out value="${tv.thesisSubject }"/>(<c:out value="${tv.age }"/>)<br/>
	</c:forEach><br/>
	<% 
		//day0731에 있는 forwardVO를 사용하여 값을 넣고 JSTL을 사용하여 테이블로 출력
		List<ForwardVO> list2=new ArrayList<ForwardVO>();
		list2.add(new ForwardVO("뚜딘","관악구",23));
		list2.add(new ForwardVO("디니","유니버셜뮤직",28));
		list2.add(new ForwardVO("휘니","RBW",24));
		list2.add(new ForwardVO("큥이","SM",27));
		request.setAttribute("list2", list2);
		
		int cnt=1;
	%>
		<strong>좋아요</strong><br/>
		<c:forEach items="${list2 }" var="tv2">
			<input type="checkbox" name="theBest" value="${tv2.name }">
			<c:out value="${tv2.name }"/>(<c:out value="${tv2.age }"/>)<%-- (<c:out value="${tv2.age }"/>) --%>
		</c:forEach>
	
	
		<table border="1" cellspacing="0">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>나이</th>
		</tr>
		<!-- 선언 : 같은 이름의 변수는 만들면 처음은 선언이 된다.  -->
		<c:set var="num" value="0"/>
		<c:forEach var="data" items="${list2 }">
		<!-- 재할당 : 아래 부분은 할당이 된다.  -->
		<c:set var="num" value="${num+1 }"/>
		<tr>
			<td><c:out value="${num}"/></td>
			<td><c:out value="${data.name }"/></td>		
			<td><c:out value="${data.addr }"/></td>		
			<td><c:out value="${data.age }"/></td>		
		</tr>
		</c:forEach>
		</table>
</body>
</html>