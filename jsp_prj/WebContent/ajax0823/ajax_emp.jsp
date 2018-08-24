<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.SQLException"%>
<%@page import="ajax0823.EmpVO"%>
<%@page import="java.util.List"%>
<%@page import="ajax0823.AjaxDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String deptno=request.getParameter("deptno");
	AjaxDAO a_dao=AjaxDAO.getInstance();
	
	List<EmpVO> list=null;
	try{
	list=a_dao.selectEmp(Integer.parseInt(deptno));
	}catch(SQLException se){
		se.printStackTrace();
	}
	
	JSONArray empArr=null;
	if(list!=null){
		empArr=new JSONArray();
		JSONObject tempEmp=null;
		for(EmpVO ev : list){
			tempEmp=new JSONObject();
			tempEmp.put("empno", ev.getEmpno());
			tempEmp.put("ename", ev.getEname());
			tempEmp.put("sal", ev.getSal());
			tempEmp.put("job", ev.getJob());
			tempEmp.put("hiredate", ev.getHiredate());
			//{"empno":10,"ename":"송재원","sal":2800}
			empArr.add(tempEmp);
			}
		SimpleDateFormat pubSdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		JSONObject empJson=new JSONObject();
		empJson.put("pubDate",pubSdf.format(new Date()));
		empJson.put("result",list!=null&&list.size()!=0);
		empJson.put("data",empArr);
		out.print(empJson.toJSONString());
	}
%>