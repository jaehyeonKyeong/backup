<%@page import="kr.co.sist.domain.Dept"%>
<%@page import="kr.co.sist.dao.SelectExam1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<strong>컬럼 여러개에 행 하나 조회</strong>
	<div>
		<div>
			<a style="font-size: 14px" href="use_select_mybatis.jsp?page=day0906/multi_column&deptno=10">10번 부서</a>
			<a style="font-size: 14px" href="use_select_mybatis.jsp?page=day0906/multi_column&deptno=20">20번 부서</a>
			<a style="font-size: 14px" href="use_select_mybatis.jsp?page=day0906/multi_column&deptno=30">30번 부서</a>
			<a style="font-size: 14px" href="use_select_mybatis.jsp?page=day0906/multi_column&deptno=40">40번 부서</a>
		</div>
	<%
		String deptno = request.getParameter("deptno");
			if(deptno == null){
		out.println("부서번호 링크를 클릭하세요");
			}else{
		SelectExam1 se1 = new SelectExam1();
		Dept dept = se1.multiColumn(Integer.parseInt(deptno));
	%>
				${ param.deptno } 번 부서는 <strong>
				<%= dept.getDname() %></strong>(<%= dept.getLoc() %>)
				부서 입니다.
			<%
		}//end else
	%>
	</div>
</div>