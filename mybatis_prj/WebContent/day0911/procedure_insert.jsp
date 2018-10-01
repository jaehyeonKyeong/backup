<%@page import="kr.co.sist.vo.EmpInsertVO"%>
<%@page import="kr.co.sist.vo.DynamicSetVO"%>
<%@page import="kr.co.sist.dao.SelectExam3"%>
<%@page import="kr.co.sist.domain.Emp"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.domain.Dept"%>
<%@page import="kr.co.sist.dao.SelectExam1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<strong>사원 정보 추가</strong>
	<div>
	<form action="use_select_mybatis.jsp">
		<input type="hidden" name="page" value="day0911/procedure_insert" />
		<label>사원번호</label>
		<input type="text" name="empno" value="${ param.empno }" onclick="this.value=''"/><br/>
		<label>사원명</label>
		<input type="text" name="ename" value="${ param.ename }" onclick="this.value=''"/><br/>
		<label>연봉</label>
		<input type="text" name="sal" value="${ param.sal }" onclick="this.value=''"/><br/>
		<label>보너스</label>
		<input type="text" name="comm" value="${ param.comm }" onclick="this.value=''"/><br/>
		<input type="submit" value="사원정보추가"/>
	</form>
	<c:if test="${ not empty param.empno }">
		<div style="margin-top: 20px">
	<%
		String empno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		String sal = request.getParameter("sal");
		String comm = request.getParameter("comm");
		
		SelectExam3 se3 = new SelectExam3();
		EmpInsertVO eiv=new EmpInsertVO(ename,"",Integer.parseInt(empno),Integer.parseInt("".equals(sal)?"0":sal),
				Integer.parseInt("".equals(comm)?"0":comm));
		String msg = se3.insertProc(eiv);
		pageContext.setAttribute("msg", msg);
	%>
	<strong>${msg }</strong>
		
		</div>
	</c:if>
	</div>
</div>