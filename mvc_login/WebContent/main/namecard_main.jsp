<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>명함관리</title>
<!-- Load CSS -->
<link href="http://localhost:8080/mvc_login/common/css/style.css"
	rel="stylesheet" type="text/css" />
<!-- Load Icon Font -->
<link href="http://localhost:8080/mvc_login/common/css/webfont.css"
	rel="stylesheet" type="text/css" />
<!-- Load jQuery library -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<!-- Load jCarousel js -->
<script type="text/javascript"
	src="http://localhost:8080/mvc_login/common/js/jquery.jcarousel.js"></script>
<!-- Load MixItUup js -->
<script type="text/javascript"
	src="http://localhost:8080/mvc_login/common/js/jquery.mixitup.js"></script>
<!-- Load js -->
<script type="text/javascript"
	src="http://localhost:8080/mvc_login/common/js/custom.js"></script>
</head>
<c:if test="${not empty param.current_page or param.cmd eq 'NC_M001' }">
	<script type="text/javascript">
		$(function() {
			//animate : HTML의 요소를 원하는 위치로 이동
			//이동할 위치의 좌표를 얻기위해 offset함수 사용
			//좌표 : $("#about").offset().top,left,bottom, right
			var offset = $("#about").offset();
			//animate : 애니메이션 효과(대상을 이동)
			//animate({옵션:이동할값},속도)
			//alert(offset.top+"/"+offset.left+"/"+offset.bottom+"/"+offset.right)
			$("html,body").animate({
				scrollTop : offset.top - 50
			}, 0);
		});
	</script>
</c:if>
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
			<h1>
				혁신적인 명함관리 <b class="rotate color">어머! 이건 꼭 써야해,거래처,지인,지나가는 사람</b>.
			</h1>
		</div>
		<a href="javascript:void(0);" class="scrolldown">
			<h3>명함보기</h3>
			<div data-icon="&#xe017;" class="icon"></div>
		</a>
	</div>
	<!-- End Home -->

	<!-- Start BlockQuote -->
	<div class="blockquote main">
		<blockquote>
			당신의 <b>거래처를</b>혁신적으로 관리할 수 있습니다.
		</blockquote>
	</div>
	<!-- End BlockQuote -->



	<!-- Start Section Divider -->
	<div class="section divider">
		<h2>보유 명함 리스트</h2>
		<a class="scroll" id="about"></a>
	</div>
	<!-- End Section Divider -->


	<!-- 명함 리스트 시작  -->
	<div class="content">
		<div style="height: 290px;">
			<table
				style="margin: 0px auto; border-top: 2px solid #6093e7; border-spacing: 0px">
				<thead>
					<tr style="height: 30px;">
						<th
							style="width: 60px; border-bottom: 1px solid #6093e7; vertical-align: middle">번호</th>
						<th
							style="width: 300px; border-bottom: 1px solid #6093e7; vertical-align: middle">업체명</th>
						<th
							style="width: 120px; border-bottom: 1px solid #6093e7; vertical-align: middle">담당자</th>
						<th
							style="width: 150px; border-bottom: 1px solid #6093e7; vertical-align: middle">부서</th>
						<th
							style="width: 180px; border-bottom: 1px solid #6093e7; vertical-align: middle">입력일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="nv" items="${nameList}">
						<c:set var="i" value="${i+1}" />
						<tr style="height: 30px">
							<td
								style="border-bottom: 1px solid #6093e7; vertical-align: middle; text-align: center"><c:out
									value="${i}" /></td>
							<td
								style="font-size: 16px; font-color: #333; border-bottom: 1px solid #6093e7; vertical-align: middle; text-align: center"><a
								href="nc_detail.do?cmd=NC_S001&nc_num=${nv.ncNum }&current_page=${empty param.current_page?1:param.current_page}">
									<c:out value="${nv.company}" />
							</a></td>
							<td
								style="border-bottom: 1px solid #6093e7; vertical-align: middle; text-align: center"><c:out
									value="${nv.manager}" /></td>
							<td
								style="border-bottom: 1px solid #6093e7; vertical-align: middle; text-align: center"><c:out
									value="${nv.dept}" /></td>
							<td
								style="border-bottom: 1px solid #6093e7; vertical-align: middle; text-align: center"><c:out
									value="${nv.inputDate}" /></td>
						</tr>
					</c:forEach>
					<c:if test="${empty nameList}">
						<tr>
							<td colspan="5"
								style="text-align: center; border-bottom: 1px solid #6093e7;">
								등록된 명함이 없습니다.<br /> <a href="nc_add.do?cmd=NC_I001"
								style="text-align: right">명함등록</a>
							</td>
						</tr>
					</c:if>
				</tbody>
			</table>
			<div style="margin-top: 10px; text-align: center;">
				${nameIndexList}</div>
			<a href="nc_add.do?cmd=NC_I001" style="text-align: center;">명함등록</a>
		</div>

	</div>
	<!-- 명함 리스트 끝 -->


	<!-- Start Content -->
	<div class="content">

		<!-- Start Person Block -->
		<div class="person">
			<div class="image quotefade">
				<img src="http://localhost:8080/mvc_login/common/img/person.jpg">
				<div class="quotehover">
					<h5>“You have to do something you’ve never done to have
						something you’ve never had.”</h5>
					<h6>Elizabeth Franklin</h6>
				</div>
			</div>
			<div class="info">
				<h2>John Doe</h2>
				<h4 class="light-gray">CEO</h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
					enim ad minim veniam, quis nostrud exercitation ullamco laboris
					nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
					reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
					pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
					culpa qui officia deserunt mollit anim id est laborum.</p>
				<a href="#" class="socialicon linkedin"></a> <a href="#"
					class="socialicon facebook"></a> <a href="#"
					class="socialicon twitter"></a> <a href="#"
					class="socialicon dribbble"></a> <a href="#"
					class="socialicon pinterest"></a>
			</div>
		</div>
		<!-- Clear :) -->
		<div class="clear"></div>
		<!-- End Person Block -->
	</div>
	<!-- End Content -->
	<!-- Start Section Divider -->
	<div class="section divider">
		<h2 id="servicestitle">Our Services</h2>
		<a class="scroll" id="services"></a>
	</div>
	<!-- End Section Divider -->

	<!-- Start Content -->
	<div class="content">

		<!-- Start Main Paragraph -->
		<p class="main dark-gray" id="services">Hover over any of our
			services to find out more.</p>
		<!-- Start Main Paragraph -->

		<div class="servicesitem">
			<div class="front">
				<div data-icon="&#xe082;" class="icon"></div>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			</div>
			<div class="back">
				<h3>Consulting</h3>
			</div>
		</div>

		<div class="servicesitem">
			<div class="front">
				<div data-icon="&#xe046;" class="icon"></div>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			</div>
			<div class="back">
				<h3>Targeting</h3>
			</div>
		</div>

		<div class="servicesitem">
			<div class="front">
				<div data-icon="&#xe087;" class="icon"></div>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			</div>
			<div class="back">
				<h3>Mobile Apps</h3>
			</div>
		</div>

		<div class="servicesitem">
			<div class="front">
				<div data-icon="&#xe090;" class="icon"></div>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
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