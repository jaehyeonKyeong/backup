<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/jsp_prj/common/css/main.css" />
<!--  CDN -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- SmartMenus core CSS (required) -->
<link href="../common/js/smart/css/sm-core-css.css" rel="stylesheet"
	type="text/css" />
<link href="../common/js/smart/css/sm-simple/sm-simple.css"
	rel="stylesheet" type="text/css" />
<!-- SmartMenus jQuery plugin -->
<script type="text/javascript"
	src="../common/js/smart/jquery.smartmenus.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#main-menu').smartmenus({
			subMenusSubOffsetX : 1,
			subMenusSubOffsetY : -8
		}); //smartmenus


	}); //ready
</script>
<style type="text/css">
#wrap {
	width: 1024px;
	height: 1000px;
	margin: 0px auto
}

#header {
	height: 150px
}

#headerTop {
	height: 75px;
	font-family: 고딕;
	font-size: 30px;
	text-align: center;
	font-weight: bold;
	padding-top: 25px;
	background: #FFF url(../common/images/header_bg.png)
}

#navi {
	height: 500px
}

#container {
	height: 750px
}

#footer {
	height: 60px;
	background: #FFF url(../common/images/footer_bg.png);
	font-size: 16px;
	font-weight: bold;
	text-align: right;
	padding-right: 30px;
	padding-top: 40px;
	width: 994px;
}

#tab {
	border-top: 2px solid #5B7CE5;
	border-spacing: 0px;
	margin: 0px auto
}

#numTitle {
	width: 60px
}

#subjectTitle {
	width: 350px
}

#writerTitle {
	width: 100px
}

#evtTitle {
	width: 200px
}

#inputTitle {
	width: 120px
}

#cntTitle {
	width: 60px
}

th {
	border-bottom: 1px solid #E7E7E7;
	height: 25px;
	background-color: #EAE9F7;
	color: #545454
}

td {
	border-bottom: 1px solid #E7E7E7;
	text-align: center;
	height: 25px
}

tr:hover {
	background-color: #EAE9F7;
}
</style>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<div id="headerTop">일 정 관 리 시 스 템</div>
			<div id="navi">
				<c:import url="../common/jsp/diary_menu.jsp" />
			</div>
		</div>
		<div id="container">
		<%
		request.setCharacterEncoding("UTF-8");
			//1.파일 업로드 객체 생성
			String repository="c:/dev/workspace/jsp_prj/WebContent/upload/";
			int maxSize=1024*1024*10;
			MultipartRequest mr=new MultipartRequest(request,repository,maxSize,"UTF-8",new DefaultFileRenamePolicy());
		%>
		업로더 : <%= mr.getParameter("uploader") %><br>
		나이 : <%= mr.getParameter("age") %><br>
		파일명 원본명 : <%= mr.getOriginalFileName("upfile") %><br>
		파일명 변경명: <%= mr.getFilesystemName("upfile") %><br>
		<a href="mr_file_upload_frm.jsp">업로드폼</a>
		<a href="file_list.jsp">리스트 보기</a>
		
		</div>
		<div id="footer">Copyright&copy; class4 All Right Reserved.</div>
	</div>
</body>
</html>



