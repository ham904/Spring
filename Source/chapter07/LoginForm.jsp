<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>

	<form name="userlogin" method="post" action="login">
	<table style='border:1px solid black'>
		<tr>
			<td>아 이 디</td>
			<td><input type=text name=userId size=20></td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><input type=password name=userPw size=20></td>
		</tr>
	</table>
	<table style='width:500'>
		<tr>
			<td>
				<input type=submit value="LOGIN">
				<input type=reset value="CANCEL">
			</td>
		</tr>
	</table>
	</form>
	 
</body>
</html>