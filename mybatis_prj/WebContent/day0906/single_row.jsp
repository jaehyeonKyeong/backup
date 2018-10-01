<%@page import="java.util.List"%>
<%@page import="kr.co.sist.domain.Dept"%>
<%@page import="kr.co.sist.dao.SelectExam1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<strong>컬럼 하나에 여러행 조회</strong>
	<div>
		<%
			SelectExam1 se1 = new SelectExam1();
			List<String> empList = se1.singleRow();
			pageContext.setAttribute("empList", empList);
		%>
		<ul>
		<c:forEach var="ename" items="${empList }">
		<c:set var="cnt" value="${ cnt + 1 }"/>
		<li><c:out value="${ename }"/>
			<c:if test="${ cnt eq 1 }">
				<img src="common/images/new.png" style="margin-left: -5px"/>
			</c:if>
		</li>		
		</c:forEach>
		</ul>
	</div>
</div>