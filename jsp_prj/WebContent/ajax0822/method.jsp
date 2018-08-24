<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String method=request.getMethod();
	String name=request.getParameter("name");
	int age=Integer.parseInt(request.getParameter("age"));
	
	JSONObject dataJSON=new JSONObject();
	dataJSON.put("method",method);
	dataJSON.put("name",name);
	dataJSON.put("age",age);
	out.print(dataJSON.toJSONString());
	
%>