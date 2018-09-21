<%@page import="day0827.CarVO"%>
<%@page import="java.util.List"%>
<%@page import="day0827.CarDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	
	String country=request.getParameter("country");
	String maker=request.getParameter("maker");
	String model=request.getParameter("model");
	String jobFlag=request.getParameter("jobFlag");
	
	CarDAO  c_dao=CarDAO.getinstance();
	
	if("1".equals(jobFlag)){
	List<String> maker_list=c_dao.selectMarker(country);
	pageContext.setAttribute("maker_list",maker_list);
	pageContext.setAttribute("model_list",null);
	}
	
	if("2".equals(jobFlag)){
	List<String> maker_list=c_dao.selectMarker(country);
	pageContext.setAttribute("maker_list",maker_list);
	List<String> model_list=c_dao.selectModel(maker);
	pageContext.setAttribute("model_list",model_list);
	pageContext.setAttribute("car_list",null);
	}
	
	if("3".equals(jobFlag)){
	List<String> model_list=c_dao.selectModel(maker);
	pageContext.setAttribute("model_list",model_list);
	List<String> maker_list=c_dao.selectMarker(country);
	pageContext.setAttribute("maker_list",maker_list);
	List<CarVO> car_list=c_dao.selectCar(model);
	pageContext.setAttribute("car_list",car_list);
	}		
	
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/jsp_prj/common/css/main.css">
<!-- CDN -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
function sendCountry(){//제조국
	sendRequest(1)
}
function sendMaker(){//제조사
	sendRequest(2)
}
function sendModel(){
	sendRequest(3)
}
function sendRequest(pageFlag){
	var obj=document.carFrm;
	var flag=false;
	if(pageFlag==1){
		flag=obj.country.selectIndex!= 0; 
	}
	if(pageFlag==2){//제조사
		flag=obj.maker.selectIndex!= 0; 
	}
	if(pageFlag==3){//모델 선택후 상세조회
		flag=obj.model.selectIndex!= 0; 
	}
	
	if(flag){
		obj.jobFlag.value=pageFlag;
		obj.submit();
	}
	
}
window.onload=function(){
	document.getElementById("country").addEventListener("change", sendCountry);
	document.getElementById("maker").addEventListener("change", sendMaker);
	document.getElementById("search").addEventListener("click", sendModel);
}
</script>
<style>
select {
	height: 25px;
	font-size: 14px;
	font-weight: bold
}

select, input {
	height: 25px;
	font-size: 14px;
	font-weight: bold
}

lable {
	font-size: 14px;
	font-weight: bold
}

#car_category {
	text-align: center;
	margin-bottom: 10px;
	margin-top: 30px
}

table {
	border-spacing: 0px;
	margin: 0px auto;
	border-top: 2px solid #333
}

th {
	height: 30px;
	border-bottom: 1px solid #333
}

td {
	border-bottom: 1px solid #333
}

#imgTitle {
	width: 80px;
}

#optionTitle {
	width: 450px;
}

#ccTitle {
	width: 60px;
}

#priceTitle {
	width: 60px;
}

#hiredateTitle {
	width: 120px;
}
</style>
</head>
<body>
	<div>
		<div id="car_category">
			<form name="carFrm" action="car.jsp" method="post">
			<input type="hidden" name="jobFlag" />
				<label>차량 선택</label> 
				<select id="country" name="country">
					<option value="none">-----제조국-----</option>
					<option value="국산"${param.country eq '국산'?" selected='selected'":"" }>국산</option>
					<option value="수입"${param.country eq '수입'?" selected='selected'":"" }>수입</option>
				</select> <select id="maker" name="maker">
					<option value="none">----제조사----</option>
					<c:forEach var="maker" items="${maker_list }">
					<option value="${maker }"${param.maker eq maker?" selected='selected'":"" }><c:out value="${maker }"/></option>
					</c:forEach>
				</select> <select id="model" name="model">
					<option value="none">----모델명----</option>
					<c:forEach var="model" items="${model_list }">
					<option value="${model }"${param.model eq model?" selected='selected'":"" }><c:out value="${model }"/></option>
					</c:forEach>
				</select> 
				<input type="button" value="검색" id="search" class="btn" />
			</form>
		</div>
		<div id="result">
			<table>
				<tr>
					<th id="imgTitle">이미지</th>
					<th id="optionTitle">옵션</th>
					<th id="ccTitle">배기량</th>
					<th id="priceTitle">가격</th>
					<th id="hiredateTitle">입력일</th>
				</tr>
				<c:forEach var="cv" items="${car_list }">
				<tr>
					<td><img src="images/${cv.car_img }" style="width:80px"/></td>
					<td><c:out value="${cv.car_option }"/></td>
					<td><c:out value="${cv.cc }"/></td>
					<td><c:out value="${cv.price }"/></td>
					<td><c:out value="${cv.hiredate }"/></td>
				</tr>
				</c:forEach>
				<c:if test="${param.jobFlag eq '3' and empty car_list }">
				<tr>
					<td colspan="5" align="center"> ${param.model } 차량은 매물이 없습니다.</td>
				</tr>
				</c:if>
				

			</table>
		</div>
	</div>
</body>
</html>