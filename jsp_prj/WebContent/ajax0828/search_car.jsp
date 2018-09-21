<%@page import="day0827.CarVO"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.SQLException"%>
<%@page import="day0827.CarDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String model=request.getParameter("model");
	JSONObject carJson=new JSONObject();//{}
	JSONArray carJsonArray=new JSONArray();//[{car_img:aa},{car_option:bb}...]
	boolean flag=false;
	try{
		CarDAO c_dao=CarDAO.getinstance();
		List<CarVO> carList=c_dao.selectCar(model);
	
		JSONObject tempCar=null;
		for(CarVO car: carList){
			flag=true;
			tempCar=new JSONObject();
			tempCar.put("car_option",car.getCar_option());
			tempCar.put("car_img",car.getCar_img());
			tempCar.put("hiredate",car.getHiredate());
			tempCar.put("price",car.getPrice());
			tempCar.put("cc",car.getCc());
			carJsonArray.add(tempCar);//[{car_option:썬루프}...]
		}
		if(flag){
			carJson.put("data",carJsonArray);//{data:[{car_option:썬루프}...]}
		}
	}catch(SQLException se){
		se.printStackTrace();
	}
	carJson.put("result",flag);//{result:true}
	out.print(carJson.toJSONString());
%>