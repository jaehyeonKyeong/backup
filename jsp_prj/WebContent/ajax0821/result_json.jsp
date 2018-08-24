<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	JSONObject personData=new JSONObject();
personData.put("name","뚜딘");
personData.put("age",23);
personData.put("addr","서울시 관악구 청룡동");
personData.put("img","sist_logo.jpg");
out.println(personData.toJSONString());
%>
