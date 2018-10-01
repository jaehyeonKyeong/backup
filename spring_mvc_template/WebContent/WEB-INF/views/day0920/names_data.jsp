<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="position: relative; margin:0px auto">
	<c:forEach var="name" items="${requestScope.names }">
	<c:set var="i" value="${i+100 }"/>
	<div style="position: absolute; top:${i}px; left:${i}px">
		${name }
	</div>
	</c:forEach>
</div>