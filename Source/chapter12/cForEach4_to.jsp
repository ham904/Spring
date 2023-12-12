<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	<table border=1>
		<tr>
			<td width=100>이름</td>
			<td width=150>전자우편</td>
		</tr>
		
		<c:forEach var="item" items="${studentList }">
			<tr>
				<td>${item.userName}</td>
				<td>${item.userMail}</td>
			</tr>		
		</c:forEach>
		
		
	</table>
</body>
</html>