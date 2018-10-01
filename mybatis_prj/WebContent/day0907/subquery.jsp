<%@page import="kr.co.sist.domain.CarModel"%>
<%@page import="kr.co.sist.domain.Emp"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.dao.SelectExam2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
<%
	SelectExam2 se2 = new SelectExam2();
	List<CarModel> carList = se2.subquery(11, 20);
	pageContext.setAttribute("carList", carList);	
%>
	<strong>차량 테이블 조회</strong>
	<div>
		<table>
			<tr>
				<th style="width: 80px">번호</th>
				<th style="width: 150px">모델명</th>
				<th style="width: 100px">연식</th>
				<th style="width: 120px">배기량</th>
				<th style="width: 100px">가격</th>
				<th style="width: 150px">이미지</th>
			</tr>
			<c:forEach var="car" items="${ carList }">
			<c:set var="i" value="${i+1 }"/>
			 <tr>
			 	<td>${i }</td>
			 	<td>${car.model }</td>
			 	<td>${car.year }</td>
			 	<td>${car.price }</td>
			 	<td>${car.cc }</td>
			 	<td class="img"><a href="#">${car.img }</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<div>
		<img src="common/images/get.png" width="200px" id="carImg"/>
	</div>
</div>