<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>

	<% String depart="소프트웨어"; %>

	<form name="myform" method="post" action="paramFormProc1.jsp?depart=<%=depart%>"%>
		학번(정수) : <input type="text" name="num" size=10><br>
		이름(문자) : <input type="text" name="user" size=20><br>
		평점(실수) : <input type="text" name="score" size=5><br>
		<input type="submit" value="저장">
	</form>

</body>
</html>
