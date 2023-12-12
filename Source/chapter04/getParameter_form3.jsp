<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	가능한 외국어를 모두 선택해 주세요.
	<form name="myform" method="post" action="gParam3">
		<input type=checkbox name="lang" value="영어">영어 <br>
		<input type=checkbox name="lang" value="불어">불어 <br>		
		<input type=checkbox name="lang" value="일본어">일본어 <br>
		<input type=checkbox name="lang" value="중국어">중국어 <br>
		<input type=checkbox name="lang" value="스페인어">스페인어 <br>		
		<input type=submit value="OK">		
	</form>
</body>
</html>