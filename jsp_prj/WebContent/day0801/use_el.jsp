<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
isELIgnored="false"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main.css">
<!--  CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<div>
	<ul>
		<li>EL 문자열 사용</li>
		<li>${"안녕하세요?"}</li>
		<li>${'안녕하세요?' }</li>
	</ul>
	<ul>
		<li>EL 연산자 사용</li>
		<li>단항</li>
		<li>!8>1 = ${!(8>1)} (${not(8 gt 1)})</li>
		<li>산술</li>
		<li>8+1=${8+1}</li>
		<li>8-1=${8-1}</li>
		<li>8x1=${8*1}</li>
		<li>8/1=${8/1}</li>
		<!--  나눈 나머지는 %와 mod로 사용할 수 있다. -->
		<li>8%1=${8%1},${8 mod 1}</li>
		<li>관계연산자</li>
		<li>8>1=${8>1}(${8 gt 1 })</li>
		<li>8<1=${8<1}(${8 lt 1 })</li>
		<li>8>=1=${8>=1}(${8 ge 1 })</li>
		<li>8<=1=${8<=1}(${8 le 1 })</li>
		<li>8==1=${8==1}(${8 eq 1 })</li>
		<%-- <li>8!=1=${8!=1}(${8 ne 1 })</li> --%>
		<li>논리연산자</li>
		<li>8>1 && 1 < 8 = ${8>1 && 1<8 }(${8 gt 1 and 1 lt 8 })</li>
		<li>8>1 || 1 < 8 = ${8>1 || 1<8 }(${8 gt 1 or 1 lt 8 })</li>
		<li>삼항연산자</li>
		<li>10 > -1 = ${10 > -1?"양수":"음수"}</li>
		
	</ul>
	<%-- el에서는 shift연산자를 쓸수 없다. 사용불가. ${1 << 4 } 
            el에서는 단항연산자 not 이외의 사용불가.    ${~1}
	--%>
	<ul>
		<li>웹의 파라메터 받기</li>
		<li><a href="use_el.jsp?name=ddudin&age=23&age=24">요청</a></li>
		<li>이름 : ${param.name }</li>
		<!-- 파라메터명이 같다면 이전의 자바코드를 사용하여 출력해야한다. -->
		<li>나이 : ${param.age }</li>
		<li>${param.name==null?"(null)위의 요청을 눌러주세요":"" }</li>
		<!-- null인 경우에는 empty로 사용할 수 있다. -->
		<li>${empty param.name ?"(empty)위의 요청을 눌러주세요":"" }</li>
	</ul>
	<%
		//scope 객체의 사용 : EL에서는 변수나 method를 직접접근할수 없다.
		int i=100;
		pageContext.setAttribute("page_i",i);
		request.setAttribute("request_i" ,i);
		session.setAttribute("session_i" ,i);
		application.setAttribute("app_i" ,i);
	%>
		<%-- i : ${i}  변수에 대한 직접 참조는 불가능이다. --%>	
		<ul>
			<!-- scope 객체는 생략이 가능하다. -->
			<li>pageScope : ${pageScope.page_i},(${page_i})</li>
			<li>requestScope : ${requestScope.request_i},(${request_i})</li>
			<li>sessionScope : ${sessionScope.session_i},(${session_i})</li>
			<li>applicationScope : ${applicationScope.app_i},(${app_i})</li>
		</ul>
	</div>
</body>
</html>