<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%@page import="ajax0823.LatLngVO"%>
<%@page import="java.util.List"%>
<%@page import="ajax0823.AjaxDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String loc = request.getParameter("loc");
	AjaxDAO ad = AjaxDAO.getInstance();

	List<LatLngVO> list = null;
	try {
		list = ad.selectLatLng(Integer.parseInt(loc));
	} catch (SQLException se) {
		se.printStackTrace();
		list=new ArrayList<LatLngVO>();
		list.add(new LatLngVO("쌍용교육센터",37.4992940, 127.0331880));
	}
	JSONArray ja=new JSONArray();
	JSONObject jo=null;
	for(LatLngVO lv:list){
		jo=new JSONObject();
		jo.put("title",lv.getTitle());
		jo.put("lat",lv.getLat());
		jo.put("lng",lv.getLng());
		ja.add(jo);
	}
	out.print(ja.toJSONString());
	
%>
