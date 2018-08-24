<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="내부페이지"%>
    <!-- 변수나 method를 공유할 수 없고,
    	페이지 지시자에 대한 충돌이 발생하지 않는다.
    -->
    
<%
String name="지승민";
%>

 내부 JSP(공통 디자인)
<strong><%=name %></strong><br/>
<img src="../common/images/add.png" />

