<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main.css"/>
<!-- CDN -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
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
		
		$("#id").keydown(function(evt) {
			if(evt.which==13){
				chkNull();
			}//end if
		});//keydown
		
		$("#passwd").keydown(function(evt) {
			if(evt.which==13){
				chkNull();
			}//end if
		});//keydown
		
		$(".btn").click(function() {
				chkNull();
		});//click
		
	});//ready


</script>
<style type="text/css">
	#wrap{width: 1024px;height: 1000px;margin: 0px auto;}
	#header{height: 150px;}
	#headerTop{height: 75px; font-family:고딕; font-size:30px; text-align:center;
			font-weight:bold; padding-top:25px; 
			background: #fff url(../common/images/header_bg.png)}
	#navi{height: 500px}
	#container{height:750px }
	#footer{height:60px;background: #fff url(../common/images/footer_bg.png);
			font-size: 16px; font-weight: bold;text-align: right;
			padding-right: 30px; width: 994px; padding-top: 40px;}
</style>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<div id="headerTop">
			Web 연 습 (^o^)/
			
			</div>
			<div id="navi">
			 <jsp:include page="/common/jsp/main_menu.jsp" />
			</div>
		</div>
		<div id="container">
		<div style="position: relative;">
			<img src="images/temp_bg1.png" style="position: absolute;top:0px; left:0px;"/>
			<div style="position: absolute;top: 30px;left: 700px;">
			<form action="use_session_b.jsp" method="post" name="frm">
			<table>
			<tr>
			<td >
			<input type="text" name="id" class="inputBox" 
			placeholder="아이디" id="id" style="width:200px;height: 30px"
			autofocus="autofocus" tabindex="1"/>
			
			
			</td>
			<td rowspan="2">
			<input type="button" value="로그인"
				 class="btn" style="height: 66px; width: 65px;" tabindex="3"/>
			</td>
			
			</tr>
			<tr>
			<td>
			<input type="password" name="passwd" class="inputBox" id="passwd"
				placeholder="비밀번호" style="width: 200px;height: 30px" tabindex="2"/>
			</td>
			</tr>
			</table>
			</form>
			<div>
			<a href="#">회원가입</a>
			<a href="#">아이디/비빌번호 찾기</a>
			</div>
			</div>
		</div>
		</div>
		<div id="footer">
		Copyright&copy;class4 All Right Reserved.
		
		</div>
	</div>


</body>
</html>