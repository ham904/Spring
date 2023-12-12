<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="score">${param.score}</c:set>

<c:choose>
	<c:when test="${score>=95 }"> A+ 학점입니다. </c:when>
	<c:when test="${score>=90 }"> A0 학점입니다. </c:when>
	<c:when test="${score>=85 }"> B+ 학점입니다. </c:when>
	<c:when test="${score>=80 }"> B0 학점입니다. </c:when>
	<c:when test="${score>=75 }"> C+ 학점입니다. </c:when>
	<c:when test="${score>=70 }"> C0 학점입니다. </c:when>
	<c:when test="${score>=65 }"> D+ 학점입니다. </c:when>
	<c:when test="${score>=60 }"> D0 학점입니다. </c:when>
	
	<c:otherwise> F학점입니다. </c:otherwise>				
</c:choose>