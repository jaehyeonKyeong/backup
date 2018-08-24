<%@page import="java.sql.SQLException"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@page import="kr.co.sist.util.HashAlgorithm"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:useBean id="duv" class="kr.co.sist.diary.vo.DiaryUpdateVO" scope="page"/>
<jsp:setProperty property="*"  name="duv" />
<script type="text/javascript">
<%
	try{
	duv.setIp_address(request.getRemoteAddr());
	duv.setPwd( HashAlgorithm.changeMD5(duv.getPwd()));
	
	DiaryDAO d_dao=DiaryDAO.getInstance();
	int cnt=d_dao.updateDiary(duv);
	String msg="비밀번호를 확인하세요.";	
	if(cnt==1){
		msg="이벤트를 정상적으로 변경하였습니다.";
	}//end if

	%>
	alert("<%= msg %>");
	<%
	if(cnt==0){
	%>
	history.back();
	<%
	}else{
	%>
	location.href="diary.jsp?param_year=${ param.param_year }&param_month=${ param.param_month }&$param_day=${ param.param_day }&page_flag=read_frm&num=${ param.num }";
	<%
		
	}//end if
	
	}catch(SQLException se){
		se.printStackTrace();
	%>
	alert("죄송합니다. 문제가 발생하였습니다.");
	<%
	}//end catch
%>
</script>




