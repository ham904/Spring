<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="i" begin="2" end="9" step="1">
	
	<c:forEach var="j" begin="1" end="9" step="1">
		${i} * ${j} = ${i*j} <br>
	</c:forEach>
	<hr>
	
</c:forEach>