<%@page import="kr.co.sist.domain.Emp"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.domain.Dept"%>
<%@page import="kr.co.sist.dao.SelectExam1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<strong>작다의 비교 조회</strong>
	<div>
	<form action="use_select_mybatis.jsp">
		<input type="hidden" name="page" value="day0906/lessthan"/>
		<label>연봉</label>
		<input type="text" name="sal" value="${param.sal }" onclick="this.value=''"/>
		<input type="submit" value="사원조회"/>
	</form>
	<c:if test="${not empty param.sal }">
	<div style="margin-top: 20px">
 		<%
 			String sal=request.getParameter("sal");
 			SelectExam1 se1 = new SelectExam1();
 			List<Emp> empList = se1.lessThan(Integer.parseInt(sal));
 			pageContext.setAttribute("empList", empList);
 		%>
	<table>
		<tr>
			<th style="width: 100px">사원번호</th>
			<th style="width: 150px">사원명</th>
			<th style="width: 100px">연봉</th>
			<th style="width: 200px">입사일</th>
		</tr>
		<c:if test="${empty empList }">
		<tr>
			<td colspan="4" align="center">
				<strong>${param.sal }</strong>보다 적은 연봉을 수령하는 사원은 존재하지 않습니다.
			</td>
		</tr>
		</c:if>
		<c:forEach var="emp" items="${empList }">
		<tr>
			<td><c:out value="${emp.empno}"/></td>
			<td><c:out value="${emp.ename}"/></td>
			<td><c:out value="${emp.sal}"/></td>
			<td><c:out value="${emp.hiredate}"/></td>
		</tr>		
		</c:forEach>
	</table>
	</div>
	</c:if>
	</div>
</div>