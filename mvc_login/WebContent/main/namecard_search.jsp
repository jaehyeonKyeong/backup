<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>명함 조회</title>
<!-- Load CSS -->
<link href="http://localhost:8080/mvc_login/common/css/style.css" rel="stylesheet" type="text/css" />
<!-- Load Icon Font -->
<link href="http://localhost:8080/mvc_login/common/css/webfont.css" rel="stylesheet" type="text/css" />
<!-- Load jQuery library -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<!-- Load jCarousel js -->
<script type="text/javascript" src="http://localhost:8080/mvc_login/common/js/jquery.jcarousel.js"></script>
<!-- Load MixItUup js -->
<script type="text/javascript" src="http://localhost:8080/mvc_login/common/js/jquery.mixitup.js"></script>
<!-- Load js -->
<script type="text/javascript" src="http://localhost:8080/mvc_login/common/js/custom.js"></script>

<script type="text/javascript">
$(function(){
	
	//animate : HTML의 요소를 원하는 위치로 이동
	//이동할 위치의 좌표를 얻기위해 offset함수 사용
	//좌표 : $("#about").offset().top,left,bottom, right
	var offset=$("#about").offset();
	//animate : 애니메이션 효과(대상을 이동)
	//animate({옵션:이동할값},속도)
	//alert(offset.top+"/"+offset.left+"/"+offset.bottom+"/"+offset.right)
	$("html,body").animate({scrollTop:offset.top-50},0);
	
	
	var email="${ncData.email}";
	$("#email1").val(email.split("@")[0]);
	$("#email2").val(email.split("@")[1]);
	
	$("#btnUpdate").click(function(){
		if(confirm("명함정보를 수정하시겠습니까?")){
		if($("#dept").val()==""){
			alertCenter("#dept","#deptAlert", "부서명은");
			return;
		}
		if($("#manager").val()==""){
			alertCenter("#manager","#mgrAlert", "담당자 이름은");
			return;
		}
		if($("#addr").val()==""){
			alertCenter("#addr","#addrAlert", "주소는");
			return;
		}
		if($("#email1").val()==""){
			alertCenter("#email1","#emailAlert", "이메일 주소는");
			return;
		}
		if($("#email2").val()==""){
			alertCenter("#email2","#emailAlert", "이메일 주소는");
			return;
		}
		if($("#position").val()==""){
			alertCenter("#position","#positionAlert", "직급");
			return;
		}
		document.frm.action="namecard_modify.do";
		$("[name='cmd']").val("NC_U001");
		$("#frm").submit();
		}
	});
	$("#btnList").click(function(){
		history.back();
	});
	$("#btnReset").click(function(){
		location.reload();
	});
	$("#btnDelete").click(function(){
		if(confirm($("#manager").val()+"님의 명함을 삭제하시겠습니까?")){
			document.frm.action="namecard_remove.do";
			$("[name='cmd']").val("NC_D001");
			$("#frm").submit();
		}
	});
	
});//ready
function alertCenter(id,alertId,msg){
		$(id).focus();
		$(alertId).html(msg+" 필수 입력입니다.");
		$(alertId).css("color","#ff0000");
		$(alertId).fadeOut(300).fadeIn(300).fadeOut(300).fadeIn(300).fadeOut(300).fadeIn(300).fadeOut(300).fadeIn(500).fadeOut(500);
}

