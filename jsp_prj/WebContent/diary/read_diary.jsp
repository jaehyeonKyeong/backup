<%@page import="kr.co.sist.diary.vo.DiaryVO"%>
<%@page import="kr.co.sist.diary.vo.DiaryListVO"%>
<%@page import="kr.co.sist.diary.vo.ListVO"%>
<%@page import="kr.co.sist.diary.vo.MonthInfoVO"%>
<%@page import="kr.co.sist.diary.vo.MonthVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="http://211.63.89.140:8080/jsp_prj/common/css/main.css" />
<!--  CDN -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- SmartMenus core CSS (required) -->
<link href="../common/js/smart/css/sm-core-css.css" rel="stylesheet"
	type="text/css" />
<link href="../common/js/smart/css/sm-simple/sm-simple.css"
	rel="stylesheet" type="text/css" />
<!-- SmartMenus jQuery plugin -->
<script type="text/javascript"
	src="../common/js/smart/jquery.smartmenus.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#main-menu').smartmenus({
			subMenusSubOffsetX : 1,
			subMenusSubOffsetY : -8
		}); //smartmenus
	}); //ready
</script>
<style type="text/css">

#wrap {
	width: 1024px;
	height: 1000px;
	margin: 0px auto
}

#header {
	height: 150px
}

#headerTop {
	height: 75px;
	font-family: 고딕;
	font-size: 30px;
	text-align: center;
	font-weight: bold;
	padding-top: 25px;
	background: #FFF url(../common/images/header_bg.png)
}

#navi {
	height: 500px
}

#container {
	height: 750px
}

#footer {
	height: 60px;
	background: #FFF url(../common/images/footer_bg.png);
	font-size: 16px;
	font-weight: bold;
	text-align: right;
	padding-right: 30px;
	padding-top: 40px;
	width: 994px;
}
.wLabel{ height: 20px;width: 120px; text-align: center;}			
.wInput{ height: 20px;width: 280px; }			
.wTaLabel{ height: 120px;width: 120px; text-align: center;}			
.wTaInput{ height: 120px;width: 280px; }	
.wTitle{ width: 360px; height: 30px;text-align: center; font-size: 20px;
		font-weight: bold }
		
#readFrm{top: 90px;left: 80px;background-color:#FFFFFF;width:650px; margin:0px auto  }
</style>
<!--  summer note 시작 -->
<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>
<script src="../common/summernote/summernote-ko-KR.js"></script>
<script type="text/javascript">

	$(function(){
			  $('#summernote').summernote({
				  placeholder: '이벤트 입력',
			      height: 200,
			      width: 500,
			      lang: 'ko-KR'
			});//summernote
	});//ready
</script>
<!--  summer note 끝 -->
</head>
<body>
	<div id="wrap">
		<div id="header">
			<div id="headerTop">일 정 관 리 시 스 템</div>
			<div id="navi">
				<c:import url="../common/jsp/diary_menu.jsp" />
			</div>
		</div>
		<div id="container">
			<div id="readFrm">
				<c:catch var="e">
					<%
						String num = request.getParameter("num");
							DiaryDAO d_dao = DiaryDAO.getInstance();
							DiaryVO dv = d_dao.selectDay(Integer.parseInt(num));

							String ip = request.getRemoteAddr();
							//EL에서 사용하기 위해 변수의 값을 Scope객체 저장 
							pageContext.setAttribute("dv", dv);
							pageContext.setAttribute("ip", ip);
					%>
				</c:catch>
				<c:if test="${ e ne null }">
					<script type="text/javascript">
						$(function() {
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
					<input type="hidden" name="page_flag" /> <input type="hidden"
						name="num" value="${ param.num }" />
						<a href="list.jsp?current_page=${param.current_page }">목록보기</a><br>
					<table>
						<tr>
							<td colspan="2" class="wTitle">
								<div style="vertical-align: top">
									이 벤 트 읽 기
								</div>
							</td>
						</tr>
						<tr>
							<td class="wLabel">작성자</td>
							<td class="wInput"><input type="text" name="writer"
								class="inputBox" value="${ dv.writer }" readonly="readonly" /></td>
						</tr>
						<tr>
							<td class="wLabel">작성일</td>
							<td class="wInput"><c:out value="${ dv.input_date }" /></td>
						</tr>
						<tr>
							<td class="wLabel">이벤트일</td>
							<td class="wInput"><input type="text" name="param_year"
								class="inputBox" style="width: 40px" readonly="readonly"
								value="${ param.param_year }" />- <input type="text"
								name="param_month" class="inputBox" style="width: 20px"
								readonly="readonly" value="${ param.param_month }" />- <input
								type="text" name="param_day" class="inputBox"
								style="width: 20px" readonly="readonly"
								value="${ param.param_day }" /></td>
						</tr>
						<tr>
							<td class="wLabel">제목</td>
							<td class="wInput"><input type="text" name="subject"
								class="inputBox" style="width: 300px" value="${ dv.subject }"
								readonly="readonly" /></td>
						</tr>
						<tr>
							<td class="wTaLabel">이벤트 내용</td>
							<td class="wTaInput">
								<%-- <textarea에 값을 설정할 때에는 value가 아니고 
					태그사이에 값이 바로 설정한다. 
			 --%> <textarea name="content" id="summernote"
									style="width: 300px; height: 200px">${ dv.content }</textarea>
								<span id="contentWarn"></span>
							</td>
						</tr>
						<tr>
							<td class="wLabel">비밀번호</td>
							<td class="wInput"><input type="password" name="pwd"
								class="inputBox" style="width: 150px"
								title="이벤트를 변경 또는 삭제할 때 필요" /> <strong>작성자 IP : ${ dv.ip_address }(
									접속자 IP : ${ ip } ) </strong> <span id="pwdWarn"></span></td>
						</tr>
						<tr>
							<td colspan="2" class="wTitle"><input type="button"
								value="이벤트수정" class="btn" id="btnUpdate" /> <input type="button"
								value="이벤트삭제" class="btn" id="btnDelete" /> <input type="reset"
								value="초기화" class="btn" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div id="footer">Copyright&copy; class4 All Right Reserved.</div>
	</div>
</body>
</html>



