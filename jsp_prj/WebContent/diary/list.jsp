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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="lv" class="kr.co.sist.diary.vo.ListVO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="lv"></jsp:setProperty>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://211.63.89.130:8080/jsp_prj/common/css/main.css"/>
<!--  CDN -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- SmartMenus core CSS (required) -->
 <link href="../common/js/smart/css/sm-core-css.css" rel="stylesheet" type="text/css" />
<link href="../common/js/smart/css/sm-simple/sm-simple.css" rel="stylesheet" type="text/css" />
<!-- SmartMenus jQuery plugin -->
<script type="text/javascript" src="../common/js/smart/jquery.smartmenus.min.js"></script>
<script type="text/javascript">
$(function() {
	$('#main-menu').smartmenus({
		subMenusSubOffsetX: 1,
		subMenusSubOffsetY: -8
	});//smartmenus
	$("#btnSearch").click(function(){
	      if($("#keyword").val()==""){
	         alert("검색어를 입력해주세요.");
	         $("#keyword").focus();
	         return;
	      }//end if
	      $("#searchFrm").submit();
	   });//click
	
	
	
});//ready
</script>
<style type="text/css">
#wrap { width: 1024px; height: 1000px; margin: 0px auto }
#header{ height: 150px }
#headerTop{ height: 75px; font-family:고딕; font-size:30px; text-align:center;
					font-weight:bold; padding-top:25px;
			background: #FFF url(../common/images/header_bg.png)}
#navi{ height: 500px}
#container{ height:750px }
#footer{ height:60px;background: #FFF url(../common/images/footer_bg.png) ;
			font-size: 16px; font-weight: bold; text-align: right; 
			padding-right: 30px; padding-top:40px;
			width: 994px;}
			
#tab{ border-top: 2px solid #5B7CE5;border-spacing: 0px; margin: 0px auto }
#numTitle{ width:60px }
#subjectTitle{ width:350px }
#writerTitle{ width:100px }
#evtTitle{ width:200px }
#inputTitle{ width:120px }
#cntTitle{ width:60px }
				
th{ border-bottom: 1px solid #E7E7E7; height:25px;
		background-color:  #EAE9F7 ;color:#545454 }
td{  border-bottom: 1px solid #E7E7E7; text-align: center;height: 25px }
tr:hover{ background-color:  #EAE9F7 ; }	
</style>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<div id="headerTop">
				일 정 관 리 시 스 템 
			</div>
			<div id="navi">
				<c:import url="../common/jsp/diary_menu.jsp"/>
			</div>
		</div>
		<div id="container">
		<%
			DiaryDAO d_dao=DiaryDAO.getInstance();
			//1. 전체 게시물의 갯수 
			/* ListVO lv=null; */
		//	ListVO lv=new ListVO("writer","123");
			int totalCount=d_dao.rowCnt(lv);
			//2. 한 화면에 보여줄 게시물의 수 
			 int pageScale=10;
			//3. 총 페이지 수 계산
			//int  totalPage=(int)Math.ceil((double)totalCount/pageScale);
			int totalPage=totalCount/pageScale;
			if( totalCount%pageScale != 0){
				totalPage++;
			}//end if
		
			//4. 선택한 페이지 번호 얻기
			String currentPage=request.getParameter("current_page");
			int tempPage=currentPage==null?1:Integer.parseInt(currentPage);
			//5. 시작번호 구하기
			int startNum=tempPage*pageScale-pageScale+1;
			//6.  끝번호 구하기
			int endNum=startNum+pageScale-1;
			
		/* 	lv=new ListVO("","",startNum,endNum); */
		
		lv.setStartNum(startNum);
		lv.setEndNum(endNum);
		
		
		
			List<DiaryListVO> list =d_dao.selectDiaryList(lv);
			pageContext.setAttribute("list", list);
			pageContext.setAttribute("list_size", totalPage);
			pageContext.setAttribute("current_page", tempPage);
			pageContext.setAttribute("totalCount", totalCount);
			pageContext.setAttribute("pageScale", pageScale);
		%>
	<%-- 	전체 글의 수 : <%= totalCount %><br/>
		한 화면에 보여줄 게시물의 수 : <%= pageScale %><br/>
		총페이지 수 : <%= totalPage %><br/>
		선택한 페이지 번호  : <%= tempPage %><br/>
		시작 번호  : <%= startNum %><br/>
		끝 번호  : <%= endNum %><br/> --%>
		<div>
		<div style="height: 300px">
		<table id="tab">
			<thead>
			<tr>
				<th id="numTitle">번호</th>
				<th id="subjectTitle">제목</th>
				<th id="writerTitle">작성자</th>
				<th id="evtTitle">이벤트일</th>
				<th id="inputTitle">작성일</th>
				<th id="cntTitle">조회수</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="dlv" items="${ list }">
				<c:set var="num"  value="${ num+1 }"/>
				<tr>
					<td><c:out value="${ totalCount+1-( current_page-1)*pageScale- num }"/></td>
					<td><a href="read_diary.jsp?num=${ dlv.num }&param_year=${ dlv.e_year }&param_month=${ dlv.e_month }&param_day=${ dlv.e_day }&current_page=${ current_page }"><c:out value="${ dlv.subject }"/></a></td>
					<td><c:out value="${ dlv.writer }"/></td>
					<td><c:out value="${ dlv.input_date }"/></td>
					<td><c:out value="${ dlv.e_year }"/>-<c:out value="${ dlv.e_month }"/>-<c:out value="${ dlv.e_day }"/></td>
					<td><c:out value="${ dlv.cnt }"/></td>
				</tr>
			</c:forEach>
			<c:if test="${empty list }">
			<tr>
				<td colspan="6" style="text-align:center;">	"${param.keyword }" 에 해당하는 글 없다.
				</td>
			</tr>
			</c:if>
			</tbody>
		</table>
		</div>
		<div id="indexList" style="text-align: center;">
		<c:forEach var="i" begin="1" end="${ list_size }" step="1">
		 [ <a href="list.jsp?current_page=${ i }&fieldName=${param.fieldname }$keyword=${param.keyword}">${ i }</a> ]
		</c:forEach>
		</div>
		<div id="searchDiary" style="text-align: center;margin-top: 10px">
			<form action="list.jsp" method="post" name="searchFrm"
				id="searchFrm">
				<select name="fieldName" style="height: 22px">
					<option value="writer"${param.fieldName eq 'writer'?" selected='selected'":"" }>작성자</option>
					<option value="subject"${param.fieldName eq 'subject'?" selected='selected'":"" }>제목</option>
					<option value="content"${param.fieldName eq 'content'?" selected='selected'":"" }>내용</option>
				</select>
				<input type="text" name="keyword" class="inputBox"
					style="width:250px" id="keyword" value="${param.keyword}"/>
				<input type="button" value="검색" class="btn" id="btnSearch"/>
			</form>
		</div>
		</div>
		
		</div>
		<div id="footer">
			Copyright&copy; class4 All Right Reserved.
		</div>
	</div>
</body>
</html>



    