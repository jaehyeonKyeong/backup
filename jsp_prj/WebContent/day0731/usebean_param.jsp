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

</head>
<body>
	<!-- 요청값을 받기 전에 인코딩해준다. -->
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	
	<!-- parameter 값을 VO에 저장하기 위해 useBean 태그를 선언한다. -->
	<jsp:useBean id="bpv" class="day0731.BeanParamVO" scope="page"/>
	<!-- Parameter 값 설정 -->
	<jsp:setProperty property="*" name="bpv"/>
	<%= bpv %>
	<div>
	<ul>
	<li>입력값 :</li>
	<li>아이디 :<jsp:getProperty property="id" name="bpv"/></li>
	<li>비밀번호 :<jsp:getProperty property="pass" name="bpv"/></li>
	<li>이름 :<jsp:getProperty property="name" name="bpv"/></li>
	
	<li>전화번호 :<jsp:getProperty property="phone1" name="bpv"/>-
			<jsp:getProperty property="phone2" name="bpv"/>-
			<jsp:getProperty property="phone3" name="bpv"/>
	</li>
	
	<li>우편번호 :<jsp:getProperty property="zipcode1" name="bpv"/>-
			<jsp:getProperty property="zipcode1" name="bpv"/>
	</li>
			
	<li>주소 :<jsp:getProperty property="addr" name="bpv"/>
			<jsp:getProperty property="addr_detail" name="bpv"/>
	</li>
			
	<li>주민번호 :<jsp:getProperty property="ssn1" name="bpv"/>-
			<jsp:getProperty property="ssn2" name="bpv"/>
			
	</li>
			
	<li>성별 :<jsp:getProperty property="gender" name="bpv"/></li>
	
	<li>생년월일 :<jsp:getProperty property="birth_year" name="bpv"/>-
			<jsp:getProperty property="birth_month" name="bpv"/>
			<jsp:getProperty property="birth_day" name="bpv"/>
	</li>
			
	<li>결혼기념일 :<jsp:getProperty property="m_year" name="bpv"/>-
			<jsp:getProperty property="m_month" name="bpv"/>-
			<jsp:getProperty property="m_day" name="bpv"/>
	</li>
			
	<li>취미:<jsp:getProperty property="hobby" name="bpv"/></li>
	<!-- 배열의 값은 jsp:getProperty로 출력할 수 없다. 주소가 나와 사용X.
		이전의 코드를 사용.
	 -->
	<%
	if(bpv.getHobby() !=null){
		for(int i=0; i<bpv.getHobby().length; i++){
		out.println(bpv.getHobby()[i]);
		}//end for
	}else{
		out.println("취미가 없습니다.");
	}//end if
			
	%>
	
	
	<li>가입인사 :<jsp:getProperty property="greeting" name="bpv"/></li>
	
	</ul>	
	
	</div>




</body>
</html>













