<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main.css">
<!-- CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> 
<script type="text/javascript">

</script>
<!-- summer note 시작 -->

<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>
<script src="../common/summernote/summernote-ko-KR.js"></script>
<script type="text/javascript">
$(function() {
	$(document).ready(function() {
		  $('#summernote').summernote({
			  placeholder: '오늘의 뉴스 입력',
			  height:300,
			  width: 500,
			  lang : 'ko-KR',
			  
		}); //summernote
		});//
	});//ready
</script>

<!-- summer note 끝-->

</head>
<body>
<form action="summer_note_process.jsp" method="post">
<label>작성자</label>
<input type="text" name="writer" class="inputBox"/><br/>
<label>뉴스</label>
<textarea id="summernote" name="news"></textarea><br/>
<input type="submit" value="뉴스작성" class="btn" />
</form>



</body>
</html>