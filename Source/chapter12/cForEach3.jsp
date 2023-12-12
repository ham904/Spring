<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String[] korCity = {"서울", "부산", "대구", "인천", "광주", "울산", "창원"};
%>

<c:set var="city" value="<%=korCity %>"/>

<c:forEach var="data" items="${city}" begin="2" end="4" varStatus="status">
	1. 인덱스 : ${status.index} <br>
	2. 루프실행 횟수 : ${status.count } <br>
	3. begin/end 값 : ${status.begin } / ${status.end } <br>
	4. 배열 요소 : <b> ${data} </b>
	<hr>
</c:forEach>