<%@page import="java.sql.SQLException"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@page import="kr.co.sist.util.HashAlgorithm"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:useBean id="ddv" class="kr.co.sist.diary.vo.DiaryDeleteVO" scope="page"/>
<jsp:setProperty property="*"  name="ddv" />
<script type="text/javascript">
<%
	try{
		//ddv.setNum(request.getRemoteAddr());
		ddv.setPwd( HashAlgorithm.changeMD5(ddv.getPwd()));
	
	DiaryDAO d_dao=DiaryDAO.getInstance();
	int cnt=d_dao.deleteDiary(ddv);
	String msg="비밀번호를 확인하세요.";	
	if(cnt==1){
		msg="이벤트를 정상적으로 삭제하였습니다.";
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




