<%@page import="kr.co.sist.domain.Emp"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.dao.SelectExam2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
<%
	SelectExam2 se2 = new SelectExam2();
	List<Emp> empList = se2.union();
	pageContext.setAttribute("empList", empList);	
%>
	<strong>사원 조회</strong>
	<div>
		<table>
			<tr>
				<th style="width: 80px">번호</th>
				<th style="width: 150px">사원번호</th>
				<th style="width: 100px">사원명</th>
				<th style="width: 120px">연봉</th>
				<th style="width: 100px">입사일</th>
			</tr>
			<c:forEach var="emp" items="${ empList }">
			<c:set var="i" value="${i+1 }"/>
			 <tr>
			 	<td>${i }</td>
			 	<td>${emp.ename }</td>
			 	<td>${emp.empno }</td>
			 	<td>${emp.sal }</td>
			 	<td class="hiredate">${emp.hiredate }</td>
			</tr>
			</c:forEach>
		</table>
		<div>
			<input type="date" id="date"/>
		</div>
	</div>
</div>