<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" type="text/css"href="http://211.63.89.140:8080/jsp_prj/common/css/main.css"> -->
<!-- CDN -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
function printValue(value){
	alert(value);
}
</script>
<style type="text/css">
table{border:1px solid #333}
tr{border:1px solid #333}
td{width:120px;width:30px;border:1px solid #333}
</style>
</head>
<body>
	<%
		for (int i = 0; i < 6; i++) {
	%>
	<h<%=i + 1%>>아 그랬냐 발발이 치와와 왜냐하면</h<%=i + 1%>>
	<%
		} //end for
	%>
	<%
		int sum = 0;
		for (int i = 1; i < 101; i++) {
			sum += i;
		}
	%>
	<br>
	1~100까지의 합은 :
	<%=sum%>
	<br>
	<%
		//scriptlet내에서는 객체를 생성하여 사용할 수 있다
		Calendar cal = Calendar.getInstance();
		int nowYear = cal.get(Calendar.YEAR);
		int nowMonth = cal.get(Calendar.MONTH) + 1;
		int nowDay = cal.get(Calendar.DAY_OF_MONTH);
		//이번달의 마지막 일
		int lastDate = cal.getActualMaximum(Calendar.DATE);
	%>
	<br>
	<select>
		<option>---년---</option>
		<!-- 1. 1950년 부터 현재년 까지 출력 -->
		<%-- <%for(int tempYear=1950;tempYear<=nowYear;tempYear++){ %>
		<option<%= tempYear==nowYear?" selected='selected'":"" %>><%= tempYear%></option>
		<%} %> --%>
		<!-- 2.현재년을 기준으로 이전2년과 이후 2년을 출력 -->
		<%
			for (int tempYear = nowYear - 2; tempYear <= nowYear + 2; tempYear++) {
		%>
		<option <%=tempYear == nowYear ? " selected='selected'" : ""%>><%=tempYear%></option>
		<%
			} //endFor
		%>
	</select>
	<select>
		<option>---월---</option>
		<%
			for (int tempMonth = 1; tempMonth < 13; tempMonth++) {
		%>
		<option <%=tempMonth == nowMonth ? " selected='selected'" : ""%>><%=tempMonth%></option>
		<%
			} //end for
		%>
	</select>
	<select>
		<option>---일---</option>
		<%
			for (int tempDay = 1; tempDay < lastDate + 1; tempDay++) {
		%>
		<option <%=tempDay == nowDay ? " selected='selected'" : ""%>><%=tempDay%></option>
		<%
			} //end for
		%>
	</select>
	<br>
	<br>
	<div>
		<table>
			<%for (int i = 1; i < 10; i++) {%>
			<tr>
				<%for(int j=2;j<10;j++){ %>
				<td onclick="printValue('<%=j%>x<%=i%>=<%=j*i%>')"><%= j+"*"+i %></td>
				<%} %>
			</tr>
			<%}%>
		</table>
	</div><br>
		<% String[] names={"송재원","강소예","경제현","이동근"}; %>
		<%for(int i=0;i<names.length;i++){ %>
		<input type="radio" name="3조" value="<%=names[i] %>"><%=names[i] %>
		<%}//end for %>
</body>
</html>