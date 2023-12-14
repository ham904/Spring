<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!-- 
<c:set var="col" value="${param.col}" />
<c:set var="key" value="${param.key}" />
<c:set var="rNo" value="${param.rcdNO}" />
<c:set var="nowPage" value="${param.nowPage}" />
-->

<%

	String col = (String)request.getAttribute("col");
	String key = (String)request.getAttribute("key");	
	String nowPage = (String)request.getAttribute("nowPage");
	String rNo = String.valueOf(request.getAttribute("rNo"));

	pageContext.setAttribute("newLine", "\r\n");
	pageContext.setAttribute("br", "<br>");
%>

<c:set var="col" value="<%=col %>"/>
<c:set var="key" value="<%=key %>"/>
<c:set var="nowPage" value="<%=nowPage %>"/>
<c:set var="rNo" value="<%=rNo %>"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 삭제</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

	<table class="noline">
		<tr><td class=header>게시글 삭제</td><tr>
	</table>
	
	<hr align=center width=500 size=3 noshade>

	<form name="boardDelete" method="post" action="${contextPath}/boardDelete.do?rcdNO=${rNo}&col=${col}&key=${key}&nowPage=${nowPage}">
	
	<table class=main>
		
		<tr>
			<td class=title2>제목</td>
			<td class=content2> ${record.rcdSubject} </td>
		</tr>			
		<tr>
			<td class=title2>내용</td>
			<td class=content2> ${fn:replace(record.rcdContent, newLine, br)} </td>
		</tr>
		<tr>
			<td class=title2>패스워드</td>
			<td class=content2>
				<input type="password" name="rcdPass" size=20 required>
			</td>
		</tr>	
						
	</table>
	
	<table align=center>
		<tr>
			<td width=80 align=left>
				<input type="button" value="LIST" onClick="location.replace('${contextPath}/boardList.do?col=${col}&key=${key}&nowPage=${nowPage}')">
			</td>
			<td width=400 align=right>
				<input type="submit" value="DELETE">
				<input type="reset" value="CANCLE">
			</td>
		</tr>	
	</table>	
	
	</form>	
	
</body>
</html>