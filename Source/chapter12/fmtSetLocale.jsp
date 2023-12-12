<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date " %>

<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="now" value="<%=new Date()%>"/>

<b>대한민국 포맷</b><br>
<fmt:setLocale value="ko_kr"/>
금액 : <fmt:formatNumber value="10000" type="currency" /> <br>
일시 : <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/> 
<hr>

<b>미국 포맷</b><br>
<fmt:setLocale value="en_us"/>
금액 : <fmt:formatNumber value="10000" type="currency" /> <br>
일시 : <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/>
<hr>
 
<b>일본 포맷</b><br>
<fmt:setLocale value="ja_jp"/>
금액 : <fmt:formatNumber value="10000" type="currency" /> <br>
일시 : <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/>