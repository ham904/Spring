<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="style.css">	
</head>
<body>

	<h3 align=center>학생 정보 입력</h3>
	<hr align=center width=320 noshade>
	
	<form name="studentInput" method="post" action="studentController.jsp">
	
		<input type="hidden" name="action" value="insert">
		
		<table class=main>
			
			<tr>
				<td class=title2>아이디</td>
				<td class=content2>
					<input type=text name="id" size=10 required>
				</td>	
			</tr>
	
			<tr>
				<td class=title2>이름</td>
				<td class=content2>
					<input type=text name="name" size=10 required>
				</td>	
			</tr>
	
			<tr>
				<td class=title2>학과</td>
				<td class=content2>
					<input type=text name="depart" size=20>
				</td>	
			</tr>		
			
			<tr>
				<td class=title2>등급</td>
				<td class=content2>
					<input type=text name="grade" size=5 required>
				</td>	
			</tr>		
			
			<tr>
				<td class=title2>점수</td>
				<td class=content2>
					<input type=text name="score" size=5 required>
				</td>	
			</tr>		
		</table>
		<hr align=center width=320 size=1 noshade>
	
		<table align=center>
			<tr>
				<td align=left width=200>
					<input type="submit" value="SAVE"> &nbsp;
					<input type="reset" value="CANCEL">
				</td>
				<td align=right width=100>
					<input type="button" value="LIST" onClick="location.replace('studentController.jsp?action=list')">			
				</td>			
			</tr>	
		</table>
	
	</form>
	
</body>
</html>