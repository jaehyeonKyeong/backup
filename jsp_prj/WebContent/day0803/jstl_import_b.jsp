<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<img src="http://211.63.89.133:8080/jsp_prj/day0802/images/title.png"/>
<br/>
공통디자인
<%
	String name="최주오";
	session.setAttribute("name", name);
%>
이름 : ${name},  <%= name%>