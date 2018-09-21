<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	$(function() {
		$("#country").change(function() {
			var country = $("#country").val();
			if (country != "none") {
				$.ajax({
					url : "search_maker.jsp",
					data : "country=" + country,
					type : "get",
					dataType : "json",
					//async://false동기(응답이 오고난 후 success), true비동기(응답이 오기전에 success)
					error : function(xhr) {
						console.log("error-code : " + xhr.status + " :: " + xhr.statusText);
					},
					success : function(json_obj) {
						//{result:true||false,data:[{maker:현대},{maker:대우},{maker:삼성}...]}
						if (json_obj.result) {

							var makerSel = document.getElementById("maker");
							makerSel.length = 1; //데이터가 중복이 되지 않게 초기화 시켜준다.

							var modelSel = document.getElementById("model");
							modelSel.length = 1; //데이터가 중복이 되지 않게 초기화 시켜준다.
							
							
							$.each(json_obj.data, function(i, data) {
								makerSel.options[i + 1] = new Option(data.maker /*보여질값*/ , data.maker /*value값*/ );
							});

						} else {
							alert(country + "으로 조회된 결과가 존재하지 않습니다. 잠시후에 다시 시도해주세요");
						}
					}
				}); //ajax
			}else{
				var makerSel = document.getElementById("maker");
				makerSel.length = 1; //데이터가 중복이 되지 않게 초기화 시켜준다.

				var modelSel = document.getElementById("model");
				modelSel.length = 1; //데이터가 중복이 되지 않게 초기화 시켜준다.
				$("#none").show();
				$(".car_data").remove();
			} //if
		}); //change
		$("#maker").change(function() {
			var maker = $("#maker").val();
			if (maker != "none") {
				$.ajax({
					url : "search_model.jsp",
					data : "maker=" + maker,
					type : "get",
					dataType : "json",
					//async://false동기(응답이 오고난 후 success), true비동기(응답이 오기전에 success)
					error : function(xhr) {
						console.log("error-code : " + xhr.status + " :: " + xhr.statusText);
					},
					success : function(json_obj) {
						//{result:true||false,data:[{model:그랜저},{model:소나타},{model:아반테}...]}
						if (json_obj.result) {

							var modelSel = document.getElementById("model");
							modelSel.length = 1; //데이터가 중복이 되지 않게 초기화 시켜준다.

							$.each(json_obj.data, function(i, data) {
								modelSel.options[i + 1] = new Option(data.model /*보여질값*/ , data.model /*value값*/ );
							});

						} else {
							alert(maker + "로 조회된 결과가 존재하지 않습니다. 잠시후에 다시 시도해주세요");
						}
					}
				}); //ajax
			} //if
		}); //change
		$("#search").click(function() {
			var model = $("#model").val();
			if (model != "none") {
				$.ajax({
					url : "search_car.jsp",
					data : "model=" + model,
					type : "get",
					dataType : "json",
					//async://false동기(응답이 오고난 후 success), true비동기(응답이 오기전에 success)
					error : function(xhr) {
						console.log("error-code : " + xhr.status + " :: " + xhr.statusText);
					},
					success : function(json_obj) {
						//{result:true||false,data:[{car_option:썬루프},{cc:2000},...]}
						$("#none").hide();
						$(".car_data").remove();
						if (json_obj.result) {
							var option = null;
							$.each(json_obj.data, function(i, data) {
								option=data.car_option;
								if(option.length >19){
									option=option.substring(0,20)+" ...";
								}
								
								$("#carTab:last")
									.append("<tr class='car_data' style='text-align:center'><td><img src='../ajax0827/images/" + data.car_img
										+ "' style='width:80px'/></td><td>" + option
										+ "</td><td>" + data.cc + "</td><td>" + data.price + "</td><td>" + data.hiredate + "</td></tr>")
							});

						} else {
							$("#carTab:last")
								.append("<tr class='car_data'style='text-align:center'><td colspan=5>" + model +
									"차량은 현재 존재하지 않습니다.<br>"
									+ "<img src='../common/images/get.png' style='width:80px'/>"
									+ "</td></tr>");
						}
					}
				}); //ajax
			} //if
		}); //change

	}); //ready
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
				<input type="hidden" name="jobFlag" /> <label>차량 선택</label> <select
					id="country" name="country">
					<option value="none">-----제조국-----</option>
					<option value="국산">국산</option>
					<option value="수입">수입</option>
				</select> <select id="maker" name="maker">
					<option value="none">----제조사----</option>
				</select> <select id="model" name="model">
					<option value="none">----모델명----</option>
				</select> <input type="button" value="검색" id="search" class="btn" />
			</form>
		</div>
		<div id="result">
			<table id="carTab">
				<tr>
					<th id="imgTitle">이미지</th>
					<th id="optionTitle">옵션</th>
					<th id="ccTitle">배기량</th>
					<th id="priceTitle">가격</th>
					<th id="hiredateTitle">입력일</th>
				</tr>
				<tr id="none" style="text-align: center">
					<td colspan=5><img src="../common/images/get.png"
						style="width: 100px; margin-top: 10px;" /><br>차량을 선택해 주세요</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>