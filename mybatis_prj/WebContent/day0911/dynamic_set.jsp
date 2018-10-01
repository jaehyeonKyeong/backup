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
	<strong>사원 정보 변경</strong>
	<div>
	<form action="use_select_mybatis.jsp">
		<input type="hidden" name="page" value="day0911/dynamic_set" />
		<label>사원번호</label>
		<input type="text" name="empno" value="${ param.empno }" onclick="this.value=''"/><br/>
		<label>사원명</label>
		<input type="text" name="ename" value="${ param.ename }" onclick="this.value=''"/><br/>
		<label>연봉</label>
		<input type="text" name="sal" value="${ param.sal }" onclick="this.value=''"/><br/>
		<label>보너스</label>
		<input type="text" name="comm" value="${ param.comm }" onclick="this.value=''"/><br/>
		<input type="submit" value="사원정보변경"/>
	</form>
	<c:if test="${ not empty param.empno }">
		<div style="margin-top: 20px">
	<%
		String empno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		String sal = request.getParameter("sal");
		String comm = request.getParameter("comm");
		
		SelectExam3 se3 = new SelectExam3();
		DynamicSetVO ds_vo=new DynamicSetVO(Integer.parseInt(empno),Integer.parseInt("".equals(sal)?"0":sal),
				Integer.parseInt("".equals(comm)?"0":comm),ename);
		int cnt = se3.dynamicSet(ds_vo);
		boolean flag=false;
		if(cnt==0){
			flag=true;
		}
		pageContext.setAttribute("flag", flag);
	%>
	<c:if test="${flag }">
	${param.ename }(${param.sal }) 사원의 정보가 변경되었습니다.
	</c:if>
	<c:if test="${not flag }">
	${param.ename }(${param.sal }) 사원의 정보 변경 실패.
	</c:if>
		
		</div>
	</c:if>
	</div>
</div>