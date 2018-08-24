<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"href="http://211.63.89.140:8080/jsp_prj/common/css/main.css">
<!-- CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
</script>
<style type="text/css">
	table{border:1px solid #333; border-spacing:0px;}
	td,th{border:1px solid #333;text-align: center;}
	#nameTitle{width:80px}
	#scoreTitle{width:600px}
</style>
</head>
<body>
	<%!
		String name; //instance변수
		public String getName(){
			return"최주오";
		}
	%>
	<%!
	/**
	라디오 버튼을 생성할때 사용한다
	@Param radioName 생성할 라디오 버튼의 이름
	@Param cnt 생성할 라디오 버튼의 갯수
	@Param selectedIndex 초기 라디오버튼의 선택
	@Return 생성한 라디오버튼의 이름
	
	*/
	public String createRadio(String radioName,int cnt,int selectedIndex){
			//String radio="";
			//for(int j=0;j<11;j++){
			//	radio+="<input type='radio'name='handsomeScore"+i+"'value='"+j+"'>"
			//	+j+"점&nbsp;";
			//}
			//return radio;
			StringBuilder radio=new StringBuilder();
			for(int i=0;i<cnt;i++){
				radio.append("<input type='radio' name='").append(radioName).append("'value='")
				.append(i).append("'").append(i==selectedIndex?" checked='checked'":"").append(">").append(i).append("점&nbsp;");
				
			}
			return radio.toString();
	}
	%>
	이름 : <Strong><%=name %></Strong><br>
	이름 : <Strong><%=getName()%></Strong>
	<% 
		String[] names={"지승민","송재원","꿀형","후니다2","빛동희","우또탄"};
	%>
	<table>
		<tr>
			<th id="nameTitle">이름</th>
			<th id="scoreTitle">잘생김점수</th>
		</tr>
		<% for(int i=0;i<names.length;i++){ %>
		<tr>
			<td><%=names[i] %></td>
			<td><%=createRadio("handsome"+i,11,0)%>
			</td>
		</tr>
		
		<% } %>
	</table>
</body>
</html>