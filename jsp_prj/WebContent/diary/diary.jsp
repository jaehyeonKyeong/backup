<%@page import="kr.co.sist.diary.vo.MonthInfoVO"%>
<%@page import="kr.co.sist.diary.vo.MonthVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%!
	public static final int START_DAY=1;
%>
 <%
 	request.setCharacterEncoding("UTF-8");
 %>
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
	
	$("#btnWrite").click(function(){
		//유효성검증
		if($("[name='writer']").val()==""){
			$("#writerWarn")
			.html("<strong style='color:#FF0000'> 작성자 필수 입력</strong>");
			$("#writerWarn").fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(1000).fadeOut(1000);
			$("[name='writer']").focus();
			return;
		}//end if
		if($("[name='subject']").val()==""){
			$("#subjectWarn").html("<strong style='color:#FF0000'>제목 필수 입력</strong>");
			$("#subjectWarn").fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(1000).fadeOut(1000);
			$("[name='subject']").focus();
			return;
		}//end if
		if($("[name='content']").val()=="" || $("[name='content']").val()=="<p><br></p>" ){
			$("#contentWarn").html("<strong style='color:#FF0000'>내용 필수 입력</strong>");
			$("#contentWarn").fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(1000).fadeOut(1000);
			$("[name='content']").focus();
			return;
		}//end if
		if($("[name='pwd']").val()==""){
			$("#pwdWarn").html("<strong style='color:#FF0000'>비밀번호 필수 입력</strong>");
			$("#pwdWarn").fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(1000).fadeOut(1000);
			$("[name='pwd']").focus();
			return;
		}//end if
		$("#wFrm").submit();
	})//click
	
	$("#btnUpdate").click(function(){
		if($("[name='content']").val()=="" || $("[name='content']").val()=="<p><br></p>" ){
			$("#contentWarn").html("<strong style='color:#FF0000'>내용 필수 입력</strong>");
			$("#contentWarn").fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(1000).fadeOut(1000);
			$("[name='content']").focus();
			return;
		}//end if
		if($("[name='pwd']").val()==""){
			$("#pwdWarn").html("<strong style='color:#FF0000'>비밀번호 필수 입력</strong>");
			$("#pwdWarn").fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(1000).fadeOut(1000);
			$("[name='pwd']").focus();
			return;
		}//end if
		var obj=document.rFrm;
		obj.action="diary.jsp"
		obj.page_flag.value="update_process";
		obj.submit();
		
	});//click
	$("#btnDelete").click(function(){
		if($("[name='pwd']").val()==""){
			$("#pwdWarn").html("<strong style='color:#FF0000'>비밀번호 필수 입력</strong>");
			$("#pwdWarn").fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(1000).fadeOut(1000);
			$("[name='pwd']").focus();
			return;
		}//end if
	var obj=document.rFrm;
	obj.action="diary.jsp"
	obj.page_flag.value="delete_process";
	obj.submit();
	});//click
	
});//ready

function moveDiary(month, year){
	var obj=document.hidFrm;
	//action(입력값을 받을 페이지)설정 : obj.action="URL"
	obj.action="diary.jsp";
	//method(전송방식)설정 : obj.method="GET|POST"
	obj.method="post";
	//이동할 값 설정
	obj.param_month.value=month;
	obj.param_year.value=year;
	obj.submit();	
}//moveDiary

function pageMove(year, month, day, pageFlag, cnt){
	if( pageFlag == "write_frm"){
		if( cnt > 4 ){
			alert("하루에 작성가능한  이벤트는 5건 까지 입니다.");
			return;
		}//end if
	}//end if
	
	var obj=document.hidFrm;
	obj.action="diary.jsp";
	obj.method="post";
	
	obj.param_year.value=year;
	obj.param_month.value=month;
	obj.param_day.value=day;
	obj.page_flag.value=pageFlag;
	obj.num.value=cnt;
	
	obj.submit();
	
}//pageMove

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
			
