<%@page import="kr.co.sist.domain.Emp"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.dao.SelectExam2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
<form action="use_select_mybatis.jsp" method="get">
	<input type="hidden" name="page" value="day0907/dynamic_tab">
	<label>조회할 테이블 선택</label>
	<input type="radio" name="tab" value="emp"${param.tab eq 'emp'?" checked='checked'":"" }>EMP |
	<input type="radio" name="tab" value="cp_emp"${param.tab eq 'cp_emp'?" checked='checked'":"" }>CP_EMP <br/>
	<input type="submit" value="조회"/>
</form>
<c:if test="${ not empty param.tab }">
<%
	String tab = request.getParameter("tab");
	SelectExam2 se2 = new SelectExam2();
	List<Emp> empList = se2.dynamicTab(tab);
	pageContext.setAttribute("empList", empList);	
%>
	<strong>${ param.tab }테이블 조회</strong>
	<div>
		<table>
			<tr>
				<th style="width: 80px">번호</th>
				<th style="width: 100px">사원번호</th>
				<th style="width: 120px">사원명</th>
				<th style="width: 100px">연봉</th>
				<th style="width: 150px">입사일</th>
			</tr>
			<c:forEach var="emp" items="${ empList }">
			<c:set var="i" value="${i+1 }"/>
			 <tr>
			 	<td>${i }</td>
			 	<td>${emp.empno }</td>
			 	<td>${emp.ename }</td>
			 	<td>${emp.sal }</td>
			 	<td>${emp.hiredate }</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</c:if>
</div>