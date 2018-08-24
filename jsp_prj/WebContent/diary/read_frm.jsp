<%@page import="kr.co.sist.diary.vo.DiaryVO"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="readFrm">
<c:catch var="e">
<%
	String num=request.getParameter("num");
	DiaryDAO d_dao=DiaryDAO.getInstance();
	DiaryVO dv=d_dao.selectDay( Integer.parseInt(num));
	
	String ip=request.getRemoteAddr();
	//EL에서 사용하기 위해 변수의 값을 Scope객체 저장 
	pageContext.setAttribute("dv",dv); 
	pageContext.setAttribute("ip",ip); 
	
%>
</c:catch>
<c:if test="${ e ne null }">
	<script type="text/javascript">
	$(function(){
		alert("${ param.param_day } 이벤트를 읽어오지 못했습니다.");
		console.log("${ e }");
	});
	</script>
</c:if>
<form action="diary.jsp" method="post" name="rFrm" id="rFrm">
<!-- diary.jsp로 요청하되 page_flag가 update_process이거나
   delete_process 이므로 
	c:import는 update_process.jsp나 delete_process.jsp를 넣어서 
	실행하게 된다.
 -->
<input type="hidden" name="page_flag" />
<input type="hidden" name="num" value="${ param.num }"/>
<table>
	<tr>
		<td colspan="2" class="wTitle">
		<div  style="vertical-align: top">
		이 벤 트 읽 기<span style="float:right;padding-right: 10px;">
		<a href="diary.jsp?param_year=${ param.param_year }&param_month=${ param.param_month }"><img src="images/btn_close.png"/></a></span>
		</div>
		</td>
	</tr>
	<tr>
		<td class="wLabel">작성자 </td>
		<td class="wInput">
		<input type="text" name="writer" class="inputBox" value="${ dv.writer }" readonly="readonly"/>
		</td>
	</tr>
	<tr>
		<td class="wLabel">작성일</td>
		<td class="wInput"><c:out value="${ dv.input_date }"/></td>
	</tr>
	<tr>
		<td class="wLabel">이벤트일</td>
		<td class="wInput">
			<input type="text" name="param_year" class="inputBox" style="width: 40px"
				readonly="readonly" value="${ param.param_year }"/>-
			<input type="text" name="param_month" class="inputBox" style="width: 20px"
				readonly="readonly" value="${ param.param_month }"/>-
			<input type="text" name="param_day" class="inputBox" style="width: 20px"
				readonly="readonly" value="${ param.param_day }"/>
		</td>
	</tr>
	<tr>
		<td class="wLabel">제목</td>
		<td class="wInput">
				<input type="text" name="subject" class="inputBox" 
				style="width: 300px" value="${ dv.subject }" readonly="readonly"/>
		</td>
	</tr>
	<tr>
		<td class="wTaLabel">이벤트 내용</td>
		<td class="wTaInput">
			<%-- <textarea에 값을 설정할 때에는 value가 아니고 
					태그사이에 값이 바로 설정한다. 
			 --%>
			<textarea name="content" id="summernote"
				style="width:300px;height: 200px">${ dv.content }</textarea>
		<span id="contentWarn"></span>
		</td>
	</tr>
	<tr>
		<td class="wLabel">비밀번호</td>
		<td class="wInput">
				<input type="password" name="pwd" class="inputBox" 
				style="width: 150px" title="이벤트를 변경 또는 삭제할 때 필요"/> 
				<strong>작성자 IP : ${ dv.ip_address }( 접속자 IP : ${ ip } ) </strong>
				<span id="pwdWarn"></span>
		</td>
	</tr>
	<tr>
		<td colspan="2"  class="wTitle">
			<input type="button" value="이벤트수정" class="btn" id="btnUpdate"/>
			<input type="button" value="이벤트삭제" class="btn" id="btnDelete"/>
			<input type="reset" value="초기화" class="btn"/>
		</td>
	</tr>
</table>
</form>
</div>


    