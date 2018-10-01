<%@page import="kr.co.sist.domain.DynamicIf"%>
<%@page import="kr.co.sist.dao.SelectExam3"%>
<%@page import="kr.co.sist.domain.Emp"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.dao.SelectExam2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
<form action="use_select_mybatis.jsp" method="get">
	<input type="hidden" name="page" value="day0911/dynamic_choose">
	<label>조회할 부서 선택(choose)</label>
	<input type="text" name="deptno" value="${param.deptno}">
	<input type="submit" value="조회"/>
</form>
<c:if test="${ not empty param.deptno }">
<%
	String deptno = request.getParameter("deptno");
	SelectExam3 se3 = new SelectExam3();
	List<DynamicIf> empList = se3.dynamicChoose(Integer.parseInt(deptno));
	pageContext.setAttribute("empList", empList);	
%>
	<strong>${ param.deptno }테이블 조회(choose)</strong>
	<div>
		<table>
			<tr>
				<th style="width: 80px">번호</th>
				<th style="width: 100px">사원번호</th>
				<th style="width: 120px">사원명</th>
				<th style="width: 100px">연봉</th>
				<th style="width: 150px">입사일</th>
				<th style="width: 150px">부서번호/세부번호</th>
			</tr>
			<c:forEach var="emp" items="${ empList }">
			<c:set var="i" value="${i+1 }"/>
			 <tr>
			 	<td>${i }</td>
			 	<td>${emp.empno }</td>
			 	<td>${emp.ename }</td>
			 	<td>${emp.sal }</td>
			 	<td>${emp.hiredate }</td>
			 	<td>${emp.deptno }</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</c:if>
</div>