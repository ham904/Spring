<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	<form name="myform" method="post" action="paramTo.jsp">
	
		이름 : <input type="text" name="username" size=20><br>
		메일 : <input type="text" name="usermail" size=20><br>
		
		취미(관심분야) : 하나 이상 선택 <br>
		<input type="checkbox" name="hobby" value="게임">게임 &nbsp;
		<input type="checkbox" name="hobby" value="여행">여행 &nbsp;		
		<input type="checkbox" name="hobby" value="영화">영화 <br>	
			
		<input type="submit" value="확인">
				
	</form>	
</body>
</html>