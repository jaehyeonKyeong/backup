<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- SmartMenus core CSS (required) -->
<link href="http://211.63.89.135:8080/jsp_prj/common/js/smart/css/sm-core-css.css" rel="stylesheet" type="text/css" />
<link href="http://211.63.89.135:8080/jsp_prj/common/js/smart/css/sm-simple/sm-simple.css" rel="stylesheet" type="text/css" />
<!-- SmartMenus jQuery plugin -->
<script type="text/javascript" src="http://211.63.89.135:8080/jsp_prj/common/js/smart/jquery.smartmenus.min.js"></script>
<script type="text/javascript">
$(function() {
		$('#main-menu').smartmenus({
			subMenusSubOffsetX : 1,
			subMenusSubOffsetY : -8
		});//smart menus
});//ready
</script>
<nav id="main-nav">
					<!-- Sample menu definition -->
					<ul id="main-menu" class="sm sm-simple">
						<li><a href="#/">Home</a></li>
						<li><a href="#">파라메터 연습</a>
							<ul>
								<li><a href="">이름이 유일할 때</a></li>
								<li><a href="">이름이 중복될 때</a></li>
								<li><a href="#" class="disabled">사용불가</a></li>
							</ul></li>
						<li><a href="why_session_a.html">세션이 필요한이유</a></li>
						<li><a href="#">지원</a>
							<ul>
								<li><a href="#">빛동희</a></li>
								<li><a href="#">갓대현</a></li>
							</ul></li>
						<li><a href="#">4강의장에 대해서</a>
							<ul class="mega-menu">
								<li>
									<!-- The mega drop down contents -->
									<div style="width: 400px; max-width: 100%;">
										<div style="padding: 5px 24px;">
											<p>Servlet과 JSP를 만드는 목적 : 동적으로 HTML을 생성하기 위해서</p>
										</div>
									</div>
								</li>
							</ul></li>
					</ul>
				</nav>