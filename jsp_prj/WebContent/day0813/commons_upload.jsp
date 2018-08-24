<%@page import="org.apache.commons.fileupload.FileUploadBase"%>
<%@page import="kr.co.sist.util.HangulConv"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
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
				//enctype="multipart/form-data"이므로 기존의 parameter로는 처리할수 없다.
				//String name=request.getParameter("uploader");

				//request.setCharacterEncoding("UTF-8"); //multipart/form에서는 사용할 수 없다.
				//파일 업로드에 적합한 요청인지 판별
				//Form컨트롤의  한글처리는 안되나  파일명의 한글 처리는 된다.
				request.setCharacterEncoding("UTF-8");
				boolean isMultipart = ServletFileUpload.isMultipartContent(request);

				pageContext.setAttribute("isMultipart", isMultipart);
			%>
			<c:choose>
				<c:when test="${isMultipart }">
					<%
						// DiskFileItemFactory:업로드된 파일을 제어하고 저장하기 위해 사용하는 class 
								DiskFileItemFactory factory = new DiskFileItemFactory();

								// 저장객체의 설정
								// 저장파일을 메모리에 분할 저장하는 크기(한계치)
								// Byte*KByte*MByte
								int threshold = 1024 * 1024 * 1;//메모리에 1MByte씩 저장
								factory.setSizeThreshold(threshold);

								//업로드 된 파일이 저장될 경로
								File repository = new File("C:/dev/workspace/jsp_prj/WebContent/upload/");
								factory.setRepository(repository);

								// ServletFileUpload : HTML Form Control을 사용할 수 있는 class
								ServletFileUpload upload = new ServletFileUpload(factory);

								// 업로드하는 파일의 최대크기 설정
								int maxSize = 1024 * 1024 * 5;
								upload.setSizeMax(maxSize);

								// HTML Form Control의 값을 얻기 위해
								// Form Control을 FileItem 객체에 할당하여 List로 받는다.
								String uploader = "", age = "", fileName = "";
								try{
								List<FileItem> items = upload.parseRequest(request);

								// 리스트에 저장된 HTML Form Control의 처리
								Iterator<FileItem> iter = items.iterator();
								while (iter.hasNext()) {
									FileItem item = iter.next();

									if (item.isFormField()) {
										//out.println("일반 컨트롤"); //<input>,<select>,<textarea>;
										String name = item.getFieldName();//Form Control명
										String value = item.getString();//Form Control값
										if ("uploader".equals(name)) {
											uploader = value;
										}
										if ("age".equals(name)) {
											age = value;
										}
										//out.println("Form Control Name :"+name);
										//out.println("Form Control Value:"+value);
									} else {
										//out.println("파일 컨트롤"); //<input type="file">인것을 뜻한다.;
										//String fieldName = item.getFieldName();//폼컨트롤명
										fileName = item.getName();//선택한 파일명
										
										//저장될 경로와 업로드한 파일명이 결합되어
										File uploadedFile = new File(repository.getAbsolutePath()+"/"+fileName);
										//파일을 생성한다
									    item.write(uploadedFile);
										
										//  String contentType = item.getContentType();
										//boolean isInMemory = item.isInMemory();//최대크기 안에 포함
										// long sizeInBytes = item.getSize();//파일의 크기
										//out.println("컨트롤명"+fieldName+"/선택파일명 : "+fileName+", contentType:"+contentType+", 설정크기내:"+isInMemory+"/파일크기 : "+sizeInBytes);
									}
								}
					%>
					업로드 성공<br>
					업로더 : <%=HangulConv.toUTF(uploader)%><br>
					연령대 : <%=HangulConv.toUTF(age)%><br>
					file명 : <%=fileName %><br>
					<a href="commons_file_upload_frm.jsp">업로드폼</a><br>
					<a href="../day0814/file_list.jsp">파일 목록</a><br>
					<%}catch(FileUploadBase.SizeLimitExceededException slee){
						
						out.println("파일 크기 초과");
						slee.printStackTrace();
					}
						%>
				</c:when>
				<c:otherwise>
					<!-- 파일 업로드 수행에 부적합한 요청 이 페이지를 직접 요청했거나, enctype="multipart/form-data"가 아닌경우  -->
					<c:redirect url="file_upload_form.jsp" />
				</c:otherwise>
			</c:choose>
		</div>
		<div id="footer">Copyright&copy; class4 All Right Reserved.</div>
	</div>
</body>
</html>



