<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/spring_mvc_template/common/css/main.css">
<!-- CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#post").click(function() {
		document.frm.action="get_post.do";
		$("[method='post']").submit();
	});//click
	
	$("#btn").click(function() {
		var color=$("#color").val();
		$.ajax({
			url:"day0920/use_jsp.do",
			data:"color="+color,
			type:"GET",
			dataType:"json",
			error:function( xhr ){
				alert(xhr.status +"/" + xhr.statusText);
			},
			success:function(json){
				var output ="<strong>"+$("#name").val()+"</strong>님 께서 선택하신 색은 " +$("#color").val()+"이고<br/> 색의 의미는 : ["
				+json.selectColor+"] 입니다. <br/> 처리된 시간 : " + json.time;
				$("#result").html(output);
			}//success
		});//ajax
	});//click
	
	
	
	$.ajax({
		url:"day0921/use_response_body.do",
		type:"GET",
		dataType:"json",
		error:function(xhr){
			console.log(xhr.status+"/"+xhr.statusText);
		},
		success:function(json){
			//decodeURI -> 문자열을 decoding하여 보여주는 일
			var output="이름 : "+decodeURI(json.name)+"<br>수강과목 :";
			$.each(json.subject_arr,function(i,subject_json){
				output+=subject_json.subject+" ";
			});
			$("#response_body").html(output);
		}
		
	})
	
	
}); // ready
</script>
</head>
<body>
	안녕 Spring MVC!<br/>
	<ul>
		<li><a href="get.do">GET의 요청</a></li>
		<li><form method="post" name="frm" action="post.do">
			<input type="submit" value="POST의 요청"></form></li>
		<li><a href="get_post.do">GET요청</a>
			  <a href="#void" id="post">POST요청</a></li>
		<li>
			<a href="day0919/a.do">다양한 URL을 하나의 method 처리 a.do</a>
			<a href="day0919/b.do">다양한 URL을 하나의 method 처리 b.do</a>
			<a href="day0919/c.do">다양한 URL을 하나의 method 처리 c.do</a>
			<a href="day0919/yana.do">다양한 URL을 하나의 method 처리 <span style="text-shadow: 2px 2px #333;"> yana.do </span></a>
		</li>
		<li>
			<a href="day0917/sub_dir.do">하위 경로 요청</a>
		</li>
		<li>
			<a href="redirect_html.do">HTML로 이동</a>
		</li>
		<li>
			<a href="redirect_jsp.do">JSP로 이동</a>
		</li>
		<li>
			<a href="use_request.do">RequestForm이동</a>
		</li>
		<li>
			<a href="use_param.do">각각의 변수 사용 이동</a>
		</li>
		<li>
			<a href="use_vo.do">VO 사용 이동</a>
		</li>
		<li>
			<a href="day0919/use_request.do">HttpServletRequest를 사용한 값 전달</a>
		</li>
		<li>
			<a href="day0919/use_model.do">Model을 사용한 값 전달</a>
		</li>
		<li>
			<a href="day0919/use_mav.do">ModelAndView를 사용한 값 전달</a>
		</li>
		<li>
			<a href="day0919/use_session.do">HttpSession사용 값 전달 이동</a>
		</li>
		<li>
			<a href="day0919/use_session_attr.do">SessionAttribute 사용 값 전달 이동</a>
		</li>
		<li>
			<a href="day0920/remove_session.do">세숀삭제</a>
		</li>
		<li>
			<a href="day0920/include_jsp.do">인끄루드</a>
		</li>
		<li>
			<a href="day0920/do_include.do">do_include</a>
		</li>
		<li>
			<a href="day0920/exception.do">Exception Handling</a>
		</li>
		<li>
			<div>
				<label>이름</label>
				<input type="text" name="name" id="name" class="inputBox"/><br/>
				<select id="color">
					<option value="빨강">빨강</option>
					<option value="노랑">노랑</option>
					<option value="초록">초록</option>
					<option value="파랑">파랑</option>
					<option value="보라">보라</option>
					<option value="분홍">분홍</option>
				</select>
				<input type="button" value="조회" class="inputBox" id="btn"/>
			</div> 
			<div id="result"></div>
		</li>
		<li>
			<div id="response_body"></div>
		</li>
		<li>
			<a href="day0921/forward_a.do?exe_file=calc">forward A chain(계산기)</a>
			<a href="day0921/forward_a.do?exe_file=notepad">forward A chain(메모장)</a>
			<a href="day0921/forward_b.do">forward B chain</a>
		</li>
		<li>
			<a href="day0921/add_cookie.do">쿠키 심기</a>
			<a href="day0921/read_cooke.do">쿠키 읽기</a>
		</li>
	</ul>
</body>
</html>