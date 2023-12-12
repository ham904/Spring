<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>

	<b>box 커스텀 태그 실행</b>
	<br>
	<my:box> 안녕하세요. </my:box>
	<my:box> ${10>20} </my:box>
	<br>
	
</body>
</html>