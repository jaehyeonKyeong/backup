<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.SQLException"%>
<%@page import="day0827.CarDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String country=request.getParameter("country");
	JSONObject makerJson=new JSONObject();//{}
	JSONArray makerJsonArray=new JSONArray();//[{maker:aa},{maker:bb}...]
	boolean flag=false;
	try{
		CarDAO c_dao=CarDAO.getinstance();
		List<String> makerList=c_dao.selectMarker(country);
	
		JSONObject tempMaker=null;
		for(String maker: makerList){
			flag=true;
			tempMaker=new JSONObject();
			tempMaker.put("maker",maker);
			makerJsonArray.add(tempMaker);//[{maker:현대}...]
		}
		if(flag){
		makerJson.put("data",makerJsonArray);//{data:[{maker:현대}...]}
		}
	}catch(SQLException se){
		se.printStackTrace();
	}
	makerJson.put("result",flag);//{result:true}
	out.print(makerJson.toJSONString());
%>