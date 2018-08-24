<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main.css">
<!--CDN-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> 
<script type="text/javascript">
$(function(){
	$("#week").change(function(){
		if($("#week").val()!="none"){
			if(confirm("요일의 메세지를 확인하시겠습니까?")){
				$("#frm").submit();
			}//end if
		}//end if
	});//change
});//ready
</script>

</head>
<body>
<!-- 요일별 이미지 출력 -->
	<div>
	<img src="images/title.png"/><br/>
		<form action="jstl_choose.jsp" method="get" name="frm" id="frm">
			<select id="week" name="week">
				<option value="none">요일 선택</option>
				<option value="sun">일</option>
				<option value="mon">월</option>
				<option value="tue">화</option>
				<option value="wed">수</option>
				<option value="thu">목</option>
				<option value="fri">금</option>
				<option value="sat">토</option>
			</select>
		</form>
	</div>
	
	<div>
		<c:if test="${not empty param.week and param.week ne 'none'}">
			<%-- <img src="images/${param.week }.png"/> --%>
			<c:choose>
				<c:when test="${ param.week eq 'sun'}">
					<img src="images/sun.png" title="일요일은 짜파게티"/>
				</c:when>
				<c:when test="${ param.week eq 'mon'}">
					<img src="images/mon.png" title="월요일은 김치볶음밥"/>
				</c:when>
				<c:when test="${ param.week eq 'tue'}">
					<img src="images/tue.png" title="화요일은 돈가스"/>
				</c:when>
				<c:when test="${ param.week eq 'wed'}">
					<img src="images/wed.png" title="수요일은 46cm 제주 피자"/>
				</c:when>
				<c:when test="${ param.week eq 'thu'}">
					<img src="images/thu.png" title="목요일은 짜파게티"/>
				</c:when>
				<c:when test="${ param.week eq 'fri'}">
					<img src="images/fri.png" title="금요일은 수진이의 김치볶음밥"/>
				</c:when>
				<c:otherwise>
					<img src="images/sat.png" title="토요일은 집밥"/>
				</c:otherwise>
			</c:choose>
		</c:if>
	</div>
</body>
</html>