</script>
</head>
<!-- Start Body -->
<body>
	<!-- Start Menu -->
	<div class="menubar" data-scroll="true">
		<a href="#" class="logo"></a>
		<ul class="mainmenu">
			<li class="active"><a href="#home">Home</a></li>
			<li><a href="#services">Services</a></li>
			<li><a href="#about">About</a></li>
			<li><a href="#portfolio">Portfolio</a></li>
			<li><a href="#blog">Blog</a></li>
			<li><a href="#contact">Contact</a></li>
		</ul>
	</div>
	<!-- End Menu -->
	
	<!-- Start Home -->
	<a class="scroll" id="home"></a>
	<div class="home hero">
		<div class="overlay"></div>
		<div class="herowrapper">
			<h1>혁신적인 명함관리 <b class="rotate color">어머! 이건 꼭 써야해,거래처,지인,지나가는 사람</b>.</h1>
		</div>
		<a href="javascript:void(0);" class="scrolldown">
			<h3>명함보기</h3>
			<div data-icon="&#xe017;" class="icon"></div>
		</a>
	</div>
	<!-- End Home -->

	<!-- Start BlockQuote -->
	<div class="blockquote main">
		<blockquote>당신의  <b>거래처를</b>혁신적으로 관리할 수 있습니다.</blockquote>
	</div>
	<!-- End BlockQuote -->


	
	<!-- Start Section Divider -->
	<div class="section divider">
		<h2>명 함 추 가</h2>
		<a class="scroll" id="about"></a>
	</div>
	<!-- End Section Divider -->
	
	
	<!-- 명함 입력폼 시작 -->
	<div class="content">
	<form name="frm" id="frm" method="post">
	<!--  enctype이 변경되어 cmd parameter가 전달 되지 못한다. -->
	<input type="hidden" name="cmd"/>
	<input type="hidden" name="nc_num" value="${ncData.ncNum }"/>
	<input type="hidden" name="current_page" value="${param.current_page }"/>
	
	<table border="1">
	<tr>
		<td style="vertical-align: top">
			<img id="img" src="http://localhost:8080/mvc_login/upload/${ncData.comImg }" width="200px"/>	<br/>
		</td>
		<td style="vertical-align: top">
		<table>
		<tr>	
			<td>업체명</td><td><input type="text"  name="company" id="company" style="width:200px;" value="${ncData.company }" readonly="readonly" readonly="readonly"><span id="comAlert"></span></td>
		</tr>
		<tr>	
			<td>부서명</td><td><input type="text" name="dept" id="dept" style="width:200px;" value="${ncData.dept }" readonly="readonly"><span id="deptAlert"></span></td>
		</tr>
		<tr>	
			<td>직급</td><td><input type="text" name="position" id="position" style="width:200px;" value="${ncData.position }"><span id="positionAlert"></span></td>
		</tr>
		<tr>	
			<td>담당자</td><td><input type="text" name="manager" id="manager" style="width:200px;" value="${ncData.manager }" readonly="readonly"><span id="mgrAlert"></span></td>
		</tr>
		<tr>	
			<td>전화번호</td><td>
				<input type="text" name="phone" id="phone" style="width:120px;"value="${ncData.phone }" readonly="readonly"><span id="phoneAlert"></span>
			</td>
		</tr>
		<tr>	
			<td>FAX</td>
			<td>
				<input type="text" name="fax" id="fax" style="width:140px;" value="${ncData.fax }" readonly="readonly"><span id="FAXAlert"></span>
			</td>
		</tr>
		<tr>	
			<td>주소</td>
			<td><input type="text" name="addr" id="addr" style="width:300px;" value="${ncData.addr }" readonly="readonly"><span id="addrAlert"></span></td>
		</tr>
		<tr>	
			<td>이메일</td>
			<td><input type="text" name="email1" id="email1" style="width:150px;" >
			@<input type="text" name="email2" id="email2" style="width:150px;" ><span id="emailAlert"></span></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="button" value="변경" id="btnUpdate"> 
			<input type="button" value="삭제" id="btnDelete"> 
			<input type="button" value="초기화" id="btnReset">
			<input type="button" value="명함목록" id="btnList"> 
			</td>
		</tr>
	</table>
	</td>	
	</tr>
	</table>	
	</form>
	
	</div>
	<!-- 명함 입력폼 끝 -->


	<!-- Start Section Divider -->
	<div class="section divider">
		<h2 id="servicestitle">Our Services</h2>
		<a class="scroll" id="services"></a>
	</div>
	<!-- End Section Divider -->

	<!-- Start Content -->
	<div class="content">

		<!-- Start Main Paragraph -->
		<p class="main dark-gray" id="services">Hover over any of our services to find out more.</p>
		<!-- Start Main Paragraph -->

		<div class="servicesitem">
			<div class="front">
				<div data-icon="&#xe082;" class="icon"></div>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			</div>
			<div class="back">
				<h3>Consulting</h3>
			</div>
		</div>

		<div class="servicesitem">
			<div class="front">
				<div data-icon="&#xe046;" class="icon"></div>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			</div>
			<div class="back">
				<h3>Targeting</h3>
			</div>
		</div>

		<div class="servicesitem">
			<div class="front">
				<div data-icon="&#xe087;" class="icon"></div>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			</div>
			<div class="back">
				<h3>Mobile Apps</h3>
			</div>
		</div>

		<div class="servicesitem">
			<div class="front">
				<div data-icon="&#xe090;" class="icon"></div>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			</div>
			<div class="back">
				<h3>Rockstars</h3>
			</div>
		</div>

		<!-- Clear :) -->
		<div class="clear"></div>
	</div>
	<!-- End Content -->
	

	<footer class="footer">
		<a href="http://sist.co.kr"><h6>© Copyright 2018 | class4</h6></a>
	</footer>

</body>
<!-- End Body -->
</html>