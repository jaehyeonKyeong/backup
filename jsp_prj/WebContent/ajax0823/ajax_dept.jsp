<%@page import="java.sql.SQLException"%>
<%@page import="day0806.DeptVO"%>
<%@page import="java.util.List"%>
<%@page import="ajax0823.AjaxDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
$(function(){
	$("#selDept").change(function() {
		var deptno=$("#selDept").val();
		if(deptno!="none"){
			if(confirm(deptno+"번 부서정보를 조회하시겠습니까?")){
				//선택한 부서정보의 사원을 조회하기 위해 넘긴다.
				var param="deptno="+deptno;
				
				$.ajax({
					url:"ajax_emp.jsp",
					data:param,
					type:"get",
					dataType:"json",
					error:function(xhr){
						alert("조회가 원활하지 못합니다.\n 잠시후 다시 시도해주세요");
						console.log("error-code : "+xhr.status+" :: "+xhr.statusText);
					},
					success:function(json){
						$(".e_row").remove();
						if(json.result){//조회된 부서가 존재한다면
						var cnt=0;
							$.each(json.data, function(i, jsonEmp) {
								$("#empInfo:last").append("<tr class='e_row'><td>"
										+jsonEmp.empno+"</td><td>"
										+jsonEmp.ename+"</td><td>"
										+jsonEmp.job+"</td><td>"
										+jsonEmp.sal+"</td><td>"
										+jsonEmp.hiredate+"</td></tr>"
								);
										cnt++;
							});
						$("#empInfo:last")
						.append("<tr class='e_row'><td colspan='5' style='text-align:right'> 사원수 총 "+
								cnt
								+" 명</td></tr>");
						}else{
							$("#empInfo:last")
							.append("<tr class='e_row'><td colspan='5'>"+
									$("#selDept").find("option:selected").text()
									+" 부서는 사원이 존재하지 않습니다.</td></tr>");
						}
					}
				});
			}
		}
	});
});
</script>
<style type="text/css">
#wrap {
	width: 1000px;
	height: 700px;
	margin: 0px auto;
}

#left {
	width: 343px;
	height: 400px;
	float: left;
}

#content {
	width: 600px;
	height: 400px;
	float: left;
	margin-top: 20px;
	margin-left: 10px
}

#title {
	font-family: 맑은 고딕, dotum;
	font-size: 25px;
	font-weight: bold;
	text-align: center
}

#selDept {
	height: 30px;
	font-family: 맑은 고딕;
	font-size: 18px;
	font-weight: bold
}

#lbl {
	font-family: 맑은 고딕, dotum;
	font-size: 18px;
	font-weight: bold;
	text-align: center
}

#empInfo {
	margin-top: 10px;
	border-spacing: 0px;
	border-top: 2px solid #333;
}

th, td {
	border-bottom: 1px solid #333;
	text-align: center;
	font-family: 맑은 고딕, dotum;
	font-size: 13px;
	font-weight: normal;
}

th {
	height: 30px;
}

td {
	height: 30px;
}

#empno {
	width: 80px
}

#ename {
	width: 130px
}

#job {
	width: 100px
}

#sal {
	width: 80px
}

#hiredate {
	width: 200px
}
</style>
</head>
<body>
	<div id="wrap">
		<div id="left">
			<img src="../common/images/get.png" />
		</div>
		<div id="content">
			<div id="title">부서별 사원 정보 조회</div>
			<div id="deptContent">
				<label id="lbl">부서번호</label>
				<%
					List<DeptVO> list = null;
					try {
						list = AjaxDAO.getInstance().selectAllDept();
					} catch (SQLException se) {
						se.printStackTrace();
					}
					pageContext.setAttribute("deptData", list);
				%>
				<select id="selDept">
					<option value="none">부서선택</option>
					<c:forEach var="dv" items="${deptData }">
					<option value="${dv.deptno }"><c:out value="${dv.dname } - ${dv.loc }"/></option>
					
					</c:forEach>
				</select>
				<div id="empView">
					<table id="empInfo">
						<tr>
							<th id="empno">사원번호</th>
							<th id="ename">사원명</th>
							<th id="job">직무</th>
							<th id="sal">연봉</th>
							<th id="hiredate">입사일</th>
						</tr>
						<tr class='e_row'>
							<td colspan="5">부서정보를 조회하세요</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>