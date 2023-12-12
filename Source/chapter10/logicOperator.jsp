<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	
	\${(20>10) && (20>30)} : ${(20>10) && (20>30)}<br>
	\${(20>10) and (20>30)} : ${(20>10) and (20>30)}<br>
	
	\${(20>10) || (20>30)} : ${(20>10) || (20>30)}<br>
	\${(20>10) or (20>30)} : ${(20>10) or (20>30)}<br>
		
	\${!(20>10)} : ${!(20>10)}<br>
	\${not(20>10)} : ${not(20>10)}<br>

</body>
</html>

