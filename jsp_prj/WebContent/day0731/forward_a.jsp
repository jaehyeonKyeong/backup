<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="데이터처리 목적"
    
%>

<%--
//parameter없이 페이지 이동할 때
<jsp:forward page="forward_b.jsp" /> --%>

<%-- parameter입력하여 페이지를 이동 --%>
<!-- forward 태그 사이에는 param만 정의한다. -->
<!-- bean의 scope 사용 -->
<jsp:useBean id="fv1" class="day0731.ForwardVO" scope="request" />
<jsp:setProperty name="fv1" property="name" value="뚜딘" />
<jsp:setProperty name="fv1" property="age" value="23" />
<jsp:setProperty name="fv1" property="addr" value="서울시 관악구 청룡동" />

<jsp:useBean id="fv2" class="day0731.ForwardVO" scope="session" />
<jsp:setProperty name="fv2" property="name" value="대현" />
<jsp:setProperty name="fv2" property="age" value="27" />
<jsp:setProperty name="fv2" property="addr" value="서울시 관악구 봉천동" />

<jsp:forward page="forward_b.jsp">
	<jsp:param value="youngin" name="addr"/>
</jsp:forward>




