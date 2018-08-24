<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	$(".btn").click(function() {
		if($("#uploader").val()==""){
			alert("업로더 명을 입력하세요");
			$("#uploader").focus();
			return;
			
		}
		if($("#upfile").val()==""){
			alert("파일을 선택하세요");
			return;
		}
		
		//upload가능 확장자 설정(이미지만)
		var extArr=["jpg","png","gif","bmp","jpeg"];
		
		var tempFile=$("#upfile").val().split(".");
		var ext=tempFile[tempFile.length-1].toLowerCase();
		var flag=false;
		for(var i=0;i<extArr.length; i++){
			if(extArr[i]==ext){
				flag=true;
			}
		}
		/* 
		if( !flag ){
			alert("확장자가 jpg,png,gif,bmp,jpeg만 업로드 가능합니다.");
			return;
		}//end if
		 */
		
		$("#frm").submit();
		
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
			
#tab{ border-top: 2px solid #5B7CE5;border-spacing: 0px; margin: 0px auto }
#numTitle{ width:60px }
#subjectTitle{ width:350px }
#writerTitle{ width:100px }
#evtTitle{ width:200px }
#inputTitle{ width:120px }
#cntTitle{ width:60px }
				
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
		<div>
			<div style="font-size:25px;font-weight:bold">파일 업로드</div>
			<div>
			<form action="mr_upload.jsp" name="frm" id="frm" method="post" enctype="multipart/form-data">
			<!-- RFC1867: Html Form기반의 파일 업로드는 method=post,enctype=multipart/form-data로 설정되어야 한다
				enctype이 multipart/form-data인 경우에는 jsp에서 parameter값을 받을 수 없다.
			 -->
			
				<table>
					<tr>
						<td>업로더</td>
						<td><input type="text" id="uploader" name="uploader" class="inputBox"/></td>
					</tr>
					<tr>
					<td>나이</td>
					<td>
						<select id="age" name="age">
							<c:forEach var="cnt" begin="10" end="70" step="10">
								<option value="${cnt }"><c:out value="${cnt}"/></option>							
							</c:forEach>
						</select>
					</td>
					</tr>
					<tr>
						<td>파일1</td>
						<td>
						<input type="file" id="upfile" name="upfile" class="inputBox"/>
						</td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="button" value="업로드" class="btn"/>
						</td>
					</tr>
				</table>
				</form>
				<a href="../day0814/file_list.jsp">파일목록</a>
			</div>
		</div>
		</div>
		<div id="footer">
			Copyright&copy; class4 All Right Reserved.
		</div>
	</div>
</body>
</html>



    