<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MyBatis를 사용한 다양한 조회</title>
<!-- Load CSS -->
<link href="http://localhost:8080/mybatis_prj/common/css/style.css" rel="stylesheet" type="text/css" />
<!-- Load Icon Font -->
<link href="http://localhost:8080/mybatis_prj/common/css/webfont.css" rel="stylesheet" type="text/css" />
<!-- Load jQuery library -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<!-- Load jCarousel js -->
<script type="text/javascript" src="http://localhost:8080/mybatis_prj/common/js/jquery.jcarousel.js"></script>
<!-- Load MixItUup js -->
<script type="text/javascript" src="http://localhost:8080/mybatis_prj/common/js/jquery.mixitup.js"></script>
<!-- Load js -->
<style type="text/css">
.hdate:{ cursor: pointer; }
.hdate:hover{ text-decoration: underline;}

</style>
<script type="text/javascript" src="http://localhost:8080/mybatis_prj/common/js/custom.js"></script>
<script type="text/javascript">
$(function(){
	
	<c:if test="${ not empty param.page }">
		var offset=$('#blog').offset();
		$("html,body").animate({scrollTop: offset.top-80}, 0)
	</c:if>
	/* 
	$('.img').mouseover(function() {
		var img = $(this).text();
		$('#carImg').prop("src","day0907/images/"+img);
	});//click
	 */	
	 
	 $('.hdate').click(function() {
			var date = $(this).text();
			$('#hdate').val(date)
		});//click
	 
});//ready
function viewImg(img){
	$('#carImg').prop("src","day0907/images/"+img);
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
			<h1>MyBatis의 사용 <b class="rotate color">다양한 select쿼리,typeAlias사용,resultMap사용,중복쿼리사용</b>.</h1>
		</div>
		<a href="javascript:void(0);" class="scrolldown">
			<h3>사용</h3>
			<div data-icon="&#xe017;" class="icon"></div>
		</a>
	</div>
	<!-- End Home -->

	<!-- Start BlockQuote -->
	<div class="blockquote main">
		<blockquote>JDBC,DBCP보다 <b>아주 편리한</b> 
			DB Mapper Framework 인 MyBatis를 프로젝트에 도입하세요. (^. ~)</blockquote>
	</div>
	<!-- End BlockQuote -->

	<!-- Start Content -->
	<div class="content">
	<!-- Start Section Divider -->
	<div class="section divider">
		<h2>다양한 select 작업들</h2>
		<a class="scroll" id="blog"></a>
	</div>
	<!-- End Section Divider -->

	<!-- Start Content -->
	<div class="content">
	</div>
		<!-- Start Content -->
		<div class="content sidebar" id="snippets" style="margin-top: 30px">
			<c:if test="${ not empty param.page }">
				<c:import url="${ param.page }.jsp" />
			</c:if>
			<c:if test="${ empty param.page }">
				<img src="common/images/get.png" width="300">
			</c:if>

		</div>
		<!-- End Content -->

		<!-- Start Sidebar -->
		<div id="sidebar" class="sidebar" style="margin-top: -100px">
			
			<div class="widget">
				<h5>작업선택</h5>
				
				<ul>
					<li><h6><b class="light-gray">></b> <a href="use_select_mybatis.jsp?page=day0906/single_column">컬럼 하나 행 하나 조회</a><span class="light-gray"> (4)</span></h6></li>
					<li><h6><b class="light-gray">></b> <a href="use_select_mybatis.jsp?page=day0906/multi_column">컬럼 여러개 행 하나 조회</a><span class="light-gray"> (2)</span></h6></li>
					<li><h6><b class="light-gray">></b> <a href="use_select_mybatis.jsp?page=day0906/single_row">컬럼 하나 행 여러개 조회</a><span class="light-gray"> (6)</span></h6></li>
					<li><h6><b class="light-gray">></b> <a href="use_select_mybatis.jsp?page=day0906/multi_row">컬럼 여러개 행 여러개 조회</a><span class="light-gray"> (1)</span></h6></li>
					<li><h6><b class="light-gray">></b> <a href="use_select_mybatis.jsp?page=day0906/greaterthan">&gt;의 조회</a><span class="light-gray"> (2)</span></h6></li>
					<li><h6><b class="light-gray">></b> <a href="use_select_mybatis.jsp?page=day0906/lessthan">&lt;의 조회</a><span class="light-gray"> (7)</span></h6></li>
					<li><h6><b class="light-gray">></b> <a href="use_select_mybatis.jsp?page=day0906/like">like의 조회 </a><span class="light-gray"> (1)</span></h6></li>
					<li><h6><b class="light-gray">></b> <a href="use_select_mybatis.jsp?page=day0907/dynamic_tab">동적인 테이블의 조회 </a><span class="light-gray"> (1)</span></h6></li>
					<li><h6><b class="light-gray">></b> <a href="use_select_mybatis.jsp?page=day0907/subquery">subquery</a><span class="light-gray"> (1)</span></h6></li>
					<li><h6><b class="light-gray">></b> <a href="use_select_mybatis.jsp?page=day0907/union">union</a><span class="light-gray"> (1)</span></h6></li>
					<li><h6><b class="light-gray">></b> <a href="use_select_mybatis.jsp?page=day0907/join">join</a><span class="light-gray"> (1)</span></h6></li>
					<li><h6><b class="light-gray">></b> <a href="use_select_mybatis.jsp?page=day0907/join_subquery">join+subquery</a><span class="light-gray"> (1)</span></h6></li>
					<li><h6><b class="light-gray">></b> <a href="use_select_mybatis.jsp?page=day0910/dynamic_if">dynamic query (if)</a><span class="light-gray"> (1)</span></h6></li>
					<li><h6><b class="light-gray">></b> <a href="use_select_mybatis.jsp?page=day0911/dynamic_set">dynamic query (set)</a><span class="light-gray"> (1)</span></h6></li>
					<li><h6><b class="light-gray">></b> <a href="use_select_mybatis.jsp?page=day0911/dynamic_choose">dynamic query (choose)</a><span class="light-gray"> (1)</span></h6></li>
					<li><h6><b class="light-gray">></b> <a href="use_select_mybatis.jsp?page=day0911/dynamic_foreach">dynamic query (forEach)</a><span class="light-gray"> (1)</span></h6></li>
					<li><h6><b class="light-gray">></b> <a href="use_select_mybatis.jsp?page=day0911/procedure_insert">procedure insert</a><span class="light-gray"> (1)</span></h6></li>
					<li><h6><b class="light-gray">></b> <a href="use_select_mybatis.jsp?page=day0912/procedure_select">procedure select</a><span class="light-gray"> (1)</span></h6></li>
				</ul>
			</div>

	</div>
		<div class="clear"></div>
	</div>
	<!-- End Content -->
	
	<footer class="footer">
		<a href="http://sist.co.kr"><h6>© Copyright 2018 | class4</h6></a>
	</footer>

</body>
<!-- End Body -->
</html>