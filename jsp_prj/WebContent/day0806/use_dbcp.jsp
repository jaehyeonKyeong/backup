<%@page import="day0806.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main.css">
<!-- CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> 
<script type="text/javascript">
/* $(function(){
	$(".btn").click(function(){
		var total=0;
		$.each($("td:nth-child(4)"),function(){ //td중 4번째 td를 구하여 합
			total+=parseInt($(this).text());
		});//each
		$("#salSum").text(total);
	});//click
});//ready */
$(function(){
	$(".btn").click(function(){
		var total=0;
		$.each($(".sal"),function(){	//class가 sal인 td의 합
			total+=parseInt($(this).text());
		});//each
		$("#salSum").text(total);
	});//click
});//ready

</script>
<style type="text/css">
#numTitle{width: 80px}
#empnoTitle{width: 100px}
#enameTitle{width: 120px}
#salTitle{width: 100px}
#hiredateTitle{width: 180px}
th,td{border: 1px solid #333; height: 20px; text-align: center;}
table{border-spacing: 0px}
</style>

</head>
<body>
<c:catch var="e">
<%
Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs=null;

try{
//1.JNDI(Java Naming and Directory Interface)사용객체 생성.
Context ctx=new InitialContext();
//2.DBCP에서 객체 얻기
DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/dbcp");
//3.Connection얻기
con=ds.getConnection();
//4.쿼리문수행 객체 얻기
String selectEmp="select empno, ename, sal, to_char(hiredate,'yyyy-mm-dd')hiredate from emp order by sal desc";
pstmt=con.prepareStatement(selectEmp);
//5.쿼리문 수행후 결과 얻기
rs=pstmt.executeQuery();
 
List<EmpVO> list=new ArrayList<EmpVO>();

EmpVO ev=null;
while(rs.next()) {
	ev=new day0806.EmpVO(rs.getInt("empno"), rs.getInt("sal"),
		rs.getString("ename"), rs.getString("hiredate"));
	list.add(ev);
}//end while
pageContext.setAttribute("dataEmp", list);
}finally{
//6.연결 끊기
if(rs !=null){rs.close();} //end if
if(pstmt !=null){pstmt.close();}//end if
if(con !=null){con.close();}//end if
}//end finally
%>
<table>
<thead>
<tr>
<th id="numTitle">번호</th>
<th id="empnoTitle">사원번호</th>
<th id="enameTitle">사원명</th>
<th id="salTitle">연봉</th>
<th id="hiredateTitle">입사일</th>

</tr>
</thead>
<tbody>
<c:forEach var="emp" items="${dataEmp}">
<c:set var="num" value="${num+1}" />
<tr>
<td><c:out value="${num}"></c:out>
<td><c:out value="${emp.empno}"></c:out>
<td><c:out value="${emp.ename}"></c:out>
<td class="sal"><c:out value="${emp.sal}"></c:out>
<td><c:out value="${emp.hiredate}"></c:out>
</td>
</c:forEach>
</tbody>
</table>
<div>
	<input type="button" value="연산" class="btn" />
</div>
<div>연봉 합 :<span id="salSum"></span> </div>

</c:catch>
<c:if test="${e ne null}">
<img src="http://localhost:8080/jsp_prj/common/images/error.png" />
</c:if>
</body>
</html>




