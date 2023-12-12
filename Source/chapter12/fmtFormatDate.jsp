<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date " %>

<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="now" value="<%=new Date()%>"/>

<h3>지정 출력 형식</h3>
<b>[ shortStyle ]</b> :

<fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short"/> 
<hr>

<b>[ mediumStyle ]</b> :
<fmt:formatDate value="${now}" type="both" dateStyle="medium" timeStyle="medium"/> 
<hr>

<b>[ longStyle ]</b> :
<fmt:formatDate value="${now}" type="both" dateStyle="long" timeStyle="long"/> 
<hr>

<b>[ fullStyle ]</b> :
<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/> 
<hr>

<h3>패턴 출력 형식</h3>
<fmt:formatDate value="${now}" type="both" pattern="yyyy/MM/dd (E) hh:mm:ss (a)" />
