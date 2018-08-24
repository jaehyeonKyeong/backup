<%@page import="xml0816.PersonVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.IOException"%>
<%@page import="xml0816.ParsingXML"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/jsp_prj/common/css/main.css">
<!-- CDN -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<%
		pageContext.setAttribute("person_data", parsing());
	%>
	<table>
		<thead>
			<tr>
				<th style="width:100px">이름</th>
				<th>태어난 해</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
		<c:if test="${empty person_data }">
			<tr>
				<td colspan="3">조회된 데이터가 존재하지 않습니다.</td>
			</tr>
		</c:if>
		<c:forEach var="pv" items="${person_data}">
			 <tr>
			 	<td><c:out value="${pv.name }"/></td>
			 	<td><c:out value="${pv.birthYear }"/></td>
			 	<td><c:out value="${pv.addr }"/></td>
			 </tr>
		</c:forEach>
		</tbody>
	</table>
	<%!public List<PersonVO> parsing() throws IOException {
		BufferedReader br = null;
		List<PersonVO> list = new ArrayList<PersonVO>();
		try {
			//1. xml을 연결
			br = new BufferedReader(new InputStreamReader(
					new FileInputStream("C:/dev/workspace/jsp_prj/WebContent/xml0816/person_data.xml"), "UTF-8"));
			//2.파일에서 줄단위로 읽어 들이기
			String temp = "", parsingNode = "", data = "";
			PersonVO pv = null;
			while ((temp = br.readLine()) != null) {
				//3.노드 얻기
				parsingNode = temp.substring(temp.indexOf("<") + 1, temp.indexOf(">"));
				if ("name".equals(parsingNode)) {
					pv = new PersonVO();
					data = temp.substring(temp.indexOf(">") + 1, temp.lastIndexOf("<"));
					pv.setName(data);
				}
				if ("birthYear".equals(parsingNode)) {
					data = temp.substring(temp.indexOf(">") + 1, temp.lastIndexOf("<"));
					pv.setBirthYear(Integer.parseInt(data));
				}
				if ("addr".equals(parsingNode)) {
					data = temp.substring(temp.indexOf(">") + 1, temp.lastIndexOf("<"));
					pv.setAddr(data);
					list.add(pv);
				}
			}

		} finally {
			if (br != null) {
				br.close();
			}
		}
		return list;
	}%>
</body>
</html>