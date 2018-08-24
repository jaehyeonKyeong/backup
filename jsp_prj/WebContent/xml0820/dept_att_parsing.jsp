<%@page import="org.jdom2.Attribute"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.jdom2.Element"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.IOException"%>
<%@page import="org.jdom2.JDOMException"%>
<%@page import="org.jdom2.Document"%>
<%@page import="org.jdom2.input.SAXBuilder"%>
<%@page import="xml0817.DeptVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"href="http://localhost:8080/jsp_prj/common/css/main.css">
<!-- CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<%
		pageContext.setAttribute("deptList", attParsing());
	%>
	<select>
		<option>--------부서선택--------</option>	
		<c:forEach var="dv" items="${deptList}">
		<option value="${dv.deptno }">	
			<c:out value="${dv.dname }"/>(<c:out value="${dv.loc }"/>)
		</option>
		<c:if test="${empty deptList }">
			<option value="none">
			부서가 존재하지않습니다.
			</option>
		</c:if>
		</c:forEach>
	</select>
</body>
</html> 
<%! 
public List<DeptVO> attParsing() throws JDOMException,IOException{
	List<DeptVO> list=new ArrayList<DeptVO>();
	//1. builder생성
	SAXBuilder builder=new SAXBuilder();
	//2. 최상위 문서 객체 얻기
	Document doc=builder.build(new URL("http://localhost:8080/jsp_prj/xml0820/dept_att.xml"));
	//3. 부모노드 얻기 <depts>
	Element rootNode=doc.getRootElement();
	//4. 반복되는 자식 노드 얻기
	Iterator<Element> deptIta=rootNode.getChildren().iterator();
	
	Element deptNode=null;
	Attribute deptAtt=null;
	DeptVO dv=null;
	
	Iterator<Element> deptSubIta=null;//dept노드의 자식노드들
	Element deptSubNode=null;//dept노드의 자식노드 저장

	while(deptIta.hasNext()){
		dv=new DeptVO();
		//5. 값얻기 (속성값,노드사이의 값,자식 노드)
		deptNode=deptIta.next();
		deptAtt=deptNode.getAttribute("deptno");
		dv.setDeptno(deptAtt.getIntValue());
		
		//dept노드의 자식노드들 반복
		deptSubIta=deptNode.getChildren().iterator();
		while(deptSubIta.hasNext()){
			
			deptSubNode=deptSubIta.next(); // <dname>,<loc>
			
			if("dname".equals(deptSubNode.getName())){
				//parsing한 값을 vo에 설정
				dv.setDname(deptSubNode.getValue());
			}
			
			if("loc".equals(deptSubNode.getName())){
				//parsing한 값을 vo에 설정
				dv.setLoc(deptSubNode.getValue());
			}
			
		}//while
			
		list.add(dv);
		
	}//while
	return list;
}
%>