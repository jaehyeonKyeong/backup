<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="writeFrm">
<%
	Date date=new Date();
	pageContext.setAttribute("date",date);
	String ip=request.getRemoteAddr();
	pageContext.setAttribute("ip", ip);
%>
<form action="diary.jsp" method="post" name="wFrm" id="wFrm">
<!-- diary.jsp로 요청하되 page_flag가 write_process이므로 
	c:import는 write_process.jsp를 넣어서 실행하게 된다.
 -->
<input type="hidden" name="page_flag" value="write_process"/>
<table>
	<tr>
		<td colspan="2" class="wTitle">
		<div  style="vertical-align: top">
		이벤트작성<span style="float:right;padding-right: 10px;">
		<a href="diary.jsp?param_year=${ param.param_year }&param_month=${ param.param_month }"><img src="images/btn_close.png"/></a></span>
		</div>
		</td>
	</tr>
	<tr>
		<td class="wLabel">작성자 </td>
		<td class="wInput">
		<input type="text" name="writer" class="inputBox"/>
		<span id="writerWarn"></span>
		</td>
	</tr>
	<tr>
		<td class="wLabel">작성일</td>
		<td class="wInput"><fmt:formatDate value="${ date }" pattern="yyyy-MM-dd a HH:mm"/></td>
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
				style="width: 300px"/>
				<span id="subjectWarn"></span>
		</td>
	</tr>
	<tr>
		<td class="wTaLabel">이벤트 내용</td>
		<td class="wTaInput">
				<textarea name="content" id="summernote"
					style="width:300px;height: 200px"></textarea>
		<span id="contentWarn"></span>
		</td>
	</tr>
	<tr>
		<td class="wLabel">비밀번호</td>
		<td class="wInput">
				<input type="password" name="pwd" class="inputBox" 
				style="width: 150px" title="이벤트를 삭제할 때 필요"/> 
				<strong>IP Address : ${ ip }</strong>
				<span id="pwdWarn"></span>
		</td>
	</tr>
	<tr>
		<td colspan="2"  class="wTitle">
			<input type="button" value="이벤트작성" class="btn" id="btnWrite"/>
			<input type="reset" value="초기화" class="btn"/>
		</td>
	</tr>
</table>
</form>
</div>


