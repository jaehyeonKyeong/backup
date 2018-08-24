<%@page import="day0806.DeptVO"%>
<%@page import="kr.co.sist.util.HashAlgorithm"%>
<%@page import="java.util.ArrayList"%>
<%@page import="day0806.EmpVO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main.css"/>
<!-- CDN  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".btn").click(function(){
		var deptno=$("#deptno").val();
		var dname=$("#dname").val();
		var loc=$("#loc").val();
		var flag=false;
		$.each($("#tab td:nth-child(1)"),function(){
			if($(this).text()==deptno){
				alert("이미 추가된 부서 입니다.");
				flag=true;
			}//end if
		});//end each
		if(!flag){
			$("#tab:last").append("<tr><td>"+deptno
					+"</td><td>"+dname+"</td><td>"+loc+"</td></tr>");
		}//end if
		$("#deptno").val("");
		$("#dname").val("");
		$("#loc").val("");
		$("#deptno").focus();
	});//click
});//ready
</script>
<style type="text/css">
#dnoTitle{ width: 100px}
#dnameTitle{ width: 150px}
#locTitle{ width: 150px}
th,td{ border: 1px solid #333;height: 20px;text-align: center }
table{ border-spacing: 0px}
</style>
</head>
<body>
<c:catch var="e">
<%= HashAlgorithm.changeMD5("123") %>
<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
	//1. JNDI 사용객체 생성
	Context ctx=new InitialContext();
	//2. DBCP에서 객체 얻기
	DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/dbcp");
	//3. Connection얻기
	con=ds.getConnection();
	//4. 쿼리문수행 객체 얻기
	String selectDept="select deptno,dname,loc from dept";
	pstmt=con.prepareStatement(selectDept);
	
	//5. 쿼리문 수행후 결과 얻기
	rs=pstmt.executeQuery();
	
	List<DeptVO> list=new ArrayList<DeptVO>();
	
	DeptVO dv=null;
	while( rs.next() ){
		dv=new DeptVO( rs.getInt("deptno"),rs.getString("dname"),
					rs.getString("loc"));
		list.add(dv);
	}//end while
		pageContext.setAttribute("dataDept", list);
	}finally{
	//6. 연결 끊기
		if( rs != null ){ rs.close(); }//end if
		if( pstmt != null ){ pstmt.close(); }//end if
		if( con != null ){ con.close(); }//end if
	}//end finally
%>

<table id="tab">
<thead>
<tr>
	<th id="dnoTitle">부서번호</th>
	<th id="dnameTitle">부서명</th>
	<th id="locTitle">위치</th>
</tr>
</thead>
<tbody>
<c:forEach var="dept" items="${ dataDept }">
<tr>
	<td><c:out value="${ dept.deptno }"/></td>
	<td><c:out value="${ dept.dname }"/></td>
	<td><c:out value="${ dept.loc }"/></td>
</tr>
</c:forEach>
</tbody>
</table>
<div style="margin-top: 10px">
<label>부서번호</label>
<input type="text" name="deptno" id="deptno" class="inputBox"/>
<label>부서명</label>
<input type="text" name="dname" id="dname" class="inputBox"/>
<label>위치</label>
<input type="text" name="loc" id="loc" class="inputBox"/>
	<input type="button" value="부서추가" class="btn" />
</div>

</c:catch>
<c:if test="${ e ne null }">
<img src="http://localhost:8080/jsp_prj/common/images/error.png"/>
</c:if>

</body>
</html>





