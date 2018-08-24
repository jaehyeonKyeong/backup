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
<%!
	//declaration : method 선언, instance변수 선언 
	//- Class Field에 정의하는 코드
	private Map<String,String> map=new HashMap<String,String>();
	//instance 영역 : 객체화가 되면 자동으로 최초 딱 한번 호출되는 영역
	{
	//	System.out.println("instance 영역");
		map.put("song","송재원,에헤~~~");
		map.put("lee","이종민,뭐지..?");
		map.put("shin","신종성,아하~아하");
		map.put("bae","뚜딘,그럼요! 그럼요!");
	}//instance영역
%>
<%
	//	System.out.println("_jspService 영역");
	//1. 파라메터 값을 세션에 설정 
	String id=request.getParameter("id");
	String passwd=request.getParameter("passwd");
	//SHA 로 암호화
	passwd=HashAlgorithm.changeMD5(passwd);
	
	String name="";
	String msg="";
	if( map.containsKey(id) && 
		HashAlgorithm.changeMD5("1234").equals(passwd) ){
		name=map.get(id).split(",")[0];
		msg=map.get(id).split(",")[1];
		//세션(내장객체)에 설정 
		session.setAttribute("usr_id", id);
		session.setAttribute("usr_name", name);
		//세션 생존시간(interval) 설정
		session.setMaxInactiveInterval(60*2);
		
		%>
		<strong><%= name %></strong>님 (<%= msg %>)<br/>
		<a href="javascript:location.replace('use_session_c.jsp')">작업 페이지</a>
		
		<%
		
	}else{
		%>
		<script type="text/javascript">
		location.replace("use_session_a.html");
		</script>
	<%
	}//end if
	%>
		</div>
		</div>
		<div id="footer">
			Copyright&copy; class4 All Right Reserved.
		</div>
	</div>
</body>
</html>





