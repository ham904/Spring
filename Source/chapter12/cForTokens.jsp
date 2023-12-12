<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="korCity" value="서울 부산 대구 인천" />

<c:forTokens var="city" items="${korCity}" delims=" " varStatus="status">
	1. index : ${status.index} <br>
	2. loop : ${status.count} <br>
	3. token : <b>${city}</b>
	<hr>
</c:forTokens>