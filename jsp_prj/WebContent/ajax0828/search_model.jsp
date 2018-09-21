<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.SQLException"%>
<%@page import="day0827.CarDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String maker=request.getParameter("maker");
	JSONObject modelJson=new JSONObject();//{}
	JSONArray modelJsonArray=new JSONArray();//[{model:aa},{model:bb}...]
	boolean flag=false;
	try{
		CarDAO c_dao=CarDAO.getinstance();
		List<String> modelList=c_dao.selectModel(maker);
	
		JSONObject tempModel=null;
		for(String model: modelList){
			flag=true;
			tempModel=new JSONObject();
			tempModel.put("model",model);
			modelJsonArray.add(tempModel);//[{model:소나타}...]
		}
		if(flag){
			modelJson.put("data",modelJsonArray);//{data:[{model:소나타}...]}
		}
	}catch(SQLException se){
		se.printStackTrace();
	}
	modelJson.put("result",flag);//{result:true}
	out.print(modelJson.toJSONString());
%>