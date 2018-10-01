<%@page import="kr.co.sist.domain.Zipcode"%>
<%@page import="kr.co.sist.domain.Emp"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.domain.Dept"%>
<%@page import="kr.co.sist.dao.SelectExam1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<strong>like 조회</strong>
	<div>
	<form action="use_select_mybatis.jsp">
		<input type="hidden" name="page" value="day0906/like"/>
		<label>동 이름</label>
		<input type="text" name="dong" value="${param.dong }" onclick="this.value=''"/>
		<input type="submit" value="우편번호조회"/>
	</form>
	<c:if test="${not empty param.dong }">
	<div style="margin-top: 20px">
 		<%
 			String dong=request.getParameter("dong");
 			SelectExam1 se1 = new SelectExam1();
 			List<Zipcode> dongList = se1.like(dong);
 			pageContext.setAttribute("dongList", dongList);
 		%>
	<table>
		<tr>
			<th style="width: 100px">우편번호</th>
			<th style="width: 400px">주소</th>
		</tr>
		<c:if test="${empty dongList }">
		<tr>
			<td colspan="2" align="center">
				<strong>${param.dong }</strong>은 존재하지 않습니다.
			</td>
		</tr>
		</c:if>
		<c:forEach var="dong" items="${dongList }">
		<tr>
			<td><c:out value="${dong.zipcode }"/></td>
			<td>
			<c:out value="${dong.sido}"/>
			<c:out value="${dong.gugun}"/>
			<c:out value="${dong.dong}"/>
			<c:out value="${dong.bunji}"/>
			</td>
		</tr>		
		</c:forEach>
	</table>
	</div>
	</c:if>
	</div>
</div>