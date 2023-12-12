<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<c:set var="col" value="${param.col}" />
<c:set var="key" value="${param.key}" />
<c:set var="nowPage" value="${param.nowPage}" />

<c:set var="rNo" value="${param.rcdNO}" />

<%
	pageContext.setAttribute("newLine", "\r\n");
	pageContext.setAttribute("br", "<br>");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 수정</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

	<table class="noline">
		<tr><td class=header>게시글 수정</td><tr>
	</table>
	
	<hr align=center width=500 size=3 noshade>

	<form name="boardModify" method="post" action="${contextPath}/boardModify.do?rcdNO=${rNo}&col=${col}&key=${key}&nowPage=${nowPage}">
	
	<table class=main>
	
		<tr>
			<td class=title2>작성자</td>
			<td class=content2> ${record.userName} </td>
		</tr>
		<tr>
			<td class=title2>이메일</td>
			<td class=content2>
				<input type="email" name="userMail" size=30 value='${record.userMail}'>
			</td>
		</tr>			
		<tr>
			<td class=title2>제목</td>
			<td class=content2>
				<input type="text" name="rcdSubject" size=45 required value='${record.rcdSubject}'>
			</td>
		</tr>			
		<tr>
			<td class=title2>내용</td>
			<td class=content2>
				<textarea name="rcdContent" cols=50 rows=10>${record.rcdContent}</textarea>
			</td>
		</tr>
		<tr>
			<td class=title2>패스워드</td>
			<td class=content2>
				<input type="password" name="rcdPass" size=10 required>
			</td>
		</tr>	
						
	</table>
	
	<table align=center>
		<tr>
			<td width=80 align=left>
				<input type="button" value="LIST" onClick="location.replace('${contextPath}/boardList.do?col=${col}&key=${key}&nowPage=${nowPage}')">
			</td>
			<td width=400 align=right>
				<input type="submit" value="SAVE">
				<input type="reset" value="CANCLE">
			</td>
		</tr>	
	</table>	
	
	</form>	
	
</body>
</html>