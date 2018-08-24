<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<%
	request.setCharacterEncoding("UTF-8");
%>
	<!-- parameter 값을 VO에 저장하기 위해 useBean 태그를 선언  -->
	<jsp:useBean id="bpv" class="day0731.BeanParamVO" scope="page"/>
	<!--  Parameter 값 설정 -->
	<jsp:setProperty property="*" name="bpv"/>
	<div>
		<ul>
			<li>입력값 : </li>
			<li>아이디 : ${param.id} </li>
			<li>비번 : ${param.pass}  </li>
			<li>이름 : ${param.name} </li>
			<li>
			전화번호 : ${param.phone1}-${param.phone2}-${param.phone3}
			 </li>
			<li>우편번호 : ${param.zipcode1}-${param.zipcode2}
			</li>
			<li>주소  : ${param.addr}<br>
			                ${param.addr_detail} 
			</li>
			<li>주민번호 : ${param.ssn1}-
			                     ${param.ssn2}
			</li>
			<li>성별 : ${param.gender}</li>
			<li>생일 : 
			${param.birth_year}-
			${param.birth_month}-
			${param.birth_day}
			
			</li>
			<li>결혼유무 : ${param.marriage} </li>
			<li>결혼기념일 : 
			${param.m_year}-
			${param.m_month}-
			${param.m_day}
			</li>
			<li>취미 : <%-- ${param.hobby} --%> </li>
			<!-- 배열의 값은 EL로 출력할수 없다. 선택값중 가장 처음 나오는 값만 출력한다.- 기존의 코드로 사용한다.  -->
			<%
					if(bpv.getHobby()!=null){
						for(int i=0;i<bpv.getHobby().length;i++){
							out.println(bpv.getHobby()[i]);
						}
					}else{
						out.println("취미가 없습니다.");
					}
			%>
			<li>가입인사 : ${param.greeting} </li>
		</ul>
	
	</div>
	
	<%-- <%= bpv %> --%>
</body>
</html>