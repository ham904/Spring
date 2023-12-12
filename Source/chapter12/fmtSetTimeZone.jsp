<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.Date " %>

<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="now" value="<%=new Date()%>"/>

<b>시스템 설정 (기본값)</b> <br>
<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/> 
<hr>

<b>서울</b> <br>
<fmt:setTimeZone value="Asia/Seoul"/>
<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/>
<hr>

<b>로스앤젤러스</b> <br>
<fmt:setTimeZone value="America/Los_Angeles"/>
<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/>
<hr>

<b>파리</b> <br>
<fmt:setTimeZone value="Europe/Paris"/>
<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/>