#diaryWrap{ width: 710px;height: 550px; position: relative; margin: 0px auto}
#diaryTitle{ width: 710px;height: 50px; text-align: center}
#diaryContent{ width: 710px;height: 400px;margin: 0px auto;position: relative; }
#nowDate{ font-family: 고딕; font-size: 25px;font-weight: bold }
.sunTitle{ width: 100px;height: 25px ;color: #D04C3E }
.weekTitle{  width: 100px;height: 25px;color:#565656  }
.satTitle{  width: 100px;height: 25px;color: #538EF2 }
table { border: 1px solid #D6D7D7;border-spacing: 0px }
th,td{ border: 1px solid #D6D7D7}
td{ height: 70px; vertical-align: top; text-align: left;padding-left: 5px }
.sunColor{  color:#D04C3E;font-weight: bold }
.weekColor{  color:#565656; }
.satColor{ color:#538EF2;font-weight: bold  }

#toDay{ border:1px solid #D7E2E9; background-color: #E9F4FB;
			font-size: 15px; font-weight: bold;  }
			
			
.wLabel{ height: 20px;width: 80px; text-align: center;}			
.wInput{ height: 20px;width: 280px; }			
.wTaLabel{ height: 120px;width: 80px; text-align: center;}			
.wTaInput{ height: 120px;width: 280px; }	
.wTitle{ width: 360px; height: 30px;text-align: center; font-size: 20px;
		font-weight: bold }
		
#diaryFrm{ position: absolute;top: 90px;left: 80px;
				background-color:#FFFFFF;border: 2px solid #333;
				box-shadow: 10px 10px 10px #333  }		
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

<!-- tooltip 시작 -->
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
  $( function() {
    $( document ).tooltip({
      position: {
        my: "center bottom-20",
        at: "center top",
        using: function( position, feedback ) {
          $( this ).css( position );
          $( "<div>" )
            .addClass( "arrow" )
            .addClass( feedback.vertical )
            .addClass( feedback.horizontal )
            .appendTo( this );
        }
      }
    });
  } );
  </script>
  <link type="text/css" rel="stylesheet" href="../common/css/tooltip.css"/>   
<!-- tooltip 끝 -->

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
			<div id="diaryWrap">
				<%
				Calendar cal=Calendar.getInstance();
				int nowYear=0;
				int nowMonth=0;
				int nowDay=cal.get(Calendar.DAY_OF_MONTH);
				
				boolean toDayFlag=false;
				StringBuilder toDay=new StringBuilder();
				toDay.append(cal.get(Calendar.YEAR))
				.append(cal.get(Calendar.MONTH)+1);
				
				
	//현재월에 없는 날짜가 입력되면 다음달 1일로 넘어가는 것을 막는다. 
 			 	cal.set(Calendar.DAY_OF_MONTH,1);
				String param_month=request.getParameter("param_month");
				if( param_month != null ){
					//이전 월이 선택되었으므로 달력의 월을 이전월로 변경
					cal.set(Calendar.MONTH, Integer.parseInt(param_month)-1);
				}//end if 
				//변경된 월을 얻는다. 
				nowMonth=cal.get(Calendar.MONTH)+1; 
				
				String param_year=request.getParameter("param_year");
				if(param_year != null){
					//년도가 있다면 입력된 년으로 년을 변경
					cal.set(Calendar.YEAR, Integer.parseInt(param_year));
				}//end if
				//설정된 년도를 받는다.
				nowYear=cal.get(Calendar.YEAR);
				
				//오늘을 표현해야할지 설정 
				toDayFlag=
					toDay.toString().equals(new StringBuilder().append(nowYear)
					.append(nowMonth).toString());
				
				%>
				<form name="hidFrm">
					<input type="hidden" name="param_month">
					<input type="hidden" name="param_year">
					<input type="hidden" name="param_day">
					<input type="hidden" name="page_flag">
					<input type="hidden" name="num">
				</form>
				
				<div id="diaryTitle">
				<a href="#" onclick="moveDiary('<%= nowMonth-1==0?12: nowMonth-1 %>','<%= nowMonth-1==0? nowYear-1:nowYear %>')">
				<img src="images/btn_prev.png" title="이전 월"></a>
				<span id="nowDate" title="<%= nowYear%>-<%= nowMonth %>-<%= nowDay%>"><%= nowYear %>.<%= nowMonth %></span>
				<a href="#" onclick="moveDiary('<%= nowMonth+1==13?1:nowMonth+1%>','<%=nowMonth+1==13?nowYear+1:nowYear %>')">
				<img src="images/btn_next.png" title="다음 월"></a>
				<a href="diary.jsp">
				<img src="images/btn_today.png" title="현재 월 "></a>
				</div>
				<div id="diaryContent">
				<table>
				<thead>
				<tr>
					<th class="sunTitle">일</th>
					<th class="weekTitle">월</th>
					<th class="weekTitle">화</th>
					<th class="weekTitle">수</th>
					<th class="weekTitle">목</th>
					<th class="weekTitle">금</th>
					<th class="satTitle">토</th>
				</tr>
				</thead>
				<tbody>
				<tr>
				<%
					String dayColor="";
				//이번달에 이벤트가 존재하는지  DB Table 조회
				
				DiaryDAO d_dao=DiaryDAO.getInstance();
				Map<String,List<MonthVO>> monthMap=
						d_dao.selectMonth(	new MonthInfoVO( String.valueOf(nowYear),String.valueOf(nowMonth)));
					//끝일을 모르기 때문에 무한 loop
					for(int tempDay=1; ; tempDay++){
					//임시일자를 달력객체에 설정 
					cal.set(Calendar.DAY_OF_MONTH, tempDay);
					//현재월에 없는 날짜가 설정되면 다음달 1일로 얻어진다.
					if(tempDay != cal.get(Calendar.DAY_OF_MONTH)){
						//임시일자와 증가하는 일자가 다르다면 마지막 날이므로
						//공백을 출력하고 빠져나간다.
						int day_of_week=cal.get(Calendar.DAY_OF_WEEK);
						if( day_of_week != Calendar.SUNDAY ){
							for(int blankTd=day_of_week;
									blankTd< Calendar.SATURDAY+1 ; blankTd++){
								out.println("<td>&nbsp;</td>");
							}//end for
						}//end if
						break;					
					}//end if
					
					//요일별 글자색 설정
					switch(cal.get(Calendar.DAY_OF_WEEK)){
					case Calendar.SUNDAY : dayColor="sunColor";
					break;
					case Calendar.SATURDAY : dayColor="satColor";
					break;
					default : dayColor="weekColor";
					}//end switch
					
					// 1일을 출력하기 전에 공백을 출력
					switch(tempDay){
					case START_DAY:
						for(int blankTd=1; 
								blankTd < cal.get(Calendar.DAY_OF_WEEK);
								blankTd++){
							out.println("<td>&nbsp;</td>");
						}//end for
					}//end switch
					
					List<MonthVO> evtList=null;
					int evtCnt=0;//설정된 날에 대한 작성된 이벤트 수
					//임시일자를 넣었을 때 키가 존재한다면 이벤트가 존재.
					if(monthMap.containsKey(String.valueOf(tempDay))){
						//작성된 이벤트를 받아서
						evtList=monthMap.get(String.valueOf(tempDay));
						evtCnt=evtList.size();
					}//end if
					pageContext.setAttribute("evtCnt", evtCnt);//일관성 측면에서는 좋지 않다.
					//요일을 출력
				%>
				<td<%= toDayFlag&&tempDay==nowDay?" id='toDay'":"" %>>
				<div>
				 <a href="#" onclick="pageMove('<%= nowYear %>','<%= nowMonth %>','<%= tempDay %>','write_frm',${ evtCnt })"><span class="<%= dayColor%>"><%= tempDay %></span></a>
				</div>
				<%	if(evtList != null){ %>
				<div>
					<% for(MonthVO mv: evtList){	%>
						<a href="#" onclick="pageMove('<%= nowYear %>','<%= nowMonth %>','<%= tempDay %>','read_frm',<%= mv.getNum() %>)">
						<img src="images/evt.png" title="<%= mv.getSubject() %>"/></a>
					<% 	}//end for %>
				</div>
				<%	}//end if	%>				
				</td>
				<%
					//설정된 요일이 토요일이면 줄을 변경한다.
					switch(cal.get(Calendar.DAY_OF_WEEK)){
					case Calendar.SATURDAY :
						out.println("</tr>");
						out.println("\t\t\t\t<tr>");
					}//end
					}//end for
				%>
				</tr>
				</tbody>
				</table>
				</div>
				<c:if test="${ not empty param.page_flag }">
				<div id="diaryFrm">
					<c:import url="${ param.page_flag }.jsp"/>
				</div>
				</c:if>
			</div>
		</div>
		<div id="footer">
			Copyright&copy; class4 All Right Reserved.
		</div>
	</div>
</body>
</html>



    