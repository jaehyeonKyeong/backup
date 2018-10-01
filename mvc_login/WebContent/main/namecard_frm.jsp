<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>명함관리</title>
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
	
	
	$("#file").change(function(){
		var fileName=$("#file").val();
		var ext_arr=["jpg","gif","png","bmp","jpeg"];
		var selectExt=fileName.split(".")[fileName.split(".").length-1].toLowerCase();
		var flag=false;

		$.each(ext_arr,function(i,ext){
			if(selectExt ==ext){
				flag=true;
			}//end if
		});//each
		if(!flag){//업로드가능 확장자가 아닐 때 
			alert("업로드는 이미지만 가능합니다.\n확장자는 jpg,gif,png,bmp,jpeg만 가능합니다.");
		return;
		}//end if
		//미리보기 이미지는 서버에 존재 해야한다.
		//$("#img").prop("src","");
		//var img=document.getElementById('img');
		//img.src=URL.createObjectURL(event.target.files[0]);
		//createObjectURL : file의 경로를 URL형태로 변경하는 일
		$('#img').prop("src",URL.createObjectURL(event.target.files[0]));
	});//change
	$("#btnAdd").click(function(){
		if($("#company").val()==""){
			alertCenter("#company","#comAlert", "아이디는");
			return;
		}
		if($("#dept").val()==""){
			alertCenter("#dept","#deptAlert", "부서명은");
			return;
		}
		if($("#manager").val()==""){
			alertCenter("#manager","#mgrAlert", "담당자 이름은");
			return;
		}
		if($("#phone2").val()==""){
			alertCenter("#phone2","#phoneAlert", "전화번호는");
			return;
		}
		if( $("#phone3").val()==""){
			alertCenter("#phone3","#phoneAlert", "전화번호는");
			return;
		}
		if($("#fax1").val()==""){
			alertCenter("#fax1","#FAXAlert", "FAX번호는");
			return;
		}
		if($("#fax2").val()==""){
			alertCenter("#fax2","#FAXAlert", "FAX번호는");
			return;
		}
		if($("#fax3").val()==""){
			alertCenter("#fax3","#FAXAlert", "FAX번호는");
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
		$("form").submit();
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
	<form enctype="multipart/form-data" method="post" action="add_nc_process.do?cmd=NC_I002">
	<!--  enctype이 변경되어 cmd parameter가 전달 되지 못한다. -->
	<!-- <input type="hidden" name="cmd" value="NC_I002"/> -->
	
	<table border="1">
	<tr>
		<td style="vertical-align: top">
			<img id="img" src="http://localhost:8080/mvc_login/common/img/placeholder_large3.jpg" width="200px"/>	<br/>
			<input type="file" name="file" value="이미지선택" style="width: 200px" id="file">
			
		</td>
		<td style="vertical-align: top">
		<table>
		<tr>	
			<td>업체명</td><td><input type="text" name="company" id="company" style="width:200px;"><span id="comAlert"></span></td>
		</tr>
		<tr>	
			<td>부서명</td><td><input type="text" name="dept" id="dept" style="width:200px;"><span id="deptAlert"></span></td>
		</tr>
		<tr>	
			<td>직급</td><td><input type="text" name="position" id="position" style="width:200px;"><span id="positionAlert"></span></td>
		</tr>
		<tr>	
			<td>담당자</td><td><input type="text" name="manager" id="manager" style="width:200px;"><span id="mgrAlert"></span></td>
		</tr>
		<tr>	
			<td>전화번호</td><td><select name="phone1" style="line-height: 25px; font-size:15px;border:1px solid #6093e7; margin-bottom:20px;height:28px;">
				<option selected="selected">010</option>
				<option>011</option>
				<option>017</option>
				<option>018</option>
				<option>019</option>
				</select>-<input type="text" name="phone2" id="phone2" style="width:40px;" maxlength="4">-
				<input type="text" name="phone3" id="phone3" style="width:40px;" maxlength="4"><span id="phoneAlert"></span>
			</td>
		</tr>
		<tr>	
			<td>FAX</td>
			<td>
				<input type="text" name="fax1" id="fax1" style="width:40px;" maxlength="4">-
				<input type="text" name="fax2" id="fax2" style="width:40px;" maxlength="4">-
				<input type="text" name="fax3" id="fax3" style="width:40px;" maxlength="4"><span id="FAXAlert"></span>
			</td>
		</tr>
		<tr>	
			<td>주소</td>
			<td><input type="text" name="addr" id="addr" style="width:300px;"><span id="addrAlert"></span></td>
		</tr>
		<tr>	
			<td>이메일</td>
			<td><input type="text" name="email1" id="email1" style="width:150px;">@<input type="text" name="email2"id="email2"  style="width:200px;"><span id="emailAlert"></span></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="button" value="추가" id="btnAdd"> 
			<input type="reset" value="초기화">
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