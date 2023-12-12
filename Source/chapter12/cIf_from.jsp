<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="name"> ${"이순신"} </c:set>
<c:set var="depart"> ${"소프트웨어"} </c:set>
<c:set var="age"> ${25} </c:set>

<c:if test="${(name=='이순신')&&(depart=='소프트웨어')}" var="result" scope="session">
	<h3> 이름 : ${name} </h3>
	<h3> 학과 : ${depart}</h3>
	<h3> result : ${result} </h3>	 	
</c:if>
<hr>
 
<c:if test="${age > 20}">
	<h3> ${name}님은 성인입니다.</h3>
</c:if>
 <hr>
 
<a href="cIf_to.jsp">확인</a>