<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="인크루드 연습" import="java.util.Date"%>
<!-- 포함되는 JSP에서는 최소한의 디자인태그만 가진다<html>,<body>들은 가지지 않는다 -->
	<strong> include_b에서 제공</strong>
	<% String title="삼십이기가 2개 9900원!"; int cnt=2; int price=9900; %>
	<br>
	제품명 : <%= title %>
	<%! public String getName(){
		return "뚜딘";		
	}
		%>
