<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:out value="&ge;" escapeXml="true" /> <br>
<c:out value="&ge;" escapeXml="false" /> <br><hr>

<c:out value="<h2>오늘은 월요일입니다.</h2>" escapeXml="true" /> <br>
<c:out value="<h2>오늘은 월요일입니다.</h2>" escapeXml="false" /> <hr>

<c:out value="${user}">Guest</c:out>님의 방문을 환영합니다.