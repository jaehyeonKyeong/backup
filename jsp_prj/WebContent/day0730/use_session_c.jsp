<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.co.sist.util.HashAlgorithm"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="세션 내장객체를 사용하여 관계유지"
    session="true"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/servlet_prj/common/css/main.css"/>
<!--  CDN -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- SmartMenus core CSS (required) -->
 <link href="../common/js/smart/css/sm-core-css.css" rel="stylesheet" type="text/css" />
<link href="../common/js/smart/css/sm-simple/sm-simple.css" rel="stylesheet" type="text/css" />
<!-- SmartMenus jQuery plugin -->
<script type="text/javascript" src="../common/js/smart/jquery.smartmenus.min.js"></script>
<script type="text/javascript">
function chkNull(){
	if($("#id").val()==""){
		$("#id").focus();
		return;
	}//end if
	if($("#passwd").val()==""){
		$("#passwd").focus();
		return;
	}//end if
	$("[name='frm']").submit();
}//chkNull

$(function() {
	$('#main-menu').smartmenus({
		subMenusSubOffsetX: 1,
		subMenusSubOffsetY: -8
	});//smartmenus
	$("#id").keydown(function(evt) {
		if( evt.which ==13 ){
			chkNull();
		}//end if
	});//keydown
	$("#passwd").keydown(function(evt) {
		if( evt.which ==13 ){
			chkNull();
		}//end if
	});//keydown
	$(".btn").click(function(){
		chkNull();
	});
	
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
</style>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<div id="headerTop">
				Web 연습  s('. ^)v 
			</div>
			<div id="navi">
			    <nav id="main-nav">
      <!-- Sample menu definition -->
     <!--  <ul id="main-menu" class="sm sm-blue"> -->
      <ul id="main-menu" class="sm sm-simple">
        <li><a href="#">Home</a></li>
        <li><a href="#">파라메터연습</a>
          <ul>
            <li><a href="parameter.html">이름이 유일할 때</a></li>
            <li><a href="parameter_values.html">이름이 중복될때</a></li>
            <li><a href="#" class="disabled">사용불가</a></li>
          </ul>
        </li>
        <li><a href="why_session_a.html">세션이 필요한이유</a></li>
        <li><a href="#">지원</a>
          <ul>
            <li><a href="">빛동희</a></li>
            <li><a href="">갓대현</a></li>
          </ul>
        </li>
        
        <li><a href="#">4강의장에 대해서</a>
          <ul class="mega-menu">
            <li>
              <!-- The mega drop down contents -->
              <div style="width:400px;max-width:100%;">
                <div style="padding:5px 24px;">
                <p>Servlet과 JSP를 만드는 목적 : 동적으로 HTML을 생성하기위해서</p>
                </div>
              </div>
            </li>
          </ul>
        </li>
      </ul>
    </nav>
			</div>
		</div>
		<div id="container">
		<div style="position: relative;">
			<img src="images/temp_bg1.png"/>
			<div style="position: absolute;top: 30px;left:700px">

<%
	//이전 페이지에서 사용한 값을 얻기위해 "세션" 을 사용한다.
	String name=(String)session.getAttribute("usr_name");
	String id=(String)session.getAttribute("usr_id");
	if(id==null){//interval 시간 외에 동작,URL 직접 입력한 경우
		%>
		<script type="text/javascript">
		location.replace("use_session_a.html");
		</script>
	<%
	}//end if
	%>
		<strong><%= id%>(<%= name %>님)</strong><br/>
		<a href="javascript:location.replace('use_session_d.jsp')">로그 아웃</a><br/>
		데헷 ^0^
		
		</div>
		</div>
		<div id="footer">
			Copyright&copy; class4 All Right Reserved.
		</div>
	</div>
</body>
</html>





