<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>

	<form name="beanForm" method="post" action="beanProc.jsp">
	<table style='border:1px solid black'>
		<tr>
			<td>아이디</td>
			<td><input type=text name="id" size=10></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type=text name="name" size=10></td>
		</tr>
		<tr>
			<td>학과</td>
			<td><input type=text name="depart" size=25></td>
		</tr>
		<tr>
			<td>등급</td>
			<td><input type=text name="grade" size=5></td>
		</tr>
		<tr>
			<td>점수</td>
			<td><input type=text name="score" size=5></td>
		</tr>						
	</table>
	<table style='width:500'>
		<tr>
			<td>
				<input type=submit value="SAVE">
				<input type=reset value="CANCEL">
			</td>
		</tr>
	</table>
	</form>
	
</body>
</html>