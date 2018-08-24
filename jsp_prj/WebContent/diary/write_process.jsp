<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@page import="kr.co.sist.util.HashAlgorithm"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="div" class="kr.co.sist.diary.vo.DiaryInsertVO" scope="page"/>
<jsp:setProperty property="*" name="div"/>
<script type="text/javascript">
<c:catch var="e">
<%
	String ip=request.getRemoteAddr();
	//ip설정
	div.setIp_address(ip);
	//비밀번호 SHA 로 변환
	div.setPwd( HashAlgorithm.changeMD5(div.getPwd()));
	//DB추가 
	
	DiaryDAO d_dao=DiaryDAO.getInstance();
	boolean flag=d_dao.insertDiary(div);
	if(flag){
		
%>
	alert("${ param.param_day }일에 이벤트가 작성되었습니다.");
	location.replace("diary.jsp?param_year=${ param.param_year }&param_month=${ param.param_month }");

<%}else{%>
	alert("${ param.param_day }일에 작성할 수 있는 \n이벤트의 수가 초과되었습니다.");
	history.back();
<%}//end if{%>

	</c:catch>
<c:if test="${ not empty e }">
	alert("${ param.param_day }일에 이벤트가 작성실패. ");
	console.log("${ e }");
</c:if>
</script>



