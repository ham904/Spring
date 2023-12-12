<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/myTag.tld" prefix="my" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	
	<b> line 커스텀 태그 실행 </b> <br>
	<my:line/>
	
	<b> upper 커스텀 태그 실행 </b> <br>
	<my:upper> custom tag </my:upper>
	
	<b> upperCount 커스텀 태그 실행 </b> <br>
	<my:upperCount color="red" count="10">korea</my:upperCount>	
	
</body>
</html>