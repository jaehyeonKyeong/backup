<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="day0814.TempFileVO"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main.css"/>
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
			
			
#numTitle{width:80px;}
#nameTitle{width:300px;}
#modifyTitle{width:150px;}
#sizeTitle{width:120px;}

table{margin:0px auto}
th{ border-bottom: 1px solid #E7E7E7; height:25px;
		background-color:  #EAE9F7 ;color:#545454 }
td{  border-bottom: 1px solid #E7E7E7; text-align: center;height: 25px }
tr:hover{ background-color:  #EAE9F7 ; }	
</style>
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
		
		<%
			File[] fileList=new File("C:/dev/workspace/jsp_prj/WebContent/upload/").listFiles();
			List<TempFileVO> list=new ArrayList<TempFileVO>();
			if(fileList!=null){
				for(File temp:fileList){
					list.add(new TempFileVO(temp.getName(),new Date(temp.lastModified()),temp.length()));
				}
			}
			
		
			pageContext.setAttribute("file_list", list); //${}에서 사용하려면 scope객체에 넣어야한다.
		%>
		<table>
		
			<thead>
				<tr>
					<th id="numTitle">번호</th>
					<th id="nameTitle">파일 명</th>
					<th id="modifyTitle">업로드된 날짜</th>
					<th id="sizeTitle">크기</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty file_list}">
					<tr>
						<td colspan="4">업로드한 파일이 없습니다.<br><a href="../day0813/commons_file_upload_frm.jsp">Commons 업로드폼</a><br><a href="../day0813/mr_file_upload_frm.jsp">Multipart 업로드폼</a></td>
					</tr>
				</c:if>
				<c:forEach var="file" items="${file_list }">
				<c:set var="i" value="${i+1 }"/>
					<tr>
						<td><c:out value="${i }"/></td>
						
						<td>
						<a href="download.jsp?file_name=${file.fileName }">
						<!-- 브라우저에서 해석할수 있는것은 브라우저에서 바로 보여지지만, 해석하지 못하는 것은 브라우저에서 다운로드 된다. -->
							<c:out value="${file.fileName }"/>
						</a>
						</td>
						<%-- ※EL에서 getter가 아닌 method는 method기호()를 붙여서 호출 할 수는 있지만 Linux에서는 error가 발생한다. --%>
						<td><fmt:formatDate pattern="yyyy-MM-dd a HH:mm" value="${file.lastModified }"/></td>
						<td><fmt:formatNumber pattern="#,###" value="${file.fileSize}"/>Byte</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		</div>
		<div id="footer">
			Copyright&copy; class4 All Right Reserved.
		</div>
	</div>
</body>
</html>



    