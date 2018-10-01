<%@page import="kr.co.sist.domain.DeptEmpJoin"%>
<%@page import="kr.co.sist.domain.Emp"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.dao.SelectExam2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
<form action="use_select_mybatis.jsp" method="get">
	<input type="hidden" name="page" value="day0907/join">
	<label>매니저 선택</label>
	<%
		SelectExam2 se2 = new SelectExam2();
		List<Integer> mgrList = se2.selectAllMgr();
		pageContext.setAttribute("mgrList", mgrList);
	%>
	<select name="mgr" id="mgr">
		<option value="0">-----매니저선택------</option>
		<c:forEach var="mgr" items="${mgrList }">
		<option value="${mgr }"${param.mgr eq mgr ?" selected='selected'":"" }><c:out value="${mgr }" /></option>
		</c:forEach>
	</select>
	<input type="submit" value="조회" id="search"/>
</form>
<c:if test="${ not empty param.mgr and param.mgr ne '0'}">
<%
	String mgr = request.getParameter("mgr");
	List<DeptEmpJoin> empList = se2.join(new Integer(mgr) );
	pageContext.setAttribute("empList", empList);	
%>
	<strong>${param.mgr }매니저가 관리하는 사원</strong>
	<div style="margin-top:10px">
		<table>
			<tr>
				<th style="width: 80px">번호</th>
				<th style="width: 100px">사원번호</th>
				<th style="width: 120px">사원명</th>
				<th style="width: 100px">연봉</th>
				<th style="width: 100px">직무</th>
				<th style="width: 150px">입사일</th>
				<th style="width: 80px">부서번호</th>
				<th style="width: 150px">부서명</th>
				<th style="width: 150px">위치</th>
			</tr>
			<c:forEach var="emp" items="${ empList }">
			<c:set var="i" value="${i+1 }"/>
			 <tr>
			 	<td>${i }</td>
			 	<td>${emp.empno }</td>
			 	<td>${emp.ename }</td>
			 	<td>${emp.sal }</td>
			 	<td>${emp.job }</td>
			 	<td>${emp.hiredate }</td>
			 	<td>${emp.deptno }</td>
			 	<td>${emp.dname }</td>
			 	<td>${emp.loc }</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</c:if>
</div>