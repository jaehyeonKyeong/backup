<%@page import="kr.co.sist.dao.SelectExam2"%>
<%@page import="kr.co.sist.domain.JoinSubquery"%>
<%@page import="kr.co.sist.domain.Zipcode"%>
<%@page import="kr.co.sist.domain.Emp"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.domain.Dept"%>
<%@page import="kr.co.sist.dao.SelectExam1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<strong>join+subquery를 사용한 조회</strong>
	<div>
	<form action="use_select_mybatis.jsp">
		<input type="hidden" name="page" value="day0907/join_subquery"/>
		<label>제조사</label>
		<input type="text" name="maker" value="${param.maker }" onclick="this.value=''"/>
		<input type="submit" value="제조사 모델 조회"/>
	</form>
	<c:if test="${not empty param.maker }">
	<div style="margin-top: 20px">
 		<%
 			String maker=request.getParameter("maker");
 			SelectExam2 se2 = new SelectExam2();
 			List<JoinSubquery> carList = se2.joinSubquery(maker);
 			pageContext.setAttribute("carList", carList);
 		%>
	<table>
		<tr>
			<th style="width: 150px">이미지</th>
			<th style="width: 100px">제조국</th>
			<th style="width: 100px">제조사</th>
			<th style="width: 100px">모델명</th>
			<th style="width: 100px">년식</th>
			<th style="width: 100px">가격</th>
		</tr>
		<c:if test="${empty carList }">
		<tr>
			<td colspan="6" align="center">
				<strong>${param.maker }</strong>는 존재하지 않습니다.
			</td>
		</tr>
		</c:if>
		<c:forEach var="car" items="${carList }">
		<tr>
			<td><c:out value="${car.car_img }"/></td>
			<td><c:out value="${car.country }"/></td>
			<td><c:out value="${car.maker }"/></td>
			<td><c:out value="${car.model }"/></td>
			<td><c:out value="${car.car_year }"/></td>
			<td><c:out value="${car.price }"/></td>
		</tr>		
		</c:forEach>
	</table>
	</div>
	</c:if>
	</div>
</div>